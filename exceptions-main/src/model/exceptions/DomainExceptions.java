package model.exceptions;

public class DomainExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainExceptions(String msg) {
		super(msg);
	}
}


/*
 * A classe pode ser extendida de RuntimeException ou Exception...
 * RuntimeException = não precisa tratar o erro obrigatoriamente
 * Exception =  é obrigado a tratar aquele erro (mesmo que propagando)
 */