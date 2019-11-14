//生成html的工具类

package com.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
//import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
	private static final String DEFAULT_TEMPLATE = "conf/reportTemplate.html";   
    public String getTemplatePath() {   
        return "";   
    }   
       
    public String run(Map context) throws Exception{   
    	return executeFreemarker(context); 
    }   
    
    private String executeFreemarker(Map context)throws Exception{   
    	String content="";
        Configuration cfg = new Configuration();   
        cfg.setDirectoryForTemplateLoading(   
                new File(getTemplatePath()));   
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        cfg.setObjectWrapper(new DefaultObjectWrapper());              
        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage());                      
        Template temp = cfg.getTemplate(getTemplate());    
        StringWriter out = new StringWriter();   
        temp.process(context, out);   
        //System.out.print(out.toString());
        return out.toString();
    }   
  
    public String getTemplate() {   
        // TODO Auto-generated method stub   
        return DEFAULT_TEMPLATE;   
    }    
//	private static final String DEFAULT_TEMPLATE = "conf/reportTemplate.html";//模板文件路径
//	private static final String ENCODING="utf-8";//模板文件内容编码
//	private static Configuration conf=new Configuration();//模板生成配置
//	private static Map<String,Object> tempMap=new HashMap<String,Object>();//邮件模板缓冲池
//	static{
//		conf.setClassForTemplateLoading(FreeMarkerUtil.class, DEFAULT_TEMPLATE);//设置模板路径
//	}
//	//通过模板文件名称获取指定模板
//	private static Template getTemplateByName(String name) throws IOException{
//		Template template=conf.getTemplate(name);
//		
//		return null;
//	}
//	//根据指定模板将内容输出到控制台
//	public static void outputToConsole(String name,Map<String,Object >map){
//		//通过template可以将文件输出到相应的流
//		try {
//			Template temp=getTemplateByName(name);
//			temp.setEncoding(ENCODING);
//			temp.process(map,new PrintWriter(System.out));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TemplateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	//根据指定模板将内容直接输出到文件
////	@param name
////
////    *            模板文件名称
////
////    * @param map
////
////    *            与模板内容转换对象
////
////    * @param outFile
////
////    *            输出的文件绝对路径
//	public static void outputToFile(String name,Map<String,Object>map,String outFile){
//		FileWriter out=null;
//		try {
//			out=new FileWriter(new File(outFile));
//			Template temp=getTemplateByName(name);
//			temp.setEncoding(ENCODING);
//			temp.process(map, out);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TemplateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally{
//			if(out!=null)
//				try {
//					out.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
//	}
//	public static String generateHtmlFromFtl(String name,Map<String,Object>map) throws IOException, TemplateException{
//		Writer out=new StringWriter(2048);
//		Template temp=getTemplateByName(name);
//		temp.setEncoding(ENCODING);
//		temp.process(map, out);
//		return out.toString();		
//	}
}
