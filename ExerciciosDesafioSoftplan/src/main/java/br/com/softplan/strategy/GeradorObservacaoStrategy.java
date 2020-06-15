package br.com.softplan.strategy;

import java.util.List;
import java.util.Map;

import br.com.softplan.business.GeradorObservacaoNumeros;
import br.com.softplan.business.GeradorObservacaoValores;
import br.com.softplan.interfaces.GeradorObservacaoNumerosInterface;
import br.com.softplan.interfaces.GeradorObservacaoValoresInterface;

public class GeradorObservacaoStrategy implements GeradorObservacaoValoresInterface, GeradorObservacaoNumerosInterface {

	List<Integer> numerosNotasFiscais;

	public GeradorObservacaoStrategy() {
		super();
	}

	public static Object getInstance(List<Integer> numerosNotasFiscais) {

		return new GeradorObservacaoNumeros(numerosNotasFiscais);
	}

	public static Object getInstance(Map<Integer, String> numerosNotasFiscais) {

		return new GeradorObservacaoValores(numerosNotasFiscais);
	}

	@Override
	public String geraObservacao(Map<Integer, String> numerosNotasFiscais) {
		GeradorObservacaoValores goValores = (GeradorObservacaoValores) getInstance(numerosNotasFiscais);
		return goValores.geraObservacao(numerosNotasFiscais);
	}

	@Override
	public String geraObservacao(List<Integer> numerosNotasFiscais) {
		GeradorObservacaoNumeros goValores = (GeradorObservacaoNumeros) getInstance(numerosNotasFiscais);
		return goValores.geraObservacao(numerosNotasFiscais);
	}

	@Override
	public String geraObservacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder retornaCodigos(List<Integer> numerosNotasFiscais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder retornaCodigos(Map<Integer, String> numerosNotasFiscais) {
		// TODO Auto-generated method stub
		return null;
	}

}
