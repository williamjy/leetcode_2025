class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public void SetPrev(ListNode prev) {
        this.prev = prev;
    }
    public void SetNext(ListNode next) {
        this.next = next;
    }
}

class LRUCache {
    int capacity;
    int size;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.cacheMap = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        int debugCapacity = this.capacity;
        int debugSize = this.size;
        ListNode debugHead = this.head;
        ListNode debugTail = this.tail;
        Map<Integer, ListNode> debugCacheMap = this.cacheMap;
        if (cacheMap.containsKey(key)) {
            ListNode curr = cacheMap.get(key);
            if (curr != tail) {
                if (size == 2) {
                    if (curr == head) {
                        curr.prev = tail;
                        tail.next = head;
                        head = tail;
                        tail = curr;
                        head.prev = null;
                        tail.next = null;
                    }
                } else if (size > 2) {
                    if (curr == head) {
                        head = head.next;
                        curr.prev = null;
                        curr.next = null;
                        head.prev = null;
                        tail.next = curr;
                        curr.prev = tail;
                        tail = curr;
                    } else {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                        tail.next = curr;
                        curr.prev = tail;
                        curr.next = null;
                        tail = curr;
                    }
                }
            }
            return curr.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        int debugCapacity = this.capacity;
        int debugSize = this.size;
        ListNode debugHead = this.head;
        ListNode debugTail = this.tail;
        Map<Integer, ListNode> debugCacheMap = this.cacheMap;
        if (cacheMap.containsKey(key)) {
            get(key);
            tail.value = value;
        } else {
            ListNode curr = new ListNode(key, value);
            cacheMap.put(key, curr);
            if (size == capacity) {
                Integer headKey = head.key;
                cacheMap.remove(headKey);
                if (size == 1) {
                    head = curr;
                    tail = curr;
                } else {
                    head = head.next;
                    head.prev.next = null;
                    head.prev = null;
                    tail.next = curr;
                    curr.prev = tail;
                    tail = curr;
                }
            } else {
                if (size == 0) {
                    head = curr;
                    tail = curr;
                } else {
                    tail.next = curr;
                    curr.prev = tail;
                    tail = curr;
                }
                size++;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */