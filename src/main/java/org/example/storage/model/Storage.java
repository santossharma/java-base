package org.example.storage.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private final Map<String, String> storageMap;

    public Storage() {
        storageMap = new ConcurrentHashMap<>();
    }

    public Map<String, String> getStorageMap() {
        return storageMap;
    }
}
