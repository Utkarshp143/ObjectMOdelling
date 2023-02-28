package com.crio.jukebox.entities;

import java.util.*;

public class User  extends BaseEntity
{
    private final String userName;
    private List<PlayList> playlists;
    
    public User(String name)
    {
        userName = name;
        playlists = new ArrayList<>();
    }
    public User(String id,String name)
    {
        this.id = id;
        userName = name;
    }
    
    public String getUserName() 
    {
        return userName;
    }

    public List<PlayList> getPlaylists()
    {
        return playlists;
    }
    public void setPlaylists(List<PlayList> playlists)
    {
        this.playlists = playlists;
    }

    public String toString() 
    {
        return "User [id=" + this.getId() + ", playlists=" + this.getPlaylists() + ", name=" + this.getUserName() + "]";
    }

    // public void deletePlaylist(PlayList playlist)
    // {
    //     playlists.removeIf(p -> p.getId() == playlist.getId())
    // }
}
