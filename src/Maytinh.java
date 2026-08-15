import javax.swing.*;

public class Maytinh {

    private JPanel panel1;
    private JTextField số1TextField;
    private JTextField số2TextField;
    private JTextArea kếtQuảTextArea;
    private JButton clearButton;
    private JButton chiaButton;
    private JButton nhânButton;
    private JButton trừButton;
    private JButton cộngButton;

    public Maytinh() {
        cộngButton.addActionListener(e -> {
            tinhToan("+");
        });
        trừButton.addActionListener(e -> {
            tinhToan("-");
        });
        nhânButton.addActionListener(e -> {
            tinhToan("*");
        });
        chiaButton.addActionListener(e -> {
            tinhToan("/");
        });
        clearButton.addActionListener(e -> {
            số1TextField.setText("");
            số2TextField.setText("");
            kếtQuảTextArea.setText("");
        });
    }
    private void tinhToan(String phepTinh) {

        try {

            double so1 = Double.parseDouble(số1TextField.getText().trim());
            double so2 = Double.parseDouble(số2TextField.getText().trim());

            double ketQua = 0;

            switch (phepTinh) {

                case "+":
                    ketQua = so1 + so2;
                    break;

                case "-":
                    ketQua = so1 - so2;
                    break;

                case "*":
                    ketQua = so1 * so2;
                    break;

                case "/":

                    if (so2 == 0) {
                        JOptionPane.showMessageDialog(
                                panel1,
                                "Không thể chia cho 0!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }

                    ketQua = so1 / so2;
                    break;
            }
            String lichSu = so1 + " " + phepTinh + " " + so2 + " = " + ketQua;

            kếtQuảTextArea.append(lichSu + "\n");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "Vui lòng nhập số hợp lệ!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Máy tính mini");

        Maytinh maytinh = new Maytinh();

        frame.setContentPane(maytinh.panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 500);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}