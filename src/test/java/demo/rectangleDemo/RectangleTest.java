package demo.rectangleDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {
    @Test
    public void testConstructorOk(){
        Assertions.assertDoesNotThrow(()-> new Rectangle(4, 3));
    }
    @Test
    public void testConstructorBad1(){
        Assertions.assertThrows(NegativeLengthException.class, ()-> new Rectangle(-4,  3));
        Assertions.assertThrows(NegativeLengthException.class, ()-> new Rectangle(-4, -3));
        Assertions.assertThrows(NegativeLengthException.class, ()-> new Rectangle( 4, -3));
    }

    @Test
    public void testConstructorBad2(){
        Assertions.assertThrows(ZeroLengthException.class, ()-> new Rectangle( 0,  3));
        Assertions.assertThrows(ZeroLengthException.class, ()-> new Rectangle( 0,  0));
        Assertions.assertThrows(ZeroLengthException.class, ()-> new Rectangle( 4,  0));
    }

    @Test
    void testPerimeter1() throws Exception {
        Rectangle r = new Rectangle(4, 3);
        Assertions.assertEquals(14, r.perimeter());
    }

    @Test
    void testPerimeter2() throws Exception {
        Rectangle r = new Rectangle(100, 100);
        Assertions.assertEquals(400, r.perimeter());
    }

    @Test
    void testArea1() throws Exception {
        Rectangle r = new Rectangle(4, 3);
        Assertions.assertEquals(12, r.area());
    }
    @Test
    void testArea2() throws Exception {
        Rectangle r = new Rectangle(100, 100);
        Assertions.assertEquals(10000, r.area());
    }

    @Test
    void testEqualsYes() throws Exception {
        Rectangle r1 = new Rectangle(4, 3);
        Rectangle r2 = new Rectangle(4, 3);
        Rectangle r3 = new Rectangle(3, 4);
        Assertions.assertTrue(r1.equals(r2));
        Assertions.assertTrue(r2.equals(r1));
        Assertions.assertTrue(r1.equals(r3));
        Assertions.assertTrue(r3.equals(r2));

    }

    @Test
    void testEqualsNo() throws Exception {
        Rectangle r1 = new Rectangle(4, 3);
        Rectangle r2 = new Rectangle(4, 4);
        Assertions.assertFalse(r1.equals(r2));
    }

    @Test
    void testHashCode1() throws GeometryException {
        Rectangle r1 = new Rectangle(4, 3);
        Rectangle r2 = new Rectangle(4, 4);
        Assertions.assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testHashCode2() throws GeometryException {
        Rectangle r1 = new Rectangle(4, 3);
        Rectangle r2 = new Rectangle(4, 3);
        Rectangle r3 = new Rectangle(3, 4);
        Assertions.assertEquals(r1.hashCode(), r2.hashCode());
        Assertions.assertEquals(r2.hashCode(), r3.hashCode());
        Assertions.assertEquals(r1.hashCode(), r3.hashCode());
    }

//    @Test
//    void testHashCode3() throws GeometryException {
//        Rectangle r1 = new Rectangle(4, 3);
//        Rectangle r2 = new Rectangle(2, 5);
//        Assertions.assertNotEquals(r1.hashCode(), r2.hashCode());
//
//    }
}