package dev.valentinpichavant.controllers;

/**
 * Created by valentinpichavant on 10/21/16.
 */

import dev.valentinpichavant.beans.SecurityUtil;
import dev.valentinpichavant.beans.SocialMediaService;
import dev.valentinpichavant.beans.User;
import dev.valentinpichavant.beans.UserService;
import dev.valentinpichavant.exceptions.DuplicateEmailException;
import dev.valentinpichavant.forms.RegistrationForm;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class RegistrationController {

    private UserService service;

    private final ProviderSignInUtils providerSignInUtils;

    @Inject
    public RegistrationController(UserService service, ConnectionFactoryLocator connectionFactoryLocator,
                                  UsersConnectionRepository connectionRepository) {
        this.service = service;
        this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);

    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

        RegistrationForm registration = createRegistrationDTO(connection);
        model.addAttribute("user", registration);

        return "user/registrationForm";
    }

    private RegistrationForm createRegistrationDTO(Connection<?> connection) {
        RegistrationForm dto = new RegistrationForm();

        if (connection != null) {

            Facebook facebook = ((Connection<Facebook>) connection).getApi();
            String[] fields = {"id", "email", "first_name", "last_name"};
            org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
            dto.setEmail(userProfile.getEmail());
            dto.setFirstName(userProfile.getFirstName());
            dto.setLastName(userProfile.getLastName());

            ConnectionKey providerKey = connection.getKey();
            dto.setSignInProvider(SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase()));
        }

        return dto;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") RegistrationForm userAccountData,
                                      BindingResult result,
                                      WebRequest request) throws DuplicateEmailException {
        if (result.hasErrors()) {
            return "user/registrationForm";
        }
        User registered = createUserAccount(userAccountData, result);

        if (registered == null) {
            return "user/registrationForm";
        }

        SecurityUtil.logInUser(registered);
        providerSignInUtils.doPostSignUp(registered.getEmail(), request);

        return "redirect:/";
    }

    private User createUserAccount(RegistrationForm userAccountData, BindingResult result) {
        User registered = null;

        try {
            registered = service.registerNewUserAccount(userAccountData);
        } catch (DuplicateEmailException ex) {
            addFieldError(
                    "user",
                    "email",
                    userAccountData.getEmail(),
                    "NotExist.user.email",
                    result);
        }

        return registered;
    }

    private void addFieldError(String objectName, String fieldName, String fieldValue, String errorCode, BindingResult result) {
        FieldError error = new FieldError(
                objectName,
                fieldName,
                fieldValue,
                false,
                new String[]{errorCode},
                new Object[]{},
                errorCode
        );

        result.addError(error);
    }
}