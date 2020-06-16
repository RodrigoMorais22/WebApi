package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Item;
import ftt.ec.model.DbUtil;

public class ItemDao implements Dao<Item> {
	
	private Connection connection;
	
	//Constructor
	public ItemDao() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Item item) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.ITEM (NAME, RARITY) VALUES (?, ?)");
            
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getRarity());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Item item) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.BERRY SET NAME=?, " 
                    		                      + "RARITY=?, "
                                                  + "WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getRarity());
            preparedStatement.setInt(3, item.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	} //update

	@Override
	public void delete(Item item) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.ITEM WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, item.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	} //delete 

	@Override
	public Item find(Item item) {
		
		Item i = new Item();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.ITEM WHERE ID=?");
            
            preparedStatement.setLong(1, item.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                i.setId(rs.getInt("ID"));
                i.setName(rs.getString("NAME"));
                i.setRarity(rs.getInt("RARITY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return i;
		
	} //find

	@Override
	public ArrayList<Item> findAll(Item item) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL
		
		ArrayList<Item> iList = new ArrayList<Item>();
        
        try {
        	
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.ITEM");
            
            while (rs.next()) {
                
            	Item i = new Item();
                
            	i.setId(rs.getInt("ID"));
                i.setName(rs.getString("NAME"));
                i.setEmail(rs.getInt("RARITY"));

                iList.add(i);
                
            } //while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return iList;
		
	} //findAll
	
	public int count() {
		
		int count = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.ITEM");
            
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
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM FTT.ITEM");
            
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