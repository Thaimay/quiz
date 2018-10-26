package com.ssv.template.service;

import java.util.List;
import java.util.Optional;

import com.ssv.template.data.repository.BuildingRepository;
import com.ssv.template.model.Building;

public class BuildingService {

	public int insertBuilding(Building building) {
		return new BuildingRepository().insertBuilding(building);
	}

	public int updateBuilding(Building building) {
		return new BuildingRepository().updateBuilding(building);
	}

	public int deleteBuildingById(int id) {
		return new BuildingRepository().deleteBuildingById(id);
	}

	public List<Building> selectAllBuilding() {
		return new BuildingRepository().findAll();
	}

	public Building selectBuildingById(int id) {
		Optional<Building> optBuilding = new BuildingRepository().findById(id);
		if (optBuilding.isPresent()) {
			return optBuilding.get();
		}
		return null;
	}

}
