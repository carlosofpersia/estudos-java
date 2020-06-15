package br.com.softplan.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import br.com.softplan.dto.ComposicaoDTO;
import br.com.softplan.dto.ItemDTO;

public class PrecoComposicaoInsumosTest {

	@Test
	public void verificaConstrutor() {
		PrecoComposicaoInsumos business = new PrecoComposicaoInsumos();
		assertTrue(business instanceof PrecoComposicaoInsumos);
	}

	@Test
	public void verficaparSeParseItensJsonToDTO() {

		JSONParser jsonParser = new JSONParser();

		String mockDadosEntrada = "{\"codigoComposica\": 98561, \"descricaoComposicao\": \"Descricao da Composicao\", \"unidadeComposicao\":\"M2\", \"tipoItem\": \"COMPOSICAO\", \"codigoItem\": 87286, \"descricaoItemComposicao\": \"Descricao do Item\", \"unidadeItem\": \"M3\", \"quantidadeComposicao\": \"0,0250000\", \"valorUnitario\": \"\" }";

		try {

			Object obj = jsonParser.parse(mockDadosEntrada.toString());
			JSONObject objComposicoes = (JSONObject) obj;
			ItemDTO itemDTO = ItemDTO.parseJsonToDTO(objComposicoes);

			assertEquals((itemDTO.getCodigoItem()).toString(), "87286");

			assertEquals((itemDTO.getUnidadeItem()).toString(), "M3");

			assertEquals((itemDTO.getTipoItem()).toString(), "COMPOSICAO");

			assertEquals((itemDTO.getValorUnitario()).toString(), "0.0");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void verficaparSeParseComposicaoJsonToDTO() {

		JSONParser jsonParser = new JSONParser();

		String mockDadosEntrada = "{\"codigoComposicao\": 98561, \"descricaoComposicao\": \"Descricao da Composicao\", \"unidadeComposicao\":\"M2\", \"tipoItem\": \"COMPOSICAO\", \"codigoItem\": 87286, \"descricaoItemComposicao\": \"Descricao do Item\", \"unidadeItem\": \"M3\", \"quantidadeComposicao\": \"0,0250000\", \"valorUnitario\": \"\" }";

		try {

			Object obj = jsonParser.parse(mockDadosEntrada.toString());
			JSONObject objComposicoes = (JSONObject) obj;
			ComposicaoDTO composicaoDTO = ComposicaoDTO.parseJsonToDTO(objComposicoes);

			assertEquals((composicaoDTO.getCodigoComposicao()).toString(), "98561");

			assertEquals((composicaoDTO.getUnidadeComposicao()).toString(), "M2");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
