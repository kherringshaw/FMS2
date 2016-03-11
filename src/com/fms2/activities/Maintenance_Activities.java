package com.fms2.activities;
import com.fms2.dal.Maintenance_DAO;
import com.fms2.model.Facility_Maintenance;
import com.fms2.model.Facility_MaintReq;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Maintenance_Activities {
    
	private Maintenance_DAO maintDAO = new Maintenance_DAO();

    //Create a new facility maintenance request
	public void makeFacilityMaintRequest(int facilityId, int maintId, String maintenanceDescription, String status, double cost) {			
		try {
			maintDAO.makeFacilityMaintRequest(facilityId, maintId, maintenanceDescription, status, cost);
			System.out.println("Request has been added");
	    } catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
	    }
	}


    //Schedule maintenance for a given facility (end date can be unknown at the time)
	public void scheduleMaintenance(int facilityId, Calendar startDate, Calendar endDate, int maintId){
		try {
			maintDAO.createMaintenceSchedule(facilityId, startDate, endDate, maintId);

		} catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception schedule maintenance request.");
		      System.err.println(se.getMessage());
	    }
	}
	
    //Calculates the percentage of time down during a year (number of days down/365)
    public double calcProblemRateForFacility(int facilityId, String status){
    	int downtime = 0;
    	
    	try{    	
    		return (maintDAO.calculateDownTimeForFacility(facilityId)/365.0)*100;
    		
    	} catch (Exception se) {
	      System.err.println("Maintenance_Activities: Threw an Exception calcDownTimeForFacility.");
	      System.err.println(se.getMessage());
    	}
    	return downtime;
	}



    //Calculates the total downtime for open maintenance requests -- the total number of requests a facility has had
    public int calcDownTimeForFacility(int facilityId) {
    	int downtime = 0;
    	
    	try{    	
    		return maintDAO.calculateDownTimeForFacility(facilityId);
    		
    	} catch (Exception se) {
	      System.err.println("Maintenance_Activities: Threw an Exception calcDownTimeForFacility.");
	      System.err.println(se.getMessage());
    	}
    	return downtime;
    }

    
    
    //Lists all maintenance requests for a given facility
    public List<Facility_MaintReq> listMaintRequests(int facilityId, String status){		
		try {
			//System.out.println(facilityId);
			return maintDAO.listMaintRequests(facilityId, status);
			

	    } catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception returning all maintenance requests.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}


    //Lists all open maintenance requests for whole portfolio
    public List<Facility_Maintenance> listMaintenance(int facilityId){		
		try {
			return maintDAO.listMaintenance(facilityId);

	    } catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception returning all open maintenance.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}
    
    //Lists all the problems for a given facility; both open and closed
	public List<Facility_MaintReq> listFacilityProblems(int facilityId){		
		
		try {			
			return maintDAO.listFacilityProblems(facilityId);
	    } 
		
		catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception returning listFacilityProblems.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}


	public int calcMaintanceCostForFacility(int facilityId) {
    	
		try {

			return  maintDAO.calcMaintanceCostForFacility(facilityId);

	    } catch (Exception se) {
		      System.err.println("Maintenance_Activities: Threw an Exception calcProblemRateForFacility.");
		      System.err.println(se.getMessage());
	    }
		return 0;
	}

}
