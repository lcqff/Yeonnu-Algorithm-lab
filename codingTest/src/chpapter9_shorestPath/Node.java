package chpapter9_shorestPath;

class Node implements Comparable<Node> {
    private int cost;
    private int nodeNum;

    public int getCost() {
        return cost;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public Node(int cost, int nodeNum) {
        this.cost = cost;
        this.nodeNum = nodeNum;
    }

    @Override
    public int compareTo(Node node) { //오름차 정렬됨
        if (this.cost > node.getCost()) {
            return 1;
        }
        if (this.cost < node.getCost()) {
            return -1;
        }
        if (this.nodeNum < node.getNodeNum()) {
            return -1;
        }
        return 0;
    }
}
