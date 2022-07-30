package virtualKey.Screens;

import java.util.ArrayList;
import java.util.Scanner;

public class welcomeScreen 
{
	private String introText = " _____________________________Welcome to LOCKEDME.COM______________________________\n";
    private String developerDetails = "Developer Details:\nDeveloper Name: Kamali S\nContact :xxxx@abc.com";

    //function to print introduction about application and developer
    public void introScreen()
    {
    	System.out.println("####################################################################################\n\n");
    	System.out.println(introText);
        System.out.println(developerDetails);
        System.out.println("\n\n####################################################################################\n");
        displayMenu();
    }

    //function to display the options of main menu 
    public static void displayMenu()
    {
    	 ArrayList<String> option= new ArrayList<>();
    	 option.add("\nMain Menu:\n");
         option.add("1. List the files");
         option.add("2. Show file operations");
         option.add("3. Quit");
         
    	 for(int i=0;i<option.size();i++)
    	    {
    	    	System.out.println(option.get(i));
    	    }
    	 userInput();
    }
    
    //function to get the user input & execute accordingly
    public static void userInput()
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nEnter your choice : ");
    	int in = sc.nextInt();
    	
    	switch(in)
		{
		case 1:
			fileOptions.listFiles();                       //to display the list of available files in the directory
			displayMenu();
			break;
			
		case 2:
			fileOptions.displayMenu();                     //to display the options of file operation
			break;
			
		case 3:
			System.out.println("\n####################################################################################\n");
			System.out.print("\n \t\t\tClosing the application....\n \n \t\t\t\tThank you!!!");
			System.out.println("\n\n####################################################################################\n\n");
			System.exit(1);                                //to exit from the application
			break;
			
		default:
			System.out.print("\nInvalid option...");
			displayMenu();
			break;
		}
    	
    }
   
}
