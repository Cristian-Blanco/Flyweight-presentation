/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import factory.CoffeeFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weight.Coffee;
import weight.ICoffee;

/**
 *
 * @author jackl
 */
public class Client extends HttpServlet {
    CoffeeFactory fabricaCafe = new CoffeeFactory();
    static ArrayList<String> save = new ArrayList<>();
    static ArrayList<ICoffee> trick = new ArrayList<>();
    static ICoffee cafe;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        cafe = fabricaCafe.getCafe(request.getParameter("product_select"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>CoCoffe</title>\n" +
                    "    <link rel=\"shortcut icon\" href=\"img/icon.png\" type=\"image/x-icon\">\n" +
                    "    <link rel=\"stylesheet\" href=\"css/estilos.css\">\n" +
                    "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap\" rel=\"stylesheet\"> \n" +
                    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<header>\n" +
                    "      <!--  <nav>\n" +
                    "            <a href=\"\"></a>\n" +
                    "            <a href=\"\"></a>\n" +
                    "        </nav>-->\n" +
                    "        <section class=\"textos-header\">\n" +
                    "            <h1>CoCoffe</h1>\n" +     
                    "        </section>\n" +
                    "        <div class=\"wave\" style=\"height: 150px; overflow: hidden;\"><svg viewBox=\"0 0 500 150\" preserveAspectRatio=\"none\"\n" +
                    "                style=\"height: 100%; width: 100%;\">\n" +
                    "                <path d=\"M0.00,49.98 C150.00,150.00 349.20,-50.00 500.00,49.98 L500.00,150.00 L0.00,150.00 Z\"\n" +
                    "                    style=\"stroke: none; fill: #fff;\"></path>\n" +
                    "            </svg></div>\n" +
                    "    </header>");
            out.println("<main>\n" +
                    "        <section class=\"contenedor sobre-nosotros\">\n" +
                    "            <h2 class=\"titulo\">Informacion</h2>\n" +
                    "            <div class=\"contenedor-sobre-nosotros\">\n" +
                    "                <img src=\"https://images.unsplash.com/photo-1441109296207-fd911f7cd5e5?ixlib=rb-1.2.1&auto=format&fit=crop&w=1371&q=80\" alt=\"\" class=\"imagen-about-us\">\n" +
                    "                <div class=\"contenido-textos\">\n" +
                    "                    <h3><span>1</span>Sobre lo que has pedido:</h3>");
            if(CoffeeFactory.existance){
                out.println("<p>Un café como el cafe pedido ya se está fabricando, se agregó una nueva petición</p>");
            }else{
                out.println("<p>El café ingresado aun no se está fabricando, se fabricará </p>");
            }

            out.println("<div class=\"container\">\n" +
"            <form action=\"Info\" method=\"GET\" class=\"form\">\n" +
"                <div class=\"form-header\">\n" +
                   
"                    <h3 class=\"form-title\"><span>2</span>Ingresa tus datos</h3>\n" +
"                </div>\n" +
"\n" +
"          \n" +
"\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"product_select\" class=\"form-label\">Seleccione la mesa en la que se encuentra:</label>\n" +
"                    \n" +
"                        <select class=\"form-control list\" id=\"mesa_select\" name=\"mesa_select\">\n" +
"                            <option value=\"1\">1</option>\n" +
"                            <option value=\"2\">2</option>\n" +
"                            <option value=\"3\">3</option>\n" +
"                            <option value=\"4\">4</option>\n" +
"                            <option value=\"5\">5</option>\n" +
          
"                        </select>\n" +
                              "<label for=\"full-name\">Nombre Completo:</label>\n" +
"                <input type=\"text\" class=\"form-control\" placeholder=\"Escriba su Nombre Completo\" name=\"full-name\" id=\"full-name\" required>"+
"                    </div>\n" +
"\n" +
"                <input type=\"submit\" value=\"Continuar\" class=\"button-submit\">\n" +
"\n" +
"            </form>\n" +
"        </div>");
            out.println("</body>");
            out.println("</html>");
            
        }
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
