package com.ninjaone.dundie_awards.exception;

import java.util.Date;

public record Error(
    Date timestamp,
    String message,
    String details) {
}
