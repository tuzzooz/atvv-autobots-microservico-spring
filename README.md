## Tecnologias

- **Java:** OpenJDK 17
- **Framework:** Spring Boot 2.7.0
- **ORM:** Spring Data JPA / Hibernate
- **Database:** H2 Database (in-memory)
- **Build Tool:** Maven 3.6.3
- **Outras:** Lombok

---

## Estrutura dos Microserviços

Cada microserviço segue a estrutura padrão Maven:

```

service-(exempplo)/
├── src/
│   ├── main/
│   │   ├── java/com/autobots/automanager/
│   │   │   ├── *Application.java
│   │   │   ├── entidades/
│   │   │   ├── repositorios/
│   │   │   └── controles/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .mvn/
├── mvnw
├── mvnw.cmd
└── pom.xml

```

---

## Requisitos do Sistema

- **Java:** OpenJDK 17 ou superior
- **Maven:** 3.6.3+ (incluído via wrapper)
- **Memória:** Mínimo 2GB RAM
- **Sistema Operacional:** Windows, Linux ou macOS

## Arquitetura

|--------------|-------|-----------|---------------|
| service-empresa | 8080 | Gerenciamento de empresas/lojas | http://localhost:8080/empresas |
| service-cliente | 8081 | Cadastro de clientes | http://localhost:8081/clientes |
| service-funcionario | 8082 | Cadastro de funcionários | http://localhost:8082/funcionarios |
| service-servico | 8083 | Catálogo de serviços | http://localhost:8083/servicos |
| service-mercadoria | 8084 | Estoque de mercadorias | http://localhost:8084/mercadorias |
| service-veiculo | 8085 | Registro de veículos | http://localhost:8085/veiculos |
| service-venda | 8086 | Controle de vendas | http://localhost:8086/vendas |
|--------------|-------|-----------|---------------|

## Como Executar

### Pré-requisitos
Verifique se o Java 17 está instalado:
```powershell
java -version
```
Deve retornar: `openjdk version "17.x.x"` ou superior

### Primeiro Passo

```powershell
cd .\atvv-autobots-microservico-spring-main\
```

### Para os Executar Manualmente ( em terminais diferentes!)
```powershell
cd service-empresa 
.\mvnw.cmd spring-boot:run

cd service-cliente
.\mvnw.cmd spring-boot:run

cd service-funcionario
.\mvnw.cmd spring-boot:run

cd service-servico
.\mvnw.cmd spring-boot:run

cd service-mercadoria
.\mvnw.cmd spring-boot:run

cd service-veiculo
.\mvnw.cmd spring-boot:run

cd service-venda
.\mvnw.cmd spring-boot:run
```

## Testes CRUD 

### 1. service-empresa (Porta 8080)

#### GET - Listar todas as empresas
**cURL (Windows PowerShell):**
```powershell
curl http://localhost:8080/empresas
```

**cURL (Linux/Mac):**
```bash
curl http://localhost:8080/empresas
```

**Insomnia:**
```
Method: GET
URL: http://localhost:8080/empresas
```

#### GET - Buscar empresa por ID
**cURL (PowerShell):**
```powershell
curl http://localhost:8080/empresas/1
```

**Insomnia:**
```
Method: GET
URL: http://localhost:8080/empresas/1
```

#### POST - Criar nova empresa
**cURL (PowerShell):**
```powershell
$body = @{
    nomeFantasia = "Auto Center Premium"
    razaoSocial = "Auto Center Premium LTDA"
    cnpj = "12.345.678/0001-90"
    telefone = "(11) 98765-4321"
    email = "contato@autopremium.com"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/empresas" -Method POST -ContentType "application/json" -Body $body
```

**cURL (Linux/Mac):**
```bash
curl -X POST http://localhost:8080/empresas \
  -H "Content-Type: application/json" \
  -d '{
    "nomeFantasia": "Auto Center ",
    "razaoSocial": "Auto Center LTDA",
    "cnpj": "12.345.678/0001-90",
    "telefone": "(11) 98765-4321",
    "email": "contato@auto.com"
  }'
```

**Insomnia:**
```
Method: POST
URL: http://localhost:8080/empresas
Headers: Content-Type: application/json
Body (JSON):
{
  "nomeFantasia": "Auto Center",
  "razaoSocial": "Auto Center",
  "cnpj": "12.345.678/0001-90",
  "telefone": "(11) 98765-4321",
  "email": "contato@auto.com"
}
```

#### PUT - Atualizar empresa
**cURL (PowerShell):**
```powershell
$body = @{
    nomeFantasia = "Auto Center Atualizado"
    razaoSocial = "Auto Center LTDA ME"
    cnpj = "12.345.678/0001-90"
    telefone = "(11) 98765-1111"
    email = "novo@auto.com"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/empresas/1" -Method PUT -ContentType "application/json" -Body $body
```

**cURL (Linux/Mac):**
```bash
curl -X PUT http://localhost:8080/empresas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nomeFantasia": "Auto Center Atualizado",
    "razaoSocial": "Auto Center LTDA ME",
    "cnpj": "12.345.678/0001-90",
    "telefone": "(11) 98765-1111",
    "email": "novo@auto.com"
  }'
```

**Insomnia:**
```
Method: PUT
URL: http://localhost:8080/empresas/1
Headers: Content-Type: application/json
Body (JSON):
{
  "nomeFantasia": "Auto Center Atualizado",
  "razaoSocial": "Auto Center",
  "cnpj": "12.345.678/0001-90",
  "telefone": "(11) 98765-1111",
  "email": "novo@auto.com"
}
```

#### DELETE - Remover empresa
**cURL (PowerShell):**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/empresas/1" -Method DELETE
```

**cURL (Linux/Mac):**
```bash
curl -X DELETE http://localhost:8080/empresas/1
```

**Insomnia:**
```
Method: DELETE
URL: http://localhost:8080/empresas/1
```

---

### 2. service-cliente (Porta 8081)

#### GET - Listar todos os clientes
**cURL:**
```powershell
curl http://localhost:8081/clientes
```

**Insomnia:**
```
Method: GET
URL: http://localhost:8081/clientes
```

#### GET - Buscar clientes por empresa
**cURL:**
```powershell
curl http://localhost:8081/clientes/empresa/1
```

**Insomnia:**
```
Method: GET
URL: http://localhost:8081/clientes/empresa/1
```

#### POST - Criar novo cliente
**cURL (PowerShell):**
```powershell
$body = @{
    nome = "João Vitor"
    email = "joao.vitor@email.com"
    empresaId = 1
    documentos = @(
        @{
            tipo = "CPF"
            numero = "123.456.789-00"
            orgaoEmissor = "SSP-SP"
        }
    )
    telefones = @(
        @{
            ddd = "11"
            numero = "99876-5432"
            tipo = "Celular"
        }
    )
    endereco = @{
        estado = "SP"
        cidade = "São Paulo"
        bairro = "Vila Mariana"
        rua = "Rua Vergueiro"
        numero = "1000"
        cep = "04101-000"
    }
} | ConvertTo-Json -Depth 10

Invoke-RestMethod -Uri "http://localhost:8081/clientes" -Method POST -ContentType "application/json" -Body $body
```

**cURL (Linux/Mac):**
```bash
curl -X POST http://localhost:8081/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Vitor",
    "email": "joao.vitor@email.com",
    "empresaId": 1,
    "documentos": [
      {
        "tipo": "CPF",
        "numero": "123.456.789-00",
        "orgaoEmissor": "SSP-SP"
      }
    ],
    "telefones": [
      {
        "ddd": "11",
        "numero": "99876-5432",
        "tipo": "Celular"
      }
    ],
    "endereco": {
      "estado": "SP",
      "cidade": "São Paulo",
      "bairro": "Vila Mariana",
      "rua": "Rua Vergueiro",
      "numero": "1000",
      "cep": "04101-000"
    }
  }'
```

**Insomnia:**
```
Method: POST
URL: http://localhost:8081/clientes
Headers: Content-Type: application/json
Body (JSON):
{
  "nome": "João Vitor 2",
  "email": "joao.novo@email.com",
  "empresaId": 1,
  "documentos": [
    {
      "tipo": "CPF",
      "numero": "123.456.789-00",
      "orgaoEmissor": "SSP-SP"
    }
  ],
  "telefones": [
    {
      "ddd": "11",
      "numero": "99876-5432",
      "tipo": "Celular"
    }
  ],
  "endereco": {
    "estado": "SP",
    "cidade": "São Paulo",
    "bairro": "Vila Mariana",
    "rua": "Rua Vergueiro",
    "numero": "1000",
    "cep": "04101-000"
  }
}
```

#### PUT - Atualizar cliente
**cURL (PowerShell):**
```powershell
$body = @{
    nome = "João Vitor 2"
    email = "joao.novo@email.com"
    empresaId = 1
    documentos = @(@{ tipo = "CPF"; numero = "123.456.789-00"; orgaoEmissor = "SSP-SP" })
    telefones = @(@{ ddd = "11"; numero = "99999-9999"; tipo = "Celular" })
    endereco = @{ estado = "SP"; cidade = "São Paulo"; bairro = "Centro"; rua = "Av Paulista"; numero = "100"; cep = "01310-000" }
} | ConvertTo-Json -Depth 10

Invoke-RestMethod -Uri "http://localhost:8081/clientes/1" -Method PUT -ContentType "application/json" -Body $body
```

**Insomnia:**
```
Method: PUT
URL: http://localhost:8081/clientes/1
Body: (mesmo formato do POST, com dados atualizados)
```

#### DELETE - Remover cliente
**cURL:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8081/clientes/1" -Method DELETE
```

**Insomnia:**
```
Method: DELETE
URL: http://localhost:8081/clientes/1
```

---

### 3. service-funcionario (Porta 8082)

#### Operações CRUD (mesmo padrão do service-cliente)

**GET todos:**
```
GET http://localhost:8082/funcionarios
```

**GET por empresa:**
```
GET http://localhost:8082/funcionarios/empresa/1
```

**POST criar:**
```json
{
  "nome": "Julia Santos",
  "email": "Julia@automanager.com",
  "perfil": "Mecânico",
  "dataAdmissao": "2024-11-29",
  "empresaId": 1,
  "documentos": [{"tipo": "CPF", "numero": "987.654.321-00"}],
  "telefones": [{"ddd": "11", "numero": "98888-7777", "tipo": "Celular"}],
  "endereco": {"estado": "SP", "cidade": "São Paulo", "bairro": "Mooca", "rua": "Rua da Mooca", "numero": "500", "cep": "03104-000"}
}
```

**PUT atualizar:** `http://localhost:8082/funcionarios/1`  
**DELETE remover:** `http://localhost:8082/funcionarios/1`

---

### 4. service-servico (Porta 8083)

**GET todos:**
```
GET http://localhost:8083/servicos
```

**GET por empresa:**
```
GET http://localhost:8083/servicos/empresa/1
```

**POST criar:**
```json
{
  "nome": "Revisão de 10.000 km",
  "descricao": "Revisão completa preventiva",
  "valor": 350.00,
  "empresaId": 1
}
```

**PUT atualizar:** `http://localhost:8083/servicos/1`  
**DELETE remover:** `http://localhost:8083/servicos/1`

---

### 5. service-mercadoria (Porta 8084)

**GET todos:**
```
GET http://localhost:8084/mercadorias
```

**GET por empresa:**
```
GET http://localhost:8084/mercadorias/empresa/1
```

**POST criar:**
```json
{
  "nome": "Filtro de Ar Esportivo",
  "descricao": "Filtro de ar de alto desempenho",
  "valor": 250.00,
  "quantidade": 25,
  "empresaId": 1
}
```

**PUT atualizar:** `http://localhost:8084/mercadorias/1`  
**DELETE remover:** `http://localhost:8084/mercadorias/1`

---

### 6. service-veiculo (Porta 8085)

**GET todos:**
```
GET http://localhost:8085/veiculos
```

**GET por cliente:**
```
GET http://localhost:8085/veiculos/cliente/1
```

**POST criar:**
```json
{
  "modelo": "Corolla",
  "marca": "Toyota",
  "placa": "ABC-1D23",
  "ano": 2023,
  "clienteId": 1
}
```

**PUT atualizar:** `http://localhost:8085/veiculos/1`  
**DELETE remover:** `http://localhost:8085/veiculos/1`

---

### 7. service-venda (Porta 8086)

**GET todos:**
```
GET http://localhost:8086/vendas
```

**GET por empresa:**
```
GET http://localhost:8086/vendas/empresa/1
```

**GET por período:**
```
GET http://localhost:8086/vendas/empresa/1/periodo?inicio=2024-01-01&fim=2024-12-31
```

**POST criar:**
```json
{
  "data": "2024-11-29T14:30:00",
  "empresaId": 1,
  "clienteId": 1,
  "funcionarioId": 1,
  "veiculoId": 1,
  "itens": [
    {
      "tipo": "SERVICO",
      "itemId": 1,
      "nome": "Troca de Óleo",
      "valor": 150.00,
      "quantidade": 1
    },
    {
      "tipo": "MERCADORIA",
      "itemId": 1,
      "nome": "Óleo 5W30",
      "valor": 85.00,
      "quantidade": 1
    }
  ]
}
```

**PUT atualizar:** `http://localhost:8086/vendas/1`  
**DELETE remover:** `http://localhost:8086/vendas/1`

### service-empresa (Porta 8080)

**GET - Listar todas as empresas:**
```powershell
curl http://localhost:8080/empresas
```

**GET - Buscar empresa por ID:**
```powershell
curl http://localhost:8080/empresas/1
```

**POST - Criar nova empresa:**
```powershell
curl -X POST http://localhost:8080/empresas -H "Content-Type: application/json" -d '{\"nome\":\"Auto Center Novo\",\"razaoSocial\":\"Auto Center Novo LTDA\",\"cnpj\":\"99.999.999/0001-99\"}'
```

**PUT - Atualizar empresa:**
```powershell
curl -X PUT http://localhost:8080/empresas/1 -H "Content-Type: application/json" -d '{\"nome\":\"Auto Center Atualizado\",\"razaoSocial\":\"Auto Center Atualizado LTDA\",\"cnpj\":\"11.111.111/0001-11\"}'
```

**DELETE - Deletar empresa:**
```powershell
curl -X DELETE http://localhost:8080/empresas/1
```

### service-cliente (Porta 8081)

**GET - Listar todos os clientes:**
```powershell
curl http://localhost:8081/clientes
```

**GET - Buscar clientes por empresa:**
```powershell
curl http://localhost:8081/clientes/empresa/1
```

**POST - Criar novo cliente:**
```powershell
curl -X POST http://localhost:8081/clientes -H "Content-Type: application/json" -d '{\"nome\":\"Pedro Martins\",\"email\":\"pedro@email.com\",\"empresaId\":1,\"documentos\":[{\"tipo\":\"CPF\",\"numero\":\"999.999.999-99\"}],\"telefones\":[{\"ddd\":\"11\",\"numero\":\"99999-9999\",\"tipo\":\"Celular\"}],\"endereco\":{\"estado\":\"SP\",\"cidade\":\"São Paulo\",\"bairro\":\"Centro\",\"rua\":\"Rua Nova\",\"numero\":\"100\",\"cep\":\"01000-000\"}}'
```

**PUT - Atualizar cliente:**
```powershell
curl -X PUT http://localhost:8081/clientes/1 -H "Content-Type: application/json" -d '{\"nome\":\"João Silva Atualizado\",\"email\":\"joao.novo@email.com\",\"empresaId\":1,\"documentos\":[{\"tipo\":\"CPF\",\"numero\":\"111.111.111-11\"}],\"telefones\":[{\"ddd\":\"11\",\"numero\":\"91111-1111\",\"tipo\":\"Celular\"}],\"endereco\":{\"estado\":\"SP\",\"cidade\":\"São Paulo\",\"bairro\":\"Centro\",\"rua\":\"Rua Atualizada\",\"numero\":\"100\",\"cep\":\"01000-000\"}}'
```

**DELETE - Deletar cliente:**
```powershell
curl -X DELETE http://localhost:8081/clientes/1
```

### service-funcionario (Porta 8082)

**GET - Listar todos os funcionários:**
```powershell
curl http://localhost:8082/funcionarios
```

**GET - Buscar funcionários por empresa:**
```powershell
curl http://localhost:8082/funcionarios/empresa/1
```

**POST - Criar novo funcionário:**
```powershell
curl -X POST http://localhost:8082/funcionarios -H "Content-Type: application/json" -d '{\"nome\":\"Otávio Lima\",\"email\":\"roberto@automanager.com\",\"perfil\":\"Vendedor\",\"dataAdmissao\":\"2024-11-29\",\"empresaId\":1,\"documentos\":[{\"tipo\":\"CPF\",\"numero\":\"888.888.888-88\"}],\"telefones\":[{\"ddd\":\"11\",\"numero\":\"98888-8888\",\"tipo\":\"Celular\"}],\"endereco\":{\"estado\":\"SP\",\"cidade\":\"São Paulo\",\"bairro\":\"Lapa\",\"rua\":\"Rua da Lapa\",\"numero\":\"500\",\"cep\":\"05422-000\"}}'
```

**PUT - Atualizar funcionário:**
```powershell
curl -X PUT http://localhost:8082/funcionarios/1 -H "Content-Type: application/json" -d '{\"nome\":\"Bruno Henrique\",\"email\":\"carlos.jr@automanager.com\",\"perfil\":\"Gerente Geral\",\"dataAdmissao\":\"2024-11-29\",\"empresaId\":1,\"documentos\":[{\"tipo\":\"CPF\",\"numero\":\"111.222.333-44\"}],\"telefones\":[{\"ddd\":\"11\",\"numero\":\"91111-2222\",\"tipo\":\"Celular\"}],\"endereco\":{\"estado\":\"RJ\",\"cidade\":\"Rio de Janeiro\",\"bairro\":\"Botafogo\",\"rua\":\"Rua da Esperança\",\"numero\":\"2000\",\"cep\":\"04035-000\"}}'
```

**DELETE - Deletar funcionário:**
```powershell
curl -X DELETE http://localhost:8082/funcionarios/1
```

### service-servico (Porta 8083)

**GET - Listar todos os serviços:**
```powershell
curl http://localhost:8083/servicos
```

**GET - Buscar serviços por empresa:**
```powershell
curl http://localhost:8083/servicos/empresa/1
```

**POST - Criar novo serviço:**
```powershell
curl -X POST http://localhost:8083/servicos -H "Content-Type: application/json" -d '{\"nome\":\"Lavagem Completa\",\"descricao\":\"Lavagem interna e externa\",\"valor\":80.0,\"empresaId\":1}'
```

**PUT - Atualizar serviço:**
```powershell
curl -X PUT http://localhost:8083/servicos/1 -H "Content-Type: application/json" -d '{\"nome\":\"Troca de Óleo Premium\",\"descricao\":\"Troca de óleo sintético premium\",\"valor\":200.0,\"empresaId\":1}'
```

**DELETE - Deletar serviço:**
```powershell
curl -X DELETE http://localhost:8083/servicos/1
```

### service-mercadoria (Porta 8084)

**GET - Listar todas as mercadorias:**
```powershell
curl http://localhost:8084/mercadorias
```

**GET - Buscar mercadorias por empresa:**
```powershell
curl http://localhost:8084/mercadorias/empresa/1
```

**POST - Criar nova mercadoria:**
```powershell
curl -X POST http://localhost:8084/mercadorias -H "Content-Type: application/json" -d '{\"nome\":\"Lâmpada H7\",\"descricao\":\"Lâmpada para farol automotivo\",\"valor\":35.0,\"quantidade\":60,\"empresaId\":1}'
```

**PUT - Atualizar mercadoria:**
```powershell
curl -X PUT http://localhost:8084/mercadorias/1 -H "Content-Type: application/json" -d '{\"nome\":\"Óleo Sintético 5W30 Premium\",\"descricao\":\"Óleo sintético super premium\",\"valor\":95.0,\"quantidade\":45,\"empresaId\":1}'
```

**DELETE - Deletar mercadoria:**
```powershell
curl -X DELETE http://localhost:8084/mercadorias/1
```

### service-veiculo (Porta 8085)

**GET - Listar todos os veículos:**
```powershell
curl http://localhost:8085/veiculos
```

**GET - Buscar veículos por cliente:**
```powershell
curl http://localhost:8085/veiculos/cliente/1
```

**POST - Criar novo veículo:**
```powershell
curl -X POST http://localhost:8085/veiculos -H "Content-Type: application/json" -d '{\"modelo\":\"Gol\",\"marca\":\"Volkswagen\",\"placa\":\"JKL-7890\",\"ano\":2018,\"clienteId\":1}'
```

**PUT - Atualizar veículo:**
```powershell
curl -X PUT http://localhost:8085/veiculos/1 -H "Content-Type: application/json" -d '{\"modelo\":\"Civic Si\",\"marca\":\"Honda\",\"placa\":\"ABC-1234\",\"ano\":2021,\"clienteId\":1}'
```

**DELETE - Deletar veículo:**
```powershell
curl -X DELETE http://localhost:8085/veiculos/1
```

### service-venda (Porta 8086)

**GET - Listar todas as vendas:**
```powershell
curl http://localhost:8086/vendas
```

**GET - Buscar vendas por empresa:**
```powershell
curl http://localhost:8086/vendas/empresa/1
```

**GET - Buscar vendas por período:**
```powershell
curl "http://localhost:8086/vendas/empresa/1/periodo?inicio=2024-01-01&fim=2024-12-31"
```

**POST - Criar nova venda:**
```powershell
curl -X POST http://localhost:8086/vendas -H "Content-Type: application/json" -d '{\"data\":\"2024-11-29T10:00:00\",\"empresaId\":1,\"clienteId\":1,\"funcionarioId\":1,\"veiculoId\":1,\"itens\":[{\"tipo\":\"SERVICO\",\"itemId\":1,\"nome\":\"Troca de Óleo\",\"valor\":150.0,\"quantidade\":1},{\"tipo\":\"MERCADORIA\",\"itemId\":2,\"nome\":\"Filtro de Óleo\",\"valor\":25.0,\"quantidade\":2}]}'
```

**PUT - Atualizar venda:**
```powershell
curl -X PUT http://localhost:8086/vendas/1 -H "Content-Type: application/json" -d '{\"data\":\"2024-11-29T11:00:00\",\"empresaId\":1,\"clienteId\":1,\"funcionarioId\":1,\"veiculoId\":1,\"itens\":[{\"tipo\":\"SERVICO\",\"itemId\":1,\"nome\":\"Troca de Óleo Completa\",\"valor\":180.0,\"quantidade\":1}]}'
```

**DELETE - Deletar venda:**
```powershell
curl -X DELETE http://localhost:8086/vendas/1
```

---

## Console H2 Database

| Microserviço | URL Console | JDBC URL |
|--------------|-------------|----------|
| service-empresa | http://localhost:8080/h2-console | `jdbc:h2:mem:empresadb` |
| service-cliente | http://localhost:8081/h2-console | `jdbc:h2:mem:clientedb` |
| service-funcionario | http://localhost:8082/h2-console | `jdbc:h2:mem:funcionariodb` |
| service-servico | http://localhost:8083/h2-console | `jdbc:h2:mem:servicodb` |
| service-mercadoria | http://localhost:8084/h2-console | `jdbc:h2:mem:mercadoriadb` |
| service-veiculo | http://localhost:8085/h2-console | `jdbc:h2:mem:veiculodb` |
| service-venda | http://localhost:8086/h2-console | `jdbc:h2:mem:vendadb` |

**Credenciais:**
- **User Name:** `sa`
- **Password:** (deixar em branco)

---
