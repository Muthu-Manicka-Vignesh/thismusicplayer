package com.myprograms;

import java.util.*;

public class SongList {
    static ArrayList<Song> songs= new ArrayList<>();
    ArrayList<String> artistList = new ArrayList<>();
    ArrayList<String> albumList = new ArrayList<>();
    public static Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if (song.getTitle().equals(title)) {
                return song;
            } else {
                System.out.println("No such song");
            }
        }
        return null;
    }
    public boolean addSong(String title, String artist, String album, double duration) {
        Song song = new Song(title,artist,album,duration);
        if (findSong(title)== null) {
            songs.add(song);
            return true;
        } else {
            return false;
        }
    }
    public void removeSong(String title){
        songs.remove(findSong(title));
    }


    public void printSongList(){
        for(int i=0;i<this.songs.size();i++){
            System.out.println(songs.get(i));
        }
    }

    public void printArtistList(){
        for (int i=0;i<songs.size();i++){
            artistList.add(i,this.songs.get(i).getArtist());
        }
        Set<String> s = new LinkedHashSet<>(artistList);
        Iterator<String> i= s.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
    public void printAlbumList(){
        for (int i=0;i<songs.size();i++){
            albumList.add(i,this.songs.get(i).getAlbum());
        }
        Set<String> s = new LinkedHashSet<>(albumList);
        Iterator<String> i= s.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
    public void printAlbumSongs(String name){
        for(int i = 0; i<songs.size();i++){
            if(songs.get(i).getAlbum().equals(name)){
                System.out.println(songs.get(i));
            }
        }
    }
    public void printArtistSongs(String name){
        for(int i = 0; i<songs.size();i++){
            if(songs.get(i).getArtist().equals(name)){
                System.out.println(songs.get(i));
            }
        }
    }
}





