package br.com.certificacao.aula09;

import java.time.*;
import java.time.temporal.*;

public class Exercicio3_2 {

	Exercicio3_2 () {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("3 - Crie e manipule dados de calendários usando as classes do pacote java.time");
		System.out.println("Parte 2");
	}

	public static void main (String[] args) {

		/*
		LocalDate = Data sem hora;
		LocalTime = Hora sem Data;
		LocalDateTime = Data e Hora;
		MonthDay = Dia de um mês;
		YearMonth = Mês de um ano;
		*/

		
		String msgXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>_<ns5:SERVICO_ENTRADA xmlns:ns2=\"http://caixa.gov.br/sibar\" xmlns:ns4=\"http://caixa.gov.br/sibar/valida_cartao\" xmlns:ns3=\"http://caixa.gov.br/sibar/controle_correspondente\" xmlns:ns6=\"http://caixa.gov.br/sibar/valida_senha\" xmlns:ns20=\"http://caixa.gov.br/sibar/consulta_habitacao/boleto\" xmlns:ns5=\"http://caixa.gov.br/sibar/autenticacao_biometrica\" xmlns:ns8=\"http://caixa.gov.br/sibar/consulta_conta_sid09\" xmlns:ns7=\"http://caixa.gov.br/silce/validacodigoresgate\" xmlns:ns13=\"http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/pagamento\" xmlns:ns24=\"http://caixa.gov.br/sibar/consulta_habitacao/pagamentos\" xmlns:ns9=\"http://caixa.gov.br/sibar/sms_consulta_servicos\" xmlns:ns12=\"http://caixa.gov.br/sibar/consulta_cobranca_bancaria/pagamento\" xmlns:ns23=\"http://caixa.gov.br/sibar/consulta_habitacao/liquidacao\" xmlns:ns11=\"http://caixa.gov.br/sibar/controle_pagamentos\" xmlns:ns22=\"http://caixa.gov.br/sibar/consulta_habitacao/informeirpf\" xmlns:ns10=\"http://caixa.gov.br/ippo/manutencao\" xmlns:ns21=\"http://caixa.gov.br/sibar/consulta_habitacao/contrato\" xmlns:ns17=\"http://caixa.gov.br/sibar/manutencao_cartao_debito\" xmlns:ns16=\"http://caixa.gov.br/sibar/manutencao_conta_caixa_facil\" xmlns:ns15=\"http://caixa.gov.br/sibar/manutencao_cliente\" xmlns:ns14=\"http://caixa.gov.br/sibar/manutencao_conta\" xmlns:ns25=\"http://caixa.gov.br/sibar/manutencao_sms\" xmlns:ns19=\"http://caixa.gov.br/sibar/consulta_habitacao/amortizacao\" xmlns:ns18=\"http://caixa.gov.br/siico/consulta_corporativa/conslocalidadeporcep/icopo9lb\">_    <ns2:HEADER>_        <VERSAO>1.0</VERSAO>_        <USUARIO_SERVICO>SSPLBD01</USUARIO_SERVICO>_        <OPERACAO>CONSULTA_BIOMETRICA</OPERACAO>_        <SISTEMA_ORIGEM>SISPL</SISTEMA_ORIGEM>_        <DATA_HORA>20181031103755</DATA_HORA>_    </ns2:HEADER>_    <ns3:CONTROLE_CORRESPONDENTE_ENTRADA>_        <CODIGO_SERVICO>834007</CODIGO_SERVICO>_        <CANAL>9660</CANAL>_        <CONVENIO>_            <CODIGO>11001617</CODIGO>_            <DV>3</DV>_        </CONVENIO>_        <TIPO_CARTAO>0</TIPO_CARTAO>_        <PIS>0</PIS>_        <CODIGO_SITUACAO>0</CODIGO_SITUACAO>_        <TERMINAL>000455</TERMINAL>_        <NSU_ORIGEM>0</NSU_ORIGEM>_        <CPF>0</CPF>_    </ns3:CONTROLE_CORRESPONDENTE_ENTRADA>_    <DADOS>_        <NUMERO>3539506101</NUMERO>_        <IDENTIFICADOR>CPF</IDENTIFICADOR>_        <NSU>516820102</NSU>_    </DADOS>_</ns5:SERVICO_ENTRADA>_";
		
		String msgXMLTratada = (msgXML).replaceAll(">([_]|\\n|\\t|\\s)*", ">");

		System.out.println(msgXMLTratada);

		
		//String pattern = "/>_/";
		//String msgXMLTratada = msgXML.replaceAll("(>_\\s*<?)", ">").toString();
		//String msgXMLTratada = msgXML.replaceAll(">(_|\r|\n)", ">").toString();
		
		//System.out.println( msgXMLTratada );
		

		System.out.println("Aula09.Exercicio3_1");
	}
}