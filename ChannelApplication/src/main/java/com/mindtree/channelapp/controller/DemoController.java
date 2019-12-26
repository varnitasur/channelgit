package com.mindtree.channelapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.channelapp.dto.ChannelDTO;
import com.mindtree.channelapp.dto.ChannelGroupDTO;
import com.mindtree.channelapp.dto.ChannelShowDTO;
import com.mindtree.channelapp.exception.serviceexception.ShowManagementServiceException;
import com.mindtree.channelapp.service.ShowManagementService;

@RestController
public class DemoController {
	
	@Autowired
	ShowManagementService service;
	
	@PostMapping("/insertChannelGroup")
	public String insertChannelGroup(@RequestBody ChannelGroupDTO channelGroupDto) {
	
		String response=service.insertChannelGroupToDb(channelGroupDto);
		return response;
		
	}
	@PostMapping("/insertChannel/{channelGroupName}")
	public String insertChannel(@RequestBody ChannelDTO channelDto,@PathVariable String channelGroupName) throws ShowManagementServiceException {
		
		String response=service.insertChannelToDb(channelDto,channelGroupName);
		return response;
		
	}
	@PostMapping("/insertShow/{channelName}")
	public String insertShow(@RequestBody ChannelShowDTO channelShowDto,@PathVariable String channelName) throws ShowManagementServiceException {
	
		String response=service.insertShowToDb(channelShowDto,channelName);
		return response;
	}
@GetMapping("/channels/{channelGroupId}")
	public List<ChannelDTO> getchannelsBasedOnGroupId(@PathVariable int channelGroupId) throws ShowManagementServiceException{
	List<ChannelDTO> channels= new ArrayList<ChannelDTO>();
	channels= service.getChannelsBasedOnGroupId(channelGroupId);
		
		return channels;
		
	}
}
