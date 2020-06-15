
-  Simplicidade e Clareza: Valorizamos um código de boa qualidade, que seja simples, fácil de ler, entender e alterar, ou seja, simplicidade, clareza e organização do código é essencial.

- Orientação a objetos: O design orientado a objetos também é uma característica importante que verificaremos. Buscamos aplicar em nosso dia a dia bons princípios como: DRY, YAGNI e SOLID. E padrões como: DDD e Clean Architecture. Então se ligue nisso, pois será um diferencial!

- Automação de Testes: Cobertura de testes automatizados é imprescindível para garantirmos a qualidade e produtividade na manutenção e evolução do software. Por isso, também avaliaremos os testes.

- Compartilhar decisões tomadas: Inclua um arquivo chamado README.md com as instruções, compartilhando as decisões e escolhas tomadas para melhor entendimento do seu raciocínio.

Não esperamos e não vamos analisar as seguintes questões de código: persistência em banco de dados ou arquivo, front-end ou iteração com console. Por outro lado, separação de classes e pacotes é algo esperado e que será considerado na implementação.


--------------------------------------------------------


Sexta: Inicio do projeto

Comecei 23:26 e parei 03:30 da Sexta
Fiz algumas brincadeiras domingo de 19h as 22h.

Criei um projeto no Maven, com um Skeleton Simples;
Configurei o JUNIT;

Para ligar o projeto basta ter o Maven e dar uma olhada, as Classes Centrais são br.com.softplan.GeradorObservacaoNumeros, br.com.softplan.GeradorObservacaoValores 

Chamei nossa classe de br.com.softplan.business.GeradorObservacao para separar as camadas para ficar mais fácil o entendimento do que ela representa.

Apesar que ela parece uma Utils, mas vamos ver até o final.

Começando a refatoração primeira coisa que fiz foi tirar o condicional para verificar se existe os números da Listagem. 
Isso se encaixa nas "DRY, YAGNI e SOLID. E padrões como: DDD e Clean Architecture"

Após terminar a refatoração percebi que além do que a classe já fazia ela precisava fazer a funcionalidade de Valores funcionar.

Como eu lembrei depois da parte dos valores, eu refatorei novamente a classe para poder renderizar os valores no resultado.

Essa foi a minha primeira decisão, eu precisava refatorar para retornar os valores, sem ter que mudar a forma de uso, então eu decidi fazer as duas formas funcionarem. criei assim uma inteligencia com sobrecarga de metodos isso tudo em br.com.softplan.business.GeradorObservacao

agora se eu passar os parametros List ele retorna sómente os números, se eu passar um Map ele me retornar a funcionalidade de valores, a classe ficou inteligente e funcional, mas agora ela ficou muito cheia de responsabilidades, então separei a classe que usa o List(Numeros) para a que usa Map (Valores).

Agora começou a ficar melhor, mais limpo, pois cada Classe ficou menor e com responsabilidade bem definida, nesse tempo tudo ok, mas eu queria usar essa funcionalidade de forma mais inteligente, então utilizei os poderes do padrão Strategy que serve para criar o objeto que eu espero e brinquei um pouco com o polimorfismo.

Talvez eu tenha brincado um pouco demais, mas ficou muito legal a implementação, criei tudo com testes unitários e criei também uma classe resource para testar a aplicação direto.

Criei também algumas classes para organizar melhor a estrutura proposta, como uma classe para colocar as Constantes e uma Util para metodos estáticos.

A solução uma vez decidida a programação foi rápida, poderia ter usado mais recursos, como padrões criadores, Exceptions, mas não vi necessidade para esse Exemplo1.









