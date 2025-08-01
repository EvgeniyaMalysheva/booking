package config;

import org.aeonbits.owner.ConfigFactory;

    public enum ConfigReader {
        Instance;

        protected static final BookingConfig bookingConfig =
                ConfigFactory.create(
                        BookingConfig.class,
                        System.getProperties()
                );

        public BookingConfig read() {
            return bookingConfig;
        }
}
