package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MVoiceClockMessage;
import com.lgh.spring.boot.service.clock.Sound;
import com.lgh.spring.boot.service.clock.VoiceClockService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class VoiceClockServiceImpl extends Application implements VoiceClockService {
    private static ArrayBlockingQueue<MVoiceClockMessage> messageBlockingQueue = new ArrayBlockingQueue<MVoiceClockMessage>(10);
    private static final String SPEAK_PATH = "https://gss0.baidu.com/6KAZsjip0QIZ8tyhnq/text2audio";

    @Override
    public void start() {
        try {
            new Thread(() -> {
                try {
                    launch(VoiceClockServiceImpl.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //if queue is empty, this will wait
        new Thread(() -> {
            try {
                while (true) {
                    MVoiceClockMessage mVoiceClockMessage = messageBlockingQueue.take();
                    String url = "?tex=" + URLEncoder.encode(mVoiceClockMessage.getVolTex(),"utf-8")
                            + "&cuid=" + mVoiceClockMessage.getVolCuid()
                            + "&lan=" + mVoiceClockMessage.getVolLan()
                            + "&ctp=" + mVoiceClockMessage.getVolCtp()
                            + "&pdt=" + mVoiceClockMessage.getVolPdt()
                            + "&vol=" + mVoiceClockMessage.getVolVol()
                            + "&spd=" + mVoiceClockMessage.getVolSpd();
                    Sound sound = new Sound(SPEAK_PATH + url, false);
                    sound.play();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(2);
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
