package com.mycompany.mavenproject2;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService {
    @Inject
    private UserRepository uRepo;
    
    public boolean isExists(String pUserName){
        for(User user:uRepo.getAll())
            if(user.getName().equals(pUserName))
                return true;
        return false;
    }
    
    public boolean isExists(User pUser){
        for(User user:uRepo.getAll())
            if(user.equals(pUser))
                return true;
        return false;
    }
   
}
