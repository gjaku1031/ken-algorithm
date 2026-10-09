package baek.step.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // Use two hash maps
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (isNumeric(input)) {
                sb.append(map1.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(map2.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
