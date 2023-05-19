//package config;
//
//import org.aeonbits.owner.Config;
//
//@Config.LoadPolicy(Config.LoadType.MERGE)
//@Config.Sources({
//        "system:properties",
//        "classpath:config/browserstack.properties"
//})
//
//public interface BrowstackConfig extends Config {
//    @Key("userValue")
//    String userValue();
//    @Key("keyValue")
//    String keyValue();
//    @Key("project")
//    String project();
//    @Key("build")
//    String build();
//    @Key("name")
//    String name();
//    @Key("app")
//    String app();
//    @Key("device")
//    String device();
//    @Key("osVersion")
//    String osVersion();
//    @Key("baseUrl")
//    String baseUrl();
//}
