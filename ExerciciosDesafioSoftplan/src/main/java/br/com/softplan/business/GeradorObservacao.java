package br.com.softplan.business;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * 
 * Classe Gera observações, com texto pre-definido, incluindo os números, das
 * notas fiscais, recebidos no parâmetro
 * 
 */
public class GeradorObservacao {

	private static Double totalValores = 0.0;

	static Locale ptBr = new Locale("pt", "BR");
	private static NumberFormat moedaPtbr = NumberFormat.getNumberInstance(ptBr);
	

	public GeradorObservacao() {
		GeradorObservacao.totalValores = 0.0;
		(GeradorObservacao.moedaPtbr).setMinimumFractionDigits(2);
	}

	public String geraObservacao(List<Integer> numerosNotasFiscais) {
		if (hasNumerosNotasFiscais(numerosNotasFiscais)) {
			StringBuilder codigosConcatenados = retornaCodigos(numerosNotasFiscais);
			String message = isPlural(numerosNotasFiscais) ? Constants.TX_GERADOR_OBSERVACAO_PLURAL
					: Constants.TX_GERADOR_OBSERVACAO_SINGULAR;
			return message + codigosConcatenados;
		}
		return "";
	}

	public String geraObservacao(Map<Integer, String> notasFiscaisValores) {

		List<Integer> notasFiscais = new ArrayList<>(notasFiscaisValores.keySet());

		if (hasNumerosNotasFiscais(notasFiscais)) {
			String message = isPlural(notasFiscais) ? Constants.TX_GERADOR_OBSERVACAO_PLURAL
					: Constants.TX_GERADOR_OBSERVACAO_SINGULAR;
			StringBuilder codigosConcatenados = retornaCodigos(notasFiscaisValores);
			return message + codigosConcatenados + ". Total = " + (GeradorObservacao.moedaPtbr)
					.format(Double.valueOf(GeradorObservacao.totalValores));
		}
		return "";
	}

	public static StringBuilder retornaCodigos(List<Integer> numerosNotasFiscais) {
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

	public static StringBuilder retornaCodigos(Map<Integer, String> numerosNotasFiscais) {
		StringBuilder message = new StringBuilder();
		numerosNotasFiscais.entrySet().forEach(e -> {
			GeradorObservacao.totalValores += Double.valueOf(e.getValue());
			String valorPtBr = (GeradorObservacao.moedaPtbr).format(Double.valueOf(e.getValue()));
			message.append(e.getKey())
					.append(Constants.TX_GERADOR_OBSERVACAO_CUJO_VALOR)
			        .append(valorPtBr)
			        .append(virgulaSeparadora(numerosNotasFiscais, e.getValue()));
		});
		return message;
	}

	public static boolean hasNumerosNotasFiscais(List<Integer> numerosNotasFiscais) {
		try {
			if (numerosNotasFiscais.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isPlural(List<Integer> numerosNotasFiscais) {
		try {
			if (numerosNotasFiscais.size() >= 2) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static String virgulaSeparadora(Map<Integer, String> numerosNotasFiscais, String valor) {
		String preLastIndex = numerosNotasFiscais.get(numerosNotasFiscais.size() - 1);
		String lastIndex = numerosNotasFiscais.get(numerosNotasFiscais.size());
		return (preLastIndex == valor) ? " e " : lastIndex == valor ? "" : ", ";
	}

	private static class Constants {
		public static final String TX_GERADOR_OBSERVACAO_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
		public static final String TX_GERADOR_OBSERVACAO_PLURAL = "Fatura das notas fiscais de simples remessa: ";
		public static final String TX_GERADOR_OBSERVACAO_CUJO_VALOR = " cujo valor � R$ ";
	}

}