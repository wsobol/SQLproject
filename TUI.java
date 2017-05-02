//William Sobol
import java.util.Scanner;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class TUI{
  private Scanner input = new Scanner(System.in);
  private Connection connection;
  public TUI(){

  }
  public TUI(Connection conn){
    connection = conn;
  }
  public void menuInput(){
    System.out.println("Enter '0' to exit");
    System.out.println("Enter '1' to execute a query");
    System.out.println("Enter '2' to change a table");
    option(input.nextInt());
  }
//input option choice
  public void option(int inputOption){
    if(inputOption == 1) queryRunner();
    else if(inputOption == 2) dataChangeRunner();
  }
//queries
  public void queryRunner(){
      int choice;
      Query query = new Query(connection);
    do{
      System.out.println("Enter '0' to exit or '8-28' to run a specific query");
      choice = input.nextInt();
      if(choice > 8 && choice <= 28){
          query.runQuery(choice);
      }
    }while(choice != 0);
  }

  //table modifier
  public void dataChangeRunner(){
    int choice;
    DataModifier changeData = new DataModifier(connection);
    do{
      System.out.println("Enter '0' to exit \n '1' for Person \n '2' for Job \n '3' for Job Category \n or '4' for Course");
      choice = input.nextInt();
      if(choice > 0 && choice <= 4){
        changeData.change(choice);
      }
    }while(choice != 0);
  }
}