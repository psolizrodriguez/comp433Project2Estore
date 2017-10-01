package com.ebook.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractBaseDao<T extends Object> extends AbstractJpaDao {

	@PersistenceContext(unitName = "BASEApplication")
	private EntityManager entityManager;
	protected static final Logger LOG = LoggerFactory.getLogger(AbstractBaseDao.class);

	@SuppressWarnings("hiding")
	@Transactional
	@Override
	public <T extends Object> T store(final T entity) {

		try {
			T returnValue = null;
			returnValue = (T) super.store(entity);
			return returnValue;
		} catch (final JpaOptimisticLockingFailureException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("JPA Object Optimistic Locking Exception in store");
			}
			throw new ApplicationException(e, "error.database.jpa.sqlexception.update");
		} catch (final OptimisticLockingFailureException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Optimistic Locking Failure Exception in store");
			}
			throw new ApplicationException(e, "error.database.sqlexception.update");
		} catch (final CannotAcquireLockException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Cannot acquire lock on files during an update");
			}
			throw new ApplicationException(e, "error.database.sqlexception.cannotacquirelock.update");
		} catch (final DeadlockLoserDataAccessException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(
						"Generic exception thrown when the current process was a deadlock loser, and its transaction rolled back");
			}
			throw new ApplicationException(e, "error.database.sqlexception.deadlockloser.update");
		} catch (final DataAccessException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Generic Excpetion in Database");
			}
			throw new ApplicationException(e, "error.database.sqlexception.dataaccess.update");
		}

	}

	@Transactional
	@Override
	public boolean remove(final Object entity) {
		try {
			super.remove(entity);
			super.flush();
			return true;
		} catch (final JpaOptimisticLockingFailureException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("JPA Object Optimistic Locking Exception in store");
			}
			throw new ApplicationException(e, "error.database.jpa.sqlexception.update");
		} catch (final OptimisticLockingFailureException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Optimistic Locking Failure Exception in store");
			}
			throw new ApplicationException(e, "error.database.sqlexception.update");
		} catch (final CannotAcquireLockException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Cannot acquire lock on files during an update");
			}
			throw new ApplicationException(e, "error.database.sqlexception.cannotacquirelock.update");
		} catch (final DeadlockLoserDataAccessException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(
						"Generic exception thrown when the current process was a deadlock loser, and its transaction rolled back");
			}
			throw new ApplicationException(e, "error.database.sqlexception.deadlockloser.update");
		} catch (final DataAccessException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Generic Excpetion in Database");
			}
			throw new ApplicationException(e, "error.database.sqlexception.dataaccess.update");
		}
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}