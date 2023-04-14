// Leetcode 399-evaluate-division
// mark
// done
class Solution {
    class Node {
        String val = null;
        Map<String, Double> map = null;
        public Node(String val) {
            this.val = val;
            map = new HashMap<>();
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            double v1 = values[i];
            String a = e.get(0);
            String b = e.get(1);
            Node na = nodes.getOrDefault(a, new Node(a));
            na.map.put(b, v1);
            na.map.put(a, 1.0);
            nodes.put(a, na);
            if (v1 != 0.0) {
                Node nb = nodes.getOrDefault(b, new Node(b));
                nb.map.put(a, 1.0/v1);
                nb.map.put(b, 1.0);
                nodes.put(b, nb);
            }
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            if (!nodes.containsKey(q.get(0)) || !nodes.containsKey(q.get(1))) {
                ans[i] = -1.0;
                continue;
            }
            ans[i] = dfs(nodes, new HashSet<String>(), nodes.get(q.get(0)), q.get(0), q.get(1));
        }
        return ans;
    }

    public Double dfs(Map<String, Node> nodes, Set<String> marks, Node curNode, String a, String b) {
        marks.add(curNode.val);
        if (curNode.map.containsKey(b)) {
            return curNode.map.get(b);
        }
        for (Map.Entry<String, Double> e : curNode.map.entrySet()) {
            if (marks.contains(e.getKey())) {
                continue;
            }
            marks.add(e.getKey());
            double res = dfs(nodes, marks, nodes.get(e.getKey()), a, b);
            if (res != -1.0) {
                return res*e.getValue();
            }
        }
        return -1.0;
    }
}