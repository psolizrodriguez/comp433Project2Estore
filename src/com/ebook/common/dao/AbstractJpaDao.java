package com.ebook.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.utility.AppBaseUtilsWeb;

public abstract class AbstractJpaDao implements Dao {

	private static Logger LOGGER = Logger.getLogger(AbstractJpaDao.class);

	private int defaultMaxResults = DEFAULT_MAX_RESULTS;

	public abstract EntityManager getEntityManager();

	@Transactional
	public <T extends Object> T store(T entity) {
		return getEntityManager().merge(entity);
	}

	@Transactional(readOnly = false)
	public boolean remove(Object entity) {
		try {
			getEntityManager().remove(getEntityManager().merge(entity));
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("JPA Exception when removing Object");
		}
		return false;
	}

	public boolean flush() {
		try {
			getEntityManager().flush();
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("JPA Exception when removing Object");
		}
		return false;
	}

	public void setDefaultMaxResults(int defaultMaxResults) {
		this.defaultMaxResults = defaultMaxResults;
	}

	public int getDefaultMaxResults() {
		return defaultMaxResults;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> T findByQueryName(String queryName) {
		return (T) findByQueryName(queryName, (Object[]) null);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> T findByQueryName(String queryName, Object... parameters) {
		Query query = createNamedQuery(queryName, DEFAULT_FIRST_RESULT_INDEX, 1, parameters);
		return (T) query.getSingleResult();
	}

	@Transactional
	public <T extends Object> List<T> findListByQueryName(String queryName) {
		return findListByQueryName(queryName, DEFAULT_FIRST_RESULT_INDEX, getDefaultMaxResults());
	}

	@Transactional
	public <T extends Object> List<T> findListByQueryName(String queryName, Integer firstResult, Integer maxResults) {
		return findListByQueryName(queryName, firstResult, maxResults, (Object[]) null);
	}

	@Transactional
	public <T extends Object> List<T> findListByQueryName(String queryName, Object... parameters) {
		return findListByQueryName(queryName, DEFAULT_FIRST_RESULT_INDEX, getDefaultMaxResults(), parameters);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public <T extends Object> List<T> findListByQueryName(String queryName, Integer firstResult, Integer maxResults,
			Object... parameters) {
		Query query = createNamedQuery(queryName, firstResult, maxResults, parameters);
		return query.getResultList();
	}

	@Transactional
	public int executeByQueryName(String queryName, Object... parameters) {
		Query query = getEntityManager().createNamedQuery(queryName);
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
			}
		}
		return query.executeUpdate();
	}

	@Transactional
	public Query createNamedQuery(String queryName, Integer firstResult, Integer maxResults) {
		return createNamedQuery(queryName, firstResult, maxResults, (Object[]) null);
	}

	@Transactional
	public Query createNamedQuery(String queryName, Integer firstResult, Integer maxResults, Object... parameters) {
		Query query = getEntityManager().createNamedQuery(queryName);
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
			}
		}

		query.setFirstResult(firstResult == null || firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX : firstResult);
		if (maxResults != null && maxResults > 0)
			query.setMaxResults(maxResults);

		return query;
	}

	@Transactional
	public <T extends Object> List<T> verifyListNamedQueryAll(String queryName, Object... parameters) {
		try {
			return findListByQueryName(queryName, parameters);
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}

	@Transactional
	public <T extends Object> List<T> verifyListNamedQuery(String queryName, int firstResult, int maxResults,
			Object... parameters) {
		try {
			return findListByQueryName(queryName, firstResult, maxResults, parameters);
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}

	@Transactional
	public <T extends Object> T verifyNamedQueryAll(String queryName, Object... parameters) {
		try {
			return findByQueryName(queryName, parameters);
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}

	@Transactional
	public <T extends Object> T verifyNamedQuery(String queryName, int firstResult, int maxResults,
			Object... parameters) {
		try {
			return findByQueryName(queryName, firstResult, maxResults, parameters);
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> T verifyCreateQuery(String textQuery, Object... parameters) {
		try {
			Query query = getEntityManager().createQuery(textQuery);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i + 1, parameters[i]);
				}
			}
			return (T) query.getSingleResult();
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> List<T> verifyListCreateQuery(String textQuery, Object... parameters) {
		try {
			Query query = getEntityManager().createQuery(textQuery);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i + 1, parameters[i]);
				}
			}
			return query.getResultList();
		} catch (Exception e) {
			AppBaseUtilsWeb.printException(LOGGER, e);
			return null;
		}
	}
}
