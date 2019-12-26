package com.mindtree.channelapp.service.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.channelapp.dto.ChannelDTO;
import com.mindtree.channelapp.dto.ChannelGroupDTO;
import com.mindtree.channelapp.dto.ChannelShowDTO;
import com.mindtree.channelapp.entity.Channel;
import com.mindtree.channelapp.entity.ChannelGroup;
import com.mindtree.channelapp.entity.ChannelShow;
import com.mindtree.channelapp.exception.errorconstant.ErrorConstant;
import com.mindtree.channelapp.exception.serviceexception.NoSuchChannelException;
import com.mindtree.channelapp.exception.serviceexception.NoSuchChannelGroupFound;
import com.mindtree.channelapp.exception.serviceexception.ShowManagementServiceException;
import com.mindtree.channelapp.repository.ChannelGroupRepository;
import com.mindtree.channelapp.repository.ChannelRepository;
import com.mindtree.channelapp.repository.ChannelShowRepository;
import com.mindtree.channelapp.service.ShowManagementService;

@Service
public class ShowMangementServiceImpl implements ShowManagementService {

	@Autowired
	ChannelRepository channelRepose;
	@Autowired
	ChannelGroupRepository channelGroupRepose;
	@Autowired
	ChannelShowRepository channelShowRepose;

	ModelMapper modelMapper = new ModelMapper();

	private Channel convertDTOToEntity(ChannelDTO channelDTO) {
		return modelMapper.map(channelDTO, Channel.class);
	}

	private ChannelGroup convertDTOToEntity(ChannelGroupDTO channelGroupDto) {
		return modelMapper.map(channelGroupDto, ChannelGroup.class);
	}

	private ChannelShow convertDTOToEntity(ChannelShowDTO channelShowDto) {
		return modelMapper.map(channelShowDto, ChannelShow.class);
	}

	private ChannelDTO convertEntityToDTO(Channel channel) {
		return modelMapper.map(channel, ChannelDTO.class);
	}

	private ChannelGroupDTO convertEntityToDTO(ChannelGroup channelGroup) {
		return modelMapper.map(channelGroup, ChannelGroupDTO.class);
	}

	private ChannelShowDTO convertEntityToDTO(ChannelShow channelShow) {
		return modelMapper.map(channelShow, ChannelShowDTO.class);
	}

	@Override
	public String insertChannelGroupToDb(ChannelGroupDTO channelGroupDto) {
		ChannelGroup channelGroup = convertDTOToEntity(channelGroupDto);
		channelGroupRepose.save(channelGroup);
		return "Added group successfully";
	}

	@Override
	public String insertChannelToDb(ChannelDTO channelDto, String channelGroupName) throws ShowManagementServiceException {
		Optional<ChannelGroup> channelGroup = channelGroupRepose.findBychannelGroupName(channelGroupName);
		try {
			channelGroup.orElseThrow(()->new NoSuchChannelGroupFound(ErrorConstant.NoSuchChannelGroupFound));
		} catch (NoSuchChannelGroupFound e) {
			// TODO Auto-generated catch block
			throw new ShowManagementServiceException(e.getMessage(),e);
		}
		Channel channel = convertDTOToEntity(channelDto);
		channel.setChannelGroup(channelGroup.get());
		channelRepose.save(channel);
		return "channel Added successfully";
	}

	@Override
	public String insertShowToDb(ChannelShowDTO channelShowDto, String channelName) throws ShowManagementServiceException {
		Optional<Channel> channel = channelRepose.findBychannelName(channelName);
		try {
			channel.orElseThrow(()->new NoSuchChannelException(ErrorConstant.NoSuchChannelFound));
		} catch (NoSuchChannelException e) {
			// TODO Auto-generated catch block
			throw new ShowManagementServiceException(e.getMessage(),e);
			
		}
		ChannelShow show = convertDTOToEntity(channelShowDto);
		show.setChannel(channel.get());
		channelShowRepose.save(show);
		return "Show Added sucessfully";
	}

	@Override
	public List<ChannelDTO> getChannelsBasedOnGroupId(int channelGroupId) throws ShowManagementServiceException {
	        // TODO Auto-generated method stub
	        Optional<ChannelGroup> channelgroup = channelGroupRepose.findById(channelGroupId);
	        try {
	        	channelgroup.orElseThrow(()-> new NoSuchChannelGroupFound(ErrorConstant.NoSuchChannelGroupFound));
	        } catch (NoSuchChannelGroupFound e) {
	            throw new ShowManagementServiceException(e.getMessage(),e);
	        }
	        ChannelGroup group = channelgroup.get();
	        List<Channel> channels = group.getChannels().stream().collect(Collectors.toList());
	        Collections.sort(channels);
	        List<ChannelDTO> channelsdto = channels.parallelStream().map(i->convertEntityToDTO(i)).collect(Collectors.toList());
	        return channelsdto;
	}
	

}
