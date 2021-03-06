package com.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovane
 */
import com.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<T> {

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
        
	public void salvar(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(entity);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Criteria consulta = session.createCriteria(classe);
			transacao.commit();
			return consulta.list();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public T buscarPorCodigo(Integer codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Criteria consulta = session.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			T resultado = (T) consulta.uniqueResult();
			transacao.commit();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public void excluir(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.delete(entity);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public boolean alterar(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(entity);
			transacao.commit();
			return true;
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public boolean merge(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.merge(entity);
			transacao.commit();
			return true;
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}