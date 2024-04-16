package model;

public class Grade {
	private int id;
	private SinhVien sv;
	private double Toan, Ly, Hoa;
	
	public Grade() {
	}

	public Grade(int id, SinhVien sv, double toan, double ly, double hoa) {
		super();
		this.id = id;
		this.sv = sv;
		Toan = toan;
		Ly = ly;
		Hoa = hoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SinhVien getSv() {
		return sv;
	}

	public void setSv(SinhVien sv) {
		this.sv = sv;
	}

	public double getToan() {
		return Toan;
	}

	public void setToan(double toan) {
		Toan = toan;
	}

	public double getLy() {
		return Ly;
	}

	public void setLy(double ly) {
		Ly = ly;
	}

	public double getHoa() {
		return Hoa;
	}

	public void setHoa(double hoa) {
		Hoa = hoa;
	}

	public double getTBC() {
		return (getToan () + getLy() + getHoa())/3;
	}
	public String getXepLoai() {
		String xl = "";
		double tbc = getTBC();
		if(tbc>=8) {
			xl = "GIOI";
		}else if (tbc>=7) {
			xl = "KHA";
		}else if(tbc >= 5) {
			xl = "TRUNG BINH";
		}else {
			xl ="YEU";
		}
		return xl;
	}}

