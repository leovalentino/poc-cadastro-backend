package br.com.poc.cadastro.exception;

public class PocCadastroNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PocCadastroNegocioException(String error) {
		super(error);
	}

}
