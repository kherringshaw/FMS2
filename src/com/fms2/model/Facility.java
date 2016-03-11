package com.fms2.model;

import java.util.List;


public class Facility{
	private int facilityID;
	private String owner;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private double rate;
	private int capacity;
	private int size;
	private String detail;
	
	private List<Facility_MaintReq> requests;
	private List<Facility> facList;
	
    // Constructor with facility details
    public Facility(int id, String owner, String address1, String address2, String city, String state, String zip, double rate, int capacity) {
        this.facilityID = id;
        this.owner = owner;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.rate = rate;
        this.capacity = capacity;
    }
    
    public Facility( int id, String details){
    	this.facilityID = id;
    	this.detail = details;
    }


	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int id) {
		this.facilityID = id;
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public String getAddress1(){
		return address1;
	}
	
	public void setAddress1(String address1){
		this.address1 = address1;
	}
	
	public String getAddress2(){
		return address2;
	}
	
	public void setAddress2(String address2){
		this.address2 = address2;
	}
	
	public List<Facility_MaintReq> getRequests() {
		return requests;
	}

	public void setOrders(List<Facility_MaintReq> requests) {
		this.requests = requests;
	}


	public String getDetail() {
		return detail;
	}

	public void setDescription(String detail) {
		this.detail = detail;
	}

	
	public List<Facility> getFacList() {
		return facList;
	}

	public void setFacList(List<Facility> facList) {
		this.facList = facList;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

	
	//list.add(new Facility(rs.getInt("facilityId"), rs.getString("owner"), rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getString("zip"), rs.getInt("rate"), rs.getInt("capacity")));
	@Override
	public String toString() {
	return ("Facility Information - " + "ID: " + facilityID + ", Capacity: " + capacity + ", Detail: "+ detail );
	}


}