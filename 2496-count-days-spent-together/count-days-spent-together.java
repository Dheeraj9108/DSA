class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int daysPerMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int pref[] = new int[13];

        for(int i = 1;i<=12;i++){
            pref[i] = pref[i-1] + daysPerMonth[i-1];
        }

        int aad = calculateDayOfYear(arriveAlice, pref); 
        int ald = calculateDayOfYear(leaveAlice, pref); 
        int bad = calculateDayOfYear(arriveBob, pref); 
        int bld = calculateDayOfYear(leaveBob, pref);

        return Math.max(0,Math.min(ald,bld) - Math.max(aad,bad) + 1);
    }

    private int calculateDayOfYear(String str, int pref[]){
        int m = Integer.parseInt(str.substring(0,2));
        int d = Integer.parseInt(str.substring(3));
        return pref[m-1] + d;
    }
}