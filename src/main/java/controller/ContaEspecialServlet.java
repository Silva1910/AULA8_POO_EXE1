package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;

import java.io.IOException;

@WebServlet("/ContaEspecial")
public class ContaEspecialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ContaEspecial especial = new ContaEspecial(1, "Ciclano", 1000.0f, 1000);

    public ContaEspecialServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        String jsonEspecial = (String) request.getAttribute("jsonEspecial");
        response.getWriter().write(jsonEspecial);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sacar = request.getParameter("Sacar");
        String depositar = request.getParameter("Depositar");
        String cmd = request.getParameter("Enviar");

        String saida = "";

        double s = Double.parseDouble(sacar);

        if (cmd.equals("Sacar")) {
            if (s < especial.getSaldo() + especial.getLimite()) {
                especial.sacar(Float.parseFloat(sacar));
                saida = "Saque realizado com sucesso. O saldo é " + especial.getSaldo();
                request.setAttribute("saida", saida);
            } else {
                saida = "O valor do saque é maior do que o saldo disponível.";
                request.setAttribute("saida", saida);
            }
        } else if (cmd.equals("Depositar")) {
            especial.depositar(Float.parseFloat(depositar));
            saida = "Depósito realizado com sucesso. O saldo é " + especial.getSaldo();
            request.setAttribute("saida", saida);
        }

        request.setAttribute("especial", especial);

        RequestDispatcher rd = request.getRequestDispatcher("ContaEspecial.jsp");
        rd.forward(request, response);
    }
}
