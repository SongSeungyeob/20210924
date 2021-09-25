package person;

public class Student  extends Person {
	private String School;

	public Student(String Name, Gender gender, String Phone, String School) {
		super(Name, gender, Phone);
		this.School = School;
	}
	
	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}

	@Override
	public String toString() {
		return "Student\t  [ Name = " + getName() + "\t gender = " + getGender() + "\t Phone = " +getPhone() + "\t School = " + School + "]";
	}
}