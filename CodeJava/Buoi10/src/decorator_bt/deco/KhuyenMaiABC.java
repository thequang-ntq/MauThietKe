package decorator_bt.deco;

import decorator_bt.component.ThueBao;

public class KhuyenMaiABC extends KhuyenMai {

    @Override
    public int getPhiThueBao() {
        return this.x.getPhiThueBao(); // không thay đổi
    }

    @Override
    public int getSoPhutGoiFree() {
        return this.x.getSoPhutGoiFree();
    }

    @Override
    public int getSoTinNhanFree() {
        return this.x.getSoTinNhanFree() + 1000;
    }

    @Override
    public int getGiaGoi() {
        return this.x.getGiaGoi();
    }

    @Override
    public int getGiaTinNhan() {
        return this.x.getGiaTinNhan();
    }
    
    public KhuyenMaiABC(ThueBao x) throws Exception {
    	super(x);
	}
    
}
