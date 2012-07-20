package no.rosenhoff.servlet;

import no.rosenhoff.common.data.PersonGuiWrapper;
import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.Spiller;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 13, 2010
 * Time: 2:33:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonBean extends ManagedBeans {

    private List<PersonGuiWrapper> personer = new ArrayList<PersonGuiWrapper>();

    public List<PersonGuiWrapper> getPersoner() {
        personer = new ArrayList<PersonGuiWrapper>();
        hent();
        return personer;
    }

    

    public String hent() {
        getMenuBean().setActivePage(ActivePageEnum.SPILLERE);
        List<Person> personList = personDAO.findAll();
        for (Person person : personList) {
            Spiller spiller = new Spiller();
            spiller.setLagNavn(getMenuBean().getSelectedLag().name());
            spiller.setSesong(getMenuBean().getSelectedSesong().name());
            spiller.setPersonId(person.getId());
            List<Spiller> spillereByExample = spillerDAO.findByExample(spiller);
            if (spillereByExample.size() > 0) {
                personer.add(new PersonGuiWrapper(person));
            }
        }
        return "spillere";
    }
}
