import java.util.*;
import java.sql.*;
import java.math.*;
import oracle.jdbc.*;

public class DataModifier{
  private Connection connection;
  private Scanner input = new Scanner(System.in);
  public DataModifier(Connection conn){
    connection = conn;
  }

  public void change(int userOption){

    while(userOption != 0){
//PERSON MODIFIER
      if(userOption == 1){
        System.out.printf("1: Insert \n 2: Delete  3: Exit \n");
        userOption = input.nextInt();

        if(userOption == 1){
          Person insert = new Person(connection);
          insert.insertRow();
        }

        else if(userOption == 2){
          Person delete = new Person(connection);
          delete.deleteRow();
          userOption = 1;
        }

        else userOption = 0;

      }
//JOB MODIFIER
      else if(userOption == 2){
        System.out.printf("1: Insert \n 2: Delete  3: Exit \n");
        userOption = input.nextInt();

        if(userOption == 1){
          Job insert = new Job(connection);
          insert.insertRow();
          userOption = 2;
        }

        else if(userOption == 2){
          Job delete = new Job(connection);
          delete.deleteRow();

        }

        else userOption = 0;

      }
//CATEGORY MODIFIER
      else if(userOption == 3){
        System.out.printf("1: Insert \n 2: Delete  3: Exit \n");
        userOption = input.nextInt();

        if(userOption == 1){
        	Job_category insert = new Job_category(connection);
          insert.insertRow();
          userOption = 3;
        }

        else if(userOption == 2){
          Job_category delete = new Job_category(connection);
          delete.deleteRow();
          userOption = 3;
        }

        else userOption = 0;

      }

// COURSE MODIFIER
      else if(userOption == 4){
        System.out.printf("1: Insert \n 2: Delete  3: Exit \n");
        userOption = input.nextInt();

        if(userOption == 1){
          Course insert = new Course(connection);
          insert.insertRow();
          userOption = 5;
        }

        else if(userOption == 2){
          Course delete = new Course(connection);
          delete.deleteRow();
          userOption = 5;
        }

        else userOption = 0;

      }
    }
  }
}