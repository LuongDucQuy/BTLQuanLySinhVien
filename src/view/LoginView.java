package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textField;
    public JPasswordField passwordField;

    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("iconMain.jpg"));
    public JButton jbuttonLogin;
    public JButton jbtForgetPass;
    public JToggleButton tglbtnNewToggleButton;
	private JOptionPane jOptionPane;
	private MenuView testFrame;

    public LoginView() {
        this.setTitle("LOGIN");
        this.setSize(600, 800);
        this.setIconImage(logo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 804, 425);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 400);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel left = new JPanel();
        left.setBackground(new Color(0, 128, 128));
        left.setBounds(0, 0, 400, 390);
        panel.add(left);
        left.setLayout(null);

        JLabel LogoLogin = new JLabel();
        LogoLogin.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\BTLQuanLySinhVien\\image\\LogoMain.png"));
        LogoLogin.setBounds(87, 66, 242, 213);
        left.add(LogoLogin);

        JLabel titleLogoLogin = new JLabel("Quản lý sinh viên");
        titleLogoLogin.setForeground(new Color(255, 255, 255));
        titleLogoLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLogoLogin.setBounds(122, 289, 181, 27);
        left.add(titleLogoLogin);

        JPanel right = new JPanel();
        right.setBackground(new Color(255, 255, 255));
        right.setBounds(400, 0, 400, 390);
        panel.add(right);
        right.setLayout(null);

        JLabel titleLogin = new JLabel("LOGIN");
        titleLogin.setForeground(new Color(0, 128, 128));
        titleLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
        titleLogin.setBounds(167, 22, 98, 50);
        right.add(titleLogin);

        JLabel jlabelEmail = new JLabel("Tài khoản");
        jlabelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jlabelEmail.setBounds(26, 80, 67, 22);
        right.add(jlabelEmail);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(26, 111, 274, 40);
        right.add(textField);
        textField.setColumns(10);

        JLabel lblPassword = new JLabel("Mật khẩu");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPassword.setBounds(26, 161, 66, 22);
        right.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordField.setBounds(26, 191, 274, 40);
        right.add(passwordField);

        ActionListener loginController = new LoginController(this);
        
        jbuttonLogin = new JButton("Đăng nhập");
        jbuttonLogin.setForeground(new Color(255, 255, 255));
        jbuttonLogin.setBackground(new Color(0, 128, 128));
        jbuttonLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jbuttonLogin.setBounds(26, 259, 140, 33);
        jbuttonLogin.addActionListener(loginController);

        right.add(jbuttonLogin);

        tglbtnNewToggleButton = new JToggleButton("Show");
        tglbtnNewToggleButton.addActionListener(loginController);
        tglbtnNewToggleButton.setBounds(310, 196, 66, 30);
        ActionListener loginController1 = new LoginController(this);
        tglbtnNewToggleButton.addActionListener(loginController1); // Gắn sự kiện cho nút "Show"
        right.add(tglbtnNewToggleButton);
        

        jbtForgetPass = new JButton("Quên mật khẩu?");
        jbtForgetPass.addActionListener(loginController1);

        jbtForgetPass.setBackground(SystemColor.activeCaption);
        jbtForgetPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtForgetPass.setBounds(26, 316, 140, 25);
        ActionListener loginController2 = new LoginController(this);
        tglbtnNewToggleButton.addActionListener(loginController2); 
        right.add(jbtForgetPass);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Chạy ứng dụng
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    public void dangNhap() {
        String username = textField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        
        // Kiểm tra dữ liệu nhập có trống không
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản và mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Kết nối tới cơ sở dữ liệu
                String url = "jdbc:mysql://localhost:3306/ontap";
                String user = "root";
                String pass = "";
                Connection conn = DriverManager.getConnection(url, user, pass);
                
                // Tạo truy vấn SQL
                String query = "SELECT * FROM persons WHERE user = ? AND pass = ?"; // Thay đổi your_table_name thành tên bảng chứa thông tin đăng nhập
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);
                
                // Thực thi truy vấn
                ResultSet rs = statement.executeQuery();
                
                // Kiểm tra kết quả của truy vấn
                if (rs.next()) { // Nếu có dòng dữ liệu trả về, tức là tìm thấy tài khoản và mật khẩu khớp
                    testFrame = new MenuView();
                    testFrame.setVisible(true);
                    setVisible(false);
                } else { // Nếu không tìm thấy tài khoản và mật khẩu khớp
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                
                // Đóng kết nối và các đối tượng liên quan
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

	public void hienThiMatKhau() {
	            if (tglbtnNewToggleButton.isSelected()) {
	            	passwordField.setEchoChar((char) 0);
	            	tglbtnNewToggleButton.setText("Hide");
	            } else {
	            	passwordField.setEchoChar('\u25cf');
	            	tglbtnNewToggleButton.setText("Show");
	            }
	}

	public void quenMatKhau() {
	            jOptionPane.showMessageDialog(null, "Vui lòng liên hệ Admin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
}
