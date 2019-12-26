package com.mindtree.channelapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ChannelGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelGroupId;
	private String channelGroupName;
	@OneToMany(mappedBy = "channelGroup",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Set<Channel> channels;
	public ChannelGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChannelGroup(int channelGroupId, String channelGroupName, Set<Channel> channels) {
		super();
		this.channelGroupId = channelGroupId;
		this.channelGroupName = channelGroupName;
		this.channels = channels;
	}
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
	public Set<Channel> getChannels() {
		return channels;
	}
	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
	@Override
	public String toString() {
		return "ChannelGroup [channelGroupId=" + channelGroupId + ", channelGroupName=" + channelGroupName
				+ ", channels=" + channels + "]";
	}

	
}
