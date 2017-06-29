drop table rentcar.rc_users;

create table rentcar.rc_user (  `id` int not null AUTO_INCREMENT
						, `user_name` varchar(100)
						, `user_login`	varchar(30)
						, `is_admin`	int default 0
						, `rec_state` int default 1
						, `user_password` varchar(100)
						, `change_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
						, PRIMARY KEY (`id`)
						, KEY `idx_user_login` (`user_login`)
						) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;


create unique index rc_user_ui01 on rentcar.rc_user (user_login);

/*select id, user_login, user_password from rentcar.rc_user;*/

/*delete from rentcar.rc_user where id = 1003;*/

insert into rentcar.rc_user (`user_name`, `user_login`, `user_password`, `is_admin`) values ('administrator (root)', 'admin', '111111', 1);

/*update `rc_users` set `is_admin` = 1 where `user_login` = 'admin';*/

insert into rentcar.rc_user (`user_name`, `user_login`, `user_password`) values ('simple user', 'user1', '222222');

commit;
