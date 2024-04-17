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
        setBounds(100, 100, 920, 393);
        
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
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        buttonDiem = new JButton("Quản lý điểm sinh viên");
        buttonDiem.setForeground(new Color(255, 255, 255));
        buttonDiem.setBackground(new Color(0, 100, 0));
        buttonDiem.setBounds(320, 190, 276, 69);
        contentPane.add(buttonDiem);
        buttonDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonDiem.addActionListener(action);
        buttonDiem.setIcon(new ImageIcon("image\\QLDiemMenu.png"));
        
        buttonQLSV = new JButton("Quản lý thông tin sinh viên");
        buttonQLSV.setForeground(new Color(255, 255, 255));
        buttonQLSV.setBackground(new Color(0, 100, 0));
        buttonQLSV.setBounds(10, 190, 276, 69);
        contentPane.add(buttonQLSV);
        buttonQLSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonQLSV.addActionListener(action);
        buttonQLSV.setIcon(new ImageIcon("image\\QLSVMenu.png"));
        
        buttonThuVien = new JButton("Quản lý thư viện");
        buttonThuVien.setForeground(new Color(255, 255, 255));
        buttonThuVien.setBackground(new Color(0, 100, 0));
        buttonThuVien.setBounds(620, 190, 276, 69);
        contentPane.add(buttonThuVien);
        buttonThuVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttonThuVien.setIcon(new ImageIcon("image\\QLSachMenu.png"));
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(224, 67, 437, 75);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(103, 0, 324, 85);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblNewLabel.setIcon(new ImageIcon("image\\iconMenu.png"));
        buttonThuVien.addActionListener(action);

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
