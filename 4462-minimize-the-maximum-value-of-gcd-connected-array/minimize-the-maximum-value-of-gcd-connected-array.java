class Solution {
    private int smallestPrimeFactor(int num){
        if(num % 2 == 0) return 2;

        for(int i = 3; i*i <= num; i+=2){
            if(num % i == 0) return i;
        }
        return num;
    }
    public long minimumMaxValue(int n, int index, int value) {
        if(n == 1) return value;

        if(value == 1) return -1;

        int p = smallestPrimeFactor(value);

        if(2 * index > value - p) return -1;

        if(index == n-1) return value;

        long remaining = n - index - 2;

        return (long) value + p + 2L * remaining;
    }
}