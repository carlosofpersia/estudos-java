package br.com.softplan.interfaces;

import java.util.List;

public interface GeradorObservacaoNumerosInterface extends GeradorObservacaoInterface {

	public String geraObservacao(List<Integer> numerosNotasFiscais);

	public StringBuilder retornaCodigos(List<Integer> numerosNotasFiscais);
}
