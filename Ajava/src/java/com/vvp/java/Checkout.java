/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mishil
 */
public class Checkout extends HttpServlet {
   
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
           HttpSession session = request.getSession();
           String name = request.getParameter("name");
           String number = request.getParameter("number");
           String pm = request.getParameter("pm");
           if(pm.equals("cod")){
               ArrayList cartObj = (ArrayList)session.getAttribute("cart");
               if(cartObj == null){
                   out.println("your cart is empty.");
                   return;
               }
               else{
                   for(int i=0;i<cartObj.size();i++){
                       SelectedProduct temp = (SelectedProduct)cartObj.get(i);
                       Products p = (Products)Products.products.get(new Integer(temp.pid));
                       
                       p.stock = p.stock-temp.qty;
                       Products.products.put(new Integer(temp.pid),p);
                       
                                              
                   }
               }
           }
           else
               out.println("Coming soon..");
           
           session.removeAttribute("cart");
        } finally { 
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
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
