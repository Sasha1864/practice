package org.communis.practice.exception;

import org.communis.practice.exception.error.ErrorInformation;

public class InvalidDataException extends ServerException {

    public InvalidDataException(ErrorInformation errorInformation) {
        super(errorInformation);
    }
}

