package com.crio.jukebox.services;

import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.entities.User;

public class UserService implements IUserService
{
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    
    @Override
    public User createUser(String userName)
    {
        User user = new User(userName);
        user = userRepository.save(user);

        return user;
    }
}
