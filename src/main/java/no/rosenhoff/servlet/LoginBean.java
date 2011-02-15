package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Bruker;
import org.apache.log4j.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 9, 2010
 * Time: 12:28:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());

    private String username;
    private String password;
    private boolean innlogget = false;


    public boolean isInnlogget() {
        return innlogget;
    }


    public void setInnlogget(boolean innlogget) {
        this.innlogget = innlogget;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String login() {
        Bruker exampleBruker = new Bruker();
        exampleBruker.setBrukernavn(getUsername());
        exampleBruker.setPassord(getPassword());
        List<Bruker> brukere = brukerDAO.findByExample(exampleBruker);
        boolean ok = brukere.size() > 0;
        log.debug("Logget inn bruker " + getUsername() + " med passord " + getPassword() + ". Resultat: " + ok);
        setInnlogget(ok);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (ok) {
            session.setAttribute(LoginConstants.INNLOGGET.name(), new Boolean(true));
            return "login";
        } else {
            addInfoMessage("Feil brukernavn/passord");
            return null;
        }

    }

}
