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
			System.out.println("------------------------------- ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ -------------------------------");
			System.out.println("==============================================================================");
			System.out.println("1. Εισαγωγή νέου μαθητή.\n"
							 + "2. Εμφάνιση μαθητών.\n"
							 + "3. Διαγραφή μαθητή.\n"
							 + "4. Εμφάνιση τρέχουσας κατάστασης σχολικών μονάδων.\n"
							 + "5. Εισαγωγή νέου κρούσματος.\n"
							 + "6. Αρνητικό αποτέλεσμα covid.\n"
							 + "7. Εισαγωγή νέου καθηγητή.");
			System.out.println("==============================================================================");
			System.out.println("Πατήστε το νούμερο της επιλογής που θα θέλατε να πραγματοποιηθεί.");
			System.out.println("Πατήστε το νούμερο \"8\" αν δεν θέλετε να διαλέξετε τελικά κάποια ενέργεια.");
			do {
				option = scanner_int.nextInt();
				if (option < 1 || option > 8) {
					System.out.println("Παρακαλώ ξανακοιτάξτε το ΜΕΝΟΥ ΕΠΙΛΟΓΩΝ και διαλέξτε ένα από τα νούμερα.");
					System.out.println("Πατήστε το νούμερο \"8\" αν δεν θέλετε να διαλέξετε τελικά κάποια ενέργεια.");
				}
			} while (option < 1 || option > 8);
			System.out.println("==============================================================================");
			if(option == 1) {
				System.out.println("ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΜΑΘΗΤΗ:");
				System.out.println("Δώστε το όνομα του μαθητή.");
				String name = scanner_string.nextLine();
				System.out.println("Δώστε το έτος γέννησης του μαθητή.");
				do {
					birthyear = scanner_int.nextInt();
					if (birthyear > 2015 || birthyear < 2004) {
						System.out.println("Αυτή η χρονιά δεν μπορεί να ταυτιστεί σε κάποια σχολική τάξη. Ξαναδώστε.");
					}
				} while (birthyear > 2015 || birthyear < 2004);
				System.out.println("Χρησιμοποιεί το σχολικό του Δήμου;"); // Ρωτάω αν χρησιμοποιεί το σχολικό 
				String answer = scanner_string.nextLine();
				int input;
				int type;
				if (birthyear >= 2010) {
					Elementary new_elementary = new Elementary(name, birthyear);
					input = new_elementary.getID(); //Χρειάζομαι το id του μαθητή για να τον εισάγω στα λεωφορεία
					type = 1; //καθώς και σε ποιό λεωφορείο ανήκει ανάλογα με το σχολείο του
				} else if (birthyear >= 2007) {
					Middle new_middle = new Middle(name, birthyear);
					input = new_middle.getID();
				    type = 2;
				} else {
					High new_high = new High(name, birthyear);
					input = new_high.getID();
					type = 3;
				}
				
				if (answer.equalsIgnoreCase("Ναι")) {
					Bus new_child = new Bus(input, type); // Αν χρησιμοποιεί το σχολικό τότε καλώ κατασκευαστή της κλάσης Bus ανάλογα με το σχολείο του
				}
			} else if (option == 2) {
				System.out.println("==============================================================================");
				System.out.println("ΔΗΜΟΤΙΚΟ");
				System.out.println("==============================================================================");
				key_el.display();
				System.out.println("==============================================================================");
				System.out.println("ΓΥΜΝΑΣΙΟ");
				System.out.println("==============================================================================");
				key_mid.display();
				System.out.println("==============================================================================");
				System.out.println("ΛΥΚΕΙΟ");
				System.out.println("==============================================================================");
				key_high.display();
			} else if (option == 3) {
				System.out.println("ΔΙΑΓΡΑΦΗ ΜΑΘΗΤΗ:");
				System.out.println("Δώστε το ID του μαθητή που θα θέλατε να διαγραφτεί.");
				do{
					delete = scanner_int.nextInt(); 
					if (delete > 3999 || delete < 1000) {
						System.out.println("Τα ID των μαθητών ξεκινάνε από το 1000 και φτάνουν ως το 3999. Ξαναδώστε.");
						System.out.println("ID δημοτικού: 1000-1999\nID γυμνασίου: 2000-2999\nID λυκείου: 3000-3999");
					}
				} while (delete > 3999 || delete < 1000);
				if (delete >= 1000 && delete <= 1999) {
					key_el.deleteEl(delete);//Δες μήπως μπορούν να έχουν το ίδιο όνομα όλες 
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
				System.out.println("Εισάγετε το ID του ατόμου που είναι θετικός στον κορονοιό.");
				do {
					covid = scanner_int.nextInt(); 
					if (covid > 4999 || covid < 1000) {
						System.out.println("Τα ID  ξεκινάνε από το 1000 και φτάνουν ως το 4999.");
						System.out.println("ID δημοτικού: 1000-1999\nID γυμνασίου: 2000-2999\nID λυκείου: 3000-3999\n καθηγητών: 4000-4999");
					}
				} while (covid > 4999 || covid < 1000);
				if (covid >= 1000 && covid <= 1999) {
					key_el.covidChange(covid);
					key_bus.findinbus(covid, 1); //Πλέον όταν εισάγεται ένα κρούσμα θα γίνεται άμεσα έλεγχος στο αντίστοιχο λεωφ και θα τυπώνεται το κατάλληλο μήνυμα
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
				System.out.println("Δώσε το ID ενός μαθητή με Covid-19 που βγήκε αρνητικός στο επόμενο τεστ.");
				do {
					covid_del = scanner_int.nextInt(); 
					if (covid_del > 3999 || covid_del < 1000) {
						System.out.println("Τα ID των μαθητών ξεκινάνε από το 1000 και φτάνουν ως το 3999.");
						System.out.println("ID δημοτικού: 1000-1999\nID γυμνασίου: 2000-2999\nID λυκείου: 3000-3999");
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
				System.out.println("ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΚΑΘΗΓΗΤΗ:");
				System.out.println("Δώστε το όνομα του καθηγητή.");
				String name = scanner_string.nextLine();
				System.out.println("Δώστε 1 για δημοτικό, 2 για γυμνάσιο ή 3 για λύκειο.");
				int type = scanner_int.nextInt();
				System.out.println("Δώστε αριθμό μητρώου");
				int tid = scanner_int.nextInt();
				System.out.println("Δώστε τάξη διδασκαλίας.");
				int classes = scanner_int.nextInt();
				Teachers new_teacher = new Teachers(tid,type,name,classes);
				key_teachers.display();
			}/*else if (option == 8) {
			 	*/
		} while(option != 8);
	}
}
