create view CampSiteCityTag (campID, campName, cityID, cityName, location, campPictures, discription, tagID, tagName, siteID, siteName, sitePictures, totalSites, siteMoney)
as
select cct.campID, cct.campName, cct.cityID, cct.cityName, cct.location, cct.campPictures, cct.discription, cct.tagID, cct.tagName, s.siteID, s.siteName, s.sitePictures, s.totalSites, s.siteMoney
from CampPlusCityPlusTag cct join site s on(cct.campID = s.campID);

