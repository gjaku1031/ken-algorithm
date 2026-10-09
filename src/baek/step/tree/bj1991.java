package baek.step.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] chList;
    static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        chList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            chList[i] = new ArrayList<>();
        }
        chList[0].add(null);
        chList[0].add(null);

        for (int i = 1; i <= N; i++) {
            chList[i].add(0);
            chList[i].add(0);
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            if (b != '.') {
                chList[a - 64].set(0, b - 64);
            }
            if (c != '.' && chList[i].get(1) == 0) {
                chList[a - 64].set(1, c - 64);
            }
        }
        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }

    static void preorder(int index) {
        //System.out.println(index + " run");
        ArrayList<Integer> arr = chList[index];
        if (arr.get(0) == null && arr.get(1) == null) {
            //System.out.println(index + " is empty, exiting");
            return;
        }
        System.out.print((char) (index + 64));
        if (arr.get(0) != null) {
            preorder(arr.get(0));
        }else {
            preorder(0);
        }

        if (arr.get(1) != null) {
            preorder(arr.get(1));
        } else {
            preorder(0);
        }
        //System.out.println(index + " done");
    }
    static void inorder(int index) {
        //System.out.println(index + " run");
        ArrayList<Integer> arr = chList[index];

        if (arr.get(0) == null && arr.get(1) == null) {
            //System.out.println(index + " is empty, exiting");
            return;
        }

        if (arr.get(0) != null) {
            inorder(arr.get(0));
        }else {
            inorder(0);
        }

        System.out.print((char) (index + 64));

        if (arr.get(1) != null) {
            inorder(arr.get(1));
        } else {
            inorder(0);
        }
        //System.out.println(index + " done");
    }
    static void postorder(int index) {
        //System.out.println(index + " run");
        ArrayList<Integer> arr = chList[index];

        if (arr.get(0) == null && arr.get(1) == null) {
            //System.out.println(index + " is empty, exiting");
            return;
        }

        if (arr.get(0) != null) {
            postorder(arr.get(0));
        }else {
            postorder(0);
        }


        if (arr.get(1) != null) {
            postorder(arr.get(1));
        } else {
            postorder(0);
        }
        System.out.print((char) (index + 64));
        //System.out.println(index + " done");
    }
}