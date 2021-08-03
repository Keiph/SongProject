package sg.edu.tp.musicstream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import util.AppUtil;

public class SongAdapter extends RecyclerView.Adapter<MyView> implements Filterable {
    public SongAdapter(List<Song> songs) {
        this.songs = songs;
        this.songsFiltered = songs;
    }

    List<Song> songs;
    List<Song> songsFiltered;
    Context context;

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.item_song, parent, false);
        MyView viewHolder = new MyView(songView);
        ;
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {

        Song song = songsFiltered.get(position);
        TextView artist = holder.titleArtist;
        artist.setText(song.getArtiste());
        TextView title = holder.titleTxt;
        title.setText(song.getTitle());
        int imageId = AppUtil.getImageIdFromDrawable(context, song.getCoverArt());
        holder.image.setImageResource(imageId);
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.playlist.remove(position);
                Toast.makeText(context, "Song removed", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return songsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    songsFiltered = songs;
                } else {
                    List<Song> filteredList = new ArrayList<Song>();
                    for (int i = 0; i < songs.size(); i++) {
                        if (songs.get(i).getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(songs.get(i));
                        }
                    }
                    songsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = songsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                songsFiltered = (List<Song>) results.values;
                notifyDataSetChanged();

            }
        };
    }
}
