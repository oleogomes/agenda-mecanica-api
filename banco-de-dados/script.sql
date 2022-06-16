-- CRIANDO TABELAS -- 

create table tbPessoa (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
    nome varchar(255) not null ,
    username varchar (50) not null unique,
    email varchar(255) not null unique,
    senha varchar(255) not null
);

create table tbCarro (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
   	placa varchar(8) unique not null,
   	ano_modelo varchar(4) not null
);

create table tbModeloCarro (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
	descricao varchar(50) not null
);

create table tbMarcaCarro (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
	descricao varchar(50) not null
);

create table tbServico (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
    data_hora timestamp 
);

create table tbStatusServico (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
	descricao varchar(20) not null
);

create table tbTipoServico (
	id bigint primary key GENERATED ALWAYS AS IDENTITY,
   	descricao varchar(255) not null,
   	tempo_servico integer not null,
   	valor integer not null
);

create table roles (
	id integer primary key GENERATED ALWAYS AS IDENTITY,
	name varchar(20)
);

create table user_roles (
	user_id bigint not null,
	role_id integer not null
);


-- ADICIONANDO FK's

ALTER TABLE tbcarro ADD id_Modelo bigint NOT NULL;
ALTER TABLE tbcarro  ADD CONSTRAINT carro_modelo_fk FOREIGN KEY (id_modelo) REFERENCES tbModeloCarro(id);

ALTER TABLE tbmodelocarro ADD id_marca bigint NOT NULL;
ALTER TABLE tbmodelocarro  ADD CONSTRAINT marca_modelo_fk FOREIGN KEY (id_marca) REFERENCES tbMarcaCarro(id);

ALTER TABLE tbcarro ADD id_pessoa bigint NOT NULL;
ALTER TABLE tbcarro  ADD CONSTRAINT carro_pessoa_fk FOREIGN KEY (id_pessoa) REFERENCES tbpessoa(id);

ALTER TABLE tbservico ADD id_carro bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT servico_carro_fk FOREIGN KEY (id_carro) REFERENCES tbCarro(id);

ALTER TABLE tbservico ADD id_status_Servico bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT status_servico_fk FOREIGN KEY (id_status_servico) REFERENCES tbStatusServico(id);

ALTER TABLE tbservico ADD id_tipo_servico bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT servico_tipo_servico_fk FOREIGN KEY (id_tipo_servico) REFERENCES tbTipoServico(id);

ALTER TABLE tbservico ADD id_mecanico bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT servico_mecanico_fk FOREIGN KEY (id_mecanico) REFERENCES tbPessoa(id);

ALTER TABLE tbservico ADD id_cliente bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT servico_cliente_fk FOREIGN KEY (id_cliente) REFERENCES tbPessoa(id);

ALTER TABLE user_roles ADD CONSTRAINT user_roles_user_fk FOREIGN KEY (user_id) REFERENCES tbPessoa(id);
ALTER TABLE user_roles ADD CONSTRAINT user_roles_role_fk FOREIGN KEY (role_id) REFERENCES roles(id);

--- CARGA ROLES ---
INSERT INTO roles(name) VALUES('ROLE_CLIENTE');
INSERT INTO roles(name) VALUES('ROLE_MECANICO');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

--- CARGA PARA TBMARCACARRO --- 

insert into tbmarcacarro (descricao) values 
('FIAT'),
('GM - CHEVROLET'),
('FORD'),
('VOLKSWAGEN'),
('CITROEN '),
('HONDA'),
('HYUNDAI'),
('JAC'),
('KIA MOTORS'),
('NISSAN'),
('PEUGEOT'),
('RENAULT'),
('TOYOTA');

--- CARGA MODELOS FIAT ---
insert into tbmodelocarro (id_marca, descricao ) values 
(1, '147'),
(1, '500'),
(1, 'ARGO'),
(1, 'BRAVA'),
(1, 'BRAVO'),
(1, 'COUPE'),
(1, 'CRONOS'),
(1, 'DOBLO'),
(1, 'DUCATO'),
(1, 'ELBA'),
(1, 'FIORINO'),
(1, 'FREEMONT'),
(1, 'GRAND SIENA'),
(1, 'IDEA'),
(1, 'LINEA'),
(1, 'MAREA'),
(1, 'MOBI'),
(1, 'PALIO'),
(1, 'PREMIO'),
(1, 'PULSE'),
(1, 'PUNTO'),
(1, 'SIENA'),
(1, 'STILO'),
(1, 'STRADA'),
(1, 'TEMPRA'),
(1, 'TIPO'),
(1, 'TORO'),
(1, 'UNO');






