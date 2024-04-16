package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.SinhVien;
import model.SinhVienDAO;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class SinhVienDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaSV;
	static JTextField txtTenSV;
	private JTextField txtNgaySinh;
	private JTable table_1;
	private DefaultTableModel tableModel;
	private ButtonGroup btn_gioiTinh;
	private AbstractButton rdNam;
	private AbstractButton rdNu;
	
	private ActionListener actionlistener;
	private JTextField textField;
	private JTextField txtdiachi;
	public DateFormat date_format;
	public  SinhVienDAO dao;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			SinhVienDialog dialog = new SinhVienDialog();
			dialog.fillDateTABLE();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SinhVienDialog() {
		setTitle("Quản lý thông tin");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu jMenuHeThong = new JMenu("Hệ Thống");
		menuBar.add(jMenuHeThong);
//		jMenuHeThong.addActionListener(action);
		
		JMenuItem jMenuDong = new JMenuItem("Đóng");
		jMenuHeThong.add(jMenuDong);
		jMenuDong.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Do something when "Đóng" is clicked
	        	new MenuView();
	        	setVisible(false);
	        }
	    });
		
		JMenuItem jMenuThoat = new JMenuItem("Thoát");
		jMenuHeThong.add(jMenuThoat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		jMenuThoat.addActionListener(action);
		jMenuThoat.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Do something when "Đóng" is clicked
	        	MenuView.thoatKhoiChuongTrinh();	
	        }
	    });
		
		
		date_format= new SimpleDateFormat("dd/mm/yyyy");
		dao =new SinhVienDAO();
		
		setBounds(100, 100, 679, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblNewLabel.setBounds(197, 11, 307, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("MÃ SINH VIÊN");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(33, 81, 108, 32);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("HỌ VÀ TÊN");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(33, 124, 108, 32);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("NGÀY SINH");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(33, 167, 108, 32);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("GIỚI TÍNH");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(33, 203, 108, 32);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ĐỊA CHỈ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(33, 264, 108, 32);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtMaSV = new JTextField();
			txtMaSV.setBounds(169, 81, 147, 28);
			contentPanel.add(txtMaSV);
			txtMaSV.setColumns(10);
		}
		{
			txtTenSV = new JTextField();
			txtTenSV.setColumns(10);
			txtTenSV.setBounds(169, 128, 147, 28);
			contentPanel.add(txtTenSV);
		}
		{
			txtNgaySinh = new JTextField();
			txtNgaySinh.setColumns(10);
			txtNgaySinh.setBounds(169, 175, 147, 28);
			contentPanel.add(txtNgaySinh);
		}
		{
			rdNam = new JRadioButton("NAM");
			rdNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
			rdNam.setBounds(169, 208, 68, 23);
			contentPanel.add(rdNam);
		}
		{
			rdNu = new JRadioButton("NỮ");
			rdNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			rdNu.setBounds(248, 210, 68, 23);
			contentPanel.add(rdNu);
		}
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdNam);
		btn_gioiTinh.add(rdNu);
		JScrollPane scrollPane = new JScrollPane();
		
		
        scrollPane.setBounds(33, 391, 569, 106);
        contentPanel.add(scrollPane);

        table_1 = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9"
        	}
        ));
        table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        scrollPane.setViewportView(table_1);
        
        //xử lý sự kiện click chuột
        table_1.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				int id= table_1.rowAtPoint(e.getPoint());
					String masv=table_1.getValueAt(id,0).toString();
					SinhVien sv=dao.getSinhVienByID(masv);
					setModel(sv);
			}
		});
        {
        	JButton btnThem = new JButton("THÊM");
        	btnThem.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
        				String cm = e.getActionCommand();
        				if(cm.equals("THÊM")) {
        					reset();
        				}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
        		}
        	});
        	btnThem.setBounds(396, 290, 89, 23);
        	contentPanel.add(btnThem);
        }
   
 
        {
        	JButton btnLuu = new JButton("LƯU");
        	btnLuu.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
        				String cm = e.getActionCommand();
        				if(cm.equals("LƯU")) {
        					
        					if(validateForm()) {
        						try {
        						SinhVien sv= getModel();
        						if(dao.getSinhVienByID(sv.getMaSV())!=null) {
        							JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");		
        						} else {
        							if(dao.add(sv)>0) {
        							JOptionPane.showMessageDialog(null, "Lưu thành công");	
        							try {
										fillDateTABLE();
									} catch (Exception e2) {
										// TODO: handle exception
										e2.printStackTrace();
									}
        						}
        						}
        					}catch (Exception e2) {
								e2.printStackTrace();
							}
        					}else {
        						JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra thông tin", "Thông báo",JOptionPane.WARNING_MESSAGE);
        					}
        				}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
        		}
        	});
        	btnLuu.setBounds(513, 290, 89, 23);
        	contentPanel.add(btnLuu);
        }
        {
        	JButton btnSua = new JButton("CẬP NHẬT");
        	btnSua.setHorizontalAlignment(SwingConstants.LEFT);
        	btnSua.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
						String cm=e.getActionCommand();
						if(cm.equals("CẬP NHẬT")) {
									if(validateForm()) {
										try {
											SinhVien sv= getModel();
											if(dao.updateSinhVienByID(sv)>0) {
												JOptionPane.showMessageDialog(null, "Cập nhật thành công");
												fillDateTABLE();
											}
										} catch (Exception e2) {
											e2.printStackTrace();		
										}
								}
							else {
								JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra thông tin");
							}
						}
        			}
					catch (Exception e2) {
						e2.printStackTrace();	
					}
        		}
        	});
        	btnSua.setBounds(396, 327, 97, 23);
        	contentPanel.add(btnSua);
        }
        {
        	JButton btnXoa = new JButton("XÓA");
        	btnXoa.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
        				String cm = e.getActionCommand();
        				if(cm.equals("XÓA")) {	
        					if(txtMaSV.getText().isEmpty()) {
        						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sinh viên ");	
        					} else {
        						if(dao.delSinhVienByID(txtMaSV.getText())>0) {
        							JOptionPane.showMessageDialog(null, "Xóa thành công");
        							fillDateTABLE();
        						} else {
        							JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên để xóa");
        						}
        					}
        				}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
        		}
        	});
        	btnXoa.setBounds(513, 327, 89, 23);
        	contentPanel.add(btnXoa);
        }
        {
	    	txtdiachi = new JTextField();
	    	txtdiachi.setBounds(166, 263, 150, 38);
	    	contentPanel.add(txtdiachi);
	    	txtdiachi.setColumns(10);
	    }
	    
        try {
		    BufferedImage originalImage = ImageIO.read(new File("D:\\BtlQuanlisinhvien\\BTLQuanLySinhVien\\image\\ảnh làm giao diện.jpg")); // Đường dẫn tệp hình ảnh
		    int newWidth = originalImage.getWidth() / 6; // Example: Reduce width by half
		    int newHeight = originalImage.getHeight() / 6; // Example: Reduce height by half
		    Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		    ImageIcon icon = new ImageIcon(scaledImage);
		    JLabel label_hinhanh = new JLabel(icon);
		    label_hinhanh.setBounds(400, 81, newWidth, newHeight); // Đặt kích thước của JLabel
		    contentPanel.add(label_hinhanh); // Thêm JLabel vào contentPane
		    {
		    	JLabel lblNewLabel_1 = new JLabel("THÔNG TIN SINH VIÊN");
		    	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    	lblNewLabel_1.setBounds(221, 361, 198, 32);
		    	contentPanel.add(lblNewLabel_1);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
        
	}
		
	
		
	public SinhVien getModel() throws ParseException{
		SinhVien sv = new SinhVien();
		sv.setMaSV(txtMaSV.getText());
		sv.setTenSV(txtTenSV.getText());	
		java.util.Date ngaySinh=date_format.parse(txtNgaySinh.getText());
		sv.setNgaySinh(ngaySinh);
		boolean gt= false;
		if(rdNam.isSelected()) {
			gt=true;
		}
		sv.setGioiTinh(gt);
		sv.setDiaChi(txtdiachi.getText());
		return sv;
	}
	public void reset() {
        	txtMaSV.setText("");
        	txtTenSV.setText("");
        	txtNgaySinh.setText("");
        	btn_gioiTinh.clearSelection();
        	txtdiachi.setText("");
        }
	
	public boolean validateForm() {
		if(txtMaSV.getText().isEmpty()
				|| txtTenSV.getText().isEmpty()
				|| txtNgaySinh.getText().isEmpty()
				|| txtdiachi.getText().isEmpty()
				) 
		{
			return false;
		}
		else {
			    String ngaySinhString= txtNgaySinh.getText();
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate ngaySinh = null;
				try {
					ngaySinh = LocalDate.parse(ngaySinhString, formatter);
					if (ngaySinh.isAfter(LocalDate.now())) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
	                return false; // Ngày sinh không hợp lệ
	            }
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			} 
		return true;
	}
	
	public void fillDateTABLE() {	
		DateFormat date_format= new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.setRowCount(0);//clear table
		for(SinhVien sv : dao.getAllSinhVien()) {
	        Object[] rowData = new Object[5];
	        rowData[0] =sv.getMaSV();
	        rowData[1] =sv.getTenSV() ;
	        rowData[2] = date_format.format(sv.getNgaySinh());
	        rowData[3] = sv.isGioiTinh()? "Nam" : "Nữ";
	        rowData[4] = sv.getDiaChi();
	        model_table.addRow(rowData);
	    }
		
	}
	public void setModel(SinhVien sv) {
		DateFormat date_format= new SimpleDateFormat("dd/MM/yyyy");
		txtMaSV.setText(sv.getMaSV());
		txtTenSV.setText(sv.getTenSV());
		txtNgaySinh.setText(date_format.format(sv.getNgaySinh()));
		txtdiachi.setText(sv.getDiaChi());
		boolean gt=sv.isGioiTinh();
		if(sv.isGioiTinh()) {
			rdNam.setSelected(true);
			
			
		} else {
			rdNu.setSelected(true);
		}
		
	}
	
	public SinhVien getSinhVienDangChon() {
		DateFormat date_format= new SimpleDateFormat("dd/mm/yyyy");
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		int i_row = table_1.getSelectedRow();
		String maSV =(model_table.getValueAt(i_row, 0) + "");
		String tenSV= model_table.getValueAt(i_row, 1) + "";
		String s_ngaySinh = model_table.getValueAt(i_row, 2).toString();
	    java.util.Date ngaySinh = null;
	    try {
	        ngaySinh = date_format.parse(s_ngaySinh);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		String textGioiTinh = model_table.getValueAt(i_row, 3) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		String diachi=model_table.getValueAt(i_row, 4)+" ";
		SinhVien sv = new SinhVien(maSV, tenSV,ngaySinh,gioiTinh, diachi);
		return sv;
	}
	
	public void hienThiThongTinSinhVienDaChon() {
		DateFormat date_format= new SimpleDateFormat("dd/mm/yyyy");
		SinhVien sv = getSinhVienDangChon();
		this.txtMaSV.setText(sv.getMaSV() + "");
		this.txtTenSV.setText(sv.getTenSV() + "");
		String s_ngaySinh = date_format.format(sv.getNgaySinh());
		this.txtNgaySinh.setText(s_ngaySinh + "");
		if (sv.isGioiTinh()) {
			rdNam.setSelected(true);
		} else {
			rdNu.setSelected(true);
		}}
	
}
