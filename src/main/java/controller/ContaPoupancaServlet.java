package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;
import model.ContaPoupanca;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ContaPoupanca")
public class ContaPoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContaPoupanca poupanca = new ContaPoupanca(1, "Fulano", 1000.0f, 10);

	public ContaPoupancaServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json");

	    // Construir os dados da conta poupança em formato JSON
	    String jsonPoupanca = "{";
	    jsonPoupanca += "\"id\": " + poupanca.getId() + ",";
	    jsonPoupanca += "\"cliente\": \"" + poupanca.getCliente() + "\",";
	    jsonPoupanca += "\"saldo\": " + poupanca.getSaldo();
	    jsonPoupanca += "}";

	    // Escrever os dados JSON na resposta
	    response.getWriter().write(jsonPoupanca);
	}


	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		    String sacar = request.getParameter("Sacar");
		    String depositar = request.getParameter("Depositar");
		    String cmd = request.getParameter("Enviar");

		    String saida = "";

		    double s = Double.parseDouble(sacar);

		    if (cmd.equals("Sacar")) {
		        if (s < poupanca.getSaldo()) {
		            poupanca.sacar(Float.parseFloat(sacar));
		            saida = "Saque realizado com sucesso. O saldo é " + poupanca.getSaldo();
		            request.setAttribute("saida", saida);
		        } else {
		            saida = "O valor do saque é maior do que o saldo disponível.";
		            request.setAttribute("saida", saida);
		        }
		    } else if (cmd.equals("Novo Saldo")) {
		        poupanca.calcNovoSaldo();
		        saida = "O retorno do seu investimento é " + poupanca.getSaldo();
		        request.setAttribute("saida", saida);
		    } else if (cmd.equals("Depositar")) {
		        poupanca.depositar(Float.parseFloat(depositar));
		        saida = "Depósito realizado com sucesso. O saldo é " + poupanca.getSaldo();
		        request.setAttribute("saida", saida);
		    }

		    String jsonPoupanca = "{";
		    jsonPoupanca += "\"id\": " + poupanca.getId() + ",";
		    jsonPoupanca += "\"cliente\": \"" + poupanca.getCliente() + "\",";
		    jsonPoupanca += "\"saldo\": " + poupanca.getSaldo();
		    jsonPoupanca += "}";

		    // Configurar o atributo 'jsonPoupanca' com os dados da conta poupança em formato JSON
		    request.setAttribute("jsonPoupanca", jsonPoupanca);

		    // Encaminhar para a página JSP
		    RequestDispatcher rd = request.getRequestDispatcher("ContaPoupanca.jsp");
		    rd.forward(request, response);
		}

	




	}


