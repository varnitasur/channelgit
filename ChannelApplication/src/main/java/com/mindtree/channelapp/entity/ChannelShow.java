package com.mindtree.channelapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChannelShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	private String showName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Channel channel;
	public ChannelShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ChannelShow(int showId, String showName, Channel channel) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channel = channel;
	}
	
	


	public int getShowId() {
		return showId;
	}


	public void setShowId(int showId) {
		this.showId = showId;
	}


	public String getShowName() {
		return showName;
	}


	public void setShowName(String showName) {
		this.showName = showName;
	}


	public Channel getChannel() {
		return channel;
	}


	public void setChannel(Channel channel) {
		this.channel = channel;
	}


	@Override
	public String toString() {
		return "ChannelShow [showId=" + showId + ", showName=" + showName + ", channel=" + channel + "]";
	}
	
	

}
