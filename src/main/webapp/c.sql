create table cafe_menu(
        c_no number(3) primary key,
        c_name varchar2(20 char) not null,
        c_price number(6) not null
);

create sequence cafe_menu_seq;

insert into cafe_menu values (cafe_menu_seq.nextval, 'Ŀ��', 3000);
insert into cafe_menu values (cafe_menu_seq.nextval, '����', 3100);
insert into cafe_menu values (cafe_menu_seq.nextval, 'ȫ��', 6000);
insert into cafe_menu values (cafe_menu_seq.nextval, '������', 8000);
insert into cafe_menu values (cafe_menu_seq.nextval, '��', 6300);
insert into cafe_menu values (cafe_menu_seq.nextval, '���Ƽ', 5000);

select * from cafe_menu;