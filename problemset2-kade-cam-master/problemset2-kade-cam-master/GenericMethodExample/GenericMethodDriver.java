import java.awt.Point;

/**
 * Write a description of class GenericMethodDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GenericMethodDriver
{
    public static void main(String[] args){
        GenericMethodExample gme = new GenericMethodExample();
        
        System.out.println("Testing String list. Expected: 2");
        String[] sList = new String[3];
        sList[0] = "Kyle";
        sList[1] = "Chad";
        sList[2] = "Kyle";
        String wanted = "Kyle";
        System.out.println("Result (String): " + gme.countOccurrences(sList, wanted));

        System.out.println("Testing Integer list. Expected: 2");
        Integer[] iList = new Integer[3];
        iList[0] = 3;
        iList[1] = 4;
        iList[2] = 3;
        System.out.println("Result (Integer): " + gme.countOccurrences(iList, 3));

        System.out.println("Testing Point list. Expected: 2");
        Point[] pList = new Point[3];
        pList[0] = new Point(3,3);
        pList[1] = new Point(2,2);
        pList[2] = new Point(3,3);

        Point p = new Point(3,3);
        System.out.println("Result (Point): " + gme.countOccurrences(pList, p));

        

         

    }
}
