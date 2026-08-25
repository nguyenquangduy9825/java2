import javax.swing.*;
import java.awt.*;

public class GiaiPT extends JFrame {

    private JTextField txtA;
    private JTextField txtB;
    private JTextField txtC;
    private JButton btnGiai;
    private JButton btnXoa;
    private JTextArea txtKetQua;

    public GiaiPT() {
        setTitle("GIẢI PHƯƠNG TRÌNH BẬC 2");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Tiêu đề
        JLabel lblTitle = new JLabel(
                "GIẢI PHƯƠNG TRÌNH BẬC 2",
                SwingConstants.CENTER
        );
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));

        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // Panel nhập dữ liệu
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Nhập a:"));
        txtA = new JTextField();
        inputPanel.add(txtA);

        inputPanel.add(new JLabel("Nhập b:"));
        txtB = new JTextField();
        inputPanel.add(txtB);

        inputPanel.add(new JLabel("Nhập c:"));
        txtC = new JTextField();
        inputPanel.add(txtC);

        // Panel trung tâm
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(inputPanel, BorderLayout.NORTH);

        txtKetQua = new JTextArea(8, 30);
        txtKetQua.setEditable(false);
        txtKetQua.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(txtKetQua);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Panel button
        JPanel buttonPanel = new JPanel();

        btnGiai = new JButton("GIẢI");
        btnXoa = new JButton("XÓA");

        buttonPanel.add(btnGiai);
        buttonPanel.add(btnXoa);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Đưa panel vào JFrame
        setContentPane(mainPanel);

        // =========================
        // NÚT GIẢI
        // =========================
        btnGiai.addActionListener(e -> giaiPhuongTrinh());

        // =========================
        // NÚT XÓA
        // =========================
        btnXoa.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtKetQua.setText("");
            txtA.requestFocus();
        });
    }

    // Hàm giải phương trình
    private void giaiPhuongTrinh() {

        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            // Trường hợp a = 0
            if (a == 0) {

                // b = 0
                if (b == 0) {

                    // c = 0
                    if (c == 0) {
                        txtKetQua.setText(
                                "Phương trình vô số nghiệm"
                        );
                    } else {
                        txtKetQua.setText(
                                "Phương trình vô nghiệm"
                        );
                    }

                } else {
                    // Phương trình bậc nhất
                    double x = -c / b;

                    txtKetQua.setText(
                            "Phương trình bậc nhất\n\n" +
                                    "x = " + x
                    );
                }

                return;
            }

            // Phương trình bậc 2
            double delta = b * b - 4 * a * c;

            // Delta < 0
            if (delta < 0) {

                txtKetQua.setText(
                        "Phương trình vô nghiệm\n\n" +
                                "Δ = " + delta
                );

            }
            // Delta = 0
            else if (delta == 0) {

                double x = -b / (2 * a);

                txtKetQua.setText(
                        "Phương trình có nghiệm kép\n\n" +
                                "Δ = 0\n" +
                                "x1 = x2 = " + x
                );

            }
            // Delta > 0
            else {

                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                txtKetQua.setText(
                        "Phương trình có 2 nghiệm phân biệt\n\n" +
                                "Δ = " + delta + "\n" +
                                "x1 = " + x1 + "\n" +
                                "x2 = " + x2
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập số hợp lệ!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GiaiPT form = new GiaiPT();
            form.setVisible(true);
        });
    }
}