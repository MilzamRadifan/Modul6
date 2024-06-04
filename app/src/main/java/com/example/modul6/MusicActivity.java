package com.example.modul6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  public static ArrayList<SongModel> songModels = new ArrayList<>();
  public static SongAdapter songAdapter;
  Button btTambah, bt;

  public static SongAdapter getSongAdapter() {
    return songAdapter;
  }
  public static ArrayList<SongModel> getSongModel() {
    return songModels;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_music);

    recyclerView = findViewById(R.id.rvSong);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    songAdapter = new SongAdapter(MusicActivity.this, songModels);
    recyclerView.setAdapter(songAdapter);

    btTambah = findViewById(R.id.btTambah);
    btTambah.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MusicActivity.this, AddSong.class);
        startActivity(intent);
      }
    });
  }
}