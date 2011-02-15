package no.rosenhoff.common.db;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.Sesong;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

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
public class ToppScorerDao {

    private SimpleJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }


    public List<ToppScorererElement> getToppScorerListe(Sesong sesong, Lag lag) {

        String sql = "select sp.*, \n" +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = false) as maal,\n" +
                "(select sum(p.ANT_POENG) from POENG p where p.SPILLER = sp.ID and p.SESONG = ? and p.LAG_NAVN = ? and p.ERPASS = true) as pass,\n" +
                "(select count(ks.KAMP_SPILLER_ID) from KAMP k, KAMP_SPILLER ks where k.SESONG = ? and k.LAG_NAVN = ? and k.ID = ks.KAMP_ID and ks.SPILLER_ID = sp.ID) as kamper\n" +
                "from spiller sp\n" +
                "where sp.SESONG = ?\n" +
                "and   sp.LAG_NAVN = ?\t";

        ParameterizedRowMapper<ToppScorererElement> mapper = new ParameterizedRowMapper<ToppScorererElement>() {

            public ToppScorererElement mapRow(ResultSet rs, int rowNum) throws SQLException {
                ToppScorererElement element = new ToppScorererElement();
                Spiller spiller = new Spiller();
                spiller.setId(rs.getInt("id"));
                spiller.setNavn(rs.getString("navn"));
                element.setSpiller(spiller);
                element.setMaal(rs.getInt("maal"));
                element.setPass(rs.getInt("pass"));
                element.setKamper(rs.getInt("kamper"));
                return element;
            }

        };



        return this.jdbcTemplate.query(sql,mapper,sesong.name(),lag.toString(),sesong.name(),lag.toString(),sesong.name(),lag.toString(), sesong.name(),lag.toString());
        
    }

}
