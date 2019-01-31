/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;

import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mishil
 */
public class Validation extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
//            Enumeration<String> e = request.getParameterNames();
//            while (e.hasMoreElements()) {
//                String pname = e.nextElement();
//                out.write("<br/>"+pname+":");
//                
//                
//                String[] pvalue = request.getParameterValues(pname);
//                for(int i=0;i<pvalue.length;i++){
//                    String pp = pvalue[i];
//                    out.write(pp);
//                }
//             
                
//            }
        String pwd = request.getParameter("pwd");
        String cpwd = request.getParameter("cpwd");
        
        if(!pwd.equals(cpwd))
            out.print("Check Your Password...");
   
        Pattern p = Pattern.compile("[^a-z0-9A-Z ]", Pattern.CASE_INSENSITIVE);
       
        String clg = request.getParameter("college");
        
        Matcher m = p.matcher(clg);
        boolean b = m.find();
        if(b)   
            out.println("Enter Correct College Name.."+"<br/>");


        String email = request.getParameter("email");
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if(!pat.matcher(email).matches())
            out.println("Enter Valid Email..."+"<br/>");
        
        String pn = request.getParameter("phone");
        Pattern pt = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        Matcher mm = pt.matcher(pn); 
        if(!(mm.find() && mm.group().equals(pn)))
            out.print("Enter Valid Mobile No.."+"<br/>");
        
        String sem = request.getParameter("sem");
        int s = Integer.parseInt(sem);
        
        if(s<1 || s>8)
            out.print("Enter Valid Semester No...."+"<br/>");
        
        String br = request.getParameter("branch");
        if(!(br.equalsIgnoreCase("ce") || br.equalsIgnoreCase("it")))
            out.print("Enter Valid Branch.."+"<br/>");
        }         
        catch(NumberFormatException n){
            out.print("Enter Valid Semester No...."+"<br/>");
        }
        finally { 
            out.close();
        }
    } 

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo(){
        return "Short description";
    }
    // </editor-fold>
}
