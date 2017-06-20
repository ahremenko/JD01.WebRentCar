drop table rentcar.rc_log;

create table rentcar.rc_log (  `id` int not null AUTO_INCREMENT
						, `change_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
						, `user_id` int
						, `place`	varchar(1000)
						, `message_text`	varchar(4000)
						, PRIMARY KEY (`id`)
						, KEY `idx_log` (`change_date`)
						) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;


select * from rentcar.rc_log;

alter table rentcar.rc_log add foreign key (user_id) references rentcar.rc_user(id);



