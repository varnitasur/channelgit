package com.mindtree.channelapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.channelapp.dto.ChannelDTO;
import com.mindtree.channelapp.dto.ChannelGroupDTO;
import com.mindtree.channelapp.dto.ChannelShowDTO;
import com.mindtree.channelapp.exception.serviceexception.ShowManagementServiceException;

@Service
public interface ShowManagementService {

	String insertChannelGroupToDb(ChannelGroupDTO channelGroupDto);

	String insertChannelToDb(ChannelDTO channelDto, String channelGroupName) throws ShowManagementServiceException;

	String insertShowToDb(ChannelShowDTO channelShowDto, String channelName) throws ShowManagementServiceException;

	List<ChannelDTO> getChannelsBasedOnGroupId(int channelGroupId) throws ShowManagementServiceException;

}
