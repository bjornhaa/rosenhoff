package no.rosenhoff.common.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for Kamp
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Kamp
 */

public class KampDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(KampDAO.class);
    // property constants
    public static final String MOTSTANDER = "motstander";
    public static final String HJEMME = "hjemme";
    public static final String MAAL_SCORET = "maalScoret";
    public static final String MAAL_SLUPPET_INN = "maalSluppetInn";
    public static final String BESKRIVELSE = "beskrivelse";
    public static final String SESONG = "sesong";
    public static final String LAG_NAVN = "lagNavn";

    protected void initDao() {
        // do nothing
    }

    public void save(Kamp transientInstance) {
        log.debug("saving Kamp instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Kamp persistentInstance) {
        log.debug("deleting Kamp instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Kamp findById(java.lang.Integer id) {
        log.debug("getting Kamp instance with id: " + id);
        try {
            Kamp instance = (Kamp) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Kamp", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Kamp> findByExample(Kamp instance) {
        log.debug("finding Kamp instance by example");
        try {
            List<Kamp> results = (List<Kamp>) getHibernateTemplate()
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
        log.debug("finding Kamp instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Kamp as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Kamp> findByMotstander(Object motstander) {
        return findByProperty(MOTSTANDER, motstander);
    }

    public List<Kamp> findByHjemme(Object hjemme) {
        return findByProperty(HJEMME, hjemme);
    }

    public List<Kamp> findByMaalScoret(Object maalScoret) {
        return findByProperty(MAAL_SCORET, maalScoret);
    }

    public List<Kamp> findByMaalSluppetInn(Object maalSluppetInn) {
        return findByProperty(MAAL_SLUPPET_INN, maalSluppetInn);
    }

    public List<Kamp> findByBeskrivelse(Object beskrivelse) {
        return findByProperty(BESKRIVELSE, beskrivelse);
    }

    public List<Kamp> findBySesong(Object sesong) {
        return findByProperty(SESONG, sesong);
    }

    public List<Kamp> findByLagNavn(Object lagNavn) {
        return findByProperty(LAG_NAVN, lagNavn);
    }

    public List findAll() {
        log.debug("finding all Kamp instances");
        try {
            String queryString = "from Kamp";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Kamp merge(Kamp detachedInstance) {
        log.debug("merging Kamp instance");
        try {
            Kamp result = (Kamp) getHibernateTemplate().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Kamp instance) {
        log.debug("attaching dirty Kamp instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Kamp instance) {
        log.debug("attaching clean Kamp instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static KampDAO getFromApplicationContext(ApplicationContext ctx) {
        return (KampDAO) ctx.getBean("kampDAO");
    }
}