USE [ViDuDB]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 2/21/2025 10:03:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[MaSinhVien] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinhNam] [bit] NULL,
	[MaNganhDaoTao] [int] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Student] ([MaSinhVien], [HoTen], [GioiTinhNam], [MaNganhDaoTao]) VALUES (N'sv003', N'Lê Thị Hồng Hoa', 0, 104)
GO
INSERT [dbo].[Student] ([MaSinhVien], [HoTen], [GioiTinhNam], [MaNganhDaoTao]) VALUES (N'sv008', N'Trần Văn', 1, 102)
GO
INSERT [dbo].[Student] ([MaSinhVien], [HoTen], [GioiTinhNam], [MaNganhDaoTao]) VALUES (N'sv048', N'Nguyễn Văn', 1, 102)
GO
