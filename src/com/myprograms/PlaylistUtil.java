package com.myprograms;

import java.util.List;
import java.util.ListIterator;

import static com.myprograms.SongList.findSong;

public class PlaylistUtil {

    static List<Song> songList;


    public static  void addToPlaylist(String title ) {

        if (findSong(title) == null) {
            System.out.println("Song not found");
        }else {
            ListIterator<Song> playListIterator = songList.listIterator();
            while (playListIterator.hasNext()) {
                if (playListIterator.next().getTitle().compareTo(findSong(title).getTitle()) == 0) {
                    System.out.println("Song already exists in playlist");
                }

            }
        }
        songList.add(findSong(title));
    }
    public static void removeFromPlaylist(String songName){

        ListIterator<Song> playListIterator = PlaylistUtil.songList.listIterator();
        while (playListIterator.hasNext()) {
            if (playListIterator.next().getTitle().compareTo(findSong(songName).getTitle()) == 0) {
                PlaylistUtil.songList.remove(findSong(songName));
            }
        }
    }
}
