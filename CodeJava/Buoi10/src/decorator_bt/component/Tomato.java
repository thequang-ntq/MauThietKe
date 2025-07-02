package decorator_bt.component;

public class Tomato extends ThueBao {

    @Override
    public int getPhiThueBao() {
        return 50000;
    }

    @Override
    public int getSoPhutGoiFree() {
        return 100;
    }

    @Override
    public int getSoTinNhanFree() {
        return 50;
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

