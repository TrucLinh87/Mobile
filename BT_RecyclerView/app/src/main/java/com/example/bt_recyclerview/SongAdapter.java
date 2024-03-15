package com.example.bt_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private static final String TAG = "SongAdapter";
    private List<SongModel> mSongs;
    private Context mContext;
    private LayoutInflater mLayoutInflater;


    public SongAdapter(List<SongModel> mSongs, Context mContext) {
        this.mSongs = mSongs;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);

        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
            SongModel songModel = mSongs.get(position);
            holder.tvCode.setText(songModel.getmCode());
            holder.tvArtist.setText(songModel.getmArtist());
            holder.tvLyric.setText(songModel.getmLyric());
            holder.tvTitle.setText(songModel.getmTitle());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
    class SongViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCode, tvTitle, tvLyric, tvArtist;
        public SongViewHolder(@NonNull View itemView) {

            super(itemView);

            tvCode = (TextView) itemView.findViewById(R.id.tv_code);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SongModel song = mSongs.get(getAdapterPosition());
                    Toast.makeText(mContext, song.getmTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}