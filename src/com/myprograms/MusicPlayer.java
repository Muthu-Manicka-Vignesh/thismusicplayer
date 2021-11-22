package com.myprograms;

import java.util.Scanner;

public class MusicPlayer {
    static Scanner sc = new Scanner(System.in);
    static SongList songList = new SongList();
    NamesOfPlaylist namesOfPlaylist = new NamesOfPlaylist();

    public static void menu() {
        if (SongList.songs.size() == 0) {
            System.out.println("Available actions :");
            System.out.println("0 - Songs");
            System.out.println("1 - Playlists");
            System.out.println("2 - Quit Music Player");
            System.out.println("Enter your choice");
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 0:
                    Songs();
                case 1:
                    playlists();
                case 2:
                    System.out.println("Quiting Music Player");
                    break;
                default:
                    System.out.println("Invalid choice");
                    menu();

            }
        }
        System.out.println("Available actions :");
        System.out.println("0 - Songs");
        System.out.println("1 - Albums");
        System.out.println("2 - Artists");
        System.out.println("3 - Playlists");
        System.out.println("4 - Quit Music Player");
        System.out.println("Enter your choice");
        int x = sc.nextInt();
        sc.nextLine();
        switch (x) {
            case 0:
                Songs();
            case 1:
                albums();
            case 2:
                artists();
            case 3:
                playlists();
            case 4:
                System.out.println("Quiting Music Player");
                break;
            default:
                System.out.println("Invalid choice");
                menu();
        }
    }

    public static void Songs() {
        System.out.println(SongList.songs.size() + " Songs");
        if (SongList.songs.size() == 0) {
            System.out.println("No songs currently, please add a song.");
            System.out.println("0 - Return to main menu");
            System.out.println("1 - Add new Song");
            System.out.println("Enter your choice");
            int y = sc.nextInt();
            switch (y) {
                case 0:
                    menu();
                case 1:
                    addSong();
                default:
                    System.out.println("Invalid choice");
                    Songs();
            }
        } else {
            songList.printSongList();
            System.out.println("0 - Return to main menu");
            System.out.println("1 - Add new Song");
            System.out.println("2 - Select song");
            System.out.println("Enter your choice");
            int y = sc.nextInt();
            switch (y) {
                case 0:
                    menu();
                case 1:
                    addSong();
                case 2:
                    sc.nextLine();
                    System.out.println("Enter Song Name");
                    String songName = sc.nextLine();
                    editSongList(songName);
                default:
                    System.out.println("Invalid choice");
                    Songs();
            }
        }
    }

    private static void addSong() {
        sc.nextLine();
        System.out.println("Enter song name");
        String x = sc.nextLine();
        System.out.println("Enter duration ");
        double d = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter album name");
        String a = sc.nextLine();
        System.out.println("Enter artist name");
        String ar = sc.nextLine();
        if (songList.findSong(x) == null) {
            songList.addSong(x, ar, a, d);
            System.out.println("Song added");
            Songs();
        } else {
            System.out.println("Song already exits");
            Songs();
        }
    }

    public static void editSongList(String name) {
        if (SongList.findSong(name) == null) {
            System.out.println("Song not found");
            Songs();
        } else {
            System.out.println(SongList.findSong(name).getTitle() + " chosen");
            System.out.println("0 - Play song");
            System.out.println("1 - Delete song");
            System.out.println("Enter your choice");
            int x = sc.nextInt();
            switch (x) {
                case 0:
                    playSong(name);
                    Songs();
                case 1:
                    deleteSong(name);
                    NamesOfPlaylist.deleteSongFromAllPlaylist(name);
                    Songs();
                default:
                    System.out.println("Invalid choice");
                    editSongList(name);
            }
        }
    }

    public static void playSong(String name) {
        System.out.println("Playing " + SongList.findSong(name).getTitle() + "...");
    }

    public static void deleteSong(String name) {
        if (checkIfSongIsPresentInAPlaylist(name) == true) {
            checkIfSongIsPresentInAPlaylist(name);
            System.out.println("Deleting " + name + " will remove " + name + " from the above playlist(s) as well");
            System.out.println("Are you sure you want to delete the song");
            System.out.println("0 - Yes");
            System.out.println("1 - No");
            System.out.println("Enter your choice");
            int x = sc.nextInt();
            switch (x) {
                case 0:
                    songList.removeSong(name);
                    NamesOfPlaylist.deleteSongFromAllPlaylist(name);
                    Songs();
                case 1:
                    Songs();
                default:
                    System.out.println("Invalid input");
                    deleteSong(name);

            }
        } else {
            songList.removeSong(name);
            System.out.println(name + "was removed");
            Songs();
        }
    }

    public static boolean checkIfSongIsPresentInAPlaylist(String songName) {
        for (int i = 0; i < NamesOfPlaylist.playlists.size(); i++) {
            for (int j = 0; j < NamesOfPlaylist.playlists.get(i).getSongList().size(); j++) {
                if (NamesOfPlaylist.playlists.get(i).getSongList().get(j).equals(songName)) {
                    System.out.println(songName + "was found in " + NamesOfPlaylist.playlists.get(i).getSongList().size() + "Playlist(s)");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void albums() {
        System.out.println("Albums");
        songList.printAlbumList();
        System.out.println("0 - Return to main menu");
        System.out.println("1 - See albums' songs");
        System.out.println("Enter your choice");
        int x = sc.nextInt();

        switch (x) {
            case 1:
                sc.nextLine();
                System.out.println("Type album name");
                String name = sc.nextLine();
                System.out.println(name + "'s songs");
                songList.printAlbumSongs(name);
                System.out.println("0 - Return to Main Menu");
                System.out.println("1 - Select song to play");
                System.out.println("1 - Return to Albums");
                System.out.println("Enter your choice");
                int y = sc.nextInt();
                switch (y) {
                    case 0:
                        menu();
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter song name");
                        String songName = sc.nextLine();
                        playSong(songName);
                        albums();
                    case 2:
                        albums();
                    default:
                        System.out.println("Invalid choice");
                        albums();
                }
            case 0:
                menu();
            default:
                System.out.println("Invalid choice");
                albums();
        }
    }

    public static void seeAlbum(String name) {
        System.out.println(name + "'s songs");
        songList.printAlbumSongs(name);
        System.out.println("0 - Return to Main Menu");
        System.out.println("1 - Select song to play");
        System.out.println("2 - Return to Albums");
        System.out.println("Enter your choice");
        int y = sc.nextInt();
        switch (y) {
            case 0:
                menu();
            case 1:
                sc.nextLine();
                System.out.println("Enter song name");
                String songName = sc.nextLine();
                playSong(songName);
                seeAlbum(name);

            case 2:
                albums();
            default:
                System.out.println("Invalid choice");
                seeAlbum(name);
        }
    }


    public static void artists() {
        System.out.println("Artists");

        songList.printArtistList();
        System.out.println("0 - Return to main menu");
        System.out.println("1 - See artist's songs");
        System.out.println("Enter your choice");
        int x = sc.nextInt();

        switch (x) {
            case 1:
                sc.nextLine();
                System.out.println("Type artist name");
                String name = sc.nextLine();
                seeArtist(name);
            case 0:
                menu();
            default:
                System.out.println("Invalid choice");
                artists();
        }
    }

    public static void seeArtist(String name) {

        System.out.println(name + "'s songs");
        songList.printArtistSongs(name);
        System.out.println("0 - Return to Main Menu");
        System.out.println("1 - Select song to play");
        System.out.println("2 - Artists");
        System.out.println("Enter your choice");
        int y = sc.nextInt();
        switch (y) {
            case 0:
                menu();
            case 1:
                sc.nextLine();
                System.out.println("Enter song name");
                String songName = sc.nextLine();
                playSong(songName);
                seeArtist(name);

            case 2:
                artists();
            default:
                System.out.println("Invalid choice");
                seeArtist(name);
        }
    }


    public static void playlists() {
        System.out.println("Playlists");
        if (NamesOfPlaylist.playlists.size() == 0) {
            System.out.println("No Playlists currently");
            System.out.println("0 - Return to main menu");
            System.out.println("1 - create playlist");
            System.out.println("Enter your choice");
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 0:
                    menu();
                case 1:
                    System.out.println("Enter Playlist name");
                    String title = sc.nextLine();
                    NamesOfPlaylist.createPlaylist(title);
                    seePlaylists(title);
                default:
                    System.out.println("Invalid Input");
                    playlists();

            }
        } else {
            NamesOfPlaylist.printNamesOfPlaylists();
            System.out.println("0 - Return to main menu");
            System.out.println("1 - Select a playlist");
            System.out.println("2 - create playlist");
            System.out.println("Enter your choice");
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 0:
                    menu();
                case 1:
                    System.out.println("Enter Playlist name");
                    String playlistName = sc.nextLine();
                    if(NamesOfPlaylist.findPlaylist(playlistName)!=null) {
                        selectPlaylist(playlistName);
                    }else{
                        System.out.println("Playlist not found");
                        playlists();
                    }
                case 2:
                    System.out.println("Enter Playlist name");
                    String title = sc.nextLine();
                    NamesOfPlaylist.createPlaylist(title);
                    seePlaylists(title);
                default:
                    System.out.println("Invalid Input");
                    playlists();

            }
        }
    }

    public static void selectPlaylist(String name) {
        System.out.println("0 - View Playlist");
        System.out.println("1 - Play Playlist");
        System.out.println("2 - Delete Playlist");
        System.out.println("3 - Return to Playlists");
        System.out.println("Enter your choice");
        int x = sc.nextInt();
        switch (x) {
            case 0:
                seePlaylists(name);
            case 1:
                playPlaylist(name);
                playlists();
            case 2:
                deletingPlaylist(name);
                playlists();
            case 3:
                playlists();
            default:
                System.out.println("Invalid choice");
                selectPlaylist(name);
        }
    }


    public static void seePlaylists(String playlistName) {
        if (NamesOfPlaylist.findPlaylist(playlistName).getSongList().size() == 0) {
            System.out.println("0 - Return to main menu");
            System.out.println("1 - Return to Playlists");
            System.out.println("2 - Add song to this playlist");
            System.out.println("Enter your choice");
            int y = sc.nextInt();
            switch (y) {
                case 0:
                    menu();
                case 1:
                    playlists();
                case 2:
                    System.out.println("Enter Song name");
                    sc.nextLine();
                    String title = sc.nextLine();
                    NamesOfPlaylist.findPlaylist(playlistName).getSongList().add(SongList.findSong(title));
                    System.out.println("Song added to " + playlistName);
                    seePlaylists(playlistName);
                default:
                    System.out.println("Invalid choice");
                    seePlaylists(playlistName);
            }
        } else {
            NamesOfPlaylist.displaySongsInAPlaylist(playlistName);
            System.out.println("0 - Return to main menu");
            System.out.println("1 - Return to Playlists");
            System.out.println("2 - Add song to this playlist");
            System.out.println("3 - Remove song from playlist");
            System.out.println("Enter your choice");
            int y = sc.nextInt();
            switch (y) {
                case 0:
                    menu();
                case 1:
                    playlists();
                case 2:
                    System.out.println("Enter Song name");
                    sc.nextLine();
                    String title = sc.nextLine();
                    NamesOfPlaylist.findPlaylist(playlistName).getSongList().add(SongList.findSong(title));
                    System.out.println("Song added to " + playlistName);
                    seePlaylists(playlistName);
                case 3:
                    System.out.println("Enter Song name");
                    sc.nextLine();
                    String songName = sc.nextLine();
                    removingSongFromPlaylist(songName);
                    seePlaylists(playlistName);
                default:
                    System.out.println("Invalid choice");
                    seePlaylists(playlistName);
            }
        }
    }

    public static void playPlaylist(String name) {
        System.out.println("Playing '" + name + "'playlist");
    }


    public static void deletingPlaylist(String name) {
        if (NamesOfPlaylist.findPlaylist(name) != null) {
            NamesOfPlaylist.playlists.remove(NamesOfPlaylist.findPlaylist(name));
            System.out.println("Playlist '" + name + "' was removed");
            playlists();
        }

    }

    public static void removingSongFromPlaylist(String songName) {
        PlaylistUtil.removeFromPlaylist(songName);
        System.out.println(songName + " removed from playlist ");
    }
}

