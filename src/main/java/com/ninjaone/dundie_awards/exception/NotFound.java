package com.ninjaone.dundie_awards.exception;

import jakarta.persistence.EntityNotFoundException;

public class NotFound extends EntityNotFoundException {
    public NotFound(String id) {
        super("Resource with ID "+ id + " not found");
    }
}
