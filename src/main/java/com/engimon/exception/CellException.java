package com.engimon.exception;

public class CellException extends Exception {

    private static final long serialVersionUID = -5697237102425505969L;

    private ErrorCause errorCause;

    public CellException(ErrorCause ec) {
        this.errorCause = ec;
    }

    public ErrorCause getErrorCause() {
        return errorCause;
    }

    public enum ErrorCause {
        CELL_EMPTY, CELL_OCCUPIED_BY_PLAYER, CELL_OCCUPIED_BY_OTHER;
    }

}
