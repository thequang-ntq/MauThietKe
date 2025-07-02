package decorator_bt.component;

public class VIP extends ThueBao {
	@Override
    public int getPhiThueBao() {
        return 200000;
    }

    @Override
    public int getSoPhutGoiFree() {
        return 1000;
    }

    @Override
    public int getSoTinNhanFree() {
        return 500;
    }

    @Override
    public int getGiaGoi() {
        return 1000;
    }

    @Override
    public int getGiaTinNhan() {
        return 500;
    }
}
