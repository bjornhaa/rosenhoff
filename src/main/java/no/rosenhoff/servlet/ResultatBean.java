package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 14, 2010
 * Time: 2:16:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResultatBean extends ManagedBeans {

    private List<Kamp> resultater;

    public List<Kamp> getResultater() {
        Kamp exampleKamp = new Kamp();
        exampleKamp.setSesong(getMenuBean().getSelectedSesong().name());
        exampleKamp.setLagNavn(getMenuBean().getSelectedLag().name());
        resultater = kampDAO.findByExample(exampleKamp);
        Collections.sort(resultater,new KampComparator());
        return resultater;
    }

    public String hent() {
        getMenuBean().setActivePage(ActivePageEnum.RESULTATER);
        return "resultater";
    }
}