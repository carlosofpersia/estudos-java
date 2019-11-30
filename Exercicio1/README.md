

Sexta: Inicio do projeto

Comecei 23:26 e parei 03:30

Criei um projeto no Maven, com um Skeleton Simples;
Configurei o JUNIT;



Chamei nossa classe de GeradorObservacaoBusiness para separar as camadas para ficar mais fácil o entendimento do que ela representa.
Apesar que ela parece uma Utils, mas vamos ver até o final.



Criei uma classe para testar a funcionalidade via pelo main (CLI ou Application)
Criei uma Classe de Teste.


Copiei a Classe que me passaram para refatorar.

Começando a fatoração primeira coisa que fiz foi tirar o condicional para verificar se existe os números da Listagem. 
Isso se encaixa nas "DRY, YAGNI e SOLID. E padrões como: DDD e Clean Architecture"

Ajustei o codigo para o geraObservacao funcionar em uma linha, isso tudo testando com testes unitários:

Feito isso fui para o próximo passo trabalhar no método retornaCodigos, este estava com muitas responsábilidades

decidi que o geraObservacao deveria finalizar o chamado e não o retornar código, retirei o texto e criei também um méetodo isPlural para auxiliar
a decisão do texto se plural ou singular.


Feito isso resolvi dar uma lida novamente nos requisitos e vi que o cliente propos alterações, daí tive que repensar minha solução sem alterar o 
comportamento já existente no sistema, e agora.


Fiz uma sobrecarga nos métodos principais geraObservacao e retornaCodigos, agora o sistema ficou dinamico e ainda aproveitei o que já havia desenvolvido.

Decidi colocar os textos em uma classe privada dentro do nosso projeto pois não achei necessário criar um resource nesse momento.


