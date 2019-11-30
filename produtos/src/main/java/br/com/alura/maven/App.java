package br.com.alura.maven;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static void main(String[] args) {

		// mvn surefire-report:report para gerar um relatorio

		// o atalho "Ctrl + 3" , o que abrirá o "Quick Access do Eclipse". Digite "IEMP"
		// (Import Existing Maven Projects) e pressione "Enter".
		Produto produto = new Produto("Bala juquinha sabor tangerina", 0.15);

		System.out.println("A bala que eu gosto é: " + produto.getNome() + "e custa " + produto.getPreco());

		// mvn verify - ultima fase
		System.out.println("Hello World!");

	}
}

/*
 * <project> <!-- ... --> <build> <plugins> <plugin>
 * <groupId>org.apache.maven.plugins</groupId>
 * <artifactId>maven-pmd-plugin</artifactId> <version>3.10.0</version>
 * <executions> <execution> <phase>verify</phase> <goals> <goal>check</goal>
 * </goals> </execution> </executions> </plugin> </plugins> </build> <!-- ...
 * --> </project>
 */