package com.oaktreeair.ffprogram.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.oaktreeair.ffprogram.Segment;


@Repository("segmentDao")
public class SegmentDaoImpl implements SegmentDao {
	Logger log = Logger.getLogger(SegmentDaoImpl.class);
	private JdbcTemplate template;
	private SegmentRowMapper mapper;
	private DataSource segDS;
	
	public class SegmentRowMapper implements RowMapper<Segment> {		
		@Override
		public Segment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Segment seg = new Segment();
			seg.setSegmentNumber(rs.getLong("SegmentNumber"));
			seg.setSegmentDate(rs.getDate("SegmentDate"));
			seg.setFlightNumber(rs.getInt("FlightNumber"));
			seg.setOriginatingCity(rs.getString("OrigCity"));
			seg.setMiles(rs.getInt("Miles"));
			
			return seg;
		}
	}
	
	@Autowired
	public void setDataSource(DataSource ds)  {
		template = new JdbcTemplate(ds);
		segDS = ds;
		mapper = new SegmentRowMapper();
	}
	
	@Override
	public int getSegmentCount() {
		int count = template.queryForObject("SELECT COUNT(*) FROM Segment", Integer.class);
		return count;
	}

	@Override
	public Collection<Segment> findAllSegments() {
		Collection<Segment> segs = template.query("SELECT * FROM Segment", mapper);
		return segs;
		}

	@Override
	public int insertSegment(Segment s) {
		
		return insertStudentReturnId(s);
//		return template.update(
//				"INSERT INTO Segment (SegmentDate, FlightNumber, OrigCity, Miles) VALUES(?,?,?,?)",
//				s.getSegmentDate(), s.getFlightNumber(), s.getOriginatingCity(), s.getMiles());
	}
	
	public int insertStudentReturnId(Segment s)  {
		
		SimpleJdbcInsert inserter = new SimpleJdbcInsert(segDS);
		inserter.setTableName("Segment");
		inserter.usingGeneratedKeyColumns("SegmentNumber");
		Map<String, Object> parms = new HashMap<>();
		parms.put("SegmentDate", s.getSegmentDate());
		parms.put("FlightNumber", s.getFlightNumber());
		parms.put("OrigCity", s.getOriginatingCity());
		parms.put("Miles", s.getMiles());
		
		Number id = inserter.executeAndReturnKey(parms);
		return id.intValue();
	}

}
