package OnlineExamination;

import java.util.Scanner;

public class OnlineExaminationSystem {
	 static ExamSystem system = new ExamSystem();
	
     static Scanner sc = new Scanner(System.in);
     public static void main(String[] args) {
   	   System.out.print("**********ONLINE QUIZ**********");
      while (true) {
          System.out.println("\n1. Login");
          System.out.println("2. Update");
          System.out.println("3. Start Exam");
          System.out.println("4. Submit Exam");
          System.out.println("5. Logout");
          System.out.println("6. Exit");
          System.out.print("Choose an option: ");
          int choice = sc.nextInt();
          sc.nextLine(); // Consume newline

          switch (choice) {
              case 1://login
            	   System.out.println("\n-----login-----");
                  System.out.println("Enter username: ");
                  String username = sc.nextLine();
                  System.out.println("Enter password: ");
                  String password = sc.nextLine();
                  system.login(username, password);
                  break;
              case 2://update
              {
            	   System.out.println("\n\t-----update-----");
            		System.out.println("\tWhat do you want to update");
            		System.out.println("\ta.Profile");
            		System.out.println("\tb. Password");
            	    System.out.println("\tChoose an option: ");
            	    String opt = sc.nextLine();
            	    switch (opt) {
            	    case "a":
            	  	  //update profile
            	    	if (system.loggedInUser != null) {
            	    		System.out.println("\t-----update profile-----");
            	            System.out.println("\tEnter new Profile: ");
            	            String newProfile = sc.next();
            	            system.updateProfile(newProfile);
            	        } else {
            	            System.out.println("Please login first.");
            	        }
            	    	break;
            	    case "b":
            	  	//update password
            	    	 if (system.loggedInUser != null) { 
            	    		 System.out.println("\t-----update password-----");
            	             System.out.println("\tEnter new password: ");
            	             String newPassword = sc.nextLine();
            	             system.updatePassword(newPassword);
            	         } else {
            	             System.out.println("Please login first.");
            	         }
            	    break;
            	    default:   System.out.println("Invalid option. Please try again.");
            	    }
              }
                  break;
              case 3://quiz start
                  system.startExam();
                  break;
              case 4:
            	//submit
            	  system.submitExam();
                  break;
              case 5://logout
                  system.logout();
            	  break;
              case 6://exit
                  System.out.println("Exiting...");
                  return;
              default:
                  System.out.println("Invalid option. Please try again.");
          }
      }
  }
}