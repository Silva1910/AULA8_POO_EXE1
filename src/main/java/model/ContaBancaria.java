package model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class ContaBancaria {

	private String cliente;
	private int id;
	private float saldo;
	
	public float sacar(float valor) {

		if (valor < saldo) {
			saldo = saldo - valor;
			System.out.println("voce sacou o valor " + valor +"  o valor total da conta  é " + saldo);
			return saldo;
		} else {
			System.out.println("o valor do saque e insuficiente o valor que voce tem na conta é " + saldo);
			return saldo;
		}

	}

	public float depositar(float valor) {

		
			saldo = saldo + valor;
			System.out.println(" voce depositou, valor total atual é " + saldo);
			return saldo;
		

	}	
}                                                  
