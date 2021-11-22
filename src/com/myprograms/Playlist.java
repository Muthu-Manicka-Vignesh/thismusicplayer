package com.myprograms;

import java.util.LinkedList;
import java.util.ListIterator;

import static com.myprograms.SongList.findSong;

public class Playlist  {
    private static String nameOfPlaylist;
    private static LinkedList<Song> playlist = new LinkedList<>();

    public Playlist() {
    }

    public Playlist(String nameOfPlaylist, LinkedList<Song> playlist) {
        this.nameOfPlaylist = nameOfPlaylist;
        this.playlist = playlist;
    }

    public static String getName() {
        return nameOfPlaylist;
    }

    public static LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public static void setPlaylist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }

    public static void setNameOfPlaylist(String nameOfPlaylist) {
        this.nameOfPlaylist = nameOfPlaylist;
    }

    public static  void addToPlaylist(String title ) {

        if (findSong(title) == null) {
            System.out.println("Song not found");
        }else {
            ListIterator<Song> playListIterator = playlist.listIterator();
            while (playListIterator.hasNext()) {
                if (playListIterator.next().getTitle().compareTo(findSong(title).getTitle()) == 0) {
                    System.out.println("Song already exists in playlist");
                }

            }
        }
        playlist.add(findSong(title));

    }
    public static void removeFromPlaylist(String songName){

        ListIterator<Song> playListIterator = Playlist.playlist.listIterator();
        while (playListIterator.hasNext()) {
            if (playListIterator.next().getTitle().compareTo(findSong(songName).getTitle()) == 0) {
                Playlist.playlist.remove(findSong(songName));
            }
        }
    }
}
