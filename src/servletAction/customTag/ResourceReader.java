package servletAction.customTag;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceReader {
//	static ResourceBundle rb;
//	static{
//		rb=ResourceBundle.getBundle("ApplicationResources",new Locale("vi","VN"));
//		
//	}
	ResourceBundle rb;
	public ResourceReader(Locale local) {
		rb=ResourceBundle.getBundle("ApplicationResources",local);
	}
	public void changeLocal(Locale lc) {
		rb=ResourceBundle.getBundle("ApplicationResources",lc);
	}
	public String getTitle(String key) {
		return rb.getString(key);
	}
//	public static void main(String[] args) {
//		ResourceReader rr=new ResourceReader();
//		System.out.println(rr.getTitle("Home.Menu.Danhsach"));
//		Locale lc=new Locale("en","US");
//		rr.changeLocal(lc);
//		System.out.println(rr.getTitle("Home.Menu.Danhsach"));
//	}
}
