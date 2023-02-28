package com.crio.jukebox.commands;

import java.util.List;
import java.io.IOException;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.repositories.IPlaylistRepository;


public class DeletePlaylistCommand implements ICommand
{
    private final IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) 
    {
        String commandName = tokens.get(0);
        
        if(commandName.equals("CREATE-PLAYLIST"))
        {
            String userId = tokens.get(1);
            String playlistId = tokens.get(2);
            //List<String> songId = tokens.subList(3,tokens.size());


            try
            {
                playlistService.deletePlaylist(userId,playlistId);
                System.out.println("Playlist ID: "+playlistId);

            }
            catch(RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Playlist Deletion failed!");
        }
    }
}
