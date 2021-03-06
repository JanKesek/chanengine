create table board_threads(board_id int not null, thread_id int not null,primary key (board_id, thread_id), foreign key (board_id) references board(id), foreign key(thread_id) references thread(id));
create table thread_posts(post_id int not null, thread_id int not null,primary key (post_id, thread_id), foreign key (post_id) references post(id), foreign key(thread_id) references thread(id));
create table image(id serial not null primary key,imageFilename varchar(400));
content varchar(5000) not null, username varchar(50) default 'Anonymous', thread_id int not null references thread(id));
create table thread(id serial not null primary key, imageFilename varchar(400) not null, name varchar(20) default null,
 thread_time timestamp not null,content varchar(5000) not null, username varchar(50) default 'Anonymous',
 board_id int not null references board(id));
insert into thread(imageFilename,thread_time,content,board_id) values('images/errorsql.png',current_timestamp,'test1',3);