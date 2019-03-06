package br.com.poc.cadastro.exception;

public class PocCadastroException extends Exception {

	private static final long serialVersionUID = -7755517646125094194L;

	public PocCadastroException(String error) {
		super(error);
	}
	
	public PocCadastroException(String error, Throwable e) {
		super(error, e);
	}
	
}
