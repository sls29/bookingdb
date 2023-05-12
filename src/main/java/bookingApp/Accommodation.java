package bookingApp;

public class Accommodation {

    public int id;
    public String roomType;
    public String bedType;
    public int maxGuest;
    public String roomDescription;

   public Accommodation(int id, String roomType, String bedType,
                        int maxGuest, String roomDescription) {
       this.id = id;
       this.roomType = roomType;
       this.bedType = bedType;
       this.maxGuest = maxGuest;
       this.roomDescription = roomDescription;
   }

    public String toString(){
    return "Room type: " + roomType + "; Bed type: " + bedType +
            "; Maxim persons: " + maxGuest + ".";
    }
}
