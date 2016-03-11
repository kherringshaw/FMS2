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

import com.fms2.model.Facility_Inspections;
import com.fms2.model.Facility_MaintReq;
import com.fms2.model.Facility_Use;

public class Inspection_DAO {
	
	
	public void createInspection(int facilityId, int inspectId, String description, String assignedTo, String status,
			Calendar dateAssigned, Calendar dateClosed) {

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT into inspections (facilityId, inspectId, description, assignedTo, status, dateAssigned, dateClosed) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, facilityId);
            stmt.setInt(2, inspectId);
            stmt.setString(3, description);
            stmt.setString(4, assignedTo);
            stmt.setString(5, status);
            stmt.setDate(6, new java.sql.Date(dateAssigned.getTimeInMillis()));
            stmt.setDate(7, new java.sql.Date(dateClosed.getTimeInMillis()));
            int result = stmt.executeUpdate();

            if (result == 0) {
                throw new SQLException("Maintenance_DAO: Threw a SQLException maintenance request.");
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
	}



	public List<Facility_Inspections> listInspections(int facilityId) {
        List<Facility_Inspections> inspectList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from inspections where facilityId = ?");
            ps.setInt(1, facilityId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	inspectList.add(new Facility_Inspections(rs.getInt("facilityId"),rs.getInt("inspectId"),  rs.getString("description"), rs.getString("assignedTo"), rs.getString("status")));

            }
        } catch (SQLException se) {
        	System.out.println("Inspection_DAO: Threw a SQLException listInspections.");
            System.out.println("SQLException: " + se);
        }

        return inspectList;
    }

}


