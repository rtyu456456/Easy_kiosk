create table cafe_menu(
        c_no number(3) primary key,
        c_name varchar2(20 char) not null,
        c_price number(6) not null
);

create sequence cafe_menu_seq;

insert into cafe_menu values (cafe_menu_seq.nextval, 'Ä¿ÇÇ', 3000);
insert into cafe_menu values (cafe_menu_seq.nextval, '³ìÂ÷', 3100);
insert into cafe_menu values (cafe_menu_seq.nextval, 'È«Â÷', 6000);
insert into cafe_menu values (cafe_menu_seq.nextval, '½º¹«µð', 8000);
insert into cafe_menu values (cafe_menu_seq.nextval, '¶ó¶¼', 6300);
insert into cafe_menu values (cafe_menu_seq.nextval, '¿ì·ÕÆ¼', 5000);

select * from cafe_menu;