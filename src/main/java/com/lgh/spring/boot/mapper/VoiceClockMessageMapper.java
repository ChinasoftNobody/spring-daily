package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MVoiceClockMessage;
import org.apache.ibatis.annotations.Param;

public interface VoiceClockMessageMapper {

    void insert(@Param("message") MVoiceClockMessage voiceClockMessage);
}
