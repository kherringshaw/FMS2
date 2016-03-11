package com.fms2.model;

import java.util.Calendar;

public class Facility_MaintReq {
	
    private int maintId;
    private int facilityId;
    private String maintDescription;
    private Calendar startDate;
    private double cost;
    private String status;

    
    //maintAct.makeFacilityMaintRequest(1, 101, "need light replaced", "open", 50.00);
	public Facility_MaintReq(int facilityId, String maintDescription, double cost, String status) {
		this.facilityId = facilityId;
		this.maintDescription = maintDescription;
		this.cost = cost;
		this.status = status;
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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
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
	//maintenanceReq.add(new Facility_MaintReq(rs.getInt("facilityId"), rs.getString("maint_descript"), rs.getDouble("cost"), rs.getString("status")));
	public String toString() {
	return ("Facility Information - " + "ID: " + facilityId + ", Capacity: " + cost + ", Detail: "+ status );
	}
 /**   @Override
    public String toString() {
        return "Maintenance Request Details -- " +
                ", facility Id: " + facilityId +
                ", Description: " + maintDescription +
                ", start date: " + startDate +
                ", cost: " + cost +
                ", status: " + status;
    }*/




}


