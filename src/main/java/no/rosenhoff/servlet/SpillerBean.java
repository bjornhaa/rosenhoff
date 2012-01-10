package no.rosenhoff.servlet;

import no.rosenhoff.common.data.SpillerGuiWrapper;
import no.rosenhoff.common.db.Spiller;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.context.FacesContext;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 13, 2010
 * Time: 2:33:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerBean extends ManagedBeans {

    private List<SpillerGuiWrapper> spillere = new ArrayList<SpillerGuiWrapper>();

    public List<SpillerGuiWrapper> getSpillere() {
        spillere = new ArrayList<SpillerGuiWrapper>();
        hent();
        return spillere;
    }

    

    public String hent() {
        getMenuBean().setActivePage(ActivePageEnum.SPILLERE);
        Spiller spiller = new Spiller();
        spiller.setSesong(getMenuBean().getSelectedSesong().name());
        spiller.setLagNavn(getMenuBean().getSelectedLag().name());
        List<Spiller> spillerList = spillerDAO.findByExample(spiller);
        for (Spiller spillerRes : spillerList) {
            spillere.add(new SpillerGuiWrapper(spillerRes));
        }
        return "spillere";
    }
}
