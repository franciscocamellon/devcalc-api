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

---

## 📚 TP3 – Entrega Final DevCalc CI/CD

Este projeto passou por uma evolução completa com foco em práticas modernas de integração e entrega contínua. Abaixo está um resumo das seis etapas da entrega TP3:

### ✅ Etapa 1 – Runner Auto-Hospedado

Foi configurado um runner local (Windows) e associado ao repositório da DevCalc. Um workflow simples (`self-hosted-runner.yml`) foi criado com o uso de `runs-on: self-hosted`, demonstrando execução local com comandos como `systeminfo`, `java -version` e instalação de utilitários com `choco`.

### ✅ Etapa 2 – Uso de Variáveis e Segredos

Foram criadas variáveis (`APP_MODE`, `SUPPORT_EMAIL`) e o segredo `PROD_TOKEN` nas configurações do repositório. O workflow `using-vars-secrets.yml` mostra como acessá-los usando os contextos `${{ vars.NOME }}` e `${{ secrets.NOME }}` com injeção via `env:`.

### ✅ Etapa 3 – Escopos de Variáveis de Ambiente

O workflow `env-context-demo.yml` demonstra a definição e sobreposição de variáveis nos níveis de workflow, job e step, além da leitura dos contextos `github.actor` e `runner.os`, permitindo compreender claramente o comportamento hierárquico de variáveis no GitHub Actions.

### ✅ Etapa 4 – Permissões e Uso do GITHUB_TOKEN

O workflow `deploy-check.yml` verifica o status do deploy e, caso falhe, chama o reusable workflow `create-issue.yml` que cria uma issue automaticamente no repositório. O uso explícito do `GITHUB_TOKEN` com permissão `issues: write` foi configurado e documentado.

### ✅ Etapa 5 – Ambientes Dev e Prod com Environments

Dois ambientes distintos foram configurados no GitHub:
- **development**: liberação automática e variável `API_URL`.
- **production**: exige aprovação manual e contém o segredo `PROD_API_KEY`.

Os workflows `deploy-dev.yml` e `deploy-prod.yml` executam deploys simulados com base nas branches `dev` e `main`, respectivamente, utilizando a estrutura de environments do GitHub.

### ✅ Etapa 6 – Nova Funcionalidade na API

Foi implementado o endpoint `GET /sqrt?x=16` que retorna a raiz quadrada do número informado. A funcionalidade foi integrada na classe de serviço, coberta com novos testes automatizados e verificada no pipeline de integração contínua.

---

### ▶️ Executando os novos workflows

1. **Runner auto-hospedado**: edite e execute `self-hosted-runner.yml` com `runs-on: self-hosted`.
2. **Variáveis/Segredos**: rode manualmente `using-vars-secrets.yml` via **Actions > Run workflow**.
3. **Contexto de variáveis**: acione manualmente `env-context-demo.yml` para observar os escopos.
4. **Criação de issue automática**: execute `deploy-check.yml` com falha simulada no deploy.
5. **Deploy para Dev**: faça um push na branch `dev`.
6. **Deploy para Prod**: faça um push na branch `main` e aprove o ambiente no GitHub UI.

