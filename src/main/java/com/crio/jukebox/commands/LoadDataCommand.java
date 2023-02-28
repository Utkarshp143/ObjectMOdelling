package com.crio.jukebox.commands;

import java.util.List;
import java.io.IOException;
import com.crio.jukebox.entities.Song;

import com.crio.jukebox.repositories.ISongRepository;


public class LoadDataCommand implements ICommand
{
    private final ISongRepository songRepository;

    public LoadDataCommand(ISongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    @Override
    public void execute(List<String> tokens) throws IOException {
        String commandName = tokens.get(0);
        
        if(commandName.equals("LOAD-DATA"))
        {
            songRepository.loadSongs(tokens.get(1));
            System.out.println("Song Loaded Successfully!");
        }
        else
        {
            System.out.println("Song Loading failed!");
        }
    }
}
