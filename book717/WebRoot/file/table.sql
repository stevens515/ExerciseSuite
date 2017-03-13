--图书类别表
CREATE TABLE category
(
   id VARCHAR(40) PRIMARY KEY,
   NAME VARCHAR(40) NOT NULL UNIQUE,  #分类名称
   description VARCHAR(255)           #分类描述
);


create table book
(
	id varchar(40) primary key,
	name varchar(40) not null unique,  #书名
	price decimal(8,2) not null,       #价格
	author varchar(40) not null,       #作者
	image varchar(255) not null,       #图片的位置和图片的名称
	description varchar(255),          #描述
	category_id varchar(40),           #类别id
	constraint category_id_FK foreign key(category_id) references category(id)
);	