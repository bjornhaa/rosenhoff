package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Spiller;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Feb 28, 2010
 * Time: 3:39:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerGuiWrapper {

    Logger log = Logger.getLogger(getClass());

    private Spiller spiller;

    private boolean selected = false;


    private Integer pass;

    private Integer maal;

    public Posisjon getPosisjon() {
        return Posisjon.fromKode(spiller.getPosisjon());
    }

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

    public SpillerGuiWrapper(Spiller spiller) {
        this.spiller = spiller;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setSpiller(Spiller spiller) {
        this.spiller = spiller;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
