package com.mindtree.channelapp.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelGroupDTO {
	
	private int channelGroupId;
	private String channelGroupName;
	@JsonIgnoreProperties("channelGroup")
	private Set<ChannelDTO> channels;
	public int getChannelGroupId() {
		return channelGroupId;
	}
	public void setChannelGroupId(int channelGroupId) {
		this.channelGroupId = channelGroupId;
	}
	public String getChannelGroupName() {
		return channelGroupName;
	}
	public void setChannelGroupName(String channelGroupName) {
		this.channelGroupName = channelGroupName;
	}
	public Set<ChannelDTO> getChannels() {
		return channels;
	}
	public void setChannels(Set<ChannelDTO> channels) {
		this.channels = channels;
	}
	
	

}
