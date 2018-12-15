package com.lgh.spring.boot.service.clock;

import com.lgh.spring.boot.model.MVoiceClockMessage;

public class VoiceClockCallable implements Runnable {

    private VoiceClockService voiceClockService;

    private MVoiceClockMessage voiceClockMessage;

    public VoiceClockCallable(VoiceClockService voiceClockService, MVoiceClockMessage voiceClockMessage) {
        this.voiceClockService = voiceClockService;
        this.voiceClockMessage = voiceClockMessage;
    }

    @Override
    public void run() {
        voiceClockService.voice(voiceClockMessage);
    }
}
