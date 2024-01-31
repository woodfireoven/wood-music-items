package com.example.demo;

public class MusicItemNotFoundException extends RuntimeException {

    MusicItemNotFoundException(Long id) {
        super("Could not find music item " + id);
    }
}
