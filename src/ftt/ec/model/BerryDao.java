package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Berry;
import ftt.ec.model.DbUtil;

public class BerryDao implements Dao<Berry> {
	
	private Connection connection;
	
	//Constructor
	public BerryDao() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Berry berry) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.BERRY (NAME, GROWTH_TIME) VALUES (?, ?)");
            
            preparedStatement.setString(1, berry.getName());
            preparedStatement.setString(2, berry.getGrowth());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Berry berry) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.BERRY SET NAME=?, " 
                    		                      + "GROWTH_TIME=?, "
                                                  + "WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, berry.getName());
            preparedStatement.setString(2, berry.getGrowth());
            preparedStatement.setInt(3, berry.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	} //update

	@Override
	public void delete(Berry berry) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.BERRY WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, berry.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	} //delete 

	@Override
	public Berry find(Berry berry) {
		
		Berry b = new Berry();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.BERRY WHERE ID=?");
            
            preparedStatement.setLong(1, berry.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                c.setEmail(rs.getInt("GROWTH_TIME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return b;
		
	} //find

	@Override
	public ArrayList<Berry> findAll(Berry berry) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL
		
		ArrayList<Berry> bList = new ArrayList<Berry>();
        
        try {
        	
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.BERRY");
            
            while (rs.next()) {
                
            	Berry b = new Berry();
                
            	b.setId(rs.getInt("ID"));
                b.setName(rs.getString("NAME"));
                b.setEmail(rs.getInt("GROWTH_TIME"));

                bList.add(c);
                
            } //while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return bList;
		
	} //findAll
	
	public int count() {
		
		int count = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.BERRY");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                count = rs.getInt("QTD");
                
            } //if
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

		return count;
		
	} //count
	
	public int maxId() {
		
		int maxId = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM FTT.BERRY");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                maxId = rs.getInt("MAX_ID");
                
            } //if
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

		return maxId;
		
	} //maxId

}