//William Sobol
import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class Course{
  private Connection connection;
  private Scanner input = new Scanner(System.in);

  public Course(Connection conn){
    connection = conn;
  }
  
  //INSERTS
  public void insertRow(){
    PreparedStatement pStmt = null;
    String insertStatement = "INSERT INTO course(course_id, title, lvl, credits) values (?, ?, ?, ?)";
    try{
      pStmt = connection.prepareStatement(insertStatement);

      System.out.println("Enter course ID");
      pStmt.setInt(1, input.nextInt());
      input.nextLine();
      
      System.out.println("Enter course title");
      pStmt.setString(2, input.nextLine());

      System.out.println("Enter course level");
      pStmt.setInt(3, input.nextInt());
      input.nextLine();
     
      System.out.println("Enter course credit value");
      pStmt.setInt(4, input.nextInt());

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
  //DELETES
  public void deleteRow(){
    PreparedStatement pStmt = null;
    String deleteStatement = "DELETE FROM course WHERE course_id = ?";
    try{
      pStmt = connection.prepareStatement(deleteStatement);

      System.out.println("Enter the course ID to be deleted");
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