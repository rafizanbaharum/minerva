insert into CM_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (1, 'root', 0, 1, 1, 0, TIMESTAMP '2013-01-01 00:00:00');
insert into CM_USER (ID, REALNAME, PASSWORD, ACTOR_ID) values (1, 'System Root', '6367c48dd193d56ea7b0baad25b19455e529f5ee', null);
insert into CM_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 1, 1, 1, SYSTIMESTAMP);


-- =============================================================================================
-- CM_PRINCIPAL
-- =============================================================================================
CREATE
TABLE CM_PRINCIPAL
(
  ID             NUMBER        NOT NULL,
  NAME           VARCHAR2(255) NOT NULL,
  PRINCIPAL_TYPE NUMBER(1)     NOT NULL,
  LOCKED         NUMBER(1) DEFAULT 0,
-- STANDARD METADATA COLUMN
  M_ST           NUMBER(1) DEFAULT 0,
  C_ID           NUMBER DEFAULT 0,
  C_TS           TIMESTAMP DEFAULT SYSTIMESTAMP,
  M_ID           NUMBER,
  M_TS           TIMESTAMP,
  D_ID           NUMBER,
  D_TS           TIMESTAMP
);

ALTER TABLE CM_PRINCIPAL ADD CONSTRAINT PK_CM_PRINCIPAL PRIMARY KEY (ID);

CREATE UNIQUE INDEX IDX_CM_PRINCIPAL_NAME ON CM_PRINCIPAL (NAME);

CREATE SEQUENCE SEQ_CM_PRINCIPAL START WITH 2 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CM_USER
-- =============================================================================================
CREATE
TABLE CM_USER
(
  ID          NUMBER        NOT NULL,
  REALNAME    VARCHAR2(100) NOT NULL,
  PASSWORD    VARCHAR2(200) NOT NULL,
  ACTOR_ID NUMBER
);

ALTER TABLE CM_USER ADD CONSTRAINT PK_CM_USER PRIMARY KEY (ID);

CREATE UNIQUE INDEX IDX_CM_USER_ACTOR ON CM_USER (ACTOR_ID);

ALTER TABLE CM_USER ADD CONSTRAINT FK_CM_USER_1 FOREIGN KEY (ID) REFERENCES CM_PRINCIPAL (ID);

-- =============================================================================================
-- CM_PRINCIPAL_ROLE
-- =============================================================================================

CREATE
TABLE CM_PRINCIPAL_ROLE
(
  ID NUMBER NOT NULL,
  ROLE_TYPE NUMBER(1)    NOT NULL,
  PRINCIPAL_ID NUMBER       NOT NULL,
-- STANDARD METADATA COLUMN
  M_ST    NUMBER(1) DEFAULT 0,
  C_ID    NUMBER DEFAULT 0,
  C_TS    TIMESTAMP DEFAULT SYSTIMESTAMP,
  M_ID    NUMBER,
  M_TS    TIMESTAMP,
  D_ID    NUMBER,
  D_TS    TIMESTAMP
);


ALTER TABLE CM_PRINCIPAL_ROLE ADD CONSTRAINT PK_CM_PRINCIPAL_ROLE PRIMARY KEY (ID);

ALTER TABLE CM_PRINCIPAL_ROLE ADD CONSTRAINT FK_CM_PRINCIPAL_ROLE_1 FOREIGN KEY (PRINCIPAL_ID) REFERENCES CM_PRINCIPAL (ID);

CREATE UNIQUE INDEX IDX_CM_PRINCIPAL_ROLE ON CM_PRINCIPAL_ROLE (ROLE_TYPE, PRINCIPAL_ID);

CREATE SEQUENCE SEQ_CM_PRINCIPAL_ROLE START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;

-- =============================================================================================
-- CM_GROUP
-- =============================================================================================
CREATE
TABLE CM_GROUP
(
  ID NUMBER NOT NULL
);

ALTER TABLE CM_GROUP ADD CONSTRAINT PK_CM_GROUP PRIMARY KEY (ID);

ALTER TABLE CM_GROUP ADD CONSTRAINT FK_CM_GROUP_1 FOREIGN KEY (ID) REFERENCES CM_PRINCIPAL (ID);

-- =============================================================================================
-- CM_GROUP_MEMBER
-- =============================================================================================

CREATE
TABLE CM_GROUP_MEMBER
(
  ID           NUMBER NOT NULL,
  GROUP_ID     NUMBER NOT NULL,
  PRINCIPAL_ID NUMBER NOT NULL,
  -- STANDARD METADATA COLUMN
  M_ST         NUMBER(1) DEFAULT 0,
  C_ID         NUMBER DEFAULT 0,
  C_TS         TIMESTAMP DEFAULT SYSTIMESTAMP,
  M_ID         NUMBER,
  M_TS         TIMESTAMP,
  D_ID         NUMBER,
  D_TS         TIMESTAMP
);

ALTER TABLE CM_GROUP_MEMBER ADD CONSTRAINT PK_CM_GROUP_MEMBER PRIMARY KEY (ID);

ALTER TABLE CM_GROUP_MEMBER ADD CONSTRAINT FK_CM_GROUP_MEMBER_1 FOREIGN KEY (GROUP_ID) REFERENCES CM_GROUP (ID);

ALTER TABLE CM_GROUP_MEMBER ADD CONSTRAINT FK_CM_GROUP_MEMBER_2 FOREIGN KEY (PRINCIPAL_ID) REFERENCES CM_PRINCIPAL (ID);

CREATE INDEX IDX_CM_GROUP_MEMBER_2 ON CM_GROUP_MEMBER (GROUP_ID);

CREATE INDEX IDX_CM_GROUP_MEMBER_3 ON CM_GROUP_MEMBER (PRINCIPAL_ID);

CREATE UNIQUE INDEX IDX_GROUP_MEMBER ON CM_GROUP_MEMBER (GROUP_ID, PRINCIPAL_ID)

CREATE SEQUENCE SEQ_CM_GROUP_MEMBER START WITH 1 INCREMENT BY 1 NOMAXVALUE NOMINVALUE CACHE 20 NOORDER;