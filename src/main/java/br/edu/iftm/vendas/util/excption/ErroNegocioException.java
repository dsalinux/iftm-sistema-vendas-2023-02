package br.edu.iftm.vendas.util.excption;

public class ErroNegocioException extends Exception {

    public ErroNegocioException(String message) {
        super(message);
    }

    public ErroNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
