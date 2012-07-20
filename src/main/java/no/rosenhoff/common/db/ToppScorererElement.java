package no.rosenhoff.common.db;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 17, 2010
 * Time: 10:32:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToppScorererElement {


    private Person person;

    private int maal = 0;

    private int pass = 0;

    private int kamper = 0;


    public int getMaal() {
        return maal;
    }

    public void setMaal(int maal) {
        this.maal = maal;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getKamper() {
        return kamper;
    }

    public void setKamper(int kamper) {
        this.kamper = kamper;
    }

    public int getTotal() {
        return maal+pass;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getPoengPrKamp() {
        if (kamper == 0 || getTotal() == 0) {
            return new BigDecimal(0);
        }
        float kampf = Float.valueOf(kamper);
        float tot = Float.valueOf(getTotal());
        float res = tot/kampf;
        return new BigDecimal(res);
    }
}
