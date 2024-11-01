package OnlineExamination;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class ExamSystem {
	static Scanner sc= new Scanner(System.in);
	 private Map<String, User> users = new HashMap<>();
	static  User loggedInUser;
	  private boolean examInProgress = false;
	    private Timer timer;

	    //login user and password
	    public ExamSystem() {
	        // Sample user
	        users.put("mona123", new User("monika123", "monika"));
	    }
	    
	    //login method
	    public boolean login(String username, String password) {
	        User user = users.get(username);
	        if (user != null && user.password.equals(password)) {
	            loggedInUser = user;
	            System.out.println("Login successful.");
	            return true;
	        } else {
	            System.out.println("Invalid username or password.");
	            return false;
	        }
	    }
	    
//logout method
	    public void logout() {
	        if (loggedInUser != null) {
	            loggedInUser = null;
	            System.out.println("Logged out successfully.");
	        } else {
	            System.out.println("No user is currently logged in.");
	        }
	    }

	    //update profile
	    public void updateProfile(String newInfo) {
	        if (loggedInUser != null) {
	            loggedInUser.updateProfile(newInfo);
	        } else {
	            System.out.println("Please login to update profile.");
	        }
	    }

	    //update password
	    public void updatePassword(String newPassword) {
	        if (loggedInUser != null) {
	            loggedInUser.updatePassword(newPassword);
	        } else {
	            System.out.println("Please login to update password.");
	        }
	    }

	    //submit quiz
	    public void submitExam() {
	        if (examInProgress) {
	            examInProgress = false;
	            timer.cancel();
	            System.out.println("Exam submitted successfully.");
	        } else {
	            System.out.println("No exam in progress to submit.");
	        }
	    }
	

	    //exam start
	    public void startExam() {
	    	 int count=0;
	    	    int ans;
	        if (loggedInUser == null) {
	            System.out.println("Please login to start the exam.");
	            return;
	        }
	        System.out.println("\n-----start quiz-----");
	        if (examInProgress) {
	            System.out.println("An exam is already in progress.");
	            return;
	        }

	        examInProgress = true;
	        System.out.println("\nExam started. You have 20 seconds to complete.");
	        System.out.println("There are 5 questions in the examination");
	        System.out.println("Each question consist of 4 option you have to choose correct answer");
	        // Timer set for 20 seconds for auto-submit
	        timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                submitExam();
	            }
	        }, 20000);
	        List<String> questions = Arrays.asList(
	                "\nQ.1. Java is developed by? \n a) James Gosling  \n b) Dennis Ritchie \n c) Ken Thompson \n d) Steve Jobs",
	                "\nQ.2. Java is? \n a) Low level \n b) High level \n c) Middle level \n d) Machine Level",
	                "\nQ.3. Java isy? \n a) Platform Dependent \n b) Einstein \n c) None \n d) All of the above",
	                "\nQ.4. Technical Name of Core Java is knon as? \n a) Compiled Language \n b) Interpreted Language \n c) Both Compiled and Interprete \n d) None",
	                "\nQ.5. Java is? \n a) Compiled Language \n b) Interpreted Language \n c) Both Compiled and Interpreted \n d) None"
	        );

	        for (String question : questions) {
	            System.out.println(question);
	            System.out.print("Enter your answer (a/b/c/d): ");
	            String answer = sc.nextLine();
	        }
	        }
	    
	    
	   
	}