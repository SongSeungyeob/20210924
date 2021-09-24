package Person2;

public class Person 
{
	private String Name;
	private Gender gender;
	private String Phone;
	
	public Person(String name, Gender gender, String phone) {
		Name = name;
		this.gender = gender;
		Phone = phone;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", gender=" + gender + ", Phone=" + Phone + "]";
	}
	
	
}
