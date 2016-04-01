package com.fms2.activities;


import com.fms2.dal.Facility_DAO;
import com.fms2.dal.Inspection_DAO;
import com.fms2.dal.Use_DAO;
import com.fms2.model.Facility_Inspection;


import java.util.Calendar;
import java.util.List;




public class Inspection_Activities {

	private Inspection_DAO inspectDAO = new Inspection_DAO();
	
	
	//creates a new facility inspection
	public void createInspection(int facilityId, int inspectId, String description, String assignedTo, String status, 
			Calendar dateAssigned, Calendar dateClosed) {
		try {
			inspectDAO.createInspection(facilityId, inspectId, description, assignedTo, status, dateAssigned, dateClosed);

	    } catch (Exception se) {
		      System.err.println("Inspection_Activities: Threw an Exception createInspection.");
		      System.err.println(se.getMessage());
	    }
	}

	//queries the facilities inspections both completed and open
	public List<Facility_Inspection> listInspections(int facilityId) {
		try {
			return inspectDAO.listInspections(facilityId);

	    } catch (Exception se) {
		      System.err.println("Inspection_Activities: Threw an Exception listInspections.");
		      System.err.println(se.getMessage());
	    }
		return null;
	}
    	



    


}

