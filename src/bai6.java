import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


public class bai6 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Tính tổng 2 số");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Số thứ nhất:");
        JTextField txt1 = new JTextField(10);

        JLabel label2 = new JLabel("Số thứ hai:");
        JTextField txt2 = new JTextField(10);

        JButton btnTinh = new JButton("Tính tổng");

        JLabel ketQua = new JLabel("Kết quả: ");

        btnTinh.addActionListener(e -> {

            try {
                double a = Double.parseDouble(txt1.getText());
                double b = Double.parseDouble(txt2.getText());

                double tong = a + b;

                ketQua.setText("Kết quả: " + tong);

            } catch (NumberFormatException ex) {
                ketQua.setText("Vui lòng nhập số!");
            }
        });

        frame.add(label1);
        frame.add(txt1);

        frame.add(label2);
        frame.add(txt2);

        frame.add(btnTinh);
        frame.add(ketQua);

        frame.setVisible(true);
    }
    }

