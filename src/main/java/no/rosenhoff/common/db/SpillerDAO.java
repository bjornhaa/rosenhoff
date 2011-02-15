package no.rosenhoff.common.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Spiller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Spiller
 */

public class SpillerDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(SpillerDAO.class);
    // property constants
    public static final String NAVN = "navn";
    public static final String POSISJON = "posisjon";
    public static final String EMAIL = "email";
    public static final String MOBIL = "mobil";
    public static final String SESONG = "sesong";
    public static final String LAG_NAVN = "lagNavn";

    protected void initDao() {
        // do nothing
    }

    public void save(Spiller transientInstance) {
        log.debug("saving Spiller instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Spiller persistentInstance) {
        log.debug("deleting Spiller instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Spiller findById(java.lang.Integer id) {
        log.debug("getting Spiller instance with id: " + id);
        try {
            Spiller instance = (Spiller) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Spiller", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Spiller> findByExample(Spiller instance) {
        log.debug("finding Spiller instance by example");
        try {
            List<Spiller> results = (List<Spiller>) getHibernateTemplate()
                    .findByExample(instance);
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Spiller instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Spiller as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Spiller> findByNavn(Object navn) {
        return findByProperty(NAVN, navn);
    }

    public List<Spiller> findByPosisjon(Object posisjon) {
        return findByProperty(POSISJON, posisjon);
    }

    public List<Spiller> findByEmail(Object email) {
        return findByProperty(EMAIL, email);
    }

    public List<Spiller> findByMobil(Object mobil) {
        return findByProperty(MOBIL, mobil);
    }

    public List<Spiller> findBySesong(Object sesong) {
        return findByProperty(SESONG, sesong);
    }

    public List<Spiller> findByLagNavn(Object lagNavn) {
        return findByProperty(LAG_NAVN, lagNavn);
    }

    public List findAll() {
        log.debug("finding all Spiller instances");
        try {
            String queryString = "from Spiller";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Spiller merge(Spiller detachedInstance) {
        log.debug("merging Spiller instance");
        try {
            Spiller result = (Spiller) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Spiller instance) {
        log.debug("attaching dirty Spiller instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Spiller instance) {
        log.debug("attaching clean Spiller instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static SpillerDAO getFromApplicationContext(ApplicationContext ctx) {
        return (SpillerDAO) ctx.getBean("spillerDAO");
    }
}