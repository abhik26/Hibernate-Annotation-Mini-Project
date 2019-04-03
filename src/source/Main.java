package source;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StudentOperations operations = new StudentOperations();
		boolean looping = true;
		do {
			System.out.print("1.	list all students\n"
					+ "2.	add a student\n"
					+ "3.	delete a student\n"
					+ "4.	update a student\n"
					+ "5.	add marks\n"
					+ "6.	exit\n");
			
			String result="";
			int choice = 0;
			System.out.print("enter choice: ");
			choice = scanner.nextInt();
			switch(choice) {
			
			case 1: {
				List<Student> studentList = operations.listAllStudents();
				for (Student student : studentList) {
					System.out.println(student.toString());
				}
				break;
			}
			case 2: {
				System.out.print("enter student name: ");
				String name = scanner.next();
				System.out.print("enter student contact: ");
				long contact = scanner.nextLong();
				result = operations.addStudent(name, contact);
				System.out.println(result);
				break;
			}
			case 3: {
				System.out.print("enter student id: ");
				int id = scanner.nextInt();
				result = operations.deleteStudent(id);
				System.out.println(result);
				break;
			}
			case 4: {
				System.out.print("enter student id: ");
				int id = scanner.nextInt();
				System.out.print("enter student name: ");
				String name = scanner.next();
				System.out.print("enter student contact: ");
				long contact = scanner.nextLong();
				result = operations.updateStudent(id, name, contact);
				System.out.println(result);
				break;
			}
			case 5: {
				try {
					System.out.print("enter student id: ");
					int studentId = scanner.nextInt();
					System.out.print("enter subject code: ");
					int subjectCode = scanner.nextInt();
					System.out.print("enter subject name: ");
					String subjectName = br.readLine();
					System.out.print("enter marks obtained: ");
					float marksObtained = scanner.nextFloat();
					result = operations.addMarks(studentId, subjectCode, subjectName, marksObtained);
					System.out.println(result);
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
				
			}
			case 6: {
				looping = false;
				break;
			}
			default: {
				System.out.println("invalid entry!!");
			}
			}
		} while(looping);
		scanner.close();
		operations.close();
	}

}
