//William Sobol
import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class Job_category{
  private Connection connection;
  private Scanner input = new Scanner(System.in);

  public Job_category(Connection conn){
    connection = conn;
  }

	//INSERTS
  public void insertRow(){
    PreparedStatement pStmt = null;
    String insertStatement = "INSERT INTO job_category(cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (?, ?, ?, ?, ?, ?)";

    try{
      pStmt = connection.prepareStatement(insertStatement);

      System.out.println("Enter category code");
      pStmt.setInt(1, input.nextInt());
      input.nextLine();

	  System.out.println("Enter low pay range");
      pStmt.setString(2, input.nextLine()); 
	 
	  System.out.println("Enter high pay range");
      pStmt.setString(3, input.nextLine());
	 
      System.out.println("Enter job category title");
      pStmt.setString(4, input.nextLine());

      System.out.println("Enter parent category");
      pStmt.setInt(5, input.nextInt());
      input.nextLine();
      
      System.out.println("Enter SOC");
      pStmt.setString(6, input.nextLine());
      
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
    String deleteStatement = "DELETE FROM job_category WHERE cate_code = ?";
    try{
      pStmt = connection.prepareStatement(deleteStatement);

      System.out.println("Enter category code of job to be deleted");
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