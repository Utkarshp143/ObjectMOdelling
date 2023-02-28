package com.crio.jukebox.services;

import com.crio.jukebox.entities.PlayList;
import java.util.list;

public interface IPlaylistService 
{
    public PlayList createPlaylist(String userId, String playlistName, List<String> songId);
    public void deletePlaylist(String userId, String playlistId);
    public PlayList addSongs(String userId, String playlistId, List<String> songId);
    public PlayList deleteSongs(String userId, String playlistId, List<String> songId);
    public long count();
}
