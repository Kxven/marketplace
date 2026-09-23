# 🛒 Marktplace

Projeto de estudos desenvolvido com **Java e Spring**, com foco em **Domain-Driven Design (DDD)**, separação entre domínio e infraestrutura, persistência com JPA e recursos do ecossistema Spring.

> **Status:** Projeto de estudos — ainda não finalizado.

---

## 🎯 Objetivo

O projeto foi criado para estudar como estruturar uma aplicação de cadastro de clientes utilizando conceitos de **DDD (Domain-Driven Design)** e uma separação clara entre:

* Regras e modelos do domínio;
* Interfaces de repositório;
* Implementações de persistência;
* Entidades utilizadas pelo JPA;
* Recursos do Spring para exposição e persistência de dados.

A ideia principal é entender como o **domínio pode permanecer independente da tecnologia de persistência**.

---

## 📚 Conceitos estudados

### 1. Domain-Driven Design (DDD)

O projeto utiliza uma estrutura inspirada em **DDD**, separando responsabilidades entre o domínio e a infraestrutura.

A entidade de domínio `Customer` representa o cliente dentro da regra de negócio, enquanto as classes relacionadas ao JPA ficam na infraestrutura.

O objetivo é entender como evitar que o modelo de negócio fique diretamente dependente dos detalhes do banco de dados.

---

### 2. Modelo de domínio

A classe `Customer` representa o cliente no domínio da aplicação.

Ela possui informações como:

* `id`
* `firstName`
* `lastName`
* `email`
* `phone`
* `address`

O projeto também utiliza métodos como `create()` e `withId()` para controlar a criação e a identificação do objeto dentro do domínio.

---

### 3. Identificador com UUID

O projeto possui um `CustomerId` representado como `record`.

```java
public record CustomerId(UUID value) {
}
```

Esse estudo ajuda a entender como representar identificadores do domínio de maneira mais explícita.

---

### 4. Repository Pattern

O domínio possui uma interface `CustomerRepository`.

Ela define operações relacionadas ao cliente sem conhecer a implementação utilizada para armazenar os dados.

A implementação fica na infraestrutura.

```text
CustomerRepository
        ↓
JpaCustomerRepository
        ↓
CustomerEntityRepository
        ↓
Banco de dados
```

Isso demonstra a separação entre o **contrato do domínio** e a **tecnologia utilizada para persistência**.

---

### 5. Mapeamento entre domínio e persistência

O projeto possui:

```text
Customer
CustomerEntity
```

A entidade de domínio representa o negócio, enquanto `CustomerEntity` representa a estrutura utilizada pelo JPA.

O `JpaCustomerRepository` realiza a conversão entre esses modelos.

Esse conceito ajuda a entender por que uma aplicação pode possuir mais de uma representação para o mesmo dado.

---

### 6. Spring Data JPA

O projeto utiliza **Spring Data JPA** para facilitar a comunicação com o banco de dados.

A interface `CustomerEntityRepository` estende:

```java
JpaRepository<CustomerEntity, UUID>
```

Isso permite utilizar operações de persistência sem precisar implementar manualmente consultas básicas.

---

### 7. Entidades JPA

`CustomerEntity` utiliza anotações do JPA, como:

```java
@Entity
@Table
@Id
@Column
@OneToOne
```

O estudo envolve entender como uma classe Java pode ser mapeada para uma tabela do banco de dados.

---

### 8. Relacionamento One-to-One

O cliente possui um endereço relacionado através de:

```java
@OneToOne
```

O projeto utiliza esse relacionamento para estudar como representar associações entre entidades no JPA.

---

### 9. Bean Validation

O projeto utiliza validações como:

```java
@NotBlank
@Email
```

Essas validações ajudam a garantir que determinados dados respeitem regras básicas.

Por exemplo:

* `@NotBlank` impede que determinados campos sejam vazios;
* `@Email` verifica se o valor informado possui um formato de e-mail válido.

---

### 10. Restrições no banco de dados

Também existem restrições relacionadas à persistência, como:

```java
nullable = false
unique = true
```

Isso permite estudar a diferença entre:

* **Validação realizada pela aplicação**;
* **Restrições garantidas pelo banco de dados**.

Por exemplo, uma validação como `@Email` ocorre no contexto da aplicação, enquanto `unique = true` pode gerar uma restrição de unicidade na tabela do banco.

---

### 11. UUID e geração de identificadores

O projeto utiliza **UUID** como identificador dos clientes.

Também existe estudo sobre geração automática do identificador através do ciclo de persistência utilizando:

```java
@PrePersist
```

O objetivo é compreender como executar uma ação automaticamente antes da entidade ser persistida.

---

### 12. Datas de criação

O projeto utiliza:

```java
@CreationTimestamp
```

para trabalhar com o registro automático da data de criação da entidade.

Esse recurso permite estudar como informações relacionadas ao ciclo de vida de uma entidade podem ser preenchidas durante a persistência.

---

### 13. Spring Data REST

O repositório também explora:

```java
@RepositoryRestResource
```

Esse recurso permite estudar como repositórios podem ser expostos através dos recursos do **Spring Data REST**.

Dessa forma, parte da exposição dos dados pode ser realizada pelo próprio ecossistema Spring Data REST.

---

### 14. Projections

O projeto possui uma **Projection** para trabalhar com uma representação específica dos dados retornados.

O objetivo é entender como retornar determinadas informações sem necessariamente expor toda a estrutura da entidade.

Isso é útil quando existe a necessidade de controlar quais informações serão disponibilizadas em determinada resposta.

---

### 15. Repository Events

O projeto também explora eventos do Spring Data REST, como:

```java
@HandleAfterCreate
@HandleAfterSave
@HandleAfterDelete
```

A finalidade é estudar como executar determinadas ações depois de eventos relacionados à persistência.

Esses eventos permitem reagir a operações como:

* Criação de uma entidade;
* Atualização de uma entidade;
* Exclusão de uma entidade.

---

### 16. Lombok

O projeto utiliza **Lombok** para reduzir código repetitivo.

Entre os recursos utilizados estão:

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
```

Essas anotações permitem gerar automaticamente métodos e estruturas comuns, como:

* Getters;
* Setters;
* Construtores;
* Builder.

---

## 🏗️ Estrutura estudada

De forma simplificada:

```text
        DOMÍNIO
           │
           ▼
 CustomerRepository
           │
           ▼
 JpaCustomerRepository
           │
           ▼
CustomerEntityRepository
           │
           ▼
      BANCO DE DADOS
```

Essa estrutura demonstra o estudo da separação entre:

**Regra de negócio → Contratos → Infraestrutura → Banco de dados**

O domínio define o que precisa ser feito, enquanto a infraestrutura contém os detalhes necessários para realizar a persistência.

---

## 📁 Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── dio/
            └── marktplace/
                └── registration/
                    ├── domain/
                    │   ├── customer/
                    │   └── ...
                    │
                    └── infrastructure/
                        ├── customer/
                        └── ...
```

A divisão principal estudada é entre:

### `domain`

Responsável pelos elementos relacionados ao negócio da aplicação.

Exemplos:

* Entidades de domínio;
* Identificadores;
* Interfaces de repositório;
* Regras relacionadas ao domínio.

### `infrastructure`

Responsável pelos detalhes técnicos necessários para executar a aplicação.

Exemplos:

* Entidades JPA;
* Repositórios Spring Data;
* Implementações dos repositórios;
* Configurações relacionadas à persistência.

---

## 🔄 Fluxo de persistência estudado

Um dos principais conceitos estudados no projeto é o caminho percorrido pelos dados entre o domínio e o banco.

```text
                  DOMÍNIO
                     │
                     ▼
               Customer
                     │
                     ▼
          CustomerRepository
                     │
                     ▼
        JpaCustomerRepository
                     │
                     ▼
            CustomerEntity
                     │
                     ▼
       CustomerEntityRepository
                     │
                     ▼
              BANCO DE DADOS
```

A ideia é evitar que o `Customer` do domínio precise conhecer diretamente conceitos específicos do JPA ou do banco de dados.

---

## 🛠️ Tecnologias e conceitos

### Tecnologias

* **Java**
* **Spring**
* **Spring Data JPA**
* **Spring Data REST**
* **Hibernate/JPA**
* **Jakarta Validation**
* **Lombok**
* **Banco de dados relacional**

### Conceitos estudados

* **Domain-Driven Design (DDD)**
* **Repository Pattern**
* **Separação entre domínio e infraestrutura**
* **Mapeamento objeto-relacional**
* **Entidades JPA**
* **Relacionamentos JPA**
* **UUID**
* **Bean Validation**
* **Restrições de banco de dados**
* **Projections**
* **Repository Events**
* **Persistência com Spring Data**
* **Lombok**

---

## 📌 Sobre o projeto

Este repositório faz parte dos meus estudos de **Java e Spring**.

O foco principal não é apresentar uma aplicação pronta para produção, mas registrar a evolução no aprendizado de conceitos de:

* Arquitetura;
* Domain-Driven Design;
* Persistência;
* Spring;
* JPA;
* Organização de projetos;
* Separação de responsabilidades.

O projeto ainda está em desenvolvimento e representa uma etapa do processo de aprendizado.
