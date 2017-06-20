drop table rentcar.rc_order;

create table rentcar.rc_order (  `id` int not null AUTO_INCREMENT
						, `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP 
						, `change_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
						, `user_id` int
						, `car_id`	int
						, `date_from`	date
						, `days`	int
						, `total_cost`	float
						, `payment`	float
						, `rec_state` int default 1
						, PRIMARY KEY (`id`)
						, KEY `idx_order_user` (`user_id`)
						, KEY `idx_order_date` (`date_from`)
						, KEY `idx_order_recstate` (`rec_state`)
						) ENGINE=InnoDB AUTO_INCREMENT=5001 DEFAULT CHARSET=utf8;


alter table rentcar.rc_order add constraint rc_order_usr_fk foreign key (user_id) references rentcar.rc_user(id);

alter table rentcar.rc_order add constraint rc_order_car_fk foreign key (car_id) references rentcar.rc_car(id);

select * from rentcar.rc_order;