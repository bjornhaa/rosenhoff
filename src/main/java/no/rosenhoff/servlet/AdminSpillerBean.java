package no.rosenhoff.servlet;

import no.rosenhoff.common.data.SpillerGuiWrapper;
import no.rosenhoff.common.db.KampSpiller;
import no.rosenhoff.common.db.Poeng;
import no.rosenhoff.common.db.Spiller;
import org.apache.log4j.Logger;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.lob.BlobImpl;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminSpillerBean extends ManagedBeans {

    private List<SpillerGuiWrapper> spillere = new ArrayList<SpillerGuiWrapper>();


    private Logger log = Logger.getLogger(getClass());

    private Spiller nySpiller = new Spiller();

    private org.primefaces.model.UploadedFile imageFile;

    private StreamedContent streamImage;
    private Spiller selectedSpiller;

    private Integer fileSizeLimit = 1024*300;

    public Integer getFileSizeLimit() {
        return fileSizeLimit;
    }

    public StreamedContent getStreamImage() throws SQLException {
        Map<String, String> requestParamMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String spillerId = requestParamMap.get("spillerId");
        if (spillerId != null) {
            Spiller spiller = spillerDAO.findById(new Integer(spillerId));
            InputStream stream = spiller.getBilde().getBinaryStream();
            return new DefaultStreamedContent(stream);
        } else {
            InputStream stream = getClass().getResourceAsStream("../images/photo_default.jpg");
            return new DefaultStreamedContent(stream);
        }
    }

    public void setStreamImage(StreamedContent streamImage) {
        this.streamImage = streamImage;
    }


    public Spiller getNySpiller() {
        return nySpiller;
    }

    public void setNySpiller(Spiller nySpiller) {
        this.nySpiller = nySpiller;
    }


    public List<SpillerGuiWrapper> getSpillere() {
        return spillere;
    }

    public void setSpillere(List<SpillerGuiWrapper> spillere) {
        this.spillere = spillere;
    }


    public String redigerSpillere() {
        hentAlleSpillere();
        getMenuBean().setActivePage(ActivePageEnum.REDIGER_SPILLERE);
        return "redigerSpiller";
    }

    private void hentAlleSpillere() {
        spillere = new ArrayList<SpillerGuiWrapper>();
        Spiller spiller = new Spiller();
        spiller.setSesong(getMenuBean().getSelectedSesong().name());
        spiller.setLagNavn(getMenuBean().getSelectedLag().name());
        List<Spiller> spillerList = spillerDAO.findByExample(spiller);
        for (Spiller spillerRes : spillerList) {
            spillere.add(new SpillerGuiWrapper(spillerRes));
        }

    }

    public String lagreSpiller() throws IOException {

        nySpiller.setSesong(getMenuBean().getSelectedSesong().name());
        nySpiller.setLagNavn(getMenuBean().getSelectedLag().name());
        if (imageFile != null) {
            log.debug("lagrer nytt bilde");
            Blob image = new BlobImpl(imageFile.getContents());
            nySpiller.setBilde(image);
        }
        if (nySpiller.getId() == null) {
            spillerDAO.save(nySpiller);
        } else {
            spillerDAO.attachDirty(nySpiller);
        }
        hentAlleSpillere();
        nySpiller = new Spiller();

        return "redigerSpiller";
    }

    public String edit() {
        nySpiller = getSelectedSpiller();
        return "nySpiller";
    }

    public String slett() {
        kampSpillerDAO.deleteBySpiller(getSelectedSpiller().getId());
        poengDAO.deleteBySpiller(getSelectedSpiller().getId());

        spillerDAO.delete(getSelectedSpiller());
        hentAlleSpillere();
        return "redigerSpiller";

    }

    public void handleFileUpload(FileUploadEvent event) {
        log.debug("Uploaded file "+event.getFile().getFileName());
        imageFile = event.getFile();
    }

    public Spiller getSelectedSpiller() {
        return selectedSpiller;
    }

    public void setSelectedSpiller(Spiller selectedSpiller) {
        this.selectedSpiller = selectedSpiller;
    }

}
