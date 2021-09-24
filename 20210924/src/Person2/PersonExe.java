package Person2;

public class PersonExe 
{
	private static PersonExe singleton = new PersonExe();
	private Person[] arrayPerson;
	
	private PersonExe() {
		arrayPerson = new Person[100];
	}
	
	public static PersonExe getInstance() {
		System.out.println("####");
		return singleton;
	}
	
	public void execute() {
		while(true) {
			System.out.println("[ Person ���� �ý��� ] - - - - - - - - - - - ");
			System.out.println("1.��� 2. ��ȸ 3. ���� 4. ���� 5. ����");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - ");

			int Menu = Scanutil.readInt("�޴��� �����ϼ���.");
			if (Menu == 1) {
				System.out.println("[ Person ��� ������ �����ϰڽ��ϴ�. ]");
				addPerson();
			} else if(Menu == 2) {
				System.out.println("[ Person ��ȸ ������ �����ϰڽ��ϴ�. ]");
				showList();
			} else if(Menu == 3) {
				System.out.println("[ Person ���� ������ �����ϰڽ��ϴ�. ]");
				modify();
			} else if(Menu == 4) {
				System.out.println("[ Person ���� ������ �����ϰڽ��ϴ�. ]");
				remove();
			} else if(Menu == 5) {
				System.out.println("�����ϰڽ��ϴ�.");
				break;
			}
		}
	}
	
	public void remove() {
		System.out.println("[ ģ����� ]= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			System.out.println("[" + i + "] " + arrayPerson[i].toString());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		
		int Select = Scanutil.readInt("�����Ϸ��� Person�� ��ȣ�� �Է��ϼ���");
		if(arrayPerson[Select] == null) {
			System.out.println("�̹� �������� �ʴ� Person�̹Ƿ� ������ �� �����ϴ�.");
		} else {
			arrayPerson[Select] = null;
			System.out.println("[ ������ �Ϸ��Ͽ����ϴ�. ]");
		}
	}
	
	public void modify() {
		System.out.println("[ ģ����� ]= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			System.out.println("[" + i + "] " + arrayPerson[i].toString());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		boolean Flag = false;
		int Select = Scanutil.readInt("�����Ϸ��� Person�� ��ȣ�� �Է��ϼ���.");
		
		String NewPhone = Scanutil.readStr("�����Ϸ��� ����ó�� �Է��ϼ���. [ ������ ��ġ ������ ���͸� �Է��ϼ��� ].");
		if(NewPhone.equals("") == false) {
			Flag = true;
			arrayPerson[Select].setPhone(NewPhone);
		} else {
			System.out.println("[ ��ȣ�� �������� �����̽��ϴ�. ]");
		}
		
	  if(arrayPerson[Select] instanceof Student) {
			String NewSchool = Scanutil.readStr("�����Ϸ��� �б��� �Է��ϼ���. [ ������ ��ġ ������ ���͸� �Է��ϼ��� ].");
			if(NewSchool.equals("") == false) {
				Flag = true;
				((Student)arrayPerson[Select]).setSchool(NewSchool);
			} else {
				System.out.println("[ �б��� �������� �����̽��ϴ�. ]");
			}
		} else if(arrayPerson[Select] instanceof Worker) {
			String NewWorker = Scanutil.readStr("�����Ϸ��� ������ �Է��ϼ���. [ ������ ��ġ ������ ���͸� �Է��ϼ��� ].");
			if(NewWorker.equals("") == false) {
				Flag = true;
				((Worker)arrayPerson[Select]).setWorker(NewWorker);
			} else {
				System.out.println("[ ������ �������� �����̽��ϴ�. ]");
			}
		}
	  
	  if(Flag == true) {
		  System.out.println("[ ������ �Ϸ�Ǿ����ϴ�. ]");
	  } else {
		  System.out.println("[ ������ ������ �����ϴ�. ]");
	  }
	}
	
	public void showList() {
		String Name = Scanutil.readStr("��ȸ�� �̸��� �Է��ϼ���");
		int Gend = Scanutil.readInt("��ȸ�� Person�� ������ ���ڶ�� '0'����, ���ڶ�� '1'���� �Է��ϼ���");
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		boolean Flag = false;
		System.out.println("[ ��ȸ��� ] = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			if(arrayPerson[i].getName().indexOf(Name) != -1 && arrayPerson[i].getGender() == gender) {
				Flag = true;
				if(arrayPerson[i] instanceof Person) {
					System.out.println(arrayPerson[i].toString());
				} else if(arrayPerson[i] instanceof Student) {
					System.out.println(((Student)arrayPerson[i]).toString());
				} else if(arrayPerson[i] instanceof Worker) {
					System.out.println(((Worker)arrayPerson[i]).toString());
				}
			}
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		if(Flag == false)  {
			System.out.println("���ǰ� ��ġ�ϴ� Person�� �������� �ʽ��ϴ�.");
		}
	}
	
	public void addPerson() {

		int Person_Type;
		while (true) {
			System.out.println("1. Person 2. Student 3. Worker");
			Person_Type = Scanutil.readInt("[ ����� Person�� Type�� ������ �ּ���. ]");
			if(Person_Type > 3) {
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			} else break;
		}
		
		Person P = null;
		String Name = Scanutil.readStr("�̸��� �Է��ϼ���");
		int  Gend = Scanutil.readInt("���ڸ� '0'����,  ���ڸ� '1'���� �Է��ϼ���");
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		String Phone = Scanutil.readStr("��ȣ�� �Է��ϼ���");
		
		if(Person_Type == 1) {
			P = new Person(Name, gender, Phone);
		}
		if(Person_Type == 2) {
			String School = Scanutil.readStr("�б��� �Է��ϼ���");
			P = new Student(Name, gender, Phone, School);
		} else if(Person_Type == 3) {
			String Worker = Scanutil.readStr("������ �Է��ϼ���");
			P = new Worker(Name, gender, Phone, Worker);
		}
		
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) {
				arrayPerson[i] = P;
				break;
			}
		}
		
		System.out.println("[ ��Ͽ� �����Ͽ����ϴ�. ]");
	}
}
