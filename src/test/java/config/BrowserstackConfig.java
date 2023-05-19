package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("username")
    String username();
    @Key("passwordKey")
    String passwordKey();
    @Key("remoteUrl")
    String remoteUrl();
    @Key("project")
    String project();
    @Key("build")
    String build();
    @Key("name")
    String name();
    @Key("app")
    String app();

}
