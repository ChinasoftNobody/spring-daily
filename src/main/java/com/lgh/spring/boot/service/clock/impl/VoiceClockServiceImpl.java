package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MVoiceClockMessage;
import com.lgh.spring.boot.service.clock.VoiceClockService;
import com.lgh.spring.boot.util.JLUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class VoiceClockServiceImpl implements VoiceClockService {
    private static ArrayBlockingQueue<MVoiceClockMessage> messageBlockingQueue = new ArrayBlockingQueue<MVoiceClockMessage>(10);

    @Override
    public void start() {
        try {
            new Thread(() -> {
                try {
                    while (true) {
                        MVoiceClockMessage mVoiceClockMessage = messageBlockingQueue.take();
                        JLUtil.play(mVoiceClockMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMessage(MVoiceClockMessage voiceClockMessage) {
        try {
            //if queue is full,will wait
            messageBlockingQueue.put(voiceClockMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
