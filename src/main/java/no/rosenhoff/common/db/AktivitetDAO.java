package no.rosenhoff.common.db;

import no.rosenhoff.common.data.AktivitetComparator;
import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aktivitet entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @author MyEclipse Persistence Tools
 * @see no.rosenhoff.common.db.Aktivitet
 */

public class AktivitetDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(AktivitetDAO.class);
    // property constants
    public static final String HVA = "hva";
    public static final String SESONG = "sesong";
    public static final String LAG_NAVN = "lagNavn";

    protected void initDao() {
        // do nothing
    }

    public void save(Aktivitet transientInstance) {
        log.debug("saving Aktivitet instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Aktivitet persistentInstance) {
        log.debug("deleting Aktivitet instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Aktivitet findById(java.lang.Integer id) {
        log.debug("getting Aktivitet instance with id: " + id);
        try {
            Aktivitet instance = (Aktivitet) getHibernateTemplate().get(
                    "no.rosenhoff.common.db.Aktivitet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Aktivitet> findByExample(Aktivitet instance) {
        log.debug("finding Aktivitet instance by example");
        try {
            List<Aktivitet> results = (List<Aktivitet>) getHibernateTemplate()
                    .findByExample(instance);
            Collections.sort(results, new AktivitetComparator());
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Aktivitet instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Aktivitet as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public Aktivitet findNextActivity(Sesong sesong, Lag lag) {
        log.debug("Fidning next aktivity");
        Aktivitet next = null;
        try {
            String queryString = "from Aktivitet as model where model.naar > ? and model.sesong = ? and model.lagNavn = ? and model.poll = ? order by model.naar";
            Object[] values = new Object[] {new Date(),sesong.name(),lag.name(),Boolean.TRUE};
            List<Aktivitet> aktiviteter = getHibernateTemplate().find(queryString, values);
            if (aktiviteter.size() > 0) {
                next = aktiviteter.get(0);
            } 
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
        return next;
    }

    public List<Aktivitet> findBySesongLag(Sesong sesong, Lag lag) {
        log.debug("Finding by sesong and lag");
        try {
            String queryString = "from Aktivitet as model where model.sesong = ? and model.lagNavn = ?";
            Object[] values = new Object[] {sesong.name(),lag.name()};
            return getHibernateTemplate().find(queryString, values);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<Aktivitet> findByHva(Object hva) {
        return findByProperty(HVA, hva);
    }

    public List<Aktivitet> findBySesong(Object sesong) {
        return findByProperty(SESONG, sesong);
    }

    public List<Aktivitet> findByLagNavn(Object lagNavn) {
        return findByProperty(LAG_NAVN, lagNavn);
    }

    public List findAll() {
        log.debug("finding all Aktivitet instances");
        try {
            String queryString = "from Aktivitet";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Aktivitet merge(Aktivitet detachedInstance) {
        log.debug("merging Aktivitet instance");
        try {
            Aktivitet result = (Aktivitet) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Aktivitet instance) {
        log.debug("attaching dirty Aktivitet instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Aktivitet instance) {
        log.debug("attaching clean Aktivitet instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static AktivitetDAO getFromApplicationContext(ApplicationContext ctx) {
        return (AktivitetDAO) ctx.getBean("AktivitetDAO");
    }
}