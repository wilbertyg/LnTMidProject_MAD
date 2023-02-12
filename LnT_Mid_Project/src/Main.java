//LnTMidProject_Mobile-C_Wilbert Yang
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		Vector<Car> cars = new Vector<>();
		Vector<Motorcycle> motor = new Vector<>();
		String vType;
		int choice = 0, numCar = 0, numMotor = 0;
		while (true) {
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.println("3. Exit Program");
			System.out.print("[Input]:");
			choice = scan.nextInt(); scan.nextLine();
			if (choice == 1) {
				vType = typeGet();
				if (vType.equalsIgnoreCase("car")) {
					numCar++;
					cars.add(new Car(vType));
				} else {
					numMotor++;
					motor.add(new Motorcycle(vType));
				}
				System.out.print("ENTER to return");
				scan.nextLine();
			} else if (choice == 2) {
				System.out.println("|----|--------------------|--------------------|");
				System.out.println("|No  |Type                |Name                |");
				System.out.println("|----|--------------------|--------------------|");
				for (int i = 0; i < numCar; i++) {
					System.out.printf("|%-4d|%-20s|%-20s|\n", i+1, cars.get(i).vType, cars.get(i).vName);
				}
				System.out.println("|----|--------------------|--------------------|");
				for (int i = 0; i < numMotor; i++) {
					System.out.printf("|%-4d|%-20s|%-20s|\n", i+numCar+1, motor.get(i).vType, motor.get(i).vName);
				}
				System.out.println("|----|--------------------|--------------------|");
				System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
				int choose = scan.nextInt(); scan.nextLine();
				if (choose >= 1 && choose <= numMotor + numCar) {
					System.out.println();
					if (choose > numCar) {
						int index = choose - numCar - 1;
						System.out.println("Brand: " + motor.elementAt(index).vBrand);
						System.out.println("Name: " + motor.elementAt(index).vName);
						System.out.println("License Plate: " + motor.elementAt(index).vLicense);
						System.out.println("Type: " + motor.elementAt(index).vSpeci);
						System.out.println("Gas Capacity: " + motor.elementAt(index).vGasCap);
						System.out.println("Top Speed: " + motor.elementAt(index).vTopSpeed);
						System.out.println("Wheel(s): " + motor.elementAt(index).vWheel);
						System.out.println("Helm: " + motor.elementAt(index).helmet);
						motor.elementAt(index).ent();
						System.out.print("\nHelmet price: ");
						int priceHelmet = scan.nextInt(); scan.nextLine();
						System.out.println("Price: <Motorcycle Price> + " + priceHelmet * motor.elementAt(index).helmet);
					} else {
						int index = choose - 1;
						System.out.println("Brand: " + cars.elementAt(index).vBrand);
						System.out.println("Name: " + cars.elementAt(index).vName);
						System.out.println("License Plate: " + cars.elementAt(index).vLicense);
						System.out.println("Type: " + cars.elementAt(index).vSpeci);
						System.out.println("Gas Capacity: " + cars.elementAt(index).vGasCap);
						System.out.println("Top Speed: " + cars.elementAt(index).vTopSpeed);
						System.out.println("Wheel(s): " + cars.elementAt(index).vWheel);
						System.out.println("Entertainment System: " + cars.elementAt(index).entertainmentSystem);
						cars.elementAt(choose - 1).ent();
					}
					System.out.print("ENTER to continue");
					scan.nextLine();
				}
			} else if (choice == 3) {
				break;
			}
			System.out.println("\n");
		}
	}
	static String typeGet() {
		boolean x = false;
		String vTypex = new String();
		while (!x) {
			System.out.print("Input type [Car | Motorcycle]: ");
			vTypex = scan.nextLine();
			if (vTypex.equalsIgnoreCase("car") || vTypex.equalsIgnoreCase("motorcycle")) {
				x = true;
			}
		}
		return (vTypex.equalsIgnoreCase("car")? "Car" : "Motorcycle");
	}
}
