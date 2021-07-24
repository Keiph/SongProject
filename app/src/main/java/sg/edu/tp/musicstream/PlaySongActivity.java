package sg.edu.tp.musicstream;

import android.media.AudioManager;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PlaySongActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private AudioManager audioManager;
    private Button btnPlayPause = null;
    SeekBar seekBar;
    SeekBar volumeSeekBar;
    Handler handler = new Handler();
    Button repeatBtn;
    boolean repeatFlag = false; //not a loop when enter in app
    Button shuffleBtn;
    boolean shuffleFlag = false;
    SongCollection songCollection = new SongCollection();
    SongCollection originalSongCollection = new SongCollection();

    List<Song> shuffleList = Arrays.asList(songCollection.songs);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE); //get system audio service cast to AudioManager
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); //all device when starting app set music all to max volume when streaming music
        int currentVolume =audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);// Check Media/phone int in volume


        setContentView(R.layout.activity_play_song);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek","Retrieved Position is "+currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
        seekBar = findViewById(R.id.seekBar);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);// set the max volume from what we declared in line 37
        volumeSeekBar.setProgress(currentVolume);// set the current volume  from what we found in line 38
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
                //whenever i drag the seek bar listen to this line of code
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //whenever i touch the seek bar listen to this line of code
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //whenever i let go of the seek bar listen to this line of code
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //I can pause the music here but not good for user experience
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player !=null && player.isPlaying()) {
                    player.seekTo(seekBar.getProgress());
                }

            }
        });
        repeatBtn = findViewById(R.id.repeatBtn);
        shuffleBtn = findViewById(R.id.shuffleBtn);

    }

    Runnable p_bar = new Runnable() {
        @Override
        public void run() {
            if (player !=null && player.isPlaying()) {
                seekBar.setProgress(player.getCurrentPosition());
            }
            handler.postDelayed(this, 1000);
        }
    };

    public void displaySongBasedOnIndex(int selectedIndex) {
        Song song = songCollection.getCurrentSong(currentIndex);
        title = song.getTitle();
        artiste = song.getArtiste();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtiste = findViewById(R.id.txtArtist);
        txtArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);
    }

    public void playSong(String songUrl) {
        try {
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopsWhenMusicEnds();
            btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
            //btnPlayPause.setText("PAUSE");
            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view) {
        if (player != null && player.isPlaying()) { //if player is playing
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(p_bar); // This line remove all existing calling of the runnable so that only 1 runnable is called per second
            handler.postDelayed(p_bar, 1000);
            player.pause();
            btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
            setTitle("Now Playing: " + title + " - " + artiste);
            //if song is playing, user press pause, music pause and change to play arrow xml
        } else {
            player.start();
            btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
            //btnPlayPause.setText("PAUSE");
        }
    }

    private void gracefullyStopsWhenMusicEnds() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (repeatFlag){//loop on
                    playOrPauseMusic(null);// call playOrPauseMusic method again
                }else {
                    Toast.makeText(getBaseContext(), "Song ended", Toast.LENGTH_LONG).show();
                    btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                    //btnPlayPause.setText("PLAY");
                }
            }
        });
    }

    public void playNext(View view) {
        currentIndex = songCollection.getNextSong(currentIndex);
        Toast.makeText(this, "After clicking playNext,\nthe current index of this song\nin the SongCollection array is now :" + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playNext, the index is now :" + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void playPrevious(View view) {
        currentIndex = songCollection.getPrevSong(currentIndex);
        Toast.makeText(this, "After clicking playPrevious,\nthe current index of this song\nin the SongCollection array is now :" + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playPrevious, the index is now :" + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player != null) {
            handler.removeCallbacks(p_bar);//More robust, solve crashing when prev and song is still playing
            player.stop();
            player.release();
            player = null;
        }
    }

    public void repeatSong(View view) {
        if (repeatFlag){
            repeatBtn.setBackgroundResource(R.drawable.ic_baseline_repeat_off_24);
        }else{
            repeatBtn.setBackgroundResource(R.drawable.ic_baseline_repeat_24);
        }
        repeatFlag =!repeatFlag; //if initial repeatFlag is true then false, if false then true
    }
    public void shuffleSong(View view) {
        if (shuffleFlag){
            shuffleBtn.setBackgroundResource(R.drawable.ic_baseline_shuffle_off_24);
            songCollection = new SongCollection();
        }else{
            shuffleBtn.setBackgroundResource(R.drawable.ic_baseline_shuffle_on_24);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
        }
        shuffleFlag =!shuffleFlag; //if initial repeatFlag is true then false, if false then true
    }
}
