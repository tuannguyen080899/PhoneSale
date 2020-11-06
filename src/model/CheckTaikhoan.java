package model;

import java.util.ArrayList;
import java.util.List;

import dao.DaoTaikhoan;

public class CheckTaikhoan {
	public boolean checkAdmin(String username,String password) {
		List<Taikhoan> adlist=new ArrayList<>();
		DaoTaikhoan dao=new DaoTaikhoan();
		adlist=dao.getAllTaikhoanPhanquyenAdmin();
		for(Taikhoan tk:adlist) {
			if(username.equals(tk.getUsername())&&password.equals(tk.getPassword())) {
				return true;
			}
		}
	return false;
	}
	public boolean checkCustomer(String username,String password) {
		List<Taikhoan> adlist=new ArrayList<>();
		DaoTaikhoan dao=new DaoTaikhoan();
		adlist=dao.getAllTaikhoanPhanquyenKhachhang();
		for(Taikhoan tk:adlist) {
			if(username.equals(tk.getUsername())&&password.equals(tk.getPassword())) {
				return true;
			}
		}
	return false;
	}
}
