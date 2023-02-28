package com.crio.jukebox.commands;

import java.util.List;
import java.io.IOException;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IPlaylistRepository;


public class PlaySongCommand implements ICommand
{
    private final ISongRepository songRepository;
    private final IPlaylistRepository playlistRepository;

    public PlaySongCommand(ISongRepository songRepository, IPlaylistRepository playlistRepository)
    {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        String commandName = tokens.get(0);
        
        if(commandName.equals("PLAY-SONG"))
        {
            String userId = tokens.get(1);
            
            PlayList playlist = playlistRepository.findById(userId).get();
            List<Song> songList = playlist.getSongs();

            if(songList.size() != 0)
            {
                Song song = songList.get(0);
                String songId = song.getId();

                // PlaylistRepository.setPlayingPlaylistId(playlistId);
                songRepository.setPlayingSongId(songId);


                System.out.println("Current song playing");
                System.out.println("SongName: "+song.getSongName());
                System.out.println("AlbumName: "+song.getAlbumName());
                System.out.println("ArtistName: "+song.getAlbumArtistToString());


            }
            else
            {
                System.out.println("Something went wrong with Song!");
            }
        }
    }

}
