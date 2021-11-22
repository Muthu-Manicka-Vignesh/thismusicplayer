package com.myprograms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NamesOfPlaylist  {
    static List<Playlist> playlists = new ArrayList<>();


    public static Playlist findPlaylist(String title){
        for(int i=0;i<playlists.size(); i++){
            Playlist playlist =playlists.get(i);
            if(playlist.getName().equals(title)){
                return playlist;
            }
            return null;
        }
        return null;
    }
    public static void displaySongsInAPlaylist(String name){
        for(int i=0;i<findPlaylist(name).getPlaylist().size();i++){
            System.out.println(findPlaylist(name).getPlaylist().get(i));
        }
    }


    public static void printNamesOfPlaylists(){
        for(int i =0; i< playlists.size();i++){
            System.out.println(playlists.get(i).getName());
        }
    }


    public static void deleteSongFromAllPlaylist(String songName){
    for(int i=0;i<NamesOfPlaylist.playlists.size();i++){
        for (int j=0;j<NamesOfPlaylist.playlists.get(i).getPlaylist().size();j++){
            if(NamesOfPlaylist.playlists.get(i).getPlaylist().get(j).equals(songName)){
                NamesOfPlaylist.playlists.get(i).getPlaylist().remove(j);
                }
            }
        }
    }

    public static void createPlaylist(String name) {

        Playlist playlist1 = new Playlist();
        playlist1.s
        playlists.add(playlist1);
    }
}
