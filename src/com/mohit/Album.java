package com.mohit;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name=name;
        this.artist=artist;
        this.songs= new ArrayList<Song>();
    }

    public Album(){

    }

    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return  null;
    }

    public boolean addSong(String title,double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
            System.out.println(title  + "successfully added to the list");
            return true;
        }
        else{
            System.out.println("Song with name" + title + "already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index=trackNumber-1;
        if(index >0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        else{
            System.out.println("This album does not have song with track number "+ trackNumber);
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> Playlist){
        for(Song checkSong : this.songs){
            if(checkSong.getTitle().equals(title)){
                Playlist.add(checkSong);
                return true;
            }


        }
        System.out.println("There is no such song in album");
        return false;
    }

}
