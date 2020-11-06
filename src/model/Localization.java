package model;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Localization {
	public String dinhDangtien(int s) {
		Locale lo = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lo);
		return nf.format(s);
	}
}
