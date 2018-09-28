package br.com.certificacao.aula08;

public class Exercicio1 {

	Exercicio1() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("1 - Diferencie entre exceções do tipo checked, runtime e erros");
	}

	public static void main (String[] args) {

		/*

		Throwable - Topo da hierarquia de erros do java.
		
			* Error (OutOfMemoryError)
				- Situações extremas, o programa não se recupera
			
			* Exception (SQLException)
				- RuntimeException
					- fILHAS DE RuntimeException SÃO UNCHECKED
					- NullPointerException
					- IndexOutOfBoundsException
				- Todas as classes IRMÃS DE RuntimeException são CHECKED, O COMPILADOR OBRIGA A FAZER UM TRATAMENTO.

				OBS: Exception
				- Checked (Exception - Não é fácil evitar, are the exceptions that are checked at compile time, Checked exceptions são utilizadas para erros recuperáveis .)
				- Unchecked (FILHOS DE Error, RuntimeException  - Erros mais simples de serem evitados, com tipos de checagem. Não é obrigatório o tratamento da mesma, Unchecked exceptions são utilizadas para erros irrecuperáveis )

		*/
	
		Exercicio1 e = new Exercicio1();

		System.out.println("Aula08.Exercicio1");
	}	
}


/*

//Listagem 2: Exemplo real de um Checked Exception
private void criaArquivo(String pathAlternativo) {
        File arquivo = null;
        try {
             
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
             
            if (pathAlternativo.equals(""))
                arquivo = new File("/home/admin/Documentos/arquivo_" + fmt.format(new Date()) );
            else
                arquivo = new File(pathAlternativo+"arquivo_" + fmt.format(new Date()) );
             
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
            writer.write("Linha 001");
            writer.close();
        } catch (IOException e ) {
            if (arquivo != null){
                if (arquivo.exists()){
                    arquivo.delete();
                    criaArquivo("/home/admin/PathAlternativo/");
                }
            }
        }
    }

*/