package ergasia;

public class Teachers {
	private static Teachers[] elementaryteachers = new Teachers[6];
	private static Teachers[] middleteachers = new Teachers[10];
	private static Teachers[] highteachers = new Teachers[10];
	private static int c1 = 0;
	private static int c2 = 0;
	private static int c3 = 0;
	private static int tcid; /* 4000-4999*/ /*Ως 4300 δημ , ως 4700 , γυμν ,ως 4999 λυκ*/
	private String name;
	private int classes; /* από 0 έως 5 είναι οι τάξεις του δημοτικού και 6-8 είναι γυμνάσιο και 9-11 λύκειο */
	private boolean covid_status;
	public static int counter_covidel;
	public static int counter_covidmid;
	public static int counter_covidhi;
	public static boolean fe = false;
	public static boolean fm = false;
	public static boolean fh = false;
	
	public Teachers () {
	}
	
	public Teachers(int data, int type, String name, int cl) {
		if (type == 1)  {
			if(data >= 4000 && data < 4300) {
				if (c1 < 6 ) {
					this.tcid = data;
					this.name = name;
					this.classes = cl;
					this.covid_status = false;
					elementaryteachers[c1] = this;
					c1++;
					System.out.println("Η εισαγωγή του καθηγητή έγινε επιτυχώς.");
				} else {
					System.out.println("Δεν υπάρχει άλλη χωρητικότητα για καθηγητές δημοτικού.");
				}
			}else {
			System.out.println("Ο αριθμός μητρώου του καθηγητή δημοτικού πρέπει να είναι από 4000 έως 4299");
			}
		}else if (type == 2) {
			if(data >= 4300 && data < 4700) {
				if (c2 < 10 ) {
					this.tcid = data;
					this.name = name;
					this.classes = cl;
					this.covid_status = false;
					middleteachers[c2] = this;
					c2++;
					System.out.println("Η εισαγωγή του καθηγητή έγινε επιτυχώς.");
				} else {
					System.out.println("Δεν υπάρχει άλλη χωρητικότητα για καθηγητές γυμνασίου.");
				}
			}else {
			System.out.println("Ο αριθμός μητρώου του καθηγητή γυμνασίου πρέπει να είναι από 4300 έως 4699");
			}
		} else if (type == 3){
			if(data >= 4700 && data < 5000) {
				if (c3 < 10 ) {
				this.tcid = data;
				this.name = name;
				this.classes = cl;
				this.covid_status = false;
				highteachers[c3] = this;
				c3++;
				System.out.println("Η εισαγωγή του καθηγητή έγινε επιτυχώς.");
			    } else {
				System.out.println("Δεν υπάρχει άλλη χωρητικότητα για καθηγητές λυκείου.");
			    }
			} else {
				System.out.println("Ο αριθμός μητρώου του καθηγητή λυκείου πρέπει να είναι από 4700 έως 4999");
			}
	    }	
		
	}
	public void covidChanget(int covid_id) {
			boolean flag = false;
			int k = 0;
			int mode = 0;
		if (tcid < 4300) {
			for (int i = 0; i < elementaryteachers.length; i++) {
				if (elementaryteachers[i] != null) {
					if (elementaryteachers[i].getTcid() == covid_id) {
						flag = true;
						if (elementaryteachers[i].isCovid_status() == false) {
							mode = 1;
						} else {
							mode = 2;
						}
						k = i;
						i = elementaryteachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 1) {
					elementaryteachers[k].setCovid_status(true);
					counter_covidel++;
				} else {
					elementaryteachers[k].setCovid_status(false);
					counter_covidel--;
				}
				if(counter_covidel == 2) {
					System.out.println("Το δημοτικό ξαναξεκίνησε την λειτουργεία του.");
				}
			}	
		} else if (tcid < 4700 ) {
			for (int i = 0; i < middleteachers.length; i++) {
				if (middleteachers[i] != null) {
					if (middleteachers[i].getTcid() == covid_id) {
						flag = true;
						if (middleteachers[i].isCovid_status() == false) {
							mode = 1;
						} else {
							mode = 2;
						}
						k = i;
						i = middleteachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 1) {
					middleteachers[k].setCovid_status(true);
					counter_covidel++;
				} else {
					middleteachers[k].setCovid_status(false);
					counter_covidel--;
				}
				if(counter_covidel == 0) {
					System.out.println("Το γυμνάσιο ξαναξεκίνησε την λειτουργεία του.");
				}
			}	
		} else {
			for (int i = 0; i < highteachers.length; i++) {
				if (highteachers[i] != null) {
					if (highteachers[i].getTcid() == covid_id) {
						flag = true;
						if (highteachers[i].isCovid_status() == false) {
							mode = 1;
						} else {
							mode = 2;
						}
						k = i;
						i = highteachers.length - 1;
					}
				}
			}
			if (flag == true) {
				if (mode == 1) {
					highteachers[k].setCovid_status(true);
					counter_covidel++;
				} else {
					highteachers[k].setCovid_status(false);
					counter_covidel--;
				}
				if(counter_covidel == 0) {
					System.out.println("Το λύκειο ξαναξεκίνησε την λειτουργεία του.");
				}
			}	
		}
			
	}
	public void covidStatus() {
		if(counter_covidel !=0) {
			if (tcid < 4300) {
			  for (int i = 0; i < elementaryteachers.length; i++) {
				if(elementaryteachers[i] != null) {
					if (elementaryteachers[i].isCovid_status() == true) {
						if(elementaryteachers[i].getClasses()==0) {
							System.out.println("\"Α' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						} else if (elementaryteachers[i].getClasses()==1) {
							System.out.println("\"B' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						} else if (elementaryteachers[i].getClasses()==2) {
							System.out.println("\"Γ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						}else if (elementaryteachers[i].getClasses()==3) {
							System.out.println("\"Δ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						}else if (elementaryteachers[i].getClasses()==4) {
							System.out.println("\"Ε' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						} else if (elementaryteachers[i].getClasses()==5) {
							System.out.println("\"ΣΤ' ΤΑΞΗ ΔΗΜΟΤΙΚΟΥ ΚΛΕΙΣΤΗ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
						} else {
							System.out.println("Μέχρι τώρα δεν υπάρχει κάποιο κρούσμα καθηγητή στις τάξεις του δημοτικού.");
						}	
					}
				  }
			  }
			} else if (tcid >= 4300 && tcid < 4700) {
				for (int i = 0; i < middleteachers.length; i++) {
						if(middleteachers[i] != null) {
							if (middleteachers[i].isCovid_status() == true) {
								if (middleteachers[i].getClasses() >= 6 && middleteachers[i].getClasses() <= 8) {
									System.out.println("\" ΤΟ ΓΥΜΝΑΣΙΟ ΚΛΕΙΣΤΟ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.\"");
								} else {
							       System.out.println("Μέχρι τώρα δεν υπάρχει κάποιο κρούσμα καθηγητή στις τάξεις του γυμνασίου.");
								}
							}
						}
				}
			} else {
				for (int i = 0; i < highteachers.length; i++) {
					if (highteachers[i]!=null) {
						if (highteachers[i].isCovid_status() == true) {
							if (highteachers[i].getClasses() <= 9 && highteachers[i].getClasses() >= 11 ) {
								System.out.println("ΤΟ ΛΥΚΕΙΟ ΚΛΕΙΣΤΟ ΜΕΧΡΙ ΝΕΩΤΕΡΑΣ ΛΟΓΩ ΚΡΟΥΣΜΑΤΟΣ ΕΚΠΑΙΔΕΥΤΙΚΟΥ.");
							} else {
								System.out.println("Μέχρι τώρα δεν υπάρχει κάποιο κρούσμα καθηγητή στις τάξεις του λυκείου.");
						    }
					   }
					} 
				}
			}
		}
	}
		
	
	public void display() {
		int e = 0 ;
		for(int i = 0 ; i < elementaryteachers.length ; i++ ) {
			if(elementaryteachers[i] != null) {
				System.out.println("Ο-Η καθηγητής-τρια της " + (elementaryteachers[i].getClasses() + 1) + " δημοτικού είναι ο-η " + elementaryteachers[i].getName());
			}else {
				e++;
			}
		}
		if (e <= 6 && e >= 1) {
			System.out.println("Το δημοτικό δεν έχει πληρότητα καθηγητών");
		}
		int m = 0;
		for(int i = 0 ; i < middleteachers.length ; i++ ) {
			if(middleteachers[i] == null) {
				m++;
			}else {
				System.out.println("Ο-Η καθηγητής-τρια του γυμνασίου είναι ο-η " + middleteachers[i].getName());
			}
		}
		if(m > 0) {
			System.out.println("Το γυμνάσιο δεν έχει πληρότητα καθηγητών");
		}
		int h = 0;
		for(int i = 0 ; i < highteachers.length ; i++ ) {
			if(highteachers[i] == null) {
				h++;
			}else {
				System.out.println("Ο-Η καθηγητής-τρια του λυκείου είναι ο-η " + highteachers[i].getName());
			}
		}
		if(h > 0) {
			System.out.println("Το λύκειο δεν έχει πληρότητα καθηγητών");
		}
	}
			
	public int getTcid() {
		return tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCovid_status() {
		return covid_status;
	}

	public void setCovid_status(boolean covid_status) {
		this.covid_status = covid_status;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
	}
	
	
}

