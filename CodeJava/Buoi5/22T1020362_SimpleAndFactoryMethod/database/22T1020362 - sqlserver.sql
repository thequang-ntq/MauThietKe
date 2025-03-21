USE [22T1020362_SimpleAndMethodFactory]
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name LIKE 'SinhVien')
BEGIN
	CREATE TABLE SinhVien(
		MaSinhVien NVARCHAR(10) NOT NULL,
		HoTen NVARCHAR(50) NOT NULL,
		GioiTinhNam BIT NOT NULL,
		NgaySinh DATE NOT NULL,
		CONSTRAINT PK_SinhVien PRIMARY KEY (MaSinhVien)
	)
END
GO
IF NOT EXISTS (SELECT * FROM SinhVien)
BEGIN
	INSERT INTO SinhVien
	VALUES 	('22T1020340', N'Võ Minh Quân', 0, '2004-10-17'),
			('22T1020749', N'Lê Phước Thiên', 1,  '2004-09-26'),
			('22T1020606', N'Hoàng Trọng Hiếu', 1, '2004-02-11'),
			('22T1020362', N'Nguyễn Thế Quang', 1, '2004-01-27'),
			('22T1020333', N'Võ Minh Chiến', 1, '2004-01-01')
END
GO
--SELECT * FROM SinhVien WHERE MaSinhVien LIKE '22T1020362'
-- SELECT * FROM SinhVien
-- INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)
-- DELETE FROM SinhVien WHERE MaSinhVien LIKE ?