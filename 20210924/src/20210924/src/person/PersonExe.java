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
		arrayPerson[0] = new Person("홍길동",Gender.MAN, "1234-1234");
		arrayPerson[1] = new Person("김길동",Gender.MAN, "1234-4321");
		arrayPerson[2] = new Person("최길동",Gender.WOMAN, "1234-5678");
		arrayPerson[3] = new Person("김수진",Gender.WOMAN, "8765-4312");
		arrayPerson[4] = new Student("송승엽",Gender.MAN, "1234-0000", "컴공과");
		arrayPerson[5] = new Student("김철수",Gender.MAN, "0000-4321", "수학과");
		arrayPerson[6] = new Worker("엽승송", Gender.WOMAN, "9876-5432", "카카오");
		arrayPerson[7] = new Worker("전지현", Gender.WOMAN, "4312-5678", "삼성");
		/* ***************************************************************************/
		
		while(true) {
			System.out.println("| ㅡ ㅡ ㅡ ㅡ ㅡ [ Person 관리 시스템 ] ㅡ ㅡ ㅡ ㅡ ㅡ | ");
			System.out.println("|       1.등록   2. 조회   3. 수정   4. 삭제   5. 종료        |");
			System.out.println("| ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ | ");

			int Menu = Scanutil.readInt("* 메뉴를 선택하세요(1 ~ 5)  : ");
			if (Menu == 1) {
				System.out.println("* Person '등록' 과정을 진행하겠습니다. *");
				addPerson();
			} else if(Menu == 2) {
				System.out.println("* Person '조회' 과정을 진행하겠습니다. *");
				showList();
			} else if(Menu == 3) {
				System.out.println("* Person '수정' 과정을 진행하겠습니다. *");
				modify();
			} else if(Menu == 4) {
				System.out.println("* Person '삭제' 과정을 진행하겠습니다. *");
				remove();
			} else if(Menu == 5) {
				System.out.println("* '종료' 하겠습니다. *");
				break;
			}
			System.out.println();
		}
	}
	
	public void remove() {
		PrintList();		
		int Select = Scanutil.readInt("- 삭제하려는 Person의 번호를 입력하세요 : ");
		if(arrayPerson[Select] == null) {
			System.out.println("< < 이미 존재하지 않는 Person이므로 삭제할 수 없습니다. > >");
		} else {
			arrayPerson[Select] = null;
			System.out.println("[ 삭제를 완료하였습니다. ]");
		}
	}
	
	public void modify() {
		PrintList();
		boolean Flag = false;
		int Select = Scanutil.readInt("- 수정하려는 Person의 번호를 입력하세요 : ");
		
		String NewPhone = Scanutil.readStr("- 수정하려는 연락처를 입력하세요. ( 수정을 원치 않으면 엔터를 입력하세요 ) : ");
		if(NewPhone.equals("") == false) {
			Flag = true;
			arrayPerson[Select].setPhone(NewPhone);
			System.out.println("* 연락처를 수정 하였습니다 *");
		} else {
			System.out.println("     < < 연락처를 수정하지 않으셨습니다. > >");
		}
		
	  if(arrayPerson[Select] instanceof Student) {
			String NewSchool = Scanutil.readStr("- 수정하려는 학교를 입력하세요. ( 수정을 원치 않으면 엔터를 입력하세요 ) : ");
			if(NewSchool.equals("") == false) {
				Flag = true;
				((Student)arrayPerson[Select]).setSchool(NewSchool);
				System.out.println("* 학교를 수정 하였습니다. * ");
			} else {
				System.out.println("     < < 학교를 수정하지 않으셨습니다. > >");
			}
		} else if(arrayPerson[Select] instanceof Worker) {
			String NewWorker = Scanutil.readStr("- 수정하려는 직장을 입력하세요. ( 수정을 원치 않으면 엔터를 입력하세요 ) : ");
			if(NewWorker.equals("") == false) {
				Flag = true;
				((Worker)arrayPerson[Select]).setWorker(NewWorker);
				System.out.println("* 직장을 수정 하였습니다. * ");
			} else {
				System.out.println("     < < 직장을 수정하지 않으셨습니다. > >");
			}
		}
	  
	  if(Flag == true) {
		  System.out.println("[ 수정이 완료되었습니다. ]");
	  } else {
		  System.out.println("[ 수정한 사항이 없습니다. ]");
	  }
	}
	
	public void showList() {
		String Name = Scanutil.readStr("- 조회할 이름을 입력하세요. (입력을 원하지 않을 시, '엔터'를 입력하세요) : ");
		if(Name.equals("")) {
			System.out.println("     < < 이름을 입력하지 않으셨습니다. 조회 조건에서 '이름'을 배제합니다. > >");
		}
		String Str_Gend = null;
		Gender gender = null;
		int Gend;
		
		while(true) {
			Str_Gend = Scanutil.readStr("- 조회할 Person의 성별이 남자라면 '0'번을, 여자라면 '1'번을 입력하세요 (입력을 원하지 않을 시, '엔터'를 입력하세요) : ");
			if(Str_Gend.equals("")) {
				System.out.println("     < < 성별을 입력하지 않으셨습니다.  조회 조건에서 '성별'을 배제합니다.  > >");
				break;
			} else if(Str_Gend.equals("0")  || Str_Gend.equals("1") ) {
				 Gend = Integer.parseInt(Str_Gend);
				 gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
				break;
			} else {
				System.out.println("- 잘못된 입력입니다. 다시 입력해주세요 !");
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
		System.out.println("* * [ 조회결과 ] * * * * * * * * * * * * * * * * * * * * * * * *  * * * * * * * * * * * * * * * * * * * ");
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
			System.out.println("조건과 일치하는 Person이 존재하지 않습니다.");
		} else {
			System.out.println("[ 조건에 맞는 Person 조회 목록입니다. ] ");
		}
	}
	
	public void addPerson() {

		int Person_Type;
		while (true) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println("*     1. Person      2. Student      3. Worker        *");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			Person_Type = Scanutil.readInt("위의 보기에서 등록할 Person의 Type을 선택해 주세요 : ");
			
			if(Person_Type > 3) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			} else break;
		}
		
		Person P = null;
		String Name = Scanutil.readStr("- 이름을 입력하세요 : ");
		int Gend;
		while(true) 
		{
			Gend = Scanutil.readInt("- 남자면 '0'번을,  여자면 '1'번을 입력하세요 : ");
			if(Gend != 0 && Gend != 1) {
				System.out.println("- 잘못된 입력입니다 ! 다시 입력해주세요 !");
			} else break;
		}
		
		Gender gender = Gend == 0 ? Gender.MAN : Gender.WOMAN;
		String Phone = Scanutil.readStr("- 번호를 입력하세요 : ");
		
		if(Person_Type == 1) {
			P = new Person(Name, gender, Phone);
		}
		if(Person_Type == 2) {
			String School = Scanutil.readStr("- 학교를 입력하세요 : ");
			P = new Student(Name, gender, Phone, School);
		} else if(Person_Type == 3) {
			String Worker = Scanutil.readStr("- 직장을 입력하세요 : ");
			P = new Worker(Name, gender, Phone, Worker);
		}
		
		for(int i = 0 ; i < arrayPerson.length; i++) {
			if(arrayPerson[i] == null) {
				arrayPerson[i] = P;
				break;
			}
		}
		
		System.out.println("[ Person 등록에 성공하였습니다.  ]");
	}
	
	public void PrintList() {
		System.out.println("[ People 목록 ] * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
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
