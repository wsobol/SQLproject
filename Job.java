//William Sobol
import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class Job{
  private Connection connection;
  private Scanner input = new Scanner(System.in);

  public Job(Connection conn){
    connection = conn;
  }

  //INSERT
  
  public void insertRow(){
    PreparedStatement pStmt = null;
    String insertStatement = "INSERT INTO job(job_id, pay_rate, pay_type, comp_id, emp_mode, " +
                              "cate_code) values (?, ?, ?, ?, ?, ?)";
    try{
      pStmt = connection.prepareStatement(insertStatement);

      System.out.println("Enter job code");
      pStmt.setInt(1, input.nextInt());
     
      System.out.println("Enter pay rate");
      pStmt.setInt(2, input.nextInt());
      
      System.out.println("Enter pay type (Hourly/Salary)");
      pStmt.setString(3, input.nextLine());

      System.out.println("Enter company id");
      pStmt.setInt(4, input.nextInt());
      	  
	  System.out.println("Enter employment type (Full-Time/Part-Time");
      pStmt.setString(5, input.nextLine());

      System.out.println("Enter job category code");
      pStmt.setInt(6, input.nextInt());

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
    String deleteStatement = "DELETE FROM Job WHERE job_id = ?";
    try{
      pStmt = connection.prepareStatement(deleteStatement);

      System.out.println("Enter Job ID to be deleted");
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