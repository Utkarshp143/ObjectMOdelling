package com.crio.jukebox.commands;

import java.util.List;
import java.io.IOException;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.repositories.IPlaylistRepository;


public class ModifyPlaylistCommand implements ICommand
{   
    // private final ISongRepository songRepository;
    // private final IPlaylistRepository playlistRepository;
    private final IPlaylistService playlistService;

    public ModifyPlaylistCommand(IPlaylistService playlistService)
    {
        this.playlistService = playlistService;
    
    }


    @Override
    public void execute(List<String> tokens) 
    {
        String commandName = tokens.get(0);
        
        if(commandName.equals("MODIFY-PLAYLIST"))
        {

            try
            {
                String userId = tokens.get(2);
                String playlistId = tokens.get(3);
                List<String> songId = tokens.subList(4,tokens.size());

                PlayList playlist = null;

                if(tokens.get(1).equals("ADD-Song"))
                {
                    playlist = playlistService.addSongs(userId,playlistId,songId);
                }
                else
                {
                    playlist = playlistService.deleteSongs(userId,playlistId,songId);
                }

                System.out.println("PlayListName: "+playlist.getPlaylistName());
                System.out.println("PlayListId: "+playlist.getId());
                System.out.print("Songs IDS-");

                int i = 0;
                int size = playlist.getSongs().size();

                for(Song s : playlist.getSongs())
                {
                    System.out.print(s.getId());
                    if(i != size-1)
                    {
                        System.out.print(" ");
                        i++;
                    }
                }

                System.out.println();


            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
       
        }
    }
}
