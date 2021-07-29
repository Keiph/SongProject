package sg.edu.tp.musicstream;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlaylistActivity extends AppCompatActivity {
    RecyclerView playlist;
    SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        playlist = findViewById(R.id.recycleView);
        songAdapter = new SongAdapter(MainActivity.playlist);
        playlist.setAdapter(songAdapter);
        playlist.setLayoutManager(new LinearLayoutManager( this));


    }

}
