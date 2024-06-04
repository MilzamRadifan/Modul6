package com.example.modul6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>
  {
    private Context context;
    private List<SongModel> songModel;
    private static ClickListener clickListener;
    public SongAdapter(Context context, ArrayList<SongModel> songModel){
      this.context = context;
      this.songModel = songModel;
    }

    public void
    setOnItemClickListener(SongAdapter.ClickListener clickListener) {
      SongAdapter.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View vh  = LayoutInflater.from(this.context).inflate(R.layout.item_song, parent, false);
      return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
      SongModel song = this.songModel.get(position);
      ViewHolder vh = (ViewHolder) holder;

      vh.tvTitle.setText(song.getTitle());
      vh.tvArtist.setText(song.getArtist());
      vh.tvAlbum.setText(song.getAlbum());
      vh.tvDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int adapterPosition = holder.getAdapterPosition();
          songModel.remove(adapterPosition);
          notifyDataSetChanged();
        }
      });
    }
    @Override
    public int getItemCount() {
      return songModel.size();
    }

    public interface ClickListener {
      void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
      TextView tvTitle, tvArtist, tvAlbum, tvDelete;
      public ViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvArtist = itemView.findViewById(R.id.tvArtist);
        tvAlbum = itemView.findViewById(R.id.tvAlbum);
        tvDelete = itemView.findViewById(R.id.tvDelete);
      }
    }
  }