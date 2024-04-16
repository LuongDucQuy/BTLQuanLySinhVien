package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.MenuController;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

public class MenuView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	public JMenu menuSelect;
	public JMenuItem menuLogOut;
	public JMenuItem menuExit;
	public JButton buttonDiem;
	public JButton buttonQLSV;
	public JButton buttonThuVien;
	private QuanLyThuVienView testFrame;
	private LoginView testLogOut;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("iconMain.jpg"));

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuView frame = new MenuView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        setBounds(100, 100, 920, 313);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        Action action = new MenuController(this);
        
        menuSelect = new JMenu("Select");
        menuSelect.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\BTLQuanLySinhVien\\image\\menuSelect.png"));
        menuSelect.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menuBar.add(menuSelect);
        
        menuLogOut = new JMenuItem("Log out");
        menuLogOut.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\BTLQuanLySinhVien\\image\\menuLogOut.png"));
        menuLogOut.addActionListener(action);
        menuLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuSelect.add(menuLogOut);
        
        JSeparator separator = new JSeparator();
        menuSelect.add(separator);
        
        menuExit = new JMenuItem("Exit");
        menuExit.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\BTLQuanLySinhVien\\image\\menuExit.png"));
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuSelect.add(menuExit);
        
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        buttonDiem = new JButton("Quản lý điểm sinh viên");
        buttonDiem.setBackground(SystemColor.activeCaption);
        buttonDiem.setBounds(358, 94, 209, 97);
        contentPane.add(buttonDiem);
        buttonDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonDiem.addActionListener(action);
        
        buttonQLSV = new JButton("Quản lý thông tin sinh viên");
        buttonQLSV.setBackground(SystemColor.activeCaption);
        buttonQLSV.setBounds(55, 94, 228, 97);
        contentPane.add(buttonQLSV);
        buttonQLSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonQLSV.addActionListener(action);
        
        buttonThuVien = new JButton("Quản lý thư viện");
        buttonThuVien.setBackground(SystemColor.activeCaption);
        buttonThuVien.setBounds(631, 94, 221, 97);
        contentPane.add(buttonThuVien);
        buttonThuVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonThuVien.addActionListener(action);
        
        JLabel lblNewLabel_2 = new JLabel("Chương trình quản lý sinh viên");
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setBackground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNewLabel_2.setBounds(283, 35, 359, 32);
        contentPane.add(lblNewLabel_2);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

//	public void quanLySinhVien() {
//		testFrame = new test();
//        testFrame.setVisible(true);
//        setVisible(false);
//	}
//
//	public void quanLyDiem() {
//		testFrame = new test();
//        testFrame.setVisible(true);
//        setVisible(false);
//	}

	public void quanLyThuVien() {
		testFrame = new QuanLyThuVienView();
        testFrame.setVisible(true);
        setVisible(false);
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoát khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void dangXuat() {
	    int luaChon = JOptionPane.showConfirmDialog(
	        this,
	        "Bạn chắc chắn muốn đăng xuất khỏi chương trình?",
	        "Log out",
	        JOptionPane.YES_NO_OPTION
	    );

	    if (luaChon == JOptionPane.YES_OPTION) {
	        LoginView testLogOut = new LoginView();
	        testLogOut.setVisible(true);
	        setVisible(false);
	    }
	}
}
