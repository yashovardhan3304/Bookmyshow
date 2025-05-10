import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

class colours
{	
    // ANSI escape codes for different colors
    public static final String RESET = "\033[0m";  // Reset the color
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String MAGENTA = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
	
    public static final String BOLD = "\033[1m";
    public static final String UNDERLINE = "\033[4m";
    public static final String REVERSED = "\033[7m";

    // Combination: Red foreground, green background
    public static final String rg="\033[31;42m" ;
}
class Account
{
	static String name="mani";
	static String pswd="1234";
	void account()
	{
			System.out.println("1.Login \n2.Signup \n3.Exit ");
		try{
			int z=Main.sc.nextInt();
			switch(z)
			{
				case 1 : login();
					 break;
				case 2:  signup();
					 break;
				case 3:  Main.mp.exit();
					 break;
				default :System.out.println("Entered Wrong details Enter Correct ");
					 account();
					 break;
			}
		}
		catch(Exception e)
		{
				System.out.println("          NO such option Exist Try Again :\n");
				Main.sc.next();
				 account();
		}
	}
	void login()
	{
		System.out.println("\tLogin To Continue--->");	
		System.out.println("Enter UserName :");
		System.out.print("								");String name=Main.sc.next();
		System.out.println("Enter Password :");
		System.out.print("								");String pswd=Main.sc.next();	
		if(this.name.equals(name) && this.pswd.equals(pswd))
		{
			
			System.out.println("							Login Successfull...");
		}
		else if(this.name.equals(name) && !(this.pswd.equals(pswd)))
		{
			System.out.println("Entered Wrong Password \n1.Show Password \n2.Change Password \n3.Try Again");
		    try{
			int z=Main.sc.nextInt();
			if(z==1)
			{
				System.out.println(getp());	
				System.out.println("Redirecting To Login Page");
				login();
			}
			else if(z==2)
			{
				System.out.println("Enter New Password");
				setp(Main.sc.next());
				System.out.println("Password Changed Successfully...  \n      Redirecting To Login Page");
				login();
			}
			else if(z==3)
			{
				login();
			}
			else
			{
				System.out.println("Invalid Input Try Again... Redirecting To Login Page");
				login();
			}
		    }
		    catch(Exception e)
		    {
			System.out.println("          NO such option Exist Try Again Redirecting To Login Page :\n");
			Main.sc.next();
			login();

		    }
		}
		else
		{
			System.out.println("Details Not Found \n1.Try Again \n2.Signup \n3.Exit");
		   try{
			int n=Main.sc.nextInt();
			if(n==1)
			{
				login();	
			}    
			else if(n==2)
			signup();
			else if(n==3)
			Main.mp.exit();
			else 
			{
				System.out.println("Invalid Input Try Again... Redirecting To Login Page");
				login();
			}
		  }
		  catch(Exception e)
	 	  {
			System.out.println("          NO such option Exist Try Again Redirecting To Login Page :\n");
			Main.sc.next();
			login();
		  }
		}
	}
	void setu(String u)
	{
		this.name=u;
	}
	void setp(String p)
	{
		this.pswd=p;
		
	}
	String  getp()
	{
		return pswd;
	}
	String getu()
	{	
		return name;
	}
	void signup()
	{
		System.out.println("Enter Username :");
		System.out.print("								");String newu=Main.sc.next();
		System.out.println();
		System.out.println("Enter Password :");
		System.out.print("								");String newp=Main.sc.next();
		System.out.println();
		setp(newp);
		setu(newu);
		System.out.println("Signup Completed \n   Login ");
		login();		
	}
}
abstract class Bank
{
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();
    public abstract boolean verifyPin(String inputPin);
}
class SBI extends Bank 
{
    
       	static double balance = 5000.00;
       	static String pin = "1234";
    
    	static Scanner sc=Main.sc;
    
    	public void deposit(double amount) 
	{
        	balance += amount;
        	System.out.println("Deposited: " + amount + ". New balance: " + balance);
    	}

    	public void withdraw(double amount) 
	{
        	if (amount <= balance) 
		{
            		balance -= amount;
            		System.out.println("Debited: " + amount );
        	} 
		else 
		{
            		System.out.println("Insufficient balance!");
        	}
    	}

    	public double getBalance() 
	{
        	return balance;
    	}

    	public boolean verifyPin(String inputPin) 
	{
        	return pin.equals(inputPin);
    	}

    	public void updatePin(String newPin) 
	{
        	pin = newPin;
        	System.out.println("PIN updated successfully!");
    	}
    	void paybill(double bill )
    	{
		System.out.print("1.deposit \n 2.check balance \n 3.pay bill \n4.Exit \n5.Mainpage");
	    try{
		int n=sc.nextInt();
		if(n==1)
		{	
			System.out.print("Enter amount for deposit :");
			double amount =sc.nextDouble();
			deposit(amount);
			paybill(bill);
		}
		else if(n==2)
		{
			System.out.print(getBalance());
			paybill(bill);
		}
		else if(n==3)
		{
			payment(bill);
		}
		else if(n==4)
		{
			Main.mp.exit();
		}
		else if(n==5)
		{
			Main.mp.mainPage();
		}
		else
		{
			System.out.println("Invalid Input Try Again");
			paybill(bill);
		}
	    }
	    catch(Exception e)
	    {
		System.out.println("          NO such option Exist Try Again :\n");
			Main.sc.next();
			paybill(bill);
	    }
    	}
    	void payment(double bill)
    	{
        	System.out.println("Your total bill is :"+ bill);
	
		System.out.println("Enter pin :");
    		String ppin=sc.next();
    		if(ppin.equals(pin))
		{
			if(bill<=getBalance())
			{
			
				withdraw(bill);
				System.out.print("payment successfull \nyour remaining balance is" +getBalance());
			}
			else
			{
				System.out.println("Insufficient balance!");
				paybill(bill);		
			}
		}
		else
		{
			System.out.println("Wrong pin \n 1.Try again \n 2.Update pin \n3.Exit \n4.Mainpage");
			try{
			int n=sc.nextInt();
			if(n==1)
			{
				payment(bill);
			}
			else if(n==2)
			{
				System.out.print("enter new pin");
				String pinn=sc.next();
				updatePin(pinn);
				payment(bill);
			}
			else if(n==3)
			{
				Main.mp.exit();
			}
			else if(n==4)
			{
				Main.mp.mainPage();
			}
			else
			{
				System.out.println("Invalid Input Try Again");
				payment(bill);
			}
			}
			catch(Exception e)
			{
				System.out.println("          NO such option Exist Try Again :\n");
				Main.sc.next();
				payment(bill);
			}
		}
    	}			
}
class HDFC extends Bank 
{
    
       	static double balance = 1000.00;
       	static String pin = "2345";
    
    	static Scanner sc=Main.sc;
    
    	public void deposit(double amount) 
	{
        	balance += amount;
        	System.out.println("Deposited: " + amount + ". New balance: " + balance);
    	}

    	public void withdraw(double amount) 
	{
        	if (amount <= balance) 
		{
            		balance -= amount;
            		System.out.println("Debited: " + amount );
        	} 
		else 
		{
            		System.out.println("Insufficient balance!");
        	}
    	}

    	public double getBalance() 
	{
        	return balance;
    	}

    	public boolean verifyPin(String inputPin) 
	{
        	return pin.equals(inputPin);
    	}

    	public void updatePin(String newPin) 
	{
        	pin = newPin;
        	System.out.println("PIN updated successfully!");
    	}
    	void paybill(double bill )
    	{
		System.out.print("1.deposit \n 2.check balance \n 3.pay bill \n4.Exit \n5.Mainpage");
		try{
		int n=sc.nextInt();
		if(n==1)
		{	
			System.out.print("Enter amount for deposit :");
			double amount =sc.nextDouble();
			deposit(amount);
			paybill(bill);
		}
		else if(n==2)
		{
			System.out.print(getBalance());
			paybill(bill);
		}
		else if(n==3)
		{
			payment(bill);
		}
		else if(n==4)
		{
			Main.mp.exit();
		}
		else if(n==5)
		{
			Main.mp.mainPage();
		}
		else
		{
			System.out.println("Invalid Input Try Again");
			paybill(bill);
		}
		}
		catch(Exception e)
	    	{
		System.out.println("          NO such option Exist Try Again :\n");
			Main.sc.next();
			paybill(bill);
	    	}
    	}
    	void payment(double bill)
    	{
        	System.out.println("Your total bill is :"+ bill);
	
		System.out.println("Enter pin :");
    		String ppin=sc.next();
    		if(ppin.equals(pin))
		{
			if(bill<=getBalance())
			{
			
				withdraw(bill);
				System.out.print("payment successfull \nyour remaining balance is" +getBalance());
			}
			else
			{
				System.out.println("Insufficient balance!");
				paybill(bill);		
			}
		}
		else
		{
			System.out.println("Wrong pin \n 1.Try again \n 2.Update pin \n3.Exit \n4.Mainpage");
			try{
			int n=sc.nextInt();
			if(n==1)
			{
				payment(bill);
			}
			else if(n==2)
			{
				System.out.print("enter new pin");
				String pinn=sc.next();
				updatePin(pinn);
				payment(bill);
			}
			else if(n==3)
			{
				Main.mp.exit();
			}
			else if(n==4)
			{
				Main.mp.mainPage();
			}
			else
			{
				System.out.println("Invalid Input Try Again");
				payment(bill);
			}
			}
			catch(Exception e)
			{
				System.out.println("          NO such option Exist Try Again :\n");
				Main.sc.next();
				payment(bill);
			}

		}
    	}			
}
class AXIS extends Bank 
{
    
       	static double balance = 1500.00;
       	static String pin = "3456";
    
    	static Scanner sc=Main.sc;
    
    	public void deposit(double amount) 
	{
        	balance += amount;
        	System.out.println("Deposited: " + amount + ". New balance: " + balance);
    	}

    	public void withdraw(double amount) 
	{
        	if (amount <= balance) 
		{
            		balance -= amount;
            		System.out.println("Debited: " + amount );
        	} 
		else 
		{
            		System.out.println("Insufficient balance!");
        	}
    	}

    	public double getBalance() 
	{
        	return balance;
    	}

    	public boolean verifyPin(String inputPin) 
	{
        	return pin.equals(inputPin);
    	}

    	public void updatePin(String newPin) 
	{
        	pin = newPin;
        	System.out.println("PIN updated successfully!");
    	}
    	void paybill(double bill )
    	{
		System.out.print("1.deposit \n 2.check balance \n 3.pay bill \n4.Exit \n5.Mainpage");
		try{
		int n=sc.nextInt();
		if(n==1)
		{	
			System.out.print("Enter amount for deposit :");
			double amount =sc.nextDouble();
			deposit(amount);
			paybill(bill);
		}
		else if(n==2)
		{
			System.out.print(getBalance());
			paybill(bill);
		}
		else if(n==3)
		{
			payment(bill);
		}
		else if(n==4)
		{
			Main.mp.exit();
		}
		else if(n==5)
		{
			Main.mp.mainPage();
		}
		else
		{
			System.out.println("Invalid Input Try Again");
			paybill(bill);
		}
		}
		catch(Exception e)
	    	{
		System.out.println("          NO such option Exist Try Again :\n");
			Main.sc.next();
			paybill(bill);
	    	}
		
    	}
    	void payment(double bill)
    	{
        	System.out.println("Your total bill is :"+ bill);
	
		System.out.println("Enter pin :");
    		String ppin=sc.next();
    		if(ppin.equals(pin))
		{
			if(bill<=getBalance())
			{
			
				withdraw(bill);
				System.out.print("payment successfull \nyour remaining balance is" +getBalance());
			}
			else
			{
				System.out.println("Insufficient balance!");
				paybill(bill);		
			}
		}
		else
		{
			System.out.println("Wrong pin \n 1.Try again \n 2.Update pin \n3.Exit \n4.Mainpage");
			try{
			int n=sc.nextInt();
			if(n==1)
			{
				payment(bill);
			}
			else if(n==2)
			{
				System.out.print("enter new pin");
				String pinn=sc.next();
				updatePin(pinn);
				payment(bill);
			}
			else if(n==3)
			{
				Main.mp.exit();
			}
			else if(n==4)
			{
				Main.mp.mainPage();
			}
			else
			{
				System.out.println("Invalid Input Try Again");
				payment(bill);
			}
			}
			catch(Exception e)
			{
				System.out.println("          NO such option Exist Try Again :\n");
				Main.sc.next();
				payment(bill);
			}
		}
    	}			
}
class RecentBookingOne 
{
	public String location;
	public String language;
    	public String movie;
    	public String theatre;
    	public String date;
    	public String time;
    	public String seats;
	public double bill;

    	public RecentBookingOne(String location,String language,String movie, String theatre, String date, String time, String seats,double bill) 
	{
		this.location=location;
		this.language=language;
        	this.movie = movie;
        	this.theatre = theatre;
        	this.date = date;
        	this.time = time;
        	this.seats = seats;
		this.bill=bill;
    	}
    	public String getFormattedTicket() 
	{
        	return String.format(
            	"\nBooking Summary:\n-----------------***************************------------------\n" +
		"		|   Location    : %s\n" +
		"		|   Language    : %s\n" +
            	"		|   Movie       : %s\n" +
            	"		|   Theatre     : %s\n" +
            	"		|   Date        : %s\n" +
            	"		|   Show Time   : %s\n" +
            	"		|   Seat Nos    : %s\n" +
		"		|   totalbill   : %2f\n" +
            	"------------------***************************------------------",location,language,movie, theatre, date, time, seats, bill);
    	}
    	public String toString() 
	{
        	return getFormattedTicket();
    	}
}
class RecentBookingTwo 
{
    	public static ArrayList<RecentBookingOne> recentBookings = new ArrayList<>();
	
	public static void addFive()
	{
		RecentBookingTwo.addBooking(new RecentBookingOne("Hyderabad","Telugu","Movie A", "Theatre 1", "12/10/2024", "6:00 PM", "A1, A2",550));
        	RecentBookingTwo.addBooking(new RecentBookingOne("Hyderabad","Telugu","Movie B", "Theatre 2", "13/10/2024", "3:00 PM", "B1, B2",540));
        	RecentBookingTwo.addBooking(new RecentBookingOne("Hyderabad","Telugu","Movie C", "Theatre 3", "14/10/2024", "9:00 PM", "C1, C2",550));
        	RecentBookingTwo.addBooking(new RecentBookingOne("Hyderabad","Telugu","Movie D", "Theatre 4", "15/10/2024", "5:00 PM", "D1, D2",330));
        	RecentBookingTwo.addBooking(new RecentBookingOne("Hyderabad","Telugu","Movie E", "Theatre 5", "16/10/2024", "7:00 PM", "E1, E2",330));
	}
    	static void addBooking(RecentBookingOne booking) 
	{	
        	recentBookings.add(0, booking);  // Add the new booking at the first index
        	if (recentBookings.size() > 5) 
		{
            		recentBookings.remove(recentBookings.size() - 1);  // Remove the last booking
        	}
    	}

    	static void displayRecentBookings() 
	{
        	if (recentBookings.isEmpty()) 
		{
            		System.out.println("No recent bookings found.");
        	} 
		else 
		{
            		System.out.println("Recent Bookings:");
            		int count = 1;
            		for (RecentBookingOne booking : recentBookings) 
			{
                		System.out.println(count + ". " + booking); // Calls toString() automatically
                		count++;
            		}
        	}
    	}
}
interface Theatre 
{
	 String theatre();
}
class Hyderabad implements Theatre
{
	static String selectedtheatre;
	static Scanner sc=MovieBooking.sc;
	public  String theatre()
	{
		int theatrechoice=0;
		String theatre[]={"MIRAJ CINEMAS","SANDYA 70MM","PRASADS MULTIPLEX","AMB CINEMAS"};
		
		System.out.println("Select a Theatre");
		System.out.println();
		System.out.println();
		
		for(int i=0;i<theatre.length;i++)
		{
			System.out.println((i+1) + ". "+ theatre[i]);
		}
		System.out.println();
		System.out.println();
		
		try{
		theatrechoice=sc.nextInt() -1;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Try Again..");
			sc.next();
			theatre();
		}
		System.out.println();
		
		if(theatrechoice < 0 || theatrechoice >= theatre.length	)
		{
			System.out.println("Invalid choice. Try Again.");
			return theatre();
		}
		else
		{
			selectedtheatre = theatre[theatrechoice];
        		System.out.println("Your Selected Theatre Is : " + selectedtheatre);
			System.out.println();
			System.out.println();

			return selectedtheatre;
		}
		
	}
}
class Chennai implements Theatre
{
	static String selectedtheatre;
	static Scanner sc=MovieBooking.sc;
	public  String theatre()
	{
		int theatrechoice=0;
		String theatre[]={"INOX-CHENNAI","MAYAJAAL_MULTIPLEX","SATYAM_CINEMAS","ABIRAMI MULTIPLEX"};
		System.out.println("Select a Theatre");
		System.out.println();
		System.out.println();

		for(int i=0;i<theatre.length;i++)
		{
			System.out.println((i+1) + ". "+ theatre[i]);
		}
		System.out.println();
		System.out.println();
		
		try{
		theatrechoice=sc.nextInt() -1;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Try Again..");
			sc.next();
			theatre();
		}

		System.out.println();
		
		if(theatrechoice < 0 || theatrechoice >= theatre.length	)
		{
			System.out.println("Invalid choice. Try Again.");
			return theatre();
		}
		else
		{
			selectedtheatre = theatre[theatrechoice];
        		System.out.println("Your Selected Theatre Is : " + selectedtheatre);
			System.out.println();
			System.out.println();
	
			return selectedtheatre;
		}
		
	}
}
class Bangalore implements Theatre
{
	static String selectedtheatre;
	static Scanner sc=MovieBooking.sc;
	public  String theatre()
	{
		int theatrechoice=0;
		String theatre[]={"KINO _CINEMAS","URVASI_THEATRE","GOPALAN CINEMAS","MUKUNDA_THEATRE"};
		System.out.println("Select a Theatre");
		System.out.println();
		System.out.println();

		for(int i=0;i<theatre.length;i++)
		{
			System.out.println((i+1) + ". "+ theatre[i]);
		}
		System.out.println();
		System.out.println();

		try{
		theatrechoice=sc.nextInt() -1;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Try Again..");
			sc.next();
			theatre();
		}

		System.out.println();
	
		if(theatrechoice < 0 || theatrechoice >= theatre.length	)
		{
			System.out.println("Invalid choice. Try Again.");
			return theatre();
		}
		else
		{
			selectedtheatre = theatre[theatrechoice];
        		System.out.println("Your Selected Theatre Is : " + selectedtheatre);
			System.out.println();
			System.out.println();
		
			return selectedtheatre;
		}
		
	}
}
class Mumbai implements Theatre
{
	static String selectedtheatre;
	static Scanner sc=MovieBooking.sc;
	public  String theatre()
	{
		int theatrechoice=0;
		String theatre[]={"CARNIVAL CINEMAS","METRO_INOX","MOVIEMAX","CINEPOLIS"};
		System.out.println("Select a Theatre");
		System.out.println();
		System.out.println();

		for(int i=0;i<theatre.length;i++)
		{
			System.out.println((i+1) + ". "+ theatre[i]);
		}
		System.out.println();
		System.out.println();

		try{
		theatrechoice=sc.nextInt() -1;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Try Again..");
			sc.next();
			theatre();
		}

		System.out.println();
		
		if(theatrechoice < 0 || theatrechoice >= theatre.length	)
		{
			System.out.println("Invalid choice. Try Again.");
			return theatre();
		}
		else
		{
			selectedtheatre = theatre[theatrechoice];
        		System.out.println("Your Selected Theatre Is: " + selectedtheatre);
			System.out.println();
			System.out.println();

			return selectedtheatre;
		}
		
	}
}
class Seating
{
    	public static final String[] rowNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    	public final int totalRows = 10;
    	public final int totalColumns = 9;
    	boolean[][]  seats = new boolean[totalRows][totalColumns];
    
    	public boolean isSeatAvailable(int row, int column) 
	{
        	return row >= 0 && row < totalRows && column >= 0 && column < totalColumns && !seats[row][column];
    	}

    	public void bookSeat(int row, int column) 
	{
        	if (isSeatAvailable(row, column)) 
		{
            		seats[row][column] = true; 
       		}
    	}

    	public void displaySeats() 
	{
        	System.out.print("    				");
        	for (int j = 1; j <= totalColumns; j++) 
		{
			if(j==1)
            		System.out.print("  "+j + "     ");
			else
			System.out.print(j + "     ");
        	}
        	System.out.println();

        	for (int i = 0; i < totalRows; i++) 
		{
			if(i==0)
			System.out.println("						------BALCONY 250RS------");
			if(i==3)
			System.out.println("						------GOLD 150RS------");
			if(i==7)
			System.out.println("						------SILVER 100RS------");

           		System.out.print("			"+rowNames[i] + "  ---> "); 
			
            		for (int j = 0; j < totalColumns; j++) 
			{
                		System.out.print(seats[i][j] ? colours.GREEN+" [x]  "+colours.RESET : " [ ]  ");
            		}
            		System.out.println();
        	}
    	}
	
}

class MovieBooking 
{
	
	static Scanner sc = new Scanner(System.in);
	static final String et="EXIT";
	static final String gb="Go-Back";
	static String selectedLocation;
	static String selectedLanguage;
	static String selectedMovie;
	static String selectedDate;
	static String selectedShowTime;
	static String selectedtheatre;
	static ArrayList<String> selectedSeats;
	static double amount = 0;
	static double totalbill = 0;
	public static String location()
	{
		int locationChoice=0;
		String[] locations = {"Hyderabad", "Chennai", "Bangalore", "Mumbai","EXIT"};
       		 System.out.println("Select a location:");
		 	System.out.println();
			System.out.println();

        	for (int i = 0; i < locations.length; i++) 
		{
            		System.out.println((i + 1) + ". " + locations[i]);
        	}

		System.out.println();
		System.out.println();

        	locationChoice = sc.nextInt() - 1;
		System.out.println();

        	if (locationChoice < 0 || locationChoice >= locations.length) 
		{
            		System.out.println("Invalid choice. Try Again.");
            		 location();
       		}
		else if(locations[locationChoice].equals(et))
		{
			 Main.mp.mainPage();
			 Main.mp.options();
		}
		else
		{
       	 		selectedLocation = locations[locationChoice];
        		System.out.println("Your selected Location Is : " + selectedLocation);
			System.out.println();
			System.out.println();
	
		}
		return selectedLocation;
	}
	public static String lang()
	{
		int languageChoice=0;
		String[] languages = {"Telugu", "Hindi", "Tamil", "Kannada","Go-Back","EXIT"};
        	System.out.println("Select a language to watch the movie:");
		System.out.println();
		System.out.println();

        	for (int i = 0; i < languages.length; i++) 
		{
            		System.out.println((i + 1) + ". " + languages[i]);
        	}
		
		System.out.println();
		System.out.println();

        	languageChoice = sc.nextInt() - 1;
		System.out.println();

        	if (languageChoice < 0 || languageChoice >= languages.length) 
		{
            		System.out.println("Invalid choice. Try Again.");
			lang();
        	}
		else if(languages[languageChoice].equals(et))
		{
			Main.mp.mainPage();
			Main.mp.options();
		}
		else if(languages[languageChoice].equals(gb))
		{
			bookTickets();
			Main.mp.options();
		}
		else
		{
        		selectedLanguage = languages[languageChoice];
        		System.out.println("Your  selected Language Is : " + selectedLanguage);
			System.out.println();
			System.out.println();
	
		}
		return selectedLanguage;
	}
	public static String movie()
	{
		int movieChoice=0;
		String[] movies = {"Devara", "Kalki", "Maharaja", "Kill","Go-Back","EXIT"};
        	System.out.println("Select a movie to watch:");
		System.out.println();
		System.out.println();

        	for (int i = 0; i < movies.length; i++) 
		{
            		System.out.println((i + 1) + ". " + movies[i]);
        	}

		System.out.println();
		System.out.println();

        	movieChoice = sc.nextInt() - 1;
		System.out.println();
	
        	if (movieChoice < 0 || movieChoice >= movies.length) 
		{
            		System.out.println("Invalid choice. Try Again.");
            		movie();
        	}
		else if(movies[movieChoice].equals(et))
		{
			Main.mp.mainPage();
			Main.mp.options();
		}
		else if(movies[movieChoice].equals(gb))
		{
			bookTickets();
			Main.mp.options();
		}
		else
		{
        		selectedMovie = movies[movieChoice];
        		System.out.println("Your selected Movie Is : " + selectedMovie);
			System.out.println();
			System.out.println();
		}
		return selectedMovie;
	}
	public static String date()
	{
		int dateChoice=0;
		System.out.println("Select a date to watch the movie (next 5 days):");
		System.out.println();
		System.out.println();

        	List<String> dates = new ArrayList<>();
        	SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy"); // Format for month name

        	Calendar calendar = Calendar.getInstance();
        	for (int i = 0; i < 5; i++) 
		{
            		dates.add(dateFormat.format(calendar.getTime())); // Format current date
            		System.out.println((i + 1) + ". " + dates.get(i));
            		calendar.add(Calendar.DATE, 1); // Increment day
        	}
		
		dates.add("Go-Back");
		dates.add("EXIT");
		System.out.println("6. "+ dates.get(5));
		System.out.println("7. "+ dates.get(6));
		
		System.out.println();
		System.out.println();

        	dateChoice = sc.nextInt() - 1;
		
		System.out.println();
		
        	if (dateChoice < 0 || dateChoice >= dates.size()) 
		{
            		System.out.println("Invalid choice. Try Again.");
            		date();
        	}
		else if(dates.get(dateChoice).equals(et))
		{
			Main.mp.mainPage();
			Main.mp.options();
		}
		else if(dates.get(dateChoice).equals(gb))
		{
			bookTickets();
			Main.mp.options();
		}
		else
		{
       	 		selectedDate = dates.get(dateChoice);
        		System.out.println("Your selected Date Is : " + selectedDate);
			System.out.println();
			System.out.println();
		}

		return selectedDate;
	}
	public static String show()
	{
		int showTimeChoice=0;
		String[] showTimes = {"11:00 AM", "2:30 PM", "6:00 PM", "9:00 PM","Go-Back","EXIT"};
        	System.out.println("Select a show time:");
		System.out.println();
		System.out.println();

        	for (int i = 0; i < showTimes.length; i++) 
		{
            		System.out.println((i + 1) + ". " + showTimes[i]);
        	}
		System.out.println();
		System.out.println();

        	showTimeChoice = sc.nextInt() - 1;
		System.out.println();
		

        	if (showTimeChoice < 0 || showTimeChoice >= showTimes.length) 
		{
            		System.out.println("Invalid choice. Try Again.");
            		show();
        	}
		else if(showTimes[showTimeChoice].equals(et))
		{
			Main.mp.mainPage();
			Main.mp.options();
		}
		else if(showTimes[showTimeChoice].equals(gb))
		{
			bookTickets();
			Main.mp.options();
		}
		
		else
		{
        		selectedShowTime = showTimes[showTimeChoice];
        		System.out.println("Your selected Show Time Is : " + selectedShowTime);
			System.out.println();
			System.out.println();
		}

		return selectedShowTime;
	}



	/* static public boolean check()
	{
		ArrayList<RecentBookingOne> check = RecentBookingTwo.recentBookings;
		int count=0;
		for(int i=0;i<check.size();i++)
		{
			RecentBookingOne ticket = check.get(i);
			if(selectedLanguage.equals(ticket.language)&&selectedMovie.equals(ticket.movie)&&selectedLocation.equals(ticket.location)&&selectedDate.equals(ticket.date)&&selectedShowTime.equals(ticket.time)&&selectedtheatre.equals(ticket.theatre))
		{
			String s[] = ticket.seats.split(", ");boolean cut = true;
			for(int j=0;j<selectedSeats.size();j++)
			{
				for(int k=0;k<s.length;k++)
				{
					if(selectedSeats.get(j).equals(s[k]))
					{
						cut = false;
						break;
					}
				}
				if(!cut)
				break;	
			}
			if(!cut)
			return false;	
	
		}
		else
		{
			count++;
		}
		}
		if(count==check.size())
		return true;
		return false;
	}
	*/
	
	
	
	public static ArrayList<String> seatingArrangement()
	{
		amount=0;
		Seating seating = new Seating();
		
		System.out.println("Select Seats :");
		
		System.out.println();
		seating.displaySeats();
		ArrayList<String> selectedSeats = new ArrayList<>();
		int numSeats;
		while(true)
		{
			boolean che=false;
			System.out.print("How many seats would you like to book? ");
			try{
        		 numSeats = Main.sc.nextInt();
				if(numSeats >0 && numSeats <=10)
				{
					break;
				}
				else{
					if(numSeats<=0)
					System.out.println("			MIN You Can Book atleast 1 Ticket");  
					else
					System.out.println("			MAX You Can Book Only 10 Tickets At a Time");
					che=true;
				}
			
			}
			catch(Exception e)
			{
				Main.sc.next();
				System.out.println("Invalid Input ...");
				che=true;
			}
		}

		System.out.println("Select seat like (e.g., A1, B2): ");
		System.out.println();
		System.out.println();

		for (int i = 0; i < numSeats; i++) 
		{
            		String seatInput = Main.sc.next();
			if("ABC".contains(String.valueOf(seatInput.charAt(0))))
			{
				amount+=250;
			}
			else if("DEFG".contains(String.valueOf(seatInput.charAt(0))))
			{
				amount+=150;
			}
			else if("HIJ".contains(String.valueOf(seatInput.charAt(0))))
			{
				amount+=100;
			}
            		int row = seatInput.charAt(0) - 'A'; // Convert row character to index
            		int column = Character.getNumericValue(seatInput.charAt(1)) - 1; // Convert column character to index
           		if (seating.isSeatAvailable(row, column)) 
			{
				
                		selectedSeats.add(seatInput.toUpperCase());
				
            		} 
			else 
			{
                		System.out.println("Seat " + seatInput.toUpperCase() + " is not available. Please choose another seat.");
               		 	i--;
            		}
		}
        	System.out.println("You have selected the following seats: " + selectedSeats);
        	System.out.println();
		System.out.println();

        	System.out.println("Do you want to proceed with booking these seats? (Yes/Cancel): ");
		System.out.println(colours.GREEN+"				-----"+colours.RESET+colours.RED+"	--------"+colours.RESET);
		System.out.println(colours.GREEN+	"				|YES|"+colours.RESET+colours.RED+"	|CANCEL|"+colours.RESET);
		System.out.println(colours.GREEN+"				-----"+colours.RESET+colours.RED+"	--------"+colours.RESET);
		System.out.println();
		System.out.println();

        	String confirm = Main.sc.next();
		System.out.println();
		
        	if (confirm.equalsIgnoreCase("yes")) 
		{
			totalbill = payBooking(numSeats,amount);
            		for (String seat : selectedSeats) 
			{
                		int row = seat.charAt(0) - 'A';
                		int column = Character.getNumericValue(seat.charAt(1)) - 1;
                		seating.bookSeat(row, column);
            		}
            		System.out.println("Your Seats:");
			System.out.println();

            		seating.displaySeats();
        	} 
		else 
		{
            		System.out.println("Booking has been canceled.");
			System.out.println();

			Main.mp.options();
        	}
		return selectedSeats;
	}
	
	public static double payBooking(int seats, double amount) 
	{
		System.out.println("		-----------*************-------------");
		System.out.println("			YOUR BILL IS 	: " +	amount);
		double tax = amount * (5.0 / 100);
		System.out.println("			GST 5%	 	: "	+	tax);
    		
    		totalbill = amount + tax; 
		System.out.println("			TOTAL BILL IS	: "+totalbill);
		System.out.println("		-----------*************-------------");
		System.out.println();
		System.out.println();
		
		System.out.println("PAYMENT OPTIONS		\n1.Gpay	\n2.PhonePay");
		int p=sc.nextInt();
		if(p==1||p==2)
		{
		System.out.println("Select Bank   \n1.SBI  \n2.HDFC  \n3.AXIS");
		int n=Main.sc.nextInt();
		switch(n)
		{
			case 1 : SBI sb=new SBI();
				 sb.payment(totalbill);
				 break;
			case 2 : HDFC hb=new HDFC();
				 hb.payment(totalbill);
				 break;
			case 3 : AXIS ax=new AXIS();
				 ax.payment(totalbill);
				 break;
			default:System.out.println("Entered Wrong Input");
				payBooking(seats,amount);
				break;	
		}
		}
		else	
		{
			System.out.println("Entered Wrong Input		\n1.Try Again		\n2.MainPage");
			int pp=Main.sc.nextInt();
			if(pp==1)
			payBooking(seats,amount);
			else
			Main.mp.mainPage();
		}
    		return totalbill;
	}

	public static void printTickets()
	{
		 // Final Booking Summary
        	System.out.println("\nBooking Summary:");
		System.out.println("-----------------***************************------------------");
        	System.out.println("               |   Location      : " + selectedLocation);
        	System.out.println("               |   Language      : " + selectedLanguage);
        	System.out.println("               |   Movie         : " + selectedMovie);
		System.out.println("               |   Theatre       : " + selectedtheatre);
        	System.out.println("               |   Date          : " + selectedDate);
        	System.out.println("               |   Show Time     : " + selectedShowTime);
		System.out.println("               |   Seat Nos      : " + selectedSeats);
		System.out.println("               |   total bill    : " + totalbill);
		System.out.println("------------------***************************------------------");

	}
	
    	public static void bookTickets() 
	{
     		selectedLocation = location();

		selectedLanguage = lang();

		selectedMovie= movie();
				
		if(selectedLocation.equals("Hyderabad"))
		{
			Hyderabad hyd=new Hyderabad();
			selectedtheatre = hyd.theatre();
		}
		else if(selectedLocation.equals("Chennai"))
		{
			Chennai ch=new Chennai();
			selectedtheatre =ch.theatre();
		}
		else if(selectedLocation.equals("Bangalore"))
		{
			Bangalore bg=new Bangalore();
			selectedtheatre =bg.theatre();
		}
		else if(selectedLocation.equals("Mumbai"))
		{
			Mumbai mb=new Mumbai();
			selectedtheatre =mb.theatre();
		}

		selectedDate = date();
		selectedShowTime = show();
		
		selectedSeats = seatingArrangement();
		String seatString = String.join(", ", selectedSeats);
		
		RecentBookingTwo.addBooking(new RecentBookingOne(selectedLocation,selectedLanguage,selectedMovie,selectedtheatre,selectedDate,selectedShowTime,seatString,totalbill));
		MainPage.c++;
		printTickets();
		Main.mp.options();
      }
}
class MainPage
{
	static int c=1;
	static void options()
	{
		System.out.println(colours.GREEN +"                          ---------Select Any Option-------------- "+colours.RESET);
		System.out.println("		1.Exit   \n		2.MainPage");
		int e=Main.sc.nextInt();
		if(e==1)
		Main.mp.exit();
		else
		Main.mp.mainPage(); 
	}
	static void exit()
	{
		System.out.println(colours.BLUE +"                      	 -------------ThankYou Have a Good Day-------------- "+colours.RESET);
					 System.exit(0);
	}
	void mainPage()
	{ 


		System.out.println("\t\t\t\t\t\t\t  "+"\033[31;1m  -------MAINPAGE-------- "+colours.RESET);
		System.out.println("		1.Book Movie Tickets  \n		2.Recent Bookings   \n		3.Exit");
		int s=Main.sc.nextInt();
		if(s==1)
		{
			MovieBooking.bookTickets();
		}
		else if(s==2)
		{
			if(c==1)
			RecentBookingTwo.addFive();
			c++;
			RecentBookingTwo.displayRecentBookings();
			options();
		}
		else if(s==3)
		{
			exit();
		}
		else
		{
			System.out.println("Entered Wrong Input Try Again....");
			mainPage();
		}
	}
}
class Main extends MainPage
{
	static java.util.Scanner sc=new java.util.Scanner(System.in);
	static Account ac=new Account();
	static MainPage mp=new MainPage();
	static
	{
		
		System.out.println(colours.YELLOW+"\t\t\t\t\t\t\t	WELCOME TO BOOK MY SHOW"+colours.RESET);
		System.out.println();
        	String[] loadingSymbols = {"|", "/", "-", "\\"};  

        	try{
        	for (int i = 0; i < 20; i++) 
		{
            		
            		System.out.print(colours.CYAN+"\r	\t\t\t\t\t\t\t	Loading " + loadingSymbols[i % 4]  +  colours.RESET);  
            		Thread.sleep(250);  
        	}
		}
		catch (InterruptedException e) 
		{
            		e.printStackTrace();
        	}

		
        	clearConsole();
        	System.out.println(); 
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t\t\t\t\t\t  "+"\033[31;1m     WELCOME TO BOOK YOUR SHOW "+colours.RESET);
		System.out.println("\t\t\t\t\t\t\t\t    \033[31;47m It's SHOWTIME "+colours.RESET);
	}
	static void main()
	{
		
		ac.account();	
		mp.mainPage();
		
	}
	public static void main(String []args)
	{	RecentBookingTwo.addFive();
		main();
		System.out.println("what to do");
	}
	public static void clearConsole() 
    	{
        	try 
		{
            		if (System.getProperty("os.name").contains("Windows")) 
			{
                		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            		} 
			else 
			{
                		System.out.print("\033[H\033[2J");
                		System.out.flush();
            		}
        	} 
		catch (Exception e) 
		{
            		System.out.println("Error clearing console");
        	}
    	}
}