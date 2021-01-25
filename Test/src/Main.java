import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner_int = new Scanner(System.in);
		Scanner scanner_string = new Scanner (System.in);
		int delete;
		int option;
		int covid;
		int covid_del;
		int birthyear;
		Elementary key_el = new Elementary();
		Middle key_mid = new Middle();
		High key_high = new High();
		Bus key_bus = new Bus();
		Teachers key_teachers = new Teachers();

		do {
			System.out.println("------------------------------- ����� �������� -------------------------------");
			System.out.println("==============================================================================");
			System.out.println("1. �������� ���� ������.\n"
							 + "2. �������� �������.\n"
							 + "3. �������� ������.\n"
							 + "4. �������� ��������� ���������� �������� �������.\n"
							 + "5. �������� ���� ����������.\n"
							 + "6. �������� ���������� covid.\n"
							 + "7. �������� ���� ��������.");
			System.out.println("==============================================================================");
			System.out.println("������� �� ������� ��� �������� ��� �� ������ �� ���������������.");
			System.out.println("������� �� ������� \"8\" �� ��� ������ �� ��������� ������ ������ ��������.");
			do {
				option = scanner_int.nextInt();
				if (option < 1 || option > 8) {
					System.out.println("�������� ������������ �� ����� �������� ��� �������� ��� ��� �� �������.");
					System.out.println("������� �� ������� \"8\" �� ��� ������ �� ��������� ������ ������ ��������.");
				}
			} while (option < 1 || option > 8);
			System.out.println("==============================================================================");
			if(option == 1) {
				System.out.println("�������� ���� ������:");
				System.out.println("����� �� ����� ��� ������.");
				String name = scanner_string.nextLine();
				System.out.println("����� �� ���� �������� ��� ������.");
				do {
					birthyear = scanner_int.nextInt();
					if (birthyear > 2015 || birthyear < 2004) {
						System.out.println("���� � ������ ��� ������ �� ��������� �� ������ ������� ����. ���������.");
					}
				} while (birthyear > 2015 || birthyear < 2004);
				System.out.println("������������ �� ������� ��� �����;"); // ����� �� ������������ �� ������� 
				String answer = scanner_string.nextLine();
				int input;
				int type;
				if (birthyear >= 2010) {
					Elementary new_elementary = new Elementary(name, birthyear);
					input = new_elementary.getID(); // ���������� �� id ��� ������ ��� �� ��� ������ ��� ���������
					type = 1; // ����� ��� �� ���� ��������� ������ ������� �� �� ������� ���
				} else if (birthyear >= 2007) {
					Middle new_middle = new Middle(name, birthyear);
					input = new_middle.getID();
				    type = 2;
				} else {
					High new_high = new High(name, birthyear);
					input = new_high.getID();
					type = 3;
				}
				
				if (answer.equalsIgnoreCase("���")) {
					Bus new_child = new Bus(input, type); // �� ������������ �� ������� ���� ���� ������������ ��� ������ Bus ������� �� �� ������� ���
				}
			} else if (option == 2) {
				System.out.println("==============================================================================");
				System.out.println("��������");
				System.out.println("==============================================================================");
				key_el.display();
				System.out.println("==============================================================================");
				System.out.println("��������");
				System.out.println("==============================================================================");
				key_mid.display();
				System.out.println("==============================================================================");
				System.out.println("������");
				System.out.println("==============================================================================");
				key_high.display();
			} else if (option == 3) {
				System.out.println("�������� ������:");
				System.out.println("����� �� ID ��� ������ ��� �� ������ �� ����������.");
				do{
					delete = scanner_int.nextInt(); 
					if (delete > 3999 || delete < 1000) {
						System.out.println("�� ID ��� ������� �������� ��� �� 1000 ��� ������� �� �� 3999. ���������.");
						System.out.println("ID ���������: 1000-1999\nID ���������: 2000-2999\nID �������: 3000-3999");
					}
				} while (delete > 3999 || delete < 1000);
				if (delete >= 1000 && delete <= 1999) {
					key_el.deleteEl(delete);//��� ����� ������� �� ����� �� ���� ����� ���� 
				} else if (delete >= 2000 && delete <= 2999) {
					key_mid.deleteMid(delete);
				} else {
					key_high.deleteHigh(delete);
				}
			} else if (option == 4) {
				key_el.covidStatus();
				key_mid.covidStatus();
				key_high.covidStatus();
				key_teachers.covidStatus();
			} else if (option == 5) {
				System.out.println("�������� �� ID ��� ������ ��� ����� ������� ���� ��������.");
				do {
					covid = scanner_int.nextInt(); 
					if (covid > 4999 || covid < 1000) {
						System.out.println("�� ID  �������� ��� �� 1000 ��� ������� �� �� 4999.");
						System.out.println("ID ���������: 1000-1999\nID ���������: 2000-2999\nID �������: 3000-3999\n ���������: 4000-4999");
					}
				} while (covid > 4999 || covid < 1000);
				if (covid >= 1000 && covid <= 1999) {
					key_el.covidChange(covid);
					key_bus.findinbus(covid, 1); // ����� ���� ��������� ��� ������� �� ������� ����� ������� ��� ���������� ���� ��� �� ��������� �� ��������� ������
				} else if (covid >= 2000 && covid <= 2999) {
					key_mid.covidChange(covid);
					key_bus.findinbus(covid, 2);
				} else if (covid >= 2999 && covid <= 3999){
					key_high.covidChange(covid);
					key_bus.findinbus(covid, 3);
				} else {
					key_teachers.covidChanget(covid);
				}
			} else if (option == 6) {
				System.out.println("���� �� ID ���� ������ �� Covid-19 ��� ����� ��������� ��� ������� ����.");
				do {
					covid_del = scanner_int.nextInt(); 
					if (covid_del > 3999 || covid_del < 1000) {
						System.out.println("�� ID ��� ������� �������� ��� �� 1000 ��� ������� �� �� 3999.");
						System.out.println("ID ���������: 1000-1999\nID ���������: 2000-2999\nID �������: 3000-3999");
					}
				} while (covid_del > 3999 || covid_del < 1000);
				if (covid_del >= 1000 && covid_del <= 1999) {
					key_el.covidChange(covid_del);
				} else if (covid_del >= 2000 && covid_del <= 2999) {
					key_mid.covidChange(covid_del);
				} else {
					key_high.covidChange(covid_del);
				}
			}else if (option == 7) {
				System.out.println("�������� ���� ��������:");
				System.out.println("����� �� ����� ��� ��������.");
				String name = scanner_string.nextLine();
				System.out.println("����� 1 ��� ��������, 2 ��� �������� � 3 ��� ������.");
				int type = scanner_int.nextInt();
				System.out.println("����� ������ �������");
				int tid = scanner_int.nextInt();
				System.out.println("����� ���� �����������.");
				int classes = scanner_int.nextInt();
				Teachers new_teacher = new Teachers(tid,type,name,classes);
				key_teachers.display();
			}/*else if (option == 8) {
			 	*/
		} while(option != 8);
	}
}
