package problemfive;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AirlineReservation app = new AirlineReservation();

		char toContinue = 0;

		do {
			System.out.println("*************Airline Booking System*************");
			System.out.println("1. Display seating chart");
			System.out.println("2. Book a seat"); 
			System.out.println("3. Cancel a seat by name"); 
			System.out.println("4. Get seat number by name"); 
			System.out.println("5. Total seats on each row"); 
			System.out.println("6. Search N consecutive seats"); 
			System.out.println("7. Randomly relocate seats"); 
			System.out.println("x. Exit");

			app.printLines();
			System.out.print("Provide your option to continue: ");
			char menuOption = sc.next().charAt(0);

			switch(menuOption) {

			case 49: 
			{
				app.printLines();
				System.out.println("1.Show full view\n2.Show specific range of rows");
				int option = sc.nextInt();
				switch(option) {
				case 1:
					app.displaySeats();
					break;
				case 2:
				{
					System.out.println("Row range(1-12)");

					System.out.println("Enter first row: ");
					int firstRow = sc.nextInt();

					System.out.println("Enter last row: ");
					int lastRow = sc.nextInt();
					app.displaySeats(firstRow, lastRow);
					break;
				}
				default:
					System.out.println("Please provide a valid option!");
				}
				app.printLines();
				break;
			}
			case 50:
			{
				app.printLines();

				String passengerName = "";
				System.out.print("Enter your name: ");
				passengerName = sc.next();

				String[] prefSeat; 
				System.out.println("Specify seat number like: [row number]-[seat number]");
				System.out.print("Enter your preferred seat: ");
				prefSeat = sc.next().split("-");

				if(app.bookSeats(passengerName, prefSeat)) {
					System.out.println("Your seat has been successfully booked. Have a pleasant flight!");
				} else {
					System.out.println("Your preferred seat is not available");
				}
				break;
			}
			case 51:
			{
				app.printLines();
				System.out.println("Enter your name: ");
				String searchName = sc.next();
				app.removeBookedSeat(searchName);
				System.out.println("Your seat has been cancelled!");
				break;
			}

			case 52:
			{
				app.printLines();
				System.out.println("Enter your name: ");
				String passName = sc.next();
				String searchName = app.searchSeatByName(passName);
				if(searchName == null) {
					System.out.println("No seats available with this user");
				} else {
					System.out.println("Your seat number is " + searchName);
				}
				break;
			}

			case 53:
			{
				app.printLines();
				int[] seatsAvailablePerRow = app.seatsAvailablePerRow();
				System.out.println("Displaying seats available per row: ");
				for(int i = 1; i < seatsAvailablePerRow.length; i++) {
					System.out.println("Row " + i + "--> " + seatsAvailablePerRow[i]);
				}
				break;
			}

			case 54: 
			{
				app.printLines();
				System.out.print("Enter the number of consecutive seats wanted: ");
				int totalSeatsRequired = sc.nextInt();
				String seatNo = "";

				try {
					seatNo = app.searchNConsecutiveSeats(totalSeatsRequired);
					if(seatNo == null) {
						System.out.println("No, Seats Available! Try booking individual seats...");
					} else {
						System.out.println("Total " + totalSeatsRequired + " available from: " + seatNo);
					}
				} catch (IllegalColumnException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

			case 55:
			{
				app.printLines();
				System.out.println("Relocating passenger seats on random manner...");
				app.relocateRandomly();
				System.out.println("Done !!!");
				break;
			}

			case 120:
				app.printLines();
				System.out.println("Thank you for choosing our airline! Safe travels!");
				app.printLines();
				System.exit(0);

			default:
				System.out.println("Please provide a valid option!");
			}


			System.out.println("<------------------In Main menu------------------>");
			System.out.println("Do you want to continue?(y/N) ");
			toContinue = sc.next().charAt(0);

		} while(toContinue == 'y' || toContinue == 'Y');

		System.out.println("Exiting the app...");

		app.printLines();
		System.out.println("Thank you for choosing our airline! Safe travels!");
		app.printLines();

		sc.close();
	}
}