package com.crio.jukebox.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crio.jukebox.exceptions.NoSuchCommandException;


public class CommandInvoker 
{
    private final HashMap<String,ICommand> commandMap = new HashMap<>();

    public void register(String commandName, ICommand command){
        commandMap.put(commandName,command);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException, IOException {
        ICommand command = get(commandName);
        if(command == null){
            // Handle Exception
            throw new NoSuchCommandException();
        }
        command.execute(tokens);
    }
}
