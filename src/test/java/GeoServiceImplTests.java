import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTests {

    @ParameterizedTest
    @ValueSource(strings = {"172.123.12.19", "172."})
    void testLocationByIp(String ip) {
        Location expended = new Location("Moscow", Country.RUSSIA, null, 0);
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);
        assertEquals(expended, location);
    }

    public static Location location_1() {
        return new Location(null, null, null, 0);
    }

    public static Location location_2() {
        return new Location("Moscow", Country.RUSSIA, "Lenina", 15);
    }

    public Location location_3() {
        return new Location("New York", Country.USA, " 10th Avenue", 32);
    }

    public Location location_4() {
        return new Location("Moscow", Country.RUSSIA, null, 0);
    }

    public static Object[] location_5() {
        return new Location[]{new Location("New York", Country.USA, null, 0)};
    }

    public Location location_6() {
        return null;
    }


    @ParameterizedTest
    @MethodSource("location_5")
    void testLocationByIp_2(Location expected) {
        String ip = "96.";
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);
        //assertEquals(expected, location);



    }

}
