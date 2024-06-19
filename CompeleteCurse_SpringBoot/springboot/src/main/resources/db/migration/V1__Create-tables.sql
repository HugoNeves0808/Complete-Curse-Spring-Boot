create table tb_products (value numeric(38,2), id_product uuid not null, description varchar(255), name varchar(255), primary key (id_product));
create table users (role smallint check (role between 0 and 1), id uuid not null, login varchar(255), password varchar(255), primary key (id));
