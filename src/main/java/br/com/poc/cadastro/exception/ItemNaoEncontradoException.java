package br.com.poc.cadastro.exception;

public class ItemNaoEncontradoException extends PocCadastroException {

	private static final long serialVersionUID = 6186237713595335416L;

	public ItemNaoEncontradoException(String error) {
		super(error);
	}
	
	public ItemNaoEncontradoException(String error, Throwable e) {
		super(error, e);
	}

}
