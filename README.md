# Ignição Spring Rest
Este projeto (AlgaTransito) simula uma aplicação de trânsito para gerenciar as autuações dos veículos por um agente.

### Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring JPA
- MySQL
- Flyway
- Maven

## Instruções de Instalação

### Pre Requisitos
- Java 17+
- Maven
- MySQL

### Instalação

1. Clone o repositório
   
```bash
  git clone https://github.com/ClebersonCosta/ignicao-spring-rest.git
```

2. Configure sua senha do banco de dados no arquivo 'application.properties'

```bash
  spring.datasource.url=jdbc:mysql://localhost/algatransito?createDatabaseIfNotExist=true&serverTimezone=UTC
  spring.datasource.username=root
  spring.datasource.password={SUA SENHA AQUI}
```

3. Instale as dependências do maven

```bash
  mvn install
```

4. Gere o JAR do projeto

```bash
  mvn clean package
```

5. Rode o JAR gerado

```bash
  java -jar target/algatransito-api-0.0.1-SNAPSHOT.jar
```

# API Endpoints
<br>

## Entidade Proprietário

## GET /proprietarios

**Descrição:** retorna um JSON com uma lista dos proprietários dos veículos
```json
{
    "id": 1,
    "nome": "João da Silva",
    "email": "joaodasilva@algaworks.com.br",
    "telefone": "11 99999-9999"
},
{
    "id": 2,
    "nome": "Maria dos Santos",
    "email": "maria@algaworks.com.br",
    "telefone": "11 99999-8888"
}
```

## GET /proprietarios/{id}

**Descrição:** retorna um JSON com dados do proprietário conforme id
```json
{
    "id": 1,
    "nome": "João da Silva",
    "email": "joaodasilva@algaworks.com.br",
    "telefone": "11 99999-9999"
}
```

## POST /proprietarios

**Descrição:** insere um novo proprietário de veículo
```json
{
    "nome": "Manoel",
    "email": "manoel@algaworks.com.br",
    "telefone": "34 91234-5678"
}
```

## PUT /proprietarios/{id}

**Descrição:** atualiza o dados do proprietário conforme id
```json
{
    "nome": "Manoel",
    "email": "manoel@algaworks.com.br",
    "telefone": "34 91234-5678"
}
```

## DELETE /proprietarios/{id}

**Descrição:** remove o proprietário conforme id
<br>
<br>

## Entidade Veículo

## GET /veiculos

**Descrição:** retorna um JSON com uma lista de veículos e seu proprietário

```json
{
    "id": 1,
        "proprietario": {
        "id": 1,
        "nome": "João da Silva",
        "email": "joaodasilva@algaworks.com.br",
        "telefone": "11 99999-9999"
        },
    "marca": "Honda",
    "modelo": "HR-V",
    "placa": "KRM9988",
    "status": "REGULAR",
    "dataCadastro": "2023-05-18T18:00:00Z",
    "dataApreensao": null
},
{
    "id": 2,
        "proprietario": {
        "id": 1,
        "nome": "João da Silva",
        "email": "joaodasilva@algaworks.com.br",
        "telefone": "11 99999-9999"
        },
    "marca": "Honda",
    "modelo": "Civic",
    "placa": "QBN7F89",
    "status": "REGULAR",
    "dataCadastro": "2025-01-02T17:37:56Z",
    "dataApreensao": null
}
```

## GET /veiculos/{id}

**Descrição:** retorno um JSON com os dados do veículo conforme id

```json
{
    "id": 1,
    "nomeProprietario": "João da Silva",
    "marca": "Honda",
    "modelo": "HR-V",
    "numeroPlaca": "KRM9988",
    "status": "REGULAR",
    "dataCadastro": "2023-05-18T18:00:00Z",
    "dataApreensao": null
}
```
