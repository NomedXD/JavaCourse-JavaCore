package by.teachmeskills.task1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//@WebServlet("/task")
@WebServlet(urlPatterns = {"/cool", "/gachi"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculator.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String operand1 = req.getParameter("operand1");
        String operand2 = req.getParameter("operand2");

        String[] operations = req.getParameterValues("operation");
        try {
            writer.println("<h3>Results</h3>");
            Arrays.stream(operations).forEach(s -> {
                switch (s) {
                    case "SummarizationOption": {
                        writer.println("<li> Sum = " + Calculator.summation(Double.parseDouble(operand1),Double.parseDouble(operand2)) + "</li>");
                        break;
                    }
                    case "SubtractionOption": {
                        writer.println("<li> Subtraction = " + Calculator.subtraction(Double.parseDouble(operand1),Double.parseDouble(operand2)) + "</li>");
                        break;
                    }
                    case "MultiplicationOption": {
                        writer.println("<li> Multiplication = " + Calculator.multiplication(Double.parseDouble(operand1),Double.parseDouble(operand2)) + "</li>");
                        break;
                    }
                    case "DivisionOption": {
                        writer.println("<li> Division = " + Calculator.division(Double.parseDouble(operand1),Double.parseDouble(operand2)) + "</li>");
                        break;
                    }
                }
            });
        } finally {
            writer.close();
        }
    }
}