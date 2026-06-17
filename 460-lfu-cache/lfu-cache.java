class LFUCache {

    Map<Integer, Pair<Integer, Integer>> cache = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freMap = new HashMap<>();
    int cap = 0;
    int minf = 0;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    private void insert(int key, int val, int fre){
        cache.put(key, new Pair<Integer, Integer>(fre, val));
        freMap.computeIfAbsent(fre, k->new LinkedHashSet<>()).add(key);
    }
    
    public int get(int key) {
        
        Pair<Integer, Integer> freVal = cache.get(key);

        if(freVal == null) return -1;

        int fre = freVal.getKey();
        Set<Integer> keySet = freMap.get(fre);

        keySet.remove(key);

        if(keySet.isEmpty()){
            freMap.remove(fre);

            if(minf == fre) minf++;
        }

        insert(key, freVal.getValue(), fre+1);
        return freVal.getValue();
    }
    
    public void put(int key, int value) {

        if(cap <= 0) return;
        
        Pair<Integer, Integer> freVal = cache.get(key);

        if(freVal != null){
            cache.put(key, new Pair<Integer, Integer>(freVal.getKey(), value));
            get(key);
            return;
        }

        if(cap == cache.size()){
            Set<Integer> keySet = freMap.get(minf);
            int keyToDel = keySet.iterator().next();
            cache.remove(keyToDel);
            keySet.remove(keyToDel);

            if(keySet.isEmpty()) freMap.remove(minf);
        }

        minf = 1;
        insert(key,value,1);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */