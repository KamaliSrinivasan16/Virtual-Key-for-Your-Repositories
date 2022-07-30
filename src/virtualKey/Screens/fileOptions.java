package virtualKey.Screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class fileOptions 
{
	//function to display the options of file operations menu
	public static void displayMenu()
    {
		ArrayList<String> option = new ArrayList<>();
		option.add("\n Select a operation :\n");
		option.add("1. Add a File");
        option.add("2. Delete A File");
        option.add("3. Search A File");
        option.add("4. Return to Menu");
       
    	 for(int i=0;i<option.size();i++)
    	    {
    	    	System.out.println(option.get(i));
    	    }
    	 userInput();
    }
	
	    public static String name = "C:\\Users\\Parthi K\\eclipse-workspace\\virtualKeyForRepository\\resources\\Directory\\";

	    private static ArrayList<File> files = new ArrayList<File>();
	    
	    static Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
	    
	    static File Dfiles = path.toFile();
	
	//function to list the files available in the directory
	public static void listFiles()
	{
		
		System.out.println("\n List of files: \n");
        File[] directoryFiles = Dfiles.listFiles();
    	files.clear();
    	
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	for(File f : files)
    	{
    		System.out.println(" "+f.getName());
    	}
		
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
	        addFile();
	        displayMenu();
			break;
			
		case 2:
			deleteFile();
			displayMenu();	
			break;
			
		case 3:
			searchFile();
			displayMenu();
			break;
			
		case 4:
			welcomeScreen.displayMenu();
		    break;
		    
		default:
			System.out.print("\nInvalid option...");
			break;
		}
    }
	
	//function to new add files to the existing directory
	public static void addFile()
	{
		System.out.print("\nEnter the file name: ");
		String newFile = getInput();
		File f = new File(name+newFile);
		try {
			if(f.createNewFile())
			{
				System.out.print("\nNew file added : "+f.getName()+"\n");
				files.add(f);
			}
			else
			{
				System.out.print("This file already exists\n");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		listFiles();
	}
	
	//function to delete the mentioned file from the directory
	public static void deleteFile()
	{
		System.out.print("\nEnter the file name: ");
		String delFile = getInput();
		File f = new File(name+delFile);
		if(f.delete())
		{
			System.out.print("\nThe file named '"+f.getName()+"' is deleted successfully");
			files.remove(f);
		}
		else
		{
			System.out.print("\nFile not found\n");
		}
		listFiles();
		
	}
	
	//function to search the mentioned file from the directory
	public static void searchFile()
	{
		System.out.print("\nEnter the file name: ");
		String lookFile = getInput();
		File f = new File(name+lookFile);
		if(f.exists())
		{
			System.out.print("The file '"+f.getName()+"', you are searching is found\n");
		}
		else
		{
			System.out.print("\nFile not found\n");
		}
	}

	//function to get the user-input
	public static String getInput()
	{
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();	
	}
}
