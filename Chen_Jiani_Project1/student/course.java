package student;

public class course {
	String number;
	double credit;
	String grade;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double data) {
		this.credit = data;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "[course code=" + number + ", credit=" + credit + ", grade=" + grade + "]";
	}

}

