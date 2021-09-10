package com.co.app.miscellaneous.constant;

public enum ValidationMessageEnum {

    UnknownException("UnknownException.code", "UnknownException.message", "UnknownException.recomen");

    private final String code;
    private final String message;
    private final String recomen;

    private ValidationMessageEnum(String code, String message, String recomen) {
        this.code = code;
        this.message = message;
        this.recomen = recomen;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRecomen() {
        return recomen;
    }

}
