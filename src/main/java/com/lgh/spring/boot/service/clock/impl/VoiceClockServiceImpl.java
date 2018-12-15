package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MVoiceClockMessage;
import com.lgh.spring.boot.service.clock.Sound;
import com.lgh.spring.boot.service.clock.VoiceClockService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class VoiceClockServiceImpl extends Application implements VoiceClockService {
    private static ArrayBlockingQueue<MVoiceClockMessage> messageBlockingQueue = new ArrayBlockingQueue<MVoiceClockMessage>(10);

    @Override
    public void voice(MVoiceClockMessage voiceClockMessage) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //if queue is empty, this will wait
        MVoiceClockMessage mVoiceClockMessage = messageBlockingQueue.take();
        //TODO handle url to file
        Sound sound = new Sound("file:/home/maysham/code/spring-daily/src/main/resources/static/text2audio.mp3", false);
        sound.play();
        //delete the temp file
    }
}
