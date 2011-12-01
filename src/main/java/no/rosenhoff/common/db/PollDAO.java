package no.rosenhoff.common.db;

import no.rosenhoff.common.data.AktivitetComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Collections;
import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Poll entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see Poll
 */

public class PollDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(PollDAO.class);
    // property constants

    public static final String AKTIVITET_ID = "aktivitetId";
    

    protected void initDao() {
        // do nothing
    }

    public void save(Poll transientInstance) {
        log.debug("saving Poll instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Poll persistentInstance) {
        log.debug("deleting Poll instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Poll findById(Integer id) {
        log.debug("getting Poll instance with id: " + id);
        try {
            Poll instance = (Poll) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Poll", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Poll> findByExample(Poll instance) {
        log.debug("finding Poll instance by example");
        try {
            List<Poll> results = (List<Poll>) getHibernateTemplate()
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
        log.debug("finding Poll instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Poll as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }


    public List findAll() {
        log.debug("finding all Poll instances");
        try {
            String queryString = "from Poll";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Poll merge(Poll detachedInstance) {
        log.debug("merging Poll instance");
        try {
            Poll result = (Poll) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Poll instance) {
        log.debug("attaching dirty Poll instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Poll instance) {
        log.debug("attaching clean Poll instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static PollDAO getFromApplicationContext(ApplicationContext ctx) {
        return (PollDAO) ctx.getBean("PollDAO");
    }
}