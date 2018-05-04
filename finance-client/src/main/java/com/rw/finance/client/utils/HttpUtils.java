package com.rw.finance.client.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 16:06 2018/4/27
 */
public class HttpUtils {
    /**
     * post重定向
     * @param url
     * @param params
     * @param response
     * @throws IOException
     */
    public static void redirect(String url, Map<String,String> params, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD></HEAD>");
        out.println(" <BODY>");
        out.println("<form name=\"form\" action=\""+url+"\" method=\"post\">");
        for(Map.Entry<String, String> map:params.entrySet()){
            out.println("<input type=\"hidden\" name=\""+map.getKey().trim()+"\" value=\""+map.getValue().trim()+"\"/>");
        }
        out.println("</form>");
        out.println("<script>window.document.form.submit();</script>");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
