package no.rosenhoff.common.data;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

/** @author Hibernate CodeGenerator */
public class Bilde implements Serializable {


	/** identifier field */
	private Integer id;

	/** persistent field */
	private Blob bildeBlob;

	/** nullable persistent field */
	private String bildetekst;
	
	/** persistent field */
	private String katalog;
	



	
	public byte[] getBilde() {
		if (getBildeBlob() == null) {
			return null;
		} else {
			return toByteArray(getBildeBlob());
		}
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/** Don't invoke this.  Used by Hibernate only. */
	private Blob getBildeBlob() {
		return bildeBlob;
		//return Hibernate.createBlob(this.bilde);
	}

	/** Don't invoke this.  Used by Hibernate only. */
	private void setBildeBlob(Blob bilde) {
		this.bildeBlob = bilde;
		//this.bilde = this.toByteArray(bilde);
	}

	private byte[] toByteArray(Blob blob) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = null;

		try {
			is = blob.getBinaryStream();
			int read;
			while ((read = is.read()) != -1) {
				baos.write(read);
			}
			return baos.toByteArray();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (baos != null) {
				try {
					baos.close();
					is.close();
				} catch (IOException ex) {
				}
			}
		}
	}


	public String getBildetekst() {
		return this.bildetekst;
	}

	public void setBildetekst(String bildetekst) {
		this.bildetekst = bildetekst;
	}
	
	

	public String getKatalog() {
		return katalog;
	}


	public void setKatalog(String katalog) {
		this.katalog = katalog;
	}


	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Bilde))
			return false;
		Bilde castOther = (Bilde) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

}
