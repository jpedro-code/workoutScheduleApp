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
## Estrutura de Dados no Firebase
Este aplicativo utiliza o Firebase Realtime Database para armazenar e sincronizar os dados dos treinos dos usuários. Abaixo está a estrutura de dados utilizada no Firebase:

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

Cada usuário tem sua própria entrada na coleção `usuarios`, com informações como nome, email e senha. Os treinos de cada usuário são armazenados na coleção `treinos`, onde cada documento representa um treino individual associado ao usuário correspondente através do campo `usuario_id`.

Essa estrutura permite que os usuários gerenciem seus treinos de forma eficiente, com a capacidade de adicionar, editar, excluir e visualizar seus treinos de forma intuitiva no aplicativo.

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
