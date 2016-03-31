package com.fms2.model;


import java.util.Calendar;


public class Facility_Inspection {

    private int maintId;
    private int facilityId;
    private String description;
    private String assignedTo;
    private Calendar dateAssigned;
    private Calendar dateClosed;
    private String status;
    
    //inspect.createInspection(3, 101, "need parking lot restriped", "Eric", "open", dateAssigned, dateClosed);

    public Facility_Inspection(int facilityId, int maintId, String description, String assignedTo, String status, Calendar dateAssigned, Calendar dateClosed) {
        this.maintId = maintId;
        this.facilityId = facilityId;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dateAssigned = dateAssigned;
        this.dateClosed = dateClosed;
        this.status = status;
    }

    public Facility_Inspection(int facilityId, int maintId, String description, String assignedTo, String status) {
        this.maintId = maintId;
        this.facilityId = facilityId;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
    }


	public int getMaintId() {
        return maintId;
    }

    public void setMaintId(int maintId) {
        this.maintId = maintId;
    }

    public String getDescriptione() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }
    

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    

    public Calendar getdateAssigned() {
        return dateAssigned;
    }

    public void setdateAssigned(Calendar dateAssigned) {
        this.dateAssigned = dateAssigned;
    }
    

    public Calendar getdateClosed() {
        return dateClosed;
    }

    public void setdateClosed(Calendar dateClosed) {
        this.dateClosed = dateClosed;
    }
  

    @Override
    public String toString() {
        return "Inspections -- " +
                "Facility: " + facilityId +
                ", Type: " + description  +
                ", Type: " + assignedTo  +
                ", Status: " + status;
    }
}