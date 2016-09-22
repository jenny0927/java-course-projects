package student;

import java.awt.List;
import java.util.ArrayList;

public class Student implements Comparable<Student>{
	
	String firstName;
	String lastName;
	String Major;
	String ID; 	
	double GPA;
	public ArrayList<course> CoursesList = new ArrayList<course>();
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public double studentTotalCredits() {
		double totalCredits=0;
		
		for(int j=0; j<this.CoursesList.size();j++){
			course cs = this.CoursesList.get(j); 
			totalCredits+= cs.getCredit();
		}
		return totalCredits;
	}

	public double studentTotalGPA() {	
		double total = 0.0;
		
		for(int j=0; j<this.CoursesList.size();j++){
			course cs = this.CoursesList.get(j); 
			total += gradeToGPA(cs.getGrade());
		}
		
		return total;
	}

	public double gradeToGPA(String grade){
		double GPAscore;
	
		switch(grade){
			case "A": GPAscore = 4.0;
				break;
			case "A-": GPAscore = 3.7;
				break;
			case "B": GPAscore = 3.0;
				break;
			case "B+": GPAscore = 3.3;
				break;
			case "B-": GPAscore = 2.7;
				break;
			case "C+": GPAscore = 2.3;
				break;
			case "C": GPAscore = 2.0;
				break;
			case "C-": GPAscore = 1.7;
				break;
			case "D": GPAscore = 1.0;
				break;
			case "D+": GPAscore = 1.3;
				break;
			case "D-": GPAscore = 0.7;
				break;
			default: GPAscore = 0;
				break;
			}
		return GPAscore;
	}
	//comparison based on last name
	public int compareTo(Student s)
	{
		return lastName.compareTo(s.getLastName());		
	}
		
	public boolean equal(Student id)
	{
		if(ID.equals(id)) return true;
		return false;
	}
	@Override
	public String toString() 
	{
		return "[LastName=" + lastName + ",FirstName=" + firstName  + ", ID=" + ID+"\n";
	}
}

