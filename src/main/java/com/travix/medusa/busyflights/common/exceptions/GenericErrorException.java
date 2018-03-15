package com.travix.medusa.busyflights.common.exceptions;

/**
 * Created by danilopereira on 15/03/18.
 */
public class GenericErrorException extends Exception {
    private static final long serialVersionUID = 1L;

    private int errorCode;

    private String errorMessage;

    public GenericErrorException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public GenericErrorException(int errorCode, String message, Throwable cause){
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

}
