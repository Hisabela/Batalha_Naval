import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        char[][] tabuleiro = new char[8][8]; // Feedback e o tabuleiro
        boolean[][] navios = new boolean[8][8]; // Guardar onde estão os navios

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int tentativas = 0;
        int totalNavios = 10;

        // Estrutura do tabuleiro
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = '~';

            }
        }

        // Posicionando Navios;
        int posicaoNavio = 0;
        while (posicaoNavio < 10) {
            int linha = random.nextInt(8);
            int coluna = random.nextInt(8);
            if (!navios[linha][coluna]) {
                navios[linha][coluna] = true;
                posicaoNavio++;

            }

        }

        // jogadas do tabuleiro
        mostrarTabuleiro(tabuleiro);
        while (tentativas <= 30 || totalNavios == 0) {

            System.out.println("Digite as coordenadas para atacar (linha e coluna, separadas por espaço): ");
            int linha = teclado.nextInt();
            int coluna = teclado.nextInt();
            mostrarTabuleiro(tabuleiro);

            if (linha != posicaoNavio && coluna != posicaoNavio) {
                System.out.println("Voce errou!");
                tabuleiro[linha][coluna] = 'X';

            } else if (linha == posicaoNavio && coluna == posicaoNavio) {
                System.out.println("Voce acertou!");
                tabuleiro[linha][coluna] = 'A';
                tentativas++;
                totalNavios--;
            }

            else if (linha > 8 || coluna > 8 || linha > 0 || coluna > 0) {
                System.out.println("Coordenadas erradas, você perdeu uma tentativa");
                tentativas++;
            } else if (tabuleiro[linha][coluna] == 'A' || tabuleiro[linha][coluna] == 'X') {
                System.out.println("Você já atirou nessa coordenada, você perdeu uma tentativa");
                tentativas++;
            }

            System.out.println("Essa é sua " + tentativas + " tentativa");

        }
        teclado.close();

    }

    private static void mostrarTabuleiro(char tabuleiro[][]) {
        System.out.println();
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[0].length; c++) {
                if (tabuleiro[l][c] < 10) {
                    System.out.print("~" + tabuleiro[l][c] + " ");
                } else {
                    System.out.print(tabuleiro[l][c] + " ");
                }
            }
            System.out.println(" ");
        }
        System.out.println();

    }

}
