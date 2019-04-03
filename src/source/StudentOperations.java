package source;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class StudentOperations {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	/*List all students*/
	public List<Student> listAllStudents() {
		List<Student> studentList = null;
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Student");
			studentList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return studentList;
	}
	
	/*method to add new student*/
	public String addStudent(String name, long contact) {
		String result="";
		Student student = new Student();
		//student.setId(id);
		student.setName(name);
		student.setContact(contact);
		Session session = factory.openSession();
		Transaction tc = session.beginTransaction();
		try {
			session.save(student);
			tc.commit();
			result = "..student successfully added..";
		} catch(Exception e) {
			e.printStackTrace();;
		}
		finally {
			session.close();
		}
		return result;
	}
	
	/*method to delete a student*/
	public String deleteStudent(int id) {
		String result = "";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Student student = session.get(Student.class, id);
			session.delete(student);
			transaction.commit();
			result = "..student successfully deleted..";
		} catch(Exception e) {
			result = e.getMessage();
		}
		finally {
			session.close();
		}
		return result;
	}
	
	/*method to update student details*/
	public String updateStudent(int id, String name, long contact) {
		String result = "";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Student student = session.get(Student.class, id);
			if (student != null) {
				student.setName(name);
				student.setContact(contact);
				session.update(student);
				transaction.commit();
				result = "..student successfully updated..";
			}
		} catch(Exception e) {
			result = e.getMessage();
		}
		finally {
			session.close();
		}
		return result;
	}
	
	//method to add data in marks table
	public String addMarks(int studentId, int subjectCode, String subjectName, float marksObtained) {
		String result="";
		Student student;
		Marks marks;
		Session session=null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			student = session.load(Student.class, studentId);
			marks = new Marks();
			marks.setStudent(student);
			marks.setSubjectCode(subjectCode);
			marks.setSubjectName(subjectName);
			marks.setMarksObtained(marksObtained);
			session.save(marks);
			session.getTransaction().commit();
		} catch(Exception e) {
			result = e.getLocalizedMessage();
		}
		finally {
			session.close();
		}
		result = "..marks successfully added..";
		return result;
	}
	
	public void close() {
		factory.close();
	}
}
