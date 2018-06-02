package com.hxdq.xedsms.db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.InputStream;

import org.apache.ibatis.exceptions.IbatisException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class SSFactory {

	// It can be set through setConfigFile(String) method.
	private static String CONFIG_FILE_LOCATION = "etc/ibatis_config.xml";
	private static InputStream configInputStream = null;

	/** Holds a single instance of Session */
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

	/** The single instance of SessionFactory */
	private static SqlSessionFactory sessionFactory;

	public synchronized static SqlSession currentSession() {

		SqlSession session = (SqlSession) threadLocal.get();

		if (session == null) {
			try {
				if (sessionFactory == null) {
					Reader reader;
					if(configInputStream != null){
						reader = new InputStreamReader(configInputStream);
					}else{
						reader = Resources
							.getResourceAsReader(CONFIG_FILE_LOCATION);
					}
					sessionFactory = new SqlSessionFactoryBuilder()
							.build(reader);
				}
				session = (sessionFactory != null) ? sessionFactory
						.openSession() : null;
				threadLocal.set(session);
			} catch (IOException e) {
				System.err
						.println("failed to create SessionFactory: config file("
								+ CONFIG_FILE_LOCATION + ") not found");
			} catch (IbatisException e) {
				System.err.println("failed to openSession");
				e.printStackTrace();
			}
		}

		return session;
	}

	/**
	 * Close the single session instance.
	 * 
	 * @throws Exception
	 */
	public synchronized static void closeSession() {
		SqlSession session = (SqlSession) threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
			session = null;
		}
	}

	/**
	 * Default constructor.
	 */
	private SSFactory() {
	}

	public static void setConfigFile(String configFile) {
		if (configFile != null && !configFile.equals("")) {
			CONFIG_FILE_LOCATION = configFile;
		}
	}

	public static void setConfigFile(InputStream is) {
		if (configInputStream == null) {
			configInputStream = is;
		}
	}
}
