package com.fms2.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import com.fms2.model.Facility_MaintReq;
import com.fms2.model.Facility_Maintenance;

public class Maintenance_DAO {


    public void makeFacilityMaintRequest(int facilityId, int maintId, String maintenanceDescription, String status, double cost) throws Exception {

            try {
                Connection conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT into maintenance_request (facilityId, maintenanceId, maint_descript, status, cost) VALUES (?, ?, ?, ?, ?)");
                stmt.setInt(1, facilityId);
                stmt.setInt(2, maintId);
                stmt.setString(3, maintenanceDescription);
                stmt.setString(4, status);
                stmt.setDouble(5, cost);

                int result = stmt.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Maintenance_DAO: Threw a SQLException maintenance request.");
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
    }


	public void createMaintenceSchedule(int facilityId, Calendar startDate, Calendar endDate, int maintId) {


            try {
                Connection conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT into maintenance_schedule (facilityId, start_date, end_date, maintenance_id) VALUES (?, ?, ?, ?)");
                stmt.setInt(1, facilityId);
                stmt.setDate(2, new java.sql.Date(startDate.getTimeInMillis()));
                stmt.setDate(3, new java.sql.Date(endDate.getTimeInMillis()));
                stmt.setInt(4, maintId);

                int result = stmt.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Maintenance_DAO: Threw a SQLException maintenance schedule.");
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
    }


	public double calcProblemRateForFacility(int facilityId, String status) {
		
        double maintCost = 0;
		try {
            Connection conn = DBHelper.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM maintenance_request WHERE facilityId = '" + facilityId + "'");
            
            List<Integer> list1 = new ArrayList();
            
			while (rs.next()){
				list1.add(rs.getInt(5));
			}
			
		     Integer sum = new Integer(0); 
		     for (Integer i : list1) {
		         sum = sum + i;
		     }

		     return (double) sum;

        } catch (SQLException e) {
        	System.out.println("Maintenance_DAO: Threw a SQLException calcProblemRateForFacility.");
            System.out.println("SQLException: " + e);
        }

        return maintCost;

	}

	public int calculateDownTimeForFacility(int facilityId) {
        int sum = 0;
        //SELECT DATEDIFF(day,'2014-06-05','2014-08-05') AS DiffDate

        try {

            Connection conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DATEDIFF(end_date, start_date) as Difference FROM maintenance_schedule WHERE facilityId = ?");

            stmt.setInt(1, facilityId);
            ResultSet resultSet = stmt.executeQuery();

        	
            List<Integer> list1 = new ArrayList();

            
			while (resultSet.next()){
				list1.add(resultSet.getInt(1));
			}
			
		     sum = new Integer(0); 
		     for (Integer i : list1) {
		         sum = sum + i;
		     }
		     
		     System.out.println("This is how many days Facility" + facilityId + " has been down: " + sum);

        } catch (SQLException se) {
        	System.out.println("Maintenance_DAO: Threw a SQLException calculateDownTimeForFacility.");
            System.out.println("SQLException: " + se);
        }

        return sum;
    }

	public List<Facility_MaintReq> listMaintRequests(int facilityId, String status) {
		
        List<Facility_MaintReq> maintenanceReq = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from maintenance_request where facilityId = ? AND status='open'");
            ps.setInt(1, facilityId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                maintenanceReq.add(new Facility_MaintReq(rs.getInt("facilityId"), rs.getString("maint_descript"), rs.getDouble("cost"), rs.getString("status")));

            }
        } catch (SQLException se) {
        	System.out.println("Maintenance_DAO: Threw a SQLException listMaintRequests.");
            System.out.println("SQLException: " + se);
        }

        return maintenanceReq;
    }

	public List<Facility_Maintenance> listMaintenance(int facilityId) {
        List<Facility_Maintenance> maintenanceReq = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from maintenance_schedule where facilityId = ? ");
            ps.setInt(1, facilityId);
            ResultSet rs = ps.executeQuery();
            //Facility_Maintenance(int facilityId, Calendar startDate, Calendar endDate, int maintId)
            while (rs.next()) {

            	Calendar start =  Calendar.getInstance();
            	Calendar end  = Calendar.getInstance();
            	start.setTime(rs.getDate(2));
            	end.setTime(rs.getDate(3));

                maintenanceReq.add(new Facility_Maintenance(rs.getInt("facilityId"), start, end, rs.getInt("maintenance_id")));
            }
        } catch (SQLException se) {
        	System.out.println("Maintenance_DAO: Threw a SQLException listMaintenance.");
            System.out.println("SQLException: " + se);
        }
        
        return maintenanceReq;
    }
	

	public List<Facility_MaintReq> listFacilityProblems(int facilityId) {
        List<Facility_MaintReq> maintenanceReq = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from maintenance_request where facilityId = ?");
            ps.setInt(1, facilityId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                maintenanceReq.add(new Facility_MaintReq(rs.getInt("facilityId"), rs.getString("maint_descript"), rs.getDouble("cost"), rs.getString("status")));

            }
        } catch (SQLException se) {
        	System.out.println("Maintenance_DAO: Threw a SQLException listMaintRequests.");
            System.out.println("SQLException: " + se);
        }

        return maintenanceReq;
	}


	public int calcMaintanceCostForFacility(int facilityId) {
		
        int maintCost = 0;
		try {
            Connection conn = DBHelper.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM maintenance_request WHERE facilityId = '" + facilityId + "'");
            
            List<Integer> list1 = new ArrayList();
            
			while (rs.next()){
				list1.add(rs.getInt(5));
			}
			
		     Integer sum = new Integer(0); 
		     for (Integer i : list1) {
		         sum = sum + i;
		     }

		     return sum;

        } catch (SQLException e) {
        	System.out.println("Maintenance_DAO: Threw a SQLException calcProblemRateForFacility.");
            System.out.println("SQLException: " + e);
        }

        return maintCost;
	}



	
	
	

}
