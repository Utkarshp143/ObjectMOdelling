package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.PlayList;

public interface IPlaylistService 
{
    public PlayList createPlaylist(String userId, String playlistName, List<String> songId);
    public void deletePlaylist(String userId, String playlistId);
    public PlayList addSongs(String userId, String playlistId, List<String> songId);
    public PlayList deleteSongs(String userId, String playlistId, List<String> songId);
    public long count();
}
