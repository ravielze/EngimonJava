package com.engimon.exception;

public class PlayerException extends Exception {

    private static final long serialVersionUID = 6303925513327912701L;

    public enum PlayerError {
        NO_ACTIVE_ENGIMON;
    }

    private PlayerError playerError;

    public PlayerError getPlayerError() {
        return this.playerError;
    }

    public PlayerException(PlayerError pe) {
        this.playerError = pe;
    }

}
