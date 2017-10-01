package com.ebook.common.dao;

import java.util.List;

public interface Dao {

	public static final int DEFAULT_FIRST_RESULT_INDEX = 0;

	public static final int DEFAULT_MAX_RESULTS = 200;

	public void setDefaultMaxResults(int defaultMaxResults);

	public int getDefaultMaxResults();

	public <T extends Object> T store(T obj);

	public boolean remove(Object obj);

	public boolean flush();

	public <T extends Object> T findByQueryName(String queryName);

	public <T extends Object> T findByQueryName(String queryName, Object... parameters);

	public <T extends Object> List<T> findListByQueryName(String queryName);

	public <T extends Object> List<T> findListByQueryName(String queryName, Integer firstResult, Integer maxResults);

	public <T extends Object> List<T> findListByQueryName(String queryName, Object... parameters);

	public <T extends Object> List<T> findListByQueryName(String queryName, Integer firstResult, Integer maxResults,
			Object... parameters);

}
