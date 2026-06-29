package com.algaworks.algashop.ordering.infrastructure.adapters.in.web.exceptionhandler;

public class BadGatewayException extends RuntimeException{
    public BadGatewayException() {
    }

    public BadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class ServerErrorException extends RuntimeException {
        public ServerErrorException() {}

        public ServerErrorException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ClientErrorException extends RuntimeException {
        public ClientErrorException() {}

        public ClientErrorException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
