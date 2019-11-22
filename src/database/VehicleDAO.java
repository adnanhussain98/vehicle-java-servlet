package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Vehicle;

public class VehicleDAO {
	// 1. Load the driver
	// 2. Define the connection url.
	// 3. establish the connection
	// 4. create a statement object
	// 5. execute a query
	// 6. process the results
	// 7 close the connection

	private Connection getConnection() {

		Connection conn = null;

		try {
			// load driver
			Class.forName("org.sqlite.JDBC");
			// url of the database location
			String url = "jdbc:sqlite:/Users/adnanhussain/Documents/VehicleWebApp/vehicles.sqlite";
			// initialise connection object
			conn = DriverManager.getConnection(url);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// returns conn object
		return conn;
	}

	public ArrayList<Vehicle> getVehicles() throws SQLException {
		ArrayList<Vehicle> allVehicles = new ArrayList<>();
		// makes the connection local
		// not making it global gives you the connection when it's available
		Connection connection = getConnection();
		// create a statement object
		Statement statement = connection.createStatement();

		// the return of query gets stored into ResultSet (rs is the local object)
		String query1 = "SELECT * FROM vehicles";
		System.out.println(query1);

		// the return of query gets stored into ResultSet (rs is the local object)
		ResultSet rs = statement.executeQuery(query1);

		while (rs.next()) {
			// declaring a int called id and storing the column name vehicle_id from the
			// result set into the variable.
			int id = rs.getInt("vehicle_id");
			String make = rs.getString("make");
			String model = rs.getString("model");
			int year = rs.getInt("year");
			int price = rs.getInt("price");
			String licenseNumber = rs.getString("license_number");
			String colour = rs.getString("colour");
			int numberDoors = rs.getInt("number_doors");
			String transmission = rs.getString("transmission");
			int mileage = rs.getInt("mileage");
			String fuelType = rs.getString("fuel_type");
			int engineSize = rs.getInt("engine_size");
			String bodyStyle = rs.getString("body_style");
			String condition = rs.getString("condition");
			String notes = rs.getString("notes");

			System.out.println(id + " " + make + " " + model + " " + year);

			// create new Vehicle object
			Vehicle vehicle = new Vehicle(id, make, model, year, price, licenseNumber, colour, numberDoors,
					transmission, mileage, fuelType, engineSize, bodyStyle, condition, notes);

			allVehicles.add(vehicle);
		}
		return allVehicles;

	}

	public void insertVehicles(Vehicle vehicle) throws SQLException {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "INSERT INTO vehicles (vehicle_id, make, model, year, price, license_number, colour, number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, Notes )"
				+ " VALUES (" + vehicle.getVehicleId() + ", '" + vehicle.getMake() + "', '" + vehicle.getModel() + "', "
				+ vehicle.getYear() + ", " + vehicle.getPrice() + ", '" + vehicle.getLicenseNumber() + "', '"
				+ vehicle.getColour() + "', " + vehicle.getNumberDoors() + ", '" + vehicle.getTransmission() + "', "
				+ vehicle.getMileage() + ", '" + vehicle.getFuelType() + "', " + vehicle.getEngineSize() + ", '"
				+ vehicle.getBodyStyle() + "', '" + vehicle.getCondition() + "', '" + vehicle.getNotes() + "' );";
		System.out.println(sql);

		statement.executeUpdate(sql);
		System.out.println("done");

	}

	public void updateVehicle(Vehicle updateVehicle) throws SQLException {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "UPDATE vehicles " + "SET make = 'Bentley' " + " WHERE vehicle_id = 555";
		System.out.println(sql);

		statement.executeUpdate(sql);
		System.out.println("done");

		connection.close();
	}

	public void deleteDVD(Vehicle deleteVehicle) throws SQLException {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "DELETE FROM vehicles " + " WHERE vehicle_id = " + deleteVehicle.getVehicleId() + ";";

		System.out.println(sql);

		statement.executeUpdate(sql);
		System.out.println("done");

	}

}
