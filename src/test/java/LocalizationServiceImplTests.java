import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;


public class LocalizationServiceImplTests {

    @ParameterizedTest
    @ValueSource(strings = {"Добро пожаловать"})
    void testLocale(String expected) {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(RUSSIA);
        assertEquals(expected, result);
    }

        @ParameterizedTest
        @MethodSource("sourceAdd")
        void testLocaleFull(Country country, String expendedMessage){
            LocalizationService localizationService = new LocalizationServiceImpl();
            String result = localizationService.locale(country);
            assertEquals(expendedMessage, result);
        }

        public static Stream<Arguments> sourceAdd(){
        return Stream.of(Arguments.of(RUSSIA, "Добро пожаловать"),
        Arguments.of(USA, "Welcome"));
        }

}
