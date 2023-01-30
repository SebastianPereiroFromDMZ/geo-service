import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import static ru.netology.entity.Country.RUSSIA;


public class LocalizationServiceImplTests {

    @ParameterizedTest
    @ValueSource(strings = {"Добро пожаловать"})
    void testLocale(String expected){
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(RUSSIA);
        assertEquals(expected,result);
    }
}
