CREATE TABLE tb_sala (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         localizacao VARCHAR(100) NOT NULL,
                         capacidade_maxima INTEGER NOT NULL CHECK (capacidade_maxima > 0),
                         criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_palestrante (
                                id BIGSERIAL PRIMARY KEY,
                                nome VARCHAR(150) NOT NULL,
                                email VARCHAR(150) NOT NULL UNIQUE,
                                especialidade VARCHAR(100),
                                mini_biografia TEXT,
                                criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_evento (
                           id BIGSERIAL PRIMARY KEY,
                           titulo VARCHAR(150) NOT NULL,
                           descricao TEXT,
                           data_hora_inicio TIMESTAMP NOT NULL,
                           data_hora_fim TIMESTAMP NOT NULL,
                           sala_id BIGINT NOT NULL,
                           palestrante_id BIGINT NOT NULL,
                           criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT fk_evento_sala FOREIGN KEY (sala_id) REFERENCES tb_sala(id),
                           CONSTRAINT fk_evento_palestrante FOREIGN KEY (palestrante_id) REFERENCES tb_palestrante(id),
                           CONSTRAINT chk_datas_validas CHECK (data_hora_fim > data_hora_inicio)
);

CREATE TABLE tb_participante (
                                 id BIGSERIAL PRIMARY KEY,
                                 nome VARCHAR(150) NOT NULL,
                                 email VARCHAR(150) NOT NULL UNIQUE,
                                 cpf VARCHAR(14) NOT NULL UNIQUE,
                                 criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_inscricao (
                              id BIGSERIAL PRIMARY KEY,
                              evento_id BIGINT NOT NULL,
                              participante_id BIGINT NOT NULL,
                              data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT fk_inscricao_evento FOREIGN KEY (evento_id) REFERENCES tb_evento(id),
                              CONSTRAINT fk_inscricao_participante FOREIGN KEY (participante_id) REFERENCES tb_participante(id),
                              CONSTRAINT uk_inscricao_unica UNIQUE (evento_id, participante_id)
);