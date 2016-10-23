package dev.valentinpichavant.exceptions;

/**
 * Created by valentinpichavant on 10/21/16.
 */
public class DuplicateEmailException extends Exception {
    public DuplicateEmailException(String string) {
        super(string);
    }
}
