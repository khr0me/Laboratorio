import java.util.Scanner;

public class P_D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Numero di partenza: ");
        int start = in.nextInt();
        System.out.print("Numero massimo: ");
        int n = in.nextInt();
        in.close();

        if(start>n) {
            System.out.println("Il numero di partenza deve essere maggiore di quello massimo");
        }

        Thread tP = new PariDispari(start, n, true);
        Thread tD = new PariDispari(start, n, false);
        tP.start();
        tD.start();
    }
}