package maytinh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiMayTinh extends JFrame implements ActionListener {

    // Thành phần giao diện
    private JTextField displayField;

    // Biến lưu trữ logic
    private double soHang1 = 0;
    private String phepToan = "";
    private boolean dangNhapSoMoi = false;

    public UiMayTinh() {
        setTitle("Máy tính đơn giản");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo màn hình hiển thị
        displayField = new JTextField("0");
        displayField.setFont(new Font("Arial", Font.BOLD, 40));
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // Tạo bảng các nút bấm
        JPanel nutbam = new JPanel();
        nutbam.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttonLabels = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "0", ".", "=", "/"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this); // Gán ActionListener cho mỗi nút
            nutbam.add(button);
        }

        add(nutbam, BorderLayout.CENTER);
        setVisible(true);

        JPanel NutC = new JPanel();
        NutC.setLayout(new BorderLayout());
        JButton Cbutton = new JButton("C");
        NutC.setPreferredSize(new Dimension(0, 60));
        Cbutton.addActionListener(this); // Gán ActionListener cho mỗi nút
        NutC.add(Cbutton);
        add(NutC, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lấy chuỗi văn bản của nút đã bấm
        String command = e.getActionCommand();

        if (command.matches("[0-9]|\\.")) { // Xử lý nút số và dấu chấm
            if (dangNhapSoMoi) {
                displayField.setText(command);
                dangNhapSoMoi = false;
            } else {
                if (displayField.getText().equals("0") && !command.equals(".")) {
                    displayField.setText(command);
                } else {
                    displayField.setText(displayField.getText() + command);
                }
            }
        } else if (command.matches("[\\/\\*\\-\\+]")) { // Xử lý các toán tử
            soHang1 = Double.parseDouble(displayField.getText());
            phepToan = command;
            dangNhapSoMoi = true;
        } else if (command.equals("=")) { // Xử lý nút bằng
            double soHang2 = Double.parseDouble(displayField.getText());
            double ketQua = 0;
            try {
                switch (phepToan) {
                    case "+":
                        ketQua = soHang1 + soHang2;
                        break;
                    case "-":
                        ketQua = soHang1 - soHang2;
                        break;
                    case "*":
                        ketQua = soHang1 * soHang2;
                        break;
                    case "/":
                        if (soHang2 == 0) {
                            displayField.setText("Lỗi");
                            return;
                        }
                        ketQua = soHang1 / soHang2;
                        break;
                }
            } catch (NumberFormatException ex) {
                displayField.setText("Lỗi");
                return;
            }
            displayField.setText(String.valueOf(ketQua));
            soHang1 = ketQua;
            phepToan = "";
            dangNhapSoMoi = true;
        } else if (command.equals("C")) { // Xử lý nút xóa
            soHang1 = 0;
            phepToan = "";
            dangNhapSoMoi = false;
            displayField.setText("0");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UiMayTinh());
    }
}
