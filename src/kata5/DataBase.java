package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataBase {
    private final String URL;
    Connection connection = null;
    
    DataBase(String URL) {
        this.URL = URL;
    }

    void open(){
        try {
            this.connection = DriverManager.getConnection(URL);
            System.out.println("Base de datos abierta ...");
        }
        catch (SQLException ex){
            System.out.println("ERROR Database: can not open");
        }
    }

    void close() {
        if (this.connection != null)
        try {
            this.connection.close();
            System.out.println("Base de datos cerrada");

        }
        catch (SQLException ex){
            System.out.println("ERROR Database: can not close");
        }
    }

    void select_PERSONAS() {
        String SQL = "SELECT * FROM PERSONAS";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            System.out.println("ID \t NOMBRE \t APELLIDO \t DEPARTAMENTO");
            System.out.println("-- \t ------  \t -------- \t ------------");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + "  \t " +
                        resultset.getString("NOMBRE") + "  \t " +
                        resultset.getString("APELLIDO") + "  \t " +
                        resultset.getString("DEPARTAMENTO"));
            }
            System.out.println("* * * * * * * * * *");
        }
        catch (SQLException ex){
            System.out.println("ERROR Database: can not select form personas " + ex.getMessage());
        }
    }

    void insert_PERSONAS(People people) {
        String SQL = "INSERT INTO PERSONAS (NOMBRE, APELLIDO, DEPARTAMENTO) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL);
            preparedStatement.setString(1, people.getNombre());
            preparedStatement.setString(2, people.getApellido());
            preparedStatement.setString(3, people.getDepartamento());
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("ERROR Database: can not insert into personas " + ex.getMessage());
        }
    }
    
    void createTable_EMAIL() {
        try{
        
            String SQL = "CREATE TABLE `EMAIL` ("
                + "`ID`	INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`Mail`	TEXT NOT NULL)";
        
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
        } 
        catch (SQLException ex){
            System.out.println("ERROR Database: can not create table " + ex.getMessage());
        }
    }

    void insert_EMAIL(List<String> mailList) {
        String SQL = "INSERT INTO EMAIL (MAIL) VALUES (?)";
        
        
        for(String str : mailList){
            try{
                PreparedStatement preparedStatement = this.connection.prepareStatement(SQL);
                preparedStatement.setString(1, str);
                preparedStatement.executeUpdate();
            }
            catch (SQLException ex){
                System.out.println("ERROR Database: can not insert into email " + ex.getMessage());
            }   
        }
    }
}
