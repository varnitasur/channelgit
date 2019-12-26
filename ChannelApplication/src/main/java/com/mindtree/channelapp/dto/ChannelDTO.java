package com.mindtree.channelapp.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelDTO {

	
	private int channelId;
	private String channelName;
	private double price;
	
	@JsonIgnoreProperties("channels")
	private ChannelGroupDTO channelGroup;
	
	@JsonIgnoreProperties("channel")
	private Set<ChannelShowDTO> shows;

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ChannelGroupDTO getChannelGroup() {
		return channelGroup;
	}

	public void setChannelGroup(ChannelGroupDTO channelGroup) {
		this.channelGroup = channelGroup;
	}

	public Set<ChannelShowDTO> getShows() {
		return shows;
	}

	public void setShows(Set<ChannelShowDTO> shows) {
		this.shows = shows;
	}

	
	
	
}
