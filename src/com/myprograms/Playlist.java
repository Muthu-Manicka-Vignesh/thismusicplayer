package com.myprograms;

import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private  String nameOfPlaylist;
    private  List<Song> songList = new LinkedList<>();

    public Playlist() {
    }

    public Playlist(String nameOfPlaylist, LinkedList<Song> songList) {
        this.nameOfPlaylist = nameOfPlaylist;
        this.songList.addAll(songList);
    }

    public  String getName() {
        return nameOfPlaylist;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public  void setSongList(LinkedList<Song> songList) {
        this.songList = songList;
    }

    public  void setNameOfPlaylist(String nameOfPlaylist) {
        this.nameOfPlaylist = nameOfPlaylist;
    }
}
