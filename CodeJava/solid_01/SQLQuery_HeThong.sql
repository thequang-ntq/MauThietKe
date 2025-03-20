USE quanlysv;

CREATE TABLE NganhDaoTao
(
	MaNganhDaoTao INT NOT NULL,
    TenNganhDaoTao VARCHAR(255) CHARSET utf8mb4 NOT NULL,
	CONSTRAINT pk_NganhDaoTao PRIMARY KEY (MaNganhDaoTao) 
);

CREATE TABLE SinhVien
(
	MaSinhVien VARCHAR(50) CHARSET utf8mb4 NOT NULL,
    HoTen VARCHAR(255) CHARSET utf8mb4 NOT NULL,
    GioiTinhNam BOOL NOT NULL,
    MaNganhDaoTao INT NOT NULL,
    CONSTRAINT pk_SinhVien PRIMARY KEY (MaSinhVien),
    CONSTRAINT fk_SinhVien_NganhDaoTao FOREIGN KEY (MaNganhDaoTao) REFERENCES NganhDaoTao (MaNganhDaoTao)
);

INSERT INTO NganhDaoTao
VALUES 	(102, "Công nghệ thông tin"),
		(104, "Toán cao cấp"),
		(38, "Báo chí");

INSERT INTO SinhVien
VALUES 	('22T1020362', 'Nguyễn Thế Quang', True, 102),
		('22T1020749', 'Lê Phước Thiên', True, 102);