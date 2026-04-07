class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // true → access order for LRU behavior
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);  // Moves the accessed key to most recently used
        }
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);  // Adds or updates key
        if (cache.size() > capacity) {
            // Remove the least recently used entry (eldest entry)
            int eldestKey = cache.entrySet().iterator().next().getKey();
            cache.remove(eldestKey);
        }
    }
}
