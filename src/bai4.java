import java.util.Scanner;

public class bai4 {
    static void main() {
        Scanner ket=new Scanner(System.in);
        // nhập 3 số abc
        System.out.println("nhập vào số a");
        double a=ket.nextDouble();
        System.out.println("nhập vào số b");
        double b=ket.nextDouble();
        System.out.println("nhập vào số c");
        double c=ket.nextDouble();
        if (a + b > c && a + c > b && b + c > a) {

            if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } else if ((a == b || a == c || b == c) &&
                    (a * a + b * b == c * c ||
                            a * a + c * c == b * b ||
                            b * b + c * c == a * a)) {
                System.out.println("Tam giác vuông cân");
            } else if (a * a + b * b == c * c ||
                    a * a + c * c == b * b ||
                    b * b + c * c == a * a) {
                System.out.println("Tam giác vuông");
            } else if (a == b || a == c || b == c) {
                System.out.println("Tam giác cân");
            } else {
                System.out.println("Tam giác thường");
            }

        } else {
            System.out.println("Không phải tam giác");
        }


    }
}
