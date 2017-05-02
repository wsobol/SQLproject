//QUERY 8
		else if (userOption == 8){
          System.out.println("List a person’s missing knowledge/skills for a specific job in a readable format.");
          statstr = "SELECT k_code " +
          "FROM(SELECT k_code " +
                "FROM required " +
                "WHERE job_id = ? ) " +
                "MINUS " +
                "(SELECT k_code " +
                "FROM has_skill " +
                "WHERE person_id = ?) NATURAL JOIN knowledge_skills ";

          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job id");
          pStmt.setInt(1, input.nextInt());
          System.out.println("Enter person ID");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            String kCode = rs.getString("Missing k_code");
            System.out.println(kCode);
          }
        }
		
//QUERY 9
		else if (userOption == 9){
          System.out.println("9");
          statstr = "WITH skill_gap AS( " +
					"SELECT k_code, title " +
					"FROM ( SELECT k_code, title " +
						"FROM required" +
						"WHERE job_id = ?) " +
					"MINUS " +
						"(SELECT k_code, title " +
						"FROM has_skill " +  
						"WHERE person_id = ?) ) " +
				"SELECT course_id, C.title " +
				"FROM course C " +
				"WHERE NOT EXISTS ( ( SELECT k_code " +
					"FROM skill_gap) " +
					"MINUS " +
					"SELECT k_code " +
					"FROM course_skill as CS " +
					"WHERE C.course_id = CS.course_id) ) ";


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
	  
//QUERY 15
        else if (userOption == 15){
          System.out.println("List all the names along with the emails of the persons who are qualified for a job.  ");
          statstr = "SELECT person_id, email "
			"FROM person P "
			"WHERE NOT EXISTS( "
				"(SELECT k_code "
				"FROM required " 
				"WHERE job_id = ?) "
				"MINUS "
				"(SELECT k_code "
				"FROM has_skill "
				"WHERE has_skill.person_id = P.person_id)) " ; 


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job ID");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            String pName = rs.getString("pName");
            String email = rs.getString("email");
            System.out.println(pName"\t" + email);
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
					"WHERE job_code = ? ) " +
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
            String pName = rs.getString("pName");
            String email = rs.getString("email");
            System.out.println(pName "\t" + email);
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
		  System.out.printlin("Enter job ID");
		  int jobID = input.nextInt();
          pStmt.setInt(1, jobID);
          rs = pStmt.executeQuery();

          while(rs.next()){
            String pName = rs.getString("pName");	  
            String skills = rs.getString("skills");	 
			System.out.println(pName "\t" + skills);
			}
        }
	 
//QUERY 19
else if (userOption == 19){
          System.out.println("For a specified job category and a given small number k, make a 'missing-k' " +
                              "list that lists the people’s IDs andthe number of missing skills  for the " +
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
          int soc = input.nextInt();
          pStmt.setInt(1, cate_code);
          System.out.println("Enter missing skills 'k'");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int personId = rs.getInt("person_id");
            int count = rs.getInt("Skills_gap");
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

			"SELECT k_code, COUNT(person_id) as personCount " +
			"FROM persons_missing_skills_number NATURAL JOIN skills_gap " +
			"GROUP BY k_code " +
			"ORDER BY personCount DESC";


          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter category code");
          int cateCode = input.nextInt();
          pStmt.setInt(1, cateCode);
          System.out.println("Enter missing skills 'k'");
          pStmt.setInt(2, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int kCode = rs.getInt("k_code");
            int pIDCount = rs.getInt("personCount");
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
              "WHERE job_code = ? AND end_date IS NOT NULL";

          pStmt = connection.prepareStatement(statstr);
          System.out.println("Enter job ID");
          pStmt.setInt(1, input.nextInt());
          rs = pStmt.executeQuery();

          while(rs.next()){
            int perId = rs.getInt("person_id");
            System.out.println(perId);
          }
        }
	  
	  
	  
	  
		
		