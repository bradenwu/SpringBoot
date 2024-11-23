package cn.edu.ncut.cs.springboot.kaptcha.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "kaptcha")
public class KaptchaProperties {
    private int imageWidth=100;
    private int imageHeigth=40;
    private int textproducerFontSize=32;
    private String textproducerFontColor="0,0,0";
    private String textproducerCharString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYAZ";
    private int textproducerCharLength=4;
    private String noiseImpl="com.google.code.kaptcha.impl.NoNoise";
}

