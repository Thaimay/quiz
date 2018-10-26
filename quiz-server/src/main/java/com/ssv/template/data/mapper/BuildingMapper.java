package com.ssv.template.data.mapper;

import com.ssv.template.model.Building;

public interface BuildingMapper extends Mapper<Building> {
	public int insertBuilding(Building building);

	public int updateBuilding(Building building);

	public int deleteBuildingById(int id);

}
