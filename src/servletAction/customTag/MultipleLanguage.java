package servletAction.customTag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MultipleLanguage extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		//lay gia tri local tu session
		PageContext pc=(PageContext)getJspContext();
		HttpServletRequest request=(HttpServletRequest)pc.getRequest();
		HttpSession session=request.getSession();
		Locale local=(session.getAttribute("local")!=null)?
		(Locale)session.getAttribute("local"):new Locale("en","US");
		//Ä‘á»�c giĂ¡ trá»‹ ngÆ°á»�i dĂ¹ng Ä‘iá»�n vĂ o customTab
				//Locale local=(Locale)session.getAttribute("local");
				//sáº½ bá»‹ nullpointException do chÆ°a cĂ³ locale cho Dangnhap.jsp.
		StringWriter sw=new StringWriter();
		getJspBody().invoke(sw);
		String value=null;
		String rbKey=sw.toString();
		//láº¥y giĂ¡ trá»‹ ngÆ°á»�i dĂ¹ng Ä‘Ă£ Ä‘iá»�n Ä‘á»ƒ Ä‘á»‘i chiáº¿u trong
		//file properties, láº¥y ra value cá»§a key Ä‘Ă³
		ResourceReader rr=new ResourceReader(local);
		value=rr.getTitle(rbKey);
		//in giĂ¡ trá»‹ cá»§a value len giao diá»‡n Ä‘á»ƒ 
		//thay cho key ngÆ°á»�i dĂ¹ng Ä‘Ă£ Ä‘iá»�n
		JspWriter jw=getJspContext().getOut();
		jw.print(value);
		
	}
}
