package org.communis.practice.exception;

import org.communis.practice.exception.error.ErrorInformation;

public class AlreadyExistsException extends ServerException {

    public AlreadyExistsException(ErrorInformation errorInformation)
    {
        super(errorInformation);
    }
}
