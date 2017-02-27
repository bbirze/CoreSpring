package com.oaktreeair.ffprogram.controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oaktreeair.ffprogram.Segment;

@Controller
@RequestMapping("rest")
public class SegmentController {

	private static long nextID = 15;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	@Autowired
	private ServletContext servletCtx;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/segment/{segmentNumber}", method = RequestMethod.GET)
	public @ResponseBody Segment getSegment(@PathVariable("segmentNumber") long segNum) {

		List<Segment> segments = (List<Segment>) servletCtx.getAttribute("segments");
		for (Segment s : segments) {
			if (segNum == s.getSegmentNumber()) {
				return s; // return matching Segment
			}
		}

		throw new ResourceNotFoundException(); // didn't find segment
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/segment", method = RequestMethod.GET)
	public @ResponseBody List<Segment> getSegments() {
		
		List<Segment> segments = (List<Segment>) servletCtx.getAttribute("segments");

		return segments;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/segment", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Segment createSegment(@RequestBody Segment seg, HttpServletResponse response) {

		List<Segment> segments = (List<Segment>) servletCtx.getAttribute("segments");
		seg.setSegmentNumber(nextID++);
		segments.add(seg);

		response.setHeader("Location", "/segment/" + seg.getSegmentNumber());
		return seg;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/segment/{segmentNumber}", method = RequestMethod.PUT)
	public ResponseEntity<String> putSegment(@PathVariable("segmentNumber") long segNum, @RequestBody Segment seg) {

		Segment found = null;
		List<Segment> segments = (List<Segment>) servletCtx.getAttribute("segments");
		ResponseEntity<String> ret = new ResponseEntity<String>(HttpStatus.NO_CONTENT);

		for (Segment s : segments) {
			if (segNum == s.getSegmentNumber()) {
				found = s; // found matching Segment
			}
		}
		if (found == null) {
			throw new ResourceNotFoundException();
		}
		found.setFlightNumber(seg.getFlightNumber());
		found.setMiles(seg.getMiles());
		found.setOriginatingCity(seg.getOriginatingCity());
		found.setSegmentDate(seg.getSegmentDate());

		return ret;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/segment/{segmentNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSegment(@PathVariable("segmentNumber") long segNum) {

		Segment found = null;
		ResponseEntity<String> ret = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		List<Segment> segments = (List<Segment>) servletCtx.getAttribute("segments");

		for (Segment s : segments) {
			if (segNum == s.getSegmentNumber()) {
				found = s;
				;
			}
		}
		if (found == null) {
			throw new ResourceNotFoundException();
		}

		segments.remove(found);
		return ret;
	}

}
