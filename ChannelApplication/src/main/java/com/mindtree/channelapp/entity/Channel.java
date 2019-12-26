package com.mindtree.channelapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Channel implements Comparable<Channel>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelId;
	private String channelName;
	private double price;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ChannelGroup channelGroup;
	
	@OneToMany(mappedBy = "channel")
	private Set<ChannelShow> shows;

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Channel(int channelId, String channelName, double price, ChannelGroup channelGroup, Set<ChannelShow> shows) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
		this.channelGroup = channelGroup;
		this.shows = shows;
	}

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

	public ChannelGroup getChannelGroup() {
		return channelGroup;
	}

	public void setChannelGroup(ChannelGroup channelGroup) {
		this.channelGroup = channelGroup;
	}

	public Set<ChannelShow> getShows() {
		return shows;
	}

	public void setShows(Set<ChannelShow> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", price=" + price
				+ ", channelGroup=" + channelGroup + ", shows=" + shows + "]";
	}

	@Override
	public int compareTo(Channel channel) {
		int result= 0;
		if(this.price<channel.price)
			result=-1;
		else if (this.price==channel.price)
			result=0;
		else
			result=1;
		if(result==0) {
			if(this.channelName.compareTo(channel.channelName)<0)
				result=-1;
			else if(this.channelName.compareTo(channel.channelName)>0)
				result=1;
			else
				result=0;
		}
		return result;
	}
	
	

}
