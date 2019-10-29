
package hu.oenik7.web.services;

import hu.oenik7.web.bl.*;
import javax.ejb.Singleton;
import javax.inject.Inject;



@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    public void registration( String userName, String pPassword)
    throws RegistrationException{
        try {

               userRepository.add(new User(userName, pPassword, false));

        } catch (Exception ex) {
               throw new RegistrationException();
        }

    }

    public User login(String pUserName, String pPass) throws LoginException {
        try {
            return userRepository.getUser(pUserName, pPass);
        } catch (Exception ex) {
            ex.getMessage();
            throw new LoginException();
        }

    }
}