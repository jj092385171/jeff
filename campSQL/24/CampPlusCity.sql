create view CampPlusCity (campID, campName, cityID, cityName, location, campPictures, discription)
as
select camp.campID, camp.campName, camp.cityID, city.cityName, camp.location, camp.campPictures, camp.discription
from camp  join city on(camp.cityID = city.cityID);


select * 
from CampPlusCity;


