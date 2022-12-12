create view TagPlusCamp(campID, tagID, tagName)
as
select tagofcamp.campid, tagofcamp.tagid, tag.tagname
from tagofcamp join tag on(tagofcamp.tagid = tag.tagid);

select * 
from TagPlusCamp;