USE vd_ses3_designpatterns;

CREATE TABLE NganhDaoTao(
	MaNganhDaoTao INT NOT NULL,
	TenNganhDaoTao VARCHAR(100) CHARSET utf8mb4 NULL,
	CONSTRAINT PK_NganhDaoTao PRIMARY KEY (MaNganhDaoTao)
);

CREATE TABLE Student(
	MaSinhVien VARCHAR(50) CHARSET utf8mb4 NOT NULL,
	HoTen VARCHAR(100) CHARSET utf8mb4 NULL,
	GioiTinhNam BIT NULL,
	MaNganhDaoTao INT NULL,
 CONSTRAINT PK_Student PRIMARY KEY (MaSinhVien)
);

INSERT INTO NganhDaoTao
VALUES	(101, "Điện tử viễn thông"),
		(102, "Công nghệ thông tin"),
        (103, "Toán ứng dụng"),
		(104, "Văn học"),
        (105, "Báo chí & Truyền thông"),
        (109, "xxxxxxxxxxxxx"),
        (836, "Quản lý nhà nước")
;

INSERT INTO Student
VALUES 	('sv003', 'Lê Thị Hồng Hoa', 0, 104),
		('sv008', 'Trần Văn', 1, 102),
        ('sv048', 'Nguyễn Văn', 1, 102),
        ('sv872', 'Trần Nguyên Phong', 1, 103),
        ('T102972', 'John Smith', 1, 102)
;
-- SELECT MaNganhDaoTao, TenNganhDaoTao FROM vd_ses3_designpatterns.NganhDaoTao;
-- INSERT INTO vd_ses3_designpatterns.NganhDaoTao (MaNganhDaoTao, TenNganhDaoTao) VALUES (?, ?);
