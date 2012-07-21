package no.rosenhoff.servlet;

import no.rosenhoff.common.data.SpillerGuiWrapper;
import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.PersonAsSpiller;
import no.rosenhoff.common.db.PersonDAO;
import no.rosenhoff.common.db.Spiller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 20, 2012
 * Time: 3:10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminSpillerBean extends ManagedBeans {

    private List<PersonAsSpiller> personer = new ArrayList<PersonAsSpiller>();

    private PersonAsSpiller selectedPerson;
    private static final String REDIGER_SPILLERE = "redigerSpillere";

    public String redigerSpillere() {
        hentSpillere();

        return REDIGER_SPILLERE;
    }

    private void hentSpillere() {
        getMenuBean().setActivePage(ActivePageEnum.REDIGER_SPILLERE);
        personer = getJdbcDao().findPersonMedSpillerFlag(getMenuBean().getSelectedSesong(), getMenuBean().getSelectedLag());
    }

    public List<PersonAsSpiller> getPersoner() {
        return personer;
    }

    public PersonAsSpiller getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonAsSpiller selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String aktiverSpiller() {
        Spiller spiller = new Spiller();
        spiller.setLagNavn(getMenuBean().getSelectedLag().name());
        spiller.setSesong(getMenuBean().getSelectedSesong().name());
        spiller.setPersonId(getSelectedPerson().getPerson().getId());
        spiller.setPosisjon("B");
        getSpillerDAO().save(spiller);
        hentSpillere();
        return REDIGER_SPILLERE;
    }

    public String deAktiverSpiller() {
        Spiller spillerToDelete = getSpillerDAO().findById(getSelectedPerson().getSpillerId());
        getSpillerDAO().delete(spillerToDelete);
        hentSpillere();
        return REDIGER_SPILLERE;


    }
}
