package controller;

import java.sql.SQLException;

import database.VehicleDAO;

public class Controller {

	public static void main(String[] args) {

		VehicleDAO dao = new VehicleDAO();
		
		try {
			dao.getVehicles();
			//dao.insertVehicles();
			dao.updateVehicle();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
