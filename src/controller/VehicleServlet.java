package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.VehicleDAO;
import models.Vehicle;

@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VehicleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// initialising the print writer
		PrintWriter writer = response.getWriter();
		VehicleDAO dao = new VehicleDAO();

		try {
			ArrayList<Vehicle> allVehicles = dao.getVehicles();

			for (Vehicle d : allVehicles) {
				writer.write(d.getMake());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
