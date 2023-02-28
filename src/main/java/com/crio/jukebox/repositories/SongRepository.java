package com.crio.jukebox.repositories;


import com.crio.jukebox.entities.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class SongRepository implements ISongRepository
{
    private final HashMap<String, Song> songMap;
        private Integer autoIncrement = 0;
        private String playingSongId = "";

        public SongRepository()
        {
            this.songMap = new HashMap<>();
        }
        public SongRepository(HashMap<String, Song> map)
        {
            this.songMap = map;
            this.autoIncrement = songMap.size();
        }

        @Override
    public Song save(Song entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Song s = new Song(Integer.toString(autoIncrement),entity.getSongName(),entity.getGenre(),entity.getAlbumName(),entity.getAlbumArtist(),entity.getFeaturedArtist());
            songMap.put(s.getId(),s);
            return s;
        }
        songMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Song> findAll() {
    //  return Collections.emptyList();
        List<Song> result = new ArrayList<>(songMap.values());
        return result;
    }

    @Override
    public Optional<Song> findById(String id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Question entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

        @Override
        public String getPlayingSongId()
        {
            this.playingSongId;
        }

        @Override
        public void setPlayingSongId(String id)
        {
            this.playingSongId = id;
        }

        @Override
        public void loadSongs(String filename) throws IOException
        {
           Path path = Paths.get(filename);
           Charset sc = StandardCharsets.UTF_8;
           
           List<String> list = Files.readAllLines(path,sc);

           for(String line : list)
           {
            String[] arr = line.split(",");
            List<String> featuredArtist = Arrays.asList(arr[arr.length -1].split("#"));

            Song song = new Song(arr[1],arr[2],arr[3],arr[4],featuredArtist);
            
            save(song);
           }
        }
}   
