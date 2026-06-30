<div align="center">

# Livraria Alquimia

### Conhecimento que Transforma

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen?style=flat-square)]()
[![License](https://img.shields.io/badge/license-MIT-blue?style=flat-square)]()
[![Generation Brasil](https://img.shields.io/badge/Generation%20Brasil-Bootcamp-purple?style=flat-square)]()

Sistema de e-commerce para uma livraria virtual, desenvolvido inteiramente em **Java**, rodando via **Console (Terminal)**.

</div>

---

## Sumário

- [Sobre o Projeto](#sobre-o-projeto)
- [Demonstração](#demonstração-do-sistema)
- [Funcionalidades](#funcionalidades-do-sistema)
- [Tecnologias e Conceitos](#tecnologias-e-conceitos-utilizados)
- [Como Rodar o Projeto](#como-rodar-o-projeto-no-seu-computador)
- [Autora](#autora)

---

## Sobre o Projeto

Seja muito bem-vindo(a) ao repositório da **Livraria Alquimia**!

Este projeto foi construído com muito carinho, lógica e café durante o **Bootcamp da Generation Brasil**, servindo como o projeto final de avaliação do **Bloco 1**.

---

## Demonstração do Sistema

> **Dica:** suba um print do seu console rodando com o nome `print_menu.png` na pasta principal do repositório para que ele apareça automaticamente aqui.

```
![Demonstração do menu](print_menu.png)
```

---

## Funcionalidades do Sistema

O sistema é um **CRUD completo** para gerenciar livros, além de contar com ferramentas inteligentes de busca e benefícios especiais:

| Funcionalidade | Descrição |
|---|---|
| **Listagem Completa** | Visualize todos os livros disponíveis com seus respectivos detalhes (Título, Autor, Gênero e Preço) |
| **Busca Inteligente por ID** | Encontre rapidamente qualquer produto informando o seu código identificador |
| **Busca por Título** | Localize livros mesmo informando apenas parte do título |
| **Busca por Autor/Autora** | Filtre os resultados pelo nome do(a) autor(a) |
| **Busca por Gênero Literário** | Filtre os resultados pelo gênero do livro |
| **Gerenciamento de Estoque** | Cadastre novos livros, atualize dados existentes e delete produtos fora de circulação |
| **Cupons de Desconto** | Aplique cupons ativos (`BEMVINDO10`, `LEITOR20`, `PROMO50`) para descontos percentuais em livros selecionados |

---

## Tecnologias e Conceitos Utilizados

Para estruturar este projeto de forma robusta e limpa, foram aplicados conceitos avançados de **Programação Orientada a Objetos (POO)** em Java:

- **Linguagem:** Java (Versão 17+)
- **Arquitetura:** Padrão **MVC** (Model-View-Controller), mantendo as responsabilidades separadas e o código organizado
- **Abstração e Herança:** Classe abstrata mãe `Produto`, herdada pela classe específica `Livro`
- **Interfaces (Contratos):** Uso da interface `Repository` para definir os comportamentos obrigatórios de manipulação de dados
- **Java Collections:** `ArrayList` para gerenciar a lista de livros e `HashMap` para armazenar a tabela de cupons ativos de forma eficiente
- **Tratamento de Exceções:** Exceções personalizadas (`LivrariaException`, `BuscaSemResultadoException`, `CupomInvalidoException`) para guiar o usuário com mensagens amigáveis em vez de travar o programa
- **Controle de Versão:** Git e GitHub organizados através de branches estruturadas (`01_Menu`, `02_Model_Repository`, `03_Controller`)

---

## Como Rodar o Projeto no seu Computador

Caso queira testar a Livraria Alquimia localmente, siga estes passos:

**1.** Certifique-se de ter o **Java JDK 17** ou superior instalado na sua máquina.

**2.** Clone este repositório no seu terminal:

```bash
git clone https://github.com/luizavpg-bit/projeto_livraria_alquimia.git
```

**3.** Abra a sua IDE preferida (Eclipse, Spring Tool Suite ou VS Code).

**4.** Importe o projeto como um **Existing Java Project**.

**5.** Abra o arquivo `Menu.java`, localizado em:

```
src/livraria_virtual/Menu.java
```

**6.** Clique com o botão direito e selecione:

```
Run As > Java Application
```

---

## Autora

Este projeto foi desenvolvido por:

**Luiza Valentina**

[![GitHub](https://img.shields.io/badge/GitHub-%40luizavpg--bit-181717?style=flat-square&logo=github)](https://github.com/luizavpg-bit)

Bootcamp de Desenvolvimento Web Full Stack — **Generation Brasil** (Turma Java-85)

<div align="center">

---

### Livraria Alquimia: Conhecimento que transforma!

</div>
