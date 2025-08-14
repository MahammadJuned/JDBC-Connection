import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagement {
	
	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			String url = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "connect";
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection is established...");
			while(true) {
				
				System.out.println("PRESS 1 TO VIEW ALL STUDENT DETAILS");
				System.out.println("PRESS 2 TO ADD NEW STUDENT DETAILS");
				System.out.println("PRESS 3 TO UPDATE STUDENT DETAILS");
				System.out.println("PRESS 4 TO DELETE STUDENT DETAILS");
				System.out.println("PRESS 0 TO EXIT THE SYSTEM.....");
				System.out.print("Enter your option: ");
				int option = sc.nextInt();
				sc.nextLine();
				switch(option) {
				case 1 : readRecords();
						 System.out.println("------------------------------------");
						 break;
				case 2: insertRecord();
						System.out.println("------------------------------------");
						break;
				case 3: updateDetails();
						System.out.println("------------------------------------");
						break;
				case 4: deleteStudent();
						System.out.println("------------------------------------");
						break;
				case 0: System.out.println("EXITING THE SYSTEM");
						System.exit(0);
				default: System.out.println("Invalid option, please enter a valid option");
						System.out.println("------------------------------------");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			con.close();
		}
		

	}
	
	public static void insertRecord() throws SQLException {
		String insertQuery = "insert into student values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertQuery);
		System.out.println("Enter Id of the student: ");
		int id = sc.nextInt();
		stmt.setInt(1, id);
		sc.nextLine();
		System.out.println("Enter name of the student: ");
		String name = sc.nextLine();
		stmt.setString(2, name);
		System.out.println("Enter the age of the student: ");
		int age = sc.nextInt();
		stmt.setInt(3, age);
		System.out.println("Enter the marks of the student: ");
		int marks = sc.nextInt();
		stmt.setInt(4, marks);
		
		int i = stmt.executeUpdate();
		if(i > 0)
			System.out.println("Student Details are inserted successfully...");
		else
			System.out.println("Student details are not inserted...");
	}
	
	public static void readRecords() throws SQLException {
		String ReadData = "SELECT * from student";
		PreparedStatement pstmt = con.prepareStatement(ReadData);
		ResultSet rs = pstmt.executeQuery();
		boolean found = false;
		
		while(rs.next()) {
			found = true;
			System.out.println(rs.getInt(1) +" " + rs.getString(2)+" " + rs.getInt(3)+" "+rs.getInt(4));
		}
		if(!found) {
			System.out.println("No Student records exists...");
			return;
		}
	}
	
	public static void updateDetails() throws SQLException {
		String checkId = "select * from student where id = ?";
		PreparedStatement check = con.prepareStatement(checkId);
		System.out.println("Enter the id of the Student to update: ");
		int stdId = sc.nextInt();
		check.setInt(1, stdId);
		ResultSet result = check.executeQuery();
		if(result.next()) {
			sc.nextLine();
			System.out.println("Enter new Name: ");
			String newName = sc.nextLine();
			
			System.out.println("Enter new Age: ");
			int newAge = sc.nextInt();
			
			System.out.println("Enter new marks: ");
			int newMarks = sc.nextInt();	
	
		
		
		String updateData = "update student set name = ?, age = ?, marks = ? where id = ?";
		PreparedStatement updateStmt= con.prepareStatement(updateData);
		
		updateStmt.setString(1,newName);
		updateStmt.setInt(2,newAge);
		updateStmt.setInt(3,newMarks);
		updateStmt.setInt(4,stdId);
		
		int affected = updateStmt.executeUpdate();
		if(affected > 0) 
			System.out.println("Student Details are updated successfully...");
		else 
			System.out.println("No rows are affected...");
		} else {
			System.out.println("No Such student exists...");
		}
	}
	
	public static void deleteStudent() throws SQLException {
		String deleteData = "Delete from student where id = ?";
		PreparedStatement deletestmt = con.prepareStatement(deleteData);
		System.out.println("Enter the id of the student to delete: ");
		int stdIdtoDelete = sc.nextInt();
		deletestmt.setInt(1, stdIdtoDelete);
		int rowsAffected = deletestmt.executeUpdate();
		if(rowsAffected > 0) {
			System.out.println("Student with id " + stdIdtoDelete + " is deleted successfully...");
		} else {
			System.out.println("No student with such id exists...");
		}
	}

}
