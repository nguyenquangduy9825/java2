import java.util.Scanner;

public class bai3 {
    static void main() {
        System.out.println("nhập vào 1 số ");
        Scanner matlol = new Scanner(System.in);
        int a = matlol.nextInt();
        if(songuyento(a)){
            System.out.println(+a+"đây là số nguyên tố ");
        }
        else{
            System.out.println("đây ko phải là số nguyên tố");
        }



    }

    public static boolean songuyento(int b) {
        if (b < 2) {
            return false;
        }
        for (int i = 2; i < b; i++) {
            if (b % i == 0) {
                return false;
            }


        }
        return true;
    }
}
