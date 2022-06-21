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
   	placa varchar(7) unique not null,
   	ano_modelo varchar(4)
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

ALTER TABLE tbservico ADD id_mecanico bigint;
ALTER TABLE tbservico ADD CONSTRAINT servico_mecanico_fk FOREIGN KEY (id_mecanico) REFERENCES tbPessoa(id);

ALTER TABLE tbservico ADD id_cliente bigint NOT NULL;
ALTER TABLE tbservico ADD CONSTRAINT servico_cliente_fk FOREIGN KEY (id_cliente) REFERENCES tbPessoa(id);

ALTER TABLE user_roles ADD CONSTRAINT user_roles_user_fk FOREIGN KEY (user_id) REFERENCES tbPessoa(id);
ALTER TABLE user_roles ADD CONSTRAINT user_roles_role_fk FOREIGN KEY (role_id) REFERENCES roles(id);

--- CARGA ROLES ---
INSERT INTO roles(name) VALUES('ROLE_CLIENTE');
INSERT INTO roles(name) VALUES('ROLE_MECANICO');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

--- CARGA STATUS-SERVICO ---
INSERT INTO tbstatusservico (descricao) VALUES('Agendado');
INSERT INTO tbstatusservico (descricao) VALUES('Em andamento');
INSERT INTO tbstatusservico (descricao) VALUES('Finalizado');

--- CARGA TIPOS-SERVICO ---
INSERT INTO tbtiposervico  (descricao, tempo_servico, valor) values
('Troca de óleo', 1, 180),
('Troca de amortecedores', 5, 300),
('Troca de bomba de gasolina', 5, 250),
('Troca de filtro de ar', 2, 120),
('Troca de pneus', 1, 80),
('Limpeza de bico', 3, 100),
('Limpeza do sistema de arrefecimento', 2, 100),
('Troca de radiador', 5, 300),
('Troca de óleo de caixa', 2, 120),
('Revisão geral', 8, 300),
('Troca de correa dentada', 3, 240),
('Troca de líquido de freio', 1, 100),
('Higienização ar condicionado', 5, 300),
('Carga gás ar condicionado', 2, 170),
('Ajuste de embreagem', 5, 280),
('Passagem de scanner', 2, 100);


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
('NISSAN'),
('PEUGEOT'),
('RENAULT'),
('TOYOTA');

--- CARGA MODELOS FIAT ---
insert into tbmodelocarro (id_marca, descricao ) values 
(25, '147'),
(25, '500'),
(25, 'ARGO'),
(25, 'BRAVA'),
(25, 'BRAVO'),
(25, 'COUPE'),
(25, 'CRONOS'),
(25, 'DOBLO'),
(25, 'DUCATO'),
(25, 'ELBA'),
(25, 'FIORINO'),
(25, 'FREEMONT'),
(25, 'GRAND SIENA'),
(25, 'IDEA'),
(25, 'LINEA'),
(25, 'MAREA'),
(25, 'MOBI'),
(25, 'PALIO'),
(25, 'PREMIO'),
(25, 'PULSE'),
(25, 'PUNTO'),
(25, 'SIENA'),
(25, 'STILO'),
(25, 'STRADA'),
(25, 'TEMPRA'),
(25, 'TIPO'),
(25, 'TORO'),
(25, 'UNO');

--- CARGA MODELOS GM-CHEVROLET ---
insert into tbmodelocarro (id_marca, descricao ) values 
(26, 'AGILE'),
(26, 'ASTRA'),
(26, 'BLAZER'),
(26, 'CAMARO'),
(26, 'CAPTIVA'),
(26, 'CARAVAN'),
(26, 'CELTA'),
(26, 'CHEVETTE'),
(26, 'CHEVY'),
(26, 'CLASSIC'),
(26, 'COBALT'),
(26, 'CORSA'),
(26, 'CRUZE'),
(26, 'D-10'),
(26, 'D-20'),
(26, 'IPANEMA'),
(26, 'KADETT'),
(26, 'MARAJO'),
(26, 'MERIVA'),
(26, 'MONTANA'),
(26, 'MONZA'),
(26, 'OMEGA'),
(26, 'ONIX'),
(26, 'OPALA'),
(26, 'PRISMA'),
(26, 'S10'),
(26, 'SILVERADO'),
(26, 'SPIN'),
(26, 'TRACKER'),
(26, 'VECTRA');

--- CARGA MODELOS FORD ---
insert into tbmodelocarro (id_marca, descricao ) values 
(27, 'BELINA'),
(27, 'BRONCO'),
(27, 'BLAZER'),
(27, 'CORCEL'),
(27, 'COURIER'),
(27, 'DEL REY'),
(27, 'ECOSPORT'),
(27, 'EDGE'),
(27, 'ESCORT'),
(27, 'EXPLORER'),
(27, 'F-100'),
(27, 'F-1000'),
(27, 'F-150'),
(27, 'F-250'),
(27, 'F-350'),
(27, 'F-4000'),
(27, 'F-75'),
(27, 'FIESTA'),
(27, 'FOCUS'),
(27, 'FUSION'),
(27, 'GALAXIE'),
(27, 'GT'),
(27, 'KA'),
(27, 'MAVERICK'),
(27, 'MONDEO'),
(27, 'MUSTANG'),
(27, 'PAMPA'),
(27, 'RANGER'),
(27, 'VERONA'),
(27, 'VERSAILLES'),
(27, 'WILLYS');

--- CARGA MODELOS VW ---
insert into tbmodelocarro (id_marca, descricao ) values 
(28, 'AMAROK'),
(28, 'APOLO'),
(28, 'BORA'),
(28, 'BRASILIA'),
(28, 'CROSSFOX'),
(28, 'FOX'),
(28, 'FUSCA'),
(28, 'GOL'),
(28, 'GOLF'),
(28, 'GRAND SAVEIRO'),
(28, 'JETTA'),
(28, 'KARMANN-GHIA'),
(28, 'KOMBI'),
(28, 'LOGUS'),
(28, 'NIVUS'),
(28, 'PARATI'),
(28, 'PASSAT'),
(28, 'POINTER'),
(28, 'POLO'),
(28, 'QUANTUM'),
(28, 'SANTANA'),
(28, 'SAVEIRO'),
(28, 'SPACECROSS'),
(28, 'T-CROSS'),
(28, 'UP!'),
(28, 'VARIANT'),
(28, 'VIRTUS'),
(28, 'VOYAGE');

--- CARGA MODELOS CITROEN ---
insert into tbmodelocarro (id_marca, descricao ) values 
(29, 'AIRCROSS'),
(29, 'AX'),
(29, 'BERLINGO'),
(29, 'BC'),
(29, 'C3'),
(29, 'C4'),
(29, 'C4 CACTUS'),
(29, 'C5'),
(29, 'C6'),
(29, 'C8'),
(29, 'DS3'),
(29, 'DS4'),
(29, 'DS5'),
(29, 'EVASION'),
(29, 'GRAND C4'),
(29, 'JUMPER'),
(29, 'JUMPY'),
(29, 'XANTIA'),
(29, 'XM'),
(29, 'XSARA');

--- CARGA MODELOS HONDA ---
insert into tbmodelocarro (id_marca, descricao ) values 
(30, 'ACCORD'),
(30, 'CITY'),
(30, 'CIVIC'),
(30, 'CR-V'),
(30, 'FIT'),
(30, 'HR-V'),
(30, 'ODYSSEY'),
(30, 'PASSPORT'),
(30, 'PRELUDE'),
(30, 'WR-V');

--- CARGA MODELOS HIUNDAY ---
insert into tbmodelocarro (id_marca, descricao ) values 
(31, 'ACCENT'),
(31, 'ATOS'),
(31, 'AZERA'),
(31, 'COUPE'),
(31, 'CRETA'),
(31, 'ELANTRA'),
(31, 'EQUUS'),
(31, 'EXCEL'),
(31, 'GALLOPER'),
(31, 'GENESIS'),
(31, 'GRAND SANTA FE'),
(31, 'H1'),
(31, 'H100'),
(31, 'HB20'),
(31, 'HB20S'),
(31, 'HB20X'),
(31, 'HR'),
(31, 'I30'),
(31, 'I30CW'),
(31, 'IX35'),
(31, 'MATRIX'),
(31, 'PORTIER'),
(31, 'SANTA FE'),
(31, 'SCOUPE'),
(31, 'SONATA'),
(31, 'TUCSON'),
(31, 'VELOSTER'),
(31, 'VERACRUZ');

--- CARGA MODELOS JAC ---
insert into tbmodelocarro (id_marca, descricao ) values 
(32, 'E-J7'),
(32, 'E-JS1'),
(32, 'E-JS4'),
(32, 'IEV'),
(32, 'J2'),
(32, 'J3'),
(32, 'J5'),
(32, 'J6'),
(32, 'T'),
(32, 'T40'),
(32, 'T5'),
(32, 'T50'),
(32, 'T6'),
(32, 'T60'),
(32, 'T8'),
(32, 'T80'),
(32, 'V260');

--- CARGA MODELOS NISSAN ---
insert into tbmodelocarro (id_marca, descricao ) values 
(33, '350Z'),
(33, '370Z'),
(33, 'ALTIMA'),
(33, 'AX'),
(33, 'D-21'),
(33, 'FRONTIER'),
(33, 'GRAND LIVINA'),
(33, 'GT-R'),
(33, 'INFINIT'),
(33, 'KICKS'),
(33, 'LEAF'),
(33, 'LIVINA'),
(33, 'MARCH'),
(33, 'MAXIMA'),
(33, 'MICRA'),
(33, 'MURANO'),
(33, 'NX'),
(33, 'PATHFINDER'),
(33, 'PICK-UP'),
(33, 'PRIMERA'),
(33, 'QUEST'),
(33, 'SENTRA'),
(33, 'SX'),
(33, 'TIIDA'),
(33, 'VERSA'),
(33, 'X-TRAIL'),
(33, 'ZX');

--- CARGA MODELOS PEUGEOT ---
insert into tbmodelocarro (id_marca, descricao ) values 
(34, '96'),
(34, '2008'),
(34, '205'),
(34, '206'),
(34, '207'),
(34, '208'),
(34, '3008'),
(34, '306'),
(34, '307'),
(34, '308'),
(34, '405'),
(34, '406'),
(34, '407'),
(34, '408'),
(34, '5008'),
(34, '504'),
(34, '505'),
(34, '508'),
(34, '605'),
(34, '607'),
(34, '806'),
(34, '807'),
(34, 'BOXER'),
(34, 'E-208'),
(34, 'EXPERT'),
(34, 'HOGGAR'),
(34, 'PARTNER'),
(34, 'RCZ');

--- CARGA MODELOS RENAULT ---
insert into tbmodelocarro (id_marca, descricao ) values 
(35, '19'),
(35, '21'),
(35, 'CAPTUR'),
(35, 'CLIO'),
(35, 'DUSTER'),
(35, 'EXPRESS'),
(35, 'FLUENCE'),
(35, 'KANGOO'),
(35, 'KWID'),
(35, 'LAGUNA'),
(35, 'LOGAN'),
(35, 'MASTER'),
(35, 'MEGANE'),
(35, 'SAFRANE'),
(35, 'SANDER'),
(35, 'SCENIC'),
(35, 'STEPWAY'),
(35, 'SYMBOL'),
(35, 'TRAFIC'),
(35, 'TWINGO'),
(35, 'ZOE');

--- CARGA MODELOS TOYOTA ---
insert into tbmodelocarro (id_marca, descricao ) values 
(36, 'AVALON'),
(36, 'BAND'),
(36, 'CAMRY'),
(36, 'CELICA'),
(36, 'COROLLA'),
(36, 'CORONA'),
(36, 'ETIOS'),
(36, 'FIELDER'),
(36, 'HILUX'),
(36, 'LAND CRUISER'),
(36, 'MR-2'),
(36, 'PASEO'),
(36, 'PREVIA'),
(36, 'PRIUS'),
(36, 'RAV4'),
(36, 'SUPRA'),
(36, 'T90'),
(36, 'VENZA'),
(36, 'YARIS');