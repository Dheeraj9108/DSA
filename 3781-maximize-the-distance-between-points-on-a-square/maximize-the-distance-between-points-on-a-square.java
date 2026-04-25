class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long> arr = new ArrayList<>();

        // Map points to 1d plane
        for(int point[]: points){
            int x = point[0];
            int y = point[1];

            if(x == 0){
                arr.add((long)y);
            } else if (y == side){
                arr.add((long)side+x);
            } else if (x == side){
                arr.add(3*(long)side - y);
            } else {
                arr.add(4*(long)side - x);
            }
        }

        Collections.sort(arr);

        int l = 0;
        int h = side;
        int ans = 0;
        while(l<=h){
            int mid = (l+h)/2;
            if(check(arr,mid,side,k)){
                ans = mid;
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return ans;
    }

    private boolean check(List<Long> arr, int mid, int side, int k){
        long perimeter = 4L*side;
        for(long start: arr){
            long end = start + perimeter - mid;
            long cur = start;

            for(int i = 0;i<k-1;i++){
                long target = cur+mid;
                int idx = lowerBound(arr,target);
                if(idx == arr.size() || arr.get(idx) > end){
                    cur = -1;
                    break;
                }
                cur = arr.get(idx);
            }

            if(cur >= 0) return true;
        }
        return false;
    }

    private int lowerBound(List<Long> arr, long target){
        int l = 0;
        int h = arr.size()-1;

        while(l<=h){
            int mid = (l+h)/2;
            if(arr.get(mid) < target){
                l = mid+1;
            } else {
                h = mid-1;
            }
        }

        return l;
    }
}