package com.lgh.spring.boot.util;

import com.lgh.spring.boot.model.MVoiceClockMessage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

public class JLUtil {

    private static final String SPEAK_PATH = "https://gss0.baidu.com/6KAZsjip0QIZ8tyhnq/text2audio";

    public static void play(MVoiceClockMessage message) throws Exception{
        String url = "?tex=" + URLEncoder.encode(message.getVolTex(),"utf-8")
                + "&cuid=" + message.getVolCuid()
                + "&lan=" + message.getVolLan()
                + "&ctp=" + message.getVolCtp()
                + "&pdt=" + message.getVolPdt()
                + "&vol=" + message.getVolVol()
                + "&spd=" + message.getVolSpd();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.execute(SPEAK_PATH + url, HttpMethod.GET, null, clientHttpResponse -> {
            Player player = null;
            try {
                player = new Player(clientHttpResponse.getBody());
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
            return clientHttpResponse.getBody();
        });

    }
}
