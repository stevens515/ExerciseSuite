create table book
(
	id varchar(40) primary key,
	name varchar(40) not null unique,	#����
	price decimal (8,2) not null,	#�۸�
	author varchar(40) not null,	#����
	image varchar(255) not null,		#ͼƬ��λ�ú�ͼƬ������
	description varchar(255),		#����
	category_id varchar(40),		#���id
	constraint category_id_FK foreign key(category_id) references category(id)
);