package com.learn.spring.Chap4.cd;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String musicName;

	public SgtPeppers() {
	}

	public SgtPeppers(String musicName) {
		super();
		this.musicName = musicName;
	}

	@Override
	public void play() {
		System.out.println("playing some music!"+musicName);
	}

	@Override
	public void playTrack(int trackNumber) {

	}

}
