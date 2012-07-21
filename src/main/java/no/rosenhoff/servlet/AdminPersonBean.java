package no.rosenhoff.servlet;

import no.rosenhoff.common.data.Constants;
import no.rosenhoff.common.data.PersonGuiWrapper;
import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.Spiller;
import org.apache.log4j.Logger;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminPersonBean extends ManagedBeans {

    private List<PersonGuiWrapper> personer = new ArrayList<PersonGuiWrapper>();


    private Logger log = Logger.getLogger(getClass());

    private Person nyPerson = new Person();

    private Person selectedPerson;

    UploadedFile upFile;

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }

    public String upload() throws IOException {
        if (getSelectedPerson().getId() == null) {
            addInfoMessage("MŒ lagre personern f¿rst");
            return "nyPerson";

        }
        String contentType = upFile.getContentType();
        String[] split = contentType.split("/");
        if (split.length != 2) {
            throw new RuntimeException("kjer a, pr¿v ett bilde a");
        }
        if (!split[0].equalsIgnoreCase("image")) {
            throw new RuntimeException("Bare bilder kan lastes opp");
        }
        String ext = split[1];
        String path = Constants.UPLOAD_BASE_PATH + "/" + getSelectedPerson().getId() + "." + ext;
        File imageFile = new File(path);
        imageFile.mkdirs();

        BufferedImage bimg = ImageIO.read(upFile.getInputStream());
        getSelectedPerson().setImageExtension(ext);
        getPersonDAO().attachDirty(getSelectedPerson());
        ImageIO.write(bimg, ext, imageFile);

        return "nyPerson";

    }


    public Person getNyPerson() {
        return nyPerson;
    }

    public void setNyPerson(Person nyPerson) {
        this.nyPerson = nyPerson;
    }


    public List<PersonGuiWrapper> getPersoner() {
        return personer;
    }

    public void setPersoner(List<PersonGuiWrapper> personer) {
        this.personer = personer;
    }


    public String redigerPersoner() {
        hentAllePersoner();
        getMenuBean().setActivePage(ActivePageEnum.REDIGER_PERSONER);
        return "redigerPerson";
    }

    private void hentAllePersoner() {
        personer = new ArrayList<PersonGuiWrapper>();
        List<Person> personList = personDAO.findAll();
        for (Person person : personList) {
            personer.add(new PersonGuiWrapper(person));
        }

    }

    public String lagrePerson() throws IOException {

        if (nyPerson.getId() == null) {
            personDAO.save(nyPerson);
        } else {
            personDAO.attachDirty(nyPerson);
        }
        hentAllePersoner();
        nyPerson = new Person();

        return "redigerPerson";
    }

    public String edit() {
        nyPerson = getSelectedPerson();
        return "nyPerson";
    }

    public String slett() {
        Spiller spiller = new Spiller();

        spiller.setPersonId(selectedPerson.getId());
        List<Spiller> spillerList = spillerDAO.findByExample(spiller);
        if (spillerList.size() > 0) {
            addInfoMessage("Kan ikke slette en person som er tilordnet ett lag");
            return null;

        }
        personDAO.delete(selectedPerson);
        hentAllePersoner();
        return "redigerPerson";

    }

    public String nyPerson() {
        selectedPerson = new Person();
        nyPerson = new Person();
        return "nyPerson";

    }


    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

}
