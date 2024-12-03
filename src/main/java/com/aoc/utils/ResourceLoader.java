package com.aoc.utils;

import java.io.InputStream;

public class ResourceLoader {
    public static InputStream getResourceAsStream(String resourcePath) {
        InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        }
        return inputStream;
    }
}
