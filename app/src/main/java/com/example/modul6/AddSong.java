package com.example.modul6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddSong extends AppCompatActivity {

  private SongModel songModel;
  EditText etTitle, etArtist, etAlbum;
  Button btSave;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_song);

    etTitle = findViewById(R.id.etTitle);
    etArtist = findViewById(R.id.etArtist);
    etAlbum = findViewById(R.id.etAlbum);
    btSave = findViewById(R.id.btSave);

    btSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String title = etTitle.getText().toString();
        String artist = etArtist.getText().toString();
        String album = etAlbum.getText().toString();

        songModel = new SongModel(title, artist, album);

        MusicActivity.getSongModel().add(songModel);
        MusicActivity.getSongAdapter().notifyDataSetChanged();

        Intent intent = new Intent(AddSong.this, MusicActivity.class);
        startActivity(intent);
      }
    });

  }
}