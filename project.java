package oops_project;
import java.util.Scanner;
import java.util.Date;

public class project {
	class driver {

	    private String name;
	    private int code;
	    private Date dob;
	    private char gender;
	    private String address;

	    
	    void input()
	    {
	    	Scanner in = new Scanner(System.in);
	    	dob = new Date();
	    	System.out.println("ENTER DRIVER DETAILS");
	    	System.out.println("Enter 3-digit Driver Code ");
	    	System.out.println("(PLEASE ENTER 3 DIGIT NUMBER ONLY) ");
	        code = in.nextInt();
	        System.out.println('\n' + "Enter Driver's Name ");
	        name = in.nextLine();
	        System.out.println("Enter Driver's Date of Birth in order Day-Month-Year ");
	        System.out.println("(- MEANS USE SPACE BAR HERE) ");
	        System.out.println("Enter Gender m-male,f-female,o-other ");
	        gender = in.nextLine().charAt(0);
	        System.out.println("Enter Address ");
	        address = in.nextLine();
	    }
	    void maddress(String newAddress)
	    {
	        address = newAddress;
	    }
//	    void mdob(date Dob)
//	    {
//	        dob.d=Dob.d;
//	        dob.m=Dob.m;
//	        dob.y=Dob.y;
//	    }
	    void mname(String newName)
	    {
	        name = newName;
	    }
	    int cod()
	    {
	        return code;
	    }
	    String rname()//return name
	    {
	        return name;
	    }

	    void display()
	    {
	        System.out.println("Driver's code :- " + code);
	        System.out.println("Driver's Name :- " + name);
	        System.out.println("Driver's date of birth  :- ");
	        System.out.println("Driver's Gender :- " + gender);;
	        System.out.println("Driver's Address :- "+ address);
	    }
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
