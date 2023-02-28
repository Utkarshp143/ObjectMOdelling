package com.crio.jukebox.appConfig;

import com.crio.jukebox.commands.CreatePlaylistCommand;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.DeletePlaylistCommand;
import com.crio.jukebox.commands.ICommand;
import com.crio.jukebox.commands.LoadDataCommand;
import com.crio.jukebox.commands.ModifyPlaylistCommand;
import com.crio.jukebox.commands.PlayPlaylistCommand;
import com.crio.jukebox.commands.PlaySongCommand;

import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.PlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.SongRepository;

import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.PlaylistService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.UserService;


public class ApplicationConfig 
{
    
    ISongRepository songRepository = new SongRepository();
    IUserRepository userRepository = new UserRepository();
    IPlaylistRepository playlistRepository = new PlaylistRepository();

    ISongService songService = new SongService(songRepository);
    IUserService userService = new UserService(userRepository);
    IPlaylistService playlistService = new PlaylistService(playlistRepository);
    
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    
    private final CreatePlaylistCommand playlistCommand = new CreatePlaylistCommand(playlistService);
    private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    private final LoadDataCommand loadDataCommand = new LoadDataCommand(songRepository);
    private final ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(songRepository,playlistRepository,playlistService);
    private final PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(songRepository,playlistRepository);
    private final PlaySongCommand playSongCommand = new PlaySongCommand(songRepository,playlistRepository);

    private final CommandInvoker commandInvoker = new CommandInvoker();


    public CommandInvoker getCommandInvoker()
    {
        commandInvoker.register("LOAD-DATA",loadDataCommand);
        commandInvoker.register("CREATE-USER",createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST",CreatePlaylistCommand);
        commandInvoker.register("DELETE-PLAYLIST",deletePlaylistCommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyPlaylistCommand);
        commandInvoker.register("PLAY-PLAYLIST",playPlaylistCommand);
        commandInvoker.register("PLAY-SONG",playSongCommand);

        return commandInvoker;
    }
}
