<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aula Servlets Pagina</title>
<link rel="stylesheet" href="./css/styles.css">
</head>
<nav id="menu">
	<ul>
		<li><a href="ContaPoupanca.jsp">Conta Poupanca </a></li>
		<li><a href="ContaEspecial.jsp">Conta Especial </a></li>
	</ul>
</nav>

<body>

	<div class="container" align="center">
		<form action="ContaPoupanca" method="post">
			<p class="title">
				<b> Conta Poupança </b>
			</p>
			<table>

				<tr>
					<td><input class="input_data" type="number" id="Depositar"
						name="Depositar" step="0.1" placeholder="Depositar"
						oninput="validarValor(this);" value="0"></td>
				</tr>
				<tr>
					<td><input class="input_data" type="number" id="Sacar"
						name="Sacar" step="0.1" placeholder="Sacar"
						oninput="validarValor(this);" value="0"></td>
				</tr>

				<script>
					function validarValor(input) {
						if (input.value < 0) {
							input.value = 0;
						}
					}
				</script>
				<tr>
					<td><input type="hidden" name="cmd" id="cmd" value="">
						<input type="submit" id="EnviarSacar" name="Enviar" value="Sacar"
						onclick="document.getElementById('cmd').value = 'Sacar';">
						<input type="submit" id="EnviarDepositar" name="Enviar"
						value="Depositar"
						onclick="document.getElementById('cmd').value = 'Depositar';">
						<input type="submit" id="EnviarListar" name="Enviar"
						value="Listar"
						onclick="document.getElementById('cmd').value = 'Listar';">
						<input type="submit" id="EnviarNovoSaldo" name="Enviar"
						value="Novo Saldo"
						onclick="document.getElementById('cmd').value = 'Novo Saldo';">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div id="output" align="center">${saida}</div>
	<br />
<c:if test="${not empty poupanca}">
    <div align="center">
        <table>
            <thead>  
                <tr>
                    <th>#ID</th>
                    <th>Nome</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${poupanca.getId()}</td>
                    <td>${poupanca.getCliente()}</td> <!-- Alterado para getCliente() -->
                    <td>${poupanca.getSaldo()}</td>
                </tr>
            </tbody>
        </table>
    </div>
</c:if>



	


</body>
</html>
