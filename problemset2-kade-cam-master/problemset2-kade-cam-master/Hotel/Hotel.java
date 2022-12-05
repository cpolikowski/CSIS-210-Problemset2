
import java.util.ArrayList;

/**
 * Write a description of class Hotel here.
 *
 * @author Cam Polikowski & Kade Garrison
 * @version (a version number or a date)
 */
public class Hotel
{
    // instance variables - replace the example below with your own
    private ArrayList<Room> availableRooms; 
    private ArrayList<Room> reservedRooms;

    /**
     * Construct a hotel with an empty list of available rooms and empty list of reserved rooms
     */
    public Hotel()
    {
        availableRooms = new ArrayList<Room>();
        reservedRooms = new ArrayList<Room>();
    }
    
    /**
     * Construct a hotel with an input list of available rooms and an input list of reserved rooms
     */
    public Hotel(ArrayList<Room> availableRooms, ArrayList<Room> reservedRooms) {
        this.availableRooms = availableRooms;
        this.reservedRooms = reservedRooms;
    }

    /** Adds a room to the list of available rooms if it has a room number not already listed in the hotel 
     * @param Room the room being added.
     * @return boolean 
     */
    public boolean addNewRoom(Room room){
        boolean ret = true;
        for (int i = 0; i < availableRooms.size(); i++){
            if (availableRooms.get(i).getRoomNumber() == room.getRoomNumber()){
                ret = false;
            }
        }

        for (int i = 0; i < reservedRooms.size(); i++) {
            if (reservedRooms.get(i).getRoomNumber() == room.getRoomNumber()){
                ret = false;
            }
        }

        if (ret == true) {
            availableRooms.add(room);
        }
        return ret;
    }


    /** Returns the list of available rooms
     * @return ArrayList<Room> 
     */
    public ArrayList<Room> getAllAvailableRooms(){
        return availableRooms;
    }

    /** Returns the list of reserved rooms
     * @return ArrayList<Room> 
     */
    public ArrayList<Room> getAllReservedRooms(){
        return reservedRooms;
    }

    /** Returns the room associated with the input room number, as long as it is available
     * @return Room 
     */
    public Room getAvailableRoomByRoomNumber(int roomNumber) {
        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i).getRoomNumber() == roomNumber) {
                return availableRooms.get(i);
            }
        }
        return null;
    }

    /** Returns a list of the available rooms mathcing the input criteria
     * @param int Floor of the room, View view of the room, int The max capcity the room can hold, boolean Whether there is a kitchen or not
     * @return ArrayList<Room> 
     */
    public ArrayList<Room> getAvailableRooms(int floor, View view, int maxCapcity, boolean kitchenette) {
        ArrayList<Room> ret = new ArrayList<Room>();
        for (int i = 0; i < availableRooms.size(); i++) {
            if ((availableRooms.get(i).getRoomNumber() / 100) >= floor){
                if (availableRooms.get(i).getView() == view){
                    if (availableRooms.get(i).getMaxCapacity() >= maxCapcity){
                        if (availableRooms.get(i).hasKitchenette() == kitchenette){
                            ret.add(availableRooms.get(i));
                        }
                    }
                }
            }
        }
        return ret;
    }

    /** Returns the room associated with the input room number, as long as it is reserved.
     * @param int roomNumber 
     * @return Room 
     */
    public Room getReservedRoomByRoomNumber(int roomNumber){
        for (int i = 0; i < reservedRooms.size(); i++) {
            if (reservedRooms.get(i).getRoomNumber() == roomNumber) {
                return reservedRooms.get(i);
            }
        }
        return null;
    }

    /** If the room with the input room number is reserved, makes the room available and returns true.
     * @param int the roomNumber desired
     * @return boolean 
     */
    public boolean makeRoomAvailable(int roomNumber){
        Room temp;
        boolean ret = false;
        for (int i = 0; i < reservedRooms.size(); i++){
            if (reservedRooms.get(i).getRoomNumber() == roomNumber){
                temp = reservedRooms.get(i);
                reservedRooms.remove(temp);
                availableRooms.add(temp);
                ret = true;
            }
        }
        return ret;
    }

    /** If the room with the input room number is available, reserves the room and returns true.
     * @param int Room number
     * @return boolean 
     */
    public boolean reserveRoom(int roomNumber){
        Room temp;
        boolean ret = false;
        for (int i = 0; i < availableRooms.size(); i++){
            if (availableRooms.get(i).getRoomNumber() == roomNumber){
                temp = availableRooms.get(i);
                availableRooms.remove(temp);
                reservedRooms.add(temp);
                ret = true;
                i = 999;
            }
        }
        return ret;
    }

    /** Returns a list of the available room descriptions followed by reserved descriptions.
     * @return String
     */
    
    public String toString() {
        String ret = "Available Rooms:\n";
        for (int i = 0; i < availableRooms.size(); i++) {
            ret = ret + availableRooms.get(i).toString() + "\n";
        }
        ret = ret + "\n";
        ret = ret + "Reserved Roomns:\n";
        for (int i = 0; i < reservedRooms.size(); i++) {
            ret = ret + reservedRooms.get(i).toString() + "\n";
        }
        return ret;
    }
}
