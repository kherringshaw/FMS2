package com.fms2.model;

import java.util.List;


public class Facility_Detail{
	private int facilityId;
	private String facilityDetail;
	

    // Constructor with facility details
    public Facility_Detail(int facilityId, String detail) {
        this.facilityId = facilityId;
        this.facilityDetail = detail;
    }



	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int id) {
		this.facilityId = id;
	}
	public String getFacilityDetail() {
		return facilityDetail;
	}

	public void setFacilityDetail(String facilityDetail) {
		this.facilityDetail = facilityDetail;
	}
	

	
	//list.add(new Facility(rs.getInt("facilityId"), rs.getString("owner"), rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getString("zip"), rs.getInt("rate"), rs.getInt("capacity")));
	@Override
	public String toString() {
	return ("Facility Information - " + "ID: " + facilityId + ", Detail: "+ facilityDetail );
	}


}