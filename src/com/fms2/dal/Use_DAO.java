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

import com.fms2.model.Facility_Use;

public class Use_DAO {
	
	
	public void addFacilityUse(int facilityId, int useId, String tenant, Calendar startDate, Calendar endDate, String status) {
		
		Date start = new Date(startDate.YEAR, startDate.MONTH, startDate.DAY_OF_MONTH);
		Date end = new Date(endDate.YEAR, endDate.MONTH, endDate.DAY_OF_MONTH);

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT into facility_use(facilityId, useId, tenant, startDate, endDate, status) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, facilityId);
            stmt.setInt(2, useId);
            stmt.setString(3, tenant);
            stmt.setDate(4, start);
            stmt.setDate(5, end);
            stmt.setString(6, status);

            int result = stmt.executeUpdate();

            if (result == 0) {
                throw new SQLException("Maintenance_DAO: Threw a SQLException maintenance request.");
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
}
	
    public boolean isInUseDuringInterval(int facilityId, Calendar startDate, Calendar endDate) throws Exception {
        boolean isInUse = false;       

            try {
                Connection conn = DBHelper.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * from facility_use where (endDate > ? and startDate < ?) and facilityId = ?");
                

                
                Date start = new Date(startDate.get(startDate.YEAR), startDate.get(startDate.DAY_OF_MONTH), startDate.get(startDate.MONTH));
                Date end = new Date(startDate.get(startDate.YEAR), startDate.get(startDate.DAY_OF_MONTH), startDate.get(startDate.MONTH));
                

                ps.setDate(1, start);
                ps.setDate(2, end);
                ps.setInt(3, facilityId);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    isInUse = true;
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }

        return isInUse;
    }

    public void createFacilityUse(int facilityId, Calendar startDate, Calendar endDate) throws Exception {

            try {
                Connection conn = DBHelper.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO facility_use(status, startDate, endDate)  VALUES (?,?,?) WHERE facilityId = ?");
                
                Date start = new Date(startDate.get(startDate.YEAR), startDate.get(startDate.DAY_OF_MONTH), startDate.get(startDate.MONTH));
                Date end = new Date(startDate.get(startDate.YEAR), startDate.get(startDate.DAY_OF_MONTH), startDate.get(startDate.MONTH));

                ps.setString(1, "occupied");
                ps.setInt(4, facilityId);
                ps.setDate(2, start);
                ps.setDate(3, end);

                
            } catch (SQLException e) {
            	System.out.println("Use_DAO:  There is an exception in createFacilityUse.");
                System.out.println("SQLException: " + e);
            }

    }

    public List<Facility_Use> listActualUsage(int facilityId) {
        List<Facility_Use> facilityUseList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from facility_use where facilityId = ? AND status = 'occupied'");
            ps.setInt(1, facilityId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                facilityUseList.add(new Facility_Use(resultSet.getInt("useId"), resultSet.getInt("facilityId"), resultSet.getString("tenant"), resultSet.getDate("startDate").toString(), resultSet.getDate("endDate").toString(), resultSet.getString("status")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return facilityUseList;
    }
    
    public List<Facility_Use> listAllFacilities(int facilityId) {
        List<Facility_Use> facilityUseList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from facility_use where facilityId = ?");
            ps.setInt(1, facilityId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                facilityUseList.add(new Facility_Use(resultSet.getInt("useId"), resultSet.getInt("facilityId"), resultSet.getString("tenant"), resultSet.getDate("startDate").toString(), resultSet.getDate("endDate").toString(), resultSet.getString("status")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return facilityUseList;
    }

    public void vacateFacility(int facilityId) {
        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE facility_use set endDate = ?, status = 'vacant' where facilityId = ? ");

            Date currentTime = new Date(new java.util.Date().getTime());

            ps.setDate(1, currentTime);
            ps.setInt(2, facilityId);


            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No facility in use for facility id = " + facilityId);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

	public double calculateUsageRate(int facilityId) {
        double usageCalc = 0;

		try {
            Connection conn = DBHelper.getConnection();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM facility WHERE facilityId = '" + facilityId + "'");
            
            List<Integer> list1 = new ArrayList();
            List<Integer> ratelist = new ArrayList();

			while (rs.next()){
				list1.add(rs.getInt(9)); //retrieving occupancy
				ratelist.add(rs.getInt(8)); // retrieving rate
			}
			
		     Integer sum = new Integer(0); 
		     for (Integer i : list1) {
		         sum = sum + i;
		     }
		     int rate = ratelist.get(0);

		     return (double) sum*rate;

        } catch (SQLException e) {
        	System.out.println("Use_DAO: Threw a SQLException calculateUsageRate.");
            System.out.println("SQLException: " + e);
        }

        return usageCalc;

	}

}


