package dinhdang;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Dinhdangtien {
	public String Format(int tien) {
		Locale locale = new Locale("vi", "VN");
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatSym = new DecimalFormatSymbols(locale);
		formatSym.setGroupingSeparator(',');
		formatSym.setCurrencySymbol("ð");
		format.setDecimalFormatSymbols(formatSym);
		if (tien == 0) {
			return "0";
		} else {
			return format.format(tien);
		}
	}

	public static void main(String[] args) {
		Dinhdangtien d = new Dinhdangtien();
		System.out.println(d.Format(10000000));
	}
}
