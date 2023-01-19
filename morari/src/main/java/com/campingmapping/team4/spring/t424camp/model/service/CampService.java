package com.campingmapping.team4.spring.t424camp.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t424camp.model.dao.repository.CampRepository;
import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.entity.City;
import com.campingmapping.team4.spring.t424camp.model.entity.Site;
import com.campingmapping.team4.spring.t424camp.model.entity.Tag;

@Service
@Transactional
public class CampService {

	@Autowired
	private CampRepository campRepository;

	@Autowired
	private SiteService siteService;

	@Autowired
	private CityService cityService;

	@Autowired
	private TagService tagService;

	// 新增Camp
	public Camp insert(String campName, Integer cityID, String location, String campPicturesPath, String description,
			int[] tagIDs) {

		Set<Tag> tags = new HashSet<Tag>();
		for (int tagID : tagIDs) {
			Tag tag = tagService.findById(tagID);
			tags.add(tag);
		}

		City city = cityService.findById(cityID);

		Camp camp = new Camp(campName, city, location, campPicturesPath, description, tags);

		return campRepository.save(camp);
	}

	// 找全部Camp
	public List<Camp> findAll() {
		return campRepository.findAll();
	}

	// Id找Camp
	public Camp findById(int campId) {
		Optional<Camp> op = campRepository.findById(campId);
		Camp camp = null;

		if (op.isPresent()) {
			camp = op.get();
		}

		return camp;
	}

	// 更新Camp
	public Camp update(Integer campID, String campName, Integer cityID, String location, String campPicturesPath,
			String description, int[] tagIDs) {

		Set<Tag> tags = new HashSet<Tag>();
		for (int tagID : tagIDs) {
			Tag tag = tagService.findById(tagID);
			tags.add(tag);
		}

		City city = cityService.findById(cityID);

		Camp camp = new Camp(campID, campName, city, location, campPicturesPath, description, tags);

		return campRepository.save(camp);
	}

	// 刪除Camp
	public boolean deleteById(Integer campId) {
		Camp camp = findById(campId);

		if (camp != null) {
//			//fkCityId設null
//			camp.setCity(null);
//
//			//刪除TagOfCamp
//			Set<Tag> tags = camp.getTags();
//			if(tags.size() != 0) {
//				Iterator<Tag> it1 = tags.iterator();
//				while (it1.hasNext()) {
//					it1.remove();
//				}
//			}
//			
			// 刪除SiteOfCamp
			Set<Site> sites = camp.getSites();
			if (sites.size() != 0) {
				for (Site site : sites) {
					site.setCamp(null);
					siteService.deleteById(site.getSiteID());
				}
			}
		}

		campRepository.deleteById(campId);
		return true;
	}

}
