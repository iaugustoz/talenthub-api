package com.iaugusto.talenthub.exceptions;

public class ExistingUserException extends RuntimeException {
    public ExistingUserException() {
        super("Usuário já possui uma conta.");
    }
}
