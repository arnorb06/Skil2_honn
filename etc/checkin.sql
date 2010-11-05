CREATE TABLE checkin (
  id int Identity (1, 1) primary key NOT NULL,
  title varchar(64) NOT NULL,
  checkindate datetime,
  username varchar(64) NOT NULL,
  venueid int NOT NULL
)

