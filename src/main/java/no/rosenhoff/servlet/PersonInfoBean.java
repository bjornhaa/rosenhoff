package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.SpillerSesong;
import no.rosenhoff.common.db.ToppScorererElement;
import org.primefaces.event.CloseEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 22, 2012
 * Time: 5:05:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonInfoBean extends ManagedBeans {

    private PersonInfo personInfo;

    private Person selectedPerson;

    public PersonInfo getPersonInfo() {
        PersonInfo info = personInfo;
        personInfo = null;
        return info;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String lastInfo() {
        personInfo = new PersonInfo();
        List<SpillerSesong> spillSesonger = jdbcDao.getSpillSesong(selectedPerson.getId());
        for (SpillerSesong spillerSesong : spillSesonger) {
            ToppScorererElement scoreElement = jdbcDao.getScoreForPerson(spillerSesong.getSesong(), spillerSesong.getLag(), selectedPerson.getId());
            personInfo.addElement(spillerSesong, scoreElement);
        }
        return "spillere";

    }

    public void handleClose(CloseEvent event) {
        System.out.println("close call");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                event.getComponent().getId() + " closed", "So you don't like nature?");

        facesContext.addMessage(null, message);
    }

    public void handleTest(ActionEvent event) {
        System.out.println("handling done");
    }
}
