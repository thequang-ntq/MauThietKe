USE vd_ses4_designpatterns;
CREATE TABLE SinhVien(
	MaSinhVien VARCHAR(50) CHARSET utf8mb4 NOT NULL,
	HoTen VARCHAR(100) CHARSET utf8mb4 NULL,
	GioiTinhNam BIT NULL,
	MaNganhDaoTao INT NULL,
    NgaySinh DATE NULL,
	CONSTRAINT PK_SinhVien PRIMARY KEY (MaSinhVien)
);
INSERT INTO SinhVien
VALUES 	('22T1020340', 'Võ Minh Quân', 0, 102, '2004-10-17'),
		('22T1020749', 'Lê Phước Thiên', 1, 102, '2004-09-26'),
        ('22T1020606', 'Hoàng Trọng Hiếu', 1, 102, '2004-02-11'),
        ('22T1020362', 'Nguyễn Thế Quang', 1, 102, '2004-01-27'),
        ('22T1020333', 'Võ Minh Chiến', 1, 102, '2004-01-01')
;
-- SELECT * FROM vd_ses4_designpatterns.SinhVien WHERE HoTen LIKE '%Z%';