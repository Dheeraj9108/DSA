class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int ast : asteroids){
            if(ast > m) return false;
            m+=ast;
        }
        return true;
    }
}