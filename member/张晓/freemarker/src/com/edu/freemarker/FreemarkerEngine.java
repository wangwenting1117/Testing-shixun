package com.edu.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.edu.test.TestsListener;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerEngine {
	private static final String DEFAULT_TEMPLATE = "conf/TestReport.html";   
    public String getTemplatePath() {   
        return "";   
    }   
       
    public String run(Map context) throws Exception{   
    	return executeFreemarker(context); 
    }   
    
    private String executeFreemarker(Map context)throws Exception{   
    	String content="";
        Configuration cfg = new Configuration(Configuration.getVersion());   
        cfg.setDirectoryForTemplateLoading(   
                new File(getTemplatePath()));   
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        cfg.setObjectWrapper(new DefaultObjectWrapper());              
        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));                      
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
}