package dev.valentinpichavant.beans;

import dev.valentinpichavant.exceptions.DuplicateEmailException;
import dev.valentinpichavant.forms.RegistrationForm;

/**
 * Created by valentinpichavant on 10/21/16.
 */
public interface UserService {

    default User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException {
        return null;
    }
}