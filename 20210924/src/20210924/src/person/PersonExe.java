package person;

public class PersonExe 
{
	private static PersonExe singleton = new PersonExe();
	private Person[] arrayPerson;
	
	private PersonExe() {
		arrayPerson = new Person[100];
	}
	
	public static PersonExe getInstance() {
		return singleton;
	}
	
	public void execute() {
		
		/* **************************** Sample Data ***********************************/
		arrayPerson[0] = new Person("ȫ�浿",Gender.MAN, "1234-1234");
		arrayPerson[1] = new Person("��浿",Gender.MAN, "1234-4321");
		arrayPerson[2] = new Person("�ֱ浿",Gender.WOMAN, "1234-5678");
		arrayPerson[3] = new Person("�����",Gender.WOMAN, "8765-4312");
		arrayPerson[4] = new Student("�۽¿�",Gender.MAN, "1234-0000", "�İ���");
		arrayPerson[5] = new Student("��ö��",Gender.MAN, "0000-4321", "���а�");
		arrayPerson[6] = new Worker("���¼�", Gender.WOMAN, "9876-5432", "īī��");
		arrayPerson[7] = new Worker("������", Gender.WOMAN, "4312-5678", "�Ｚ");
		/* ***************************************************************************/
		
		while(true) {
			System.out.println("| �� �� �� �� �� [ Person ���� �ý��� ] �� �� �� �� �� | ");
			System.out.println("|       1.���   2. ��ȸ   3. ����   4. ����   5. ����        |");
			System.out.println("| �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� | ");

			int Menu = Scanutil.readInt("* �޴��� �����ϼ���(1 ~ 5)  : ");
			if (Menu == 1) {
				System.out.println("* Person '���' ������ �����ϰڽ��ϴ�. *");
				addPerson();
			} else if(Menu == 2) {
				System.out.println("* Person '��ȸ' ������ �����ϰڽ��ϴ�. *");
				showList();
			} else if(Menu == 3) {
				System.out.println("* Person '����' ������ �����ϰڽ��ϴ�. *");
				modify();
			} else if(Menu == 4) {
				System.out.println("* Person '����' ������ �����ϰڽ��ϴ�. *");
				remove();
			} else if(Menu == 5) {
				System.out.println("* '����' �ϰڽ��ϴ�. *");
				break;
			}
			System.out.println();
		}
	}
	
	public void remove() {
		PrintList();		
		int Select = Scanutil.readInt("- �����Ϸ��� Person�� ��ȣ�� �Է��ϼ��� : ");
		if(arrayPerson[Select] == null) {
			System.out.println("< < �̹� �������� �ʴ� Person�̹Ƿ� ������ �� �����ϴ�. > >");
		} else {
			arrayPerson[Select] = null;
			System.out.println("[ ������ �Ϸ��Ͽ����ϴ�. ]");
		}
	}
	
	public void modify() {
		PrintList();
		boolean Flag = false;
		int Select = Scanutil.readInt("- �����Ϸ��� Person�� ��ȣ�� �Է��ϼ��� : ");
		
		String NewPhone = Scanutil.readStr("- �����Ϸ��� ����ó�� �Է��ϼ���. ( ������ ��ġ ������ ���͸� �Է��ϼ��� ) : ");
		if(NewPhone.equals("") == false) {
			Flag = true;
			arrayPerson[Select].setPhone(NewPhone);
			System.out.println("* ����ó�� ���� �Ͽ����ϴ� *");
		} else {
			System.out.println("     < < ����ó�� �������� �����̽��ϴ�. > >");
		}
		
	  if(arrayPerson[Select] instanceof Student) {
			String NewSchool = Scanutil.readStr("- �����Ϸ��� �б��� �Է��ϼ���. ( ������ ��ġ ������ ���͸� �Է��ϼ��� ) : ");
			if(NewSchool.equals("") == false) {
				Flag = true;
				((Student)arrayPerson[Select]).setSchool(NewSchool);
				System.out.println("* �б��� ���� �Ͽ����ϴ�. * ");
			} else {
				System.out.println("     < < �б��� �������� �����̽��ϴ�. > >");
			}
		} else if(arrayPerson[Select] instanceof Worker) {
			String NewWorker = Scanutil.readStr("- �����Ϸ��� ������ �Է��ϼ���. ( ������ ��ġ ������ ���͸� �Է��ϼ��� ) : ");
			if(NewWorker.equals("") == false) {
				Flag = true;
				((Worker)arrayPerson[Select]).setWorker(NewWorker);
				System.out.println("* ������ ���� �Ͽ����ϴ�. * ");
			} else {
				System.out.println("     < < ������ �������� �����̽��ϴ�. > >");
			}
		}
	  
	  if(Flag == true) {
		  System.out.println("[ ������ �Ϸ�Ǿ����ϴ�. ]");
	  } else {
		  System.out.println("[ ������ ������ �����ϴ�. ]");
	  }
	}
	
	public void showList() {
		String Name = Scanutil.readStr("- ��ȸ�� �̸��� �Է��ϼ���. (�Է��� ������ ���� ��, '����'�� �Է��ϼ���) : ");
		if(Name.equals("")) {
			System.out.println("     < < �̸��� �Է����� �����̽��ϴ�. ��ȸ ���ǿ��� '�̸�'�� �����մϴ�. > >");
		}
		String Str_Gend = null;
		Gender gender = null;
		int Gend;
		
		while(true) {
			Str_Gend = Scanutil.readStr("- ��ȸ�� Person�� ������ ���ڶ�� '0'����, ���ڶ�� '1'���� �Է��ϼ��� (�Է��� ������ ���� ��, '����'�� �Է��ϼ���) : ");
			if(Str_Gend.equals("")) {
				System.out.println("     < < ������ �Է����� �����̽��ϴ�.  ��ȸ ���ǿ��� '����'�� �����մϴ�.  > >");
				break;
			} else if(Str_Gend.equals("0")  || Str_Gend.equals("1") ) {
				 Gend = Integer.parseInt(Str_Gend);
				 gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
				break;
			} else {
				System.out.println("- �߸��� �Է��Դϴ�. �ٽ� �Է����ּ��� !");
			}
		}
		System.out.println();
		
		int Mode;
		if(Name.equals("") && Str_Gend.equals("")) {
			Mode = 1;
		} else if(!Name.equals("") && Str_Gend.equals("")) {
			Mode = 2;
		} else if(Name.equals("") && !Str_Gend.equals("")) {
			Mode = 3;
		} else {
			Mode = 4;
		}
		
		boolean Flag = false;
		System.out.println("* * [ ��ȸ��� ] * * * * * * * * * * * * * * * * * * * * * * * *  * * * * * * * * * * * * * * * * * * * ");
		for (int i = 0; i < arrayPerson.length; i++) {
			if (arrayPerson[i] == null) continue;
			if (Mode == 1) {
				Flag = true;
				Print_State(arrayPerson[i]);
			} else if(Mode == 2) {
				if(arrayPerson[i].getName().indexOf(Name) != -1) {
					Flag = true;
					Print_State(arrayPerson[i]);
				}
			} else if(Mode == 3) {
				if(arrayPerson[i].getGender() == gender) {
					Flag = true;
					Print_State(arrayPerson[i]);
				}
			} else {
				if(arrayPerson[i].getName().indexOf(Name) != -1 && arrayPerson[i].getGender() == gender) {
					Flag = true;
					Print_State(arrayPerson[i]);
				}
			}
		}
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		if(Flag == false)  {
			System.out.println("���ǰ� ��ġ�ϴ� Person�� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("[ ���ǿ� �´� Person ��ȸ ����Դϴ�. ] ");
		}
	}
	
	public void addPerson() {

		int Person_Type;
		while (true) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println("*     1. Person      2. Student      3. Worker        *");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			Person_Type = Scanutil.readInt("���� ���⿡�� ����� Person�� Type�� ������ �ּ��� : ");
			
			if(Person_Type > 3) {
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			} else break;
		}
		
		Person P = null;
		String Name = Scanutil.readStr("- �̸��� �Է��ϼ��� : ");
		int Gend;
		while(true) 
		{
			Gend = Scanutil.readInt("- ���ڸ� '0'����,  ���ڸ� '1'���� �Է��ϼ��� : ");
			if(Gend != 0 && Gend != 1) {
				System.out.println("- �߸��� �Է��Դϴ� ! �ٽ� �Է����ּ��� !");
			} else break;
		}
		
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		String Phone = Scanutil.readStr("- ��ȣ�� �Է��ϼ��� : ");
		
		if(Person_Type == 1) {
			P = new Person(Name, gender, Phone);
		}
		if(Person_Type == 2) {
			String School = Scanutil.readStr("- �б��� �Է��ϼ��� : ");
			P = new Student(Name, gender, Phone, School);
		} else if(Person_Type == 3) {
			String Worker = Scanutil.readStr("- ������ �Է��ϼ��� : ");
			P = new Worker(Name, gender, Phone, Worker);
		}
		
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) {
				arrayPerson[i] = P;
				break;
			}
		}
		
		System.out.println("[ Person ��Ͽ� �����Ͽ����ϴ�.  ]");
	}
	
	public void PrintList() {
		System.out.println("[ People ��� ] * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			System.out.println("[" + i + "] " + arrayPerson[i].toString());
		}
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
	}
	
	public void Print_State(Person A) {
		if(A instanceof Student) {
			System.out.println(((Student)A).toString());
		} else if(A instanceof Worker) {
			System.out.println(((Worker)A).toString());
		} else {
			System.out.println(A.toString());
		}
	}
}
