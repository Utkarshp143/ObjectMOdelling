package com.crio.jukebox.repositories;

import java.io.IOException;
import com.crio.jukebox.entities.Song;

public interface ISongRepository extends CRUDRepository<Song, String>
{
    public void loadSongs(String filename) throws IOException;
    public String getPlayingSongId();
    public void setPlayingSongId(String playingSongId);
}
