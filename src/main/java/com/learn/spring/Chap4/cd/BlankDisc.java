package com.learn.spring.Chap4.cd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BlankDisc implements CompactDisc {

	Logger logger = LoggerFactory.getLogger(BlankDisc.class);

	private String title;
	private String artist;
	private List<String> tracks;
	
	
	public BlankDisc(String title, String artist, List<String> tracks) {
		super();
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}
	public BlankDisc(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	@Override
	public void play() {
		System.out.println("Playing "+title+" by "+artist);
		for(String track:tracks){
			System.out.println("-Track: "+track);
		}

	}

	@Override
	public void playTrack(int trackNumber){
		logger.info("play tracker number is "+trackNumber);
	}
	public String test() {
		return "eltest!";
	}

}
