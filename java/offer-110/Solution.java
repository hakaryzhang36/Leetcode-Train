// Leetcode offer-110
class Solution {
    int[][] graph = null;
    int end = 0;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        end = graph.length-1;
        dfs(0, new ArrayList<Integer>());
        return ans;
    }

    public void dfs (int i, ArrayList<Integer> list) {
        list.add(i);
        if (i == end) {
            ans.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            dfs(graph[i][j], list);
        }
        list.remove(list.size()-1);
        return;
    }

}