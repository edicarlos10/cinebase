# Apresentação
No link a seguir, segue meu site com breve apresentação e contatos.

https://edicarlos.dev.br/
# O Projeto - Cinebase
Aplicativo que consume API do TMDB (The Movie Database) simulando uma **NetFlix**.
A Api tem vários endpoints, uma das mais completas da internet, onde pode ser criado um app gigante.  

A documentação [TMDB](https://developer.themoviedb.org/reference/intro/getting-started)

Foi demonstrado como criar um APP Android usando **Kotlin e Arquitetura limpa + Conceitos de SOLID**.
Irá existir uma home onde serão carregado listagem de filmes separado por seções, com possibilidade de pesquisa.
Irá existir uma página de detalhes, favoritos e profile.

# Como rodar
Apenas clone o projeto, e sync o gradle via Android Studio.

E, crie um conta na [TMDB](https://developer.themoviedb.org/) habilitando uma **Key** para ser usada nas requisições.
Essa key deve ser inserida no arquivo **ICineApiClient**. Futuramente será movido para o local.properties.

Não deverá ter problemas.
# Arquitetura e Tecnologias
A estrutura está **bem sólida**, e a arquitetura está bem definida.

Seguindo com:
- **Clean Architecture, Conceitos de SOLID**
- **MVVM, Flow**
- **Kotlin como linguagem de programação**
- **Retrofit para trabalhar com a API**
- **Hilt para DI**
- **Coil compose para carregamento de imagens**
- **Mockito para testes automatizados**
- **Corrotinas para eventos assincronos**
- **JetPack Compose para UI**

Outros detalhes podem ser _conferidos nos arquivos do projeto._ 
# Oque faltou
- Melhorar a parte visual
- Melhoria de ações em alguns botões da bottom bar
- Implementar o endpoint de search
- Implementar o endpoint de favotitar
- Implementar o endpoint de detalhes
- Implementar a seção de profile
- Fazer a paginação da listagem

# Melhorias
Algumas melhorias _deverão ser feitas:_

- Melhoraria de UI
- Implementar endpoints
- Inserir icone
- Inserir uma Splash
- Integração com as actions do gitHub (rodar lint, unit testes por ex)


Abaixo, segue um exemplo de como poderá ser a UI

[Link de UI](https://www.behance.net/gallery/9650557/iOS7-Weather-App)

# Testes
Testes unitários foram criados para a camada de Network e Domain. Elas englobam:
- Remote data
- Repository
- Use Cases

Para executar os testes basta abrir o arquivo pelo android studio e apertar na flecha verde do inicio da classe de teste.

# Prints de tela


# Licensa
O código pode ser usado livremente, **isentando o autor** de qualquer responsabilidade de seu uso.
