![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)


# Gestão de Formação Educacional em Kotlin

Este projeto implementa um sistema para gerenciar formações educacionais, permitindo a criação de conteúdos de ensino, matrícula de alunos e visualização de informações detalhadas sobre as formações.

## Estrutura e Design

#### Classes e Tipos de Dados

- **Nivel (Enum):** Define os níveis de dificuldade dos cursos (Básico, Intermediário, Difícil).
- **Usuario (Data Class):** Representa os alunos, com validação de dados para garantir nomes válidos e IDs positivos.
- **ConteudoEducacional (Data Class):** Armazena informações dos conteúdos das formações, incluindo nome, duração e nível, com validação para duração positiva.
- **Formacao (Data Class):** Agrupa `ConteudosEducacionais` e gerencia uma lista de `Usuarios` inscritos.

#### Validação de Entrada de Dados

- Utilização de `require` para assegurar dados consistentes e válidos.

#### Lazy Initialization

- Uso do `by lazy` para calcular a duração total dos cursos de forma eficiente.

## Funcionalidades Implementadas

- `Matrícula de Alunos`: Permite adicionar alunos às formações, com verificação contra matrículas duplicadas.

- `Visualização Detalhada da Formação`: `getAllFormacaoData` exibe informações completas sobre a formação, incluindo conteúdos educacionais e alunos matriculados.

## Vantagens

- `Clareza e Legibilidade`: Código bem estruturado, facilitando a compreensão e manutenção.

- `Reutilização e Manutenibilidade`: Classes facilmente reutilizáveis e extensíveis.

- `Verificação de Dados Robusta`: Validção robusta nos construtores para garantir a integridade dos dados.


### ⌨ Clone

Para utilizá-lo, é necessário clonar o repositório.

```bash
    %sh 
    git clone https://github.com/JuanCampbsi/aprenda-kotlin-com-exemplos-lab
```

### ⌨ play.kotlinlang.org
Para rodar o projeto direto no playground do kotlin basta clicar no link abaixo.

-   [PlayGround Kotlinlang](https://pl.kotl.in/dBT6SHI3a) - version JVM 1.9.20


👨‍💻 **Author** 💻

Developed by [_Juan Campos_](https://www.linkedin.com/in/juancampos-ferreira/)