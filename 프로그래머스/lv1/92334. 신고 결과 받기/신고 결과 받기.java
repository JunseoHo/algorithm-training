class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        boolean[][] reportTable = new boolean[id_list.length][id_list.length];
        for (String s : report) {
            String[] tokens = s.split(" ");
            int reporter = -1;
            int reportee = -1;
            for (int i = 0; i < id_list.length; i++) if (id_list[i].equals(tokens[0])) reporter = i;
            for (int i = 0; i < id_list.length; i++) if (id_list[i].equals(tokens[1])) reportee = i;
            reportTable[reporter][reportee] = true;
        }
        for (int i = 0; i < reportTable.length; i++) {
            int reportCount = 0;
            for (int j = 0; j < reportTable.length; j++) if (reportTable[j][i]) reportCount++;
            if (reportCount >= k)
                for (int j = 0; j < reportTable.length; j++) if (reportTable[j][i]) answer[j]++;
        }
        return answer;
    }
}