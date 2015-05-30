Nova Proposta de Arquitetura
============================

Objetivo
--------
O objetivo dessa nova proposta é refatorar a aplicação para utilizar as normas de boas práticas de programação Orientada à Objetos, como utilização de Design Patterns (os que eu conheço), usar técnicas de concorrência e outras técnicas.

Um dos principais objetivos é desacoplar módulos da aplicação de forma a orientá-las à Interfaces e não à implementações, como está agora. Isso servirá principalmente para facilitar a extensibilidade do código e adaptá-lo para novos cenários, caso necessário.

Modulos
-------
A aplicação contará com 3 módulos:  
*  Processador votos:  O processador votos terá a responsabilidade de conectar a qualquer base de dados e extrair informações à respeito de um voto feito por um eleitor;
*  Enfileirador: o enfileirador vai intermediar os módulos da aplicação e servirá para centralizar as mensagens que precisam serem trocadas entre os módulos da aplicação;
*  Contabilizador: o contabilizador terá a responsabilidade de fazer a contabilização dos votos e retornar o resultado esperado;

Esses módulos serão desenhados em um diagrama de atividade.  
Esses módulos deverão funcionar em paralelo;
