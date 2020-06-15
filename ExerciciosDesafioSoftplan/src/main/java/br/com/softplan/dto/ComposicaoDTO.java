package br.com.softplan.dto;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import br.com.softplan.core.Utils;

public class ComposicaoDTO {

	private Long codigoComposicao;
	private String descricaoComposicao;
	private String unidadeComposicao;

	private List<ItemDTO> itens = new ArrayList<>();

	public Double totalComposicoes = 0.0;
	public Double totalTipoInsumos = 0.0;
	
	public Long getCodigoComposicao() {
		return codigoComposicao;
	}

	public void setCodigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	}

	public String getDescricaoComposicao() {
		return descricaoComposicao;
	}

	public void setDescricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
	}

	public String getUnidadeComposicao() {
		return unidadeComposicao;
	}

	public void setUnidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public void addItens(ItemDTO itens) {
		(this.itens).add(itens);
	}

	@Override
	public String toString() {

		/*
		 * return "ComposicaoDTO [codigoComposicao=" + codigoComposicao +
		 * ", totalTipoInsumos=" + totalTipoInsumos + ", descricaoComposicao=" +
		 * descricaoComposicao + ", unidadeComposicao=" + unidadeComposicao + ", itens="
		 * + itens + ", totalComposicoes=" + Utils.doubleToStrValue(totalComposicoes) +
		 * "]";
		 */

		return "Composição do Serviço:  [Código: " + codigoComposicao + " - (" + unidadeComposicao + ") "
				+ descricaoComposicao + " Total: " + Utils.doubleToStrValue(totalComposicoes) + "]";
	}
	

	public static ComposicaoDTO parseJsonToDTO(JSONObject insumo) {

		ComposicaoDTO composicaoDTO = new ComposicaoDTO();

		composicaoDTO.setCodigoComposicao((Long) insumo.get("codigoComposicao"));
		composicaoDTO.setDescricaoComposicao((String) insumo.get("descricaoComposicao"));
		composicaoDTO.setUnidadeComposicao((String) insumo.get("unidadeComposicao"));
		composicaoDTO.totalComposicoes = 0.0;

		return composicaoDTO;
	}
	
	

}
