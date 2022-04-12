package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPoint2DTest {
    @Test
    void testCheckPointCoordinates()  {
        MyPoint2D point = new MyPoint2D(15, 12);
        assertAll(
                () -> assertEquals(15, point.getX()),
                () -> assertEquals(12, point.getY())
        );
    }

    @Test
    void testPointsEquality()  {
        MyPoint2D point1 = new MyPoint2D(15, 12);
        MyPoint2D point2 = new MyPoint2D(15, 12);
        assertEquals(point1, point2);
    }

    @Test
    void testPointsNonEqual() {
        MyPoint2D point1 = new MyPoint2D(15, 12);
        MyPoint2D point2 = new MyPoint2D(-15, 12);
        assertNotEquals(point1, point2);
    }
}