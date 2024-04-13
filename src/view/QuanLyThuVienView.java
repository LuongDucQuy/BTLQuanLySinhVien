package view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyMuonTraController;
import controller.QuanLySachController;
import model.MuonTraModel;
import model.QuanLyMuonTraModel;
import model.QuanLySachModel;
import model.SachModel;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class QuanLyThuVienView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QuanLySachModel QLSachModel;
	public QuanLyMuonTraModel QLMuonTraModel;
	public MuonTraModel muonTraModel;
	private MenuView testFrame;
	private JTextField textFieldTimKiem1;
	private JTextField textFieldMaSinhVien;
	private JTextField textFieldMaSach1;
	private JTextField textFieldSoLuong1;
	private JTextField textFieldNgayHenTra;
	private JTextField textFieldTimKiemTheoMaSach;
	public JTextField textFieldGiaTien;
	public JTextField textFieldSoLuong;
	public JTextField textFieldMaTacGia;
	public JTextField textFieldNhaXuatBan;
	public JTextField textFieldTheLoai;
	public JTextField textFieldTenSach;
	public JTextField textFieldMaSach;
	public JTable table;
	public JTextField textFieldNgayXuatBan;
	public JTable table_1;
	public JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyThuVienView frame = new QuanLyThuVienView();
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
	public QuanLyThuVienView() {
		this.QLSachModel = new QuanLySachModel();
		this.QLMuonTraModel = new QuanLyMuonTraModel();
		this.muonTraModel = new MuonTraModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 841);
		
		Action action = new QuanLySachController(this);
		Action action1 = new QuanLyMuonTraController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jMenuHeThong = new JMenu("Hệ Thống");
		menuBar.add(jMenuHeThong);
		jMenuHeThong.addActionListener(action);
		
		JMenuItem jMenuDong = new JMenuItem("Đóng");
		jMenuHeThong.add(jMenuDong);
		jMenuDong.addActionListener(action);
		
		JMenuItem jMenuThoat = new JMenuItem("Thoát");
		jMenuHeThong.add(jMenuThoat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jMenuThoat.addActionListener(action);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 1061, 794);
		contentPane.add(tabbedPane_1);
		
		JPanel jPanleQuanLySach = new JPanel();
		tabbedPane_1.addTab("Quản Lý Sách", null, jPanleQuanLySach, null);
		jPanleQuanLySach.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 380, 1012, 244);
		jPanleQuanLySach.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "Th\u1EC3 Lo\u1EA1i", "Nh\u00E0 Xu\u1EA5t B\u1EA3n", "Ng\u00E0y Xu\u1EA5t B\u1EA3n", "M\u00E3 T\u00E1c Gi\u1EA3", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Ti\u1EC1n"
			}
		));
		
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 331, 1012, 2);
		jPanleQuanLySach.add(separator);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 657, 1012, 87);
		jPanleQuanLySach.add(panel_5);
		panel_5.setLayout(null);
		
		JButton buttonThem = new JButton("Thêm");
		buttonThem.setBounds(140, 28, 84, 29);
		panel_5.add(buttonThem);
		buttonThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonThem.addActionListener(action);
		
		JButton buttonSua = new JButton("Cập Nhật");
		buttonSua.setBounds(485, 28, 112, 29);
		panel_5.add(buttonSua);
		buttonSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonSua.addActionListener(action);
		
		JButton buttonXoa = new JButton("Xóa");
		buttonXoa.setBounds(663, 28, 66, 29);
		panel_5.add(buttonXoa);
		buttonXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonXoa.addActionListener(action);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(301, 28, 106, 29);
		btnLuu.addActionListener(action);
		panel_5.add(btnLuu);
		
		JButton buttonLamMoi = new JButton("Làm Mới");
		buttonLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonLamMoi.setBounds(824, 28, 112, 29);
		panel_5.add(buttonLamMoi);
		buttonLamMoi.addActionListener(action);
		
		JLabel lblNewLabel_3 = new JLabel("Chức Năng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 634, 70, 17);
		jPanleQuanLySach.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thông Tin Sách");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 357, 100, 17);
		jPanleQuanLySach.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(10, 10, 1012, 303);
		jPanleQuanLySach.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel jLabelTimKiem = new JLabel("Tìm Kiếm Theo Mã Sách");
		jLabelTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelTimKiem.setBounds(803, 111, 173, 20);
		panel_6.add(jLabelTimKiem);
		
		textFieldTimKiemTheoMaSach = new JTextField();
		textFieldTimKiemTheoMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTimKiemTheoMaSach.setColumns(10);
		textFieldTimKiemTheoMaSach.setBounds(788, 141, 202, 39);
		panel_6.add(textFieldTimKiemTheoMaSach);
		
		JButton buttonTimKiem = new JButton("Tìm Kiếm");
		buttonTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonTimKiem.setBounds(829, 190, 115, 29);
		buttonTimKiem.addActionListener(action);
		panel_6.add(buttonTimKiem);
		
		textFieldGiaTien = new JTextField();
		textFieldGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldGiaTien.setColumns(10);
		textFieldGiaTien.setBounds(505, 242, 202, 39);
		panel_6.add(textFieldGiaTien);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(505, 170, 202, 39);
		panel_6.add(textFieldSoLuong);
		
		textFieldMaTacGia = new JTextField();
		textFieldMaTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaTacGia.setColumns(10);
		textFieldMaTacGia.setBounds(505, 92, 202, 39);
		panel_6.add(textFieldMaTacGia);
		
		JLabel jLabelNamXB = new JLabel("Ngày Xuất Bản");
		jLabelNamXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelNamXB.setBounds(365, 24, 106, 20);
		panel_6.add(jLabelNamXB);
		
		JLabel jLabelMaTacGia = new JLabel("Mã Tác Giả ");
		jLabelMaTacGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelMaTacGia.setBounds(365, 99, 84, 20);
		panel_6.add(jLabelMaTacGia);
		
		JLabel jLabelSoLuong = new JLabel("Số Lượng");
		jLabelSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelSoLuong.setBounds(365, 177, 78, 20);
		panel_6.add(jLabelSoLuong);
		
		JLabel jLabelGiaTien = new JLabel("Giá Tiền");
		jLabelGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelGiaTien.setBounds(365, 249, 59, 20);
		panel_6.add(jLabelGiaTien);
		
		textFieldNhaXuatBan = new JTextField();
		textFieldNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNhaXuatBan.setColumns(10);
		textFieldNhaXuatBan.setBounds(118, 242, 202, 39);
		panel_6.add(textFieldNhaXuatBan);
		
		textFieldTheLoai = new JTextField();
		textFieldTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTheLoai.setColumns(10);
		textFieldTheLoai.setBounds(116, 170, 202, 39);
		panel_6.add(textFieldTheLoai);
		
		textFieldTenSach = new JTextField();
		textFieldTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTenSach.setColumns(10);
		textFieldTenSach.setBounds(116, 92, 202, 39);
		panel_6.add(textFieldTenSach);
		
		textFieldMaSach = new JTextField();
		textFieldMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaSach.setColumns(10);
		textFieldMaSach.setBounds(116, 17, 202, 39);
		panel_6.add(textFieldMaSach);
		
		JLabel jLabelMaSach = new JLabel("Mã Sách");
		jLabelMaSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelMaSach.setBounds(10, 10, 110, 49);
		panel_6.add(jLabelMaSach);
		
		JLabel jLabelTenSach = new JLabel("Tên Sách");
		jLabelTenSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelTenSach.setBounds(10, 99, 66, 20);
		panel_6.add(jLabelTenSach);
		
		JLabel jLabelTheLoai = new JLabel("Thể loại");
		jLabelTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelTheLoai.setBounds(10, 177, 58, 20);
		panel_6.add(jLabelTheLoai);
		
		JLabel jLabelNhaXB = new JLabel("Nhà Xuất Bản");
		jLabelNhaXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabelNhaXB.setBounds(10, 249, 98, 20);
		panel_6.add(jLabelNhaXB);
		
		textFieldNgayXuatBan = new JTextField();
		textFieldNgayXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNgayXuatBan.setColumns(10);
		textFieldNgayXuatBan.setBounds(505, 17, 202, 39);
		panel_6.add(textFieldNgayXuatBan);
		
		JButton buttonHuyTim = new JButton("Hủy Tìm");
		buttonHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonHuyTim.setBounds(829, 229, 115, 29);
		panel_6.add(buttonHuyTim);
		buttonHuyTim.addActionListener(action);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Quản Lý Mượn Trả", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm");
		lblNewLabel.setBounds(10, 10, 60, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 33, 1007, 141);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();

		JRadioButton RadioBtnTimKiemTheoTraSach = new JRadioButton("Theo Phiếu Mượn Trả Sách");
		RadioBtnTimKiemTheoTraSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RadioBtnTimKiemTheoTraSach.setBounds(16, 17, 197, 25);
		panel_1.add(RadioBtnTimKiemTheoTraSach);
		group.add(RadioBtnTimKiemTheoTraSach);

		JRadioButton RadioBtnTimKiemTheoMuonSach = new JRadioButton("Theo Mã Sinh Viên Mượn Sách");
		RadioBtnTimKiemTheoMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RadioBtnTimKiemTheoMuonSach.setBounds(17, 57, 219, 25);
		panel_1.add(RadioBtnTimKiemTheoMuonSach);
		group.add(RadioBtnTimKiemTheoMuonSach);

		JRadioButton RadioBtnTimiKiemTheoMaSach = new JRadioButton("Theo Mã Sách Được Mượn");
		RadioBtnTimiKiemTheoMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RadioBtnTimiKiemTheoMaSach.setBounds(16, 95, 195, 25);
		panel_1.add(RadioBtnTimiKiemTheoMaSach);
		group.add(RadioBtnTimiKiemTheoMaSach);

		
		textFieldTimKiem1 = new JTextField();
		textFieldTimKiem1.setBounds(253, 57, 521, 25);
		panel_1.add(textFieldTimKiem1);
		textFieldTimKiem1.setColumns(10);
		
		JButton buttonTimKiem1 = new JButton("Tìm Kiếm");
		buttonTimKiem1.setBounds(827, 53, 117, 37);
		panel_1.add(buttonTimKiem1);
		
		JLabel lblNewLabel_1 = new JLabel("Thông Tin Mượn Sách");
		lblNewLabel_1.setBounds(10, 184, 141, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 211, 1007, 227);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel jlabelMaSinhVien = new JLabel("Mã Sinh Viên");
		jlabelMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelMaSinhVien.setBounds(39, 33, 94, 20);
		panel_3.add(jlabelMaSinhVien);
		
		JLabel jlabelMaSach = new JLabel("Mã Sách");
		jlabelMaSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelMaSach.setBounds(39, 80, 59, 20);
		panel_3.add(jlabelMaSach);
		
		JLabel jlabelSoLuong = new JLabel("Số Lượng");
		jlabelSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelSoLuong.setBounds(39, 130, 73, 20);
		panel_3.add(jlabelSoLuong);
		
		JLabel jlabelNgayHenTra = new JLabel("Ngày Hẹn Trả");
		jlabelNgayHenTra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelNgayHenTra.setBounds(39, 178, 98, 20);
		panel_3.add(jlabelNgayHenTra);
		
		textFieldMaSinhVien = new JTextField();
		textFieldMaSinhVien.setBounds(249, 26, 530, 27);
		panel_3.add(textFieldMaSinhVien);
		textFieldMaSinhVien.setColumns(10);
		
		textFieldMaSach1 = new JTextField();
		textFieldMaSach1.setColumns(10);
		textFieldMaSach1.setBounds(249, 73, 530, 27);
		panel_3.add(textFieldMaSach1);
		
		textFieldSoLuong1 = new JTextField();
		textFieldSoLuong1.setColumns(10);
		textFieldSoLuong1.setBounds(249, 123, 530, 27);
		panel_3.add(textFieldSoLuong1);
		
		textFieldNgayHenTra = new JTextField();
		textFieldNgayHenTra.setColumns(10);
		textFieldNgayHenTra.setBounds(249, 171, 530, 27);
		panel_3.add(textFieldNgayHenTra);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(20, 682, 1007, 65);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton buttonMuonSach = new JButton("Mượn Sách");
		buttonMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonMuonSach.setBounds(41, 10, 121, 45);
		buttonMuonSach.addActionListener(action1);
		panel_4.add(buttonMuonSach);
		
		JButton buttonSuaThongTin = new JButton("Sửa Thông Tin");
		buttonSuaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonSuaThongTin.setBounds(374, 10, 143, 45);
		buttonSuaThongTin.addActionListener(action1);
		panel_4.add(buttonSuaThongTin);
		
		JButton buttonTraSach = new JButton("Trả Sách");
		buttonTraSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonTraSach.setBounds(571, 10, 106, 45);
		panel_4.add(buttonTraSach);
		
		JButton buttonXoaThongTin = new JButton("Xóa");
		buttonXoaThongTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonXoaThongTin.setBounds(735, 10, 65, 45);
		panel_4.add(buttonXoaThongTin);
		
		JButton buttonLamMoiThongTin = new JButton("Làm Mới");
		buttonLamMoiThongTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonLamMoiThongTin.setBounds(861, 10, 106, 45);
		buttonLamMoiThongTin.addActionListener(action1);
		panel_4.add(buttonLamMoiThongTin);
		
		JButton buttonCapNhat = new JButton("Cập Nhật");
		buttonCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonCapNhat.setBounds(201, 12, 129, 45);
		buttonCapNhat.addActionListener(action1);
		panel_4.add(buttonCapNhat);
		
		JLabel lblChcNng = new JLabel("Chức Năng");
		lblChcNng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcNng.setBounds(10, 664, 70, 17);
		panel.add(lblChcNng);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "M\u00E3 S\u00E1ch", "S\u1ED1 L\u01B0\u1EE3ng S\u00E1ch", "Ngày Mượn", "Ngày Hẹn Trả", "Ngày Trả", "Trạng Thái"
			}
		));
		
		scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(20, 459, 1007, 182);
		panel.add(scrollPane_1);
		

		setLocationRelativeTo(null);
		
//		testFrame = new test();
        this.setVisible(true);
	}

	public void xoaForm() {
		textFieldMaSach.setText("");
		textFieldTenSach.setText("");
		textFieldTheLoai.setText("");
		textFieldNhaXuatBan.setText("");
		textFieldNgayXuatBan.setText("");
		textFieldMaTacGia.setText("");
		textFieldSoLuong.setText("");
		textFieldGiaTien.setText("");
	}
	
	public void xoaForm1() {
		textFieldMaSinhVien.setText("");
		textFieldMaSach1.setText("");
		textFieldSoLuong1.setText("");
		textFieldNgayHenTra.setText("");
	}
	
	public void themThiSinhVaoTable(SachModel sach) {
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = sach.getNamXB().format(formatter);
	    modelTable.addRow(new Object[]{
	            sach.getMaSach()+"",
	            sach.getTenSach()+"",
	            sach.getTheLoai()+"",
	            sach.getNhaXB()+"",
	            strDate,
	            sach.getMaTacGia()+"",
	            sach.getSoLuong() + "",
	            sach.getGiaTien() + "",
	    });
	}
	
	public void themSachVaoTable(MuonTraModel muonTraModel) {
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = muonTraModel.getNgayHenTra().format(formatter);
	    modelTable.addRow(new Object[]{
	    		muonTraModel.getMaSinhVien()+"",
	    		muonTraModel.getMaSach()+"",
	    		muonTraModel.getSoLuong()+"",
	            strDate,
	    });
	}
	
	public void themHoacCapNhatSach(SachModel sach) {
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    
	    int soLuongDong = modelTable.getRowCount();
	    boolean daTonTai = false;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    for (int i = 0; i < soLuongDong; i++) {
	        String id = modelTable.getValueAt(i, 0) + "";
	        if (id.equals(sach.getMaSach())) {
	            // Xóa sách cũ khỏi model
	            this.QLSachModel.delete(sach);
	            modelTable.removeRow(i);
	            // Thêm sách mới vào model
	            this.QLSachModel.insert(sach);
	            modelTable.insertRow(i, new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getTheLoai(), sach.getNhaXB(), sach.getNamXB().format(formatter), sach.getMaTacGia(), sach.getSoLuong(), sach.getGiaTien()});
	            daTonTai = true;
	            break;
	        }
	    }

	    if (!daTonTai) {
	        this.themThiSinhVaoTable(sach);
	        if (!this.QLSachModel.kiemTraTonTai(sach)) {
	            this.QLSachModel.insert(sach);
	        }
	    }
	}


	public SachModel getSachDangChon() {
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    String maSach = modelTable.getValueAt(i_row, 0) + "";
	    String tenSach = modelTable.getValueAt(i_row, 1) + "";
	    String theLoai = modelTable.getValueAt(i_row, 2) + "";
	    String nhaXB = modelTable.getValueAt(i_row, 3) + "";
	    String s_NgayXB = modelTable.getValueAt(i_row, 4)+"";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate NgayXB = LocalDate.parse(s_NgayXB, formatter);
	    String maTacGia = modelTable.getValueAt(i_row, 5) + "";
	    int soLuong = Integer.valueOf(modelTable.getValueAt(i_row, 6) + "");
	    double giaTien = Double.valueOf(modelTable.getValueAt(i_row, 7) + "");
	    SachModel sachModel = new SachModel(maSach, tenSach, theLoai, nhaXB, NgayXB, maTacGia, soLuong, giaTien);
	    return sachModel;
	}


	public void hienThiSachDaChon() {
	    try {
	    	int i_row = table.getSelectedRow();
		    if (i_row == -1) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật.");
		        return;
		    }
	        SachModel sachModel = getSachDangChon();
	        if (sachModel == null) {
	    	        return;
	        }
	        
	        // Hiển thị thông tin sách
	        this.textFieldMaSach.setText(sachModel.getMaSach() + "");
	        this.textFieldTenSach.setText(sachModel.getTenSach() + "");
	        this.textFieldTheLoai.setText(sachModel.getTheLoai() + "");
	        this.textFieldNhaXuatBan.setText(sachModel.getNhaXB() + "");
	        
	        // Kiểm tra tính hợp lệ của ngày xuất bản
	        LocalDate namXB = sachModel.getNamXB();
	        if (namXB != null) {
	            String s_ngaySinh = namXB.getDayOfMonth() + "/" + namXB.getMonthValue() + "/" + namXB.getYear();
	            this.textFieldNgayXuatBan.setText(s_ngaySinh);
	        } else {
	            this.textFieldNgayXuatBan.setText("Ngày không hợp lệ");
	        }
	        
	        this.textFieldMaTacGia.setText(sachModel.getMaTacGia() + "");
	        
	        // Kiểm tra tính hợp lệ của số lượng
	        int soLuong = sachModel.getSoLuong();
	        if (soLuong >= 0) {
	            this.textFieldSoLuong.setText(soLuong + "");
	        } else {
	            this.textFieldSoLuong.setText("Số lượng không hợp lệ");
	        }
	        
	        // Kiểm tra tính hợp lệ của giá tiền
	        double giaTien = sachModel.getGiaTien();
	        if (giaTien >= 0) {
	            this.textFieldGiaTien.setText(giaTien + "");
	        } else {
	            this.textFieldGiaTien.setText("Giá tiền không hợp lệ");
	        }
	        
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin.");
	    }
	}

	public void thucHienXoa() {
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    if (i_row == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
	        return;
	    }
	    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa dòng đã chọn?");
	    if (luaChon == JOptionPane.YES_OPTION) {
	        SachModel sachModel = getSachDangChon();
	        if (sachModel != null) {
	            this.QLSachModel.delete(sachModel);
	            modelTable.removeRow(i_row);
	        }
	    }
	}

	public void thucHienThemSach() {
	    // Kiểm tra dữ liệu nhập vào
	    if (!validateForm()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
	        return;
	    }
	    
	    // Lấy dữ liệu từ các trường nhập vào
	    String MaSach = this.textFieldMaSach.getText();
	    String tenSach = this.textFieldTenSach.getText();
	    String theLoai = this.textFieldTheLoai.getText();
	    String nhaXB = this.textFieldNhaXuatBan.getText();
	    LocalDate ngayXB = null;
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        ngayXB = LocalDate.parse(this.textFieldNgayXuatBan.getText(), formatter);
	    } catch (DateTimeParseException e) {
	        JOptionPane.showMessageDialog(this, "Ngày xuất bản không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
	        return;
	    }
	    String maTacGia = this.textFieldMaTacGia.getText();
	    int SoLuong = 0;
	    
	    try {
	    	SoLuong = Integer.valueOf(this.textFieldSoLuong.getText());
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ.");
	        return;
	    }
	    
	    double giaTien = 0;	
	    try {
	    	giaTien = Double.valueOf(this.textFieldGiaTien.getText());
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Giá tiền không hợp lệ.");
	        return;
	    }
	    
	    // Tạo đối tượng sách
	    SachModel sach = new SachModel(MaSach, tenSach, theLoai, nhaXB, ngayXB, maTacGia, SoLuong, giaTien);
	    
	    // Thực hiện thêm hoặc cập nhật sách
	    this.themHoacCapNhatSach(sach);
	}


	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
			int soLuongDong = modelTable.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					modelTable.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SachModel sachModel : this.QLSachModel.getDsSach()) {
			this.themThiSinhVaoTable(sachModel);
		}
	}

	public void thucHienTim() {
	    // Goi ham huy tim kiem
	    this.thucHienTaiLaiDuLieu();
	    
	    // Thuc hien tim kiem
	    String maSachTimKiem = this.textFieldTimKiemTheoMaSach.getText();
	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	    int soLuongDong = modelTable.getRowCount();

	    Set<String> idCuaThiSinhCanXoa = new TreeSet<String>();
	    if (maSachTimKiem.length() > 0) {
	        for (int i = 0; i < soLuongDong; i++) {
	            String id = modelTable.getValueAt(i, 0) + "";
	            if (!id.equals(maSachTimKiem)) {
	                idCuaThiSinhCanXoa.add(id);
	            }
	        }
	    }
	    for (String idCanXoa : idCuaThiSinhCanXoa) {
	        soLuongDong = modelTable.getRowCount();
	        for (int i = 0; i < soLuongDong; i++) {
	            String idTrongTable = modelTable.getValueAt(i, 0) + "";
	            if (idTrongTable.equals(idCanXoa)) {
	                try {
	                    modelTable.removeRow(i);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;
	            }
	        }
	    }
	}

	
	public boolean validateForm() {
        return !textFieldMaSach.getText().isEmpty() && !textFieldTenSach.getText().isEmpty()
                && !textFieldTheLoai.getText().isEmpty() && !textFieldNhaXuatBan.getText().isEmpty()
                && !textFieldNgayXuatBan.getText().isEmpty()
                && !textFieldSoLuong.getText().isEmpty() && !textFieldMaTacGia.getText().isEmpty()
                && !textFieldGiaTien.getText().isEmpty();
    }

	public void thucHienHuyTim() {
		while(true) {
			DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
			int soLuongDong = modelTable.getRowCount();
			if(soLuongDong==0) {
				break;
			}
			else {
				try {
					modelTable.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for(SachModel sachModel : this.QLSachModel.getDsSach()) {
			this.themThiSinhVaoTable(sachModel);
		}
	}

	public void thucHienDong() {
		testFrame = new MenuView();
        testFrame.setVisible(true);
        setVisible(false);
	}

	public void thucHienThoat() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn đóng chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void thucHienMuonSach() {
	    // Kiểm tra nếu danh sách sách không rỗng
	    if (QLSachModel.getDsSach() != null) {
	        // Lấy thông tin từ các trường nhập vào
	        String maSinhVien = this.textFieldMaSinhVien.getText();
	        String maSach = this.textFieldMaSach1.getText();
	        int soLuongMuon = 0;
	        try {
	            soLuongMuon = Integer.parseInt(this.textFieldSoLuong1.getText());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Số lượng mượn không hợp lệ.");
	            return;
	        }
	        String ngayHenTraStr = this.textFieldNgayHenTra.getText();

	        // Kiểm tra ngày hẹn trả có đúng định dạng không
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate ngayHenTra;
	        try {
	            ngayHenTra = LocalDate.parse(ngayHenTraStr, formatter);
	        } catch (DateTimeParseException e) {
	            JOptionPane.showMessageDialog(this, "Ngày hẹn trả không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
	            return;
	        }

	        // Lấy thông tin sách từ danh sách sách
	        SachModel sachMuon = getThongTinSach(maSach);
	        if (sachMuon == null) {
	            JOptionPane.showMessageDialog(this, "Sách không tồn tại trong danh sách.");
	            return;
	        }

	        // Kiểm tra số lượng sách còn trong kho
	        if (soLuongMuon > sachMuon.getSoLuong()) {
	            JOptionPane.showMessageDialog(this, "Số lượng sách mượn vượt quá số lượng tồn trong kho.");
	            return;
	        }

	        // Tạo đối tượng MuonTraModel và thêm vào danh sách quản lý mượn trả
	        MuonTraModel muonTra = new MuonTraModel(maSinhVien, maSach, soLuongMuon, ngayHenTra);
	        themMuonTra(muonTra);

	        // Cập nhật số lượng sách trong danh sách sách
	        sachMuon.setSoLuong(sachMuon.getSoLuong() - soLuongMuon);
	        QLSachModel.capNhatSach(sachMuon);
	        
	        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	        for (int i = 0; i < modelTable.getRowCount(); i++) {
	            if (modelTable.getValueAt(i, 1).equals(maSach)) {
	                modelTable.setValueAt(sachMuon.getSoLuong(), i, 6);
	                break;
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Không có sách trong kho để mượn.");
	    }
	}


	
	public SachModel getThongTinSach(String maSach) {
	    for (SachModel sach : QLSachModel.getDsSach()) {
	        if (sach.getMaSach().equals(maSach)) {
	            return sach;
	        }
	    }
	    return null;
	}
	


	// Trong phương thức thêmMuonTra():
	public void themMuonTra(MuonTraModel muonTra) {
	    DefaultTableModel modelTable = (DefaultTableModel) table_1.getModel();
	    boolean daTonTai = false;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    for (int i = 0; i < modelTable.getRowCount(); i++) {
	        if (muonTra.getMaSinhVien().equals(modelTable.getValueAt(i, 0)) && muonTra.getMaSach().equals(modelTable.getValueAt(i, 1))) {
	            daTonTai = true;
	            break;
	        }
	    }

	    if (!daTonTai) {
	        LocalDateTime now = LocalDateTime.now();
	        LocalDate dateNow = now.toLocalDate(); // Chuyển LocalDateTime thành LocalDate
	        String ngayMuon = now.format(formatter);
	        String ngayTra = now.plusDays(14).format(formatter); // giả sử ngày trả là 14 ngày sau ngày mượn

	        // Kiểm tra nếu ngày hẹn trả nhỏ hơn ngày mượn
	        if (muonTra.getNgayHenTra().isBefore(dateNow)) { // Sử dụng dateNow thay vì now
	            JOptionPane.showMessageDialog(this, "Ngày hẹn trả không được nhỏ hơn ngày mượn.");
	            return;
	        }

	        // Kiểm tra nếu ngày hẹn trả lớn hơn ngày trả
	        LocalDate ngayHenTra = muonTra.getNgayHenTra();
	        LocalDate ngayTraLocalDate = LocalDate.parse(ngayTra, formatter);
	        if (ngayHenTra.isAfter(ngayTraLocalDate)) {
	            JOptionPane.showMessageDialog(this, "Ngày hẹn trả không được lớn hơn ngày trả, thời hạn mượn sách là 14 ngày.");
	            return;
	        }

	        modelTable.addRow(new Object[]{muonTra.getMaSinhVien(), muonTra.getMaSach(), muonTra.getSoLuong(), ngayMuon, muonTra.getNgayHenTra().format(formatter), ngayTra, "Chưa trả"});
	        if (!this.QLMuonTraModel.kiemTraTonTai(muonTra)) {
	            this.QLMuonTraModel.insert(muonTra);
	        }
	        this.QLMuonTraModel.capNhatSoLuongSach(muonTra.getMaSach(), muonTra.getSoLuong());
	        JOptionPane.showMessageDialog(this, "Thông tin mượn trả đã được thêm vào.");
	    }
	}
	
	public MuonTraModel getThongTinMuonTraDangChon() {
	    DefaultTableModel modelTable = (DefaultTableModel) table_1.getModel();
	    int i_row = table_1.getSelectedRow();
	    String maSinhVien = modelTable.getValueAt(i_row, 0) + "";
	    String maSach = modelTable.getValueAt(i_row, 1) + "";
	    int soLuong = Integer.valueOf(modelTable.getValueAt(i_row, 2) + "");
	    String s_NgayHenTra = modelTable.getValueAt(i_row, 4)+"";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate NgayHenTra = LocalDate.parse(s_NgayHenTra, formatter);
	    MuonTraModel muonTraModel = new MuonTraModel(maSinhVien, maSach, soLuong, NgayHenTra);
	    return muonTraModel;
	}
	
	public void capNhatThongTinMuonTra() {
		try {
	    	int i_row = table_1.getSelectedRow();
		    if (i_row == -1) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật.");
		        return;
		    }
	        MuonTraModel muonTraModel = getThongTinMuonTraDangChon();
	        if (muonTraModel == null) {
	    	        return;
	        }
	        
	        // Hiển thị thông tin sách
	        this.textFieldMaSinhVien.setText(muonTraModel.getMaSinhVien() + "");
	        this.textFieldMaSach1.setText(muonTraModel.getMaSach() + "");
	        int soLuong = muonTraModel.getSoLuong();
	        if (soLuong >= 0) {
	            this.textFieldSoLuong1.setText(soLuong + "");
	        } else {
	            this.textFieldSoLuong1.setText("Số lượng không hợp lệ");
	        }
	        
	        // Kiểm tra tính hợp lệ của ngày hẹn trả
	        LocalDate ngayHenTra = muonTraModel.getNgayHenTra();
	        if (ngayHenTra != null) {
	            String s_ngayHenTra = ngayHenTra.getDayOfMonth() + "/" + ngayHenTra.getMonthValue() + "/" + ngayHenTra.getYear();
	            this.textFieldNgayHenTra.setText(s_ngayHenTra);
	        } else {
	            this.textFieldNgayHenTra.setText("Ngày không hợp lệ");
	        }
	        
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin.");
	    }
	}

	public void thucHienSuaThongTinMuonTra() {
		int i_row = table_1.getSelectedRow();
	    if (i_row == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa thông tin.");
	        return;
	    }
	    // Kiểm tra nếu danh sách sách không rỗng
	    if (QLSachModel.getDsSach() != null) {
	        // Lấy thông tin từ các trường nhập vào
	        String maSinhVien = this.textFieldMaSinhVien.getText();
	        String maSach = this.textFieldMaSach1.getText();
	        int soLuongMuonMoi = 0;
	        try {
	            soLuongMuonMoi = Integer.parseInt(this.textFieldSoLuong1.getText());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Số lượng mượn không hợp lệ.");
	            return;
	        }
	        String ngayHenTraStr = this.textFieldNgayHenTra.getText();

	        // Kiểm tra ngày hẹn trả có đúng định dạng không
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate ngayHenTra;
	        try {
	            ngayHenTra = LocalDate.parse(ngayHenTraStr, formatter);
	        } catch (DateTimeParseException e) {
	            JOptionPane.showMessageDialog(this, "Ngày hẹn trả không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
	            return;
	        }

	        // Lấy thông tin sách từ danh sách sách
	        SachModel sachMuon = QLSachModel.timSachTheoMa(maSach);
	        if (sachMuon == null) {
	            JOptionPane.showMessageDialog(this, "Sách không tồn tại trong danh sách.");
	            return;
	        }

	        // Lấy thông tin mượn trả hiện tại
	        MuonTraModel muonTraHienTai = getThongTinMuonTraDangChon();
	        int soLuongMuonCu = muonTraHienTai.getSoLuong();

	        // Kiểm tra số lượng sách còn trong kho
	        if (soLuongMuonMoi > soLuongMuonCu + sachMuon.getSoLuong()) {
	            JOptionPane.showMessageDialog(this, "Số lượng sách mượn vượt quá số lượng tồn trong kho.");
	            return;
	        }

	        // Tạo đối tượng MuonTraModel và thêm vào danh sách quản lý mượn trả
	        MuonTraModel muonTra = new MuonTraModel(maSinhVien, maSach, soLuongMuonMoi, ngayHenTra);
	        themMuonTra(muonTra);

	        // Cập nhật số lượng sách trong danh sách sách
	        if (soLuongMuonMoi < soLuongMuonCu) {
	            sachMuon.setSoLuong(sachMuon.getSoLuong() + soLuongMuonCu - soLuongMuonMoi);
	        } else if (soLuongMuonMoi > soLuongMuonCu) {
	            sachMuon.setSoLuong(sachMuon.getSoLuong() - soLuongMuonMoi + soLuongMuonCu);
	        }
	        QLSachModel.capNhatSach(sachMuon);
	        
	        // Cập nhật số lượng sách trong bảng thông tin mượn sách
	        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
	        for (int i = 0; i < modelTable.getRowCount(); i++) {
	            if (modelTable.getValueAt(i, 1).equals(maSach)) {
	                modelTable.setValueAt(sachMuon.getSoLuong(), i, 6);
	                break;
	            }
	        }
	        
	        modelTable = (DefaultTableModel) table_1.getModel();
	        for (int i = 0; i < modelTable.getRowCount(); i++) {
	            if (modelTable.getValueAt(i, 1).equals(maSach)) {
	                modelTable.setValueAt(soLuongMuonMoi, i, 2);
	                modelTable.setValueAt(ngayHenTraStr, i, 4);
	                break;
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Không có sách trong kho để mượn.");
	    }
	}
} 

