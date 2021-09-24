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
			System.out.println("[ Person 관리 시스템 ] - - - - - - - - - - - ");
			System.out.println("1.등록 2. 조회 3. 수정 4. 삭제 5. 종료");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - ");

			int Menu = Scanutil.readInt("메뉴를 선택하세요.");
			if (Menu == 1) {
				System.out.println("[ Person 등록 과정을 진행하겠습니다. ]");
				addPerson();
			} else if(Menu == 2) {
				System.out.println("[ Person 조회 과정을 진행하겠습니다. ]");
				showList();
			} else if(Menu == 3) {
				System.out.println("[ Person 수정 과정을 진행하겠습니다. ]");
				modify();
			} else if(Menu == 4) {
				System.out.println("[ Person 삭제 과정을 진행하겠습니다. ]");
				remove();
			} else if(Menu == 5) {
				System.out.println("종료하겠습니다.");
				break;
			}
		}
	}
	
	public void remove() {
		System.out.println("[ 친구목록 ]= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			System.out.println("[" + i + "] " + arrayPerson[i].toString());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		
		int Select = Scanutil.readInt("삭제하려는 Person의 번호를 입력하세요");
		if(arrayPerson[Select] == null) {
			System.out.println("이미 존재하지 않는 Person이므로 삭제할 수 없습니다.");
		} else {
			arrayPerson[Select] = null;
			System.out.println("[ 삭제를 완료하였습니다. ]");
		}
	}
	
	public void modify() {
		System.out.println("[ 친구목록 ]= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) continue;
			
			System.out.println("[" + i + "] " + arrayPerson[i].toString());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		boolean Flag = false;
		int Select = Scanutil.readInt("수정하려는 Person의 번호를 입력하세요.");
		
		String NewPhone = Scanutil.readStr("수정하려는 연락처를 입력하세요. [ 수정을 원치 않으면 엔터를 입력하세요 ].");
		if(NewPhone.equals("") == false) {
			Flag = true;
			arrayPerson[Select].setPhone(NewPhone);
		} else {
			System.out.println("[ 번호를 수정하지 않으셨습니다. ]");
		}
		
	  if(arrayPerson[Select] instanceof Student) {
			String NewSchool = Scanutil.readStr("수정하려는 학교를 입력하세요. [ 수정을 원치 않으면 엔터를 입력하세요 ].");
			if(NewSchool.equals("") == false) {
				Flag = true;
				((Student)arrayPerson[Select]).setSchool(NewSchool);
			} else {
				System.out.println("[ 학교를 수정하지 않으셨습니다. ]");
			}
		} else if(arrayPerson[Select] instanceof Worker) {
			String NewWorker = Scanutil.readStr("수정하려는 직장을 입력하세요. [ 수정을 원치 않으면 엔터를 입력하세요 ].");
			if(NewWorker.equals("") == false) {
				Flag = true;
				((Worker)arrayPerson[Select]).setWorker(NewWorker);
			} else {
				System.out.println("[ 직장을 수정하지 않으셨습니다. ]");
			}
		}
	  
	  if(Flag == true) {
		  System.out.println("[ 수정이 완료되었습니다. ]");
	  } else {
		  System.out.println("[ 수정한 사항이 없습니다. ]");
	  }
	}
	
	public void showList() {
		String Name = Scanutil.readStr("조회할 이름을 입력하세요");
		int Gend = Scanutil.readInt("조회할 Person의 성별이 남자라면 '0'번을, 여자라면 '1'번을 입력하세요");
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		boolean Flag = false;
		System.out.println("[ 조회결과 ] = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
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
			System.out.println("조건과 일치하는 Person이 존재하지 않습니다.");
		}
	}
	
	public void addPerson() {

		int Person_Type;
		while (true) {
			System.out.println("1. Person 2. Student 3. Worker");
			Person_Type = Scanutil.readInt("[ 등록할 Person의 Type을 선택해 주세요. ]");
			if(Person_Type > 3) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			} else break;
		}
		
		Person P = null;
		String Name = Scanutil.readStr("이름을 입력하세요");
		int  Gend = Scanutil.readInt("남자면 '0'번을,  여자면 '1'번을 입력하세요");
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		String Phone = Scanutil.readStr("번호를 입력하세요");
		
		if(Person_Type == 1) {
			P = new Person(Name, gender, Phone);
		}
		if(Person_Type == 2) {
			String School = Scanutil.readStr("학교를 입력하세요");
			P = new Student(Name, gender, Phone, School);
		} else if(Person_Type == 3) {
			String Worker = Scanutil.readStr("직장을 입력하세요");
			P = new Worker(Name, gender, Phone, Worker);
		}
		
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) {
				arrayPerson[i] = P;
				break;
			}
		}
		
		System.out.println("[ 등록에 성공하였습니다. ]");
	}
}
