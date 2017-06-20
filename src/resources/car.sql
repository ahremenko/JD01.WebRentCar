drop table rentcar.rc_car;

create table rentcar.rc_car (  `id` int not null AUTO_INCREMENT
						, `model` varchar(100)
						, `model_type`	varchar(100)
						, `car_case`	varchar(100)
						, `year_manufactured`	int 
						, `transmission_type` varchar(5)	
						, `fuel_type` varchar(100)	
						, `max_distance` int
						, `price` float
						, `rec_state` int default 1
						, `change_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
						, `change_user` int
						, PRIMARY KEY (`id`)
						, KEY `idx_car` (`rec_state`)
						) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;


select * from rentcar.rc_car;

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `transmission_type`, `price`) 
values ('HONDA', 'Insight', 'HATCHBACK', 2014, 'BENZINE', 'AT', 45.00);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `transmission_type`, `price`) 
values ('Toyota', 'Corolla', 'SEDAN', 2012, 'DIESEL', 'MT', 40.00);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `transmission_type`, `price`) 
values ('VW', 'Multivan', 'BUS', 2010, 'DIESEL', 'MT', 65.00);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `max_distance`, `price`) 
values ('TESLA', 'Model S', 'HATCHBACK', 2016, null, 420, 62.50);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `max_distance`, `price`) 
values ('MITSUBISHI', 'i-MiEV', null, 2012, null, 170, 47.90);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `transmission_type`, `price`) 
values ('DODGE', 'Dakota', 'JEEP', 2007, 'GAS', 'AT', 19.99);

insert into rentcar.rc_car (`model`, `model_type`, `car_case`, `year_manufactured`, `fuel_type`, `max_distance`, `price`) 
values ('TESLA', 'Model X Ultimate Edition', null, 2017, null, 495, 79.99);

/*6;TESLA;Model_S;HATCHBACK;;62.2;420;
7;TESLA;Model_X_Ultimate_Edition;ND;2017;79.0;490;
9;MITSUBISHI;Carisma;JEEP;2014;37.0;AT;BENZINE;
10;TESLA;MODEL_S;HATCHBACK;2017;80.0;425;*/

/*update `rc_users` set `is_admin` = 1 where `user_login` = 'admin';*/

commit;
