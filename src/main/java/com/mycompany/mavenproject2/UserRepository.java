package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User("qw", "qw"));
    }
    
    public void add(User pUser){this.users.add(pUser);}
    
    public User getByName(String pName) throws NullPointerException{
        for(User user: this.users)
            if(user.getName().equals(pName))
                return user;
        throw new NullPointerException();
    }
    
    public List<User> getAll(){return this.users;}
    
}
