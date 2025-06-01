insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10001, 'Filipe Evangelista Avila', 'filipea', 'filipe.avila@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'R', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into responsavel(id, id_usuario, codigo, tipo)
values(30001, 10001, '782963', 'TM');

insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10002, 'Diogo Saffiotte Zafani', 'diogoz', 'diogo.zafani@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'C', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into crianca(id, id_usuario, data_nascimento, nivel, xp, xp_total, ponto, id_responsavel)
values(20001, 10002, '2005-05-30', 0, 0, 0, 100, 30001);

insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10003, 'Amanda Acosta De Andrade', 'amandaa', 'amanda.andrade@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'R', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into responsavel(id, id_usuario, codigo, tipo)
values(30002, 10003, '252259', 'M');

insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10004, 'Vinicius Marcel Ibaraki', 'viniciusi', 'vinicius.ibaraki@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'R', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into responsavel(id, id_usuario, codigo, tipo)
values(30003, 10004, '487233', 'AM');

insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10005, 'Davi Pelloso', 'davip', 'davi.pelloso@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'C', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into crianca(id, id_usuario, data_nascimento, nivel, xp, xp_total, ponto, id_responsavel)
values(20002, 10005, '2005-05-30', 0, 0, 0, 0, 30001);

insert into usuario(id, nome_completo, nome_usuario, email, telefone, senha, tipo, criado_em, atualizado_em)
values(10006, 'Lucas Vilas Boas Marcelino Valente', 'lucasv', 'lucas.valente@unimar.com.br', '(99) 99999-9999', 'ABC@123', 'C', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into crianca(id, id_usuario, data_nascimento, nivel, xp, xp_total, ponto, id_responsavel)
values(20003, 10006, '2005-05-30', 0, 0, 0, 0, 30003);

insert into tarefa(id, id_responsavel, id_crianca, titulo, pontuacao_total, pontuacao_conquistada, estrela, prioridade, situacao, data_hora_limite, criado_em, atualizado_em)
values(40001, 30001, 20001, 'Arrumar o Quarto', 20, 0, 0, 'M', 'C', '2025-05-30T19:25:00', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into tarefa(id, id_responsavel, id_crianca, titulo, pontuacao_total, pontuacao_conquistada, estrela, prioridade, situacao, data_hora_limite, criado_em, atualizado_em)
values(40002, 30001, 20001, 'Dar Comida ao Pet', 10, 0, 0, 'A', 'P', '2025-05-30T19:25:00', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into tarefa(id, id_responsavel, id_crianca, titulo, pontuacao_total, pontuacao_conquistada, estrela, prioridade, situacao, data_hora_limite, criado_em, atualizado_em)
values(40003, 30001, 20001, 'Ajudar a Lavar a Louça', 20, 0, 0, 'M', 'P', '2025-05-30T19:25:00', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into recompensa(id, id_responsavel, titulo, pontuacao_necessaria, quantidade, situacao, criado_em, atualizado_em)
values(50001, 30001, 'Assistir TV', 10, 5, 'D', '2025-05-30T19:25:00', '2025-05-30T19:25:00');

insert into recompensa(id, id_responsavel, titulo, pontuacao_necessaria, quantidade, situacao, criado_em, atualizado_em)
values(50002, 30001, 'Passear no parque', 50, 1, 'D', '2025-05-30T19:25:00', '2025-05-30T19:25:00');


