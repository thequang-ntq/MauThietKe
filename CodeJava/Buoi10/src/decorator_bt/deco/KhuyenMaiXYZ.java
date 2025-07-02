package decorator_bt.deco;

import decorator_bt.component.ThueBao;

public class KhuyenMaiXYZ extends KhuyenMai {

    @Override
    public int getPhiThueBao() {
        return this.x.getPhiThueBao();
    }

    @Override
    public int getSoPhutGoiFree() {
        return this.x.getSoPhutGoiFree();
    }

    @Override
    public int getSoTinNhanFree() {
        return this.x.getSoTinNhanFree();
    }

    @Override
    public int getGiaGoi() {
        return 0;
    }

    @Override
    public int getGiaTinNhan() {
        return this.x.getGiaTinNhan();
    }
    
    public KhuyenMaiXYZ(ThueBao x) throws Exception {
    	super(x);
	}
    
}
