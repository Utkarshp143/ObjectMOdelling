package com.crio.jukebox.entities;

import java.util.List;

public class PlayList extends BaseEntity
{
    private final String playlistName;
    private final String userId;
    private List<Song> songs;   
    
    public PlayList(String userId,String playlistName,List<Song> songs)
    {
        this.playlistName = playlistName;
        this.userId = userId;
        this.songs = songs;
    }

    public PlayList(String id,String userId,String playlistName,List<Song> songs)
    {
        this(userId, playlistName, songs);
        this.id = id;
        
    }
    public String getPlaylistName()
    {
        return this.playlistName;
    }
    public String getUserId()
    {
        return this.userId;
    }
    public List<Song> getSongs()
    {
        return this.songs;
    }
    public PlayList setSongs(List<Song> song)
    {
        this.songs = song;
        return this;
    }
}
