// method1: try two directions
class Solution{
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // go clockwise
        int n = distance.length;
        int dist1 = 0;
        int cur = start;
        while (cur != destination){
            int next = (cur+1)%n;
            dist1 += getdist(distance, cur, next);
            cur = next;
        }
        cur = start;
        int dist2 = 0;
        while (cur != destination){
            int next = (cur+n-1)%n;
            dist2 += getdist(distance, cur, next);
            cur = next;
        }
        return Math.min(dist1, dist2);
    }

    private int getdist(int[] distance, int s, int e){
        if (e != (s+1)%distance.length)
            return getdist(distance, e, s);
        return distance[s];
    }
}

// method2: if we use dijkstra (just to review this algorithm)
// class Solution {
//     class Item{
//         int node;
//         int dist;
//         Item(int _node, int _dist){
//             node = _node;
//             dist = _dist;
//         }
//     }
//     public int distanceBetweenBusStops(int[] distance, int start, int destination) {
//         int n = distance.length;
//         int[] cost = new int[n];
//         Arrays.fill(cost, Integer.MAX_VALUE);
//         cost[start] = 0;
//         PriorityQueue<Item> q = new PriorityQueue<Item>((v1, v2) -> v1.dist - v2.dist);
//         q.offer(new Item(start, 0));
//         while (!q.isEmpty()){
//             Item it = q.poll();
//             if (cost[it.node] < it.dist)
//                 continue;
//             int curnode = it.node;
//             int nextnode1 = (curnode+1)%n;
//             int dist1 = getdist(distance, curnode, nextnode1);
//             if(cost[curnode] + dist1 < cost[nextnode1]){
//                 cost[nextnode1] = cost[curnode] + dist1;
//                 q.offer(new Item(nextnode1, cost[nextnode1]));
//             }
//             int nextnode2 = (curnode+n-1)%n;
//             int dist2 = getdist(distance, curnode, nextnode2);
//             if(cost[curnode] + dist2 < cost[nextnode2]){
//                 cost[nextnode2] = cost[curnode] + dist2;
//                 q.offer(new Item(nextnode2, cost[nextnode2]));
//             }
//         }
//         return cost[destination];
//     }

//     private int getdist(int[] distance, int s, int e){
//         if (e != (s+1)%distance.length)
//             return getdist(distance, e, s);
//         return distance[s];
//     }
// }
