package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

    @Key("userName")
    String userName();

    @Key("mobileKey")
    String mobileKey();

    @Key("appURL")
    String appURL();
}


