<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aula Servlets Pagina 2</title>
<link rel="stylesheet" href="./css/styles.css">
</head>

<body>
<nav id="menu">
    <ul>
        <li><a href="ContaPoupanca.jsp">Conta Poupanca </a></li>
        <li><a href="ContaEspecial.jsp">Conta Especial </a></li>
    </ul>
</nav>

<div class="container" align="center">
    <form action="ContaEspecial" method="post">
        <p class="title"><b> Conta Especial </b></p>
        <table>
            <tr>
                <td><input class="input_data" type="number" id="Depositar" name="Depositar" step="0.1" placeholder="Depositar" oninput="validarValor(this);" value="0"></td>
            </tr>
            <tr>
                <td><input class="input_data" type="number" id="Sacar" name="Sacar" step="0.1" placeholder="Sacar" oninput="validarValor(this);" value="0"></td>
            </tr>
            <script>
                function validarValor(input) {
                    if (input.value < 0) {
                        input.value = 0;
                    }
                }
            </script>
            <tr>
                <td>
                    <input type="hidden" name="cmd" id="cmd" value="">
                    <input type="submit" id="EnviarSacar" name="Enviar" value="Sacar" onclick="document.getElementById('cmd').value = 'Sacar';">
                    <input type="submit" id="EnviarDepositar" name="Enviar" value="Depositar" onclick="document.getElementById('cmd').value = 'Depositar';">
                    <input type="submit" id="EnviarListar" name="Enviar"
						value="Listar"
						onclick="document.getElementById('cmd').value = 'Listar';">
                </td>
            </tr>
        </table>
    </form>
</div>

<br/>
<br/>
<div id="output" align="center">${saida}</div>
<br />
<div class="container" id="especialTable" align="center" style="display: none;">
    <table id="tableEspecial">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Nome</th>
                <th>Saldo</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const listarButton = document.getElementById('EnviarListar');
        listarButton.addEventListener('click', function(event) {
            event.preventDefault(); // Impede o envio do formulário e a recarga da página

            const especialTableDiv = document.getElementById('especialTable');
            especialTableDiv.style.display = 'block'; // Mostra a tabela

            const tbody = document.querySelector('#tableEspecial tbody');

            fetch('dadosEspecial') // Rota que retorna os dados da conta especial em JSON
                .then(response => response.json())
                .then(data => {
                    // Limpa a tabela antes de preencher com os novos dados
                    tbody.innerHTML = '';

                    // Adiciona os dados da conta especial na tabela
                    data.forEach(especial => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${especial.id}</td>
                            <td>${especial.cliente}</td>
                            <td>${especial.saldo}</td>
                        `;
                        tbody.appendChild(row);
                    });
                })
                .catch(error => console.error('Erro ao obter os dados da conta especial:', error));
        });
    });
</script>
</body>
</html>
