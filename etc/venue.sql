CREATE TABLE venues (
  id int Identity (1, 1) primary key NOT NULL,
  name varchar(128),
  street varchar(128),
  city varchar(128),
  country varchar(128),
  postalCode varchar(128),
  venuetype varchar(16),
  totalcheckins int
)
