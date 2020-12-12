/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joe
 */
public class ControllerUtility {
    
    public static void forwardToPage(
            HttpServlet servlet,
            HttpServletRequest request, 
            HttpServletResponse response,
            String url) throws ServletException, IOException
    {
        servlet.getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
}
