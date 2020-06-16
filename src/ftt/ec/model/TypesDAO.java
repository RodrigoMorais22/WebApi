package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Types;
import ftt.ec.model.DbUtil;

public class TypesDAO implements Dao<Types> {
	
	private Connection connection;
	
	//Constructor
	public TypesDAO() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Types type) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.TYPES (NAME, BIGGEST_WEAKNESS, "
                    		+ "BIGGEST_ADVANTAGE) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, type.getName());
            preparedStatement.setString(3, type.getBiggest_weakness());
            preparedStatement.setString(3, type.getBiggest_advantage());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public void update(Types type) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.TYPES SET NAME=?, BIGGEST_WEAKNESS=?, "
                    		+ "BIGGEST_ADVANTAGE=? WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, type.getName());
            preparedStatement.setString(3, type.getBiggest_weakness());
            preparedStatement.setString(3, type.getBiggest_advantage());
            
            preparedStatement.setInt(4, type.getId());            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	} //update

	@Override
	public void delete(Types type) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.TYPES WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, type.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	} //delete 

	@Override
	public Types find(Types type) {
		
		Types t = new Types();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.TYPES WHERE ID=?");
            
            preparedStatement.setLong(1, type.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                t.setId(rs.getInt("ID"));
                t.setName(rs.getString("NAME"));
                t.setBiggest_weakness(rs.getString("BIGGEST_WEAKNESS"));
                t.setBiggest_advantage(rs.getString("BIGGEST_ADVANTAGE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return t;
		
	} //find

	@Override
	public ArrayList<Types> findAll(Types type) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL		
		ArrayList<Types> tList = new ArrayList<Types>();
        
        try {        	
            Statement statement = connection.createStatement();            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.TYPES");
            
            while (rs.next()) {
                
            	Types t = new Types();                
                t.setId(rs.getInt("ID"));
                t.setName(rs.getString("NAME"));
                t.setBiggest_weakness(rs.getString("BIIGEST_WEAKNESS"));
                t.setBiggest_advantage(rs.getString("BIGGEST_ADVANTAGE"));           
                tList.add(t);
            } //while            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try        
        return tList;		
	} //findAll
	
	public int count() {
		
		int count = -1;
		
		try {			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.TYPES");            
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
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM FTT.TYPES");            
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
