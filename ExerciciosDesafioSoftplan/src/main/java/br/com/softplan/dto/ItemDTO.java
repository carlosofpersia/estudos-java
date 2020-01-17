package br.com.softplan.dto;

import org.json.simple.JSONObject;

import br.com.softplan.core.Utils;

public class ItemDTO {

	private Long codigoItem;
	private String tipoItem;
	private String descricaoItemComposicao;
	private String unidadeItem;
	private Double quantidadeComposicao;
	private Double valorUnitario;

	public Long getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getDescricaoItemComposicao() {
		return descricaoItemComposicao;
	}

	public void setDescricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
	}

	public String getUnidadeItem() {
		return unidadeItem;
	}

	public void setUnidadeItem(String unidadeItem) {
		this.unidadeItem = unidadeItem;
	}

	public Double getQuantidadeComposicao() {
		return quantidadeComposicao;
	}

	public void setQuantidadeComposicao(Double quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		return "ItemDTO [codigoItem=" + codigoItem + ", tipoItem=" + tipoItem + ", descricaoItemComposicao="
				+ descricaoItemComposicao + ", unidadeItem=" + unidadeItem + ", quantidadeComposicao="
				+ Utils.doubleToStrValue(quantidadeComposicao) + ", valorUnitario="
				+ Utils.doubleToStrValue(valorUnitario) + "]";
	}

	public static ItemDTO parseJsonToDTO(JSONObject insumo) {

		Double quantidadeComposicao = Utils.strToDoubleValue((insumo.get("quantidadeComposicao")).toString());
		Double valorUnitario = Utils.strToDoubleValue((insumo.get("valorUnitario")).toString());

		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setCodigoItem((Long) insumo.get("codigoItem"));
		itemDTO.setTipoItem((String) insumo.get("tipoItem"));
		itemDTO.setDescricaoItemComposicao((String) insumo.get("descricaoItemComposicao"));
		itemDTO.setUnidadeItem((String) insumo.get("unidadeItem"));
		itemDTO.setQuantidadeComposicao(quantidadeComposicao);
		itemDTO.setValorUnitario(valorUnitario);

		return itemDTO;
	}

}
