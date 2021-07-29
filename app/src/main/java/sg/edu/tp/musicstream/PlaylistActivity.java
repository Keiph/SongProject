package sg.edu.tp.musicstream;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        for (int i = 0; i <MainActivity.playlist.size() ; i++) {
            Log.d("temasek",MainActivity.playlist.get(i).getTitle());

        }
    }

}
