package com.fms2.model;

import java.sql.Date;
import java.util.Calendar;

public class Facility_Use {
	
    private int useId;
    private int facilityId;
    private String tenant;
    private Calendar startDate;
    private Calendar endDate;
    private String status; //vacant, occupied
	private String startDate2;
	private String endDate2;


    public Facility_Use(int facilityId, int useId, String tenant, Calendar startDate, Calendar endDate, String status) {
        this.useId = useId;
        this.facilityId = facilityId;
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    
    public Facility_Use(int facilityId, int useId, String tenant, String start, String end, String status) {
        this.useId = useId;
        this.facilityId = facilityId;
        this.tenant = tenant;
        this.startDate2 = start;
        this.endDate2 = end;
        this.status = status;
    }


    public Facility_Use(int int1, int int2, String string, Date date,
			Date date2, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getUseId() {
        return useId;
    }

    public void setId(int useId) {
        this.useId = useId;
    }
    

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }
    
	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "FacilityUse{" +
                "Facility Id: " + facilityId +
                ", Tenant: " + tenant +
                ", Start Date:" + startDate2 +
                ", End Date: " + endDate2 +
                ", Status:" + status + "   " +
                '}';
    }


}