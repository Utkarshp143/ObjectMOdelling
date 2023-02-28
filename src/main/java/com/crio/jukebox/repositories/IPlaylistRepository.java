package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.PlayList;

public interface IPlaylistRepository extends CRUDRepository<PlayList, String>  
{
    public String getPlayingPlaylistId();
    public void setPlayingPlaylistId(String playingPlayListId);
    
}
