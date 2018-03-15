package com.travix.medusa.busyflights.common;

/**
 * Created by danilopereira on 15/03/18.
 */
public enum ErrorCode {
    GENERIC_ERROR(1000, "Generic error"),
    GENERIC_SUPPLIER_ERROR(1001, "Generic Supplier Error");

    private int value;
    private String message;

    private ErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int value() {
        return this.value;
    }

    public String message() {
        return this.message;
    }

    public static ErrorCode getErrorCodeFromValue(int value) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.value == value) {
                return errorCode;
            }
        }

        throw new IllegalArgumentException(String.valueOf(value));
    }
}
