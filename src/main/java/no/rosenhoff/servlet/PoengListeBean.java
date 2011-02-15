package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Spiller;
import no.rosenhoff.common.db.ToppScorerDao;
import no.rosenhoff.common.db.ToppScorererElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 27, 2010
 * Time: 1:35:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class PoengListeBean extends ManagedBeans {

    private List<ToppScorererElement> toppScorereListe;

    public List<ToppScorererElement> getToppScorereListe() {
        toppScorereListe = toppScorerDao.getToppScorerListe(menuBean.getSelectedSesong(),menuBean.getSelectedLag());
        Collections.sort(toppScorereListe,new ToppScorerListeComparator());
        return toppScorereListe;
    }

    private ToppScorerDao toppScorerDao;

    public void setToppScorerDao(ToppScorerDao toppScorerDao) {
        this.toppScorerDao = toppScorerDao;
    }


    public String hent() {
        getMenuBean().setActivePage(ActivePageEnum.POENGLISTA);
        return "poeng";
    }
}
