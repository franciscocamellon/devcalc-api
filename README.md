# DevCalc – API REST com CI/CD
![CI Status](https://github.com/franciscocamellon/devcalc-api/actions/workflows/deploy-dev.yml/badge.svg)
![CI Status](https://github.com/franciscocamellon/devcalc-api/actions/workflows/deploy-prod.yml/badge.svg)

**DevCalc** é uma API REST escrita em **Java 22** com **Spring Boot**, que realiza operações matemáticas básicas: adição, subtração, multiplicação e divisão.

O projeto serve como base para estudos práticos de **CI/CD com GitHub Actions**, contemplando etapas como: build, testes, empacotamento (.jar) e simulação de deploy.

---

## 📌 Objetivo

Demonstrar na prática a automação do ciclo de desenvolvimento usando GitHub Actions, aplicando boas práticas de engenharia de software.

---

## 🛠️ Tecnologias Utilizadas

- Java 22 - (Amazon Corretto 22)
- Spring Boot
- JUnit 5
- Swagger/OpenAPI (via Springdoc)
- Maven (build e gerenciamento de dependências)
- GitHub Actions (CI/CD)

## 📁 Estrutura do Projeto

```
devcalc/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── devcalc/
│   │               └── <código da aplicação>
│   └── test/
│       └── java/
│           └── com/
│               └── devcalc/
│                   └── <testes automatizados>
├── .github/
│   └── workflows/
│       └── <arquivos de workflow>
├── pom.xml
└── README.md
```

## 🚀 Como Executar Localmente

### ✅ Pré-requisitos

- Java 22 instalado
- Maven 3.8 ou superior

### ▶️ Passos

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/devcalc.git
cd devcalc
```

2. Execute a aplicação com Maven:

```
mvn spring-boot:run
```

3. A API estará disponível em:

```
http://localhost:8080
```

4. A documentação Swagger estará disponível em:

```
http://localhost:8080/swagger-ui.html
```

## 📌 Exemplos de Endpoints

- `GET /api/add?a=5&b=3` → `8`
- `GET /api/sub?a=10&b=4` → `6`
- `GET /api/mul?a=2&b=7` → `14`
- `GET /api/div?a=20&b=5` → `4`

## 🚀 CI/CD com GitHub Actions



### 🔁 Gatilhos configurados

- `push` na branch `main`
- `pull_request` com alterações no diretório `src/`
- Execução manual via `workflow_dispatch`

### ⚙️ Workflows implementados

| Job        | Descrição                                      |
|------------|-----------------------------------------------|
| **checkout** | Faz o checkout do repositório                 |
| **build**    | Compila o projeto com `mvn clean install`     |
| **test**     | Executa os testes automatizados com JUnit     |
| **package**  | Gera o arquivo `.jar` com `mvn package`       |
| **deploy**   | Simula deploy com uma mensagem de sucesso     |

---

## ✅ Exemplos de uso

### Execução automática por Pull Request

Ao abrir um **pull request** com alterações em arquivos dentro da pasta `src/`, o pipeline é acionado automaticamente.

### Execução manual pela interface

1. Acesse a aba **Actions** no GitHub.
2. Selecione o workflow `CI Pipeline`.
3. Clique em **Run workflow**, selecione a branch e execute.

### 🛠️ Diagnóstico de erro no pipeline

Durante os testes de integração contínua, foi inserido um erro proposital em um dos steps do pipeline para simular uma falha (comando inexistente `comando_inexistente`).

A falha foi identificada na aba **Actions** do GitHub, acessando o log do job que falhou. Através dos logs detalhados do step, foi possível localizar a mensagem de erro: `command not found`.

Após a identificação, o erro foi corrigido substituindo o comando inválido por um comando correto. A nova execução do workflow confirmou a correção com status ✅.

### 📈 Observações sobre execução automática vs manual

Durante os testes, foram realizadas duas execuções do pipeline: uma automática via `push` na branch `main`, e outra manual através do botão "Run workflow". Na execução automática, o pipeline foi acionado imediatamente após o push, sem intervenção do usuário. Já na execução manual, foi possível escolher quais etapas deveriam ser executadas, por meio dos parâmetros `run_tests` e `run_lint`.

Essa flexibilidade é útil para casos em que o desenvolvedor deseja validar apenas partes específicas da aplicação. Além disso, a aba Actions do GitHub permite diferenciar claramente os gatilhos usados e visualizar os logs detalhados de cada execução.