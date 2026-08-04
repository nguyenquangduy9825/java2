import java.util.Scanner;

public class bai3 {
    static void main() {
        System.out.println("nhập vào 1 số nguyên tố");
        Scanner matlol = new Scanner(System.in);
        int a = matlol.nextInt();
        if(songuyento(a)){
            System.out.println("đây là số nguyên tố "+a);
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
