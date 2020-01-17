package br.com.softplan.business;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import br.com.softplan.dto.ComposicaoDTO;
import br.com.softplan.dto.ItemDTO;

public class PrecoComposicaoInsumos {

	public static Map<Long, ComposicaoDTO> composicoes = new HashMap<>();

	public void parseComposicaoDTO(JSONObject insumo) {

		ItemDTO itemDTO = ItemDTO.parseJsonToDTO(insumo);

		Long codigoComposicao = (Long) insumo.get("codigoComposicao");

		if (PrecoComposicaoInsumos.composicoes.get(codigoComposicao) != null) {

			PrecoComposicaoInsumos.composicoes.get(codigoComposicao).addItens(itemDTO);
			if (itemDTO.getTipoItem().equals("INSUMO")) {

				PrecoComposicaoInsumos.composicoes.get(codigoComposicao).totalTipoInsumos += itemDTO
						.getQuantidadeComposicao() * itemDTO.getValorUnitario();
			}
		} else {

			ComposicaoDTO composicaoDTO = ComposicaoDTO.parseJsonToDTO(insumo);
			composicaoDTO.addItens(itemDTO);
			if (itemDTO.getTipoItem().equals("INSUMO")) {

				composicaoDTO.totalTipoInsumos += itemDTO.getQuantidadeComposicao() * itemDTO.getValorUnitario();
			}
			PrecoComposicaoInsumos.composicoes.put(codigoComposicao, composicaoDTO);
		}
	}

	public void trataTipoComposicaoValores(ComposicaoDTO objeto) {
		objeto.getItens().forEach(obj -> {
			if (obj.getTipoItem().equals("COMPOSICAO")) {
				Double totalTipoInsumos = PrecoComposicaoInsumos.composicoes.get(obj.getCodigoItem()).totalTipoInsumos;
				obj.setValorUnitario(totalTipoInsumos);
			}
		});
	}

	public void totalizador(ComposicaoDTO objeto) {
		objeto.getItens().forEach(obj -> {
			PrecoComposicaoInsumos.composicoes.get(objeto.getCodigoComposicao()).totalComposicoes += obj
					.getQuantidadeComposicao() * obj.getValorUnitario();
		});
	}
}
