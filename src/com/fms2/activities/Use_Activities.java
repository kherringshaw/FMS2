package com.fms2.activities;


import com.fms2.dal.Facility_DAO;
import com.fms2.dal.Use_DAO;
import com.fms2.model.Facility_Use;

import java.util.Calendar;
import java.util.List;



public class Use_Activities {

	private Facility_DAO facDAO = new Facility_DAO();	
	private Use_DAO useDAO = new Use_DAO();
	
    public void addFacilityUse(int facilityId, int useId, String tenant, Calendar startDate, Calendar endDate, String status) {
		try {
			useDAO.addFacilityUse(facilityId, useId, tenant, startDate, endDate, status);
	    } catch (Exception se) {
		      System.err.println("Use_Activities: Threw an Exception addFacilityUse.");
		      System.err.println(se.getMessage());
	    }
	}
    
	//Checks whether the facility is in use for given interval
    public boolean isInUseDuringInterval(int facilityId, Calendar startDate, Calendar endDate) {
		
		try {
	        return useDAO.isInUseDuringInterval(facilityId, startDate, endDate);
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception isInUseDuringInterval.");
		      System.err.println(se.getMessage());
	    }
		return false;
	}
    
    //sets facility to use
    public void assignFacilityToUse(int facilityId, Calendar startDate, Calendar endDate){    	
		
		try {
	        useDAO.createFacilityUse(facilityId, startDate, endDate);
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception assignFacilityToUse.");
		      System.err.println(se.getMessage());
	    }

    }

    //Vacates a facility
    public void vacateFacility(int facilityId) {   	
		
		try {
		       useDAO.vacateFacility(facilityId);;
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception vacateFacility.");
		      System.err.println(se.getMessage());
	    }

	}


    //Returns all scheduled facility use entities
    public List<Facility_Use> listActualUsage(int facilityId) { 	
		
		try {
	        return useDAO.listActualUsage(facilityId);
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception listActualUsage.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}
    
    //Returns all facilities use entities
    public List<Facility_Use> listAllFacilities(int facilityId) { 	
		
		try {
	        return useDAO.listAllFacilities(facilityId);
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception listActualUsage.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}


    //Calculates the usage rate based on the occupancy number  * rate - (this assumes billing occurs monthly) 
    public double calcUsageRate(int facilityId){
    	
		try {
	    	return useDAO.calculateUsageRate(1);
	
	    } catch (Exception se) {
	
		      System.err.println("Use_Activity: Threw an Exception calcUsageRate.");
		      System.err.println(se.getMessage());
	    }
		return 0.0;
	}
    	



    


}

