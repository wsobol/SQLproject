import java.sql.*;
import java.math.*;
import oracle.jdbc.*;
import java.util.*;

public class Queries{
  private Connection connection;
  private Scanner input = new Scanner(System.in);
  public Queries(){}
  public Queries(Connection conn){
    connection = conn;
  }
  public void runQuery(int userOption){
      PreparedStatement pStmt = null;
      ResultSet rs = null;
      String statstr = null;
      try {
//QUERY 8
		if (userOption == 8){
          System.out.println("List a person's missing knowledge/skills for a specific job in a readable format.");
          statstr = "SELECT k_code " +
          "FROM(SELECT k_code " +
                "FROM required " +
                "WHERE job_id = ? ) " +
                "MINUS " +
                "(SELECT k_code " +
                "FROM has_skill " +
                "WHERE person_id = ?)";

          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job id");
          pStmt.setInt(1, input.nextInt());
          System.out.println("Enter person ID");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            String kCode = rs.getString("k_code");
            System.out.println(kCode);
          }
        }
		
//QUERY 9
		else if (userOption == 9){
          System.out.println("List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job. ");
          statstr = "WITH skill_gap AS( " +
        		  "SELECT k_code " +
        		  "FROM ( SELECT k_code " +
        		  		"FROM required  " +
        		  		"WHERE job_id = ?) " +
        		  	"MINUS " +
        		  		"(SELECT k_code " +
        		  		"FROM has_skill  " +
        		  		"WHERE person_id = ?) ) " +
        		 " SELECT course_id, C.title " +
        		 " FROM course C " +
        		 " WHERE NOT EXISTS ( ( SELECT k_code " +
        		  			    "FROM skill_gap) " +
        		  			"MINUS " +
        		  			"(SELECT k_code " +
        		  			"FROM course_skill CS " +
        		  			"WHERE C.course_id = CS.course_id) )" ;


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job id");
          pStmt.setInt(1, input.nextInt());
          System.out.println("Enter person ID");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
          String courseID = rs.getString("course_id");
          String courseTitle = rs.getString("title");
          System.out.println(courseID + "\t" + courseTitle);
        }
      }
		
//QUERY 10
		else if (userOption == 10){
		  System.out.println("Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the " +
		          "\"quickest\" solution for this worker. Show the course, section information and the completion date");
		          statstr = "WITH skill_gap AS ( " +
"SELECT k_code " +
"FROM ( SELECT k_code " +
	"FROM required  " +
	"WHERE job_id = ?) " +
	"MINUS " +
	"( SELECT k_code " +
	"FROM has_skill  " +
	"WHERE person_id = ? ) ) , " +
"gap_courses AS ( " +
		"SELECT course_id " +
		"FROM course C " +
		"WHERE NOT EXISTS ( " +
			"(SELECT k_code " +
			"FROM skill_gap) " +
	"MINUS " +
	"(SELECT k_code " +
	"FROM course_skill CS " +
	"WHERE C.course_id = CS.course_id ) ) ) " +

"SELECT course_id, sec_id, semester, yr, completion_date " +
"FROM gap_courses NATURAL JOIN section " +
"WHERE completion_date = (SELECT MIN(completion_date) " +
				"FROM gap_courses NATURAL JOIN section)" ;

		          pStmt = connection.prepareStatement(statstr);
		          System.out.println("Enter job ID");
		          pStmt.setInt(1, input.nextInt());
		          System.out.println("Enter person ID");
		          pStmt.setInt(2, input.nextInt());
		          rs = pStmt.executeQuery();

		          System.out.println("Code \t Section ID \t Semester \t Year \t Date");
		          while(rs.next()){
		            String courseID = rs.getString("course_id");
		            String sectionID= rs.getString("sec_id");
		            String semester = rs.getString("semester");
		            String year = rs.getString("yr");
		            java.util.Date completionDate = rs.getDate("completion_date");
		            System.out.println(courseID + "\t" + sectionID + "\t" + semester + "\t" + year + "\t" + completionDate);
		          }
		        }	
		
//QUERY 11		
		else if (userOption == 11){
	          System.out.println("Find the cheapest course to make up one’s skill gap by showing the course to take and the cost (of the section price).");
	          statstr = "WITH skill_gap AS ( " +
	          	
		"SELECT k_code " +
		"FROM  ( SELECT k_code " +
			"FROM required  " +
			"WHERE job_id = ?) " +
			"MINUS  " +
			"( SELECT k_code " +
			"FROM has_skill " + 
			"WHERE person_id = ?) ) , " +
"gap_courses AS ( " +
		"SELECT course_id " +
		"FROM course C " +
		"WHERE NOT EXISTS ( " +
		"(SELECT k_code " +
		"FROM skill_gap) " +
		"MINUS " +
		"(SELECT k_code " +
		"FROM course_skill CS " +
		"WHERE C.course_id = CS.course_id))) " +

"SELECT course_id, sec_id, completion_date, price " +
"FROM gap_courses NATURAL JOIN section " +
"WHERE price = (SELECT MIN(price) " +
				"FROM gap_courses NATURAL JOIN section)";


	          pStmt = connection.prepareStatement(statstr);
	          System.out.println("Enter job code");
	          pStmt.setInt(1, input.nextInt());
	          System.out.println("Enter the person's ID number");
	          pStmt.setInt(2, input.nextInt());
	          rs = pStmt.executeQuery();

	          System.out.println("Code \tSection \tPrice");
	          while(rs.next()){
	            String courseID = rs.getString("course_id");
	            String sectionID = rs.getString("sec_id");
	            int price = rs.getInt("price");
	            System.out.println(courseID + "\t" + sectionID + "\t" + price);
	          }
	        }
		
//QUERY 13
		else if (userOption == 13){
	          System.out.println("List all the job categories that a person is qualified for.");
	          statstr = "SELECT cate_code " +
"FROM job_category C " +
"WHERE NOT EXISTS( " +
		 "(SELECT k_code " +
		"FROM core NATURAL JOIN required NATURAL JOIN job_category " +
		"WHERE cate_code = C.cate_code) " + 
		"MINUS " +
  "(SELECT k_code " +
		"FROM has_skill " +
"WHERE person_id = ?))";


	          pStmt = connection.prepareStatement(statstr);
	          System.out.println("Enter person ID");
	          pStmt.setInt(1, input.nextInt());
	          rs = pStmt.executeQuery();

	          while(rs.next()){
	            String jobCategory = rs.getString("cate_code");
	            System.out.println(jobCategory);
	          }

	        }
		
// QUERY 14
        else if (userOption == 14){
          System.out.println("Find the job with the highest pay rate for a person according to his/her skill qualification.");
		  statstr = "WITH jobs_qualified_for AS( " +
						"SELECT job_id, pay_rate " +
						"FROM job J " +
						"WHERE NOT EXISTS( " +
							"(SELECT k_code " +
							"FROM required " +
							"WHERE job_id = J.job_id) " +
							"MINUS " +
						"(SELECT k_code " +
						"FROM has_skill " +
						"WHERE person_id = ?))) " +
					"SELECT job_id, pay_rate " +
					"FROM jobs_qualified_for " +
					"WHERE pay_rate = (SELECT MAX(pay_rate) " +
					"FROM jobs_qualified_for)" ;




          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter person ID");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          System.out.println("Job Code");
          while(rs.next()){
            String jobID = rs.getString("job_id");
            System.out.println(jobID);
          }
        }
		
//QUERY 15
        else if (userOption == 15){
          System.out.println("List all the names along with the emails of the persons who are qualified for a job.  ");
          statstr = "SELECT person_id, email " +
			"FROM person P " +
			"WHERE NOT EXISTS( " +
				"(SELECT k_code " +
				"FROM required " +
				"WHERE job_id = ?) " +
				"MINUS " +
				"(SELECT k_code " +
				"FROM has_skill " +
				"WHERE has_skill.person_id = P.person_id)) " ; 


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job ID");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            String personID = rs.getString("person_id");
            String email = rs.getString("email");
            System.out.println(personID + "\t" + email);
          }
        }
		
//QUERY 16
        else if (userOption == 16){
          System.out.println("When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost \n" +
          "qualified to the job. Make a missing-one list that lists people who miss only one skill for a specified job.");

          statstr = "SELECT person_id " +
			"FROM person P " +
			"WHERE ( SELECT COUNT(*) " +
              "FROM  (( SELECT k_code " +
				"FROM required " +
					"WHERE job_id = ? ) " +
				"MINUS " +
                   "(SELECT k_code " +
                    "FROM has_skill " + 
					"WHERE person_id = P.person_id))) = 1 " ;


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job ID");
          int jobID = input.nextInt();
          pStmt.setInt(1, jobID);
          rs = pStmt.executeQuery();

          while(rs.next()){
            String personID = rs.getString("person_id");
            System.out.println(personID);
          }
        }
		
//QUERY 17		
        else if (userOption == 17){
            System.out.println("List the skillID and the number of people in the missing-one list for a given job code in the ascending order of the people counts.");
            statstr = "WITH skills_required AS ( " +
	"SELECT k_code " +
	"FROM required " + 
	"WHERE job_id = ? ) , " +


"skill_gap AS ( " +
	"SELECT person_id, k_code " +
	"FROM ( ( SELECT person_id, k_code FROM person, skills_required) " +
		"MINUS " +
		"(SELECT person_id, k_code FROM has_skill) ) ), " +

"persons_missing_one AS ( " +
	"SELECT person_id " +
	"FROM skill_gap " +
	"GROUP BY person_id " +
	"HAVING COUNT(k_code) = 1) " +

"SELECT k_code, COUNT(k_code) " +
"FROM persons_missing_one NATURAL JOIN skill_gap " +
"GROUP BY k_code " +
"ORDER BY COUNT(k_code) ASC" ;


            pStmt = connection.prepareStatement(statstr);
            System.out.println("Enter job ID");
            int jobCode = input.nextInt();
            pStmt.setInt(1, jobCode);
            rs = pStmt.executeQuery();

            System.out.println("K Code \t Amt of People");
            while(rs.next()){
              String kCode = rs.getString("k_code");
              int pIDCount = rs.getInt("COUNT(k_code)");
              System.out.println(kCode + "\t" + pIDCount);
            }
          }
		
//QUERY 18
else if (userOption == 18){
          System.out.println("Suppose there is a new job that has nobody qualified. List the persons who miss the least number of skills and " +
			"report the least number.");
			
			statstr = "WITH required_skills AS( " +
				"SELECT k_code " +
				"FROM required " +
				"WHERE job_id= ?), " +
					"skills_gap AS( " +
						"SELECT person_id, k_code " +
						"FROM ((SELECT person_id, k_code FROM person, required_skills) " +
						"MINUS " +
						"(SELECT person_id, k_code FROM has_skill))), " +

					"skills_missing (person_id, amt) AS( " +
						"SELECT person_id, COUNT(k_code) " +
						"FROM skills_gap " +
						"GROUP BY person_id) " +
				"SELECT person_id, amt " +
				"FROM skills_missing " +
				"WHERE amt = (SELECT MIN(amt) FROM skills_missing)"; 

          pStmt = connection.prepareStatement(statstr);
		  System.out.println("Enter job ID");
		  int jobID = input.nextInt();
          pStmt.setInt(1, jobID);
          rs = pStmt.executeQuery();

          while(rs.next()){
            String personID = rs.getString("person_id");	  
            String amt = rs.getString("amt");	 
			System.out.println(personID + "\t" + amt);
			}
        }
	 
//QUERY 19
else if (userOption == 19){
          System.out.println("For a specified job category and a given small number k, make a 'missing-k' " +
                              "list that lists the peopleâ€™s IDs andthe number of missing skills  for the " +
                              "people who miss only up to k skills in the ascending order of missing skills.");

          statstr = "WITH required_skills AS( " +
				"SELECT k_code " +
				"FROM core " +
				"WHERE cate_code = ? ), " +

			"Skills_gap AS( " +
				"SELECT person_id, k_code " +
				"FROM ((SELECT person_id, k_code FROM person, required_skills) " +
				"MINUS " +
				"(SELECT person_id, k_code FROM has_skill) ) ) " +

			"SELECT person_id, COUNT(*) " +
			"FROM skills_gap " +
			"GROUP BY person_id " +
			"HAVING COUNT(*) <= ?" ;


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter category code");
          int cate_code = input.nextInt();
          pStmt.setInt(1, cate_code);
          System.out.println("Enter missing skills 'k'");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int personId = rs.getInt("person_id");
            int count = rs.getInt("COUNT(*)");
            System.out.println(personId + "\t" + count);
          }
        }	  

//QUERY 20
        else if (userOption == 20){
          System.out.println("Given a job category code and its corresponding missing-k list specified " +
                              "in Question 19. Find every skill that is needed by at least one person in the " +
                              "given missing-k list. List each skillID and the number of people who need it " +
                              "in the descending order of the people counts");

          statstr = "WITH required_skills AS( " +
				"SELECT k_code " +
				"FROM core " +
				"WHERE cate_code = ? ) , " +

			"skills_gap AS( " +
				"SELECT person_id, k_code " +
				"FROM ((SELECT person_id, k_code FROM person, required_skills) " +
				"MINUS " +
				"(SELECT person_id, k_code FROM has_skill))), " +

			"persons_missing_skills_number AS( " +
				"SELECT person_id " +
				"FROM skills_gap " +
				"GROUP BY person_id " +
				"HAVING COUNT(*) <= ?) " +

			"SELECT k_code, COUNT(k_code) " +
			"FROM persons_missing_skills_number NATURAL JOIN skills_gap " +
			"GROUP BY k_code " +
			"ORDER BY COUNT(person_id) DESC";


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter category code");
          int cateCode = input.nextInt();
          pStmt.setInt(1, cateCode);
          System.out.println("Enter missing skills 'k'");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            String kCode = rs.getString("k_code");
            int pIDCount = rs.getInt("COUNT(k_code)");
            System.out.println(kCode + "\t" + pIDCount);
          }
        }		
	  
//QUERY 21
else if (userOption == 21){
          System.out.println("In a local or national crisis, we need to find all the people who once " +
                              "held a job of the special job category identifier.");

          statstr = "SELECT DISTINCT person_id " +
              "FROM has_job NATURAL JOIN job NATURAL JOIN job_category " +
              "WHERE cate_code = ?";

          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter category code.");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int perId = rs.getInt("person_id");
            System.out.println(perId);
          }
        }	  

//QUERY 22
 else if (userOption == 22){
          System.out.println("Find all the unemployed people who once held a job of the " +
                              "given job identifier.");

          statstr = "SELECT person_id " +
              "FROM has_job " +
              "WHERE job_id = ? AND end_date IS NOT NULL";

          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job ID");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int perId = rs.getInt("person_id");
            System.out.println(perId);
          }
        }

//QUERY 23		
else if (userOption == 23){
          System.out.println("Find out the biggest employer in terms of number of employees or \n" +
          "the total amount of salaries and wages paid to employees.");
          statstr = "WITH count_employees (comp_id, employee_total) as ( " +
					"SELECT comp_id, COUNT (DISTINCT(person_id)) " +
					"FROM job NATURAL JOIN company NATURAL JOIN has_job " +
					"GROUP BY comp_id) " +
				"SELECT comp_id " +
				"FROM count_employees " +
				"WHERE employee_total = (SELECT MAX(employee_total) " +
					"FROM count_employees)" ; 


          pStmt = connection.prepareStatement(statstr);
          rs = pStmt.executeQuery();

          while(rs.next()){
            String compID = rs.getString("comp_id");
            System.out.println(compID);
          }		  	  
        }

//QUERY 24
else if (userOption == 24){
          System.out.println("Find out the job distribution among business sectors; find out the biggest sector \n" +
          "in terms of number of employees or the total amount of salaries and wages paid to employees.");
		  
          statstr = "WITH count_employees (primary_sector, employee_amount) as " +
				"( SELECT primary_sector, COUNT(DISTINCT(person_id) ) " +
				"FROM job NATURAL JOIN company NATURAL JOIN has_job " +
				"GROUP BY primary_sector) " +
				"SELECT primary_sector " +
				"FROM count_employees " +
				"WHERE employee_amount = (SELECT MAX (employee_amount) " +
				"FROM count_employees)";


          pStmt = connection.prepareStatement(statstr);
          rs = pStmt.executeQuery();

          while(rs.next()){
            String sector = rs.getString("primary_sector");
            System.out.println(sector);
          }
        }
		
//END QUERIES	
   } catch (SQLException e){
      System.out.println(e.getMessage());
    } finally {
      try{

        if (rs != null) rs.close();
        if (pStmt != null) pStmt.close();

      }catch (SQLException e){
        System.out.println(e.getMessage());
      }
    }

  }

}
	  
	  
	  
	  
		
		