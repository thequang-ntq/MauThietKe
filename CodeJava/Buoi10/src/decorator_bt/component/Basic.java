package decorator_bt.component;

public class Basic extends ThueBao{
	@Override
    public int getPhiThueBao() {
        return 10000;
    }

    @Override
    public int getSoPhutGoiFree() {
        return 10;
    }

    @Override
    public int getSoTinNhanFree() {
        return 5;
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
