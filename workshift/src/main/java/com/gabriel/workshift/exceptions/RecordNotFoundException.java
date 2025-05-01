package com.gabriel.workshift.exceptions;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String id) {
        super("Record not found with id: " + id);
    }

    public RecordNotFoundException(String message, String id) {
        super(message);
    }
}
