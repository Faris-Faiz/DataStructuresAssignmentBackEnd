package Q25;

public class MyHashMap<K, V> {

    private class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        /**
         * Constructor for Entry in the hash table
         *
         * @param key   the key element
         * @param value the value element paired to the key
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * To retrieve the key associated with the value
         *
         * @return the key of the value
         */
        public K getKey() {
            return key;
        }

        /**
         * To retrieve the value associated with the key
         *
         * @return the value of the key
         */
        public V getValue() {
            return value;
        }

        /**
         * Because values are meant to be changeable, keys aren't
         *
         * @param value the value you want to override
         */
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Entry<K, V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    private final int SIZE = 5;

    private final Entry<K, V>[] table;

    public MyHashMap() {
        this.table = new Entry[SIZE];
    }

    /**
     * To insert an element into the hashmap
     *
     * @param key   the key element you want to insert into the hashmap
     * @param value the value element you want to insert into the hashmap
     */
    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE; // the idea is that we want to insert the linked list in either
        // 5 of the slots in the table based on hashCode.

        Entry<K, V> e = table[hash];

        if (e == null) { // if the table contains no entries
            table[hash] = new Entry<K, V>(key, value);
        } else { // if it has entires
            while (e.next != null) { // traverse to find an empty slot
                if (e.getKey() == key) { // if the key clashes, then update the value
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }

            // because the above while loop stops right before the end of the list in the table
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }

            e.next = new Entry<K, V>(key, value); // create a new node at the end of the list in the table
        }
    }

    /**
     * Retrieves the value associated with the key
     *
     * @param key the desired key to have their value returned to
     * @return the value associated with the key
     */
    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        // if the list of that specific index in table is empty
        if (e == null) {
            return null;
        }

        while (e != null) {
            // if found the key that matches with the parsed key
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }

        // doesn't contain the key you want
        return null;
    }

    /**
     * To remove the element in the hashmap
     *
     * @param key the specific element you want to remove
     * @return the Key-Value pair you removed from the hashmap
     */
    public Entry<K, V> remove(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        if (e == null) {
            return null;
        }

        // for case if the first slot in the table is the
        if (e.getKey() == key) {
            table[hash] = e.next;
            e.next = null;
            return e;
        }

        // to keep track of the previous element
        Entry<K, V> prev = e;

        // to move to the next element
        e = e.next;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return e;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }
        return sb.toString();
    }
}
