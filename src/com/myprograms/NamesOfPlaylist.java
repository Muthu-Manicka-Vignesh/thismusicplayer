package com.myprograms;

import java.util.ArrayList;
import java.util.List;

public class NamesOfPlaylist  {
    static List<Playlist> playlists = new ArrayList<>();


    public static Playlist findPlaylist(String title){
        for(int i = 0; i< playlists.size(); i++){
            Playlist playlist = playlists.get(i);
            if(playlist.getName().equals(title)){
                return playlist;
            }
            return null;
        }
        return null;
    }
    public static void displaySongsInAPlaylist(String name){
        for(int i=0;i<findPlaylist(name).getSongList().size();i++){
            System.out.println(findPlaylist(name).getSongList().get(i));
        }
    }


    public static void printNamesOfPlaylists(){
        for(int i = 0; i< playlists.size(); i++){
            System.out.println(playlists.get(i).getName());
        }
    }


    public static void deleteSongFromAllPlaylist(String songName){
    for(int i = 0; i<NamesOfPlaylist.playlists.size(); i++){
        for (int j = 0; j<NamesOfPlaylist.playlists.get(i).getSongList().size(); j++){
            if(NamesOfPlaylist.playlists.get(i).getSongList().get(j).equals(songName)){
                NamesOfPlaylist.playlists.get(i).getSongList().remove(j);
                }
            }
        }
    }

    public static void createPlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setNameOfPlaylist(name);
        playlists.add(playlist);
    }
}
