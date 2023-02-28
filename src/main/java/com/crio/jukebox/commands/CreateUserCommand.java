package com.crio.jukebox.commands;

import java.util.List;
import java.io.IOException;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IPlaylistRepository;


public class CreateUserCommand implements ICommand
{
    private final IUserService userService;
    
// public CreateUserCommand (IUserService userService)
// {
//     this.userService = userService;
// }


    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute(List<String> tokens) {

        User user = userService.createUser(tokens.get(1));
        System.out.print(user);
    }
}
