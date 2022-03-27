create table admins
(
	adminid varchar(100) not null,
	hoten text not null,
	gioitinh bit not null,
	diachi text null,
	primary key(adminid)
);
create table staffs
(
	nhanvienid varchar(50) not null,
	hoten text not null,
	gioitinh bit not null,
	diachi text null,
	namsinh date not null,
	email varchar(255) null,
	sdt varchar(15) null,
	trangthai int not null,
	adminid varchar(100) not null,
	ngaytao date not null,
	primary key(nhanvienid)
);
create table customers
(
	khachhangid varchar(50)not null,
	hoten text not null,
	gioitinh bit not null,
	diachi text null,
	email varchar(255)not null,
	sdt varchar(15)null,
	nhanvienid varchar(50)not null,
	trangthai int not null,
	ngaytao date not null,
	primary key (khachhangid)
);
create table products
(
	sanphamid varchar(50)not null,
	tenloaihang text not null,
	soluong bigint not null,
	trangthai int not null,
	nhanvienid varchar(50)not null,
	primary key(sanphamid)	
);
create table products_detail
(
	ctspid varchar(50)not null,
	sanphamid varchar(50) not null,
	tensp  text not null,
	dongia real not null,
	ngaytao date not null,
	thongtinsp text null,
	soluong bigint not null,
	tragthai int not null,
	primary key(ctspid)
);
create table changed_passwords
(
	id bigserial not null,
	khachhangid varchar(50) not null,
	ngaydoi date not null,
	primary key(id)
);
create table bills
(
	id varchar(50)not null,
	ctspid varchar(50)not null,
	khachhangid varchar(50)not null,
	soluong bigint not null,
	dongia real not null,
	trangthai int not null,
	primary key(id)
);
alter table staffs 
add foreign key (adminid) references admins(adminid);
alter table products
add foreign key (nhanvienid) references staffs(nhanvienid);
alter table customers
add foreign key (nhanvienid) references staffs(nhanvienid);
alter table changed_passwords
add foreign key(khachhangid) references customers(khachhangid);
alter table products_detail
add foreign key(sanphamid) references products(sanphamid);
alter table customers
add foreign key (nhanvienid) references staffs(nhanvienid);
alter table changed_passwords
add foreign key(khachhangid) references customers(khachhangid);
alter table products_detail
add foreign key(sanphamid) references products(sanphamid);
alter table bills
add foreign key(ctspid) references products_detail(ctspid);
alter table bills
add foreign key(khachhangid) references customers(khachhangid);
alter table admins 
add column password varchar(65)not null;
alter table staffs 
add column password varchar(65)not null;
alter table customers
add column password varchar(65)not null;
