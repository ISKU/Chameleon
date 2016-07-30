package main.chameleon;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoTest {

    @Test
    public void testInfo() {
        Info info = new Info();
        Info testinfo = new Info(1, "a", 1 , 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1);

        assertEquals(4, 2 + 2);
        assertEquals(100, info.testInt());

        info.setId(1);
        assertEquals(1, info.getId());

        info.setName("a");
        assertEquals("a", info.getName());

        info.setWeek(1);
        assertEquals(1, info.getWeek());

        info.setStarttime(1);
        assertEquals(1, info.getStarttime());

        info.setStoptime(1);
        assertEquals(1, info.getStoptime());

        info.setSound(1);
        assertEquals(1, info.getSound());

        info.setWifi(1);
        assertEquals(1, info.getWifi());

        info.setBrightness(1);
        assertEquals(1, info.getBrightness());

        info.setLte(1);
        assertEquals(1, info.getLte());

        info.setBluetooth(1);
        assertEquals(1, info.getBluetooth());

        info.setAirplane(1);
        assertEquals(1, info.getAirplane());

        info.setLatitude(1.0);
        assertEquals(1.0, info.getLatitude(), 0.00001);

        info.setLongitude(1.0);
        assertEquals(1.0, info.getLongitude(), 0.00001);

        info.setToggle(1);
        assertEquals(1, info.getToggle());

        assertEquals("a", info.toString());
    }
}
