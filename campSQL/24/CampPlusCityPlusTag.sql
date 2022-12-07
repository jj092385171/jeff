create view CampPlusCityPlusTag (campID, campName, cityID, cityName, location, campPictures, discription, tagID, tagName)
as
select cpc.campID, cpc.campName, cpc.cityID, cpc.cityName, cpc.location, cpc.campPictures, cpc.discription, tpc.tagID, tpc.tagName
from CampPlusCity cpc join TagPlusCamp tpc on(cpc.campID = tpc.campID);