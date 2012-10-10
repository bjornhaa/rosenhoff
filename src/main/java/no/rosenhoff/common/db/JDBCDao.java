package no.rosenhoff.common.db;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 17, 2010
 * Time: 10:04:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class JDBCDao {

    private SimpleJdbcTemplate jdbcTemplate;
    private final ParameterizedRowMapper<ToppScorererElement> toppscorerMapper = new ParameterizedRowMapper<ToppScorererElement>() {

        public ToppScorererElement mapRow(ResultSet rs, int rowNum) throws SQLException {
            ToppScorererElement element = new ToppScorererElement();
            Person person = new Person();
            person.setEmail(rs.getString("email"));
            person.setNavn(rs.getString("navn"));
            person.setId(rs.getInt("id"));

            element.setPerson(person);
            element.setMaal(rs.getInt("maal"));
            element.setPass(rs.getInt("pass"));
            element.setKamper(rs.getInt("kamper"));
            return element;
        }

    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }


    public List<ToppScorererElement> getToppScorerListe(Sesong sesong, Lag lag) {

        String sql = "select p.*, " +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = false) as maal, " +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = true) as pass, " +
                "(select count(ks.KAMP_SPILLER_ID) from KAMP k, KAMP_SPILLER ks where k.SESONG = ? and k.LAG_NAVN = ? and k.ID = ks.KAMP_ID and ks.SPILLER_ID = sp.ID) as kamper " +
                "from spiller sp, PERSON p " +
                "where sp.SESONG = ? " +
                "and   sp.LAG_NAVN = ?" +
                "and   p.ID = sp.PERSON_ID";


        return this.jdbcTemplate.query(sql, toppscorerMapper, sesong.name(), lag.toString(), sesong.name(), lag.toString(), sesong.name(), lag.toString(), sesong.name(), lag.toString());

    }


    public List<PersonAsSpiller> findPersonMedSpillerFlag(Sesong sesong, Lag lag) {
        String personSpillerSql = "select s.id as spiller_id, p.*, " +
                "                              exists (select 1 FROM SPILLER s where s.PERSON_ID = p.id and s.LAG_NAVN = ? and s.SESONG = ?) as spiller," +
                "                              exists (select 1 from spiller s, KAMP_SPILLER ks where s.PERSON_ID = p.id and ks.spiller_id = s.id and s.LAG_NAVN = ? and s.SESONG = ?) as har_kamper " +
                "from person p " +
                "left join SPILLER s " +
                "on s.PERSON_ID = p.id and s.LAG_NAVN = ? and s.SESONG = ? " +
                "order by spiller desc,p.navn";

        ParameterizedRowMapper<PersonAsSpiller> mapper = new ParameterizedRowMapper<PersonAsSpiller>() {

            public PersonAsSpiller mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                Integer spillerId = rs.getInt(1);
                person.setId(rs.getInt(2));
                person.setNavn(rs.getString("navn"));
                person.setEmail(rs.getString("email"));
                person.setMobil(rs.getString("mobil"));
                person.setImageExtension(rs.getString("IMAGE_EXTENSION"));
                boolean isSpiller = rs.getBoolean("spiller");
                boolean kamper = rs.getBoolean("har_kamper");
                return new PersonAsSpiller(person, isSpiller, kamper, spillerId);
            }
        };
        return this.jdbcTemplate.query(personSpillerSql, mapper, lag.name(), sesong.name(), lag.name(), sesong.name(), lag.name(), sesong.name());
    }

    public List<Person> findPersonAktivDenneSesongen(Sesong sesong) {
        String personSpillerSql = "select distinct p.* " +
                "from PERSON p, SPILLER s " +
                "where s.SESONG = ? " +
                "and p.ID = s.PERSON_ID " +
                " order by p.navn";

        ParameterizedRowMapper<Person> mapper = new ParameterizedRowMapper<Person>() {

            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setNavn(rs.getString("navn"));
                person.setEmail(rs.getString("email"));
                person.setMobil(rs.getString("mobil"));
                person.setImageExtension(rs.getString("IMAGE_EXTENSION"));
                return person;
            }
        };
        return this.jdbcTemplate.query(personSpillerSql, mapper, sesong.name());

    }

    public ToppScorererElement getScoreForPerson(Sesong sesong, Lag lag, Integer personId) {

        String sql = "select p.*, " +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = false) as maal, " +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = true) as pass, " +
                "(select count(ks.KAMP_SPILLER_ID) from KAMP k, KAMP_SPILLER ks where k.SESONG = ? and k.LAG_NAVN = ? and k.ID = ks.KAMP_ID and ks.SPILLER_ID = sp.ID) as kamper " +
                "from spiller sp, PERSON p " +
                "where sp.SESONG = ? " +
                "and   sp.LAG_NAVN = ?" +
                "and   p.ID = ?" +
                "and   p.ID = sp.PERSON_ID";


        return this.jdbcTemplate.queryForObject(sql, toppscorerMapper, sesong.name(), lag.toString(), sesong.name(), lag.toString(), sesong.name(), lag.toString(), sesong.name(), lag.toString(), personId);

    }

    public List<SpillerSesong> getSpillSesong(Integer personId) {
        String sql = "select s.SESONG, s.LAG_NAVN " +
                "from person p, spiller s " +
                "where p.ID = s.PERSON_ID " +
                "and p.ID = ?";
        ParameterizedRowMapper<SpillerSesong> mapper = new ParameterizedRowMapper<SpillerSesong>() {
            public SpillerSesong mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sesong sesong = Sesong.valueOf(rs.getString("sesong"));
                Lag lag = Lag.valueOf(rs.getString("LAG_NAVN"));
                return new SpillerSesong(sesong, lag);
            }
        };
        return this.jdbcTemplate.query(sql, mapper, personId);
    }


}
