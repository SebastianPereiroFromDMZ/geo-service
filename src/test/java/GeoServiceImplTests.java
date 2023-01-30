import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTests {


    @ParameterizedTest
    @MethodSource("sourceAdd")
    void testLocationByIp(Location expended, String ip) {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);
        assertEquals(expended, location);
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(Arguments.of(new Location(null, null, null, 0), "127.0.0.1"),
                Arguments.of(new Location("Moscow", Country.RUSSIA, "Lenina", 15), "172.0.32.11"),
                Arguments.of(new Location("New York", Country.USA, " 10th Avenue", 32), "96.44.183.149"),
                Arguments.of(new Location("Moscow", Country.RUSSIA, null, 0), "172."),
                Arguments.of(new Location("New York", Country.USA, null, 0), "96."));
    }





}
