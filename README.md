# Aplicativo de Treinos

## Descrição

Este é um aplicativo de gerenciamento de treinos desenvolvido em Kotlin. Ele permite que os usuários façam login e cadastro utilizando o Firebase Authentication e armazenem seus treinos no Firebase Realtime Database. Os usuários podem criar, editar, excluir e visualizar treinos com descrições e datas.

## Funcionalidades

- **Autenticação de Usuários**: Registro e login de usuários utilizando Firebase Authentication.
- **Gerenciamento de Treinos**:
  - **Criar**: Adicione novos treinos com nome, descrição e data.
  - **Editar**: Atualize as informações dos treinos existentes.
  - **Excluir**: Remova treinos que não são mais necessários.
  - **Visualizar**: Veja uma lista de todos os treinos cadastrados.
  
## Tecnologias Utilizadas

- **Kotlin**: Linguagem principal de desenvolvimento.
- **Firebase Authentication**: Para autenticação de usuários.
- **Firebase Realtime Database**: Para armazenamento e sincronização de treinos.

## Estrutura do Projeto

```plaintext
.
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/treinosapp
│   │   │   │   ├── LoginActivity.kt
│   │   │   │   ├── RegisterActivity.kt
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── AddEditTreinoActivity.kt
│   │   │   │   ├── models
│   │   │   │   │   └── Treino.kt
│   │   │   │   ├── adapters
│   │   │   │   │   └── TreinoAdapter.kt
│   │   │   │   ├── utils
│   │   │   │   │   └── FirebaseUtils.kt
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_login.xml
│   │   │   │   │   ├── activity_register.xml
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_add_edit_treino.xml
│   │   │   │   ├── values
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── styles.xml 

```
## Estrutura de Dados no Firebase com Diagrama Visual
Este aplicativo utiliza o Firebase Realtime Database para armazenar e sincronizar os dados dos treinos dos usuários. Abaixo está o diagrama visual no Firebase:

- `usuarios` (coleção)
  - {usuario_id} (documento)
    - nome
    - email
    - senha

- `treinos` (coleção)
  - {treino_id} (documento)
    - usuario_id
    - nome
    - descricao
    - data

## Explicação dos campos usuarios e treinos

1. Usuarios:

- nome: Nome completo do usuário.
- email: Endereço de e-mail do usuário, usado para autenticação.
- senha: Senha do usuário, armazenada de forma segura e criptografada.

2. Treinos:

- usuario_id: ID do usuário proprietário do treino.
- nome: Nome do treino, pode ser qualquer texto descritivo.
- descricao: Descrição detalhada do treino, se houver.
- data: Data em que o treino foi realizado ou agendado.


## Casos de uso

1. Criar (Create):

- Adicionar um novo usuário ao Firebase Authentication.
- Adicionar um novo treino ao Firebase Realtime Database.

2. Ler (Read):

- Recuperar os dados de um usuário específico.
- Listar todos os treinos de um usuário.

3. Atualizar (Update):

- Atualizar o nome de um treino existente.
- Atualizar a descrição de um treino.
- Atualizar a data de um treino.


4. Excluir (Delete):

- Excluir um usuário e todos os seus treinos associados.
- Excluir um treino específico de um usuário.

Cada usuário tem sua própria entrada na coleção `usuarios`, com informações como nome, email e senha. Os treinos de cada usuário são armazenados na coleção `treinos`, onde cada documento representa um treino individual associado ao usuário correspondente através do campo `usuario_id`.

Essa estrutura permite que os usuários gerenciem seus treinos de forma eficiente, com a capacidade de adicionar, editar, excluir e visualizar seus treinos de forma intuitiva no aplicativo.

## Requisitos Funcionais:

1. Registro e Login de Usuários: 
    - O sistema deve permitir que os usuários se registrem e façam login utilizando um endereço de e-mail e senha.
2. Gerenciamento de Treinos:
    - Criar Treino: Os usuários devem poder adicionar novos treinos com nome, descrição e data.
    - Editar Treino: Os usuários devem poder atualizar as informações de treinos existentes.
    - Excluir Treino: Os usuários devem poder remover treinos que não são mais necessários.
    - Visualizar Treinos: Os usuários devem poder ver uma lista de todos os treinos cadastrados.

## Requisitos Não Funcionais:

1. Segurança: As informações dos usuários e treinos devem ser armazenadas de forma segura, com as senhas sendo criptografadas.
2. Desempenho: O aplicativo deve ter tempos de resposta rápidos ao realizar operações de criação, leitura, atualização e exclusão de treinos.
3. Disponibilidade: O sistema deve estar disponível para acesso e uso pelos usuários a qualquer momento, desde que tenham uma conexão com a internet.
4. Compatibilidade: O aplicativo deve ser compatível com uma variedade de dispositivos Android e tamanhos de tela.
5. Manutenibilidade: O código-fonte do aplicativo deve ser organizado e comentado de forma clara, facilitando a manutenção e futuras atualizações.

## Configuração do Ambiente

### Pré-requisitos

- Android Studio instalado
- Conta no Firebase

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/jpedro-code/workoutScheduleApp.git
   cd treinos-app
  

2. Abra o projeto no Android Studio.

3. Configure o Firebase:

- Vá ao Firebase Console.
- Crie um novo projeto ou utilize um projeto existente.
- Adicione um novo aplicativo Android ao projeto.
- Copie o arquivo google-services.json para o diretório app/ do projeto.
- Ative Firebase Authentication (Email/Password).
- Ative Firebase Realtime Database e configure as regras de segurança conforme necessário.

4. Sincronize o projeto com o Firebase:

```plaintext
Project Structure -> Dependencies -> Import Firebase
```

5. Execute o aplicativo em um dispositivo ou emulador Android.

### Como Usar

1. Registrar: Abra o aplicativo e registre-se com um novo usuário.
2. Login: Faça login com suas credenciais.
3. Gerenciar Treinos:
    - Adicione um novo treino preenchendo o nome, descrição e data.
    - Edite um treino existente clicando nele e atualizando as informações.
    - Exclua um treino deslizando-o para o lado ou utilizando o botão de excluir.
    - Visualize todos os treinos na tela principal.

### Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch (git checkout -b feature/nova-feature).
3. Faça commit das suas alterações (git commit -am 'Adiciona nova feature').
4. Faça push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.

### Contato
Para mais informações ou dúvidas, entre em contato pelo email: jpedro.rpessoa@gmail.com
