package com.myprograms;

public class Song {
    private String title;
    private String artist;
    private String album;
    private double duration;

    public Song(String title, String artist, String album, double duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
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

    @Override
    public String toString() {
        return  title + ", artist=" + artist + ", album=" + album + ", duration :"+  duration ;
    }
}
