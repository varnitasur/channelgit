package com.mindtree.channelapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelapp.entity.ChannelGroup;

@Repository
public interface ChannelGroupRepository extends JpaRepository<ChannelGroup, Integer> {

	Optional<ChannelGroup> findBychannelGroupName(String channelGroupName);

}
