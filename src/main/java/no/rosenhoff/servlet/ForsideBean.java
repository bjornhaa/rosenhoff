package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Nyhet;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ForsideBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());


    private List<no.rosenhoff.common.db.Nyhet> nyheter;


    public List<Nyhet> getNyheter() {
        hentNyheter();
        return nyheter;
    }

    private void hentNyheter() {
        nyheter = new ArrayList<Nyhet>();
        Nyhet exampleNyhet = new Nyhet();
        exampleNyhet.setAktiv(true);
        exampleNyhet.setSesong(getMenuBean().getSelectedSesong().name());
        exampleNyhet.setLagNavn(getMenuBean().getSelectedLag().name());
        nyheter = nyhetDAO.findByExample(exampleNyhet);
    }


}
