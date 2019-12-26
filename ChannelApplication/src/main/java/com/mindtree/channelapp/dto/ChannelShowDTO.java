package com.mindtree.channelapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelShowDTO {
	private int showId;
	private String showName;
	@JsonIgnoreProperties("shows")
	private ChannelDTO channel;
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
	public ChannelDTO getChannel() {
		return channel;
	}
	public void setChannel(ChannelDTO channel) {
		this.channel = channel;
	}
	

}
