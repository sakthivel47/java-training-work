package problemfive;

import java.util.Random;

public class AirlineReservation {

	static int rows = 13, cols = 13;
	static String[][] seats = new String[rows][cols];

	/*
	 * Initializes the seats array by setting all elements to null.
	 */
	public static void startProcess() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				seats[i][j] = null;
			}
		}
	}

	/* Function - displaySeats()
	 * Displays the seats in a tabular format(full-view).
	 */
	public void displaySeats() {
		int labelRows = 0, labelCols = 0;
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++) {
				if(i == 0 && j == 0) {
					System.out.print("\t");
				} else if(i == 0) {
					System.out.print((char)(labelCols++ + 'A') + " ");
				} else if(j == 0) {
					System.out.print(++labelRows + "\t");
				} else {
					if(seats[i][j] == null) {
						System.out.print(". ");
					} else {
						System.out.print("x ");
					}
				}
			}
			System.out.println();
		}
	}

	/*
	 * Function - displaySeats(int firstRow, int lastRow)
	 * Description - Displays seats within the specified row range.
	 * Parameters - firstRow First row number (inclusive).
	 * lastRow  Last row number (inclusive).
	 */
	public void displaySeats(int firstRow, int lastRow) {

		int labelRows = firstRow, labelCols = 0;

		for(int i = firstRow-1; i <= lastRow; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == firstRow-1 && j == 0) {
					System.out.print("\t");
				} else if(i == firstRow-1) {
					System.out.print((char)(labelCols++ + 'A') + " ");
				} else if(j == 0) {
					System.out.print(labelRows++ + "\t");
				} else {
					if(seats[i][j] == null) {
						System.out.print(". ");
					} else {
						System.out.print("x ");
					}
				}
			}
			System.out.println();
		}
	}

	/* Function - bookSeats(String passengerName, String[] prefSeat)
	 * Description - Books a seat for a passenger.
	 * Parameters - passengerName Passenger's name, 
	 * prefSeat Preferred seat in the format [row]-[seat]
	 * Return value - True if the seat was successfully booked, false otherwise.
	 */
	public boolean bookSeats(String passengerName, String[] prefSeat) {

		boolean isAvailable = false;

		int prefRow = Integer.parseInt(prefSeat[0]);
		int prefCol = prefSeat[1].charAt(0) - 'A' + 1;

		if(prefRow <= 0 || prefRow > rows || prefCol <= 0 || prefCol > cols) {
			System.out.println("Please provide a valid seat number");
			System.out.println("Specify seat number like: [row number]-[seat number]");
		} else {
			if(isSeatAvailable(prefRow, prefCol)) {

				seats[prefRow][prefCol] = passengerName;

				isAvailable = true;

			} else {
				isAvailable = false;
			}
		}
		return isAvailable;
	}

	/* Function - removeBookedSeat(String searchName)
	 * Description - Removes a booked seat based on the passenger's name.
	 * Parameters - searchName Passenger's name to search for.
	 */
	public void removeBookedSeat(String searchName) {
		boolean check = false;
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				if(searchName.equals(seats[i][j])) {
					seats[i][j] = null;
					check = true;
				}
			}
		}
		if(!check) {
			System.out.println("No user of this name");
		}
	}

	/* Function - searchSeatByName(String searchName)
	 * Description - Searches for a seat by passenger name and returns its location.
	 * Parameters - searchName Passenger's name to search for.
	 * Return value - Seat location in the format [row]-[seat] or null if not found.
	 */
	public String searchSeatByName(String searchName) {
		for(int i = 1; i < seats.length; i++) {
			for(int j = 1; j < seats[i].length; j++) {
				if(seats[i][j] != null && seats[i][j].equals(searchName)) {
					return new String(i + "-" + (char)(j + 'A' - 1));
				}
			}
		}
		return null;
	}

	/* Function - searchNConsecutiveSeats(int totalSeatsRequired)
	 * Searches for a group of consecutive available seats in the theater.
	 * Parameters - totalSeatsRequired Number of consecutive seats to search for.
	 * Return value - Seat location in the format [row]-[seat] if found, or null if not available.
	 * Throws - IllegalColumnException If the requested number of seats exceeds the available columns.
	 */
	public String searchNConsecutiveSeats(int totalSeatsRequired) throws IllegalColumnException {

		int startRow = 0, startCol = 0;

		if(totalSeatsRequired >= cols || totalSeatsRequired <= 0) {
			throw new IllegalColumnException("Invalid Column Access\nOnly " + (cols-1) + " seats per row");
		}
		else {
			boolean isPresent = false;
			for(int i = 1; i < rows; i++) {
				int count = 0;
				startRow = i;
				for(int j = 1; j < cols; j++) {
					if(seats[i][j] == null) {
						count++;
						if(count == totalSeatsRequired) {
							isPresent = true;
							break;
						}
					} else {
						count = 0;
						startCol = j;
					}
				}
			}

			if(isPresent) {
				return new String(startRow + "-" + (char) (startCol + 'A' + 1));
			} else {
				return null;
			}
		}
	}	

	/* Function - seatsAvailablePerRow()
	 * Description - Finds the number of available seats per row.
	 * Return value - Array containing the count of available seats for each row.
	 */
	public int[] seatsAvailablePerRow() {
		int[] seatsPerRowAvailable = new int[rows-1];
		for(int i = 1; i < rows; i++) {
			int count = 0;
			for(int j = 1; j < cols; j++) {
				count++;
			}
			seatsPerRowAvailable[i] = count;
		}
		return seatsPerRowAvailable;
	}

	/* Function - relocateRandomly
	 * Description - Relocates seats randomly within rows.
	 */
	public void relocateRandomly() {
		Random random = new Random();
		for(int i = 1; i < rows; i++) {
			int randInt = random.nextInt(1, cols-1);
			swap(seats, i, randInt);
		}
	}

	/* Function - swap(String[][] seats, int row, int col)
	 * Description - Swaps two seats in the array.
	 * Parameters - seats 2D array representing seats,
	 * row - Row index, col - Column index.
	 */
	public void swap(String[][] seats, int row, int col) {
		String temp = seats[row][col];
		seats[row][col] = seats[col][row];
		seats[col][row] = temp;
	}

	/* Function - isSeatAvailable(int row, int col)
	 * Description - Checks if a seat is available.
	 * Parameters - row Row number,
	 * col Column number.
	 * Return value - True if the seat is available, false otherwise.
	 */
	public boolean isSeatAvailable(int row, int col) {
		for(int i = 1; i < seats.length; i++) {
			for(int j = 1; j < seats[i].length; j++) {
				if(i == row && j == col) {
					if(seats[i][j] == null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void printLines() {
		System.out.println("*************************************************");
	}
}