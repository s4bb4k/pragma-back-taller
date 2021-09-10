package com.co.app.miscellaneous.exception;

public class ExceptionHelper {

    public static void procesar(Exception e, String messageException) {
        throw new ControllerPragmaException(messageException, e);
    }

}
