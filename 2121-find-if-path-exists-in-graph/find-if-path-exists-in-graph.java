class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        
        for (int[] edge: edges){
            List<Integer> vertices1 = edgeMap.getOrDefault(edge[0], new ArrayList<>());
            vertices1.add(edge[1]);
            edgeMap.put(edge[0], vertices1);
            
            List<Integer> vertices2 = edgeMap.getOrDefault(edge[1], new ArrayList<>());
            vertices2.add(edge[0]);
            edgeMap.put(edge[1], vertices2);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        
        while (!queue.isEmpty()){
            Integer poppedVertex = queue.remove();
            
            List<Integer> vertices = edgeMap.getOrDefault(poppedVertex, new ArrayList<>());
            
            for (Integer vertex: vertices){
                if (vertex == destination){
                    return true;
                }
                
                if (!visited.contains(vertex)){
                    queue.add(vertex);
                    visited.add(vertex);
                }
            }
        }
        
        
        return false;
    }
}