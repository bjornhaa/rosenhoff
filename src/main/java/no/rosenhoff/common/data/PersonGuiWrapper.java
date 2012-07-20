package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Person;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Feb 28, 2010
 * Time: 3:39:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonGuiWrapper {

    Logger log = Logger.getLogger(getClass());

    private Person person;

    private boolean selected = false;


    private Integer pass;

    private Integer maal;


    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getMaal() {
        return maal;
    }

    public void setMaal(Integer maal) {
        this.maal = maal;
    }

    public PersonGuiWrapper(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
