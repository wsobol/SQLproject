//William Sobol
import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class Person{
  private Connection connection;
  private Scanner input = new Scanner(System.in);

  public Person(Connection conn){
    connection = conn;
  }
  
  //INSERTS
  public void insertRow(){
    PreparedStatement pStmt = null;
    String insertStatement = "INSERT INTO person(person_id, p_name, address, city, st," +
                              "zip_code, email, gender, phone) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try{
      pStmt = connection.prepareStatement(insertStatement);

      System.out.println("Enter an ID");
      pStmt.setInt(1, input.nextInt());
      input.nextLine();
      
      System.out.println("Enter the person's name");
      pStmt.setString(2, input.nextLine());

      System.out.println("Enter street name");
      pStmt.setString(3, input.nextLine());

      System.out.println("Enter city");
      pStmt.setString(4, input.nextLine());

      System.out.println("Enter state (ABR)");
      pStmt.setString(5, input.nextLine());

      System.out.println("Enter zip code");
      pStmt.setInt(6, input.nextInt());
      input.nextLine();
      
      System.out.println("Enter email address");
      pStmt.setString(7, input.nextLine());

      System.out.println("Enter gender");
      pStmt.setString(8, input.nextLine());

	  System.out.println("Enter phone number");
      pStmt.setString(9, input.nextLine());
	  
      pStmt.executeUpdate();
    } catch (SQLException e){
      System.out.println(e.getMessage());
    } finally {
      try{
        if(pStmt != null) pStmt.close();
      }catch (SQLException e){
        System.out.println(e.getMessage());
      }
    }
  }

  
  //DELETE
  public void deleteRow(){
    PreparedStatement pStmt = null;
    String deleteStatement = "DELETE FROM person WHERE person_id = ?";
    try{
      pStmt = connection.prepareStatement(deleteStatement);

      System.out.println("Enter the ID of the person to be deleted");
      pStmt.setInt(1, input.nextInt());

      pStmt.executeUpdate();
    } catch (SQLException e){
      System.out.println(e.getMessage());
    } finally {
      try{
        if(pStmt != null) pStmt.close();
      }catch (SQLException e){
        System.out.println(e.getMessage());
      }
    }
  }
}