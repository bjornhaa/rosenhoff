package no.rosenhoff.servlet;

import no.rosenhoff.common.db.SpillerSesong;
import no.rosenhoff.common.db.ToppScorererElement;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.SetUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 22, 2012
 * Time: 5:07:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonInfo {

    private Map<SpillerSesong, ToppScorererElement> sesongToppScorererElementMap = new HashMap<SpillerSesong, ToppScorererElement>();

    public Map<SpillerSesong, ToppScorererElement> getSesongToppScorererElementMap() {
        return sesongToppScorererElementMap;
    }

    public void addElement(SpillerSesong spillerSesong, ToppScorererElement element) {
        sesongToppScorererElementMap.put(spillerSesong, element);
    }

    public List<SpillerSesong> getSpillerSesonger() {
        return new ArrayList(sesongToppScorererElementMap.keySet());
    }
}
