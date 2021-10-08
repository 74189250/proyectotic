package mintic.edu.proyectoweb.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mintic.edu.proyectoweb.modelo.LectorCSV;
import mintic.edu.proyectoweb.modelo.Producto;

public class CargaArchivo extends HttpServlet {

    LectorCSV lectorCSV = new LectorCSV(',', ' ');
    String mensaje = null;
    String aviso = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = null;
        List<Producto> productos = new ArrayList<Producto>();
        //nombre = request.getParameter("nombre");
        System.out.println("nombre" + nombre);
        try{
            nombre = request.getParameter("nombre");
            System.out.println("nombre" + nombre);
            productos = lectorCSV.leerCSVsimple(nombre);
            mensaje = "Archivo CARGADO Exitosamente";
            aviso = null;
            if(productos.size() == 0){
                aviso = "Datos Leidos INVALIDOS";
                mensaje = null;
            }            
    }catch( Exception e){
        aviso = "NO se selecciono archivo para CARGAR";
        mensaje = null;        
    }
        request.setAttribute("productos", productos);
        request.setAttribute("aviso", aviso);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("jsp/vistaArchivo.jsp").forward(request, response);
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
