import java.util.Scanner;

public class bai6 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");

        if (sc.hasNextDouble()) {
            double a = sc.nextDouble();

            System.out.print("Nhập số thứ hai: ");

            if (sc.hasNextDouble()) {
                double b = sc.nextDouble();

                System.out.println("Tổng = " + (a + b));
            } else {
                System.out.println("Số thứ hai không phải là số!");
            }

        } else {
            System.out.println("Số thứ nhất không phải là số!");
        }
    }
    }

