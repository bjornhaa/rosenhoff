package no.rosenhoff.servlet;

import no.rosenhoff.common.db.ToppScorererElement;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 17, 2010
 * Time: 11:43:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToppScorerListeComparator implements Comparator<ToppScorererElement> {

    public int compare(ToppScorererElement o1, ToppScorererElement o2) {
        if (o1.getTotal() > o2.getTotal()) {
            return -1;
        } else if (o1.getTotal() < o2.getTotal()) {
            return 1;
        } else if (o1.getMaal() > o2.getMaal()) {
            return -1;
        } else if (o1.getMaal() < o2.getMaal()) {
            return 1;
        } else {
            BigDecimal poengPrKamp1 = o1.getPoengPrKamp();
            BigDecimal poengPrKamp2 = o2.getPoengPrKamp();
            if (poengPrKamp1.intValue() != 0 || poengPrKamp2.intValue() != 0) {
                return poengPrKamp1.compareTo(poengPrKamp2);
            } else if (o1.getKamper() != o2.getKamper()) {
                return o2.getKamper() - o1.getKamper();
            } else {
                return o1.getPerson().getNavn().compareToIgnoreCase(o2.getPerson().getNavn());
            }
        }

    }
}
