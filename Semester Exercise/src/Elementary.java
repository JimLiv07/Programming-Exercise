
public class Elementary {

private static Elementary[] kifisia_el = new Elementary[150];//Ο πίνακας με τους μαθητές του Δημοτικού
private static int counter_el = 0;
private static int counter_covid_el = 0;
private static boolean classes_el[] = { false, false, false, false, false, false };// Η κατάσταση των τάξεων, δηλαδή άμα είναι ανοιχτές ή κλειστές
private static int counters_el[] = { 0, 0, 0, 0, 0, 0 }; //Πόσα άτομα υπάρχουν σε κάθε τάξη
private String name;
private int id;
private int class_el;
private int birthyear;
private boolean covid_status;
private static boolean start = false;//Για να μην εμφανίζει τα μηνύματα στις εισαγωγές των create

	public Elementary() { 
	}

	public Elementary(String name, int birthyear) {
		if (counters_el[findClass(birthyear)] < 25 ) {//Το κάθε τμήμα έχει μέχρι 25 άτομα
			this.name = name;
			this.birthyear = birthyear;
			this.id = 1000 + counter_el;
			this.covid_status = false;
			this.class_el = findClass(birthyear);
			counters_el[class_el] = counters_el[class_el] + 1;
			kifisia_el[counter_el] = this;
			counter_el++;
			if (start == false) {
				System.out.println("Η εισαγωγή του μαθητή έγινε επιτυχώς.");
			}
		} else {
			System.out.println("Δεν υπάρχει άλλη χωρητικότητα σε αυτήν την τάξη.");
		}
	}

	public void create() {
		start = true;
		Elementary student1 = new Elementary("Ειρήνη Μπαρκάτσα", 2010);
		new Bus().fillBus(kifisia_el[0].getID(), 1);
		Elementary student2 = new Elementary("Penelope Duckling", 2010);
		Elementary student3 = new Elementary("Δημήτρης Τσιμπούκης", 2010);
		Elementary student4 = new Elementary("Αλέξανδρος Δούκογλου", 2010);
		Elementary student5 = new Elementary("Χαράλαμπος Ρεκτόπουλος", 2010);
		Elementary student6 = new Elementary("Νίκος Ζαγοραίος", 2011);
		new Bus().fillBus(kifisia_el[5].getID(), 1);
		Elementary student7 = new Elementary("Νότης Σφακιανάκης", 2011);
		Elementary student8 = new Elementary("Ντόναλντ Τραμπ", 2011);
		Elementary student9 = new Elementary("Τζο Μπάιντεν", 2011);
		Elementary student10 = new Elementary("Κάμαλα Χαρρις", 2011);
		Elementary student11 = new Elementary("Αρτέμης Σώρρας", 2012);
		Elementary student12 = new Elementary("Μπόμπ Μάρλει", 2012);
		new Bus().fillBus(kifisia_el[11].getID(), 1);
		Elementary student13 = new Elementary("Μπόμπ Σφουγγαράκης Τετραγωνοπαντελονής", 2012);
		Elementary student14 = new Elementary("Μπράντ Πιτ", 2012);
		Elementary student15 = new Elementary("Εφη Θώδη", 2012);
		Elementary student16 = new Elementary("Γιαννης Αντετοκούνμπο", 2013);
		new Bus().fillBus(kifisia_el[15].getID(), 1);
		Elementary student17 = new Elementary("Θανάσης Αντετοκούνμπο", 2013);
		Elementary student18 = new Elementary("Κώστας Αντετοκούνμπο", 2013);
		Elementary student19 = new Elementary("Άλεξ Αντετοκούνμπο", 2013);
		Elementary student20 = new Elementary("Λεμπρόν Τζέιμς", 2013);
		Elementary student21 = new Elementary("Μοχάμαντ Άλι", 2014);
		new Bus().fillBus(kifisia_el[20].getID(), 1);
		Elementary student22 = new Elementary("Τζο Φρέιζερ", 2014);
		Elementary student23 = new Elementary("Τζο Λιούις", 2014);
		Elementary student24 = new Elementary("Τζόρτζ Φόρμαν", 2014);
		Elementary student25 = new Elementary("Μάικ Τάισον", 2014);
		Elementary student26 = new Elementary("Λιονέλ Μεσσίας", 2015);
		new Bus().fillBus(kifisia_el[25].getID(), 1);
		Elementary student27 = new Elementary("Σωτήρης Αλεξανδρόπουλος", 2015);
		Elementary student28 = new Elementary("Σωσκράτης Διούδης", 2015);
		Elementary student29 = new Elementary("Κριστιάνο Ρονάλντο", 2015);
		new Bus().fillBus(kifisia_el[28].getID(), 1);
		Elementary student30 = new Elementary("Μάρτιν Μπρέθγουειτ", 2015);
		new Bus().fillBus(kifisia_el[29].getID(), 1);
		start = false;
	}

	private int findClass(int year) {//Γίνεται εύρεση της κλάσης από το έτος γέννησης
		if (year == 2010) {
			return 5;
		} else if (year == 2011) {
			return 4;
		} else if (year == 2012) {
			return 3;
		} else if (year == 2013) {
			return 2;
		} else if (year == 2014) {
			return 1;
		} else {
			return 0;
		}
	}

	public void display() {
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < kifisia_el.length; i++) {
				if (j == 0) {
					if (i == 0) {//Θα εμφανίζεται η τάξη με αυτόν τον έλεγχο μόνο μία φορά στην αρχή 
						System.out.println("Α' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2015) {
							System.out.println(kifisia_el[i]);
						}
					}
				} else if (j == 1) {
					if (i == 0) {
						System.out.println("Β' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2014) {
							System.out.println(kifisia_el[i]);
						}
					}
				} else if (j == 2) {
					if (i == 0) {
						System.out.println("Γ' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2013) {
							System.out.println(kifisia_el[i]);
						}
					}
				} else if (j == 3) {
					if (i == 0) {
						System.out.println("Δ' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2012) {
							System.out.println(kifisia_el[i]);
						}
					}
				} else if (j == 4) {
					if (i == 0) {
						System.out.println("Ε' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2011) {
							System.out.println(kifisia_el[i]);
						}
					}
				} else if (j == 5) {
					if (i == 0) {
						System.out.println("ΣΤ' ΤΑΞΗ:");
					}
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getBirthYear() == 2010) {
							System.out.println(kifisia_el[i]);
						}
					}
				}
			}
		}
	}

	public void deleteEl(int delete_id) {
		boolean found = false;
		boolean covid = false;
		int keep = -1;//Έστω να κρατήσουμε την τάξη του μαθητή πριν διαγραφτεί 
		for (int i = 0; i < kifisia_el.length; i++) {
			if (kifisia_el[i] != null) {
				if (kifisia_el[i].getID() == delete_id) {
					if (kifisia_el[i].getCovidStatus() == true) {//Αν ο μαθητής που πάει να διαγραφτεί έχει covid
						covid = true;
						keep = kifisia_el[i].getClassEl();
					}
					counters_el[kifisia_el[i].getClassEl()]--;//Μείωση των ατόμων σε αυτό το τμήμα
					kifisia_el[i] = null;
					found = true;
					System.out.println("Η διαγραφή του μαθητή πραγματοποιήθηκε.");
				}
			}
		}
		if (found == false) {//Αν δεν βρεθεί το ID 
			System.out.println("Το ID που δώσατε δεν αντιτοιχεί σε κάποιον μαθητή.");
			System.out.println("Οι μαθητές του δημοτικού είναι:");
			display();
		} else {
			if (covid == true) {
				boolean more = false;//Έλεγχος άμα υπάρχουν στο ίδιο τμήμα και άλλα κρούσματα
				for (int i = 0; i < kifisia_el.length; i++) {
					if (kifisia_el[i] != null) {
						if (kifisia_el[i].getClassEl() == keep) {
							if (kifisia_el[i].getCovidStatus() == true) {
								more = true;
							}
						}
					}
				}
				if (more == false) {//Αν υπάρχουν και άλλα τμήματα να μην αλλάξει το status της τάξης
					classes_el[keep] = false;
				}
				counter_covid_el--;
				if(counter_covid_el == 2) {
					System.out.println("Το δημοτικό ξανά ξεκίνησε την λειτουργεία του.");
				}
			}
		}
	}

	public void covidStatus() {
		if (counter_covid_el != 0) {	
			if (counter_covid_el >= 3) {//Σε περίπτωση που υπάρχουν πάνω από 3 κρούσματα 
				System.out.println("ΚΛΕΙΣΤΟ ΟΛΟ ΤΟ ΔΗΜΟΤΙΚΟ.\nΑΝΑΛΥΤΙΚΟΤΕΡΑ ΤΑΞΕΙΣ ΜΕ ΚΡΟΥΣΜΑΤΑ:");
			}
			for (int i = 0; i < classes_el.length; i++) {//Κάθε τάξη με κρούσμα
				if (classes_el[i] == true) {
					if (i == 0) {
						System.out.println("Α' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					} else if (i == 1) {
						System.out.println("Β' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					} else if (i == 2) {
						System.out.println("Γ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					} else if (i == 3) {
						System.out.println("Δ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					} else if (i == 4) {
						System.out.println("Ε' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					} else {
						System.out.println("ΣΤ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ.");
					}
				}
			}
		} else {//Σε περίπτωση που δεν υπάρχει κάποιο κρούσμα
			System.out.println("Δεν υπάρχει κάποιο κρούσμα στις τάξεις του δημοτικού.");
		}
	}

	public void covidChange(int covid_id, int mode) { 
		boolean flag = false; 
		int keep = 0;
		for (int i = 0; i < kifisia_el.length; i++) {
			if (kifisia_el[i] != null) {
				if (kifisia_el[i].getID() == covid_id) {
					flag = true;
					keep = i;
					i = kifisia_el.length - 1;//Για να τερματίσει πρόωρα η επανάληψη με το που βρεθεί το ζητούμενο 
				}
			}
		}
		if (flag == true) {
			if (mode == 5) {//Πρόσθεση κρούσματος
				if (kifisia_el[keep].getCovidStatus() == true) {
					System.out.println("Είναι ήδη θετικός ο μαθητής.");
				} else {
					kifisia_el[keep].setCovidStatus(true);
					if (classes_el[kifisia_el[keep].getClassEl()] == false) {
						classes_el[kifisia_el[keep].getClassEl()] = true;
					}
					counter_covid_el++;
				}
			} else {//Αφαίρεση κρούσματος
				if (kifisia_el[keep].getCovidStatus() == false) {
					System.out.println("Είναι ήδη αρνητικός ο μαθητής.");
				} else {
					kifisia_el[keep].setCovidStatus(false);
					boolean more = false;//Έλεγχος για το αν υπάρχουν στο ίδιο τμήμα και άλλα κρούσματα
					for (int i = 0; i < kifisia_el.length; i++) {
						if (kifisia_el[i] != null) {
							if (kifisia_el[i].getClassEl() == kifisia_el[keep].getClassEl()) {
								if (kifisia_el[i].getCovidStatus() == true) {
									more = true;
								}
							}
						}
					}
					if (more == false) {
						classes_el[kifisia_el[keep].getClassEl()] = false;
					}
					counter_covid_el--;
					if(counter_covid_el == 2) {//Όταν πάει από τα 3 κρούσματα στα 2 ξαναξεκινάει η λειτουργία
						System.out.println("Το δημοτικό ξανά ξεκίνησε την λειτουργεία του.");
					}
				}
			}
		} else {
			System.out.println("Δόθηκε ID μη υπάρχοντος μαθητή.");
			System.out.println("Οι μαθητές του δημοτικού είναι:");
			display();
		}
	}

	public void covidChangeTeachers(boolean covid, int cl) {
		if (covid == true) {//Ο δάσκαλος συμπεριφέρεται με παρόμοιο τρόπο όπως οι μαθητές στο δημοτικό
			counter_covid_el++;
			classes_el[cl] = true;
		} else {
			boolean more = false;
			for (int i = 0; i < kifisia_el.length; i++) {
				if (kifisia_el[i] != null) {
					if (kifisia_el[i].getClassEl() == cl) {
						if (kifisia_el[i].getCovidStatus() == true) {
							more = true;
						}
					}
				}
			}
			if (more == false) {
				classes_el[cl] = false;
			}
			counter_covid_el--;
			if(counter_covid_el == 2) {
				System.out.println("Το δημοτικό ξανά ξεκίνησε την λειτουργεία του.");
			}
		}
	}

	public void displayStudent(int id) {
		for (int i = 0; i < kifisia_el.length; i++) {
			if (kifisia_el[i] != null) {
				if (kifisia_el[i].getCovidStatus() == false) {
					if (kifisia_el[i].getID() == id) {
						System.out.println(kifisia_el[i]);
						i = kifisia_el.length - 1;
					}
				}
			}
		}
	}

	private int getClassEl() {
		return class_el;
	}
	
	private void setCovidStatus(boolean change) {
		covid_status = change;
	}
	
	private boolean getCovidStatus() {
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
