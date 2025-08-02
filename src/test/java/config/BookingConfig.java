package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})

public interface BookingConfig extends Config {
    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseURI")
    @DefaultValue("https://restful-booker.herokuapp.com")
    String getBaseURI();

}
