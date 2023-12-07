package atividade3;

import java.util.ArrayList;
import java.util.Scanner;

class Veiculo {
    protected String modelo;
    protected double preco;

    public Veiculo(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void printDados() {
        System.out.println("Modelo: " + modelo + " Preço: " + preco);
    }

    public void ajustarPreco(double ajuste) {
        this.preco += ajuste;
    }
}

class Moto extends Veiculo {
    private int ano;

    public Moto(String modelo, double preco, int ano) {
        super(modelo, preco);
        this.ano = ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public void printDados() {
        super.printDados();
        System.out.println("Ano: " + ano);
    }
}

class Carro extends Veiculo {
    private double km;

    public Carro(String modelo, double preco, double km) {
        super(modelo, preco);
        this.km = km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public void printDados() {
        super.printDados();
        System.out.println("Km: " + km);
    }
}

public class CadastroVeiculos {
    public static void main(String[] args) {

        ArrayList<Veiculo> veiculos = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Escolha o tipo de veículo (Moto ou Carro) ou digite 'sair' para encerrar:");
                String tipoVeiculo = scanner.nextLine();

                if (tipoVeiculo.equalsIgnoreCase("sair")) {
                    break;
                }

                System.out.println("Digite o modelo do veículo:");
                String modelo = scanner.nextLine();

                System.out.println("Digite o preço do veículo:");
                double preco = 0;

                boolean validInput = false;
                while (!validInput) {
                    try {
                        preco = Double.parseDouble(scanner.nextLine());
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, digite um valor válido para o preço.");
                    }
                }

                if (tipoVeiculo.equalsIgnoreCase("Moto")) {
                    System.out.println("Digite o ano da moto:");
                    int ano = 0;

                    validInput = false;
                    while (!validInput) {
                        try {
                            ano = Integer.parseInt(scanner.nextLine());
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, digite um ano válido.");
                        }
                    }

                    Moto moto = new Moto(modelo, preco, ano);
                    veiculos.add(moto);
                } else if (tipoVeiculo.equalsIgnoreCase("Carro")) {
                    System.out.println("Digite a quilometragem do carro:");
                    double km = 0;

                    validInput = false;
                    while (!validInput) {
                        try {
                            km = Double.parseDouble(scanner.nextLine());
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, digite uma quilometragem válida.");
                        }
                    }

                    Carro carro = new Carro(modelo, preco, km);
                    veiculos.add(carro);
                } else {
                    System.out.println("Tipo de veículo não reconhecido. Tente novamente.");
                }
            }

            System.out.println("\nRelatório de Veículos:");

            for (Veiculo veiculo : veiculos) {
                veiculo.printDados();
                System.out.println();
            }

            double totalAntesAjustes = veiculos.stream().mapToDouble(Veiculo::getPreco).sum();
            System.out.println("Total de preços antes dos ajustes: " + totalAntesAjustes);

            System.out.println("\nDigite o valor de ajuste para os preços (ou 0 se nenhum ajuste):");
            double ajuste = 0;

            boolean validInputAjuste = false;
            while (!validInputAjuste) {
                try {
                    ajuste = Double.parseDouble(scanner.nextLine());
                    validInputAjuste = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um valor válido para o ajuste.");
                }
            }

       for (Veiculo veiculo : veiculos) {
                veiculo.ajustarPreco(ajuste);
            }
    double totalAposAjustes = veiculos.stream().mapToDouble(Veiculo::getPreco).sum();
    System.out.println("Total de preços após os ajustes: " + totalAposAjustes);
        }
    }
}