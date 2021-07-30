package sg.edu.tp.musicstream;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    public void removeAll(View view) {
        MainActivity.playlist.clear();
        songAdapter.notifyDataSetChanged();
        Toast.makeText(this, "All Songs has been removed", Toast.LENGTH_SHORT).show();
    }

    public void profilePage(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    public void homePage(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
