package no.rosenhoff.common.db;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 18, 2012
 * Time: 9:12:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PERSON", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Person {

    private Integer id;
    private String navn;
    private String email;
    private String mobil;
    private String imageExtension;

    public Person() {
    }

    public Person(Integer id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    public Person(Integer id, String navn, String email, String mobil, String imageExtension) {
        this.id = id;
        this.navn = navn;
        this.email = email;
        this.mobil = mobil;
        this.imageExtension = imageExtension;
    }

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "NAVN", nullable = false)
    public String getNavn() {
        return navn;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "MOBIL")
    public String getMobil() {
        return mobil;
    }

    @Column(name = "IMAGE_EXTENSION")
    public String getImageExtension() {
        return imageExtension;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE);
        return builder.toString();
    }
}
