package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface LocalConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @DefaultValue("12.0")
    @Key("osVersion")
    String osVersion();

    @DefaultValue("http://0.0.0.0:4723/wd/hub")
    @Key("url")
    String url();

    @DefaultValue("android")
    @Key("platformName")
    String platformName();
}
