//time O(nlogk) where n is the no of ele in array and k is the size of priority queue
//space O(n+k) n is the space of hashmap and k is the size of pq

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        class Pair {
            int num;
            int freq;
            public Pair(int num, int freq) {
                this.num = num;
                this.freq = freq;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Pair pr = new Pair(entry.getKey(), entry.getValue());
            pq.add(pr);
            if(pq.size() > k) {
                pq.poll();
            } 
        }
        for(int i = k - 1; i >=0; i--) {
            Pair prr = pq.poll();
            result[i] = prr.num;
        }
        return result;
    }
}
