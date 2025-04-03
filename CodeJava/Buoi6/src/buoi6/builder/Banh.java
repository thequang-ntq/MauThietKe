package buoi6.builder;

public class Banh {
	// thuộc tính bắt buộc có
	private double đường;
	private double bột;
	
	// thuộc tính tuỳ chọn
	private double vani;
	private double nướcDừa;
	private double cacao;
	private double ớt;
	private double tiêu;
	
	//Set ở ngoài thì sao?
	public Banh(double đường, double bột) {
		this.đường = đường;
		this.bột = bột;
	}
	
	public Banh vani(double value) {
		this.vani = value;
		return this;
	}
	//Mang tính thử nghiệm
	//
	
	
	//1. inner class Builder, thuộc tính giống hệt class ngoài
	public static class BanhBuilder{
		// thuộc tính bắt buộc có
		private double đường;
		private double bột;
		
		// thuộc tính tuỳ chọn
		private double vani;
		private double nướcDừa;
		private double cacao;
		private double ớt;
		private double tiêu;
		
		//2. Tạo constructor với 2 TT bắt buộc
		public BanhBuilder(double đường, double bột) {
			this.đường = đường;
			this.bột = bột;
		}
		
		//3.Với mỗi thuộc tính là optional, tạo hàm builder cho thuộc tính đó
		public BanhBuilder vani(double value) {
			this.vani = value;
			return this;
		}
		public BanhBuilder nướcDừa(double value) {
			this.nướcDừa = value;
			return this;
		}
		public BanhBuilder cacao(double value) {
			this.cacao = value;
			return this;
		}
		public BanhBuilder ớt(double value) {
			this.ớt = value;
			return this;
		}
		public BanhBuilder tiêu(double value) {
			this.tiêu = value;
			return this;
		}
		
		//4. Tạo hàm Build
		public Banh build() {
			return new Banh(this);
		}
	}
	
	//5. Hàm dựng với đối số Builder
	public Banh(BanhBuilder x) {
		this.đường = x.đường;
		this.bột = x.bột;
		this.vani = x.vani;
		this.nướcDừa = x.nướcDừa;
		this.cacao = x.cacao;
		this.ớt = x.ớt;
		this.tiêu = x.tiêu;
	}
	
	public String toString() {
		return "Bánh: đường-" + this.đường + " bột-" + this.bột + " vani-" + this.vani + " nước dừa-" + this.nướcDừa  
				+ " cacao-" + this.cacao + " ớt-" + this.ớt + " tiêu-" + this.tiêu;
	}
}
