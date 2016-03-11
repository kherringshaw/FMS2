package com.fms2.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Facility_Maintenance {

    private int maintId;
    private int facilityId;
    private String maintDescription;
    private double cost;
    private String status; //open / close
    private Calendar startDate;
    private Calendar endDate;

    //maintAct.scheduleMaintenance(1, startDate, endDate, 101);

    
    public Facility_Maintenance(int facilityId, Calendar startDate, Calendar endDate, int maintId){
    	this.facilityId = facilityId;
        this.startDate = startDate;
        this.endDate = endDate;
    	this.maintId = maintId;    	
    }


	public int getMaintId() {
		return maintId;
	}

	public void setMaintId(int maintId) {
		this.maintId = maintId;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getMaintDescription() {
		return maintDescription;
	}

	public void setMaintDescription(String maintDescription) {
		this.maintDescription = maintDescription;
	}
	
	

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
    	return ("Maintenance Information - " + 
			    "Facility: " + facilityId + 
			    ", Description: " + maintDescription + 
			    ", Start Date: "+ startDate.get(startDate.YEAR) + "/" + startDate.get(startDate.MONTH) + "/" + startDate.get(startDate.DAY_OF_MONTH) +
			    ", End Date: "+ endDate.get(endDate.YEAR) + "/" + endDate.get(endDate.MONTH) + "/" + endDate.get(endDate.DAY_OF_MONTH));
    	}



}