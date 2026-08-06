import java.util.Scanner;

public class DiemCC {
    static void main() {
        System.out.println("mời bạn nhập điểm ");
        Scanner sc=new Scanner(System.in);
        System.out.println("mời nhập điểm chuyên cần");
        double diemCC=sc.nextDouble();
        System.out.println("mời nhập điểm giữa kỳ");
        double diemGK=sc.nextDouble();
        System.out.println("nhập điểm cuối kỳ");
        double diemCK=sc.nextDouble();
        double  diem=diemCC*0.1+diemGK*0.3+diemCK*0.6;
        if(diem<5){
            System.out.println("mày trượt");
        }
        else
            System.out.println("mày đỗ");
    }

}
