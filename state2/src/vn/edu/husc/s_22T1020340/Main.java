package vn.edu.husc.s_22T1020340;

public class Main {
    public static void main(String[] args) {
        Phone dt = new Phone();

        // 1.a) thiết lập trạng thái Ngoài trời cho dt
        dt.setTrangThai(new Outdoor());

        // 1.b) mô phỏng có tin nhắn đến
        System.out.println("Tin nhắn đến:");
        dt.CoTinNhan();

        // 1.c) mô phỏng có sự kiện hệ thống
        System.out.println("Sự kiện hệ thống:");
        dt.CoTBHeThong();

        // 1.d) mô phỏng có cuộc gọi đến
        System.out.println("Cuộc gọi đến:");
        dt.CoCuocGoiDen();

        // 2.a) thiết lập trạng thái Yên lặng cho dt
        dt.setTrangThai(new Silent());

        // 2.b) mô phỏng có tin nhắn đến
        System.out.println("Tin nhắn đến (Yên lặng):");
        dt.CoTinNhan();

        // 2.c) mô phỏng có cuộc gọi đến
        System.out.println("Cuộc gọi đến (Yên lặng):");
        dt.CoCuocGoiDen();
    }
}
