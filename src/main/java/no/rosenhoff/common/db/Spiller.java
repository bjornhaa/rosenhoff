package no.rosenhoff.common.db;

import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Spiller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SPILLER", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Spiller implements java.io.Serializable {

    // Fields

    private Integer id;
    private String posisjon;
    private String sesong;
    private String lagNavn;
    private Integer personId;

    public Spiller() {
    }

    /**
     * full constructor
     */
    public Spiller(String posisjon, String sesong, String lagNavn, Integer personId) {
        this.posisjon = posisjon;
        this.sesong = sesong;
        this.lagNavn = lagNavn;
        this.personId = personId;
    }

    // Property accessors

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "POSISJON", nullable = false,length = 3)
    public String getPosisjon() {
        return this.posisjon;
    }

    public void setPosisjon(String posisjon) {
        this.posisjon = posisjon;
    }




    @Column(name = "SESONG", nullable = false,length = 15)
    public String getSesong() {
        return this.sesong;
    }

    public void setSesong(String sesong) {
        this.sesong = sesong;
    }

    @Column(name = "LAG_NAVN", nullable = false, length = 10)
    public String getLagNavn() {
        return this.lagNavn;
    }

    public void setLagNavn(String lagNavn) {
        this.lagNavn = lagNavn;
    }

    @Column(name = "PERSON_ID", nullable = false)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}