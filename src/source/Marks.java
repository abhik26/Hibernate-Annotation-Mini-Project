package source;

import javax.persistence.*;

@Entity
@Table(name="Marks")
public class Marks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
	private Student student;
	
	@Column(name="subjectCode", nullable=false)
	private int subjectCode;
	
	@Column(name="subjectName")
	private String subjectName;
	
	@Column(name="marksObtained")
	private float marksObtained;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(float marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}	
}
