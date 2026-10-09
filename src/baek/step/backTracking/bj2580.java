package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj2580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] sudoku = new int[9][9];
    static StringTokenizer st;
    static int count = 0;
    static int totalNode;
    static Node[] nodes;
    static HashSet<Integer>[] rowSet = new HashSet[9];
    static HashSet<Integer>[] colSet = new HashSet[9];
    static HashSet<Integer>[] groupSet = new HashSet[9];

    public static void main(String[] args) throws IOException {
        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            groupSet[i] = new HashSet<>();
        }

        // Input
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int a = Integer.parseInt(st.nextToken());

                // Add to sets
                rowSet[i].add(a);
                colSet[j].add(a);
                groupSet[searchGroup(i, j)].add(a);

                // Assign to array
                sudoku[i][j] = a;

                if (a == 0) {
                    totalNode++;
                }
            }
        }

        nodes = new Node[totalNode];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    nodes[count] = new Node(i, j, searchGroup(i, j));
                    count++;
                }
            }
        }

        for (int i = 0; i < totalNode; i++) {
            int currentRow = nodes[i].getRow();
            int currentCol = nodes[i].getCol();
            for (int j = 1; j <= 9; j++) {
                if (valid(currentRow, currentCol, j)) {
                    nodes[i].add(j);
                }
            }
        }
        ETC(0, 0);
    }

    static void ETC(int start, int depth) {
        if (depth == totalNode) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                if (rowSet[i].size() == 9) {
                    //System.out.println("rowset check");
                    return;
                }
                for (int j = 0; j < 9; j++) {
                    if (colSet[j].size() == 9) {
                        //System.out.println("colset check");
                        return;
                    }
                    if (groupSet[searchGroup(i, j)].size() == 9) {
                        //System.out.println("groupset check");
                        return;
                    }
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        Node currentNode = nodes[start];
        int currentX = currentNode.getRow();
        int currentY = currentNode.getCol();

        for (Integer i : currentNode.candi) {
            if (valid(currentX, currentY, i)) {
                sudoku[currentX][currentY] = i;

                rowSet[currentX].add(i);
                colSet[currentY].add(i);
                groupSet[searchGroup(currentX, currentY)].add(i);

                ETC(start + 1, depth + 1);

                rowSet[currentX].remove(i);
                colSet[currentY].remove(i);
                groupSet[searchGroup(currentX, currentY)].remove(i);

                sudoku[currentX][currentY] = 0;
            }
        }
    }

    static boolean valid(int row, int col, int num) {
        return !rowSet[row].contains(num) && !colSet[col].contains(num) && !groupSet[searchGroup(row, col)].contains(num);
    }

    static int searchGroup(int row, int col) {
        int x = (row / 3) * 3;
        int y = (col / 3);
        return x + y;
    }

    static class Node {
        int row;
        int col;
        int group;
        HashSet<Integer> candi = new HashSet<>();

        public Node(int row, int col, int group) {
            this.row = row;
            this.col = col;
            this.group = group;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getGroup() {
            return group;
        }

        public HashSet<Integer> getCandi() {
            return candi;
        }

        public void add(int num) {
            candi.add(num);
        }

        public int size() {
            return candi.size();
        }
    }
}
