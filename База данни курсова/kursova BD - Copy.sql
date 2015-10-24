

 DROP DATABASE IF EXISTS `hotel`;
 create DATABASE hotel;
 use hotel;
 create table `hotel`.`Room`
 ( 
 `categoriq` tinyint not null,
 `brBeds` tinyint not null,
 `izgled`  enum ('more','planina','ezero','reka'),
 `cena` float,
 `roomID` int not null auto_increment,
 primary key (`roomID`)
 );
 
 GRANT ALL
ON hotel.*
TO 'philip'@'localhost'
IDENTIFIED BY 'topsecretpass';
 
 insert into `hotel`.`Room`( `categoriq`,`brBeds`,`izgled`,`cena`) values
 (1,1,"more",15.5),
 (1,2,'planina',34.5),
 (1,3,'ezero',35.5), 
 (1,4,'more',37.5), 
 (2,1,'planina',40.9),
 (2,2,'ezero',28.5),
 (2,3,'more',30.4),
 (2,4,'planina',40.5),
 (3,1,'reka',50.4),
 (3,2,'more',60.5),
 (3,3,"planina",70.5),
 (3,4,'more',15.5),
 (4,1,'more',25.5), 
 (4,2,'ezero',37.5), 
 (4,3,'planina',40.9),
 (4,4,'more',80.5),
 (4,4,'more',72.4),
 (5,1,'planina',30.5),
 (5,2,'more',50.4),
 (5,3,'reka',60.5),
 (5,4,"planina",90.5),
 (5,3,'more',34.5),
 (3,1,'reka',35.5), 
 (4,3,'reka',37.5), 
 (5,2,'more',40.9),
 (5,3,'ezero',30.5),
 (1,2,'reka',50.4),
 (5,3,'more',40.5),
 (3,2,'reka',50.4),
 (4,3,'more',15.5),
 (3,1,'reka',50.4),
 (3,2,'more',60.5),
 (3,3,"planina",15.5),
 (3,4,'more',34.5),
 (4,1,'more',35.5), 
 (4,2,'ezero',37.5), 
 (4,3,'planina',40.9),
 (4,4,'more',28.5),
 (4,4,'more',50.4),
 (5,1,'planina',40.5),
 (5,2,'more',50.4),
 (5,3,'reka',60.5),
 (5,4,"planina",120),
 (5,3,'more',64.5),
 (3,1,'planina',35.5), 
 (4,3,'ezero',47.5), 
 (5,2,'more',50.9),
 (5,3,'ezero',68.5),
 (1,2,'more',20.4),
 (5,3,'ezero',70.5),
 (3,2,'reka',50.4),
 (4,3,'ezero',80.5);
   
 create table `hotel`.`CurrentGuest`
 (
 `firstname` TINYTEXT NOT NULL ,
 `middlename` TINYTEXT NULL DEFAULT NULL ,
 `lastname` TINYTEXT NOT NULL ,
 `phone` BIGINT(10) NOT NULL,
 `guestID` int not null auto_increment,
 primary key (`guestID`)
 );
 insert into  `hotel`.`CurrentGuest`(`firstname` ,`middlename`,`lastname` ,`phone` )values 
 ('Ivan' ,'Petrov','Ivanov' ,'1234564578' ),
 ('to6o' ,'Petrov','Petrov' ,'1234564578' ),
 ('Veso' ,'Petrov','Todorov' ,'1234564578'),
 ('Pepi' ,'Petrov','Petrov' ,'1234564578'),
 ('Alex' ,'Atanasov','Mladjov' ,'1234564578' );

 
	
 create table `hotel`.`Booking`
 (
 `B_guestID` int  not null,
 `B_roomID` int  not null,
 `StartDate` date,
 `EndDate` date,
 foreign key(`B_guestID`) references `hotel`.`CurrentGuest`(`guestID`) ON DELETE CASCADE ON UPDATE CASCADE,
 foreign key(`B_roomID`) references `hotel`.`Room`(`roomID`) ON DELETE CASCADE ON UPDATE CASCADE,
 primary key(`B_guestID`,`B_roomID`)
 );
 insert into `hotel`.`Booking` (`B_guestID`,`B_roomID`,`StartDate`,`EndDate`) values (5,1,'2015-03-26','2016-03-30'), (4,9,'2015-03-26' , '2015-03-30 '),(3,9,'2016-04-30 ','2016-05-30 '),(1,3,'2014-03-20' , '2014-03-22 '),(2,1,'2015-03-20' , '2015-03-22' );
 
 
 DELIMITER |

 CREATE PROCEDURE show_currentGuests() SELECT DISTINCT `firstname`,`middlename`,`lastname`,`phone`,`EndDate`,`B_roomID` FROM `CurrentGuest` JOIN `Booking` where EndDate>CURDATE() and `B_guestID`=`guestID`;  END |
 
DELIMITER ;
DELIMITER |

 CREATE PROCEDURE show_pastGuests() SELECT DISTINCT `firstname`,`middlename`,`lastname`,`phone`,`EndDate`,`B_roomID` FROM `CurrentGuest` JOIN `Booking` where EndDate<CURDATE() and `B_guestID`=`guestID`;  END |

DELIMITER ;

CALL show_currentGuests();
CALL show_pastGuests();
 
 DELIMITER |

 CREATE PROCEDURE show_rooms(in `Serv_categoriq` tinyint , `Serv_brBeds` tinyint ,`Serv_izgled`  enum ('more','planina','ezero','reka'), `Serv_cena` float ) Select roomId from room where roomId not in(select B_roomID from Booking where B_guestID in(select guestId from Currentguest where  endDate>curdate() )) and categoriq=Serv_categoriq and izgled=Serv_izgled and brbeds=Serv_brbeds and cena<Serv_cena;  END |

DELIMITER ;
 DELIMITER |

 CREATE PROCEDURE show_NUMrooms(in `Serv_categoriq` tinyint , `Serv_brBeds` tinyint ,`Serv_izgled`  enum ('more','planina','ezero','reka'), `Serv_cena` float ) Select count(*) from room where roomId not in(select B_roomID from Booking where B_guestID in(select guestId from Currentguest where  endDate>curdate() )) and categoriq=Serv_categoriq and izgled=Serv_izgled and brbeds=Serv_brbeds and cena<Serv_cena;  END |

DELIMITER ;
 
 
 
  Call show_rooms(4,3,'ezero',180);
  Call show_NUMrooms(4,3,'ezero',180);
  DROP PROCEDURE IF EXISTS show_NUMrooms;
  DROP PROCEDURE IF EXISTS show_rooms;
  DROP PROCEDURE IF EXISTS show_pastGuests;
  DROP PROCEDURE IF EXISTS show_currentGuests;
 
 