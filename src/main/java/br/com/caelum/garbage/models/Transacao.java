package br.com.caelum.garbage.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {
	
	private final Long id;
	private final BigDecimal valor;
	private final LocalDateTime data;
	private final String cliente;

	public Transacao(Long id, BigDecimal valor, LocalDateTime data, String cliente) {
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public LocalDateTime getData() {
		return data;
	}
	public String getCliente() {
		return cliente;
	}

}
