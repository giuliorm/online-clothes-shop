create table shopItem(
  id serial primary key,
  name varchar(25) not null,
  description varchar(200) not null,
  price real
);

create table users(

  id serial primary key,
  email varchar(20) not null,
  password varchar(50) not null

);

create table shopItem_user (
  userId integer,
  shopItemId integer
);
