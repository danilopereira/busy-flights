package com.travix.medusa.busyflights.common.exceptions;

/**
 * Created by danilopereira on 15/03/18.
 */
public class ToughJetException extends GenericErrorException {
    public ToughJetException(int errorCode, String message) {
        super(errorCode, message);
    }

    public ToughJetException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
