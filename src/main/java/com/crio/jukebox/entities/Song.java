package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class Song extends BaseEntity
{
    private final String songName;
    private final String genre;
    private final String albumName;
    private final String albumArtist;
    private List<String> featuredArtist;
    
    public Song(String name,String genre,String albumName,String albumArtist,List<String> featuredArtist)
    {
        this.songName = name;
        this.genre = genre;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        featuredArtist = new ArrayList<>();
    }

    public Song(String id,String name,String genre,String albumName,String albumArtist,List<String> featuredArtist)
    {
        this(name, genre, albumName, albumArtist, featuredArtist);
        this.id = id;
        
    }    

    public String getSongName()
    {
        return this.songName;
    }
    public String getGenre()
    {
        return this.genre;
    }
    public String getAlbumName()
    {
        return this.albumName;
    }
    public String getAlbumArtist()
    {
        return this.albumArtist;
    }
    public String getAlbumArtistToString()
    {
        String result = "";
        int i = 0;
        for(String artist : featuredArtist)
        {
            i++;
            result += artist;
            if(i < featuredArtist.size())
            {
                result += ",";
            }
        }
        return result;
    }
    public List<String> getFeaturedArtist()
    {
        return this.featuredArtist;
    }
    public void setFeaturedArtist(List<String> ftArtist)
    {
        this.featuredArtist = ftArtist;
    }
    public String toString() 
    {
        return "Song [id=" + this.getId() + ", songName=" + this.getSongName() + ", genre=" + this.getGenre() + ", albumName=" + this.getAlbumName() + ", albumArtist= " + this.getAlbumArtist() + ", featuredArtist = " + this.getFeaturedArtist() + " ]";
    }
}
