package com.vectk.backend.service.file;

public record StoredFile(String storageKey, String checksum, long size) {}
