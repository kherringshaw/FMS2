package com.fms2.view;

import com.fms2.model.Facility;
import com.fms2.activities.Facility_Activities;
import com.fms2.activities.Inspection_Activities;
import com.fms2.activities.Maintenance_Activities;
import com.fms2.activities.Use_Activities;
import com.fms2.dal.DBHelper;

import java.util.Calendar;


public class test_client {


	public static void main(String[] args) throws Exception {
    	
		System.out.println("Facility: *************** ADD SOME FACILITIES *************************");	
    	
        Facility facility1 = new Facility(1, "PGRT", "800 W. Madison", "Ste 600", "Chicago", "IL", "60601", 20.0, 600);  
        Facility facility2 = new Facility(2, "Arden", "800 W. Monroe", "Ste 1000", "Chicago", "IL", "60601", 30.0, 1200);
        Calendar startDate = Calendar.getInstance();;
        Calendar endDate = Calendar.getInstance();;
        startDate.set(2015, 01, 15);
        endDate.set(2015, 01, 18);


        
        System.out.println("++++++++++++ TESTING FACILITY METHODS ++++++++++++++++");
        Facility_Activities fac1 = new Facility_Activities();
        System.out.println("Adding new facility1: " + facility1 + "  & facility2: " + facility2);
        fac1.addFacility(facility1);
        fac1.addFacility(facility2);
        System.out.println("queryFacilities(): " + fac1.queryFacilities());
        System.out.println();        
        System.out.println("Deleting Facility2");
        fac1.deleteFacility(2);
        System.out.println("queryFacilities(): " + fac1.queryFacilities());
        System.out.println("Adding facility detail to facility1");
        fac1.addFacilityDetail(facility1, 1, "This is a detail that has been added");
        System.out.println("getFacilityInformation -- facility1: " + fac1.getFacilityDetail(1));
        System.out.println("requestAvailableCapacity -- facility1: " + fac1.requestAvailableCapacity(1));
        System.out.println();

        System.out.println("++++++++++++ TESTING INSPECTION METHODS ++++++++++++++++");
        Inspection_Activities inspect = new Inspection_Activities();
        inspect.createInspection(3, 101, "need parking lot restriped", "Eric", "open", startDate, endDate);
        System.out.println("listInspections(1): " + inspect.listInspections(3));
        System.out.println();

        
        System.out.println("++++++++++++ TESTING MAINTENANCE METHODS ++++++++++++++++");
        Maintenance_Activities maintAct = new Maintenance_Activities();
        maintAct.makeFacilityMaintRequest(1, 101, "need light replaced", "open", 50.00);
        System.out.println("makeFacilityMaintRequest() -- Facility1: " + maintAct);        
        System.out.println("scheduleMaintenance() -- Facility1: ");
        maintAct.scheduleMaintenance(1, startDate, endDate, 101);        
        System.out.println("calcProblemRateForFacility() -- Facility1: " + maintAct.calcProblemRateForFacility(1, "open"));
        System.out.println("calcMaintanceCostForFacility() -- Facility1: " + maintAct.calcMaintanceCostForFacility(1));
        System.out.println("calcDownTimeForFacility(1): " + maintAct.calcDownTimeForFacility(1));
        System.out.println("listMaintRequests(1): " + maintAct.listMaintRequests(1, "open"));
        System.out.println("listMaintenance(1): " + maintAct.listMaintenance(1));
        System.out.println("listFacilityProblems(1): " + maintAct.listFacilityProblems(1));
        System.out.println();


        System.out.println("++++++++++++ TESTING USE METHODS ++++++++++++++++");
        Use_Activities use = new Use_Activities();
        System.out.println("addFacilityUse(): ");
        use.addFacilityUse(1, 101, "Tenant X", startDate, endDate, "occupied");
        System.out.println("isInUseDuringInterval(): " + use.isInUseDuringInterval(1, endDate, startDate));
        System.out.println("listActualUsage(1): " + use.listActualUsage(1));
        System.out.println("calcUsageRate(1): " + use.calcUsageRate(1));
        use.assignFacilityToUse(1, startDate, endDate);
        System.out.println("assignFacilityToUse" + use.listActualUsage(1));
        use.vacateFacility(1);
        System.out.println("vacateFacility" + use.listAllFacilities(1));        
        System.out.println();


    }
}

