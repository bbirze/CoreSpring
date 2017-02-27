package com.oaktreeair.ffprogram.dao;

import java.util.Collection;

import com.oaktreeair.ffprogram.Segment;

public interface SegmentDao {

	public int getSegmentCount();
	public Collection<Segment> findAllSegments();
	public int insertSegment(Segment s);
}
