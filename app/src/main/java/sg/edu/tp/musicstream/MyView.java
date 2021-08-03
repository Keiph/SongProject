package sg.edu.tp.musicstream;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyView extends RecyclerView.ViewHolder {

    public TextView titleTxt,titleArtist;
    public ImageView image;
    public Button removeBtn,playPlaylist;


    public MyView(@NonNull View itemView) {
        super(itemView);

        titleTxt = itemView.findViewById(R.id.titleTxt);
        titleArtist = itemView.findViewById(R.id.titleArtist);
        image = itemView.findViewById(R.id.image);
        removeBtn =itemView.findViewById(R.id.removeBtn);
    }
}
