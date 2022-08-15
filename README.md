# Todo
## Requisitos
- deve estar atrelado a um usuário - Header user com um id
- deve conter
  - TodoId - pk
  - Titulo - req
  - Descrição
  - Due date - req
  - User - req
  - Status - req
    - Todo
    - Doing
    - Done
- Um usuário não pode ter mais que 20 ToDos
- Um usuário não pode ter mais que 1 todo em doing
- Ao chegar a (1 ou 50 ou 100 ou 300 ou 500 ou 1000) todos done o usuário deve ganhar um reconhecimento do app
  - Troféu deve conter
    - AwardId — pk
    - User - req
    - Título - req
    - Descrição - req
    - Date - req

# Endpoints

### POST /v1/todos
Cria todos

### GET /v1/todos
Paginado

### GET /v1/todos/search
Filtro por titulo e descrição

### PUT /v1/todos/{todoId}
Alterar Todos
Não deve alterar o status
Alterar somente titulo, descricao e due date
Caso contrário lançar uma exception

### PUT /v1/todos/{todoId}/todo
Altera o status de um todo para ToDo
Não deve alterar todos de outro usuário
Todos em Done não podem mudar de status

### PUT /v1/todos/{todoId}/doing
Altera o status de um todo para Doing
Não deve alterar todos de outro usuário
Todos em Done não podem mudar de status
Não podemos ter mais de 2 todos em doing

### PUT /v1/todos/{todoId}/done
Altera o status de um todo para Done
Não deve alterar todos de outro usuário
Todos em Done não podem mudar de status
Se o usuário cumprir os requisitos para um troféu deve gerar um troféu pro usuário e informar no response

### DELETE /v1/todos/{todoId}
Remove um todo 
Não deve remover todos de outro usuário

### GET /v1/awards
Retorna uma lista de troféis do usuário

### GET /v1/awards/ranking
Retorna um ranking de users com mais troféis


