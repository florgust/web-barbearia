# Web Barbearia

Sistema completo para gestão de barbearia, incluindo agendamento de serviços, cadastro de pessoas, controle de atendimentos e administração de serviços. Desenvolvido com Java, Spring Boot, Thymeleaf, PostgreSQL e ferramentas modernas de frontend.

---

## Índice

1. [Visão Geral](#visão-geral)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Estrutura e Arquitetura](#estrutura-e-arquitetura)
4. [Instalação e Execução](#instalação-e-execução)
5. [Documentação da API](#documentação-da-api)
6. [Boas Práticas](#boas-práticas)
7. [Licença](#licença)

---

## Visão Geral

O Web Barbearia é um sistema web para gerenciamento de barbearias, permitindo:
- Cadastro e edição de pessoas (clientes e funcionários)
- Cadastro, edição e remoção de serviços
- Agendamento de horários com controle de disponibilidade
- Visualização de atendimentos realizados
- Interface moderna, responsiva e intuitiva

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4** (Web, Data JPA, Thymeleaf)
- **Thymeleaf** (templates dinâmicos)
- **PostgreSQL** (banco de dados relacional)
- **Flyway** (migração e versionamento do banco)
- **Log4j2** (logs)
- **Lombok** (redução de boilerplate Java)
- **Tailwind CSS** (estilização utilitária)
- **Bootstrap 5** (componentes prontos e responsividade)
- **pnpm** (gerenciador de pacotes frontend)
- **Maven** (build e dependências Java)

---

## Estrutura e Arquitetura

O projeto segue a arquitetura MVC (Model-View-Controller) e está organizado da seguinte forma:

```text
web-barbearia/
├── package.json
├── pnpm-lock.yaml
├── pom.xml
├── postcss.config.js
├── tailwind.config.js
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── com/web/barbearia/
│       │       ├── BarbeariaApplication.java   # Classe principal Spring Boot
│       │       ├── controller/                 # Controllers (camada C do MVC)
│       │       ├── model/                      # Entidades JPA (camada M)
│       │       ├── repository/                 # Repositórios JPA
│       │       ├── service/                    # Serviços de negócio
│       │       └── ...                         # Outras utilidades/configurações
│       ├── resources/
│       │   ├── application.yml                 # Configurações Spring Boot
│       │   ├── log4j2-spring.xml               # Configuração de logs
│       │   ├── db/migration/                   # Scripts Flyway (migrations)
│       │   ├── static/
│       │   │   ├── css/                        # CSS customizado, Tailwind, Bootstrap
│       │   │   ├── js/                         # Scripts JS
│       │   │   └── images/                     # Imagens do sistema
│       │   └── templates/                      # Views Thymeleaf (camada V)
│       │       ├── barbearia.html
│       │       ├── agendar/
│       │       ├── pessoas/
│       │       ├── servicos/
│       │       └── ...
│       └── test/
│           └── java/com/web/barbearia/         # Testes automatizados
└── target/                                     # Arquivos gerados pelo build
```

---

## Instalação e Execução

### Pré-requisitos

- Java 21+
- Maven 3.8+
- PostgreSQL 13+
- pnpm (opcional, para frontend)

### Variáveis de Ambiente

Configure o acesso ao banco em `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: "0001"
```

### Instalação das Dependências

```bash
# Instale as dependências Java
mvn clean install

# (Opcional) Instale dependências frontend
pnpm install
```

### Migrações do Banco de Dados

As migrations são executadas automaticamente pelo Flyway ao iniciar a aplicação. Os scripts estão em `src/main/resources/db/migration/`.

### Execução do Projeto

```bash
# Execute a aplicação Spring Boot
mvn spring-boot:run

# Ou gere o .jar e execute
mvn clean package
java -jar target/barbearia-0.0.1-SNAPSHOT.jar
```

O sistema estará disponível em: http://localhost:8080

---

## Documentação da API

O sistema é orientado a views (MVC), mas se houver endpoints REST, eles podem ser acessados via controllers. Para documentação automática, recomenda-se integrar o Swagger (não incluso por padrão).

---

## Boas Práticas Adotadas

- Arquitetura MVC clara (separação de responsabilidades)
- Uso de templates dinâmicos com Thymeleaf
- Mapeamento objeto-relacional com JPA/Hibernate
- Versionamento de banco com Flyway
- Logs estruturados com Log4j2
- Estilização responsiva e customizada (Tailwind + Bootstrap)
- Código limpo e reaproveitamento com Lombok
- Organização de assets (CSS, JS, imagens)
- Scripts de build e dependências bem definidos

---

## Licença

Este projeto está licenciado sob a licença MIT.