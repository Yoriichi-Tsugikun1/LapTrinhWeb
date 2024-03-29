﻿create database baitaplon
go

use baitaplon
go

create table [user](
	[account] [varchar](255),
	[password] [varchar](255),
	role int
)
select * from [user];
insert into [user] values('Admin','admin','2');
--tên, hãng, màn hình, cpu, ram, ổ cứng, đồ họa, 
-- hệ điều hành, trọng lượng, kích thước , xuất xứ, năm ra mắt, giá bán, loại, ảnh
create table sanpham(
	[id] [varchar](5) primary key,
	[tensp] [nvarchar](255),
	[manhinh] [nvarchar](255),
	[cpu] [nvarchar](255),
	[ram] [nvarchar](100),
	[ocung] [nvarchar](100),
	[dohoa] [nvarchar](255),
	[hdh] [nvarchar](255),
	[trongluong] [varchar](50),
	[kichthuoc] [varchar] (50),
	[xuatxu] [nvarchar](255),
	[nam] [int],
	[giaban] [float],
	[soluong] [int],
	[loai] [nvarchar] (100),
	[hang] [varchar](10),
	[img1] [varchar](255),
	[img2] [varchar](255),
	[img3] [varchar](255),
);
SELECT password
FROM [user]
WHERE BINARY_CHECKSUM(password) = BINARY_CHECKSUM('Huy@050402');
SELECT [password]
FROM [user] where BINARY_CHECKSUM(account) = BINARY_CHECKSUM('nguyentronghuy06@gmail.com');
alter table sanpham alter column [trongluong] [varchar](20)
go
INSERT INTO sanpham VALUES
('SP001', N'Laptop Asus TUF GAMING F15 FX506HF-HN014W', N'15.6 inches IPS Panel, 144Hz', 'Intel Core i5-11400H (12MB Cache, up to 4.6GHz, 6 lõi / 12 luồng)', '8GB RAM', '512GB M.2 PCIE G3X2 1x khe M.2 SSD trống', N'NVIDIA GeForce RTX 2050 4GB', 'Windows 11 Home', '2.3 kg', '35.9 x 25.6 x 2.28 ~ 2.45 cm', N'Mỹ', 2021, 16890000.00,50, N'Gaming', 'ASUS ', '1.jpg', '1n.jpg', '1d.jpg'),
('SP002', N'Laptop ASUS ROG Flow X13 GV301RC-LJ050W', N'13.4 inches IPS Panel, 144Hz', 'AMD Ryzen 7 6800HS', '8GB RAM', '512GB M.2 2230 NVMe™ PCIe® 4.0 SSD', N'AMD Ryzen 7 6800HS', 'Windows 11 Home SL', '1.30 Kg', '29.9 x 22.2 x 1.58 ~ 1.58 cm', N'Mỹ', 2023, 29990000.00,50, N'Gaming', 'ASUS', '2.jpg', '2n.jpg', '2d.jpg'),
('SP003', N'Laptop Asus Gaming Rog Strix G15 G513IH HN015W', N'15.6 inches IPS Panel, 144Hz', 'AMD Ryzen 7 4800H', '8GB RAM', '512GB SSD NVMe M.2 PCIe Gen 3 x 4', N'Geforce GTX 1650 4GB', 'Windows 11 SL 64 Bit', '2.1 kg', '35.4 x 25.9 x 2.26 ~ 2.72 cm', N'Mỹ', 2021, 17890000.00,50, N'Gaming', 'ASUS', '3.jpg', '3n.jpg', '3d.jpg'),
('SP004', N'Laptop Asus ROG Strix G16 G614JU-N3135W', N'16 inches Full HD', 'Intel Core i5-13450HX Gen 13', '8GB RAM', '512GB PCIe 4.0 NVMe M.2 SSD', N'NVIDIA GeForce RTX 4050 6GB GDDR6', 'Windows 11 Home', '2.50 kg', '35.4 x 26.4 x 2.26 ~ 3.04 cm', N'Mỹ', 2022, 33890000.00,50, N'Gaming', 'ASUS', '4.jpg', '4n.jpg', '4d.jpg'),
('SP005', N'Laptop Asus TUF Gaming A16 Advantage Edition FA617NS-N3486W', N'16 inches Full HD', 'AMD Ryzen 7-7735HS (8 lõi/16 luồng, 16MB L3 cache, up to 4.7 GHz max boost)', '8GB RAM', '512GB PCIe 4.0 NVMe M.2 SSD (2 khe cắm M.2 hỗ trợ SATA hoặc NVMe)', N'AMD Radeon RX 7600S 8GB GDDR6', 'Windows 11 Home', '2.20 Kg', '35.5 x 25.2 x 2.21 ~ 2.68 cm', N'Mỹ', 2021, 26490000.00,50, N'Gaming', 'ASUS', '5.jpg', '5n.jpg', '5d.jpg'),
('SP006', N'Laptop Asus TUF Gaming A15 FA507NU-LP034W', N'15.6 inches Full HD', 'AMD Ryzen 7 7735HS (8 lõi / 16 luồng, 16MB L3 cache, up to 4.7 GHz max boost)', '8GB RAM', '512GB PCIe 4.0 NVMe M.2 SSD (2230)', N'NVIDIA GeForce RTX 4050 6GB GDDR6 AMD Radeon Navi2 Graphics', 'Windows 11 Home', '2.20 kg', '35.4 x 25.1 x 2.24 ~ 2.49 cm', N'Mỹ', 2022, 24890000.00,50, N'Gaming', 'ASUS', '6.jpg', '6n.jpg', '6d.jpg'),
('SP007', N'Laptop Gaming Acer Nitro 5 Eagle AN515-57-5669 NH.QEHSV.001', N'15.6 inches Full HD', 'Intel Core i5-11400H', '8GB RAM', '512GB PCIe NVMe SSD cắm sẵn', N'NVIDIA GeForce GTX 1650 4 GB GDDR6', 'Windows 10', '2.2 kg', '363.4 (W) x 255 (D) x 23.9 (H) mm', N'Mỹ', 2023, 16190000.00,50, N'Laptop', 'Dell', '7.jpg', '7n.jpg', '7d.jpg'),
('SP008', N'Laptop MSI Gaming Bravo 15 B7ED-010VN', N'15.6 inches Full HD', 'Intel Core i3-1115G4', '16GB RAM', '512 GB SSD NVMe PCIe Gen 4.0', N'AMD Radeon RX 6550M, 4 GB', 'Windows 10', '2.25 kg', '359 x 259 x 24.95 mm', N'Mỹ', 2021, 15000000.00,50, N'Gaming', 'MSI', '8.jpg', '8n.jpg', '8d.jpg'),
('SP009', N'Laptop Lenovo IdeaPad Gaming 3 15ACH6 82K2027QVN', N'15.6 inches Full HD', 'AMD Ryzen 5 5500H', '8GB RAM', '256GB SSD', N'512GB SSD M.2 2242 PCIe 4.0x4 NVMe', 'Windows 11 Home', '2.25 kg', '359.6 x 251.9 x 24.2 mm', N'Mỹ', 2023, 15990000.00,50, N'Gaming', 'Lenovo', '9.jpg', '9n.jpg', '9d.jpg'),
('SP010', N'Laptop MSI Gaming GF63 12UCX-841VN', N'15.6 inches Full HD', 'Intel Core i5-12450H', '8GB RAM', '512GB SSD M.2 NVMe', N'NVIDIA GeForce RTX 2050 4GB GDDR6', 'Windows 11 Home', '1.8kg', '359 x 254 x 21.7 mm', N'Mỹ', 2022, 16490000.00,50, N'Gaming', 'MSI', '10.jpg', '10n.jpg', '10d.jpg'),
('SP011', N'Laptop Acer Gaming Aspire 7 A715-76-57CY NH.QGESV.004', N'15.6 inches Full HD', 'Intel Core i5 - 12450H', '8GB RAM', '512 GB SSD M.2 NVMe', N'Intel UHD ', 'Windows 10', '2.1 kg', '362.3 x 237.4 x 19.9 mm', N'Mỹ', 2022, 13990000.00,50, N'Gaming', 'Acer', '11.jpg', '11n.jpg', '11d.jpg'),
('SP012', N'Laptop HP Gaming Victus 15-FA0115TX 7C0X1PA', N'15.6 inches Full HD', 'Intel Core i5-12500H', '8GB RAM', '512GB SSD M.2 PCIe', N'NVIDIA GeForce RTX 3050 4GB GDDR6', 'Windows 11 Home', '2.29 kg', '357.9 x 255 x 23.5 mm', N'Mỹ', 2021, 19990000.00,50, N'Gaming', 'HP', '12.jpg', '12n.jpg', '12d.jpg'),
('SP013', N'Laptop gaming MSI GF63 Thin 11SC 664VN', N'15.6 inches Full HD', 'Intel Core i5-11400H 2.2GHz up to 4.5GHz 12MB', '8GB RAM', '512 GB SSD NVMe PCIe', N'NVIDIA GeForce GTX1650 4GB GDDR6', 'Windows 10', '1.86 kg', '359 x 254 x 21.7 mm', N'Mỹ', 2022, 14990000.00,50, N'Laptop', 'Dell', '13.jpg', '13n.jpg', '13d.jpg'),
('SP014', N'Laptop Acer Aspire 7 A715-76G-5806', N'15.6 inches Full HD', 'Intel Core i5 - 12450H', '16GB RAM', '512 GB SSD NVMe PCIe', N'NVIDIA GeForce RTX 3050, 4 GB', 'Windows 11 Home SL', '2.1 kg', '362.3 x 237.4 x 19.9 mm', N'Mỹ', 2023, 19990000,50, N'Gaming', 'Acer', '14.jpg', '14n.jpg', '14d.jpg'),
('SP015', N'Laptop Gigabyte MF F2VN333SH', N'15.6 inches Full HD', 'Intel Core i5-12450H 3.3GHz up to 4.4GHz, 8 nhân 12 luồng, 12MB Cache', '8GB RAM', '512GB SSD M.2 PCIE G4X4', N'Nvidia Geforce RTX 4050 4GB GDDR6', 'Windows 11', '1,9 kg', '360 x 238 x 22.7 (mm)', N'Mỹ', 2021, 20990000,50, N'Gaming', 'Gigabyte', '15.jpg', '15n.jpg', '15d.jpg'),
('SP016', N'Laptop Gigabyte G5 GD-51VN123SO', N'15.6 inches Full HD', 'Intel Core i5-11400H', '16GB RAM', '512GB M.2 NVMe PCIe', N'NVidia Geforce RTX 3050 4GB GDDR6', 'Windows 11 Home', '2.03 kg', '36.1 x 25.8 x 2.49 ~ 3.16 cm', N'Mỹ', 2022, 17990000,50, N'Gaming', 'Gigabyte', '16.jpg', '16n.jpg', '16d.jpg'),
('SP017', N'Laptop Lenovo Gaming Legion 5 Pro 16ACH6H', N'16 inches Full HD', 'AMD Ryze 7-5800H', '16GB RAM', '512GB SSD M.2 2280 PCIe 3.0x4 NVMe', N'NVIDIA GeForce RTX 3060 6GB GDDR6', 'Windows 10', '2.45 kg', '356 x 260.4-264.4 x 21.7-26.85 mm', N'Mỹ', 2023, 32990000,50, N'Gaming', 'Lenovo', '17.jpg', '17n.jpg', '17d.jpg'),
('SP018', N'Laptop LG Gram 2023 16Z90R-E.AH75A5', N'16 inches Full HD', 'Intel Core i7-1360P 2.2 GHz', '16GB RAM', '512GB SSD NVMe Gen 4', N'Nvidia RTX3050 4GB', 'Windows 11', '1.3 kg', '31.2 x 21.39 x 1.68 cm', N'Mỹ', 2023, 42990000,50, N'Gaming', 'LG', '18.jpg', '18n.jpg', '18d.jpg'),
('SP019', N'Laptop Dell Alienware X15 R2', N'15.6 inches Full HD', 'Intel Core i9-12900H (up to 5.0 GHz, 14 lõi / 20 luồng, 24MB Cache)', '16GB RAM', 'SSD 1TB M.2 PCIe NVMe', N'NVIDIA GeForce RTX 3070 Ti, 8 GB GDDR6', 'Windows 11 Pro', '2.27 kg', '359.7 x 277.33 x 15.9 mm', N'Mỹ', 2021, 49990000,50, N'Gaming', 'Dell', '19.jpg', '19n.jpg', '19d.jpg'),
('SP020', N'Laptop Dell Alienware X17', N'17.3 inches Full HD', 'Intel® Core™ i9-12900HK thế hệ thứ 12', '32GB RAM', '1 TB, M.2, PCIe NVMe, SSD', N'NVIDIA® GeForce RTX™ 3080 Ti, 16 GB GDDR6', 'Windows 11 Home, Tiếng Anh', '3.2 kg', '20.9 x 39.9 x 30 cm', N'Mỹ', 2023, 78990000,50, N'Gaming', 'Dell', '20.jpg', '20n.jpg', '20d.jpg')
insert INTO sanpham VALUES ('SP021', N'', N'', '', '3', '', N'', '', '', '', N'', , ,, N'', '', '', '');
select * from sanpham;
select top 1 id from sanpham ORDER BY id DESC;
delete sanpham where id='sp001';
select * from sanpham where hang = 'dell';
select TOP 3 id,tensp,giaban,soluong,img1 from sanpham ;
ALTER TABLE [dbo].[user]
ALTER COLUMN [account] VARCHAR(255) NOT NULL;

ALTER TABLE [dbo].[user]
ADD CONSTRAINT PK_user_account PRIMARY KEY CLUSTERED ([account] ASC);
create table [Order](
	[id] [int] IDENTITY(1,1) not null,
	[uid] [varchar](255) references [user]([account]) not null,
	[date] [date] not null,
	[totalmoney] [money]
)
ALTER TABLE [dbo].[Order]
ADD CONSTRAINT PK_Order_id PRIMARY KEY CLUSTERED ([id] ASC);

ALTER TABLE [dbo].[Order]
ADD [hoten] [nvarchar](255),
    [dienthoai] [varchar](20),
    [diachi] [nvarchar](255);

ALTER TABLE [dbo].[Order]
ADD [trangthai] [nvarchar](100);
select * from [Order];
create table [OrderLine](
	[oid] [int] not null,
	[sid] [varchar](5) not null,
	[soluong] [int] not null,
	[gia] [float] not null,
	CONSTRAINT [PK_OrderLine] PRIMARY KEY CLUSTERED
(
[oid] ASC,
[sid] 
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF,
ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[OrderLine] WITH CHECK ADD CONSTRAINT [FK_OrderLine_Order] FOREIGN
KEY([oid])
REFERENCES [dbo].[Order] ([id])
GO
select top 1 id from sanpham ORDER BY id DESC;
ALTER TABLE [dbo].[OrderLine] WITH CHECK ADD CONSTRAINT [FK_OrderLine_sanpham] FOREIGN
KEY([sid])
REFERENCES [dbo].[sanpham] ([id])
GO
select * from [OrderLine] where oid = 5 order by oid DESC;
select * from [Order] o inner join [OrderLine] ol on o.id = ol.oid
where uid ='nguyentronghuy06@gmail.com' order by id DESC ;
delete from [OrderLine] where oid = 3;
delete from [Order] where id = 4;
delete  from [Order] where id=1;
select * from [user];
select * from [OrderLine];
select * from [sanpham];
select * from [Order] where trangthai = N'Đơn Hàng Thành Công';
select * from [Order] where trangthai = N'Đã bị Hủy';
select * from [Order];
delete from [OrderLine] where oid = 4;
UPDATE [dbo].[OrderLine]
SET sid = 'H0001'
WHERE sid = 'SP001';
SELECT * FROM [dbo].[OrderLine] WHERE sid = 'SP001';
SELECT * FROM [user]
WHERE account <> 'admin';
select top 4 id,tensp,giaban,soluong,img1 from sanpham where loai = N'Văn phòng';