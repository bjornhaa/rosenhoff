package no.rosenhoff.servlet;

import no.rosenhoff.common.data.SpillerGuiWrapper;
import no.rosenhoff.common.db.Kamp;
import no.rosenhoff.common.db.KampSpiller;
import no.rosenhoff.common.db.Poeng;
import no.rosenhoff.common.db.Spiller;
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

    private List<SpillerGuiWrapper> spillere = new ArrayList<SpillerGuiWrapper>();

    private List<SpillerGuiWrapper> spillereIKamp = new ArrayList<SpillerGuiWrapper>();


    public List<SpillerGuiWrapper> getSpillereIKamp() {
        return spillereIKamp;
    }

    public List<SpillerGuiWrapper> getSpillere() {
        spillere = hentSpillere();
        return spillere;
    }

    public void setSpillere(List<SpillerGuiWrapper> spillere) {
        this.spillere = spillere;
    }

    public Kamp getSelectedKamp() {
        return selectedKamp;
    }

    public void setSelectedKamp(Kamp selectedKamp) {
        this.selectedKamp = selectedKamp;
    }


    private List<SpillerGuiWrapper> hentSpillere() {
        List<SpillerGuiWrapper> tmp = new ArrayList<SpillerGuiWrapper>();
        Spiller spiller = new Spiller();
        spiller.setSesong(getMenuBean().getSelectedSesong().name());
        spiller.setLagNavn(getMenuBean().getSelectedLag().name());
        List<Spiller> spillerList = spillerDAO.findByExample(spiller);
        for (Spiller spillerRes : spillerList) {
            tmp.add(new SpillerGuiWrapper(spillerRes, null));
        }
        return tmp;
    }


    public String lagreSpillerKamp() {
        spillereIKamp = new ArrayList<SpillerGuiWrapper>();

        for (SpillerGuiWrapper spillerGuiWrapper : spillere) {
            if (spillerGuiWrapper.isSelected()) {
                Spiller spiller = spillerGuiWrapper.getSpiller();
                KampSpiller kampSpiller = new KampSpiller();
                kampSpiller.setSpillerId(spiller.getId());
                kampSpiller.setKampId(selectedKamp.getId());
                kampSpillerDAO.save(kampSpiller);
                spillereIKamp.add(spillerGuiWrapper);
            }
        }
        return "nyPoengKamp";
    }

    public String lagreSpilerPoeng() {
        for (SpillerGuiWrapper spillerGuiWrapper : spillereIKamp) {
            if (spillerGuiWrapper.getMaal() != null && spillerGuiWrapper.getMaal() > 0) {
                Poeng poeng = new Poeng();
                poeng.setErpass(false);
                poeng.setAntPoeng(spillerGuiWrapper.getMaal());
                poeng.setKampId(selectedKamp.getId());
                poeng.setLagNavn(getMenuBean().getSelectedLag().name());
                poeng.setSesong(getMenuBean().getSelectedSesong().name());
                poeng.setSpiller(spillerGuiWrapper.getSpiller().getId());
                poengDAO.save(poeng);
            }
            if (spillerGuiWrapper.getPass() != null && spillerGuiWrapper.getPass() > 0) {
                Poeng poeng = new Poeng();
                poeng.setErpass(true);
                poeng.setAntPoeng(spillerGuiWrapper.getPass());
                poeng.setKampId(selectedKamp.getId());
                poeng.setLagNavn(getMenuBean().getSelectedLag().name());
                poeng.setSesong(getMenuBean().getSelectedSesong().name());
                poeng.setSpiller(spillerGuiWrapper.getSpiller().getId());
                poengDAO.save(poeng);
            }
        }

        addInfoMessage("Resultat lagret");
        return "redigerResultat";
    }

}
