import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] matriz = new String[3][3];
        System.out.println("Jogo da velha!");
        while(!vitoriaXO(matriz)){
            JogodaVelhaX(matriz);
            formatacao(matriz);
            if (vitoriaXO(matriz)) {
                break;
            }

            JogodaVelhaO(matriz);
            formatacao(matriz);
            if (vitoriaXO(matriz)) {
                break;
            }

        }
    }
    public static void JogodaVelhaX(String[][] matriz) {
        boolean posicao = false;
        do{
            System.out.println("Jogador 1");
            System.out.println("Digite uma linha para inserir o X");
            int Xl = scn.nextInt();
            System.out.println("Digite uma coluna para inserir o X");
            int Xc = scn.nextInt();
            if (matriz[Xl][Xc] == "X" || matriz[Xl][Xc] == "O") {
                System.out.println("Já existe um marcador nesta posicao");
                posicao = true;
            } else{
                matriz[Xl][Xc] = "X";
                posicao = false;

            }
        }while(posicao);
    }

    public static void JogodaVelhaO(String[][] matriz) {
        boolean posicao = false;
        do{
            System.out.println("Jogador 2");
            System.out.println("Digite uma linha para inserir o O");
            int Ol = scn.nextInt();
            System.out.println("Digite uma coluna para inserir o O");
            int Oc = scn.nextInt();
            if (matriz[Ol][Oc] == "X" || matriz[Ol][Oc] == "O") {
                System.out.println("Já existe um marcador nesta posicao");
                posicao = true;
            } else{
                matriz[Ol][Oc] = "O";
                posicao = false;

            }
        }while(posicao);
    }

    public static boolean vitoriaXO(String[][] matriz) {
        int empate = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2]) {
                if (matriz[i][0] == "X") {
                    System.out.println("Parabens jogador 1 voce venceu!");
                    return true;
                } else if (matriz[i][0] == "O") {
                    System.out.println("Parabens jogador 2 voce venceu!");
                    return true;
                }
            }
        }
        for (int i = 0; i < matriz[0].length; i++){
            if (matriz[0][i] == matriz[1][i] && matriz[0][i] == matriz[2][i]) {
                if (matriz[0][i] == "X") {
                    System.out.println("Parabens jogador 1 voce venceu!");
                    return true;
                } else if (matriz[0][i] == "O") {
                    System.out.println("Parabens jogador 2 voce venceu!");
                    return true;
                }
            }
        }

        if (matriz[0][0] == matriz[1][1] && matriz[0][0] == matriz[2][2]) {
            if (matriz[0][0] == "X") {
                System.out.println("Parabens jogador 1 voce venceu!");
                return true;
            } else if (matriz[0][0] == "O") {
                System.out.println("Parabens jogador 2 voce venceu!");
                return true;
            }
        }
        if (matriz[0][2] == matriz[1][1] && matriz[2][0] == matriz[0][2]) {
            if (matriz[0][2] == "X") {
                System.out.println("Parabens jogador 1 voce venceu!");
                return true;
            } else if (matriz[0][2] == "O") {
                System.out.println("Parabens jogador 2 voce venceu!");
                return true;
            }

        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == "X" || matriz[i][j] == "O") {
                    empate++;
                    if (empate == 9) {
                        System.out.println("Empate");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void formatacao(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == null) {
                    matriz[i][j] = "_";
                }
            }
        }
        System.out.print("{" + matriz[0][0] + "," + matriz[0][1] + "," + matriz[0][2] + "}" + "\n");
        System.out.print("{" + matriz[1][0] + "," + matriz[1][1] + "," + matriz[1][2] + "}" + "\n");
        System.out.print("{" + matriz[2][0] + "," + matriz[2][1] + "," + matriz[2][2] + "}" + "\n");
    }
}