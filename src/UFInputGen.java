import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class UFInputGen {

    public static void main(String[] args) {
        Kattio io = null;
        try {
            io = new Kattio(System.in, new BufferedOutputStream(new FileOutputStream("input/UFmillion")));
        } catch (FileNotFoundException e) {

        }

        int N = 750000;
        int Q = 1000000;
        io.print(N + " ");
        io.println(Q);

        String op;
        int num1;
        int num2;
        for (int i = 0; i < Q; i++) {
            if (Math.random() < 0.4) {
                op = "=";
            } else {
                op = "?";
            }
            num1 = (int)Math.floor(Math.random() * N);
            num2 = (int)Math.floor(Math.random() * N);

            io.println(op + " " + num1 + " " + num2);
        }

    }
}
