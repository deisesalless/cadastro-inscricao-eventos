INSERT INTO table_subscription (subscribed_user_id, indication_user_id, event_id) VALUES
(1, NULL, 1),   -- Usuário 1 se inscreveu no evento 1 sem indicação
(2, 1, 1),      -- Usuário 2 se inscreveu no evento 1, indicado pelo usuário 1
(3, NULL, 2),   -- Usuário 3 se inscreveu no evento 2 sem indicação
(4, 3, 2),      -- Usuário 4 se inscreveu no evento 2, indicado pelo usuário 3
(5, NULL, 3),   -- Usuário 5 se inscreveu no evento 3 sem indicação
(6, 5, 3),      -- Usuário 6 se inscreveu no evento 3, indicado pelo usuário 5
(7, NULL, 4),   -- Usuário 7 se inscreveu no evento 4 sem indicação
(8, 7, 4),      -- Usuário 8 se inscreveu no evento 4, indicado pelo usuário 7
(9, NULL, 5),   -- Usuário 9 se inscreveu no evento 5 sem indicação
(10, 9, 5),     -- Usuário 10 se inscreveu no evento 5, indicado pelo usuário 9
(1, NULL, 2),   -- Usuário 1 se inscreveu no evento 2 sem indicação
(2, NULL, 3),   -- Usuário 2 se inscreveu no evento 3 sem indicação
(3, NULL, 4),   -- Usuário 3 se inscreveu no evento 4 sem indicação
(4, NULL, 5),   -- Usuário 4 se inscreveu no evento 5 sem indicação
(5, NULL, 1),   -- Usuário 5 se inscreveu no evento 1 sem indicação
(6, NULL, 2),   -- Usuário 6 se inscreveu no evento 2 sem indicação
(7, NULL, 3),   -- Usuário 7 se inscreveu no evento 3 sem indicação
(8, NULL, 4),   -- Usuário 8 se inscreveu no evento 4 sem indicação
(9, NULL, 5),   -- Usuário 9 se inscreveu no evento 5 sem indicação
(10, NULL, 1);  -- Usuário 10 se inscreveu no evento 1 sem indicação