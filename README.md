# Conversor de Moedas em JavaFX

> Projeto de conversão de moedas em tempo real utilizando Java, JavaFX para interface gráfica e integração com API de cotações.

## 📚 Sobre o projeto

Este é um projeto desenvolvido para praticar conceitos de:
- Programação orientada a objetos em Java
- Consumo de APIs externas (requisições HTTP)
- Desserialização de dados JSON usando Gson
- Criação de interface gráfica usando **JavaFX + Scene Builder**
- Arquitetura baseada em MVC (Model-View-Controller)

A aplicação permite converter valores entre diferentes moedas, utilizando cotações atualizadas em tempo real.

## 🎯 Funcionalidades

- Conversão entre no mínimo 6 pares de moedas
- Busca de taxas de câmbio utilizando a API **Extended Rate**
- Interface gráfica amigável (JavaFX)
- Interação simples e direta com o usuário
- Cálculo e exibição do valor convertido

## 🛠️ Tecnologias utilizadas

- Java 17+
- JavaFX
- Gson
- API Extended Rate (https://exchangerate-api.com/)
- Maven

## 🏗️ Estrutura do projeto (MVC)

```
conversor-moedas-java/
├── LICENSE
├── pom.xml
├── README.md
src
├── main
│   ├── java
│   │   └── com
│   │       └── github
│   │           └── lucas
│   │               ├── client
│   │               ├── controller
│   │               ├── model
│   │               ├── util
│   │               ├── view
│   │               └── Main.java
│   └── resources
```

## 🚀 Como executar o projeto

### Pré-requisitos:
- JDK 17 ou superior instalado
- IDE com suporte a JavaFX
- Conta criada na **Extended Rate** para gerar sua **API Key**

### Rodando o projeto:
1. Clone o repositório:
   ```bash
   git clone https://github.com/Like-a-stone/conversor-moedas-java.git
   ```
2. Abra o projeto na sua IDE.
3. Configure o JavaFX (caso necessário).
4. Insira sua **API Key** no arquivo de configuração/API Client.
5. Rode a aplicação (`Adicao Futura`).

## 📄 Licença

Este projeto está licenciado sob a licença **MIT**.  
Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
