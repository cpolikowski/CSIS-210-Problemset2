/**
 * Takes any object and counts the amount of duplicates in the array for the desired input 
 *
 * @author Cam Polikowski & Kade Garrison
 * @version 3/11/22
 */
public class GenericMethodExample
{
    /**
     * Returns the number of times itemToCount occurs in list.  
     * 
     * @return the number of times itemToCount occurs in the list.
     */

    /**
     * public static int countOccurrences(String[] list, String itemToCount) 
    {
    int count = 0;

    if (itemToCount == null) {
    for (String listItem : list ){
    if (listItem == null){
    count++;
    }
    }
    } else {
    for (String listItem : list ){
    if (itemToCount.equals(listItem)){
    count++;
    }
    }
    }
    return count;
    }
     */

    public static<T> int countOccurrences(T[] list, T itemToCount) 
    {
        int count = 0;

        if (itemToCount == null) {
            for (T listItem : list ){
                if (listItem == null){
                    count++;
                }
            }
        } else {
            for (T listItem : list ){
                if (itemToCount.equals(listItem)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        String[] list = new String[3];
        list[0] = "Kyle";
        list[1] = "Chad";
        list[2] = "Kyle";
        System.out.println(countOccurrences(list, "Kyle"));

    }
}