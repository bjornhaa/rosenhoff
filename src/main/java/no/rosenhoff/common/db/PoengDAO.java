package no.rosenhoff.common.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for Poeng
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Poeng
 */

public class PoengDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(PoengDAO.class);
    // property constants
    public static final String SPILLER = "spiller";
    public static final String ERPASS = "erpass";
    public static final String SESONG = "sesong";
    public static final String LAG_NAVN = "lagNavn";
    public static final String KAMP_ID = "kampId";
    public static final String ANT_POENG = "antPoeng";

    protected void initDao() {
        // do nothing
    }

    public void save(Poeng transientInstance) {
        log.debug("saving Poeng instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Poeng persistentInstance) {
        log.debug("deleting Poeng instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Poeng findById(java.lang.Integer id) {
        log.debug("getting Poeng instance with id: " + id);
        try {
            Poeng instance = (Poeng) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Poeng", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Poeng> findByExample(Poeng instance) {
        log.debug("finding Poeng instance by example");
        try {
            List<Poeng> results = (List<Poeng>) getHibernateTemplate()
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
        log.debug("finding Poeng instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Poeng as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Poeng> findBySpiller(Object spiller) {
        return findByProperty(SPILLER, spiller);
    }

    public List<Poeng> findByErpass(Object erpass) {
        return findByProperty(ERPASS, erpass);
    }

    public List<Poeng> findBySesong(Object sesong) {
        return findByProperty(SESONG, sesong);
    }

    public List<Poeng> findByLagNavn(Object lagNavn) {
        return findByProperty(LAG_NAVN, lagNavn);
    }

    public List<Poeng> findByKampId(Object kampId) {
        return findByProperty(KAMP_ID, kampId);
    }

    public List<Poeng> findByAntPoeng(Object antPoeng) {
        return findByProperty(ANT_POENG, antPoeng);
    }

    public List findAll() {
        log.debug("finding all Poeng instances");
        try {
            String queryString = "from Poeng";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Poeng merge(Poeng detachedInstance) {
        log.debug("merging Poeng instance");
        try {
            Poeng result = (Poeng) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Poeng instance) {
        log.debug("attaching dirty Poeng instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Poeng instance) {
        log.debug("attaching clean Poeng instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static PoengDAO getFromApplicationContext(ApplicationContext ctx) {
        return (PoengDAO) ctx.getBean("poengDAO");
    }

    public void deleteByKamp(Integer kampId) {
        getHibernateTemplate().bulkUpdate("delete Poeng p where p.kampId = ?", new Object[]{kampId});
    }

    public void deleteBySpiller(Integer spillerId) {
        getHibernateTemplate().bulkUpdate("delete Poeng p where p.spiller = ?", new Object[]{spillerId});
    }

}