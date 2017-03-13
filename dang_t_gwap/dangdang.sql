select dc.name from d_category dc join d_category_product dcp on (dc.id=dcp.cat_id) join d_product dp on (dcp.product_id=dp.id) where dp.id=2;

select dp.* from d_product dp join d_book db on (dp.id=db.id) where 
has_deleted=0 order by add_time desc limit 0,8


DROP TABLE IF EXISTS d_product;
CREATE TABLE d_product (
  id int(12) NOT NULL auto_increment,
  product_name varchar(100) NOT NULL,
  description varchar(100) default NULL,
  add_time bigint(20) default NULL,
  fixed_price double NOT NULL,
  dang_price double NOT NULL,
  keywords varchar(200) default NULL,
  has_deleted int(1) NOT NULL default '0',
  product_pic varchar(200) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO d_product VALUES (7,'Servlet��JSP���ı��','Servlet��JSP���ı��',1333107780707,207,187,'key',0,'22.jpg');
INSERT INTO d_product VALUES (14,'Jane Eyre','Jane Eyre',1333244980714,70,60,'key',0,'6.jpg');
INSERT INTO d_product VALUES (4,'���������','���������',1333304980704,204,184,'key',0,'19.jpg');
INSERT INTO d_product VALUES (8,'®��','®��',1333408980708,208,188,'key',0,'23.jpg');
INSERT INTO d_product VALUES (1,'һ��İ��Ů�˵�����','һ��İ��Ů�˵�����',1333501980701,201,181,'key',0,'16.jpg');
INSERT INTO d_product VALUES (15,'Java��ҵ��ѵ�̳�','Java��ҵ��ѵ�̳�',1333654980715,60,50,'key',0,'7.jpg');
INSERT INTO d_product VALUES (9,'�ſ�Ұ����','�ſ�Ұ����',1333709980709,209,189,'key',0,'24.jpg');
INSERT INTO d_product VALUES (5,'��������С��','��������С��',1333805980705,205,185,'key',0,'20.jpg');
INSERT INTO d_product VALUES (17,'ѩ��ʫѡ','ѩ��ʫѡ',1333974980717,40,30,'key',0,'9.jpg');
INSERT INTO d_product VALUES (21,'��������һ·ͬ��','��������һ·ͬ��',1334004280721,35,25,'key',0,'13.jpg');
INSERT INTO d_product VALUES (24,'���ߵ�С����','���ߵ�С����',1334104580724,65,35,'key',0,'1.jpg');
INSERT INTO d_product VALUES (10,'ͯ�� ���˼� �ҵĴ�ѧ','ͯ�� ���˼� �ҵĴ�ѧ',1334210980710,210,190,'key',0,'2.jpg');
INSERT INTO d_product VALUES (11,'��ˮ������','��ˮ������',1334324980711,100,80,'key',0,'3.jpg');
INSERT INTO d_product VALUES (16,'�軨Ů','�軨Ů',1334464980716,50,40,'key',0,'8.jpg');
INSERT INTO d_product VALUES (25,'������Դ¼','������Դ¼',1334504680725,65,55,'key',0,'25.jpg');
INSERT INTO d_product VALUES (19,'Ʈ','Ʈ',1334694980719,20,10,'key',0,'11.jpg');
INSERT INTO d_product VALUES (23,'ͯ��','ͯ��',1334704480723,55,45,'key',0,'15.jpg');
INSERT INTO d_product VALUES (3,'����˵','����˵',1333003980703,203,183,'key',0,'18.jpg');
INSERT INTO d_product VALUES (20,'�ؼ���������','�ؼ���������',1332904180720,25,15,'key',0,'12.jpg');
INSERT INTO d_product VALUES (6,'�������','�������',1332806980706,206,186,'key',0,'21.jpg');
INSERT INTO d_product VALUES (18,'���˼�','���˼�',1332784980718,30,20,'key',0,'10.jpg');
INSERT INTO d_product VALUES (12,'С����','С����',1332622980712,90,80,'key',0,'4.jpg');
INSERT INTO d_product VALUES (22,'������ƫ��','������ƫ��',1332504380722,45,35,'key',0,'14.jpg');
INSERT INTO d_product VALUES (2,'³��ѷƯ����','³��ѷƯ����',1332402980702,202,182,'key',0,'17.jpg');
INSERT INTO d_product VALUES (13,'˫����','˫����',1332334980713,80,70,'key',0,'5.jpg');



DROP TABLE IF EXISTS d_book;
CREATE TABLE d_book (
  id int(12) NOT NULL,
  author varchar(200) NOT NULL,
  publishing varchar(200) NOT NULL,
  publish_time bigint(20) NOT NULL,
  word_number varchar(15) default NULL,
  which_edtion varchar(15) default NULL,
  total_page varchar(15) default NULL,
  print_time int(20) default NULL,
  print_number varchar(15) default NULL,
  isbn varchar(25) default NULL,
  author_summary text NOT NULL,
  catalogue text NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_book VALUES (1,'��д��','���������',1333104980701,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (2,'��д��','���������',1333204980702,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (3,'��д��','���������',1333304980703,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (4,'��д��','���������',1333404980704,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (5,'��д��','���������',1333504980705,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (6,'��д��','���������',1333604980706,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (7,'��д��','���������',1333704980707,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (8,'��д��','���������',1333804980708,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (9,'��д��','���������',1333904980709,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (10,'��д��','���������',1330804980710,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (11,'��д��','���������',1333104980711,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (12,'��д��','���������',1333204980712,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (13,'��д��','���������',1333304980713,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (14,'��д��','���������',1333404980714,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (15,'��д��','���������',1333504980715,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (16,'��д��','���������',1333604980716,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (17,'��д��','���������',1333704980717,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (18,'��д��','���������',1333804980718,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (19,'��д��','���������',1333904980719,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (20,'��д��','���������',1333004980720,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (21,'��д��','���������',1333894980721,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (22,'��д��','���������',1333884980722,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (23,'��д��','���������',1333874980723,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (24,'��д��','���������',1333864980724,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (25,'��д��','���������',1333854980725,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');


DROP TABLE IF EXISTS d_category;
CREATE TABLE d_category (
  id int(12) NOT NULL auto_increment,
  turn int(10) NOT NULL,
  en_name varchar(200) NOT NULL,
  name varchar(200) NOT NULL,
  description varchar(200),
  parent_id int(10),
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_category VALUES (1,1,'Book','ͼ��',NULL,0);
INSERT INTO d_category VALUES (2,1,'Novel','С˵',NULL,1);
INSERT INTO d_category VALUES (3,2,'Youth','�ഺ',NULL,1);
INSERT INTO d_category VALUES (4,3,'Humanity And Social Science','�������',NULL,1);
INSERT INTO d_category VALUES (5,4,'Management','����',NULL,1);
INSERT INTO d_category VALUES (6,5,'Children','�ٶ�',NULL,1);
INSERT INTO d_category VALUES (7,6,'Foreign Language','����',NULL,1);
INSERT INTO d_category VALUES (8,7,'Computer','�����',NULL,1);
INSERT INTO d_category VALUES (9,1,'Chinese Contemporary Novel','����С˵',NULL,2);
INSERT INTO d_category VALUES (10,2,'Chinese Modern Novel','���ִ�С˵',NULL,2);
INSERT INTO d_category VALUES (11,3,'Chinese Classical  Novel','�ŵ�С˵',NULL,2);
INSERT INTO d_category VALUES (12,4,'Four Classic Novels','�Ĵ�����',NULL,2);
INSERT INTO d_category VALUES (13,5,'Translated Works','��������',NULL,2);
INSERT INTO d_category VALUES (14,1,'School','У԰',NULL,3);
INSERT INTO d_category VALUES (15,2,'Love','����/���',NULL,3);
INSERT INTO d_category VALUES (16,3,'Grow Up','����/�ɳ�',NULL,3);
INSERT INTO d_category VALUES (17,4,'Fantasy','����',NULL,3);
INSERT INTO d_category VALUES (18,5,'Original','ԭ��',NULL,3);
INSERT INTO d_category VALUES (19,1,'Political','����',NULL,4);
INSERT INTO d_category VALUES (20,2,'Economic','����',NULL,4);
INSERT INTO d_category VALUES (21,3,'Law','����',NULL,4);
INSERT INTO d_category VALUES (22,4,'Philosophy','��ѧ',NULL,4);
INSERT INTO d_category VALUES (23,5,'History','��ʷ',NULL,4);
INSERT INTO d_category VALUES (24,1,'Commen Management','����ѧ',NULL,5);
INSERT INTO d_category VALUES (25,2,'Strategic Management','ս�Թ���',NULL,5);
INSERT INTO d_category VALUES (26,3,'Marketing','�г�Ӫ��',NULL,5);
INSERT INTO d_category VALUES (27,4,'Business History','��ҵʷ��',NULL,5);
INSERT INTO d_category VALUES (28,5,'E-Business','��������',NULL,5);
INSERT INTO d_category VALUES (29,1,'0-2','0-2��',NULL,6);
INSERT INTO d_category VALUES (30,2,'3-6','3-6��',NULL,6);
INSERT INTO d_category VALUES (31,3,'7-10','7-10��',NULL,6);
INSERT INTO d_category VALUES (32,4,'11-14','11-14��',NULL,6);
INSERT INTO d_category VALUES (33,5,'Child Literature','��ͯ��ѧ',NULL,6);
INSERT INTO d_category VALUES (34,1,'English','Ӣ��',NULL,7);
INSERT INTO d_category VALUES (35,2,'Japanese','����',NULL,7);
INSERT INTO d_category VALUES (36,3,'Korean','����',NULL,7);
INSERT INTO d_category VALUES (37,4,'Russian','����',NULL,7);
INSERT INTO d_category VALUES (38,5,'German','����',NULL,7);
INSERT INTO d_category VALUES (39,1,'Computer Theory','���������',NULL,8);
INSERT INTO d_category VALUES (40,2,'Database','���ݿ�',NULL,8);
INSERT INTO d_category VALUES (41,3,'Programming','�������',NULL,8);
INSERT INTO d_category VALUES (42,4,'Artificial Intelligence','�˹�����',NULL,8);
INSERT INTO d_category VALUES (43,5,'Computer Examination','���������',NULL,8);



DROP TABLE IF EXISTS d_category_product;
CREATE TABLE d_category_product (
  id int(12) NOT NULL auto_increment,
  product_id int(10) NOT NULL,
  cat_id int(10) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_category_product VALUES (1,1,9);
INSERT INTO d_category_product VALUES (2,2,9);
INSERT INTO d_category_product VALUES (3,3,9);
INSERT INTO d_category_product VALUES (4,4,9);
INSERT INTO d_category_product VALUES (5,5,9);
INSERT INTO d_category_product VALUES (6,6,9);
INSERT INTO d_category_product VALUES (7,7,9);
INSERT INTO d_category_product VALUES (8,8,9);
INSERT INTO d_category_product VALUES (9,9,9);
INSERT INTO d_category_product VALUES (10,10,9);
INSERT INTO d_category_product VALUES (11,11,10);
INSERT INTO d_category_product VALUES (12,12,10);
INSERT INTO d_category_product VALUES (13,13,10);
INSERT INTO d_category_product VALUES (14,14,10);
INSERT INTO d_category_product VALUES (15,15,10);
INSERT INTO d_category_product VALUES (16,16,10);
INSERT INTO d_category_product VALUES (17,17,10);
INSERT INTO d_category_product VALUES (18,18,10);
INSERT INTO d_category_product VALUES (19,19,10);
INSERT INTO d_category_product VALUES (20,20,10);
INSERT INTO d_category_product VALUES (21,21,10);
INSERT INTO d_category_product VALUES (22,22,10);
INSERT INTO d_category_product VALUES (23,23,10);
INSERT INTO d_category_product VALUES (24,24,10);
INSERT INTO d_category_product VALUES (25,25,10);


INSERT INTO d_category_product VALUES (26,1,2);
INSERT INTO d_category_product VALUES (27,2,2);
INSERT INTO d_category_product VALUES (28,3,2);
INSERT INTO d_category_product VALUES (29,4,2);
INSERT INTO d_category_product VALUES (30,5,2);
INSERT INTO d_category_product VALUES (31,6,2);
INSERT INTO d_category_product VALUES (32,7,2);
INSERT INTO d_category_product VALUES (33,8,2);
INSERT INTO d_category_product VALUES (34,9,2);
INSERT INTO d_category_product VALUES (35,10,2);
INSERT INTO d_category_product VALUES (36,11,2);
INSERT INTO d_category_product VALUES (37,12,2);
INSERT INTO d_category_product VALUES (38,13,2);
INSERT INTO d_category_product VALUES (39,14,2);
INSERT INTO d_category_product VALUES (40,15,2);
INSERT INTO d_category_product VALUES (41,16,2);
INSERT INTO d_category_product VALUES (42,17,2);
INSERT INTO d_category_product VALUES (43,18,2);
INSERT INTO d_category_product VALUES (44,19,2);
INSERT INTO d_category_product VALUES (45,20,2);
INSERT INTO d_category_product VALUES (46,21,2);
INSERT INTO d_category_product VALUES (47,22,2);
INSERT INTO d_category_product VALUES (48,23,2);
INSERT INTO d_category_product VALUES (49,24,2);
INSERT INTO d_category_product VALUES (50,25,2);


INSERT INTO d_category_product VALUES (51,1,1);
INSERT INTO d_category_product VALUES (52,2,1);
INSERT INTO d_category_product VALUES (53,3,1);
INSERT INTO d_category_product VALUES (54,4,1);
INSERT INTO d_category_product VALUES (55,5,1);
INSERT INTO d_category_product VALUES (56,6,1);
INSERT INTO d_category_product VALUES (57,7,1);
INSERT INTO d_category_product VALUES (58,8,1);
INSERT INTO d_category_product VALUES (59,9,1);
INSERT INTO d_category_product VALUES (60,10,1);
INSERT INTO d_category_product VALUES (61,11,1);
INSERT INTO d_category_product VALUES (62,12,1);
INSERT INTO d_category_product VALUES (63,13,1);
INSERT INTO d_category_product VALUES (64,14,1);
INSERT INTO d_category_product VALUES (65,15,1);
INSERT INTO d_category_product VALUES (66,16,1);
INSERT INTO d_category_product VALUES (67,17,1);
INSERT INTO d_category_product VALUES (68,18,1);
INSERT INTO d_category_product VALUES (69,19,1);
INSERT INTO d_category_product VALUES (70,20,1);
INSERT INTO d_category_product VALUES (71,21,1);
INSERT INTO d_category_product VALUES (72,22,1);
INSERT INTO d_category_product VALUES (73,23,1);
INSERT INTO d_category_product VALUES (74,24,1);
INSERT INTO d_category_product VALUES (75,25,1);

DROP TABLE IF EXISTS d_item;
CREATE TABLE d_item (
  id int(12) NOT NULL auto_increment,
  order_id int(10) NOT NULL,
  product_id int(10) NOT NULL,
  product_name varchar(100) NOT NULL,
  dang_price double NOT NULL,
  product_num int(10) NOT NULL,
  amount double NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS d_order;
CREATE TABLE d_order (
  id int(10) NOT NULL auto_increment,
  user_id int(10) NOT NULL,
  status int(10) NOT NULL,
  order_time bigint(20) NOT NULL,
  order_desc varchar(200) default NULL,
  total_price double NOT NULL,
 
  receive_name varchar(100) default NULL,
  full_address varchar(200) default NULL,
  postal_code varchar(8) default NULL,
  mobile varchar(20) default NULL,
  phone varchar(20) default NULL,
  
  PRIMARY KEY  (id)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS d_receive_address;
CREATE TABLE d_receive_address (
  id int(12) NOT NULL auto_increment,
  user_id int(11) NOT NULL,
  receive_name varchar(20) NOT NULL,
  full_address varchar(200) NOT NULL,
  postal_code varchar(8) NOT NULL,
  mobile varchar(15) default NULL,
  phone varchar(20) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS d_user;
CREATE TABLE d_user (
  id int(12) NOT NULL auto_increment,
  email varchar(50) NOT NULL,
  nickname varchar(50) default NULL,
  password varchar(50) NOT NULL,
  user_integral int(12) NOT NULL default '0',
  is_email_verify char(3),
  email_verify_code varchar(50) default NULL,
  last_login_time bigint default NULL,
  last_login_ip varchar(15) default NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
