ALTER TABLE topico
ADD CONSTRAINT unique_titulo_mensagem UNIQUE (titulo, mensagem);