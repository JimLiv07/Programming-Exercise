
public class Teachers {
	private static Teachers[] elementary_teachers = new Teachers[6];
	private static Teachers[] middle_teachers = new Teachers[10];
	private static Teachers[] high_teachers = new Teachers[10];
	private static int c1 = 0;
	private static int c2 = 0;
	private static int c3 = 0;
	private int teachers_id; /* 4000-4999*/ /*�� 4300 ��������, �� 4700 ��������, �� 4999 ������*/
	private String name;
	private int classes; /* ��� 0 ��� 5 ����� �� ������ ��� ��������� */
	private boolean covid_status;
	private static boolean start = false;

	public Teachers () {
	}
	
	public Teachers(int type, String name, int cl) {
		if (type == 1) {
			if (c1 < 6 ) {
				this.teachers_id = 4000 + c1;
				this.name = name;
				this.classes = cl;
				this.covid_status = false;
				elementary_teachers[c1] = this;
				c1++;
				if (start == false) {
					System.out.println("� �������� ��� �������� ����� ��������.");
				}
			} else {
				System.out.println("��� ������� ���� ������������ ��� ��������� ���������.");
			}
		} else if (type == 2) {
			if (c2 < 10 ) {
				this.teachers_id = 4300 + c2;
				this.name = name;
				this.classes = cl;
				this.covid_status = false;
				middle_teachers[c2] = this;
				c2++;
				if (start == false) {
					System.out.println("� �������� ��� �������� ����� ��������.");
				}
			} else {
				System.out.println("��� ������� ���� ������������ ��� ��������� ���������.");
			}
		} else {
			if (c3 < 10 ) {
			this.teachers_id = 4700 + c3;
			this.name = name;
			this.classes = cl;
			this.covid_status = false;
			high_teachers[c3] = this;
			c3++;
			if (start == false) {
				System.out.println("� �������� ��� �������� ����� ��������.");
			}
		    } else {
			System.out.println("��� ������� ���� ������������ ��� ��������� �������.");
		    }
	    }	
	}
	
	public void create() {
		start = true;
		Teachers teacher1 = new Teachers(1, "������� �������������", 0);
		Teachers teacher2 = new Teachers(1, "������ �����������", 1);
		Teachers teacher3 = new Teachers(1, "������ ��������", 2);
		Teachers teacher4 = new Teachers(1, "���� ������������", 3);
		Teachers teacher5 = new Teachers(1, "���� ����������", 4);
		Teachers teacher6 = new Teachers(1, "����� ������", 5);
		Teachers teacher7 = new Teachers(2, "����� ��������", -1);
		Teachers teacher8 = new Teachers(2, "������� ���������", -1);
		Teachers teacher9 = new Teachers(2, "����� ����������", -1);
		Teachers teacher10 = new Teachers(3, "����� �����", -1);
		Teachers teacher11 = new Teachers(3, "�������� ������������", -1);
		Teachers teacher12 = new Teachers(3, "������ �����������", -1);
		start = false;
	}

	public void covidChanget(int covid_id, int mode) {
		boolean flag = false;
		int keep = 0;
		if (covid_id < 4300) {
			for (int i = 0; i < elementary_teachers.length; i++) {
				if (elementary_teachers[i] != null) {
					if (elementary_teachers[i].getTeachersID() == covid_id) {
						flag = true;
						keep = i;
						i = elementary_teachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 5) {
					if (elementary_teachers[keep].getCovidStatus() == true) {
						System.out.println("����� ��� ������� � ���������.");
					} else {
						elementary_teachers[keep].setCovidStatus(true);
						new Elementary().covidChangeTeachers(true, elementary_teachers[keep].getClasses());
					}
				} else {
					if (elementary_teachers[keep].getCovidStatus() == false) {
						System.out.println("����� ��� ��������� � ���������.");
					} else {
						elementary_teachers[keep].setCovidStatus(false);
						new Elementary().covidChangeTeachers(false, elementary_teachers[keep].getClasses());
					}
				}
			} 
		} else if (covid_id < 4700 ) {
			for (int i = 0; i < middle_teachers.length; i++) {
				if (middle_teachers[i] != null) {
					if (middle_teachers[i].getTeachersID() == covid_id) {
						flag = true;
						keep = i;
						i = middle_teachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 5) {
					if (middle_teachers[keep].getCovidStatus() == true) {
						System.out.println("����� ��� ������� � ���������.");
					} else {
						middle_teachers[keep].setCovidStatus(true);
						new Middle().covidChangeTeachers(true);
					}
				} else {
					if (middle_teachers[keep].getCovidStatus() == false) {
						System.out.println("����� ��� ��������� � ���������.");
					} else {
						middle_teachers[keep].setCovidStatus(false);
						new Middle().covidChangeTeachers(false);
					}
				}
			}
		} else {
			for (int i = 0; i < high_teachers.length; i++) {
				if (high_teachers[i] != null) {
					if (high_teachers[i].getTeachersID() == covid_id) {
						flag = true;
						keep = i;
						i = high_teachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 5) {
					if (high_teachers[keep].getCovidStatus() == true) {
						System.out.println("����� ��� ������� � ���������.");
					} else {
						high_teachers[keep].setCovidStatus(true);
						new High().covidChangeTeachers(true);
					}
				} else {
					if (high_teachers[keep].getCovidStatus() == false) {
						System.out.println("����� ��� ��������� � ���������.");
					} else {
						System.out.println("���������");
						high_teachers[keep].setCovidStatus(false);
						new High().covidChangeTeachers(false);
					}
				}
			}	
		}
		if (flag == false) {
			System.out.println("��� ������� ��������� �� ������ ID.");
			System.out.println("�� ��������� �����:");
			display();
		}
	}

	public void display() {
		int e = 0;
		for(int i = 0; i < elementary_teachers.length; i++) {
			if(elementary_teachers[i] != null) {
				System.out.println("����� ��������: " + elementary_teachers[i].getName());
				System.out.println("ID ��������: " + elementary_teachers[i].getTeachersID() + " ������ ��������� ��� ��������: " + (elementary_teachers[i].getClasses() + 1) + " Covid Status: " + elementary_teachers[i].getCovidStatus());
			} else {
				e++;
			}
		}
		if (e <= 6 && e >= 1) {
			System.out.println("�� �������� ���� ��������� ���������");
		}
		int m = 0;
		for (int i = 0; i < middle_teachers.length; i++) {
			if (middle_teachers[i] == null) {
				m++;
			} else {
				System.out.println("����� ��������: " + middle_teachers[i].getName());
				System.out.println("ID ��������: " + middle_teachers[i].getTeachersID() + " ������ ��������� ��� ��������: �� ����" + " Covid Status: " + middle_teachers[i].getCovidStatus());
			}
		}
		if (m > 0) {
			System.out.println("�� �������� ���� ��������� ���������");
		}
		int h = 0;
		for (int i = 0; i < high_teachers.length; i++) {
			if (high_teachers[i] == null) {
				h++;
			} else {
				System.out.println("����� ��������: " + high_teachers[i].getName());
				System.out.println("ID ��������: " + high_teachers[i].getTeachersID() + " ������ ������� ��� ��������: �� ����" + " Covid Status: " + high_teachers[i].getCovidStatus());
			}
		}
		if (h > 0) {
			System.out.println("�� ������ ���� ��������� ���������");
		}
	}

	public int getTeachersID() {
		return teachers_id;
	}

	public void setTeachersID(int tcid) {
		this.teachers_id = tcid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getCovidStatus() {
		return covid_status;
	}

	public void setCovidStatus(boolean covid_status) {
		this.covid_status = covid_status;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
	}
}
