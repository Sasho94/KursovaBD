import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class ServerKursova {

	static ServerSocket serv;
	final static int portClient = 1116;

	private static Connection connect(String url, String user, String password) {
		Connection result = null;
		try {
			result = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Could not connect to MySQL");
		}
		return result;
	}

	public static void main(String[] args) {
		// localhost е IP на сървъра, 3306 е порта, mydb е базата
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "philip";
		String pass = "topsecretpass";

		Connection link = ServerKursova.connect(url, user, pass);

		if (link == null) {
			System.out.println("MySQl has not been started!");
			return;
		} else {
			System.out.println("Connection to the MySQL server has been established!");
		}

		try {
			serv = new ServerSocket(portClient);
		} catch (IOException e1) {
			System.out.println("Could not establish connection");
		}
		while (true) {
			try {
				Socket newConnection = serv.accept();
				User u = new User(newConnection, link);
				u.start();
			} catch (IOException e) {
				System.err.println("ERR: Can't connect to user: "+ e.getMessage());
			}
		}

	}
}

class User extends Thread {
	Connection link;
	String username;
	Socket sock;
	BufferedReader bf = null;

	public User(Socket sock, Connection link) throws IOException {
		this.sock = sock;
		this.link = link;

	}

	public void run() {

		menu();

	}

	public void menu() {
       
		int choice;
		Scanner sc=null;
		PrintWriter pw = null;
	    try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sc = new Scanner(sock.getInputStream());
			} catch (IOException e2) {
			e2.printStackTrace();
		}
		//countPrintPast(link);
				
		while (true) {
			
			if (sc.hasNextInt()) {
				try {
					choice = sc.nextInt();
					System.out.println(choice);
				} catch (Exception e) {
					System.out.println("error");
					e.printStackTrace();
					//sc.nextLine();
					continue;
				}

				switch (choice) {
				case 1:
					countPrintPast(link);
					printPast(link);
					break;
				case 2:
					countPrintPresent(link);
					printPresent(link);
					break;
				case 3: sc.nextLine();
				 String command=sc.nextLine();
				 String commandNum=sc.nextLine();
				 
				 if(getNumOfRooms(commandNum,link)>0){
				 getRooms(command,link);
				 }
				break;
				case 4: getNumOfClients(link);
				sc.nextLine();
				InsertClient(sc,link);
				}
			}
			
		
		}

	}
	
	public void InsertClient(Scanner sc,Connection link){
		
		Statement stmt = null;
		ResultSet resultSet = null;
		Date date,date1;
		 
		
		
		 String name=sc.nextLine();
		 System.out.println(name);
		 
		 String SecondName=sc.nextLine();
		 System.out.println(SecondName);
		 
	     String FamilyName=sc.nextLine();
	     System.out.println(FamilyName);
	     
	     int guest_ID= sc.nextInt();
		 System.out.println(guest_ID);
	     
	     int idRoom =sc.nextInt();
	     System.out.println(idRoom);
		 
		 int startDay=sc.nextInt();
		 System.out.println(startDay);
		 
		 int startMonth=sc.nextInt();
		 System.out.println(startMonth);
		 
		 int StartYear=sc.nextInt();
		 System.out.println(StartYear);
		 
		 int endDay=sc.nextInt();
		 System.out.println(endDay);
		 
		 int endMonth=sc.nextInt();
		 System.out.println(endMonth);
		 
		 int endYear=sc.nextInt();
		 System.out.println(endYear);
		 
		 int phone=sc.nextInt();
	     System.out.println(phone);
	     
		 		 
		 
	     
	    
	    
	    SimpleDateFormat startFormat = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
	    try{
	    	java.sql.Date startDate = new java.sql.Date((StartYear-1900),startMonth,startDay);
	    	java.sql.Date endDate = new java.sql.Date((endYear-1900+1),endMonth-1,endDay);
			
						
			 String query ="insert into  `hotel`.`CurrentGuest`(`firstname` ,`middlename`,`lastname`,`phone` )" + " values (?, ?, ?, ?)";
				 
				      // create the mysql insert preparedstatement
				      java.sql.PreparedStatement preparedStmt = link.prepareStatement(query);
				      preparedStmt.setString (1, name);
				      preparedStmt.setString (2, SecondName);
				      preparedStmt.setString (3, FamilyName);
				      preparedStmt.setLong   (4, phone);
				      
				      				 
				      // execute the preparedstatement
				      preparedStmt.execute();
				       
				     String query1 ="insert into `hotel`.`Booking` (`B_guestID`,`B_roomID`,`StartDate`,`EndDate`)"+ "values(?,?,?,?)";
						 
				      // create the mysql insert preparedstatement
				      java.sql.PreparedStatement preparedStmt1 = link.prepareStatement(query1);
				     preparedStmt1.setLong (1, guest_ID);
				     preparedStmt1.setLong (2, idRoom);
				     preparedStmt1.setDate   (3, startDate);
				     preparedStmt1.setDate   (4, endDate);
				      				 
				      // execute the preparedstatement
				     preparedStmt1.execute();   
				
				      
				      
	    }catch(Exception e){
	    	System.out.println("Problem inserting in DataBase");
	    }
		}       
	   
	    	
		
		
	public void getNumOfClients(Connection link){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
				
		try {
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery("Select count(*) from CurrentGuest;");
			resultSet.next();
			pw.println(resultSet.getInt("count(*)"));
			pw.flush();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				
			} catch (SQLException e) {
				
			}
		}
	}
	
	public int getNumOfRooms(String commandNum,Connection link){
		PrintWriter pw = null;
		int count=0;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
				
		try {
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery(commandNum);
			resultSet.next();
			count=resultSet.getInt("count(*)");
			pw.println(count);
			pw.flush();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				
			} catch (SQLException e) {
				
			}
		}
		return count;
	}
		
		
		
	
	public void getRooms(String command,Connection link) {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
		
		Calendar cal = null;
		Boolean isEmpty = true;

		try {
						
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery(command);

			
			while (resultSet.next()) {

				pw.print(resultSet.getString("roomID") + " ");
				pw.println();
				pw.flush();
				isEmpty = false;
			}
			if (isEmpty) {
				pw.println("List is empty");
				pw.flush();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				// pw.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
		
		
	
	
	
	
	
	public void countPrintPast(Connection link){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
				
		try {
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery("SELECT count(*) FROM CurrentGuest JOIN Booking where EndDate<CURDATE() and B_guestID=guestID;");
			resultSet.next();
			pw.println(resultSet.getInt("count(*)"));
			pw.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				// pw.close();
			} catch (SQLException e) {
				
			}
		}
	}
	public void countPrintPresent(Connection link){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
				
		try {
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery("SELECT count(*) FROM CurrentGuest JOIN Booking where EndDate>CURDATE() and B_guestID=guestID;");
			resultSet.next();
			pw.println(resultSet.getInt("count(*)"));
			pw.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				// pw.close();
			} catch (SQLException e) {
				
			}
		}
	}

	public void printPast(Connection link) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
		
		Calendar cal = null;
		Boolean isEmpty = true;

		try {
						
			stmt = link.createStatement();
			resultSet = stmt
					.executeQuery("CALL show_pastGuests();");

			// Обхождаме резултатната таблица ред по ред и отпечатваме на екрана
			while (resultSet.next()) {

				pw.print(resultSet.getString("firstname") + " ");
				pw.print(resultSet.getString("middlename") + " ");
				pw.print(resultSet.getString("lastname") + " ");
				pw.print("Тел."+resultSet.getString("phone") + " ");
				pw.print("Дата_ "+ resultSet.getDate("EndDate", cal) + " ");
				pw.print("Стая_"+resultSet.getInt("B_roomID") + " ");
				pw.println();
				pw.flush();
				isEmpty = false;
			}
			if (isEmpty) {
				pw.println("List is empty");
				pw.flush();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				// pw.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void printPresent(Connection link) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sock.getOutputStream(), true);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stmt = null;
		ResultSet resultSet = null;
		Calendar cal = null;
		Boolean isEmpty1 = true;

		try {

			stmt = link.createStatement();

			resultSet = stmt
					.executeQuery("CALL show_currentGuests();");

			// Обхождаме резултатната таблица ред по ред и отпечатваме на екрана

			while (resultSet.next()) {
				isEmpty1 = false;

				pw.print(resultSet.getString("firstname") + " ");
				pw.print(resultSet.getString("middlename") + " ");
				pw.print(resultSet.getString("lastname") + " ");
				pw.print("Тел."+resultSet.getString("phone") + " ");
				pw.print("Дата_ "+ resultSet.getDate("EndDate", cal) + " ");
				pw.print("Стая_"+resultSet.getInt("B_roomID") + " ");
				pw.println();
				pw.flush();

			}
			if (isEmpty1 == true) {
				pw.println("List is empty");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (resultSet != null)
					resultSet.close();
				// pw.close();
			} catch (SQLException e) {

			}
		}
	}

}
