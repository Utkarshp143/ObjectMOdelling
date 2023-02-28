package com.crio.jukebox.repositories;


import com.crio.jukebox.entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository implements IUserRepository
{
    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) 
    {
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getUserName());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<User> findAll() {
        List<User> currentUser = new ArrayList<>(userMap.values());
        return currentUser;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) 
    {
        return userMap.containsKey(id) ? true:false;    
    }

    @Override
    public void delete(User entity)
    {
        userMap.remove(entity.getId());
    }    
    

    @Override
    public void deleteById(String id) 
    {
        userMap.remove(id);
    }

    @Override
    public long count() 
    {
        return 0;
    }

   
}
