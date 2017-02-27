package com.oaktreeair.ffprogram.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oaktreeair.ffprogram.Award;
import com.oaktreeair.ffprogram.Flier;

@Repository("awardDao")
public class AwardDaoImpl implements AwardDAO {

	private JdbcTemplate template;
	private AwardRowMapper mapper;
	private DataSource theDataSource;

	@Autowired
	private FlierDAO flierDao;

	@Autowired
	public void setDataSource(DataSource ds) {
		theDataSource = ds;
		template = new JdbcTemplate(ds);
		mapper = new AwardRowMapper();
	}

	public class AwardRowMapper implements RowMapper<Award> {

		public Award mapRow(ResultSet rs, int row) throws SQLException {
			Award a = new Award();
			a.setAwardID(rs.getLong("AWARDID"));
			a.setDescription(rs.getString("DESCRIPTION"));
			a.setMilesRequired(rs.getInt("MILESREQUIRED"));

			long flierID = rs.getLong("FlierID");
			a.setFlier(flierDao.findFlierByID(flierID));

			return a;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public int insertAward(Flier flier, Award award) {

		SimpleJdbcInsert inserter = new SimpleJdbcInsert(theDataSource);
		inserter.setTableName("award");
		inserter.usingGeneratedKeyColumns("AwardID");

		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("Description", award.getDescription());
		parms.put("MilesRequired", award.getMilesRequired());
		parms.put("FlierID", flier.getFlierID());

		Number id = inserter.executeAndReturnKey(parms);
		award.setAwardID(id.longValue());
		flier.getAwards().add(award);

		return id.intValue();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void updateAward(Award award) {

		template.update("UPDATE Award SET Description=?, MilesRequired=?, FlierID=?", award.getDescription(),
				award.getMilesRequired(), award.getFlier().getFlierID());
	}

	@Transactional(propagation = Propagation.MANDATORY)
	//@Transactional(propagation = Propagation.NEVER)
	public Collection<Award> findAwardsForFlier(Long flierID) {

		Collection<Award> awards = 
				template.query("SELECT * FROM Award WHERE flierID=?", mapper, flierID);
		return awards;
	}

}
