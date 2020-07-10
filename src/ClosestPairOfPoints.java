import java.util.Arrays;
import java.util.Comparator;
class Point {
    Integer x, y;
    public Point() {
        this(0,0);
    }
    public Point(final Integer x, final Integer y) {
        this.x = x; this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
/**
 * Comparator: To sort as per the x-values
 */
class Xcomparator implements Comparator<Point> {
    @Override
    public int compare(final Point p1, final Point p2) {
        return p1.x.compareTo(p2.x);
    }
}
/**
 * Comparator: To sort as per the y-values
 */
class Ycomparator implements Comparator<Point> {
    @Override
    public int compare(final Point p1, final Point p2) {
        return p1.y.compareTo(p2.y);
    }
}
/**
 * Utility class to implement helper methods
 */
final class MyUtil {
    static double distance(final Point p1, final Point p2)
    {
        final int xDist = p1.x - p2.x;
        final int yDist = p1.y - p2.y;
        return Math.sqrt( (xDist * xDist) + (yDist * yDist) );
    }
}
/**
 * Main Utility class
 */
public final class ClosestPairOfPoints {
    /**
     * Do not call this method directly.
     * This uses brute force approach to calculate the minimum distance.
     * Ideally used for array with very few elements.
     */
    private static double getMinDistanceInSmallArray(final Point pArray[], final int stripSize) {
//Pass Double.max as current min;
        return getMinDistanceBruteForce(pArray, stripSize, Double.MAX_VALUE);
    }
    /**
     * Do not call this method directly.
     * This uses brute force approach to calculate the minimum distance.
     * Strip would contain very few elements (<8)
     */
    private static double getMinDistanceInStrip(final Point[] strip, final int stripSize, final double currentMin) {
        /* Sort the points by y-coordinates */
        Arrays.sort(strip, 0, stripSize-1, new Ycomparator());
        return getMinDistanceBruteForce(strip, stripSize, currentMin);
    }
    /**
     * Do not call this method directly.
     * This is the basic brute force approach (O(n^2)).
     * We shall be using this only in cases of small inputs (size < 8).
     * Hence, in our usage, (O(1))
     */
    private static double getMinDistanceBruteForce(final Point pArray[], final int stripSize, final double currentMin) {
        double min = currentMin;
        for (int i = 0; i < stripSize; i++) {
            for (int j = i+1; j < stripSize; j++) {
                final double distance = MyUtil.distance(pArray[i], pArray[j]);
                if (distance < min) {
                    min = distance;
                }
            }
        }
        return min;
    }
    /**
     * Do not call this method directly.
     * This implements the divide and conquer part.
     */
    private static double getMinDistance(final Point[] pArray, final int start, final int end) {
        final int size = end - start + 1;
        /* Call brute force method for the array of size 3 or less */
        if (size <= 3) {
            return getMinDistanceInSmallArray(pArray, size);
        }
        /* Calculate mid index and store the mid point object */
        final int mid = size/2;
        final Point midPoint = pArray[mid];
        /* Divide the array into two parts and recurse on each sub-array.*/
        final double dL = getMinDistance(pArray, start, mid-1);//start to mid-1 index
        final double dR = getMinDistance(pArray, mid, end);//mid to end index
        final double d = Double.min(dL, dR); //minimum distance between both parts
//Make a placeholder for all the (size) elements for the strip, initially
        final Point[] strip = new Point[size];
        int stripIndex = 0; // points to the first empty cell in the array
        for (int i = 0; i < size; i++) {
            /* x.distance of point from midPoint*/
            int xDistance = pArray[i].x = midPoint.x;
            if (xDistance < 0) {
                /*we need absolute value, as distance can never be negative*/
                xDistance = -xDistance;
            }
            if (xDistance < d) {
                /* found a point which is closer than d from the midPoint, as per x-coordinate only*/
                strip[stripIndex] = pArray[i];//include the point in the strip
                stripIndex++;//points to the next cell in the array
            }
        }
        if (stripIndex == 0) { /*If no elements in the strip */
            return d;
        }
        /* stripIndex is size of the strip, as we have already done ++
         * d: pass d as the current known min distance which would be used for comparison
         * */
        return getMinDistanceInStrip(strip, stripIndex, d);
    }
    /**
     * Only public method which would be called from outside.
     */
    public static double getMinDistance(final Point[] pArray) {
        /* Sort the points only once in the beginning by X-coordinates */
        Arrays.sort(pArray, new Xcomparator());

        final int size = pArray.length;
        /* Call the recursive method which contains the divide and conquer approach*/
        return getMinDistance(pArray, 0, size-1);
    }
    /**
     * main function tests the code with sample input
     */
    public static void main(final String[] args) {
        final Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };
        System.out.println("Points are : " + Arrays.toString(points));
        System.out.println("Min distance: " + ClosestPairOfPoints.getMinDistance(points));
    }
}