package baek.step.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st1.nextToken());
        int B = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            set1.add(Integer.parseInt(st2.nextToken()));
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            set2.add(Integer.parseInt(st3.nextToken()));
        }

        // Union
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Intersection
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        HashSet<Integer> resultSet = new HashSet<>(union);
        resultSet.removeAll(intersection);

        System.out.println(resultSet.size());

    }
}
