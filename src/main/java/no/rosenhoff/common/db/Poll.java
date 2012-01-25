package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "POLL", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Poll {

    private Integer id;
    private Integer aktivitetId;
    private String label;
    private Integer spillerId;
    private boolean kommer;

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "AKTIVITET_ID", nullable = false)
    public Integer getAktivitetId() {
        return aktivitetId;
    }

    public void setAktivitetId(Integer aktivitetId) {
        this.aktivitetId = aktivitetId;
    }

    @Column(name = "SPILLER_ID", nullable = false)
    public Integer getSpillerId() {
        return spillerId;
    }

    public void setSpillerId(Integer spillerId) {
        this.spillerId = spillerId;
    }

    @Column(name = "LABEL", nullable = false)
    public String getLabel() {
        return "Test";
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "KOMMER", nullable = false)
    public boolean isKommer() {
        return kommer;
    }

    public void setKommer(boolean kommer) {
        this.kommer = kommer;
    }
}
