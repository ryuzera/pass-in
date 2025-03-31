# Pass-In

O pass in é uma aplicação de gestão de participantes em eventos presenciais. O objetivo da ferramenta é permitir que o organizador cadastre um evento, abra uma página pública de inscrição e permita que os participantes inscritos emitam uma credencial para o check-in no dia do evento. Além disso, o sistema fará a verificação da credencial do participante para permitir a entrada no evento. 

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/ryuzera/pass-in.git
```

2. Navegue para o diretório do projeto:

```bash
cd pass-in
```

3. Execute a aplicação.

## Requisitos

### Requisitos funcionais
- [x] O organizador deve ser capaz de registrar um novo evento;
- [x] O organizador deve poder visualizar os dados do evento;
- [x] O organizador deve poder visualizar a lista de participantes;
- [x] O participante deve ser capaz de se registrar para um evento;
- [x] O participante deve poder visualizar seu crachá de inscrição;
- [x] O participante deve poder fazer o check-in no evento;

### Regras de negócios
- [x] O participante só pode se registrar para um evento uma vez;
- [x] Os participantes só podem se inscrever em eventos com vagas disponíveis;
- [x] O participante só pode fazer check-in em um evento uma vez;

### Requisitos não funcionais
- [x] O check-in no evento será realizado através de QRCode;

## Banco de Dados

Nesta aplicação usaremos um banco de dados relacional (SQL). Para o ambiente de desenvolvimento, continuaremos com HyperSQL devido à facilidade do ambiente.

### Diagrama ERD
<img src="imagem.png" alt="Exemplo imagem">

### Estrutura do Banco de Dados 
``` bash
CREATE TABLE "events" (
    "id" TEXT NOT NULL PRIMARY KEY,
    "title" TEXT NOT NULL,
    "details" TEXT,
    "slug" TEXT NOT NULL,
    "maximum_attendees" INTEGER
);

CREATE TABLE "attendees" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "event_id" TEXT NOT NULL,
    "created_at" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT "attendees_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "events" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE "check_ins" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "created_at" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "attendeeId" INTEGER NOT NULL,
    CONSTRAINT "check_ins_attendeeId_fkey" FOREIGN KEY ("attendeeId") REFERENCES "attendees" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE UNIQUE INDEX "events_slug_key" ON "events"("slug");

CREATE UNIQUE INDEX "attendees_event_id_email_key" ON "attendees"("event_id", "email");

CREATE UNIQUE INDEX "check_ins_attendeeId_key" ON "check_ins"("attendeeId");
```

