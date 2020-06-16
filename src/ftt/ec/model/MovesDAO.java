package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Moves;
import ftt.ec.model.DbUtil;

public class MovesDAO implements Dao<Moves> {
	
	private Connection connection;
	
	//Constructor
	public MovesDAO() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Moves move) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.MOVES (NAME, POWER, ACCURACY, TYPE) "
                    		+ "VALUES (?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, move.getName());
            preparedStatement.setInt(2, move.getPower());
            preparedStatement.setInt(3, move.getAccuracy());
            preparedStatement.setString(4, move.getType());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public void update(Moves move) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.MOVES SET NAME=?, POWER=?, ACCURACY=?, TYPE=? "
                                                + "WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, move.getName());
            preparedStatement.setInt(2, move.getPower());
            preparedStatement.setInt(3, move.getAccuracy());
            preparedStatement.setString(4, move.getType());
            preparedStatement.setInt(5, move.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	} //update

	@Override
	public void delete(Moves move) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.MOVES WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, move.getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        		e.printStackTrace();
        } //try		
	} //delete 
	
	@Override
	public Moves find(Moves move) {		
		Moves m = new Moves();        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.MOVES WHERE ID=?");
            
            preparedStatement.setLong(1, move.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                m.setId(rs.getInt("ID"));
                m.setName(rs.getString("NAME"));
                m.setPower(rs.getInt("NUMBER"));
                m.setAccuracy(rs.getInt("ACCURACY"));
                m.setType(rs.getString("TYPE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try
        return m;		
	} //find

	@Override
	public ArrayList<Moves> findAll(Moves move) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL
		
		ArrayList<Moves> mList = new ArrayList<Moves>();        
        try {        	
            Statement statement = connection.createStatement();            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.MOVES");            
            
            while (rs.next()) {                
            	Moves m = new Moves();                
            	m.setId(rs.getInt("ID"));
                m.setName(rs.getString("NAME"));
                m.setPower(rs.getInt("NUMBER"));
                m.setAccuracy(rs.getInt("ACCURACY"));
                m.setType(rs.getString("TYPE"));           
                mList.add(m);                
            } //while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try
        return mList;		
	} //findAll
	
	public int count() {		
		int count = -1;		
		try {			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.MOVES");            
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
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM FTT.MOVES");            
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
