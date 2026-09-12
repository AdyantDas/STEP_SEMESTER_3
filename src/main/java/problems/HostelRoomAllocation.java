package problems;

public class HostelRoomAllocation {

    public static class HostelRoom {
        private String roomNo;
        private int beds;
        private int occupied;

        public HostelRoom(String roomNo, int beds, int occupied) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = occupied;
        }

        public String getRoomNo() {
            return roomNo;
        }

        public int getBeds() {
            return beds;
        }

        public int getOccupied() {
            return occupied;
        }

        public boolean allot(String name) {
            if (occupied < beds) {
                occupied++;
                return true;
            }
            return false;
        }
    }

    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        if (rooms == null) {
            return null;
        }
        for (HostelRoom room : rooms) {
            if (room != null && room.getOccupied() < room.getBeds()) {
                return room;
            }
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom available = findAvailableRoom(rooms);
        if (available != null) {
            available.allot(studentName);
            System.out.printf("%s allotted to room %s%n", studentName, available.getRoomNo());
        } else {
            System.out.printf("No rooms available for %s%n", studentName);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test 1 (Available room exists) ---");
        HostelRoom[] rooms1 = {
                new HostelRoom("C-214", 3, 2),
                new HostelRoom("C-507", 2, 2)
        };
        safeAllot(rooms1, "Divya");

        System.out.println("\n--- Test 2 (All rooms full) ---");
        HostelRoom[] rooms2 = {
                new HostelRoom("C-214", 3, 3),
                new HostelRoom("C-507", 2, 2)
        };
        safeAllot(rooms2, "Divya");
    }
}