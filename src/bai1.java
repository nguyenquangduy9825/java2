import java.util.Scanner;

public class bai1 {
    static void main() {
        // tính tổng số chẵn
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int sum=0;
        for (int i = 2; i <=a ; i+=2) {

            sum+=i;

        }
        System.out.println("tổng số chẵn là"+sum);

    }
}
