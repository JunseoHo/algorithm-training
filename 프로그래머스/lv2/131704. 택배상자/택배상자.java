class Solution {
    public int solution(int[] order) {
    int orderIndex = 0;
        int loadCount = 0;
        int currentBox = 1;
        int[] containerBelt = new int[order.length];
        int itemCount = 0;
        while (true) {
            if (currentBox <= order.length && order[orderIndex] == currentBox) {
                orderIndex++;
                loadCount++;
                currentBox++;
            } else if (itemCount != 0 && order[orderIndex] == containerBelt[itemCount]) {
                itemCount--;
                orderIndex++;
                loadCount++;
            } else {
                if(currentBox > order.length){
                    return loadCount;
                }
                containerBelt[++itemCount] = currentBox++;
            }
        }

}
}