package dev.valentinpichavant.repositories;

/**
 * Created by valentinpichavant on 10/21/16.
 */

import dev.valentinpichavant.beans.User;
import dev.valentinpichavant.beans.UserService;
import dev.valentinpichavant.exceptions.DuplicateEmailException;
import dev.valentinpichavant.forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepositoryUserService implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException {
        if (emailExist(userAccountData.getEmail())) {
            throw new DuplicateEmailException("The email address: " + userAccountData.getEmail() + " is already in use.");
        }
        String encodedPassword = encodePassword(userAccountData);

        User.Builder user = User.getBuilder()
                .email(userAccountData.getEmail())
                .firstName(userAccountData.getFirstName())
                .lastName(userAccountData.getLastName())
                .password(encodedPassword);

        if (userAccountData.isSocialSignIn()) {
            user.signInProvider(userAccountData.getSignInProvider());
        }

        User registered = user.build();

        return repository.save(registered);
    }

    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);

        return user != null;

    }

    private String encodePassword(RegistrationForm dto) {
        String encodedPassword = null;

        if (dto.isNormalRegistration()) {
            encodedPassword = passwordEncoder.encode(dto.getPassword());
        }

        return encodedPassword;
    }
}