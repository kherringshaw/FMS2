package com.fms2.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fms2.dal.DBHelper;
import com.fms2.model.Facility;
import com.fms2.model.Facility_Detail;

public class Facility_DAO {


	public void addFacility(Facility fac) {
		Connection con = DBHelper.getConnection();
        PreparedStatement facPst = null;
        PreparedStatement addPst = null;
        PreparedStatement unitPst = null;

        try {
        	//Insert the facility object
            String facStm = "INSERT INTO facility(facilityId, owner, address1, address2, city, state, zip, rate, capacity) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            facPst = con.prepareStatement(facStm);
            facPst.setInt(1, fac.getFacilityID());
            facPst.setString(2, fac.getOwner());
            facPst.setString(3, fac.getAddress1());
            facPst.setString(4, fac.getAddress2());
            facPst.setString(5, fac.getCity());
            facPst.setString(6, fac.getState());
            facPst.setString(7, fac.getZip());
            facPst.setDouble(8, fac.getRate());
            facPst.setInt(9, fac.getCapacity());
            facPst.executeUpdate();

            System.out.println("facility -- end of insert into address");

            
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	facPst.close();
                	unitPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("Facility_DAO: Threw a SQLException adding facility.");
    	      System.err.println(ex.getMessage());
            }
        }
    }

	public void deleteFacility(int test) {
        System.out.println("Deleted: "  + test);
        try {
            Connection connection = DBHelper.getConnection();
            int removeID = test;
            String selectRemove_fac = "DELETE FROM Facility WHERE facilityID = '" + removeID + "'";
            String selectRemove_address = "DELETE FROM address WHERE facilityID = '" + removeID + "'";
            PreparedStatement statement_fac = connection.prepareStatement(selectRemove_fac);
            PreparedStatement statement_address = connection.prepareStatement(selectRemove_address);
            
            statement_fac.executeUpdate();
            statement_address.executeUpdate();

            connection.close();

        }catch (SQLException se){
            System.err.println("Facility_DAO: Threw a SQLException deleting the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
		
	}
	
	public List<Facility> queryFacilities(){
		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM facility");
			
			List<Facility> list = new ArrayList<>();

			while (rs.next()){
				list.add(new Facility(rs.getInt("facilityId"), rs.getString("owner"), rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getString("zip"), rs.getInt("rate"), rs.getInt("capacity")));
			}

			return list;
		}
			catch(SQLException e) {
				System.err.println("Facility_DAO: Threw a SQLException retrieving the facility object. ");
				System.err.println(e.getMessage());
			}
			return null;
		
	}

    
	@SuppressWarnings("unchecked")
	public int requestAvailableCapacity(int facilityId) {

		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM facility WHERE facilityId = '" + facilityId + "'");
			
			List<Integer> list1 = new ArrayList();

			while (rs.next()){
				list1.add(rs.getInt(9));
			}
			
			//System.out.println("what is in the list: " + list1);

		     Integer sum = new Integer(0); 
		     for (Integer i : list1) {
		         sum = sum + i;
		     }

			return sum;
		}
			catch(SQLException e) {
				System.err.println("Got an exception for calculateUsageRate! ");
				System.err.println(e.getMessage());
			}
			return (Integer) null;
		
	}
	
    public void addFacilityDetail(Facility fac, int facilityId, String details) throws Exception {


            try {
                Connection conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE facility SET details = ? WHERE facilityId = " + facilityId);
                stmt.setString(1, details);


                int result = stmt.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Facility_DAO: Threw a SQLException addingFacilityDetail.");
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }

    }

	public List<Facility> getFacilityDetail(int facilityId) {
		try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM facility");
			
			List<Facility> list = new ArrayList<>();

			while (rs.next()){
				list.add(new Facility(rs.getInt("facilityId"), rs.getString("details")));
			}

			return list;
		}
			catch(SQLException e) {
				System.err.println("Facility_DAO: Threw a SQLException retrieving the facility object. ");
				System.err.println(e.getMessage());
			}
			return null;
	}


    
    
}
