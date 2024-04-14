package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaEspecial extends ContaBancaria {

	private int limite;



    public ContaEspecial(int id, String cliente, float saldo, int limite) {
        super(); // Chamada ao construtor da superclasse
        this.setId(id);
        this.setCliente(cliente);
        this.setSaldo(saldo);
        this.limite = limite;
    }
	
	@Override
	public float sacar(float valor) {

		if (limite + getSaldo() < valor) {
			System.out.println(" CONTA ESPECIAL ******" +"o valor que voce deseja sacar e maior do que o seu saldo e limite, o seu saldo é "
					+ getSaldo() + "e maior do que o limite " );
			return -1;
		} else {

			setSaldo(getSaldo() - valor);
			System.out.println(" CONTA ESPECIAL ******  o seu saldo atual e " + getSaldo() + " e voce acabou de sacar o valor de " + valor );
			return getSaldo();

		}
	}


}
