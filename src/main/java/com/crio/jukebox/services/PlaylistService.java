package com.crio.jukebox.services;

import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotFoundException;

public class PlaylistService implements IPlaylistService
{
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository,ISongRepository songRepository)
    {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    // doubt in converting songId to song
    public PlayList createPlaylist(String userId, String playlistName, List<String> songId) throws SongNotFoundException
    {
        List<Song> songs = new ArrayList<>();
        PlayList playlist = new PlayList(userId,playlistName,songs);
        playlist = playlistRepository.save(playlist);

        try{
            playlist = this.addSongs(userId,playlist.getId(),songId);
        }
        catch(RuntimeException e)
        {
            playlistRepository.deleteById(playlist.getId());
            throw e;
        }

        return playlist;
    }   

    public void deletePlaylist(String userId, String playlistId) throws PlaylistNotFoundException
    {
        if(!(playlistRepository.existsById(playlistId)))
        {
            throw new PlaylistNotFoundException("Playlist not found!");
        }
        else
        {
            playlistRepository.deleteById(playlistId);
        }
    }

    public PlayList addSongs(String userId, String playlistId, List<String> songId)
    {
        PlayList playlist = playlistRepository.findById(playlistId).get();

        List<Song> listSong = playlist.getSongs();

        HashMap<String,Song> songMap = new HashMap<>();

        for(Song song : listSong)
        {
            songMap.putIfAbsent(song.getId(),song);
        }
        for(String id : songId)
        {
            if(!songRepository.existsById(id))
            {
                throw new SongNotFoundException("Song you're trying to add is not present!");
            }
            else
            {
                Song song = songRepository.findById(id).get();
                if(!songMap.containsKey(id))
                {
                    listSong.add(song);
                }
            }
        }

        playlist = playlist.setSongs(listSong);
        playlist = playlistRepository.save(playlist);

        return playlist;

    }

    public PlayList deleteSongs(String userId, String playlistId, List<String> songId)
    {
        PlayList playlist = playlistRepository.findById(playlistId).get();

        List<Song> listSong = playlist.getSongs();

        HashMap<String,Song> songMap = new HashMap<>();

        for(Song song : listSong)
        {
            songMap.put(song.getId(),song);
        }
        for(String id : songId)
        {
            if(songMap.containsKey(id))
            {
                listSong.remove(songMap.get(id));
            }
            else
            {
                throw new SongNotFoundException("Requested songs for deletion is not present!");
            }
        }

        playlist = playlist.setSongs(listSong);
        playlist = playlistRepository.save(playlist);

        return playlist;
    }

    public long count()
    {
        return playlistRepository.count();
    }
}
