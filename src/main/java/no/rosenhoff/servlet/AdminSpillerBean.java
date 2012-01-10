package no.rosenhoff.servlet;

import no.rosenhoff.common.data.Constants;
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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
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


    UploadedFile upFile;

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }

    public String upload() throws IOException {
        if (getSelectedSpiller().getId() == null) {
            addInfoMessage("MŒ lagre spilleren f¿rst");
            return "nySpiller";

        }
        String contentType = upFile.getContentType();
        String[] split = contentType.split("/");
        if (split.length!= 2) {
            throw new RuntimeException("kjer a, pr¿v ett bilde a");
        }
        if (!split[0].equalsIgnoreCase("image")) {
            throw new RuntimeException("Bare bilder kan lastes opp");
        }
        String ext = split[1];
        String path = Constants.UPLOAD_BASE_PATH +getMenuBean().getSelectedSesong()+"/"+getMenuBean().getSelectedLag()+"/"+ getSelectedSpiller().getId()+"." + ext;
        File imageFile = new File(path);
        imageFile.mkdirs();

        BufferedImage bimg = ImageIO.read(upFile.getInputStream());
        getSelectedSpiller().setImageExtension(ext);
        getSpillerDAO().attachDirty(getSelectedSpiller());
        ImageIO.write(bimg,ext,imageFile);

        return "nySpiller";
        
    }

    private Spiller selectedSpiller;


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

    public String nySpiller() {
        selectedSpiller = new Spiller();
        nySpiller = new Spiller();
        return "nySpiller";
        
    }


    public Spiller getSelectedSpiller() {
        return selectedSpiller;
    }

    public void setSelectedSpiller(Spiller selectedSpiller) {
        this.selectedSpiller = selectedSpiller;
    }

}
