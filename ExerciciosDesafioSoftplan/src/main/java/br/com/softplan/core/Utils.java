package br.com.softplan.core;

import java.util.List;
import java.util.Map;

public class Utils {
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
		String keyPenultimate = numerosNotasFiscais.get(numerosNotasFiscais.size() - 1);
		String keyLast = numerosNotasFiscais.get(numerosNotasFiscais.size());
		return (keyPenultimate == valor) ? " e " : keyLast == valor ? "" : ", ";
	}

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static Double strToDoubleValue(String valor) {
		return valor.isEmpty() ? 0 : Double.parseDouble(valor.replace(",", "."));
	}

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static String doubleToStrValue(Double valor) {
		String txValor = String.format("%.2f", valor);
		return (txValor).replace(".", ",");
	}

}
