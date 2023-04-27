package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import Entity.NhanVien;

public class NhanVien_Dao {
	public NhanVien_Dao() {
		
	}
	public boolean updateNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		PreparedStatement st = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			st = con.prepareStatement("UPDATE NhanVien SET soDT=?, matKhau=?, tenNV=?, ngaySinh=?, gioiTinh=?, cccd=?, ngayVL=? where maNV=?");
			st.setString(1, nv.getSoDT());
			st.setString(2, nv.getMatKhau());
			st.setString(3, nv.getTenNV());
			st.setDate(4, nv.getNgaySinh());
			st.setBoolean(5, nv.getGioiTinh());
			st.setString(6, nv.getCccd());
			st.setDate(7, nv.getNgayVL());
			n = st.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public NhanVien getNhanVien(String sdt, String pass) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		PreparedStatement st = null;
		try {
			Connection con = ConnectDB.getConnection();
			st = con.prepareStatement("Select * from NhanVien where SDT=? and MatKhau=?");
			st.setString(1, sdt);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				String MaNV = rs.getString("MaNV");
				String SDT = rs.getString("SDT");
				String matKhau = rs.getString("MatKhau");
				String tenNV = rs.getString("TenNV");
				Date ngaySinh = rs.getDate("NgaySinh");
				boolean gt = rs.getBoolean("GioiTinh");
				String cccd = rs.getString("CCCD");
				Date ngayVL = rs.getDate("NgayVaoLam");
				nv =  new NhanVien(MaNV, SDT, matKhau, tenNV, ngaySinh, gt, cccd, ngayVL);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nv;
	}

}
