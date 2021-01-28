
public class Bus {
	public static Bus[] elementarybus = new Bus[50];
	public static Bus[] middlebus = new Bus[50];
	public static Bus[] highbus = new Bus[50];
	private static int counterone = 0;
	private static int countertwo = 0;
	private static int counterthree = 0;
	private int id;
	
	public Bus() {
	}

	public Bus(int id, int type) {
		if (type == 1) {
			if (counterone < 50 ) {
				this.id = id;
				elementarybus[counterone] = this;
				counterone++;
				System.out.println("Η εισαγωγή του μαθητή στο σχολικό έγινε επιτυχώς.");
			} else {
				System.out.println("Δεν υπάρχει άλλη χωρητικότητα στο σχολικό του δημοτικού.");
			}
		} else if (type == 2) {
			if (countertwo < 50 ) {
				this.id = id;
				middlebus[countertwo] = this;
				countertwo++;
				System.out.println("Η εισαγωγή του μαθητή στο σχολικό έγινε επιτυχώς.");
			} else {
				System.out.println("Δεν υπάρχει άλλη χωρητικότητα στο σχολικό του γυμνασίου.");
			}
		} else {
			if (counterthree < 50 ) {
				this.id = id;
				highbus[counterthree] = this;
				counterthree++;
				System.out.println("Η εισαγωγή του μαθητή στο σχολικό έγινε επιτυχώς.");
			} else {
				System.out.println("Δεν υπάρχει άλλη χωρητικότητα στο σχολικό του λυκείου.");
			}
		}
	}
	
	public void fillBus(int id, int type) {
		if (type == 1) {
			this.id = id;
			elementarybus[counterone] = this;
			counterone++;
		} else if (type == 2) {
			this.id = id;
			middlebus[countertwo] = this;
			countertwo++;
		} else {
			this.id = id;
			highbus[counterthree] = this;
			counterthree++;
		}
	}
	
	
	public void findinbus(int cid, int type) {
		boolean flag = false;
		int keep = -1;
		if(type == 1) {
			for (int i = 0 ; i < elementarybus.length; i++) {
				if (elementarybus[i] != null) {
					if (elementarybus[i].id == cid) {
						flag = true;
						keep = 0;
						System.out.println("Βρέθηκε κρούσμα σε μαθητή που χρησιμοποιεί το σχολικό του δημοτικού, παρακαλούνται όλοι οι συνεπιβάτες να προβούν σε COVID-TEST");
					}
				}
			}
		} else if (type== 2) {
			for (int i = 0 ; i < middlebus.length; i++) {
				if (middlebus[i] != null) {
					if (middlebus[i].id == cid) {
						flag = true;
						keep = 1;
						System.out.println("Βρέθηκε κρούσμα σε μαθητή που χρησιμοποιεί το σχολικό του γυμνασίου, παρακαλούνται όλοι οι συνεπιβάτες να προβούν σε COVID-TEST");
					}
				}
			}
		} else {
			for (int i = 0 ; i < highbus.length; i++) {
				if (highbus[i] != null) {
					if (highbus[i].id == cid) {
						flag = true;
						keep = 2;
						System.out.println("Βρέθηκε κρούσμα σε μαθητή που χρησιμοποιεί το σχολικό του λυκείου, παρακαλούνται όλοι οι συνεπιβάτες να προβούν σε COVID-TEST");
					}
				}
			}
		}
		if (flag == false) {
			System.out.println("Το κρούσμα δεν επηρεάζει τη λειτουργία των σχολικών λεωφορείων");
		} else {
			Elementary el = new Elementary();
			Middle mid = new Middle();
			High high = new High();
			System.out.println("ΝΑ ΕΛΕΓΧΟΥΝ ΟΙ ΣΥΝΕΠΙΒΑΤΕΣ ΠΟΥ ΕΙΝΑΙ ΟΙ ΕΞΗΣ:");
			if (keep == 0) {
				for (int i = 0; i < elementarybus.length; i++) {
					if (elementarybus[i] != null) {
						el.displayStudent(elementarybus[i].getId());
					}
				}
			} else if (keep == 1) {
				for (int i = 0; i < middlebus.length; i++) {
					if (middlebus[i] != null) {
						mid.displayStudent(middlebus[i].getId());
					}
				}
			} else if (keep == 2) {
				for (int i = 0; i < highbus.length; i++) {
					if (highbus[i] != null) {
						high.displayStudent(highbus[i].getId());
					}
				}
			}
		}
	}

	private int getId() {
		return id;
	}

}
