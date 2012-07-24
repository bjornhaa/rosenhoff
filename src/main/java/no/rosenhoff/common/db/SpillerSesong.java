package no.rosenhoff.common.db;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 22, 2012
 * Time: 6:27:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerSesong {

    private final Sesong sesong;

    private final Lag lag;

    public SpillerSesong(Sesong sesong, Lag lag) {
        this.sesong = sesong;
        this.lag = lag;
    }

    public Sesong getSesong() {
        return sesong;
    }

    public Lag getLag() {
        return lag;
    }
}
