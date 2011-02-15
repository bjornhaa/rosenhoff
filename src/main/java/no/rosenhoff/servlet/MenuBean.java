package no.rosenhoff.servlet;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Feb 27, 2010
 * Time: 8:38:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuBean {

    private Logger log = Logger.getLogger(getClass());

    private ActivePageEnum activePage;

    private Sesong selectedSesong;

    private Lag selectedLag;

    private TimeZone defaultTimeZone = TimeZone.getDefault();

    public TimeZone getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public Sesong getSelectedSesong() {
        return selectedSesong;
    }


    public Lag getSelectedLag() {
        return selectedLag;
    }


    public ActivePageEnum getActivePage() {
        return activePage;
    }

    public void setActivePage(ActivePageEnum activePage) {
        this.activePage = activePage;
    }

    public String setConstants() {
        Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String lag = paramMap.get("lag");
        String sesong = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sesong");
        String gotoHistory = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("history");
        String gotoPage = null;
        if (StringUtils.isEmpty(gotoHistory)) {
            gotoPage = "main";
            activePage = ActivePageEnum.NYHETER;
        } else {
            gotoPage = "history";
            activePage = ActivePageEnum.HISTORIE;
        }
        selectedLag = Lag.valueOf(lag);
        selectedSesong = Sesong.valueOf(sesong);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute(LoginConstants.LAG_VALGT.name(), Boolean.TRUE);
        return gotoPage;
    }
}
