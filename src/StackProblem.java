import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackProblem {

    public static Stack<Integer> criarPilha(int n) {
        Stack<Integer> pilha = new Stack<Integer>();
        while (n > 0) {
            pilha.push(n);
            n--;
        }
        return pilha;
    }

    public static void output(Stack<Integer> pilha) {
        Stack<Integer> pilhaAux = new Stack<Integer>();
        ArrayList<Integer> descarte = new ArrayList<Integer>();

        while (pilha.size() >= 2) {
            descarte.add(pilha.pop());
            int topoPilha = pilha.pop();

            while (!pilha.isEmpty()) {
                pilhaAux.add(pilha.pop());
            }
            pilha.push(topoPilha);
            while (!pilhaAux.isEmpty()) {
                pilha.add(pilhaAux.pop());
            }
        }

        System.out.println();
        for (Integer integer : descarte) {
            if (integer == descarte.get(descarte.size() - 1)) {
                System.out.println(integer);

            } else {
                System.out.print(integer + ", ");
            }

        }

        for (Integer integer : pilha) {
            System.out.println(integer);

        }
    }

    public static int input(Scanner scanner) {
        System.out.print(
                "\nInsira um valor de 1 a 50 que representa o número de cartas na pilha. Insira o valor 0 para encerrar: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int n = input(scanner);

                while (n < 0 || n > 50) {
                    System.out.println("Error: Valor inserido menor que 0 ou maior que 50!");
                    n = input(scanner);
                }

                if (n == 0) {
                    break;
                }

                output(criarPilha(n));
            } catch (Exception e) {
                System.out.println("\n|-------------------------------------------------------------------|");
                System.out.println("| O valor inserido não é um número inteiro! Favor, reiniciar código!|");
                System.out.println("|-------------------------------------------------------------------|\n");                
                break;
            }

        }

        scanner.close();
    }
}
