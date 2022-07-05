/*
CREATE TABLE VEM_SER.ESTUDANTE (
	id NUMBER,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1), 
	PRIMARY KEY (id)
);

CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
START WITH 0
INCREMENT BY 1
NOCACHE NOCYCLE;
 
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Malu Isabelle Heloisa Baptista',TO_DATE('06-05-1953', 'dd-mm-yyyy'),'6877','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Luciana Hadassa Helena Souza',TO_DATE('02-02-1998', 'dd-mm-yyyy'),'162887','N');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Nicole Alice Ramos',TO_DATE('07-02-1958', 'dd-mm-yyyy'),'559739','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Bruno Felipe Carvalho',TO_DATE('02-02-1988', 'dd-mm-yyyy'),'869927','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Andrea Heloise Ara�jo',TO_DATE('01-01-1971', 'dd-mm-yyyy'),'357273','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Martin Levi Bento Oliveira',TO_DATE('18-05-1966', 'dd-mm-yyyy'),'137004','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Stefany Daiane Ara�jo',TO_DATE('07-04-1961', 'dd-mm-yyyy'),'362635','N');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Henry Kaique Daniel Almada',TO_DATE('10-05-1955', 'dd-mm-yyyy'),'449710','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'Luna La�s Analu Cardoso',TO_DATE('04-06-1962', 'dd-mm-yyyy'),'538984','S');
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.nextval, 'F�tima Sebastiana Barbosa',TO_DATE('11-01-1991', 'dd-mm-yyyy'),'897437','N');

SELECT * FROM VEM_SER.ESTUDANTE;
*/