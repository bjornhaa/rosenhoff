package no.rosenhoff.common.db;

import java.util.List;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Rapport entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see no.rosenhoff.common.db.Rapport
 * @author MyEclipse Persistence Tools
 */

public class RapportDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory.getLog(RapportDAO.class);
	// property constants
	public static final String OVERSKRIFT = "overskrift";
	public static final String TEKST = "tekst";
	public static final String SESONG = "sesong";
	public static final String LAG_NAVN = "lagNavn";

	protected void initDao() {
		// do nothing
	}

	public void save(Rapport transientInstance) {
		log.debug("saving Rapport instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Rapport persistentInstance) {
		log.debug("deleting Rapport instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rapport findById(java.lang.Integer id) {
		log.debug("getting Rapport instance with id: " + id);
		try {
			Rapport instance = (Rapport) getHibernateTemplate().get(
					"no.rosenhoff.common.db.Rapport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Rapport> findByExample(Rapport instance) {
		log.debug("finding Rapport instance by example");
		try {
			List<Rapport> results = (List<Rapport>) getHibernateTemplate()
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
		log.debug("finding Rapport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Rapport as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Rapport> findByOverskrift(Object overskrift) {
		return findByProperty(OVERSKRIFT, overskrift);
	}

	public List<Rapport> findByTekst(Object tekst) {
		return findByProperty(TEKST, tekst);
	}

	public List<Rapport> findBySesong(Object sesong) {
		return findByProperty(SESONG, sesong);
	}

	public List<Rapport> findByLagNavn(Object lagNavn) {
		return findByProperty(LAG_NAVN, lagNavn);
	}

	public List findAll() {
		log.debug("finding all Rapport instances");
		try {
			String queryString = "from Rapport";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Rapport merge(Rapport detachedInstance) {
		log.debug("merging Rapport instance");
		try {
			Rapport result = (Rapport) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Rapport instance) {
		log.debug("attaching dirty Rapport instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rapport instance) {
		log.debug("attaching clean Rapport instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RapportDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RapportDAO) ctx.getBean("RapportDAO");
	}

     public Rapport findRapportByKamp(Kamp kamp, Sesong sesong, Lag lag) {
        Rapport rapport = new Rapport();
        rapport.setSesong(sesong.name());
        rapport.setLagNavn(lag.name());
        rapport.setKamp(kamp.getId());
        List<Rapport> rapporter = findByExample(rapport);
        log.debug("found "+rapporter.size()+" rapporter for kamp "+kamp.getId());
        Rapport ret = null;
        if (rapporter.size() > 1) {
            throw new RuntimeException("Found "+rapporter.size()+" reports for kamp "+kamp.getId());
        }
        if (rapporter.size() == 1) {
            ret = rapporter.get(0);
        }

        return ret;

    }

    public void update(Rapport instance) {
        getHibernateTemplate().update(instance);
    }
}