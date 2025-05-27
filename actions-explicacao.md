# Explicação: Workflows vs Actions no GitHub Actions

## Diferença entre Workflows e Actions

**Workflows** e **Actions** são dois conceitos fundamentais no GitHub Actions:

- **Workflow** é um conjunto de processos automatizados definidos por um arquivo YAML localizado em `.github/workflows/`. Ele descreve **quando** e **como** os jobs devem ser executados (por exemplo: após um push na branch `main`).

- **Action** é uma **unidade reutilizável** de código que realiza uma tarefa específica dentro de um workflow (ex: checkout de código, configuração de ambiente, execução de testes). Uma action pode ser criada por você, pela comunidade ou pelo próprio GitHub.

**Resumo:**  
> O workflow organiza e executa ações. A action executa uma tarefa específica.

---

## Estrutura interna de uma Action

Uma action é um repositório que contém um arquivo chamado `action.yml` (ou `action.yaml`) na raiz. Esse arquivo define:

- **`name`**: Nome da action
- **`inputs`**: Parâmetros que a action pode receber
- **`outputs`**: Valores que a action pode retornar
- **`runs`**: Comandos que a action executa (via shell script, Docker ou JavaScript)

### Exemplo (resumido) de um `action.yml`:

```yaml
name: Checkstyle Java Action
description: Run Checkstyle and report violations
inputs:
  checkstyle_config:
    description: Caminho para o arquivo de configuração
    required: true
  github_token:
    description: Token para autenticação
    required: true
runs:
  using: docker
  image: Dockerfile
```

---

## Exemplo prático: `dbelyaev/action-checkstyle`

Essa action foi usada no projeto para verificar o estilo de código Java com base no Google Style Guide.

### Como ela é chamada no workflow

```yaml
- name: Rodar Checkstyle via Action externa
  uses: dbelyaev/action-checkstyle@v1.20.0
  with:
    github_token: ${{ secrets.GITHUB_TOKEN }}
    checkstyle_config: google_checks.xml
    level: warning
```

### Explicação:

- **`uses:`** define qual action está sendo utilizada (`dbelyaev/action-checkstyle` na versão `v1.20.0`)
- **`with:`** passa os parâmetros definidos no `action.yml` da action:
  - `github_token`: token padrão do GitHub Actions usado para autenticação segura.
  - `checkstyle_config`: caminho para o arquivo `google_checks.xml`, que define as regras de estilo.
  - `level`: define o nível de severidade dos avisos (ex: `warning`).

---

## Conclusão

- **Workflows** definem o *quando* e o *como*.
- **Actions** definem o *o quê* será feito.
- O arquivo `action.yml` é o coração de uma action — ele define os parâmetros esperados e os comandos executados.
- Usar actions externas facilita a reutilização e o profissionalismo dos pipelines, como demonstrado no uso da `action-checkstyle`.
