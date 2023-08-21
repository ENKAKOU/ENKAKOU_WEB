create table dept(
	did int primary key auto_increment,
	dname varchar(20)
);
insert into dept values (null,'市场部');
insert into dept values (null,'人事部');
insert into dept values (null,'教研部');


create table employee(
	eid int primary key auto_increment,
	ename varchar(20),
	salary double,
	birthday date,
	sex varchar(10),
	dno int
);

insert into employee values (null,'张三',8000,'1988-09-01','男',3);

insert into employee values (null,'李四',9000,'1988-09-01','男',1);

insert into employee values (null,'王五',6000,'1988-09-01','男',2);

insert into employee values (null,'赵六',10000,'1988-09-01','男',3);

insert into employee values (null,'孙七',10000,'1988-09-01','男',1);

insert into employee values (null,'田八',10000,'1988-09-01','男',null);

delete from dept where did = 2;

alter table employee add foreign key (dno) references dept(did);