import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.Console;
import java.util.InputMismatchException;  

class Account 
{
	String fName;
	String lName;
	int age;
	int acctype;
	String dob;
	String gender;
	String address;
	String contactNo;
	String email;
	int accid;
	double balance;
	String passcode;

	public Account()
	{

	}

	public Account(String fName, String lName, int age, int acctype, String dob, String gender, String address, String contactNo, String email, int accid, double balance, String passcode)
	{
	this.fName=fName; 
	this.lName=lName; 
	this.age=age;
	this.dob=dob; 
	this.gender=gender;
	this.address=address;
	this.contactNo=contactNo; 
        this.acctype=acctype;
	this.email=email;
	this.accid=accid;
	this.balance=balance;
	this.passcode=passcode;
	}

	public String getFName(){
	  return fName;
	}	
	public void setFName(String fName){
	  this.fName=fName;
	}

	public String getLName(){
	  return lName;
	}	
	public void setLName(String lName){
	  this.lName=lName;
	}

	public int getAge(){
	  return age;
	}
	public void setAge(int age){
	  this.age=age;
	}

	public String getDob(){
	  return dob;
	}
	public void setDob(String dob){
	  this.dob=dob;
	}

	public int getAccType(){
	  return acctype;
	}	
	public void setAccType(int acctype){
	  this.acctype=acctype;
	}

	public String getGender(){
	  return gender;
	}
	public void setGender(String gender){
	  this.gender=gender;
	}

	public String getAddress(){
	  return address;
	}
	public void setAddress(String address){
	  this.address=address;
	}

	public String getContactNo(){
	  return contactNo;
	}
	public void setContactNo(String contactNo){
	  this.contactNo=contactNo;
	}

	public String getEmail(){
	  return email;
	}
	public void setEmail(String email){
	  this.email=email;
	}

	public int getAccid(){
	  return accid;
	}
	public void setAccid(int accid){
	  this.accid=accid;
	}

	public double getBalance(){
	  return balance;
	}
	public void setBalance(double balance){
	  this.balance=balance;
	}

	public String getPasscode(){
	  return passcode;
	}
	public void setPasscode(String passcode){
	  this.passcode=passcode;
	}
}

class Items
{
	int transactions = 0;
	String transactionHistory = ""; 
	SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date;

       
	public void depo(Scanner sc, Account acc, double amount)
	{	
		transactions=transactions+1;
		try {			
			acc.setBalance(acc.getBalance() + amount);
			System.out.println("\nRs. "+amount +" Diposited Successfully ! \nYour Balance is: "+ acc.getBalance());	
			date= new Date();
			String d=f.format(date);
			String str = d+ "\t"+amount + " Rs    Deposited    "+acc.getBalance()+ "\n_______________________________________________________________________\n";
			transactionHistory = transactionHistory.concat(str);			
		}
		catch ( Exception e) {
		}

	}

	public void with(Scanner sc, Account acc, double amount)
	{
		transactions=transactions+1;	 
		acc.setBalance(acc.getBalance() - amount);
		System.out.println("\nRs. "+amount +" Withdraw Successfully ! \nYour Balance is: "+acc.getBalance());
		date= new Date();
		String w=f.format(date);
		String str = w+ "\t"+amount + " Rs    Withdrawed   "+acc.getBalance()+ "\n_______________________________________________________________________\n";
		transactionHistory = transactionHistory.concat(str);
		
	}

	public void tran(Scanner sc, Account acc, ArrayList<Account> accounts)
	{	
		int n=0,temp=0, sid=0; 	
		double money=0.0d;
                System.out.print("Enter the receiver's accno : ");
                boolean again=true;
		while(again){
			try{
				sid= sc.nextInt();
				again=false;
			}
			catch ( InputMismatchException e) {
				System.out.print("\nEnter reciever's correct accno: ");
				sc.next();
			}
		}

               	System.out.print("\nEnter amount to transfer : ");
		boolean again8=true;
		while(again8)
		{
			try{
				money = sc.nextDouble();
				again8=false;
			}
 			catch ( InputMismatchException e) {
 				System.out.print("\nRetype amount to Transfer: ");
				sc.next();
			}
		}

	
                for (Account a: accounts)
		{
                        if(sid==a.getAccid())
                	{
				temp=10;
                	}
	
		}
		try{
		while(temp==0 || money >acc.getBalance())
                {
		   if(temp==0)
		   n=1;
 
		   if(money >acc.getBalance())
		   n=2;
                   switch(n)
		   {
			case 1: System.out.print("\nEnter reciever's correct accno: ");  
				String id=sc.next();
				sid= Integer.parseInt(id);
					
                		for (Account a: accounts)
				{
                        		if(sid==a.getAccid())
                			{
						temp=10;
                			}
				}
			        break;
 			case 2:	System.out.print("\nInsufficient Balance !!!");
				System.out.println("\n______________________________");
 				System.out.print("\nRetype amount to Transfer: ");
				String amt=sc.next();
				money= Double.parseDouble(amt);
				break;
		   }
		}
		}
		catch(Exception e){
		}
 		transactions=transactions+1; 
		        for (Account a: accounts)
			{
                        	if(sid==a.getAccid())
                		{
                       			a.setBalance(a.getBalance() + money);
					System.out.println("\n____________________________________________________________\n");
					System.out.println("Receiver's Balance is "+a.getBalance());
					System.out.println("\nRs. "+money+" Rs Transfer Successfully to "+a.getAccid());

				}
			}

				acc.setBalance(acc.getBalance() - money);
				System.out.println("\nYour Balance is "+acc.getBalance());
				SimpleDateFormat c=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date1;
				date1= new Date();
                		String t=c.format(date1);
				String str = t + "\t"+money + " Rs    Transfered   "+ acc.getBalance()+ "\n_______________________________________________________________________\n" ;                    

		transactionHistory = transactionHistory.concat(str);
	}

	public void history(Scanner sc, Account acc)
	{		  
		if ( transactions == 0 ) 
		{
			System.out.println("\nEmpty");
		}
		else 
		{	System.out.print("\n                  -----  Transaction History  -----\n");
	  		  System.out.print("\n=====================================================================\n\n");
			System.out.println("  Date      Time        Amount       Opeartion    Remaining Balance");
		        System.out.println("\n=====================================================================\n" + transactionHistory);
		}
	}

	public void update(Scanner sc, Account acc )
	{				
		Console console = System.console();
		int s=0;
		do{
        		System.out.println("========================================");
        		System.out.println("|         Update Account Details        |");
       	 		System.out.println("========================================");
        		System.out.println("| 1. Change Name                        |");
        		System.out.println("| 2. Change PIN                         |");
        		System.out.println("| 3. Change Account Settings            |");
        		System.out.println("| 4. Change Age & Date of Birth         |");
        		System.out.println("| 5. Change Gender                      |");
        		System.out.println("| 6. Change Address                     |");
        		System.out.println("| 7. Change Contact Details             |");
        		System.out.println("| 8. Exit                               |");
        		System.out.println("========================================");
			System.out.print("\n\nEnter Your Choice: ");
			boolean again6=true;
			while(again6){
			try{s=sc.nextInt();
				again6=false;
			}
			catch ( InputMismatchException e) {
				System.out.print("\nEnter Your Choice Correctly: ");
				sc.next();
			}
			}
			System.out.println("\n");
			switch(s)		
			{

			case 1:
				System.out.print("Change First Name    : ");
				String first = sc.next();		
				while(!first.matches("^[a-zA-z]+") || first == null || first.equals("") || first.isEmpty() || first.length()>50)
				{
					System.out.print("\nPlease retype Your First Name: ");
					first = sc.next();
				}
				acc.setFName(first);
				System.out.print("-----------------------------------------------\n");

				System.out.print("Change Last Name     : ");
				String last = sc.next();
				while(!last.matches("[A-Za-z,]+") || last == null || last.equals("") || last.isEmpty())
				{
					System.out.print("\nPlease retype Your Last Name: ");
					last = sc.next();
				}
				acc.setLName(last);
				System.out.print("-----------------------------------------------\n");
				System.out.println("\n\nAccountant Name has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 2:

				System.out.print("Change PIN (4 digit) : ");
				char [] pw = System.console().readPassword();
		
				String pc = String.valueOf(pw);
				
				while(pc.length() != 4 || pc == null || pc.equals(" ") || pc.isEmpty())
				{
 					System.out.print("\nPlease retype Your PIN: ");
					pw = System.console().readPassword();
					pc = String.valueOf(pw);		
				}
				
            			System.out.print("****");
				acc.setPasscode(pc);
				System.out.print("\n-----------------------------------------------\n");
				  
				System.out.print("\nRepeat PIN           : ");
				char [] pwd = System.console().readPassword();

				String rc = String.valueOf(pwd);
				while(rc.length() != 4 || rc == null || rc.equals(" "))
				{
 					System.out.print("\nPlease retype Your PIN: ");
					pw = System.console().readPassword();
					rc = String.valueOf(pw);
				}
            			System.out.print("****");

				System.out.print("\n-----------------------------------------------\n");
				while(!pc.equals(rc))
				{
					System.out.print("\nNot matching, Enter Password return: ");
					pwd = System.console().readPassword();
            				System.out.print("****");
					pc = new String(pwd);
				}

				System.out.println("\n\nYour PIN has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 3: int at=0;

				System.out.print("Change Account Type(Saving-1 or Current-2): ");
				boolean again5=true;
				while(again5){
				try{at = sc.nextInt();
 				while(at!=1 && at!=2)	
				{
					System.out.print("\nEnter valid Account Type: ");
					at = sc.nextInt();
				}
				again5=false;
				}
				catch ( InputMismatchException e) {
					System.out.print("\nEnter valid Account Type: ");
					sc.next();
				}
				}
				acc.setAccType(at);
				
				System.out.print("-----------------------------------------------\n");

				System.out.println("\n\nAccount Type has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 4: int ag=0;

				System.out.print("Change your Age  : ");
				boolean again4=true;
				while(again4){
				try{
				ag = sc.nextInt();
				while(ag < 18 || ag > 120)
				{
 					System.out.print("\nPlease retype Your Age: ");
					ag = sc.nextInt();
				}
				again4=false;
				}
				catch ( InputMismatchException e) {
 					System.out.print("\nPlease retype Your Age: ");
					sc.next();				
				
				}
				}
				acc.setAge(ag);
				System.out.print("-----------------------------------------------\n");

				System.out.print("Change Date of Birth (dd-mm-yyyy) : ");
				String birth = sc.next();
				while(!birth.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-(\\d{4})"))
				{
 					System.out.print("\nPlease retype Your Date(dd-mm-yy): ");
					birth = sc.next();
				}
				acc.setDob(birth);
				System.out.print("-----------------------------------------------\n");

				System.out.println("\n\nAccountant Age & D.O.B has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 5:
				System.out.print("Change Gender (Male-m / Female-f/ Other-o): ");
				String g = sc.next();
 				switch(g)
				{
					case "m":
					break;
		
					case "f":
                       			break;

					case "o":
                       			break;

                       	 		default:
     					System.out.print("\nEnter Your Gender: ");
					g = sc.next();                                
				}
				acc.setGender(g);
				System.out.print("-----------------------------------------------\n");

				System.out.println("\n\nAccountant Gender has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 6: 

				System.out.print("Change your Address  : ");
				String ad = console.readLine();
				while( ad == null || ad.equals("") || ad.isEmpty())
				{
					System.out.print("\nPlease retype Address: ");
					ad = console.readLine();
				}
				acc.setAddress(ad);
				System.out.print("-----------------------------------------------\n");

				System.out.println("\n\nAccountant Address has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			case 7:

				System.out.print("Change Contact Number: ");
				String phone = sc.next();
				
				while(!phone.matches("\\d{10}$") )
				{
 					System.out.print("\nPlease retype Your Contact Number: ");
					phone = sc.next();
				}
				
				acc.setContactNo(phone);
				System.out.print("-----------------------------------------------\n");

				System.out.print("Change your Email id : ");
				String id = sc.next();
				
				while(!id.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$") )
				{
 					System.out.print("\nPlease retype Your Email: ");
					id = sc.next();
				}
				
				acc.setEmail(id);
				System.out.print("-----------------------------------------------\n");

				System.out.println("\n\nAccountant Contact Details has been Updated Successfully !!");
				System.out.println("\n\n");
			break;

			default:
				if(s > 8)
      				{	 
			        	System.out.println("Enter between 1 to 8\n");
					System.out.print("-----------------------------------------------------------\n\n");
				}
				else
      				{	
					System.out.print("-----------------------------------------------------------\n");
                			System.out.println("\nYour Account Information has been Updated Successfully !!\n\n");
				}
			}
		}while(s != 8);
		

	}

}

class Menu{

	public Menu(Scanner sc, Account acc, int lastaccid, ArrayList<Account> accounts)
	{	
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception e)
		{

		}
		boolean isFinished = false;
		double amount=0.0d;
		int i,p=0,temp=0; 
		int j=0;
		Items m=new Items();
        		System.out.println(" ");
        		System.out.println(" ");		
        		System.out.println("                                 Welcome " +acc.getFName()+" " +acc.getLName()+" to Bank Information System");
        		System.out.println(" ");
       		 	System.out.println("                            <><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        		System.out.println("                                  Perform Operation By Choosing Suitable Option !");
       		 	System.out.println("                            <><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n");



			while (!isFinished) {
			System.out.println("                              -----------------------------------------------------           ");
                        System.out.println("                                    ___  ___   ______   __    __   __     __ ");
      			System.out.println("                                   |   \\/   | | _____| |  \\  |  | |  |   |  |");
			System.out.println("                                   |        | | |___   |   \\ |  | |  |   |  |");
			System.out.println("                                   | |\\  /| | |  ___|  |    \\|  | |  |   |  |");
			System.out.println("                                   | | \\/ | | | |____  |  |\\    | |  |___|  |");
			System.out.println("                                   |_|    |_| |______| |__| \\___|  \\_______/");
        		System.out.println(" ");
			System.out.println("                              -----------------------------------------------------           ");

			System.out.println("  "); 
			System.out.println("  ");                          
			System.out.println("                                \n\n\t\t\t\t\t\1. Deposit ...... '1' \n"); 
			System.out.println("                       \t ---------------------------------- \n");
			System.out.println("                                \n\t\t\t\t\t\3. Withdraw ...... '2' \n "); 
			System.out.println("                       \t ---------------------------------- \n");
			System.out.println("                                \n\t\t\t\t\t\5. Fund Transfer ...... '3' \n"); 
			System.out.println("                       \t ---------------------------------- \n");
			System.out.println("                                \n\t\t\t\t\t\4. Account Statements ...... '4' \n"); 
			System.out.println("                       \t ---------------------------------- \n"); 
			System.out.println("                                \n\t\t\t\t\t\6. Account Management ...... '5' \n "); 
			System.out.println("                       \t ---------------------------------- \n"); 
			System.out.println("                                \n\t\t\t\t\t\2. Quit ...... '0' \n "); 

			
			System.out.print("\n\nEnter Your Choice: ");
						boolean again0=true; 
			while(again0){
				try{j=sc.nextInt();
					again0=false;
				}
				catch ( InputMismatchException e) {
					System.out.print("\nEnter Your Choice Correctly: ");
					sc.next();
				}
			}
			System.out.println("\n");
			switch(j)		
			{

                                case 1: 
		                
				System.out.print("\nEnter amount to Deposit - ");
				boolean agai=true;
				while(agai){
				try{	
		                amount = sc.nextDouble();
			  	while(amount<1500.0)
				{
 					System.out.print("\nYou've Entered amount less than Rs.1500");
 					System.out.print("\n\nRetype amount to Deposit: ");
					amount = sc.nextDouble();
				}
				agai=false;
				}
				catch ( InputMismatchException e) {
					System.out.print("\nRetype amount to Deposit: ");
					sc.next();
				}
				}
                                m.depo(sc,acc,amount);

				break;
                                
				case 2: 
                                System.out.print("\nEnter amount to Withdraw - ");
				boolean again9=true;
				while(again9){
				try{
		                amount = sc.nextDouble();
				while(amount >acc.getBalance())
				{
 					System.out.print("\nYour balance is only "+acc.getBalance());
 					System.out.print("\n\nRetype amount to Withdraw: ");
					amount = sc.nextDouble();
				}
				again9=false;
				}
				catch ( InputMismatchException e) {
 					System.out.print("\nRetype amount to Withdraw: ");
					sc.next();
				}
				}

                                m.with(sc,acc,amount);
				break;

                                case 3:
                                m.tran(sc, acc, accounts);
				break;

				case 4:
				m.history(sc,acc);
				break;

				case 5: 
				do{
        				System.out.println("   ");   
        				System.out.println("                          ========  Account Management  ========\n");
        				System.out.println("                                  1. Track Balance             ");
        				System.out.println("                                  2. View Account              ");
        				System.out.println("                                  3. Update Account Details    ");
       					System.out.println("                                  4. Exit                      ");
        				System.out.println("\n                          ======================================="); 
        				System.out.print("\n                                  Enter Your Choice := "); 
					boolean again=true;
					while(again){
						try{p=sc.nextInt();
						again=false;
						}
						catch ( InputMismatchException e) {
					System.out.print("\n                  		      Enter Your Choice Correctly: ");
							sc.next();
						}
					}
        				System.out.println("\n                          =======================================");		
 		
					System.out.println("\n");
					switch(p)		
					{
						case 1: 
				        		System.out.println("\n________________________________________");
        						System.out.println("                                        ");
        						System.out.println("   Your balance is : "+acc.getBalance()+"             ");
       	 				   		System.out.println("________________________________________\n\n");
						break;

                                		case 2: 
						String type="",gen="";
						System.out.println("Account id         : "+acc.getAccid());
						System.out.println("Balance            : "+acc.getBalance());
						System.out.println("Name of Accountant : "+acc.getFName()+"  "+acc.getLName());
						switch(acc.getAccType())
						{ 
							case 1:type="Saving Account"; 
							break;
							case 2:type="Current Account";
							break; 
						}	
						System.out.println("Account Type       : "+type);
						System.out.println("Date of Birth      : "+acc.getDob());
						System.out.println("Age                : "+acc.getAge());
						switch(acc.getGender())
						{ 
							case "m":gen="Male"; 
						 	break;
							case "f":gen="Female"; 
						 	break; 
							case "o":gen="Other"; 
						 	break;
						}
						System.out.println("Gender             : "+gen);
						System.out.println("Address            : "+acc.getAddress());
						System.out.println("Contact Number     : "+acc.getContactNo());
						System.out.println("Email id           : "+acc.getEmail());
        					System.out.println("   "); 
        					System.out.println("   "); 
						break;
				
						case 3: 
			        		m.update(sc,acc);
						break;

						default:
						if(p==4)
						{}
						else
      						{System.out.println("   ");  
			        		System.out.println("                                                   Enter correct value ..!\n\n");}
					}
				}while(p !=4);
				break;

				case 0:new Main(sc,lastaccid,accounts);
				break;

				default:
      				System.out.println("\n***************************************   ");  
			        System.out.println("\nEnter between to 0 to 5");
      	
			}
			System.out.println("\n\nxxxxxxxxx:::::: PROCESS COMPLETED: PRESS ENTER TO CONTINUE:::::::xxxxxxxxx\n\n");
			try{
			sc.nextLine();
			if(sc.nextLine()=="\n")
                        {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();}
			}
			catch(Exception e){}

		}
	}
}

class Update{


}
class Log{
		
	public Log(Scanner sc,  int lastaccid, ArrayList<Account> accounts)
	{

	System.out.print("\n  ----- User Login -----\n\n");
	  System.out.print("***************************\n");

	int id=0;
        Console console = System.console();
	System.out.print("\nEnter account id: ");
	boolean again=true;
	while(again){
	try{
		id= sc.nextInt();
		again=false;
		}
		catch ( InputMismatchException e) {
			System.out.print("\nEnter Your correct accno: ");
			sc.next();
		}
	}
	System.out.print("\nEnter a password: ");
	char [] pw = System.console().readPassword();
    
        System.out.println();
	String passcode = String.valueOf(pw);

	Account account= new Account();
	boolean exist= false;
		for (Account acc: accounts)
		{
			if(acc.getAccid() == id && acc.getPasscode().equals(passcode))
			{	
				exist=true;
				account = acc;
			}
		}
		if(exist)
		{
			new Menu(sc, account, lastaccid, accounts );
		}
		else
		{
	  		System.out.print("\n***************************\n");
			System.out.println("   Account doesn't exist\n");
			new Main(sc,lastaccid,accounts);									
		}
              
	}
}


class Main{

	public Main(Scanner sc, int Lastaccid, ArrayList<Account> accounts)
	{	
		
		int p=0;


		do
		{

        	System.out.println("   ");   
        	System.out.println("                                                ********************************");
        	System.out.println("                                                *             MENU             *");
        	System.out.println("                                                ********************************");
        	System.out.println("                                                * 1. Create another Account  *");
        	System.out.println("                                                * 2. Login                     *");
        	System.out.println("                                                * 3. Exit                      *");
        	System.out.println("                                                ********************************");

        	System.out.println("   ");  
        	System.out.println("   ");  

        	System.out.println("                                           ::::::::::::::::::::::::::::::::::::::::::"); 
        	System.out.print("\n                                                   Enter Your Choice :: "); 
		boolean again=true;
		while(again){
			try{p=sc.nextInt();
			again=false;
			}
			catch ( InputMismatchException e) {
				System.out.print("\n                                                   Enter Your Choice Correctly: ");
				sc.next();
			}
		}
                                System.out.println("\n                                           ::::::::::::::::::::::::::::::::::::::::::"); 			
 		
			System.out.println("\n");
			switch(p)		
			{
				case 1: new Reg(sc ,Lastaccid,  accounts);
				break;

                                case 2: new Log(sc,Lastaccid, accounts);
				break;
				
				case 3: 
			        System.out.println("                        ----------------------------! THANK YOU FOR VISITING US !----------------------------            ");
        			System.out.println("           ------------------------------ being our customer you are a family member of ours------------------------------- ");
        			System.out.println("                      ----------------------------  !!  Hope to See You Again  !!----------------------------");

				System.exit(0);
				break;

				default:
      				System.out.println("   ");  
			        System.out.println("                                                   Enter correct Option ..!");
			}
		}while(p !=3);
	}
}

class Reg{

	public Reg(Scanner sc, int lastaccid, ArrayList<Account> accounts)
	{


		int acctype=0,age=0;
		double balance=0.0d;

        	Console console = System.console();
		System.out.print("\n---- User Registration ----\n\n");
		System.out.print("***************************\n");
		System.out.print("Enter Your First Name: ");
		String fName = sc.next();		
		while(!fName.matches("^[a-zA-z]+") || fName == null || fName.equals("") || fName.isEmpty() || fName.length()>50)
		{
			System.out.print("\nPlease retype Your First Name: ");
			fName = sc.next();
		}
		System.out.print("-----------------------------------------------\n");
		System.out.print("Enter Your Last Name : ");
		String lName = sc.next();		
		while(!lName.matches("[A-Za-z,]+") || lName == null || lName.equals("") || lName.isEmpty())
		{
			System.out.print("\nPlease retype Your Last Name: ");
			lName = sc.next();
		}
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Account Type(Saving-1 or Current-2): ");
		boolean again1=true;
		while(again1){
			try{
				acctype = sc.nextInt();
				while(acctype!=1 && acctype!=2)	
				{
					System.out.print("\nEnter valid Account Type: ");
					acctype = sc.nextInt();
				}
				again1=false;
			}
			catch ( InputMismatchException e) {
				System.out.print("\nEnter valid Account Type: ");
				sc.next();
 			}
		
		}
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter your Age : ");
		boolean again2=true;
		while(again2){
			try{
				age = sc.nextInt();
				while(age < 18 || age > 120)
				{
 					System.out.print("\nPlease retype Your Age: ");
					age = sc.nextInt();
				}
				again2=false;
			}
			catch ( InputMismatchException e) {
 				System.out.print("\nPlease retype Your Age: ");
				sc.next();
			}
		}
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Date of Birth (dd-mm-yyyy) : ");
		String dob = sc.next();
		while(!dob.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-(\\d{4})"))
		{
 			System.out.print("\nPlease retype Your Date(dd-mm-yy): ");
			dob = sc.next();
		}
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Gender(Male-m / Female-f/ Other-o) : ");
		String gender = sc.next();
 		switch(gender)
		{
			case "m":
				break;
		
			case "f":
                       		break;

			case "o":
                       		break;
                        default:
     				System.out.print("\nEnter Your Gender: ");
				gender = sc.next();                                
		}
		System.out.print("-----------------------------------------------\n");


		System.out.print("Enter Address  : ");
		String address = console.readLine();
		while( address == null || address.equals("") || address.isEmpty())
		{
			System.out.print("\nPlease retype Your Address: ");
			address = console.readLine();
		}
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Contact Number : ");
		String contactNo = sc.next();

			while(!contactNo.matches("\\d{10}$") )
			{
 				System.out.print("\nPlease retype Your Contact Number: ");
				contactNo = sc.next();
			}		
		
		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Email id : ");
		String email = sc.next();

			while(!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$") )
			{
				
 				System.out.print("\nPlease retype Your Email: ");
				email = sc.next();
			}
	

		System.out.print("-----------------------------------------------\n");

		System.out.print("Enter Initial Balance : ");
		boolean again3=true;
		while(again3){
			try{balance= sc.nextDouble();
				while(balance<1500.0)
				{
 					System.out.print("\nBlanace should be more than Rs.1500");
 					System.out.print("\n\nPlease retype Your Balance: ");
					balance= sc.nextDouble();
				}
				again3=false;
			}
			catch ( InputMismatchException e) {
 				System.out.print("\nPlease retype Your Balance: ");
				sc.next();
 			}
		}
		System.out.print("-----------------------------------------------\n");
		System.out.print("Enter a PIN (4 digit) : ");
		char [] pw = System.console().readPassword();

		String passcode =String.valueOf(pw);
			while(passcode.length() != 4 || passcode == null || passcode.equals(" ") || passcode.isEmpty() )
			{
 				System.out.print("\nPlease retype Your PIN: ");
				pw = System.console().readPassword();
				passcode = new String(pw);
			}
	
		
            	System.out.print("****");
		System.out.print("\n-----------------------------------------------\n");
		System.out.print("Confirm PIN: ");
		char [] pwd = System.console().readPassword();

		String passcodec =String.valueOf(pwd);
		while(passcodec.length() != 4 || passcodec == null || passcodec.equals(" ") || passcodec.isEmpty())
		{
 			System.out.print("\nPlease retype Your PIN: ");
			pwd = System.console().readPassword();
			passcodec = new String(pwd);
		}

            	System.out.print("****");
		System.out.print("\n-----------------------------------------------\n");
		while(!passcode.equals(passcodec))
		{
			System.out.print("\nNot matching, Enter Password return: ");
			pwd = System.console().readPassword();
			passcodec = new String(pwd);
		}
		int id=1000100+lastaccid;
		lastaccid=lastaccid+1;
		Account acc=new Account(fName,lName, age, acctype, dob, gender, address, contactNo, email, id, balance, passcode);
		accounts.add(acc);
		
		System.out.println("\n\n                                               You are successfully register..! ");
	          System.out.println("                                           :::::::::::::::::::::::::::::::::::::::::");
                System.out.println("\n                                                 YOUR ACCOUNT ID IS :: "+ id);
		System.out.println("\n                                           :::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\n");
		new Main(sc,lastaccid,accounts);

		
	}
}




public class BankingInformationSystem
{
	static Scanner sc;
	static int Lastaccid=0;
	public static ArrayList<Account> accounts;
	
	public static void main (String args[])
	{
		sc= new Scanner(System.in);
		accounts = new ArrayList<>();
		int i=0;

        	System.out.println("                                                   ___________________________");
        	System.out.println("                                                  /  _______________________  \\");
        	System.out.println("                                                 /  /                       \\  \\");
        	System.out.println("                                                /  / BANK INFORMATION SYSTEM \\  \\");
        	System.out.println("                                               /  /___________________________\\  \\");
        	System.out.println("                                           ==========================================");
        	System.out.println("                                               ||             ( $ )             ||");
        	System.out.println("                                           ==========================================");
        	System.out.println("                                              |__|  __  |__|         |__|  __  |__|");
        	System.out.println("                                               ||  |  |  ||    ___    ||  |  |  ||");
       	 	System.out.println("                                               ||  |  |  ||   |   |   ||  |  |  ||");
        	System.out.println("                                              _||_ |__| _||_  |   |  _||_ |__| _||_");
        	System.out.println("                                            _|____|____|____|_|___|_|____|____|____|_");
        	System.out.println("                                          _|_________________________________________|_ ");      
        	System.out.println("                                         |_____________________________________________| ");  

        
		do{
			System.out.println("   ");  
        		System.out.println("   ");  

        		System.out.println("                                                     *************************");
        		System.out.println("                                                     *       MAIN MENU       *");
        		System.out.println("                                                     *************************");
        		System.out.println("                                                     * 1. Create Account     *");
        		System.out.println("                                                     * 2. Exit               *");
        		System.out.println("                                                     *************************");

        		System.out.println("   ");  
        		System.out.println("   ");  

        		System.out.println(	"                                           ::::::::::::::::::::::::::::::::::::::::::"); 
        		System.out.print("                                                     Enter Your Choice :: "); 
			boolean again=true;
			while(again){
			try{i=sc.nextInt();
			again=false;
			}
			catch ( Exception e) {
				System.out.print("\n                                                     Enter Your Choice Correctly: ");
			sc.next();
			}
			}
        		                System.out.println("                                           ::::::::::::::::::::::::::::::::::::::::::"); 

			switch(i)
			{
				case 1:new Reg(sc ,Lastaccid,  accounts);
				break;
		
				case 2:
      					System.out.println("\n                       ----------------------------THANK YOU FOR VISITING US !----------------------------            ");
        				System.out.println("             --------------------------- being our customer you are a family member of ours---------------------------- ");
       					  System.out.print("                       ----------------------------!!  Hope to See You Again  !!----------------------------");
                		break;

                		default:
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception e)
		{

		}
     					System.out.println("   ");  
					System.out.println("                                                     Enter either 1 or 2");                             
			}
		}while(i !=2);

	}

}