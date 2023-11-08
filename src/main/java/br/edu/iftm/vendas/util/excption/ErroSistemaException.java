package br.edu.iftm.vendas.util.excption;

public class ErroSistemaException extends Exception {

    public ErroSistemaException(String message) {
        super(message);
    }

    public ErroSistemaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
