package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.VehicleDAO;
import models.Vehicle;

@WebServlet("/InsertNewVehicleServlet")
public class InsertNewVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertNewVehicleServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// int id = Integer.valueOf(request.getParameter("id"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.valueOf(request.getParameter("year"));
		int price = Integer.valueOf(request.getParameter("price"));
		String licenseNumber = request.getParameter("license_number");
		String colour = request.getParameter("colour");
		int numberDoors = Integer.valueOf(request.getParameter("number_doors"));
		String transmission = request.getParameter("transmission");
		int mileage = Integer.valueOf(request.getParameter("mileage"));
		String fuelType = request.getParameter("fuel_type");
		int engineSize = Integer.valueOf(request.getParameter("engine_size"));
		String bodyStyle = request.getParameter("body_style");
		String condition = request.getParameter("condition");
		String notes = request.getParameter("notes");

		Vehicle vehicle = new Vehicle(88, make, model, year, price, licenseNumber, colour, numberDoors, transmission,
				mileage, fuelType, engineSize, bodyStyle, condition, notes);

		VehicleDAO dao = new VehicleDAO();

		try {
			dao.insertVehicles(vehicle);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
