package oops_project;

import java.util.Scanner;

public class project {
	
	Scanner scan = new Scanner(System.in);
	
	class date{
		int d, m, y;
	}
	
	class driver {

	    private String name;
	    private int code;
	    private date dob;
	    private char gender;
	    private String address;

	    
	    void input()
	    {
	    	dob = new date();
	    	System.out.println("ENTER DRIVER DETAILS");
	    	System.out.println("Enter 3-digit Driver Code ");
	    	System.out.println("(PLEASE ENTER 3 DIGIT NUMBER ONLY) ");
	        code = scan.nextInt();
	        System.out.println('\n' + "Enter Driver's Name ");
	        name = scan.nextLine();
	        System.out.println("Enter Driver's Date of Birth in order Day-Month-Year ");
	        System.out.println("(- MEANS USE SPACE BAR HERE) ");
	        System.out.println("Enter Gender m-male,f-female,o-other ");
	        gender = scan.nextLine().charAt(0);
	        System.out.println("Enter Address ");
	        address = scan.nextLine();
	    }
	    
	    void maddress(String newAddress)
	    {
	        address = newAddress;
	    }
	    
	    void mdob(date Dob)
	    {
	        dob.d=Dob.d;
	        dob.m=Dob.m;
	        dob.y=Dob.y;
	    }
	    
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
	        System.out.println("Driver's date of birth  :- " + dob.d + "-" + dob.m + "-" + dob.y);
	        System.out.println("Driver's Gender :- " + gender);;
	        System.out.println("Driver's Address :- "+ address);
	    }
	}
	
	class vehinfo extends driver
	{
	    private String regn,desc;
	    private char vtype;
	    private int spk;

	    public void mregn(String Regn)
	    {
	        regn = Regn;
	    }
	    
	    public void mdesc(String Desc)
	    {
	        desc = Desc;
	    }
	    
	    public void mvtype(char Vtype)
	    {
	        vtype=Vtype;
	    }
	    
	    public void input1()
	    {
	        input();
	        System.out.println("Enter Vehicle Information ");
	        System.out.println();
	        System.out.println("Enter Registration Number ");
	        
	        regn = scan.nextLine();//gets(regn);
	        System.out.println("Enter Vehicle Description ");
	        
	        desc = scan.nextLine();//cin.getline(desc,30);
	        System.out.println("Enter Vehicle Type a=autorickshaw,g=go,l=luxary");//cout<<endl<<"Enter Vehicle Type " <<"a=autorickshaw,g=go,l=luxary ";
	        vtype = scan.next().charAt(0);//cin>>vtype;
	      
	        if(vtype=='a'){
	        	spk=10;
	        } 
	        else if(vtype=='g'){
	        	spk=20;
	        }    
	        else{
	        	spk=30;
	        }
	            
	    }

	    int sal()
	    {
	        return spk;
	    }
	    
	    void display1()
	    {
	        display();
	        System.out.println("Registration Number " + regn);  //cout<<"Registration Number "<<regn<<endl;
	        System.out.println("Vehicle Description " + desc);  //cout<<"Vehicle Description "<<desc<<endl;
	        System.out.println("Vehicle Type " + vtype);  //cout<<"Vehicle Type "<<vtype<<endl;
	    }

	}
	
	class journey extends vehinfo
	{
	    private int nok;
	    private int stp;
	    private String salary;

	    journey()
	    {
	        nok=stp=0;
	        salary = "Unpaid";//strcpy(salary,"Unpaid");
	    }
	    void mstp()
	    {
	        stp=nok*sal();
	    }
	    void mpay(int Nok)
	    {
	        nok=Nok;
	        mstp();
	        salary = "Unpaid";//strcpy(salary,"Unpaid");
	    }

	    void input2()
	    {
	        input1();
	        System.out.println("\nEnter Number of Kilometers ");
	        System.out.println("(PLEASE ENTER ONLY NUMERALS UPTO 32000) ");
	        
	        nok = scan.nextInt();//cin>>nok;
	        mstp();
	    }
	    void pay()
	    {
	        if(stp!=0)
	        {
	            stp=0;
	            nok=0;
	            salary = "Paid";
	            mstp();
	        }
	        else{
	        	System.out.println("Salary already paid ");
	        }
	    }

	    void display2()
	    {
	        display1();
	        System.out.println("Number of kilometers before last payment " + nok);
	        System.out.println(salary);
	    }

	}// m,s;
	
	public int icode()
	{
	    int icod;
	    System.out.println("Enter 3-digit Driver Code ");
	    icod = scan.nextInt();
	    //system("cls");
	    return icod;
	};
	
	public void iname(String Name)
	{
		System.out.println("Enter Driver's Name ");
		Name = scan.nextLine();
	    //system("cls");
	};
	
	public int dcod(ifstream &fc,int &flag)
	{

	    int Cod;
	    Cod=icode();
	    while(!fc.eof())
	    {
	        fc.read((char*)&s,sizeof(journey));

	        if(Cod==s.cod())
	        {
	            s.display2();
	            flag=1;
	            break;
	        }
	    }
	    if(!flag)
	        cout<<"Record Not Found "<<endl;
	    return Cod;
	};
	
	public void dname(ifstream &fc)
	{
	    int flag=0;
	    char namec[20];
	    fflush(stdin);
	    cout<<"Enter Driver's Name "<<endl;
	    gets(namec);
	    while(!fc.eof())
	    {
	        fc.read((char*)&s,sizeof(journey));

	        if(strcmp(namec,s.rname())==0)
	        {
	            s.display2();
	            flag=1;
	            break;
	        }
	    }
	    if(!flag)
	        cout<<"Record Not Found "<<endl;
	};
	
	public void modify(int &c)
	{
	    ofstream f1("cabs.dat",ios::binary|ios::ate);
	    f1.seekp(c);
	    f1.write((char*)&s,sizeof(journey));
	    f1.close();
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b,cod,choice;
	    char c;
	    do
	    {
	        System.out.println("			WELCOME DIAL CABS");
	        System.out.println("Press 1 to Display Particular Driver's Details ");
	        System.out.println("Press 2 to Add New Driver's Details ");
	        System.out.println("Press 3 to Modify Driver's Details ");
	        System.out.println("Press 4 to Delete Driver Details ");
	        System.out.println("Press 5 to Pay Driver's Salary ");
	        System.out.println("Press 6 to Display All Drivers's Details");
	        System.out.println("(NOTE:- PLEASE ENTER NUMERICAL VALUE ONLY");
	        System.out.println("        ALSO PRESS ENTER AFTER EACH FIELD ENTERED, FIELD LIKE NAME,etc) ");
	        
	        ifstream f1;
	        f1.open("cabs.dat",ios::binary);
	        b = scan.nextInt();//cin>>b;
	        system("cls");
	        switch(b)
	        {
	        case 1:
	        {
	            int Cod,flag=0;
	            System.out.println(" WELCOME TO DISPLAY MENU ");
	            System.out.println(" Press 1 to Display using Driver Code ");
	            System.out.println(" Press 2 to Display using Driver's Name ");
	            System.out.println("(NOTE:- PLEASE ENTER NUMERICAL VALUE ONLY)");
	            System.out.println("Enter your choice ");
	            
	            choice = scan.nextInt();//cin>>choice;
	            //system("cls");
	            if(choice==1)
	            {
	                Cod=dcod(f1,flag);
	                f1.close();
	            }
	            else if(choice==2)
	            {
	                dname(f1);
	                f1.close();
	            }
	            else{
	            	System.out.println("SORRY !!! WRONG ENTRY");
	            }
	            break;
	        }
	        case 2:
	        {
	            f1.close();
	            ofstream f2("cabs.dat",ios::binary|ios::app);
	            m.input2();
	            f2.write((char*)&m,sizeof(journey));
	            f2.close();
	            break;
	        }
	        case 3:
	        {
	            int flag=0,mod,Cod;
	            char Mod;
	            System.out.println(" (FOR MODIFICATION ENTER DRIVER's CODE ONLY) ");
	            Cod=dcod(f1,flag);
	            if(flag)
	            {
	                do
	                {

	                	System.out.println();
	                	System.out.println("       WELCOME TO MODIFICATION MENU ");
	                	System.out.println("Press 1 to change Driver's Name");
	                	System.out.println("Press 2 to change Driver's Date of Birth ");
	                	System.out.println("Press 3 to change Driver's Address ");
	                	System.out.println("Press 4 to change Registration Number ");
	                	System.out.println("Press 5 to change Vehicle Description ");
	                	System.out.println("Press 6 to change Vehicle Type a=auto-rickshaw,g=go,l=luxury ");
	                	System.out.println("Press 7 to change No. of Kilometers ");
	                	System.out.println("(NOTE:- PLEASE ENTER NUMERICAL VALUE ONLY)");
	                	System.out.println("Enter your choice ");
	                    
	                	mod = scan.nextLine().charAt(0);//cin>>mod;
//	                    system("cls");
	                    switch(mod)
	                    {
	                    case 1:
	                    {
	                        String Name;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                                System.out.println("Enter New Name ");
	                                fflush(stdin);
	                                gets(Name);
	                                cout<<endl;
	                                s.mname(Name);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Name successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 2:
	                    {
	                        date Dob;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                                System.out.println("Enter New Date in order Day-Month-Year ");	 
	                                
	                                Dob.b = scan.nextInt();
	                                Dob.m = scan.nextInt();
	                                Dob.y = scan.nextInt();

	                                System.out.println("Enter New Date in order Day-Month-Year ");
	                                
	                                s.mdob(Dob);
	                                f1.close();
	                                modify(c);
	                                
	                                System.out.println("Date of Birth successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 3:
	                    {
	                        String Address;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                                System.out.println("Enter New Address ");
	                                fflush(stdin);
	                                gets(Address);
	                                System.out.println();
	                                s.maddress(Address);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Address successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 4:
	                    {
	                        String Regn;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                            	System.out.println("Enter New Vehicle Registration Number ");
	                                gets(Regn);
	                                s.mregn(Regn);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Vehicle Registration Number successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 5:
	                    {
	                        String Desc;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                                System.out.println("Enter New Vehicle Description ");
	                                fflush(stdin);
	                                gets(Desc);
	                                s.mdesc(Desc);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Vehicle Description successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 6:
	                    {
	                        char Vtype;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                            	System.out.println("Enter New Vehicle Type");
	                                Vtype = scan.nextLine().charAt(0);//cin>>Vtype;
	                                s.mvtype(Vtype);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Vehicle Type successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    case 7:
	                    {
	                        int Nok;
	                        f1.seekg(ios::beg);
	                        while(!f1.eof())
	                        {
	                            int c=f1.tellg();
	                            f1.read((char*)&s,sizeof(journey));
	                            if(Cod==s.cod())
	                            {
	                            	System.out.println("Enter New Number of Kilometers ");
	                                Nok = scan.nextInt();//cin>>Nok;
	                                s.mpay(Nok);
	                                f1.close();
	                                modify(c);
	                                System.out.println("Number of Kilometers successfully changed ");
	                                break;
	                            }
	                        }
	                        break;
	                    }
	                    default:
	                    {
	                    	System.out.println("SORRY !!! WRONG ENTRY");
	                        f1.close();
	                    }
	                    }

	                    System.out.println("\nTO CONTINUE MODIFYING PRESS 'y' OR 'Y' ELSE PRESS ANYTHING ELSE TO EXIT ");
	                    Mod = scan.nextLine().charAt(0);//cin>>Mod;
	                    system("cls");
	                }
	                while(Mod=='y' ||Mod=='Y');
	                break;
	            }
	        }
	        case 4:
	        {
	            int flag=0;
	            int Cod;
	            ofstream f2;
	            f2.open("temp.dat",ios::binary);
	            System.out.println(" (NOTE:- FOR DELETION PLEASE ENTER DRIVER's CODE ONLY) ");
	            Cod=icode();
	            while(f1.read((char*)&s,sizeof(journey)))
	            {
	                if(Cod!=s.cod())
	                {
	                    f2.write((char*)&s,sizeof(journey));
	                    flag=1;
	                }
	            }
	            if(flag){
	            	System.out.println("Record deleted successfully");
	            }
	            f1.close();
	            remove("cabs.dat");
	            rename("temp.dat","cabs.dat");
	            f2.close();
	            break;
	        }
	        case 5:
	        {
	            int Cod;
	            System.out.println(" (NOTE:- FOR PAYMENT PLEASE ENTER DRIVER's CODE ONLY) ");
	            Cod=icode();
	            while(!f1.eof())
	            {
	                int c=f1.tellg();
	                f1.read((char*)&s,sizeof(journey));
	                if(Cod==s.cod())
	                {
	                    s.pay();
	                    System.out.println("Driver's salary successfully paid ");
	                    f1.close();
	                    modify(c);
	                    break;
	                }
	            }
	            break;
	        }

	        case 6:
	        {
	            while(f1.read((char*)&s,sizeof(journey)))
	             {
	             s.display2();
	            }
	            f1.close();
	            break;
	        }
	        default:
	            System.out.println("SORRY !!! WRONG ENTRY");
	        }
	        System.out.println("\nTO CONTINUE IN MAIN MENU PRESS 'y' OR 'Y' ELSE PRESS ANYTHING ELSE TO EXIT");
	        c = scan.nextLine().charAt(0);//cin>>c;
	        system("cls");
	    }
	    while(c=='y' || c=='Y');

	    getch();
		
	}

}
