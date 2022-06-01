public class Program {

    public static void main(String[] args) {
        int in = 479598;

        int out;

        out = in % 10;
        in = in / 10;
        out += in % 10;
        in = in / 10;
        out += in % 10;
        in = in / 10;
        out += in % 10;
        in = in / 10;
        out += in % 10;
        in = in / 10;
        out += in % 10;

        System.out.println(out);
    }
}