package com.learn.spring.Chap4.cd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

	
	private CompactDisc cd;
	
	@Autowired
	public CDPlayer(CompactDisc cd) {
		super();
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
		cd.playTrack(10);
	}

}
