package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/properties/authorization.properties")
public interface AuthorizationConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}
