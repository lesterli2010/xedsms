package com.hxdq.xedsms.db;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hxdq.xedsms.Utility;

public class DBUtility {

	public static int update(Object data, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			session.update(iqlPath, data);
			session.commit();
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
		return Utility.DB_SUCCESS;
	}

	public static int delete(String userid, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			session.delete(iqlPath, userid);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
		return Utility.DB_SUCCESS;
	}

	public static int delete(HashMap map, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			session.delete(iqlPath, map);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
		return Utility.DB_SUCCESS;
	}

	public static Object selectOne(String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectOne(iqlPath);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static Object selectOne(int id, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectOne(iqlPath, id);
		} catch (Exception e) {
			throw e;
		}
	}

	public static Object selectOne(String userid, String iqlPath)
			throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectOne(iqlPath, userid);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static List selectList(HashMap map, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectList(iqlPath, map);
		} catch (Exception e) {
			// FIXME: do log
			Utility.logger.error(e);
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static List selectList(int id, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectList(iqlPath, id);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static List selectList(String id, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectList(iqlPath, id);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static int getTotalCount(String iqlPath) {
		try {
			SqlSession session = SSFactory.currentSession();
			return (Integer) session.selectOne(iqlPath);
		} catch (Exception e) {
			// FIXME: do log
			return 0;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static int getCount(int chid, String iqlPath) {
		int count;
		try {
			count = (Integer) selectOne(chid, iqlPath);
		} catch (Exception e) {
			count = 0;
		}
		return count;
	}

	public static int getCount(String restName, String iqlPath) {
		int count;
		try {
			count = (Integer) DBUtility.selectOne(restName, iqlPath);
		} catch (Exception e) {
			count = 0;
		}
		return count;
	}

	public static int getCount(String iqlPath) {
		int count;
		try {
			count = (Integer) selectOne(iqlPath);
		} catch (Exception e) {
			count = 0;
		}
		return count;
	}

	public static Object selectOne(HashMap map, String iqlPath)
			throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectOne(iqlPath, map);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
	}

	public static int getCount(HashMap map, String iqlPath) {
		int count;
		try {
			count = (Integer) selectOne(map, iqlPath);
		} catch (Exception e) {
			count = 0;
		}
		return count;
	}

	public static int delete(int id, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			session.delete(iqlPath, id);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
		return Utility.DB_SUCCESS;
	}

	public static int insert(Object data, String iqlPath) throws Exception {
		try {
			SqlSession session = SSFactory.currentSession();
			session.insert(iqlPath, data);
		} catch (Exception e) {
			// FIXME: do log
			throw e;
		} finally {
			SSFactory.closeSession();
		}
		return Utility.DB_SUCCESS;
	}

	public static List selectList(String iqlPath) {
		try {
			SqlSession session = SSFactory.currentSession();
			return session.selectList(iqlPath);
		} catch (Exception e) {
			// FIXME: do log
			return null;
		} finally {
			SSFactory.closeSession();
		}
	}

}

