/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SuscripcionDAO;
import modelo.Suscripcion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vero
 */
@WebServlet("/SuscripcionServlet")
public class SuscripcionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros de la solicitud
        String email = request.getParameter("email");
        System.out.println("Email recibido: " + email);  // Añadido para depuración
    
        // Crear objeto Suscripcion y establecer el email
        Suscripcion suscriptor = new Suscripcion();
        suscriptor.setEmail(email);
        System.out.println("Email en objeto Suscripcion: " + suscriptor.getEmail());  // Añadido para depuración

        // Guardar en la base de datos usando el DAO
        SuscripcionDAO suscriptorDAO = new SuscripcionDAO();
        boolean registroExitoso = suscriptorDAO.crearSuscripcion(suscriptor);
        
        // Redireccionar según el resultado
        if (registroExitoso) {
            response.sendRedirect("index.html?exito=true");
        } else {
            response.sendRedirect("index.html?error=true");
        }
    }

}
