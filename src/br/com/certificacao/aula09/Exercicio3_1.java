package br.com.certificacao.aula09;

import java.time.*;
import java.time.temporal.*;

public class Exercicio3_1 {

	Exercicio3_1 () {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("3 - Crie e manipule dados de calendários usando as classes do pacote java.time");
	}

	public static void main (String[] args) {

		/*
		LocalDate = Data sem hora;
		LocalTime = Hora sem Data;
		LocalDateTime = Data e Hora;
		MonthDay = Dia de um mês;
		YearMonth = Mês de um ano;
		*/

		/*****************************/

		//se passar por parametro uma unidade de tempo que não existe: 
		//java.time.temporal.UnsupportedTemporalTypeException
		//LocalDate ld2 = LocalDate.now();
		//ld2.get(ChronoField.HOUR_OF_DAY);

		/*****************************/

		LocalDateTime ldt = LocalDateTime.of(2014,12,25,12,33);
		System.out.println( ldt.getDayOfMonth() );
		System.out.println( ldt.getYear() );
		System.out.println( ldt.getMonth() );
		System.out.println( ldt.getHour() );
		System.out.println( ldt.getMinute() );

		System.out.println( ldt.get( ChronoField.DAY_OF_WEEK ) );
		System.out.println( ldt.get( ChronoField.DAY_OF_MONTH ) );

		/*****************************/

		//Se colocar o mês 13 vai dar um java.time.DateTimeException
		LocalDate natal2014Exception = LocalDate.of( 2014, 13, 25 );

		/*****************************/

		LocalTime meioDia = LocalTime.of(12,0);
		LocalDate natal2014 = LocalDate.of(2014,12,25);
		LocalDate natal2015 = LocalDate.of(2015, Month.DECEMBER, 25);

		LocalDateTime algumMomento = LocalDateTime.of(2014,12,25,12,30,02);
		LocalDateTime almocoDeNatal = LocalDateTime.of(natal2015, meioDia);

		/*****************************/

		//Zonas...
		LocalTime t1 = LocalTime.now( ZoneId.of("America/Chicago") );
		System.out.println( t1 );
		LocalTime t2 = LocalTime.now( ZoneId.of("America/Sao_Paulo") );
		System.out.println( t2 );

		/*****************************/

		LocalDate ld = LocalDate.now();
		System.out.println( ld );
		LocalTime lt = LocalTime.now();
		System.out.println( lt );
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println( ldt2 );
		
		/*****************************/

		System.out.println("Aula09.Exercicio3_1");
	}
}