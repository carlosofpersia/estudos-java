package br.com.softplan.resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.softplan.business.PrecoComposicaoInsumos;

public class Exercicio2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		PrecoComposicaoInsumos precoComposicaoInsumosBusiness = new PrecoComposicaoInsumos();

		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("" + "src/main/resources/dados-entrada-servicos-composicoes.json")) {

			Object obj = jsonParser.parse(reader);
			JSONArray objComposicoes = (JSONArray) obj;

			objComposicoes.forEach(insumos -> {
				precoComposicaoInsumosBusiness.parseComposicaoDTO((JSONObject) insumos);
			});

			PrecoComposicaoInsumos.composicoes.forEach((codigo, objeto) -> {
				precoComposicaoInsumosBusiness.trataTipoComposicaoValores(objeto);
			});

			PrecoComposicaoInsumos.composicoes.forEach((codigo, objeto) -> {
				precoComposicaoInsumosBusiness.totalizador(objeto);
			});

			System.out.println(PrecoComposicaoInsumos.composicoes.toString());

			System.out.println("OK");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}