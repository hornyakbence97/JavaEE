package com.mycompany.mavenproject2;

public class UserService {
    private UserRepository uRepo = new UserRepository();
    
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
