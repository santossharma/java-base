package org.example.storage.exception;

public class InvalidSecretKeyException extends RuntimeException {
    public InvalidSecretKeyException(String s) {
        super(s);
    }
}
