package no.rosenhoff.common.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bruker entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Bruker
 */

public class BrukerDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(BrukerDAO.class);
    // property constants
    public static final String BRUKERNAVN = "brukernavn";
    public static final String PASSORD = "passord";

    protected void initDao() {
        // do nothing
    }

    public void save(Bruker transientInstance) {
        log.debug("saving Bruker instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Bruker persistentInstance) {
        log.debug("deleting Bruker instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Bruker findById(java.lang.Integer id) {
        log.debug("getting Bruker instance with id: " + id);
        try {
            Bruker instance = (Bruker) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Bruker", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Bruker> findByExample(Bruker instance) {
        log.debug("finding Bruker instance by example");
        try {
            List<Bruker> results = (List<Bruker>) getHibernateTemplate()
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
        log.debug("finding Bruker instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Bruker as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Bruker> findByBrukernavn(Object brukernavn) {
        return findByProperty(BRUKERNAVN, brukernavn);
    }

    public List<Bruker> findByPassord(Object passord) {
        return findByProperty(PASSORD, passord);
    }

    public List findAll() {
        log.debug("finding all Bruker instances");
        try {
            String queryString = "from Bruker";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Bruker merge(Bruker detachedInstance) {
        log.debug("merging Bruker instance");
        try {
            Bruker result = (Bruker) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Bruker instance) {
        log.debug("attaching dirty Bruker instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Bruker instance) {
        log.debug("attaching clean Bruker instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static BrukerDAO getFromApplicationContext(ApplicationContext ctx) {
        return (BrukerDAO) ctx.getBean("brukerDAO");
    }
}