package com.crio.jukebox.commands;

import java.io.IOException;
import java.util.List;

public interface ICommand {
    void execute(List<String> tokens) throws IOException;
}