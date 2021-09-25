package person;

public class Worker extends Person { 
	private String Worker;

	public Worker(String name, Gender gender, String phone, String worker) {
		super(name, gender, phone);
		Worker = worker;
	}

	public String getWorker() {
		return Worker;
	}

	public void setWorker(String worker) {
		Worker = worker;
	}

	@Override
	public String toString() {
		return "Worker\t [ Name = " + super.getName() + "\t gender = " + this.getGender() + "\t Phone = " +super.getPhone() + "\t Worker=" + Worker + " ]";
	}
	
}