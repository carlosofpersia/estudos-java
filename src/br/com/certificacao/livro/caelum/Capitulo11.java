package br.com.certificacao.livro.caelum;

import java.util.*;
import java.util.function.Predicate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Capitulo11 {

	public static void main ( String[] args ) {

		//CAPITULO 11 JAVA 8 ─ TRABALHANDO COM ALGUMAS CLASSES DA JAVA API

		//11.1 CRIE E MANIPULE DADOS DE CALENDARIOS

		//Página 422.

		LocalTime currentTime = LocalTime.now(); // 09:05:03.244
		LocalDate today = LocalDate.now();       // 2014-12-10
		LocalDateTime now = LocalDateTime.now(); // 2014-12-10-09-05-03.244

		/****************/
		
		//Fuso Horário: ZoneId
		LocalTime time         = LocalTime.now(ZoneId.of("America/Chicago"));
		LocalDate date         = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));

		/****************/
		
		//.of
		LocalTime noon = LocalTime.of(12, 0);
		LocalDate christmas2014_2 = LocalDate.of(2014, 12, 25);
		LocalDate christmas2015_2 = LocalDate.of(2015, Month.DECEMBER, 25);
		MonthDay someChristmas  = MonthDay.of(Month.DECEMBER, 31);
		
		/****************/
		
		LocalDateTime someDate = LocalDateTime.of(2017, Month.JANUARY, 25, 13, 45);
		LocalDate christmas2014 = LocalDate.of(2014, 12, 25);
		LocalDateTime christmasAtNoon = LocalDateTime.of(christmas2014, noon);
		//Passar um valor inválido para qualquer um dos campos (mês 13, por exemplo) lançará um DateTimeException .

		/****************/

		/*
		 * get : obtém o valor de algo; TemporalField , geralmente ChronoField , e retorna um inteiro.
		 * is : verifica se algo é verdadeiro;
		 * with : lembra um setter, mas retorna um novo objeto com o valor alterado;
		 * plus : soma alguma unidade ao objeto, retorna um novo objeto com o valor alterado;
		 * minus : subtrai alguma unidade do objeto, retorna um novo objeto com o valor alterado;
		 * to : converte um objeto de um tipo para outro;
		 * at : combina um objeto com outro.
		*/

		LocalDateTime testeData_a = LocalDateTime.of(2014,12,15,13,0);
		System.out.println(testeData_a.getDayOfMonth()); // 15
		System.out.println(testeData_a.getDayOfYear()); // 349
		System.out.println(testeData_a.getHour()); // 13
		System.out.println(testeData_a.getMinute()); // 0
		System.out.println(testeData_a.getYear()); // 2014
		System.out.println(testeData_a.getDayOfWeek()); // MONDAY
		System.out.println(testeData_a.getMonthValue()); // 12
		System.out.println(testeData_a.getMonth()); // DECEMBER

		/****************/

		//ChronoField
		LocalDateTime testeData_b = LocalDateTime.of(2014,12,15,13,56);// 15/12/2014 13:56
		System.out.println(testeData_b.get(ChronoField.DAY_OF_MONTH));// 15
		System.out.println(testeData_b.get(ChronoField.DAY_OF_YEAR));// 349
		System.out.println(testeData_b.get(ChronoField.HOUR_OF_DAY));// 13
		System.out.println(testeData_b.get(ChronoField.MINUTE_OF_HOUR));//56
		System.out.println(testeData_b.get(ChronoField.YEAR));// 2014
		System.out.println(testeData_b.get(ChronoField.DAY_OF_WEEK));//(MONDAY)
		System.out.println(testeData_b.get(ChronoField.MONTH_OF_YEAR));// 12
		
		/****************/
		
		/* 
		 * //compile error, method not found.
		LocalDate d = LocalDate.now();
		d.getHour(); //compile error, method not found.
		*/
		
		MonthDay day1 = MonthDay.of(1, 1); //01/jan
		MonthDay day2 = MonthDay.of(1, 2); //02/jan
		System.out.println(day1.isAfter(day2)); //false
		System.out.println(day1.isBefore(day2)); //true
		
		/****************/
		
		LocalDate aprilFools = LocalDate.of(2015, 4, 1);
		LocalDate foolsDay = LocalDate.of(2015, 4, 1);// are equals
		System.out.println(aprilFools.isEqual(foolsDay)); //true 
		// does this object support days?
		System.out.println(aprilFools.isSupported( ChronoField.DAY_OF_MONTH)); //true 
		// does this object supports hours?
		System.out.println(aprilFools.isSupported( ChronoField.HOUR_OF_DAY)); //false
		// Can I make operations with days?
		System.out.println(aprilFools.isSupported(ChronoUnit.DAYS));//true
		// Can I make operations with hours?
		System.out.println(aprilFools.isSupported(ChronoUnit.HOURS));//false
		
		
		/****************/
		
		LocalDate d0 = LocalDate.of(2015, 4, 1); //2015-04-01
		d0 = d0.withDayOfMonth(15).withMonth(3); //chaining
		System.out.println(d0); //2015-03-15
		
		
		//-------//---------//
		//
		LocalDate d6 = LocalDate.of(2013, 9, 7);
		System.out.println(d6); // 2013-09-07
		d6.withMonth(12);//tem que setar para funcionar * exemplo acima.
		System.out.println(d6); // 2013-09-07
		
		/****************/
		
		/*
		 * LocalTime does not have a day of month field.
		LocalTime d = LocalTime.now();
		d.withDayOfMonth(15); // compile error
		*/
		
		
		//plus e minus
		LocalDate d7 = LocalDate.of(2013, 9, 7);
		d7 = d7.plusDays(1).plusMonths(3).minusYears(2);
		System.out.println(d7); // 2011-12-08
		
		/****************/
		
		//ChronoUnit.WEEKS -> para usar dias uso ChronoUnit.DAYS
		LocalDate d5 = LocalDate.of(2013, 9, 7);
		d5 = d5.plusWeeks(3).minus(3, ChronoUnit.WEEKS);
		System.out.println(d5); // 2013-09-07
		
		/****************/
		
		/*
		 * UnsupportedTemporalTypeException :
			LocalDate d = LocalDate.of(2013, 9, 7);
			// UnsupportedTemporalTypeException
			//LocalDate does not support hours!
			d = d.plus(3, ChronoUnit.HOURS);
			System.out.println(d);
		 */
		 
		
		
		//Convertendo entre os diversos tipos de datas
		LocalDateTime now2 = LocalDateTime.now();
		LocalDate dateNow = now2.toLocalDate(); // from datetime to date
		LocalTime timeNow = now2.toLocalTime(); // from datetime to time
		
		/****************/
		
		LocalDateTime now3 = LocalDateTime.now();
		LocalDate dateNow2 = now3.toLocalDate(); // from datetime to date
		LocalTime timeNow2 = now3.toLocalTime(); // from datetime to time
		// from date to datetime
		LocalDateTime nowAtTime1 = dateNow2.atTime(timeNow2);
		// from time to datetime
		LocalDateTime nowAtTime2 = timeNow2.atDate(dateNow2);
		
		
		/****************/
		
		//Antiga API.
		// converter uma java.util.Date em LocalDateTime , usando a timezone padrão do sistema:
		Date d = new Date();
		Instant i = d.toInstant();
		LocalDateTime ldt0 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		
		
		// converter uma java.util.Calendar em LocalDateTime , usando a timezone padrão do sistema:
		Calendar c = Calendar.getInstance();
		Instant i1 = c.toInstant();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(i1, ZoneId.systemDefault());
		
		// converter uma java.time.* em java.util.Date:
		
		Date d2 = new Date();
		Instant i2 = d2.toInstant();
		LocalDateTime ldt1 = LocalDateTime.ofInstant(i2, ZoneId.systemDefault());
		Instant instant = ldt1.toInstant(ZoneOffset.UTC);
		Date date2 = Date.from(instant);
		
		/****************/
		
		
		//Cálculos de intervalo de tempo com datas	
		
		//Calculo envolvendo duas data:
		//Duration, Period e o método between da classe ChronoUnit:
		
		//O exemplo a seguir soma 10 segundos ao instante atual:
		Instant now7 = Instant.now(); // now
		Duration tenSeconds = Duration.ofSeconds(10); // 10 seconds
		Instant t = now7.plus(tenSeconds); // now after 10 seconds
		
		
		//O exemplo mostra como pegar o intervalo em segundos entre dois instantes:
		Instant t1 = Instant.EPOCH; // 01/01/1970 00:00:00
		Instant t2 = Instant.now();
		long secondsSinceEpoch = Duration.between(t1, t2).getSeconds();
		
		
		
		
		//ChronoUnit é uma das classes mais versáteis, pois permite ver a diferença entre duas datas em várias unidades de tempo:
		LocalDate birthday5 = LocalDate.of(1983, 7, 22);
		LocalDate base = LocalDate.of(2014, 12, 25);
		// 31 years total
		System.out.println(ChronoUnit.YEARS.between(birthday5, base));
		// 377 months total
		System.out.println(ChronoUnit.MONTHS.between(birthday5, base));
		// 11479 days total
		System.out.println(ChronoUnit.DAYS.between(birthday5, base));
		
		
		//Classe Period pode ser usada para fazer cálculos de intervalos, quebrando as unidades de tempo do maior para o menor.
		LocalDate birthday2 = LocalDate.of(1983, 7, 22);
		LocalDate base1 = LocalDate.of(2014, 12, 25);
		Period lifeTime = Period.between(birthday2, base1);
		System.out.println(lifeTime.getYears()); // 31 years
		System.out.println(lifeTime.getMonths()); // 5 months
		System.out.println(lifeTime.getDays()); // 3 days
		
		/****************/
		
		//Formatando e convertendo em texto
		//DateTimeFormatter , do pacote java.time.format
		
		
		//formatter.format
		LocalDate birthday3 = LocalDate.of(1983, 7, 22);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		System.out.println(formatter.format(birthday3)); // 1983 07 22
			
		
		
		//birthday.format
		LocalDate birthday4 = LocalDate.of(1983, 7, 22);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy MM dd");
		System.out.println(birthday4.format(formatter1)); // 1983 07 22
		
		
		//DateTimeFormater
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d3 = LocalDate.parse("23/04/1986",formatter2);
		System.out.println(formatter2.format(d3)); // 23/04/1986

		/*
		 * DateTimeParseException
		 
			DateTimeFormatter formatter =
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate d =
			LocalDate.parse("23/15/1986",formatter);
			// throws DateTimeParseException
			System.out.println(formatter.format(d)); // 23/04/1986

		*/

		//11.2 EXPRESSÃO LAMBDA SIMPLES QUE CONSUME UMA LAMBDA PREDICATE		
		//Página 436.
		/*
		regras para se escrever um lambda.
		
		* Lambdas podem ter vários argumentos, como um método. Basta separá-los por , .
		
		* O tipo dos parâmetros pode ser inferido e, assim, omitido da declaração.
		
		* Se não houver nenhum parâmetro, é necessário incluir parênteses vazios, como em:
		Runnable r = () -> System.out.println("a runnable object!");
		
		* Se houver apenas um parâmetro, podemos omitir os parênteses, como em:
		Predicate<Person> matcher = p -> p.getAge() >= 18;
		
		* O corpo do lambda pode conter várias instruções, assim como um método.
		
		* Se houver apenas uma instrução, podemos omitir as chaves, como em:
		Predicate<Person> matcher = p -> p.getAge() >= 18;
		
		* Se houver mais de uma instrução, é necessário delimitar o corpo do lambda com chaves, como em:
		Runnable r = () -> { int a = 10; int b = 20; System.out.println(a + b); }

		Lambdas só podem interagir com variáveis locais caso estas estejam marcadas como final (uma referência imutável), ou que sejam efetivamente final
		
		* O parametro de uma lambda não pode ser o mesmo de uma váriavel LOCAL:
		int a = 0;
		Predicate<String> lam1 = (a) -> a > 10;
		
		*/

		int a1 = 0;
		Predicate<Integer> d4 = a -> a > 0; // problema ao usar parametro lambda e variavel local igual.
		if(d4.test(a1)){ // B
			System.out.println(a1);
		}

		
		
		
		
		
		System.out.println("OK");
	}
}