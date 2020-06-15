package br.com.softplan.interfaces;

import java.util.Map;

public interface GeradorObservacaoValoresInterface extends GeradorObservacaoInterface {

	public String geraObservacao(Map<Integer, String> numerosNotasFiscais);

	public StringBuilder retornaCodigos(Map<Integer, String> numerosNotasFiscais);
}
