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
public class ViewCart extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    public void init(ServletConfig config)throws ServletException{
        Products.initData();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        try {
           HttpSession session = request.getSession();
           ArrayList cartObj = (ArrayList)session.getAttribute("cart");
           if(cartObj == null)
               out.println("your cart is empty");
           else{
               float grandTotal=0;
               out.println("<table border='1'>" +
                            "<tr>" +
                            "<th>" + "sr no" + "</th>");
               out.println("<th>" + "Product Name"+ "</th>");
               out.println("<th>" + "Quantity" + "</th>");
               out.println("<th>" + "Price" + "</th>");
               out.println("<th>" + "Sub Total" + "</th>");
               for(int i=0;i<cartObj.size();i++){
                   SelectedProduct temp = (SelectedProduct)cartObj.get(i);
                   Products p = (Products)Products.products.get(new Integer(temp.pid));
                   
                   double price = p.getPrice();
                   double subTotal = price * temp.qty;
                   
                   out.println("<tr>");
                   out.println("<td>" +(i+1) + "</td>");
                   out.println("<td>" + p.getProductName() + "</td>");
                   out.println("<td>" + temp.qty + "</td>");
                   out.println("<td>" + price + "</td>");
                   out.println("<td>" + subTotal + "</td>");
                   grandTotal += subTotal;
                   out.println("</tr>");
               }
               out.println("</table>");
               out.println("<div style='float:right; margin-right:76%;'>" + grandTotal + "</div>");
               out.println("<br/><br/>");
               out.println("<div style='float:right; margin-right:76%;'>"+"<a href='Checkout.html'>Checkout</a>"+"</div>");
           }
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
