package cn.edu.ncut.cs.springboot.kaptcha.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

@AutoConfiguration
@ConditionalOnClass(KaptchaServlet.class)
@EnableConfigurationProperties(KaptchaProperties.class) //导入属性文件接收类
public class KaptchaAutoConfiguration {
    @Autowired
    private KaptchaProperties kaptchaProperties;
    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", kaptchaProperties.getImageWidth() + "");
        properties.setProperty("kaptcha.image.height", kaptchaProperties.getImageHeigth() + "");

        properties.setProperty("kaptcha.textproducer.font.size", kaptchaProperties.getTextproducerFontSize() + "");
        properties.setProperty("kaptcha.textproducer.font.color", kaptchaProperties.getTextproducerFontColor());
        properties.setProperty("kaptcha.textproducer.char.string", kaptchaProperties.getTextproducerCharString());
        properties.setProperty("kaptcha.textproducer.char.length", kaptchaProperties.getTextproducerCharLength() + "");
        properties.setProperty("kaptcha.noise.impl", kaptchaProperties.getNoiseImpl());
        DefaultKaptcha kaptchaProducer = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptchaProducer.setConfig(config);
        return kaptchaProducer;
    }
}
