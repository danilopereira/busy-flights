package com.travix.medusa.busyflights.common.exceptions;

/**
 * Created by danilopereira on 15/03/18.
 */
public class CrazyAirException extends GenericErrorException {
    public CrazyAirException(int errorCode, String message) {
        super(errorCode, message);
    }

    public CrazyAirException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
