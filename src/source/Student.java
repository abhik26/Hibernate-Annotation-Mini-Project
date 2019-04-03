package source;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Students")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3178552772875974878L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact")
	private long contact;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "Student id: " + id + " | name: " + name + " | contact: " + contact;
	}
}
