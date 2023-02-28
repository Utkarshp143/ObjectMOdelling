package com.crio.jukebox.repositories;


import com.crio.codingame.entities.User;
import com.crio.jukebox.entities.PlayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaylistRepository implements IPlaylistRepository
{
        private final HashMap<String, PlayList> playlistMap;
        private Integer autoIncrement = 0;
        private String playingPlaylistId = "";

        public PlaylistRepository()
        {
            this.playlistMap = new HashMap<>();
        }
        public PlaylistRepository(HashMap<String,PlayList> map)
        {
            this.playlistMap = map;
            this.autoIncrement = playlistMap.size();
        }

        @Override
        public PlayList save(PlayList entity) 
        {
            if( entity.getId() == null ){
                autoIncrement++;
                PlayList p = new PlayList(Integer.toString(autoIncrement),entity.getUserId(),entity.getPlaylistName(),entity.getSongs());
                playlistMap.put(p.getUserId(),p);
                return p;
            }
            playlistMap.put(entity.getUserId(),entity);
            return entity;
        }


        @Override
        public String getPlayingPlaylistId()
        {
            return this.playingPlaylistId;
        }

        @Override
        public void setPlayingPlaylistId(String id)
        {
            this.playingPlaylistId = id;
        }


    @Override
    public List<PlayList> findAll() {
        List<PlayList> currentPlayList = new ArrayList<>(playlistMap.values());
        return currentPlayList;
    }

    @Override
    public Optional<PlayList> findById(String id) {
        return Optional.ofNullable(playlistMap.get(id));
    }

    @Override
    public boolean existsById(String id) 
    {
        return playlistMap.containsKey(id) ? true:false;    
    }

    @Override
    public void delete(PlayList entity)
    {
        playlistMap.remove(entity.getUserId());
    }    
    

    @Override
    public void deleteById(String id) 
    {
        playlistMap.remove(id);
    }

    @Override
    public long count() 
    {
        return 0;
    }

   
}
