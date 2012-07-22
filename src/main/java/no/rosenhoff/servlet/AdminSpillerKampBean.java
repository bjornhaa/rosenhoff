package no.rosenhoff.servlet;

import no.rosenhoff.common.data.SpillerGuiWrapper;
import no.rosenhoff.common.db.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 1, 2010
 * Time: 10:22:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminSpillerKampBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());


    private Kamp selectedKamp;

    private List<PersonAsSpiller> spillere = new ArrayList<PersonAsSpiller>();

    private List<PersonAsSpiller> spillereIKamp = new ArrayList<PersonAsSpiller>();


    public List<PersonAsSpiller> getSpillereIKamp() {
        return spillereIKamp;
    }

    public List<PersonAsSpiller> getSpillere() {
        spillere = hentSpillere();
        return spillere;
    }


    public Kamp getSelectedKamp() {
        return selectedKamp;
    }

    public void setSelectedKamp(Kamp selectedKamp) {
        this.selectedKamp = selectedKamp;
    }


    private List<PersonAsSpiller> hentSpillere() {
        List<PersonAsSpiller> tmp = jdbcDao.findPersonMedSpillerFlag(getMenuBean().getSelectedSesong(), getMenuBean().getSelectedLag());
        for (PersonAsSpiller personAsSpiller : tmp) {
            if (personAsSpiller.isSpiller()) {
                spillere.add(personAsSpiller);
            }
        }

        return spillere;
    }


    public String lagreSpillerKamp() {
        spillereIKamp = new ArrayList<PersonAsSpiller>();

        for (PersonAsSpiller spillerGuiWrapper : spillere) {
            if (spillerGuiWrapper.isSelected()) {
                KampSpiller kampSpiller = new KampSpiller();
                kampSpiller.setSpillerId(spillerGuiWrapper.getSpillerId());
                kampSpiller.setKampId(selectedKamp.getId());
                kampSpillerDAO.save(kampSpiller);
                spillereIKamp.add(spillerGuiWrapper);
            }
        }
        return "nyPoengKamp";
    }

    public String lagreSpilerPoeng() {
        for (PersonAsSpiller spillerGuiWrapper : spillereIKamp) {
            if (spillerGuiWrapper.getMaal() != null && spillerGuiWrapper.getMaal() > 0) {
                Poeng poeng = new Poeng();
                poeng.setErpass(false);
                poeng.setAntPoeng(spillerGuiWrapper.getMaal());
                poeng.setKampId(selectedKamp.getId());
                poeng.setLagNavn(getMenuBean().getSelectedLag().name());
                poeng.setSesong(getMenuBean().getSelectedSesong().name());
                poeng.setSpiller(spillerGuiWrapper.getSpillerId());
                poengDAO.save(poeng);
            }
            if (spillerGuiWrapper.getPass() != null && spillerGuiWrapper.getPass() > 0) {
                Poeng poeng = new Poeng();
                poeng.setErpass(true);
                poeng.setAntPoeng(spillerGuiWrapper.getPass());
                poeng.setKampId(selectedKamp.getId());
                poeng.setLagNavn(getMenuBean().getSelectedLag().name());
                poeng.setSesong(getMenuBean().getSelectedSesong().name());
                poeng.setSpiller(spillerGuiWrapper.getSpillerId());
                poengDAO.save(poeng);
            }
        }

        addInfoMessage("Resultat lagret");
        return "redigerResultat";
    }

}
