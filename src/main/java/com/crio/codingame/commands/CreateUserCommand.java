package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;
import com.crio.codingame.services.UserService;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;
    
    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Ross"]


    @Override
    public void execute(List<String> tokens) {
        // for(int i = 0;i < tokens.size();i++){
        //     System.out.println(userService.create(tokens.get(i)));
        // }
        User user = userService.create(tokens.get(1));
        System.out.print(user);
    }
    
}
