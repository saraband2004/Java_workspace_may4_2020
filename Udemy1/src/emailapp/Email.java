package emailapp;
import java.io.*; 
import java.util.*; 
import java.lang.*;

public class Email {
	private String name;
	private char gender;
	private String password;
	private String companySuffix = "abcAG.com";
	public Email(String name) {
		this.name = name;
		System.out.println("Email created for "+name);
		this.gender = setGender();
		System.out.println("Gender is "+this.gender);
		this.password = setPassword();
		System.out.println("Your password is "+this.password);
		
		
		
	}
	private char setGender(){
		System.out.println("Enter the gender:\n M for Male\n F for Female");
		Scanner input = new Scanner (System.in);
		String sex = input.nextLine();
		int num = input.nextInt();
		String s =input.next();
		System.out.println(num+3 + s);
		if (sex.compareTo("F") == 0) {return 'F';}
		if (sex.compareTo("M") == 0) {return 'M';}
		return 'X';
	}
	private String setPassword() {
		String passwordSet = "ABCDEFGHIJKLMNabcdefghijklmn0123456789";
		String password = "";
		Random RNG = new Random();
		for (int i = 0 ; i<10; i++) {
			password = password + passwordSet.charAt(RNG.nextInt(passwordSet.length()));
		}
		return password;
	}
	public void changePassword(String password) {
		
	}
}
