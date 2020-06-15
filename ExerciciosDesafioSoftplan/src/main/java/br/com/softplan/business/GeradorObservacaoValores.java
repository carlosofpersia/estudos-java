package br.com.softplan.business;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.softplan.core.Constants;
import br.com.softplan.core.Utils;

/**
 * 
 * Classe Gera observações, com texto pre-definido, incluindo os números e
 * valores, das notas fiscais, recebidos no parâmetro
 * 
 */
public class GeradorObservacaoValores {

	private static Double totalValores = 0.0;
	Map<Integer, String> numerosNotasFiscais;

	static Locale ptBr = new Locale("pt", "BR");
	private static NumberFormat moedaPtbr = NumberFormat.getNumberInstance(ptBr);;

	public GeradorObservacaoValores(Map<Integer, String> numerosNotasFiscais) {
		this.numerosNotasFiscais = numerosNotasFiscais;
		(GeradorObservacaoValores.moedaPtbr).setMinimumFractionDigits(2);
	}

	public GeradorObservacaoValores() {
		(GeradorObservacaoValores.moedaPtbr).setMinimumFractionDigits(2);
	}

	public String geraObservacao(Map<Integer, String> numerosNotasFiscais) {
		this.numerosNotasFiscais = numerosNotasFiscais;
		GeradorObservacaoValores.totalValores = 0.0;
		return this.geraObservacao();
	}

	public String geraObservacao() {
		GeradorObservacaoValores.totalValores = 0.0;
		List<Integer> numeros = new ArrayList<>(numerosNotasFiscais.keySet());
		if (Utils.hasNumerosNotasFiscais(numeros)) {
			String message = Utils.isPlural(numeros) ? Constants.TX_GERADOR_OBSERVACAO_PLURAL
					: Constants.TX_GERADOR_OBSERVACAO_SINGULAR;
			StringBuilder codigosConcatenados = retornaCodigos(numerosNotasFiscais);
			return message + codigosConcatenados + ". Total = "
					+ (GeradorObservacaoValores.moedaPtbr).format(Double.valueOf(GeradorObservacaoValores.totalValores));
		}
		return "";
	}

	public StringBuilder retornaCodigos(Map<Integer, String> numerosNotasFiscais) {
		StringBuilder message = new StringBuilder();
		numerosNotasFiscais.entrySet().forEach(e -> {
			GeradorObservacaoValores.totalValores += Double.valueOf(e.getValue());
			String valorPtBr = (GeradorObservacaoValores.moedaPtbr).format(Double.valueOf(e.getValue()));
			message.append(e.getKey()).append(Constants.TX_GERADOR_OBSERVACAO_CUJO_VALOR).append(valorPtBr)
					.append(Utils.virgulaSeparadora(numerosNotasFiscais, e.getValue()));
		});
		return message;
	}

}