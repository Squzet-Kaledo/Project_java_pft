import org.testng.Assert;
import org.testng.annotations.Test;

public class Point {

    int a;
    int b;


    public Point(int a1, int b1) {
        a = a1;
        b = b1;
    }
    @Test
    public static double distance(Point p1, Point p2) {

        double K = Math.sqrt((p1.b - p1.a) * (p1.b - p1.a)) + ((p2.b - p2.a) * (p1.b - p1.a));
        System.out.println(K);
        return K;

    }
}
class Mega{

    public static void main(String[] args) {

        Point p1 = new Point(6,9);
        Point p2 = new Point(7,10);
        Point.distance(p1, p2);
        Assert.assertEquals(Point.distance(p1,p2),18.0);
    }
    

}