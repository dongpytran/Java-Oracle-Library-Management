
CREATE TABLE books
(
	bookCode varchar(50) Not Null,
	bookName varchar(100),
	author varchar(100),
	categoryCode varchar(50),
	publisherCode varchar(50),
	pubYear varchar(100),
	stus varchar(100),
  IMAGE BLOB,
	CONSTRAINT pk_bookcode PRIMARY KEY (bookCode)
);
CREATE TABLE categorys
(
	categoryCode varchar(50) Not Null,
	categoryName varchar(100),
	CONSTRAINT pk_cateCode Primary Key (categoryCode)
);
CREATE TABLE employees
(
	emCode varchar(50) Not Null,
	emLastName varchar(100) Not Null,
	emFirstName varchar(50) Not Null,
	birth varchar(100),
	gender varchar(50),
	adress varchar(200),
	phone varchar(20),
	email varchar(100),
	Constraint pk_emCode Primary Key (emCode)
);
CREATE TABLE publishingHouses
(
	publisherCode varchar(50) Not Null,
	publisherName varchar(100) Not Null,
	adress varchar(200),
	phone varchar(20),
	email varchar(100),
	Constraint pk_pubCode Primary Key (publisherCode)
);
CREATE TABLE reCards
(
	cardNum varchar(50) Not Null,
	startDay varchar(100) Not Null,
	finishDay varchar(100),
	note varchar(200),
	Constraint cardCode Primary Key(cardNum)
);
CREATE TABLE readers
(
	reaCode varchar(50) Not Null,
	reaName varchar(100),
	adress varchar(200),
	cardNum varchar(50) NOT NULL,
	Constraint readerCode Primary Key (reaCode,cardNum)
);

CREATE TABLE returnExchange
(
	reCode varchar(50) Not Null,
	bookCode varchar(50) Not Null,
	cardNum varchar(50) Not Null,
	emCode varchar(50),
	dayBorrow varchar(100),
	dayReturn varchar(100),
	Constraint returnCode Primary Key (reCode,bookCode,cardNum,dayBorrow)
);

CREATE TABLE RememberUser
(
	Users varchar(100) Not Null,
	Pas varchar(100),
	Constraint rememberUser Primary Key(Users)
);

ALTER TABLE books
ADD CONSTRAINT FK_b_p FOREIGN KEY (publisherCode)
REFERENCES publishingHouses(publisherCode);

ALTER TABLE books
ADD CONSTRAINT FK_b_ca FOREIGN KEY (categoryCode)
REFERENCES categorys(categoryCode);

ALTER TABLE readers
ADD CONSTRAINT FK_r_c FOREIGN KEY (cardNum)
REFERENCES reCards(cardNum);


ALTER TABLE returnExchange
ADD CONSTRAINT FK_return_book FOREIGN KEY (bookCode)
REFERENCES books(bookCode);

ALTER TABLE returnExchange
ADD CONSTRAINT FK_return_card FOREIGN KEY (cardNum)
REFERENCES reCards(cardNum);

ALTER TABLE returnExchange
ADD CONSTRAINT FK_return_em FOREIGN KEY (emCode)
REFERENCES employees(emCode);


INSERT INTO CATEGORYS
VALUES(1, 'Truyen');
INSERT INTO CATEGORYS
VALUES(2, 'SGK');
INSERT INTO CATEGORYS
VALUES(3, 'Tu Dien');
INSERT INTO CATEGORYS
VALUES(4, 'Vien Tuong');



Insert into employees(emCode,emLastName,emFirstName,birth,gender,adress,phone,email)
Values(1,'Tran','Van A', '19/09/1998','Male', 'tp.hcm', '090909090', 'asdaa@gmail.com');

Insert into employees(emCode,emLastName,emFirstName,birth,gender,adress,phone,email)
Values(2,'Nguyen','Thi B', '19/09/1998','Female', 'tp.hcm', '0797878787', 'asdaa@gmail.com');
select * from books;

CREATE OR REPLACE PROCEDURE bookquery
(book_id IN books.bookcode%TYPE,
                  book_name  OUT books.bookname%TYPE) IS
              BEGIN
                SELECT bookname INTO book_name
                 FROM books
                  WHERE bookcode = book_id;
              END bookquery;



/*show parameters sga;

  select name, value from v$sga;
  
  
desc v$instance;
select instance_name, HOST_NAME, VERSION, STARTUP_TIME, STATUS from v$instance;

show parameters sessions;

select sid, serial#, username, program from v$session;
select NAME, CREATED, OPEN_MODE, DATABASE_ROLE from v$database;

select distinct PROFILE from dba_profiles;
select * from dba_users;


CREATE PROFILE KHACHHANG2 LIMIT
CPU_PER_SESSION UNLIMITED
CPU_PER_CALL UNLIMITED
CONNECT_TIME UNLIMITED
IDLE_TIME UNLIMITED
SESSIONS_PER_USER UNLIMITED
LOGICAL_READS_PER_SESSION UNLIMITED
LOGICAL_READS_PER_CALL UNLIMITED
PRIVATE_SGA UNLIMITED
COMPOSITE_LIMIT UNLIMITED
PASSWORD_LIFE_TIME UNLIMITED
PASSWORD_GRACE_TIME DEFAULT
PASSWORD_REUSE_MAX UNLIMITED
PASSWORD_REUSE_TIME UNLIMITED
PASSWORD_LOCK_TIME 1
FAILED_LOGIN_ATTEMPTS 10
PASSWORD_VERIFY_FUNCTION NULL;

create profile C##hello limit FAILED_LOGIN_ATTEMPTS UNLIMITED PASSWORD_LIFE_TIME UNLIMITED;
select PROFILE from dba_profiles;

create user kh2 identified by kh2 profile C##hello;
select USERNAME, PASSWORD, a.account_status, a.default_tablespace, a.created, a.profile from dba_users a where a.USERNAME = 'KH1';

SELECT NAME FROM v$tablespace;

create profile "KJ" limit 
        cpu_per_session UNLIMITED
        cpu_per_call UNLIMITED
        connect_time UNLIMITED
        idle_time UNLIMITED
        sessions_per_user UNLIMITED
        logical_reads_per_session UNLIMITED
        logical_reads_per_call UNLIMITED
        private_sga UNLIMITED
        composite_limit UNLIMITED
        password_life_time 30
        password_grace_time 7
        password_reuse_max 1
        password_reuse_time 7
        password_verify_function NULL
        failed_login_attempts 3
        password_lock_time 10;




select PROFILE from dba_profiles;
select * from dba_users;

alter session set "_ORACLE_SCRIPT"=true;
CREATE USER aaa IDENTIFIED BY hr profile KHACHHANG2;


CREATE USER baby IDENTIFIED BY hr DEFAULT TABLESPACE USERS QUOTA 100M ON USERS PROFILE KHACHHANG2 ACCOUNT unlock;


select FILE_NAME, tablespace_name, BYTES, maxbytes, STATUS from dba_data_files;


show parameters audit;
select * from dba_fga_audit_trail;


CREATE AUDIT POLICY dml_pol
  ACTIONS DELETE on sys.BOOKS,
          INSERT on sys.BOOKS,
          UPDATE on sys.BOOKS;

drop role hulk;
select ROLE from dba_roles where role='IRONMAN' AND COMMON = 'NO';

select * from v$process;
select SID, SERIAL#, PADDR, USERNAME, MACHINE, PROGRAM,STATUS from v$session where type <> 'BACKGROUND';
alter system kill session '419,15233';
SELECT * FROM USER_SYS_PRIVS; 
SELECT * FROM USER_ROLE_PRIVS;
select * from users_users;
SELECT * FROM USER_TAB_PRIVS where GRANTEE <> 'SYS' AND GRANTEE <> 'PUBLIC';
SELECT * FROM sys.dba_tab_privs
    WHERE grantee <> 'SYS'  AND GRANTEE <> 'PUBLIC';
SELECT
  *
FROM
  DBA_TAB_PRIVS WHERE grantee = 'DONGPYROLES';
  
  select
   privilege
from
   sys.dba_sys_privs
 where
   grantee = 'DONGPYROLES'
union
select
   privilege
from
   dba_role_privs rp
join
   role_sys_privs rsp
on (rp.granted_role = rsp.role)
 where rp.grantee = 'DONGPYROLES'
 order by 1;


select * from  SESSION_ROLES;
delete from rememberuser;
select * from rememberuser;
SELECT * FROM user_tab_privs_recd;

select * from dba_audit_policies;
CREATE AUDIT POLICY EMPLOYEE_AUDIT
  ACTIONS DELETE on sys.EMPLOYEES,
          INSERT on sys.EMPLOYEES,
          UPDATE on sys.EMPLOYEES;
//
GRANT select, insert, update, delete on EMPLOYEES TO hr;
select * from dba_fga_audit_trail;
SELECT *
  FROM audit_unified_policies
  WHERE policy_name = 'EMPLOYEE_AUDIT';
  
  SELECT * FROM auditable_system_actions
  WHERE component = 'Standard'
  ORDER BY name;
  
  select * from DBA_STMT_AUDIT_OPTS;
begin 
DBMS_FGA.ADD_POLICY(
   object_schema =>'hr', 
   object_name => 'BOOKS', 
   policy_name => 'fga_lol',  
   statement_types => 'INSERT, SELECT, UPDATE, DELETE');
end;
set serveroutput on;
CREATE OR REPLACE PROCEDURE procOneINParameter(param1 IN VARCHAR2)
IS
BEGIN
  
  DBMS_OUTPUT.PUT_LINE('Hello World IN parameter ' || param1);

END;

CREATE OR REPLACE PROCEDURE GET_BOOK_NAME( BOOK_ID IN VARCHAR2, BOOK_NAME OUT VARCHAR2)
AS
BEGIN
  SELECT bookName INTO BOOK_NAME FROM BOOKS WHERE bookCode = BOOK_ID;
END;
DECLARE INPUT VARCHAR2 := '2';
BEGIN
GET_BOOK_NAME(INPUT);
DBMS_OUTPUT.PUT_LINE(INPUT);
END;

CREATE OR REPLACE PROCEDURE procOneINOUTParameter(genericParam IN OUT VARCHAR2)
IS
BEGIN
  
  genericParam := 'Hello World INOUT parameter ' || genericParam;

END;



CREATE OR REPLACE PROCEDURE bookquery
(book_id IN books.bookcode%TYPE,
                  book_name  OUT books.bookname%TYPE) IS
              BEGIN
                SELECT bookname INTO book_name
                 FROM books
                  WHERE bookcode = book_id;
              END bookquery;
declare 
incode varchar(50);
outname varchar(100);
begin
  incode := '1';
  schema.package.procedure(:incode, :outname);
end;
select * from v$controlfile;          
          */
