//LnTMidProject_Mobile-C_Wilbert Yang
import java.util.Scanner;

public class Vehicle { //abstract
	String vType, vBrand, vName, vLicense, vSpeci;
	int vTopSpeed, vGasCap, vWheel;
	static Scanner scan = new Scanner(System.in);
	public void ent() {
		System.out.println("Vehicle has entertainment system");
	}
	static String brandGet() {
		boolean x = false;
		String vStr = new String();
		while (!x) {
			System.out.print("Input brand [>= 5]: ");
			vStr = scan.nextLine();
			if (vStr.length() >= 5) {
				x = true;
			}
		}
		if (vStr.charAt(0) <= 'z' && vStr.charAt(0) >= 'a') {
			vStr = vStr.substring(0, 1).toUpperCase() + vStr.substring(1);
		}
		return vStr;
	}
	static String nameGet() {
		boolean x = false;
		String vStr = new String();
		while (!x) {
			System.out.print("Input name [>= 5]: ");
			vStr = scan.nextLine();
			if (vStr.length() >= 5) {
				x = true;
			}
		}
		if (vStr.charAt(0) <= 'z' && vStr.charAt(0) >= 'a') {
			vStr = vStr.substring(0, 1).toUpperCase() + vStr.substring(1);
		}
		return vStr;
	}
	static String licenseGet() {
		boolean x = false;
		String vLicensee = new String();
		while (!x) {
			boolean c = true;
			System.out.print("Input license: ");
			vLicensee = scan.nextLine();
			int len = vLicensee.length();
			if (!((vLicensee.charAt(0) >= 'A' && vLicensee.charAt(0) <= 'Z' || vLicensee.charAt(0) >= 'a' && vLicensee.charAt(0) <= 'z') && vLicensee.charAt(1) == ' ')) {
				c = false;
			}
			int count;
			for (count = 2; count < 7 && c; count++) {
				if (!(vLicensee.charAt(count) >= '0' && vLicensee.charAt(count) <= '9') && vLicensee.charAt(count) != ' ' || count > len -1) {
					c = false;
					break;
				} else if (vLicensee.charAt(count) == ' ') {
					count++;
					break;
				} else if (count == 6){
					c = false;
					break;
				}
			}
			if (len - count -1 >= 3 || len - count -1 < 0) {
				c = false;
			}
			for (; count < len && c; count++) {
				if (!(vLicensee.charAt(count) >= 'A' && vLicensee.charAt(count) <= 'Z' || vLicensee.charAt(count) >= 'a' && vLicensee.charAt(count) <= 'z' )) {
					c = false;
					break;
				}
			}
			if (c) {
				x = true;
			}
		}
		return vLicensee.toUpperCase();
	}
	static int speedGet() {
		boolean x = false;
		int vTopSpeedd = 0;
		while (!x) {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			vTopSpeedd = scan.nextInt(); scan.nextLine();
			if (vTopSpeedd >= 100 && vTopSpeedd <= 250) {
				x = true;
			}
		}
		return vTopSpeedd;
	}
	static int capGet() {
		boolean x = false;
		int cap = 0;
		while (!x) {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			cap = scan.nextInt(); scan.nextLine();
			if (cap <= 60 && cap >= 30) {
				x = true;
			}
		}
		return cap;
	}
}

class Car extends Vehicle { //inheritance
	int entertainmentSystem;
	public void ent() { // override
		if (vSpeci.equalsIgnoreCase("supercar")) {
			System.out.println("Boosting!");
		} else {
			System.out.println("Turning on entertainment system...");
		}
	}
	static int wheels() {
		while (true) {
			System.out.print("Input wheel [4 <= wheel <= 6]: ");
			int wheels = scan.nextInt(); scan.nextLine();
			if (wheels >= 4 && wheels <= 6) {
				return wheels;
			}
		}
	}
	public String getSpeci() {
		while (true) {
			boolean b = false;
			System.out.print("Input type [SUV | Supercar | Minivan]: ");
			String x = scan.nextLine();
			if (x.equalsIgnoreCase("suv") || x.equalsIgnoreCase("supercar") || x.equalsIgnoreCase("minivan")) {
				b = true;
			}
			if (b) {
				if (x.equalsIgnoreCase("SUV")) {
					x = x.toUpperCase();
				} else {
					x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
				}
				return x;
			}
		}
	}
	public int getEnt() {
		while (true) {
			System.out.print("Input entertainment system amount [>= 1]: ");
			int ent = scan.nextInt(); scan.nextLine();
			if (ent >= 1) {
				return ent;
			}
		}
	}
 	public Car(String type) {
		vType = type;
		vBrand = brandGet();
		vName = nameGet();
		vLicense = licenseGet();
		vTopSpeed = speedGet();
		vGasCap = capGet();
		vWheel = wheels();
		vSpeci = getSpeci();
		entertainmentSystem = getEnt();
	}
}

class Motorcycle extends Vehicle { //inheritance
	int helmet;
	public void ent() { //override
		System.out.println(vName + " is standing!");
	}
	static int wheels() {
		while (true) {
			System.out.print("Input wheel [2 <= wheel <= 3]: ");
			int wheels = scan.nextInt(); scan.nextLine();
			if (wheels <= 3 && wheels >= 2) {
				return wheels;
			}
		}
	}
	public int getHelm() {
		while (true) {
			System.out.print("Input helmet amount [>= 1]: ");
			int helm = scan.nextInt(); scan.nextLine();
			if (helm >= 1) {
				return helm;
			}
		}
	}
	public String getSpeci() {
		while (true) {
			boolean b = false;
			System.out.print("Input type [Automatic | Manual]: ");
			String x = scan.nextLine();
			if (x.equalsIgnoreCase("automatic") || x.equalsIgnoreCase("manual")) {
				b = true;
			}
			if (b) {
				x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
				return x;
			}
		}
	}
	public Motorcycle(String type) {
		vType = type;
		vBrand = brandGet();
		vName = nameGet();
		vLicense = licenseGet();
		vTopSpeed = speedGet();
		vGasCap = capGet();
		vWheel = wheels();
		vSpeci = getSpeci();
		helmet = getHelm();
	}
}
