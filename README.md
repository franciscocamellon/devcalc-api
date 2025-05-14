# DevCalc

**DevCalc** é uma API REST desenvolvida em **Java 21** com **Spring Boot**, que fornece operações matemáticas básicas como adição, subtração, multiplicação e divisão. Este projeto tem como objetivo servir de base para a implementação de pipelines automatizados de **CI/CD** com **GitHub Actions**, abordando etapas como verificação de código, testes automatizados, build, empacotamento e simulação de deploy.

## 🎯 Objetivo

O projeto foi desenvolvido como parte de um estudo prático sobre automação de processos de desenvolvimento com CI/CD, aplicando boas práticas de engenharia de software, testes e documentação de APIs REST.

## 🛠️ Tecnologias Utilizadas

- Java 22
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

- Java 21 instalado
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

