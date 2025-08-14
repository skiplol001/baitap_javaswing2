package UiNotepad;

import javax.swing.*;
import java.awt.*;

// Lớp chính tạo giao diện Notepad đơn giản
public class TrinhSoanThaoDonGian extends JFrame {
    
    public TrinhSoanThaoDonGian() {
        // Thiết lập cơ bản cho cửa sổ
        this.setTitle("Trình Soạn Thảo Đơn Giản");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Hiển thị giữa màn hình
        
        // Tạo thanh menu
        JMenuBar thanhMenu = new JMenuBar();
        
        // Tạo menu Tệp
        JMenu menuTep = new JMenu("Tệp");
        menuTep.add(new JMenuItem("Mới"));
        menuTep.add(new JMenuItem("Mở..."));
        menuTep.add(new JMenuItem("Lưu"));
        menuTep.addSeparator(); // Đường phân cách
        menuTep.add(new JMenuItem("Thoát"));
        
        // Tạo menu Chỉnh sửa
        JMenu menuChinhSua = new JMenu("Chỉnh sửa");
        menuChinhSua.add(new JMenuItem("Cắt"));
        menuChinhSua.add(new JMenuItem("Sao chép"));
        menuChinhSua.add(new JMenuItem("Dán"));
        menuChinhSua.add(new JMenuItem("Xóa"));
        
        // Tạo menu Định dạng
        JMenu menuDinhDang = new JMenu("Định dạng");
        menuDinhDang.add(new JMenuItem("Tự động xuống dòng"));
        menuDinhDang.add(new JMenuItem("Font chữ..."));
        
        // Tạo menu Trợ giúp
        JMenu menuTroGiup = new JMenu("Trợ giúp");
        menuTroGiup.add(new JMenuItem("Giới thiệu"));
        
        // Thêm các menu vào thanh menu
        thanhMenu.add(menuTep);
        thanhMenu.add(menuChinhSua);
        thanhMenu.add(menuDinhDang);
        thanhMenu.add(menuTroGiup);
        
        // Thiết lập thanh menu cho cửa sổ
        this.setJMenuBar(thanhMenu);
        
        // Tạo vùng soạn thảo văn bản
        JTextArea vungSoanThao = new JTextArea();
        vungSoanThao.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Thêm thanh cuộn cho vùng soạn thảo
        JScrollPane thanhCuon = new JScrollPane(vungSoanThao);
        this.add(thanhCuon, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        // Hiển thị giao diện
        SwingUtilities.invokeLater(() -> {
            TrinhSoanThaoDonGian trinhSoanThao = new TrinhSoanThaoDonGian();
            trinhSoanThao.setVisible(true);
        });
    }
}