import java.util.Scanner;

public class bai2 {
    static void main() {
        System.out.println("nhập 1 số nguyên ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        double sum=0;
        for (int i = 1; i <=a ; i++) {
            sum+=1.0/i;

        }
        System.out.println("số vừa nhâp là "+sum);
    }
}
