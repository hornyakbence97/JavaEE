package com.mycompany.mavenproject2;

import javax.inject.Inject;



public class UserService {

    public UserService() {
    }
    
    
    
    public boolean isExists(String pUserName, UserRepository repo){
        for(User user:repo.getAll())
            if(user.getName().equals(pUserName))
                return true;
        return false;
    }
    
    public boolean isExists(User pUser, UserRepository repo){
        for(User user:repo.getAll())
            if(user.equals(pUser))
                return true;
        return false;
    }
   
}
