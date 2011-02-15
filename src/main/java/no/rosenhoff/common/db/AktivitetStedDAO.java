package no.rosenhoff.common.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * AktivitetSted entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.AktivitetSted
 */

public class AktivitetStedDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(AktivitetStedDAO.class);
    // property constants
    public static final String STEDSNAVN = "stedsnavn";

    protected void initDao() {
        // do nothing
    }

    public void save(AktivitetSted transientInstance) {
        log.debug("saving AktivitetSted instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(AktivitetSted persistentInstance) {
        log.debug("deleting AktivitetSted instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public AktivitetSted findById(java.lang.Integer id) {
        log.debug("getting AktivitetSted instance with id: " + id);
        try {
            AktivitetSted instance = (AktivitetSted) getHibernateTemplate()
                    .get("no.rosenhoff.common.db.AktivitetSted", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<AktivitetSted> findByExample(AktivitetSted instance) {
        log.debug("finding AktivitetSted instance by example");
        try {
            List<AktivitetSted> results = (List<AktivitetSted>) getHibernateTemplate()
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
        log.debug("finding AktivitetSted instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from AktivitetSted as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<AktivitetSted> findByStedsnavn(Object stedsnavn) {
        return findByProperty(STEDSNAVN, stedsnavn);
    }

    public List findAll() {
        log.debug("finding all AktivitetSted instances");
        try {
            String queryString = "from AktivitetSted";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public AktivitetSted merge(AktivitetSted detachedInstance) {
        log.debug("merging AktivitetSted instance");
        try {
            AktivitetSted result = (AktivitetSted) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AktivitetSted instance) {
        log.debug("attaching dirty AktivitetSted instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(AktivitetSted instance) {
        log.debug("attaching clean AktivitetSted instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static AktivitetStedDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (AktivitetStedDAO) ctx.getBean("AktivitetStedDAO");
    }
}