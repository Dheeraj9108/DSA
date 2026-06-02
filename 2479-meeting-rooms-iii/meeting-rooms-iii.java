class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        Map<Integer, Integer> meetingMap = new HashMap<>();
        PriorityQueue<long[]> activeMeetings = new PriorityQueue<>((a,b)-> {
            if(a[1] == b[1]) return Long.compare(a[0],b[0]);
            return Long.compare(a[1],b[1]);
        });

        Arrays.sort(meetings, (a,b)->a[0] - b[0]);

        int room_number = 0;
        int max_meetings = 0;

        for(int i = 0;i < n;i++) rooms.add(i);

        for(int meeting[] : meetings){
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;
            
            while(!activeMeetings.isEmpty() && activeMeetings.peek()[1] <= start) {
                long pair[] = activeMeetings.poll();
                rooms.add((int)pair[0]);
            }  

            int room = -1;          

            if(rooms.isEmpty()) {
                long possibleRoom[] = activeMeetings.poll();
                room = (int)possibleRoom[0];
                start = possibleRoom[1];
            } else {
                room = rooms.poll();
            }

            activeMeetings.add(new long[]{room,start+duration});

            meetingMap.put(room, meetingMap.getOrDefault(room,0)+1);

            if(meetingMap.get(room) >= max_meetings){
                if(meetingMap.get(room) == max_meetings){
                    room_number = Math.min(room_number, room);
                } else {
                    max_meetings = meetingMap.get(room);
                    room_number = room;
                }
            }
        }
        return room_number;
    }
}



// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         // 0 -> room Number 1 -> endtime
//         PriorityQueue<int[]> activeMeetings = new PriorityQueue<>((a,b)->{
//             if(a[1] == b[1]) return a[0] - b[0];
//             return a[1] - b[1];
//         });
//         PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
//         int meetingFre[] = new int[n];

//         Arrays.sort(meetings,(a,b)->a[0] - b[0]);
//         int maxMeetings = 0;
//         int maxRoom = 0;

//         for(int i = 0;i<n;i++) availableRooms.add(i);

//         for(int meeting[]:meetings){
//             int start = meeting[0];
//             int end = meeting[1];

//             //
//             while(!activeMeetings.isEmpty() && activeMeetings.peek()[1] <= start) {
//                 availableRooms.add(activeMeetings.peek()[0]);
//                 activeMeetings.poll();
//             }
            
//             int possibleRoom[] = null;
//             if(!activeMeetings.isEmpty()){
//                 possibleRoom = activeMeetings.peek();
//             }

//             int room = -1;
//             if(!availableRooms.isEmpty()){
//                 room = availableRooms.poll();
//                 activeMeetings.add(new int[]{room,end});
//             } else {
//                 activeMeetings.poll();
//                 int duration = end - start;
//                 room = possibleRoom[0]; 
//                 int prevEnd = possibleRoom[1];
//                 activeMeetings.add(new int[]{room,prevEnd+duration});
//             }
//             meetingFre[room]++;
//             if(meetingFre[room] >= maxMeetings){
//                 if(meetingFre[room] == maxMeetings){
//                     maxRoom = Math.min(maxRoom,room);
//                 } else {
//                     maxMeetings = meetingFre[room]; 
//                     maxRoom = room;
//                 }
//             }
//         }
//         return maxRoom;
//     }
// }