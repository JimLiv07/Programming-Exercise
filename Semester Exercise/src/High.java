
public class High {

private static High[] kifisia_high = new High[240];
private static int counter_high = 0;
private static int counter_covid_high = 0;
private static boolean classes_high[] = { false, false, false };
private static int counters_high[] = { 0, 0, 0 };
private String name;
private int id;
private int class_high;
private int birthyear;
private boolean covid_status;
private static int covid_teacher_counter = 0;
private static boolean teacher = false;
private static boolean start = false;

	public High() { 
	}

	public High(String name, int birthyear) {
		if (counters_high[findClass(birthyear)] < 25 ) {/*�� ���� ����� ���� ����� � �����*/
			this.name = name;
			this.birthyear = birthyear;
			this.id = 3000 + counter_high;
			this.covid_status = false;
			this.class_high = findClass(birthyear);
			counters_high[class_high] = counters_high[class_high] + 1;
			kifisia_high[counter_high] = this;
			counter_high++;
			if (start == false) {
				System.out.println("� �������� ��� ������ ����� ��������.");
			}
		} else {
			System.out.println("��� ������� ���� ������������ �� ����� ��� ����.");
		}
	}
	
	public void create() {
		start = true;
		High student1 = new High("������ ��������", 2006);
		new Bus().fillBus(kifisia_high[0].getID(), 3);
		High student2 = new High("������ ����������", 2006);
		High student3 = new High("������� ����������", 2006);
		High student4 = new High("����� ��������", 2006);
		High student5 = new High("������������ ��������", 2006);
		High student6 = new High("������ ���������", 2005);
		new Bus().fillBus(kifisia_high[5].getID(), 3);
		High student7 = new High("������� ����������", 2005);
		High student8 = new High("������ ������", 2005);
		High student9 = new High("������ ���������������", 2005);
		High student10 = new High("����� ����������", 2005);
		High student11 = new High("������� ���������", 2004);
		new Bus().fillBus(kifisia_high[10].getID(), 3);
		High student12 = new High("���� �������", 2004);
		new Bus().fillBus(kifisia_high[11].getID(), 3);
		High student13 = new High("������ �������", 2004);
		new Bus().fillBus(kifisia_high[12].getID(), 3);
		High student14 = new High("����������� ������������", 2004);
		High student15 = new High("������� �������", 2004);
		start = false;
	}

	private int findClass(int year) {
		if (year == 2004) {
			return 2;
		} else if (year == 2005) {
			return 1;
		} else {
			return 0;
		}
	}

	public void display() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < kifisia_high.length; i++) {
				if (j == 0) {
					if (i == 0) {
						System.out.println("�' ����:");
					}
					if (kifisia_high[i] != null) {
						if (kifisia_high[i].getBirthYear() == 2006) {
							System.out.println(kifisia_high[i]);
						}
					}
				} else if (j == 1) {
					if (i == 0) {
						System.out.println("�' ����:");
					}
					if (kifisia_high[i] != null) {
						if (kifisia_high[i].getBirthYear() == 2005) {
							System.out.println(kifisia_high[i]);
						}
					}
				} else if (j == 2) {
					if (i == 0) {
						System.out.println("�' ����:");
					}
					if (kifisia_high[i] != null) {
						if (kifisia_high[i].getBirthYear() == 2004) {
							System.out.println(kifisia_high[i]);
						}
					}
				}
			}
		}
	}

	public void deleteHigh(int delete_id) {
		boolean found = false;
		boolean covid = false;
		int keep = -1;
		for (int i = 0; i < kifisia_high.length; i++) {
			if (kifisia_high[i] != null) {
				if (kifisia_high[i].getID() == delete_id) {
					if (kifisia_high[i].getCovidStatus() == true) {
						covid = true;
						keep = kifisia_high[i].getClassHigh();
					}
					counters_high[kifisia_high[i].getClassHigh()]--;
					kifisia_high[i] = null;
					found = true;
					System.out.println("� �������� ��� ������ ����������������.");
				}
			}
		}
		if (found == false) {/*�� ��� ������ �� ID */
			System.out.println("�� ID ��� ������ ��� ���������� �� ������� ������.");
			System.out.println("�� ������� ��� ������� �����:");
			display();
		} else {
			if (covid == true) {
				boolean more = false;
				for (int i = 0; i < kifisia_high.length; i++) {
					if (kifisia_high[i] != null) {
						if (kifisia_high[i].getClassHigh() == keep) {
							if (kifisia_high[i].getCovidStatus() == true) {
								more = true;
							}
						}
					}
				}
				if (more == false) {
					classes_high[keep] = false;
				}
				counter_covid_high--;
				if (teacher == false) {
					if(counter_covid_high == 2) {
						System.out.println("�� ������ ���� �������� ��� ����������� ���.");
					}
				}
			}
		}
	}

	public void covidStatus() {
		if (teacher == false) {
			if (counter_covid_high != 0) {	
				if (counter_covid_high >= 3) {
					System.out.println("������� ��� �� ������.\n������������� ������ �� ���������:");
				}
				for (int i = 0; i < classes_high.length; i++) {
					if (classes_high[i] == true) {
						if (i == 0) {
							System.out.println("�' ���� ������� ������� ����� ��������.");
						} else if (i == 1) {
							System.out.println("�' ���� ������� ������� ����� ��������.");
						} else {
							System.out.println("�' ���� ������� ������� ����� ��������.");
						} 
					}
				}
			} else {
				System.out.println("��� ������� ������ ������� ���� ������ ��� �������.");
			}
		} else {
			System.out.println("������� ��� �� ������ ����� ������� ��������� ������� ���� COVID.");
		}
	}

	public void covidChange(int covid_id, int mode) {
		boolean flag = false;
		int keep = 0;
		for (int i = 0; i < kifisia_high.length; i++) {
			if (kifisia_high[i] != null) {
				if (kifisia_high[i].getID() == covid_id) {
					flag = true;
					keep = i;
					i = kifisia_high.length - 1;
				}
			}
		}
		if (flag == true) {
			if (mode == 5) {
				if (kifisia_high[keep].getCovidStatus() == true) {
					System.out.println("����� ��� ��������� � �������.");
				} else {
					kifisia_high[keep].setCovidStatus(true);
					if (classes_high[kifisia_high[keep].getClassHigh()] == false) {
						classes_high[kifisia_high[keep].getClassHigh()] = true;
					}
					counter_covid_high++;
				}
			} else {
				if (kifisia_high[keep].getCovidStatus() == false) {
					System.out.println("����� ��� ��������� � �������.");
				} else {
					kifisia_high[keep].setCovidStatus(false);
					boolean more = false;
					for (int i = 0; i < kifisia_high.length; i++) {
						if (kifisia_high[i] != null) {
							if (kifisia_high[i].getClassHigh() == kifisia_high[keep].getClassHigh()) {
								if (kifisia_high[i].getCovidStatus() == true) {
									more = true;
								}
							}
						}
					}
					if (more == false) {
						classes_high[kifisia_high[keep].getClassHigh()] = false;
					}
					counter_covid_high--;
					if (teacher == false) {
						if(counter_covid_high == 2) {
							System.out.println("�� ������ ���� �������� ��� ����������� ���.");
						}
					}
				}
			}
		} else {
			System.out.println("������ ID �� ���������� ������.");
			System.out.println("�� ������� ��� ��������� �����:");
			display();
		}
	}

	public void covidChangeTeachers(boolean covid) {
		if (covid == true) {
			covid_teacher_counter++;
		} else {
			covid_teacher_counter--;
		}
		if (covid_teacher_counter == 0 && teacher == true) {
			teacher = covid;
		} else if (teacher == false) {
			teacher = covid;
		}
		if (teacher == true) {
			covidStatus();
		} else {
			if (covid_teacher_counter == 0) {
				if (counter_covid_high < 3) {
					System.out.println("�� ������ ���� �������� ��� ����������� ���.");
					System.out.println("���� �� ��������� ��� ����� covid.");
				} else {
					System.out.println("���� �� ��������� ��� ����� covid, ���� �� ������ �� ���������� �������.");
					covidStatus();
				}
			}
		}
	}

	public void displayStudent(int id) {
		for (int i = 0; i < kifisia_high.length; i++) {
			if (kifisia_high[i] != null) {
				if (kifisia_high[i].getCovidStatus() == false) {
					if (kifisia_high[i].getID() == id) {
						System.out.println(kifisia_high[i]);
						i = kifisia_high.length - 1;
					}
				}
			}
		}
	}

	protected int getClassHigh() {
		return class_high;
	}
	
	protected void setCovidStatus(boolean change) {
		covid_status = change;
	}
	
	protected boolean getCovidStatus() {
		return covid_status;
	}

	public int getID() {
		return id;
	}

	private int getBirthYear() {
		return birthyear;
	}
	
	@Override
	public String toString() {
		return "����� ������: " + name + "\nID ������: " + id + "\t���� ��������: " + 
					+ birthyear + "\tCovid: " + covid_status; 
	}
}
