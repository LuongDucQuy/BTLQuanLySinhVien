package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Grade;
import model.GradeDAO;
import model.SinhVien;
import model.SinhVienDAO;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
//import java.lang.ArrayIndexOutOfBoundsException;

public class QuanLyDiem extends JDialog {

	public static final long serialVersionUID = 1L;
	public JTextField txtMaSV;
	public JTextField txtTenSV;
	public JTextField txtToan;
	public JTextField txtLy;
	public JTextField txtHoa;
	public JTable tbDiem;
	public JTextField txtFindMaSV;
	SinhVienDAO svDAO = new SinhVienDAO();
	GradeDAO dDAO = new GradeDAO();
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			QuanLyDiem dialog = new QuanLyDiem();
			dialog.fillDataTABLE();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public QuanLyDiem() {
		setTitle("Quản lý điểm");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu jMenuHeThong = new JMenu("Hệ Thống");
		menuBar.add(jMenuHeThong);
//		jMenuHeThong.addActionListener(action);
		
		JMenuItem jMenuDong = new JMenuItem("Đóng");
		jMenuHeThong.add(jMenuDong);
//		jMenuDong.addActionListener(action);
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
		jMenuThoat.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Do something when "Đóng" is clicked
	        	MenuView.thoatKhoiChuongTrinh();	
	        }
	    });
		
//		jMenuThoat.addActionListener(action);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ ĐIỂM SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(234, 29, 294, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblMaSinhVien = new JLabel("MÃ SINH VIÊN :");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaSinhVien.setBounds(10, 164, 148, 39);
		getContentPane().add(lblMaSinhVien);
		
		JLabel lblTenSV = new JLabel("HỌ VÀ TÊN :");
		lblTenSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenSV.setBounds(10, 212, 148, 39);
		getContentPane().add(lblTenSV);
		
		JLabel lblToan = new JLabel("TOÁN :");
		lblToan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToan.setBounds(10, 261, 148, 39);
		getContentPane().add(lblToan);
		
		JLabel lblLy = new JLabel("LÝ :");
		lblLy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLy.setBounds(10, 310, 148, 39);
		getContentPane().add(lblLy);
		
		JLabel lblHoa = new JLabel("HÓA :");
		lblHoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoa.setBounds(10, 359, 148, 39);
		getContentPane().add(lblHoa);
		
		txtMaSV = new JTextField();
		txtMaSV.setBounds(188, 171, 186, 33);
		getContentPane().add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtTenSV = new JTextField();
		txtTenSV.setColumns(10);
		txtTenSV.setBounds(188, 219, 186, 33);
		getContentPane().add(txtTenSV);
		
		txtToan = new JTextField();
		txtToan.setColumns(10);
		txtToan.setBounds(188, 267, 186, 33);
		getContentPane().add(txtToan);
		
		txtLy = new JTextField();
		txtLy.setColumns(10);
		txtLy.setBounds(188, 316, 186, 33);
		getContentPane().add(txtLy);
		
		txtHoa = new JTextField();
		txtHoa.setColumns(10);
		txtHoa.setBounds(188, 359, 186, 33);
		getContentPane().add(txtHoa);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFindMaSV.setText("");
				txtMaSV.setText("");
	        	txtTenSV.setText("");
	        	txtToan.setText("");
	        	txtLy.setText("");
	        	txtHoa.setText("");
			}
		});
		btnThem.setBounds(434, 192, 85, 39);
		getContentPane().add(btnThem);
	

		JButton btnLuu = new JButton("LƯU");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( validateForm() ) {
					Grade g = getModel();
					if(dDAO.getOneGradeByMaSV(g.getSv().getMaSV())!=null) {
						JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
					} else { 
						if(dDAO.add(g)>0) {
						fillDataTABLE();
					}
				else {
					JOptionPane.showMessageDialog(null," Xin vui long kiem tra thong tin ");
				} 
					}
					}	
			}
		});
		btnLuu.setBounds(434, 241, 85, 39);
		getContentPane().add(btnLuu);
		
		JButton btnSua = new JButton("SỬA");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateForm()) {
					Grade g = getModel();
					if(dDAO.updateGrade(g)>0) {
						JOptionPane.showMessageDialog(null,"Cap nhat thanh cong");
						fillDataTABLE();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ban chua nhap thong tin");
				}
			}
		});
		btnSua.setBounds(434, 290, 85, 39);
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (txtMaSV.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên để xóa.");
		            return;
		        }

		        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) {
		            String maSV = txtMaSV.getText();
		            if (dDAO.delGrade(maSV) > 0) {
		                JOptionPane.showMessageDialog(null, "Xóa thành công.");
		                fillDataTABLE(); // Reload data after deletion
		            } else {
		                JOptionPane.showMessageDialog(null, "Xóa không thành công. Mã sinh viên không tồn tại.");
		            }
		        }
		    }
		});

//		btnXoa.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//			if( validateForm()) {
//				if(dDAO.delGrade(txtMaSV.getText())>0) {
//					fillDataTABLE();
//			}
//		}else {
//			JOptionPane.showMessageDialog(null," Xin vui long kiem tra thong tin ");
//		} 
//	}
//		
//	});

		
		btnXoa.setBounds(434, 339, 85, 39);
		getContentPane().add(btnXoa);
		
		tbDiem = new JTable();
		tbDiem.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
				int index = tbDiem.rowAtPoint(e.getPoint());
//				String masv = tbDiem.getValueAt(id, 0).toString();
				Grade d = getGradeAtPosition(index);
				setModel(d);

		    }
		});

		
		tbDiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 SV", "T\u00EAn SV", "To\u00E1n", "L\u00FD", "H\u00F3a", "TBC", "X\u1EBFp Lo\u1EA1i"
			}
		));
//		JLabel lblTBC = new JLabel("0.0");
//		lblTBC.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblTBC.setBounds(208, 408, 60, 39);
//		getContentPane().add(lblTBC);
		setBounds(100, 100, 660, 639);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tbDiem);
		scrollPane.setBounds(22, 464, 520, 91);
		getContentPane().add(scrollPane);		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 78, 582, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMSinhVin_1 = new JLabel("MÃ SINH VIÊN :");
		lblMSinhVin_1.setBounds(10, 28, 143, 25);
		lblMSinhVin_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblMSinhVin_1);
		
		txtFindMaSV = new JTextField();
		txtFindMaSV.setColumns(10);
		txtFindMaSV.setBounds(187, 28, 186, 33);
		panel.add(txtFindMaSV);
		txtMaSV.setEditable(false);
		txtTenSV.setEditable(false);
		
		JButton btnTimKiem = new JButton("TÌM KIẾM");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFindMaSV.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ban chua nhap ma sinh vien");
				}else {
//					String maSV=txtFindMaSV.getText();
//					String tenSV=SinhVienDialog.txtTenSV.getText();
					SinhVien sv = svDAO.getSinhVienByID(txtFindMaSV.getText());
					try {
						if(sv!=null) {
					    txtMaSV.setText(sv.getMaSV());
						txtTenSV.setText(sv.getTenSV());
						txtToan.setText("");
						txtLy.setText("");
						txtHoa.setText("");
						}
					
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Không có mã sinh viên cần tìm");
					}
						
				}}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(424, 23, 115, 39);
		panel.add(btnTimKiem);
	
	}
		
	public boolean validateForm() {
		if(txtMaSV.getText().isEmpty()
				|| txtTenSV.getText().isEmpty()
				|| txtToan.getText().isEmpty()
				|| txtLy.getText().isEmpty()
				|| txtHoa.getText().isEmpty() ) {
		return false;
		}else {
			try {
				double Toan = Double.parseDouble(txtToan.getText());
				double Ly = Double.parseDouble(txtLy.getText());
	            double Hoa = Double.parseDouble(txtHoa.getText());
				if(Toan < 0 || Toan > 10 || Ly < 0 || Ly > 10 ||
		                Hoa < 0 || Hoa > 10) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	
	
	public Grade getModel(){
		Grade g = new Grade();
		g.setId(0);
		SinhVien sv = new SinhVien(txtMaSV.getText(), txtTenSV.getText() );
		g.setSv(sv);
		g.setToan(Double.parseDouble(txtToan.getText()));
		g.setLy(Double.parseDouble(txtLy.getText()));
		g.setHoa(Double.parseDouble(txtHoa.getText()));
		return g;
	}
	
	
	public void fillDataTABLE() {
		DefaultTableModel model = (DefaultTableModel) tbDiem.getModel();
		model.setRowCount(0);
		for (Grade g : dDAO.getAllGrade()) {
			Object rowData[] = new Object[7];
			rowData[0] = g.getSv().getMaSV();
			rowData[1] = g.getSv().getTenSV();
			rowData[2] = g.getToan();
			rowData[3] = g.getLy();
			rowData[4] = g.getHoa();
			rowData[5] = String.format("%.2f",g.getTBC());
			rowData[6] = g.getXepLoai();
			model.addRow(rowData);
		}
	}
	public void setModel(Grade g){
		txtMaSV.setText(g.getSv().getMaSV());
		txtTenSV.setText(g.getSv().getTenSV());
		txtToan.setText(String.valueOf(g.getToan()));
		txtLy.setText(String.valueOf(g.getLy()));
		txtHoa.setText(String.valueOf(g.getHoa()));
	}

	public Grade getGradeAtPosition(int pos) {
		Grade g = new Grade();
		SinhVien sv = new SinhVien();
		sv.setMaSV(tbDiem.getValueAt(pos,0).toString());
		sv.setTenSV(tbDiem.getValueAt(pos,1).toString());
		g.setSv(sv);
		g.setToan(Double.parseDouble(tbDiem.getValueAt(pos,2).toString()));
		g.setLy(Double.parseDouble(tbDiem.getValueAt(pos,3).toString()));
		g.setHoa(Double.parseDouble(tbDiem.getValueAt(pos,4).toString()));
		return g;
		
	}
	
	
}

