package br.com.softplan.business;

import java.util.Iterator;
import java.util.List;

import br.com.softplan.core.Constants;
import br.com.softplan.core.Utils;
import br.com.softplan.interfaces.GeradorObservacaoNumerosInterface;

/**
 * 
 * Classe Gera observações, com texto pre-definido, incluindo os números, das
 * notas fiscais, recebidos no parâmetro
 * 
 */
public class GeradorObservacaoNumeros implements GeradorObservacaoNumerosInterface {

	List<Integer> numerosNotasFiscais;

	public GeradorObservacaoNumeros() {
		super();
	}

	public GeradorObservacaoNumeros(List<Integer> numerosNotasFiscais) {
		this.numerosNotasFiscais = numerosNotasFiscais;
	}

	@Override
	public String geraObservacao(List<Integer> numerosNotasFiscais) {
		this.numerosNotasFiscais = numerosNotasFiscais;
		return this.geraObservacao();
	}

	@Override
	public String geraObservacao() {
		if (Utils.hasNumerosNotasFiscais(numerosNotasFiscais)) {
			StringBuilder codigosConcatenados = retornaCodigos(numerosNotasFiscais);
			String message = Utils.isPlural(numerosNotasFiscais) ? Constants.TX_GERADOR_OBSERVACAO_PLURAL
					: Constants.TX_GERADOR_OBSERVACAO_SINGULAR;
			return message + codigosConcatenados;
		}
		return "";
	}

	@Override
	public StringBuilder retornaCodigos(List<Integer> numerosNotasFiscais) {
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = numerosNotasFiscais.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if (cod.toString() == null || cod.toString().length() <= 0)
				s = "";
			else if (iterator.hasNext())
				s = ", ";
			else
				s = " e ";
			cod.append(s + c);
		}
		return cod;
	}

}