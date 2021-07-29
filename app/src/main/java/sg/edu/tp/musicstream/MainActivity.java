package sg.edu.tp.musicstream;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button logout;


    SongCollection songCollection = new SongCollection();
    static ArrayList<Song> playlist = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.button);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }


    public void sendDataToActivity(int index){
        Intent intent = new Intent(this, PlaySongActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    public void handleSelection(View myView) {
        String resourceId = getResources().getResourceEntryName(myView.getId());
        Log.d("temasek", "The ID for the selected song is :" + resourceId);
        int currentArrayIndex = songCollection.searchSongById(resourceId);
        Log.d("temasek", "The index in the array for this song is :" + currentArrayIndex);
        sendDataToActivity(currentArrayIndex);
    }


    public void addToPlaylist(View view) {
        String songID = view.getContentDescription().toString();
        Song song = songCollection.searchById(songID);
        playlist.add(song);
        //Toast.makeText(this, "Song added", Toast.LENGTH_SHORT).show();
    }

    public void playlistPage(View view) {
        Intent intent = new Intent(this, PlaylistActivity.class);
        startActivity(intent);

    }
}