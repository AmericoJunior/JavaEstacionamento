import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estacionamento {
    // Número de vagas disponíveis
    private static final int NUM_VAGAS = 60;
    // Lista de todos os carros
    private List<Carro> carros;

    public Estacionamento() {
        carros = new ArrayList<>();
    }

    // Método para adicionar carros ao sistema
    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    // Método que distribui as vagas de forma justa
    public void distribuirVagas() {
        // Embaralhar a lista de carros para simular rodízio
        Collections.shuffle(carros);

        // Seleciona os 60 primeiros carros para ocupar as vagas
        List<Carro> carrosComVaga = carros.subList(0, NUM_VAGAS);

        System.out.println("Carros que obtiveram vaga no estacionamento:");
        for (Carro carro : carrosComVaga) {
            System.out.println("Carro: " + carro.getPlaca() + " - Inquilino: " + carro.getInquilino());
        }

        System.out.println("\nCarros que não conseguiram vaga e devem estacionar fora:");
        List<Carro> carrosSemVaga = carros.subList(NUM_VAGAS, carros.size());
        for (Carro carro : carrosSemVaga) {
            System.out.println("Carro: " + carro.getPlaca() + " - Inquilino: " + carro.getInquilino());
        }
    }

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();

        // Adicionando 80 carros ao sistema
        for (int i = 1; i <= 80; i++) {
            estacionamento.adicionarCarro(new Carro("ABC-" + i, "Inquilino " + i));
        }

        // Distribuindo as vagas
        estacionamento.distribuirVagas();
    }
}

// Classe Carro
class Carro {
    private String placa;
    private String inquilino;

    public Carro(String placa, String inquilino) {
        this.placa = placa;
        this.inquilino = inquilino;
    }

    public String getPlaca() {
        return placa;
    }

    public String getInquilino() {
        return inquilino;
    }
}
