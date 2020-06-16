package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Pokemon;
import ftt.ec.model.DbUtil;

public class PokemonDAO implements Dao<Pokemon> {
	
	private Connection connection;
	
	//Constructor
	public PokemonDAO() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Pokemon pok) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.POKEMON (NAME, NUMBER, TYPE) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, pok.getName());
            preparedStatement.setInt(2, pok.getNumber());
            preparedStatement.setString(3, pok.getType());
            
            //Data do Java tem timezone, o BD n�o tem!!!
              // java.sql.Date -> Não tem timezone
              // java.util.Date -> Tem timezone

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void update(Pokemon pok) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.POKEMON SET NAME=?, NUMBER=?, TYPE=? "
                                                + "WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, pok.getName());
            preparedStatement.setInt(2, pok.getNumber());
            preparedStatement.setString(3, pok.getType());
            
            preparedStatement.setInt(4, pok.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	} //update

	@Override
	public void delete(Pokemon pok) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.POKEMON WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, pok.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	} //delete 

	@Override
	public Pokemon find(Pokemon pok) {
		
		Pokemon p = new Pokemon();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.POKEMON WHERE ID=?");
            
            preparedStatement.setLong(1, pok.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                p.setNumber(rs.getInt("NUMBER"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return p;
		
	} //find

	@Override
	public ArrayList<Pokemon> findAll(Pokemon pok) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL
		
		ArrayList<Pokemon> pList = new ArrayList<Pokemon>();
        
        try {
        	
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.POKEMON");
            
            while (rs.next()) {
                
            	Pokemon p = new Pokemon();
                
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                p.setNumber(rs.getInt("NUMBER"));
           
                pList.add(p);
                
            } //while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return pList;
		
	} //findAll
	
	public int count() {
		
		int count = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.POKEMON");
            
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
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM FTT.POKEMON");
            
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