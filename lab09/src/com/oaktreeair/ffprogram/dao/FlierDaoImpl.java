package com.oaktreeair.ffprogram.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oaktreeair.ffprogram.Award;
import com.oaktreeair.ffprogram.Flier;

@Repository("flierDao)")
public class FlierDaoImpl implements FlierDAO {

	public class FlierRowMapper implements RowMapper<Flier> {

		@Override
		public Flier mapRow(ResultSet rs, int row) throws SQLException {
			Flier f = new Flier();
			f.setFlierID(rs.getLong("FLIERID"));
			f.setName(rs.getString("Name"));
			f.setMileageBalance(rs.getInt("MILEAGEBALANCE"));
			return f;
		}

	}

	private JdbcTemplate template;
	private FlierRowMapper mapper;
	private DataSource theDataSource;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		theDataSource = ds;
		template = new JdbcTemplate(ds);
		mapper = new FlierRowMapper();
	}
	
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public Flier findFlierByID(Long flierID) {
		return template.queryForObject("SELECT * FROM Flier WHERE flierID=?", mapper, flierID);
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void updateFlier(Flier flier) {

		template.update("UPDATE FLIER SET NAME=?, MILEAGEBALANCE=?  WHERE flierID=?", 
				flier.getName(), flier.getMileageBalance(), flier.getFlierID());
	}

}
