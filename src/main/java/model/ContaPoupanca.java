package model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContaPoupanca extends ContaBancaria {
    private int rendimentoDiario;

    public ContaPoupanca(int id, String cliente, float saldo, int rendimentoDiario) {
        super(); // Chamada ao construtor da superclasse
        this.setId(id);
        this.setCliente(cliente);
        this.setSaldo(saldo);
        this.rendimentoDiario = rendimentoDiario;
    }

    public void calcNovoSaldo() {
        float novoSaldo = getSaldo() * (1 + (rendimentoDiario / 100.0f)); // Ajuste para lidar com porcentagem
        setSaldo(novoSaldo);
        System.out.println("CONTA POUPANCA ****** O novo saldo é " + novoSaldo);
    }
}