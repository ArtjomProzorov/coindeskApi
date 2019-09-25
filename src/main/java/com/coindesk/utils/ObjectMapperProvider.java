package com.coindesk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Since {@link ObjectMapper} is used in different services, I have generated a Singleton as it's
 * seems to be better from the performance point of view
 * Singleton is a class that can have only one object (an instance of the class) at a time.
 */

public final class ObjectMapperProvider {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private ObjectMapperProvider() {
        throw new AssertionError("No instances of ObjectMapperProvider for you!");
    }

    public static ObjectMapper get() {
        return MAPPER;
    }
}