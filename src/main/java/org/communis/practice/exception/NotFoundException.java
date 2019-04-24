package org.communis.practice.exception;


import org.communis.practice.exception.error.ErrorInformation;

public class NotFoundException extends ServerException {
    public NotFoundException(ErrorInformation errorInformation) {
        super(errorInformation);
    }
}
