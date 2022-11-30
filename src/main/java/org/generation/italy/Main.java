package org.generation.italy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

public class Main {

	private static final String URL = "jdbc:mysql://localhost:3306/areoporto";
	private static final String USER = "guybrush";
	private static final String PWS = "code";
	
	
	public static void main(String[] args) {
		
//		SELECT
		
//		query1();
//		query2();
//		query3();
//		query4();
//		query5(); // TO CHECK
//		query6();
//		query7();
		
//		GROUP BY
//		queryGroup1();
//		queryGroup2();
		
//		JOIN
//		queryJoin1();
		queryJoin2();
	}

	// SINGLE TABLE
	// Selezionare tutti i passeggeri
	private static void query1() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT * FROM passengers";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String lastname = rs.getString(3);
						final Date dateOfBirth = rs.getDate(4);
						final String taxCode = rs.getString(5);
						
						System.out.println(
							id + " - " 
							+ name + " - " 
							+ lastname + " - " 
							+ dateOfBirth + " - " 
							+ taxCode
						);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	
	// Selezionare tutti i nomi degli aeroporti, ordinati per nome
	private static void query2() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT name FROM airports ORDER BY name";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final String name = rs.getString(1);
						
						System.out.println(name);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	
	// Selezionare tutti i passeggeri che hanno come cognome 'Bartell'
	private static void query3() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT * FROM passengers WHERE lastname LIKE 'Bartell'";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String lastname = rs.getString(3);
						final Date dateOfBirth = rs.getDate(4);
						final String taxCode = rs.getString(5);
						
						System.out.println(
							id + " - " 
							+ name + " - " 
							+ lastname + " - " 
							+ dateOfBirth + " - " 
							+ taxCode
						);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	// Selezionare tutti i passeggeri minorenni (considerando solo l'anno di nascita)
	private static void query4() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT * FROM passengers WHERE YEAR(date_of_birth) > (YEAR(NOW()) - 18)";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String lastname = rs.getString(3);
						final Date dateOfBirth = rs.getDate(4);
						final String taxCode = rs.getString(5);
						
						System.out.println(
							id + " - " 
							+ name + " - " 
							+ lastname + " - " 
							+ dateOfBirth + " - " 
							+ taxCode
						);
						
						System.out.println();
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	
	//  Selezionare tutti gli aerei che hanno un numero di posti compreso tra 350 e 700
	private static void query5() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT * FROM airplanes WHERE seating_capacity BETWEEN 350 AND 700";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {

						final int id = rs.getInt(1);
						final String manufacturer = rs.getString(2);
						final String model = rs.getString(3);
						final int seatingCapacity = rs.getInt(4);
						
						System.out.println(
							id + " - " 
							+ manufacturer + " - " 
							+ model + " - " 
							+ seatingCapacity
						);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	// Selezionare tutti gli ID dei dipendenti che hanno lasciato almeno una compagnia aerea
	private static void query6() {
	
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = " SELECT * "
							 + " FROM airplanes "
							 + " WHERE seating_capacity BETWEEN 350 AND 700 ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String manufacturer = rs.getString(2);
						final String model = rs.getString(3);
						final int seatingCapacity = rs.getInt(4);
						
						System.out.println(
							id + " - " 
							+ manufacturer + " - " 
							+ model + " - " 
							+ seatingCapacity
						);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	private static void query7() {
	
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = " SELECT DISTINCT employee_id "
							 + " FROM airline_employee "
							 + " WHERE layoff_date IS NOT NULL ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						
						System.out.println(id);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	// Contare quanti lavori di manutenzione ha eseguito ogni 
	// impiegato (dell'impiegato vogliamo solo l'ID) (1136)
	private static void queryGroup1() {

		 try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
				
			final String sql = " SELECT employee_id, COUNT(*) AS 'workCount' "
							 + " FROM employee_maintenance_work "
							 + " GROUP BY employee_id "
							 + " ORDER BY workCount DESC ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final int workCount = rs.getInt(2);
						
						System.out.println(id + " - " + workCount);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	
	// Contare quante volte ogni impiegato ha lasciato una 
	// compagnia aerea (non mostrare quelli che non hanno 
	// mai lasciato; dell'impiegato vogliamo solo l'ID)
	private static void queryGroup2() {

		 try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
				
			final String sql = " SELECT employee_id, COUNT(*) "
							 + " FROM areoporto.airline_employee "
							 + " WHERE layoff_date IS NOT NULL "
							 + " GROUP BY employee_id ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final int count = rs.getInt(2);
						
						System.out.println(id + " - " + count);
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	// Selezionare tutti i passeggeri del volo 70021493-2 
	private static void queryJoin1() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = "SELECT passengers.* "
							 + " FROM flights "
							 + "	JOIN flight_passenger "
							 + "		ON flights.id = flight_passenger.flight_id "
							 + "	JOIN passengers "
							 + "		ON flight_passenger.passenger_id = passengers.id "
							 + " WHERE number LIKE '70021493-2' ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {

						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String lastname = rs.getString(3);
						final Date dateOfBirth = rs.getDate(4);
						final String taxCode = rs.getString(5);
						
						System.out.println(
							id + " - " 
							+ name + " - " 
							+ lastname + " - " 
							+ dateOfBirth + " - " 
							+ taxCode
						);
						
						System.out.println();
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
	//  Selezionare i voli presi da 'Shirley Stokes'
	private static void queryJoin2() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
			final String sql = " SELECT flights.* "
							 + " FROM passengers "
							 + "	JOIN flight_passenger "
							 + "		ON passengers.id = flight_passenger.passenger_id "
							 + "	JOIN flights "
							 + "		ON flight_passenger.flight_id = flights.id "
							 + " WHERE passengers.name LIKE 'Shirley' "
							 + "	AND passengers.lastname LIKE 'Stokes' ";
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {

						final int id = rs.getInt(1);
						final String number = rs.getString(2);
						
						final Date departureDate = rs.getDate(3);
						final Time departureTime = rs.getTime(3);
						
						final Date arrivalDate = rs.getDate(4);
						final Time arrivalTime = rs.getTime(4);
						
						System.out.println(
							id + " - " 
							+ number + " - " 
							+ departureDate + " " + departureTime + " - " 
							+ arrivalDate + " " + arrivalTime
						);
						
						System.out.println();
					}
				}
			} 
			
		} catch (Exception e) {
			
			System.err.println("ERROR: " + e.getMessage());
		}
	}
}

/**
try (Connection con = DriverManager.getConnection(URL, USER, PWS)) {
			
	final String sql = "";
	
	try (PreparedStatement ps = con.prepareStatement(sql)) {
		try (ResultSet rs = ps.executeQuery()) {
			
			while(rs.next()) {
				
				System.out.println();
			}
		}
	} 
	
} catch (Exception e) {
	
	System.err.println("ERROR: " + e.getMessage());
}
*/
