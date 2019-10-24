/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cariServlet", urlPatterns = {"/search"})
public class cariServlet extends HttpServlet {

    cariMahasiswaLocal cariMahasiswa = lookupcariMahasiswaLocal();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("status", "false");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/search.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            cariMahasiswa.cekMahasiswa(request.getParameter("nama"), request.getParameter("nim"));
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param = request.getParameter("param");
        String cek = cariMahasiswa.search(param);
        if (cek=="Nope"){
            request.setAttribute("show", "Mahasiswa tidak terdaftar");
        }
        else {
            request.setAttribute("show", cek);
        }

            processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private cariMahasiswaLocal lookupcariMahasiswaLocal() {
        try {
            Context c = new InitialContext();
            return (cariMahasiswaLocal) c.lookup("java:global/A_TugasModul2/A_TugasModul2-ejb/cariMahasiswa!tugasModul2.cariMahasiswaLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
