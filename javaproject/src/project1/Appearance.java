package project1;
 import java.io.File;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;


 
 public class Appearance {

 public static void main(String[] args) {
 // TODO Auto-generated method stub 

 Start();
 AscendOrder();
 }

 public static void Start() {
 String msg = "WELCOME!";
 for(int i=0; i<2; i++) {
 for(int j=0; j<msg.length(); j++) {
 System.out.print("*");
 }
 System.out.println();
 if(i==0) {
 System.out.println(msg);
 }
 }

 System.out.println("Developer Details:\nName:Giriraj Khore. ");

 for(int i=0; i<1; i++) {
 for(int j=0; j<msg.length(); j++) {
 System.out.print("----");
 }
 System.out.println();
 }

 userInterface();
 }


 public static void userInterface() {

 System.out.println("1. Show files in Ascending Order");
 System.out.println("2. Handle the files");
 System.out.println("3. Close the application");

 try (Scanner sc = new Scanner(System.in)) {
	try {
	 System.out.print("Choose from above options: ");
	 int in = sc.nextInt();
	
	 switch(in) {
	
	 case 1 -> AscendOrder();
	
	 case 2 -> FileHandling();
	
	 case 3 -> System.out.println("Thank you for using our Application!");
	 }
	 }
	 catch(Exception e) {
	 System.out.println("Oops!! Please Enter valid number");
	 userInterface();
	 }
}
 }


 public static void FileHandling() {

 System.out.println("\n\n1-> Add a file to existing directory");
 System.out.println("2-> Delete a file from existing directory");
 System.out.println("3-> Search a file from directory");
 System.out.println("4-> Navigate to Main menu");

 try (Scanner sc = new Scanner(System.in)) {
	try {
	 System.out.println("Choose from above options: ");
	 int ans = sc.nextInt();
	
	 switch(ans) {
	
	 case 1 -> createFile();
	
	 case 2 -> DeleteFile();
	
	 case 3 -> SearchFile();
	
	 case 4 -> userInterface();
	
	 }
	 }catch (Exception e) {
	 System.err.println("Oops!! Please Enter valid number");
	 FileHandling();
	 }
}
 }

 public static void AscendOrder() {

 File Main = new File("C:\\Users\\girir\\OneDrive\\Desktop\\Locker");

 Main.mkdir();

 if(Main.isDirectory()){
 List <String> FileList = Arrays.asList(Main.list());
 Collections.sort(FileList);
 System.out.println("---------------------------------------");
 System.out.println("Sorting by filename in ascending order");
 for(String s:FileList){
 System.out.println(s);

 }
 } else{
 System.out.println(Main.getAbsolutePath() + " is not a directory");
 }
 userInterface();
 }


 public static void createFile() {

 File file = new File("C:\\Users\\girir\\OneDrive\\Desktop\\Locker");
 //Creating the directory
 file.mkdir();


 try (Scanner sc = new Scanner(System. in )) {
	System.out.println("Enter the file name : ");
	 String name = sc.nextLine(); //variable name to store the file name
	 File file1 = new File("C:\\Users\\girir\\OneDrive\\Desktop\\Locker"+name);
	
	 try {
	 if (file1.createNewFile()) {
	 System.out.println("File Created! :)");
	 FileHandling();
	 } else {
	 System.out.println("File already exists :(");
	 FileHandling();
	 }
	 } catch (Exception e) {
	 System.out.println(e);
	 }
}


 }

 public static void DeleteFile() {

 String filename;
 try (Scanner scan = new Scanner(System.in)) {
	System.out.println("Enter the Name of File you want to Delete: ");
	 filename = scan.nextLine();
}

 File file= new File("C:\\Users\\girir\\OneDrive\\Desktop\\Locker"+filename);

 if (file.delete()) {
 System.out.println("File deleted successfully");
 FileHandling();
 }
 else {
 System.err.println("Oops !! File not found.Please try again ");
 FileHandling();
 }
 }


 public static void SearchFile() {
 System.out.println("Enter the name of the file to Search");
 try (Scanner s1 = new Scanner(System.in)) {
	String folderName = s1.next();
	 File file = new File("C:\\Users\\girir\\OneDrive\\Desktop\\Locker"+folderName);
	
	 if (file.exists()) {
	 System.out.println("Yep! File found!! :)"+"\n"+"This is the file location");
	 System.out.println(file.getAbsolutePath());
	 FileHandling();
	 } else {
	 System.out.println("Sorry, File Not Found :(");
	 FileHandling();
	 }
}

 }

 }


