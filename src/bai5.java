import java.util.Scanner;

public class bai5 {
    static void main() {
        System.out.println("nhập vào 1 số nguyên n");
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a = 0;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
