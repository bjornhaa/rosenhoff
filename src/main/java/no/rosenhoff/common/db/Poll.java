package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "POLL", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Poll {

    private Integer id;
    private Integer aktivitetId;
    private Integer antPositive;
    private Integer antNegative;
    private String label;

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

    @Column(name = "ANT_POSITIVE", nullable = false)
    public Integer getAntPositive() {
        return antPositive;
    }

    public void setAntPositive(Integer antPositive) {
        this.antPositive = antPositive;
    }

    @Column(name = "ANT_NEGATIVE", nullable = false)
    public Integer getAntNegative() {
        return antNegative;
    }

    public void setAntNegative(Integer antNegative) {
        this.antNegative = antNegative;
    }

    @Column(name = "LABEL", nullable = false)
    public String getLabel() {
        return "Test";
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
