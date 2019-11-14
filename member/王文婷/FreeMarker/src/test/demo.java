//≤‚ ‘¿‡

package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.freemarker.FreeMarkerUtil;

import freemarker.template.TemplateException;

public class demo {
	FreeMarkerUtil fuFreeMarkerUtil;
	Map<String,Object>root=null;
	
	public void setUp(){
		fuFreeMarkerUtil=new FreeMarkerUtil();
		root=new HashMap<String,Object>();
	}
	private void sprint(String name)throws TemplateException, IOException{
		fuFreeMarkerUtil.outputToConsole(name,root);
	}
	private void fprint(String name,String filename){
		fuFreeMarkerUtil.outputToFile(name,root,filename);
	}
}
