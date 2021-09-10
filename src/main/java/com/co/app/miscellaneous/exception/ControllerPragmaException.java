package com.co.app.miscellaneous.exception;

public class ControllerPragmaException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerPragmaException() {
        super();
    }

    public ControllerPragmaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ControllerPragmaException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ControllerPragmaException(String arg0) {
        super(arg0);
    }

    public ControllerPragmaException(Throwable arg0) {
        super(arg0);
    }

}
