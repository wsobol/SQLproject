//William Sobol
import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class JobCategory{
  private Connection connection;
  private Scanner input = new Scanner(System.in);

  public JobCategory(Connection conn){
    connection = conn;


	//INSERTS
  public void insertRow(){
    PreparedStatement pStmt = null;
    String insertStatement = "INSERT INTO job_category(cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (?, ?, ?, ?, ?, ?)";

    try{
      pStmt = connection.prepareStatement(insertStatement);

      System.out.println("Enter category code");
      pStmt.setInt(1, input.nextInt());

	  System.out.println("Enter lowow pay range");
      pStmt.setInt(2, input.nextInt()); 
	 
	  System.out.println("Enter high pay range");
      pStmt.setInt(3, input.nextInt());
	 
      System.out.println("Enter job category title");
      pStmt.setString(4, input.nextLine());

      System.out.println("Enter parent category");
      pStmt.setInt(5, input.nextInt());

      System.out.println("Enter SOC");
      pStmt.setInt(6, input.nextInt());

      pStmt.executeUpdate();
    }catch(SQLException e){
      e.getMessage();
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