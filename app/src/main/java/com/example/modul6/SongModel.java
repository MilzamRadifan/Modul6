package com.example.modul6;

public class SongModel {
  private String title, artist, album;

  public SongModel(String title, String artist, String album) {
    this.title = title;
    this.artist = artist;
    this.album = album;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getAlbum() {
    return album;
  }
}