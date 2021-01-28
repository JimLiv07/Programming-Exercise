
public class Middle {

private static Middle[] kifisia_mid = new Middle[75];
private static int counter_mid = 0;
private static int counter_covid_mid = 0;
private static boolean classes_mid[] = { false, false, false };
private static int counters_mid[] = { 0, 0, 0 };
private String name;
private int id;
private int class_mid;
private int birthyear;
private boolean covid_status;
private static int covid_teacher_counter;
private static boolean teacher = false;
private static boolean start = false;

	public Middle() { 
	}

	public Middle(String name, int birthyear) {
		if (counters_mid[findClass(birthyear)] < 25 ) {//Το κάθε τμήμα έχει μέχρι 25 άτομα
			this.name = name;
			this.birthyear = birthyear;
			this.id = 2000 + counter_mid;
			this.covid_status = false;
			this.class_mid = findClass(birthyear);
			counters_mid[class_mid] = counters_mid[class_mid] + 1;
			kifisia_mid[counter_mid] = this;
			counter_mid++;
			if (start == false) {
				System.out.println("Η εισαγωγή του μαθητή έγινε επιτυχώς.");
			}
		} else {
			System.out.println("Δεν υπάρχει άλλη χωρητικότητα σε αυτήν την τάξη.");
		}
	}
	
	public void create() {
		start = true;
		Middle student1 = new Middle("Σταμάτης Γιακουμής", 2009);
		new Bus().fillBus(kifisia_mid[0].getID(), 2);
		Middle student2 = new Middle("Κατερίνα Ιωάννου", 2009);
		Middle student3 = new Middle("Γρηγόρης Αρναούτογλου", 2009);
		Middle student4 = new Middle("Μαριάννα Σκεπαρνιά", 2009);
		Middle student5 = new Middle("Σταμάτης Τζιαντόπουλος", 2009);
		Middle student6 = new Middle("Ιωάννης Πιστιόλης", 2008);
		new Bus().fillBus(kifisia_mid[5].getID(), 2);
		Middle student7 = new Middle("Νέστορας Μπραβίδης", 2008);
		Middle student8 = new Middle("Δημητράκης Κοκκίδης", 2008);
		Middle student9 = new Middle("Παναγιώτης Αυγόπουλος", 2008);
		Middle student10 = new Middle("Γιώργος Αυγόπουλος", 2008);
		Middle student11 = new Middle("Ιωάννης Τσιλιγγίρης", 2007);
		new Bus().fillBus(kifisia_mid[10].getID(), 2);
		Middle student12 = new Middle("Αντώνης Γκαβέζος", 2007);
		new Bus().fillBus(kifisia_mid[11].getID(), 2);
		Middle student13 = new Middle("Θάνος Βασιλοπουλος", 2007);
		Middle student14 = new Middle("Δημήτρης Καραμπάτσος", 2007);
		new Bus().fillBus(kifisia_mid[13].getID(), 2);
		Middle student15 = new Middle("Μαρία Παπαγιάννη", 2007);
		start = false;
	}

	private int findClass(int year) {
		if (year == 2007) {
			return 2;
		} else if (year == 2008) {
			return 1;
		} else {
			return 0;
		}
	}

	public void display() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < kifisia_mid.length; i++) {
				if (j == 0) {
					if (i == 0) {
						System.out.println("Α' ΤΑΞΗ:");
					}
					if (kifisia_mid[i] != null) {
						if (kifisia_mid[i].getBirthYear() == 2009) {
							System.out.println(kifisia_mid[i]);
						}
					}
				} else if (j == 1) {
					if (i == 0) {
						System.out.println("Β' ΤΑΞΗ:");
					}
					if (kifisia_mid[i] != null) {
						if (kifisia_mid[i].getBirthYear() == 2008) {
							System.out.println(kifisia_mid[i]);
						}
					}
				} else if (j == 2) {
					if (i == 0) {
						System.out.println("Γ' ΤΑΞΗ:");
					}
					if (kifisia_mid[i] != null) {
						if (kifisia_mid[i].getBirthYear() == 2007) {
							System.out.println(kifisia_mid[i]);
						}
					}
				}
			}
		}
	}

	public void deleteMid(int delete_id) {
		boolean found = false;
		boolean covid = false;
		int keep = -1;
		for (int i = 0; i < kifisia_mid.length; i++) {
			if (kifisia_mid[i] != null) {
				if (kifisia_mid[i].getID() == delete_id) {
					if (kifisia_mid[i].getCovidStatus() == true) {
						covid = true;
						keep = kifisia_mid[i].getClassMid();
					}
					counters_mid[kifisia_mid[i].getClassMid()]--;
					kifisia_mid[i] = null;
					found = true;
					System.out.println("Η διαγραφή του μαθητή πραγματοποιήθηκε.");
				}
			}
		}
		if (found == false) {//Αν δεν βρεθεί το ID 
			System.out.println("Το ID που δώσατε δεν αντιτοιχεί σε κάποιον μαθητή.");
			System.out.println("Οι μαθητές του γυμνασίου είναι:");
			display();
		} else {
			if (covid == true) {
				boolean more = false;
				for (int i = 0; i < kifisia_mid.length; i++) {
					if (kifisia_mid[i] != null) {
						if (kifisia_mid[i].getClassMid() == keep) {
							if (kifisia_mid[i].getCovidStatus() == true) {
								more = true;
							}
						}
					}
				}
				if (more == false) {
					classes_mid[keep] = false;
				}
				counter_covid_mid--;
				if (teacher == false) {
					if(counter_covid_mid == 2) {
						System.out.println("Το γυμνάσιο ξανά ξεκίνησε την λειτουργεία του.");
					}
				}
			}
		}
	}

	public void covidStatus() {
		if (teacher == false) {//Άμα δεν είναι κλειστό το γυμνάσιο λόγω του προσωπικού του
			if (counter_covid_mid != 0) {	
				if (counter_covid_mid >= 3) {
					System.out.println("ΚΛΕΙΣΤΟ ΟΛΟ ΤΟ ΓΥΜΝΑΣΙΟ.\nΑΝΑΛΥΤΙΚΟΤΕΡΑ ΤΑΞΕΙΣ ΜΕ ΚΡΟΥΣΜΑΤΑ:");
				}
				for (int i = 0; i < classes_mid.length; i++) {
					if (classes_mid[i] == true) {
						if (i == 0) {
							System.out.println("Α' ΤΑΞΗ ΓΥΜΝΑΣΙΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
						} else if (i == 1) {
							System.out.println("Β' ΤΑΞΗ ΓΥΜΝΑΣΙΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
						} else {
							System.out.println("Γ' ΤΑΞΗ ΓΥΜΝΑΣΙΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
						} 
					}
				}
			} else {
				System.out.println("Δεν υπάρχει κάποιο κρούσμα στις τάξεις του γυμνασίου.");
			}
		} else {
			System.out.println("ΚΛΕΙΣΤΟ ΟΛΟ ΤΟ ΓΥΜΝΑΣΙΟ ΚΑΘΩΣ ΒΡΕΘΗΚΕ ΚΑΘΗΓΗΤΗΣ ΘΕΤΙΚΟΣ ΣΤΟΝ COVID.");
		}
	}

	public void covidChange(int covid_id, int mode) {
		boolean flag = false;
		int keep = 0;
		for (int i = 0; i < kifisia_mid.length; i++) {
			if (kifisia_mid[i] != null) {
				if (kifisia_mid[i].getID() == covid_id) {
					flag = true;
					keep = i;
					i = kifisia_mid.length - 1;
				}
			}
		}
		if (flag == true) {
			if (mode == 5) {
				if (kifisia_mid[keep].getCovidStatus() == true) {
					System.out.println("Είναι ήδη θετικός.");
				} else {
					kifisia_mid[keep].setCovidStatus(true);
					if (classes_mid[kifisia_mid[keep].getClassMid()] == false) {
						classes_mid[kifisia_mid[keep].getClassMid()] = true;
					}
				counter_covid_mid++;
				}
			} else {
				if (kifisia_mid[keep].getCovidStatus() == false) {
					System.out.println("Είναι ήδη αρνητικός ο μαθητής.");
				} else {
					kifisia_mid[keep].setCovidStatus(false);
					boolean more = false;
					for (int i = 0; i < kifisia_mid.length; i++) {
						if (kifisia_mid[i] != null) {
							if (kifisia_mid[i].getClassMid() == kifisia_mid[keep].getClassMid()) {
								if (kifisia_mid[i].getCovidStatus() == true) {
									more = true;
								}
							}
						}
					}
					if (more == false) {
						classes_mid[kifisia_mid[keep].getClassMid()] = false;
					}
					counter_covid_mid--;
					if (teacher == false) {
						if(counter_covid_mid == 2) {
							System.out.println("Το γυμνάσιο ξανά ξεκίνησε την λειτουργεία του.");
						}
					}
				}
			}
		} else {
			System.out.println("Δόθηκε ID μη υπάρχοντος μαθητή.");
			System.out.println("Οι μαθητές του γυμνασίου είναι:");
			display();
		}
	}

	public void covidChangeTeachers(boolean covid) {
		if (covid == true) {
			covid_teacher_counter++;
		} else {
			covid_teacher_counter--;
		}
		if (covid_teacher_counter == 0 && teacher == true) {//Αν δεν υπάρχουν άλλοι θετικοί καθηγητές
			teacher = covid;
		} else if (teacher == false) {
			teacher = covid;
		}
		if (teacher == true) {
			covidStatus();
		} else {
			if (covid_teacher_counter == 0) {
				if (counter_covid_mid < 3) {//Μετά γίνεται έλεγχος για το αν πέρα από το προσωπικό το γυμνάσιο είναι έτοιμο να ανοίξει πάλι
					System.out.println("Το γυμνάσιο ξανά ξεκίνησε την λειτουργεία του.");
					System.out.println("Όλοι οι καθηγητές δεν έχουν covid.");
				} else {
					System.out.println("Όλοι οι καθηγητές δεν έχουν covid, αλλά το γυμνάσιο θα παραμείνει κλειστό.");
					covidStatus();
				}
			}
		}
	}

	public void displayStudent(int id) {
		for (int i = 0; i < kifisia_mid.length; i++) {
			if (kifisia_mid[i] != null) {
				if (kifisia_mid[i].getCovidStatus() == false) {
					if (kifisia_mid[i].getID() == id) {
						System.out.println(kifisia_mid[i]);
						i = kifisia_mid.length - 1;
					}
				}
			}
		}
	}

	protected int getClassMid() {
		return class_mid;
	}
	
	public void setCovidStatus(boolean change) {
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
		return "Όνομα μαθητή: " + name + "\nID μαθητή: " + id + "\tΈτος γέννησης: " + 
					+ birthyear + "\tCovid: " + covid_status; 
	}
}

