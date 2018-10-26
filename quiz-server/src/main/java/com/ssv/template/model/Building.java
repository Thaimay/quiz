package com.ssv.template.model;

public class Building {
	private int id;
	private String name;
	private String nameJp;
	private int heightM;
	private int heightFt;
	private int floors;
	private String year;
	private String city;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameJp() {
		return nameJp;
	}

	public void setNameJp(String nameJp) {
		this.nameJp = nameJp;
	}

	public int getHeightM() {
		return heightM;
	}

	public void setHeightM(int heightM) {
		this.heightM = heightM;
	}

	public int getHeightFt() {
		return heightFt;
	}

	public void setHeightFt(int heightFt) {
		this.heightFt = heightFt;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
