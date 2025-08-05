# Food Service Manager 🍽️

Tech Challenge da pós-graduação em Arquitetura e Desenvolvimento Java (ADJ) da PÓS TECH da FIAP. 
Ele tem como objetivo a criação de um sistema de gestão para um grupo de restaurantes.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias](#tecnologias)
- [Arquitetura](#arquitetura)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Executar](#como-executar)
- [API Endpoints](#api-endpoints)
- [Banco de Dados](#banco-de-dados)
- [Documentação da API](#documentação-da-api)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Contribuição](#contribuição)

## 🎯 Sobre o Projeto

O **Food Service Manager** é uma API REST desenvolvida para gerenciar operações de restaurantes. O objetivo é desenvolver um Backend completo e robusto utilizando o framework Spring Boot. 
O sistema permitirá que os restaurantes gerenciem suas operações, enquanto os clientes poderão consultar informações, fazer pedidos e deixar avaliações. 
A entrega do projeto será realizada em fases, para garantir um desenvolvimento escalável através do aprendizado contínuo no curso da pós graduação.

## 🚀 Tecnologias

### Backend
- **Java 21** - Linguagem de programação
- **Spring Boot** - Framework web
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **Hibernate** - ORM
- **PostgreSQL** - Banco de dados
- **Lombok** - Redução de boilerplate

### DevOps
- **Docker & Docker Compose** - Containerização
- **Maven** - Gerenciamento de dependências
- **Swagger/OpenAPI** - Documentação da API

## 🏗️ Arquitetura

```
src/main/java/com/adjt/food_service_manager/
├── controller/     # Controladores REST
├── service/        # Lógica de negócio
├── repository/     # Acesso a dados
├── model/          # Entidades JPA
├── dto/            # Data Transfer Objects
└── enums/          # Enumerações
```

### Modelos Principais

- **UsuarioModel**: Entidade principal com tipos (PROPRIETARIO/CLIENTE)
- **EnderecoModel**: Endereço embarcado (`@Embeddable`)
- **TipoUsuarioEnum**: Enum para tipos de usuário

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- **Java 21+**
- **Docker & Docker Compose**
- **Git**

## 🚀 Como Executar

### Opção 1: Docker Compose (Recomendado)

```bash
# Clone o repositório
git clone <repository-url>
cd food-service-manager

# Execute com Docker Compose
docker-compose up -d

# Verifique os logs
docker-compose logs -f app
```

### 🌐 Acesso

- **API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **PostgreSQL**: localhost:5432

## 📚 API Endpoints

### Usuários

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/usuarios/cadastrar` | Criar usuário |
| `GET` | `/usuarios/listar` | Listar todos os usuários |
| `GET` | `/usuarios/{id}` | Buscar usuário por ID |
| `GET` | `/usuarios/email/{email}` | Buscar usuário por email |
| `PUT` | `/usuarios/{id}` | Atualizar usuário |
| `DELETE` | `/usuarios/{id}` | Excluir usuário |

### Exemplo de Requisição

```json
POST /usuarios/cadastrar
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao@email.com",
  "login": "joao123",
  "senha": "senha123",
  "tipoUsuarioEnum": "CLIENTE",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": 123,
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01234-567"
  }
}
```

## 📖 Documentação da API

A documentação completa da API está disponível via **Swagger UI**:

- **URL**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

### Collection do Postman

O arquivo [`Tech_Challenger.postman_collection.json`](Tech_Challenger.postman_collection.json) contém exemplos de todas as requisições.


## 👥 Equipe

- **Desenvolvedor**: Cauana Dias Costa
- **Desenvolvedor**: Fabiano Meirellis Dolzanes
- **Desenvolvedor**: Ivan Domingos Moreira
- **Desenvolvedor**: Jociel Alves de Jesus
- **Desenvolvedor**: Wellington Feijó da Costa
