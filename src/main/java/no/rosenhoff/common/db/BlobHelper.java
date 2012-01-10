package no.rosenhoff.common.db;

import org.hibernate.Hibernate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Dec 3, 2011
 * Time: 9:47:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlobHelper {

    private String label;
    private byte[] image;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @SuppressWarnings("unused")
    private void setBlob(Blob imageBlob) {
        this.image = toByteArray(imageBlob);
    }

    @SuppressWarnings("unused")
    private Blob getBlob() {
        return Hibernate.createBlob(this.image);
    }

    private byte[] toByteArray(Blob fromImageBlob) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            return toByteArrayImpl(fromImageBlob, baos);
        } catch (Exception e) {
        }
        return null;
    }

    private byte[] toByteArrayImpl(Blob fromImageBlob,
                                   ByteArrayOutputStream baos) throws SQLException, IOException {
        byte buf[] = new byte[4000];
        int dataSize;
        InputStream is = fromImageBlob.getBinaryStream();

        try {
            while ((dataSize = is.read(buf)) != -1) {
                baos.write(buf, 0, dataSize);
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return baos.toByteArray();
    }

}
