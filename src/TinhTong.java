import javax.swing.*;

public class TinhTong extends JFrame {

    private JPanel contentPane;
    private JTextField txtN;
    private JButton btnCalculate;
    private JLabel lblResult;
    private JProgressBar progressBar;

    public TinhTong() {

        setTitle("Tính tổng các số nguyên tố nhỏ hơn N");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setSize(500, 300);
        setLocationRelativeTo(null);

        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);

        btnCalculate.addActionListener(e -> calculatePrimeSum());
    }
    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    private void calculatePrimeSum() {
        int n;
        try {

            n = Integer.parseInt(
                    txtN.getText().trim()
            );

            if (n <= 2) {

                JOptionPane.showMessageDialog(
                        this,
                        "N phải lớn hơn 2"
                );

                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập số nguyên hợp lệ!"
            );

            return;
        }
        btnCalculate.setEnabled(false);
        progressBar.setValue(0);
        lblResult.setText("Đang tính...");
        SwingWorker<Long, Void> worker =
                new SwingWorker<Long, Void>() {

                    @Override
                    protected Long doInBackground() {

                        long sum = 0;

                        for (int i = 2; i < n; i++) {

                            if (isPrime(i)) {
                                sum += i;
                            }
                            int percent =
                                    (int) (i * 100L / (n - 1));

                            setProgress(percent);
                        }

                        return sum;
                    }

                    @Override
                    protected void done() {

                        try {

                            long sum = get();

                            lblResult.setText(
                                    "Tổng các số nguyên tố nhỏ hơn "
                                            + n
                                            + " = "
                                            + sum
                            );

                            progressBar.setValue(100);

                        } catch (Exception e) {

                            lblResult.setText(
                                    "Có lỗi xảy ra!"
                            );

                        } finally {

                            btnCalculate.setEnabled(true);
                        }
                    }
                };
        worker.addPropertyChangeListener(e -> {

            if ("progress".equals(e.getPropertyName())) {

                int progress =
                        (Integer) e.getNewValue();

                progressBar.setValue(progress);
            }
        });
        worker.execute();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TinhTong form = new TinhTong();

            form.setVisible(true);
        });
    }
}