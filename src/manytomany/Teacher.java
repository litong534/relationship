package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
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
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Student> getStudents() {
		return students;
	}
}
