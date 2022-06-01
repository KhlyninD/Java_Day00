import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();

        scanner.close();

        boolean inSimple = true;

        int exitStatus = 0;

        int step = 0;

        if (in < 2) {
            System.err.println("Illegal Argument");
            exitStatus = -1;
        } else if (in == 2) {
            System.out.println(inSimple + " " + 1);
        }
        else {
            for (int i = 2; i <= sqrt(in); i++){
                step++;
                if (in % i == 0) {
                    inSimple = false;
                    break;
                }
            }
            System.out.println(inSimple + " " + step);
        }
        System.exit(exitStatus);
    }

    private static int sqrt(int in) {
        long res = 0;

        long start = 1;

        while (res <= in) {
            start ++;
            res = start * start;
        }
        return (int)start;
    }
}

