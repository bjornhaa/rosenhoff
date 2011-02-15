package no.rosenhoff.common.db;

import no.rosenhoff.common.data.NyhetComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Collections;
import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for Nyhet
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Nyhet
 */

public class NyhetDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(NyhetDAO.class);
    // property constants
    public static final String NYHET_TXT = "nyhetTxt";
    public static final String AKTIV = "aktiv";
    public static final String SESONG = "sesong";
    public static final String LAG_NAVN = "lagNavn";
    public static final String OVERSKRIFT = "overskrift";

    protected void initDao() {
        // do nothing
    }

    public void save(Nyhet transientInstance) {
        log.debug("saving Nyhet instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Nyhet persistentInstance) {
        log.debug("deleting Nyhet instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Nyhet findById(java.lang.Integer id) {
        log.debug("getting Nyhet instance with id: " + id);
        try {
            Nyhet instance = (Nyhet) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Nyhet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Nyhet> findByExample(Nyhet instance) {
        log.debug("finding Nyhet instance by example");
        try {
            List<Nyhet> results = (List<Nyhet>) getHibernateTemplate()
                    .findByExample(instance);
            log.debug("find by example successful, result size: "
                    + results.size());
            Collections.sort(results, new NyhetComparator());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Nyhet instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Nyhet as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Nyhet> findByNyhetTxt(Object nyhetTxt) {
        return findByProperty(NYHET_TXT, nyhetTxt);
    }

    public List<Nyhet> findByAktiv(Object aktiv) {
        return findByProperty(AKTIV, aktiv);
    }

    public List<Nyhet> findBySesong(Object sesong) {
        return findByProperty(SESONG, sesong);
    }

    public List<Nyhet> findByLagNavn(Object lagNavn) {
        return findByProperty(LAG_NAVN, lagNavn);
    }

    public List<Nyhet> findByOverskrift(Object overskrift) {
        return findByProperty(OVERSKRIFT, overskrift);
    }

    public List findAll() {
        log.debug("finding all Nyhet instances");
        try {
            String queryString = "from Nyhet";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Nyhet merge(Nyhet detachedInstance) {
        log.debug("merging Nyhet instance");
        try {
            Nyhet result = (Nyhet) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Nyhet instance) {
        log.debug("attaching dirty Nyhet instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Nyhet instance) {
        log.debug("attaching clean Nyhet instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static NyhetDAO getFromApplicationContext(ApplicationContext ctx) {
        return (NyhetDAO) ctx.getBean("nyhetDAO");
    }
}