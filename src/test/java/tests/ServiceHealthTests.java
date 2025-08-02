package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Evgeniya Malysheva")
@DisplayName("Эксплуатационные тесты")
public class ServiceHealthTests extends TestBase{
    @Test
    @DisplayName("TC_API_5: Проверка работоспособности (ping) сервиса")
    void healthCheckTest() {
        newBooking.pingService();
    }


}
