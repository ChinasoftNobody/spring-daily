package com.lgh.spring.boot.service.clock;

import com.lgh.spring.boot.model.MVoiceClockMessage;

public interface VoiceClockService {

    void start();

    void addMessage(MVoiceClockMessage voiceClockMessage);
}
