package com.hxdq.xedsms;

import javax.servlet.ServletContext;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;

import com.hxdq.xedsms.db.*;

public class WebPortalAppInit implements WebAppInit {

	@Override
	public void init(WebApp wapp) throws Exception {
		// TODO Auto-generated method stub
		try {
			ServletContext context = (ServletContext) wapp.getNativeContext();

			String logConfigFile = context
					.getInitParameter("webAppLogLocation");
			String webAppName = context.getInitParameter("webAppName");
			Utility.initLog(context.getResource(logConfigFile), webAppName);
			
			SSFactory.setConfigFile("");

			// Init Web Language
			String menuFile = context.getInitParameter("webAppMenu");
			
			if (menuFile != null) {
				Utility.loadMenuConfig(context.getResourceAsStream(menuFile));
				Utility.menuFileRealPath = context.getRealPath(menuFile);
				Utility.logger.info("load menuFile:" + menuFile + ", menuFileRealPath" + Utility.menuFileRealPath);
			}
			
			String dbConfig = context.getInitParameter("dbConfigLocation");
			Utility.initDB(context.getResourceAsStream(dbConfig));

			Utility.initProductBatchMap();
			
			Utility.initAuthNameHashMap();
			
			Utility.logger.info(webAppName + " is initialized successfully! ");

		} catch (Exception e) {
			if (Utility.logger != null) {
				Utility.logger.error("Exception happened in web Init.", e);
			} else {
				System.out.println("Exception happened in Web Init!");
				e.printStackTrace();
			}
			throw e;
		}
	}

}
