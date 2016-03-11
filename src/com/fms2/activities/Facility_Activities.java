package com.fms2.activities;


import com.fms2.dal.Facility_DAO;
import com.fms2.model.Facility;
import com.fms2.model.Facility_Detail;
import com.fms2.model.Facility_Use;


import java.util.List;



public class Facility_Activities {

	private Facility_DAO facDAO = new Facility_DAO();
	
	//Insert a new facility in the DB Facility
	public void addFacility(Facility facility) {	
		
		try {
			System.out.println("Facility has been added: " + facility);
			facDAO.addFacility(facility);
	
	    } catch (Exception se) {
	
		      System.err.println("Facility_Activity: Threw an Exception adding facility.");
		      System.err.println(se.getMessage());
	    }
	}


	//Delete facility in the DB Facility
	public void deleteFacility(int facilityID) {
			
		try {
			facDAO.deleteFacility(facilityID);
			System.out.println("Facility has been deleted: " + facilityID);
	    } catch (Exception se) {
		      System.err.println("Facility_Activity: Threw an Exception deleting facility.");
		      System.err.println(se.getMessage());
	    }
	}


	//Query facility in the DB
	public List<Facility> queryFacilities() {
			
		try {
			return facDAO.queryFacilities();
			
	    } catch (Exception se) {
		      System.err.println("Facility_Activity: Threw an Exception in query facility.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}

    //Return facility and facility detail information
    public List<Facility> getFacilityDetail(int facilityId){
    	
        try {
        	List<Facility> fac = facDAO.getFacilityDetail(facilityId);
            return fac;
        } catch (Exception se) {
            System.err.println("Facility_Activity: Threw a Exception retrieving facility.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    //Return the facility capacity (the capacity is how many people a space can hold).
    public int requestAvailableCapacity(int facilityId) {		
	try {
		return facDAO.requestAvailableCapacity(facilityId);
		
    } catch (Exception se) {
	      System.err.println("Facility_Activity: Threw an Exception in calculateUsageRate.");
	      System.err.println(se.getMessage());
    }
	return (Integer) null;	    	
    }


    //Add a new facility detail
    public void addFacilityDetail(Facility fac, int facilityId, String detail) {
    	
    	try{
    		facDAO.addFacilityDetail(fac, facilityId, detail);
    	} catch (Exception e){
  	      System.err.println("Facility_Activity: Threw an Exception in addFacilityDetail.");
  	      System.err.println(e.getMessage());
    	}

    }
 


}

