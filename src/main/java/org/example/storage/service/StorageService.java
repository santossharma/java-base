package org.example.storage.service;

import org.example.storage.model.Storage;
import org.example.storage.exception.InvalidSecretKeyException;

import java.util.Objects;

public class StorageService {
    private final Storage storage;

    public StorageService() {
        storage = new Storage();
    }

    public String storeKeySecret(final String secretKey, final String secretValue) {

        if(Objects.isNull(secretKey)) {
            throw new InvalidSecretKeyException("Secret Key can not be null!");
        }
        if(Objects.isNull(secretValue)) {
            throw new InvalidSecretKeyException("Secret Key can not be null!");
        }

        storage.getStorageMap().put(secretKey, secretValue);

        return secretKey;
    }
}
