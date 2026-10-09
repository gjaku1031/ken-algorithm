# ken-algorithm

Java로 자료구조와 알고리즘을 공부하며 직접 구현한 기록입니다.
백준 단계별 문제로 기초를 다지고, 티어별 심화 문제와 삼성 SW 역량테스트 기출로 응용력을 키웠습니다.

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=openjdk&logoColor=white)
![Problems](https://img.shields.io/badge/solved-476_problems-0076C0?style=flat-square)
![Period](https://img.shields.io/badge/2024.12_~_2025.10-563_commits-success?style=flat-square)

<br>

## 다룰 수 있는 것

| 영역 | 내용 |
|---|---|
| **자료구조** | 스택(직접 구현) · 큐/덱 · 우선순위 큐 · 해시 · TreeSet · 유니온 파인드 · 그래프/트리 표현 |
| **그래프** | BFS/DFS · 다익스트라 · 플로이드-워셜 · 크루스칼 · 위상 정렬 · 이분 그래프 판별 |
| **탐색** | 완전 탐색 · 백트래킹 · 이분 탐색 · 파라메트릭 서치 · 투 포인터 · 슬라이딩 윈도우 |
| **동적 계획법** | 점화식 설계 · 메모이제이션 · 0-1 배낭 · LIS(O(N log N) + 역추적) · LCS · Kadane |
| **수학** | 분할 정복 거듭제곱 · 행렬 거듭제곱 · 에라토스테네스의 체 · 유클리드 호제법 · 모듈러 역원 · CCW |
| **구현** | 시뮬레이션 · 배열 회전 · 삼성 SW 역량테스트 A형 기출 |

<br>

## 자료구조

### 스택
- 배열과 `top` 인덱스로 push / pop / peek을 직접 구현
- 모노톤 스택으로 "오른쪽에서 처음 만나는 더 큰 수"를 O(N)에 계산
- 스택으로 괄호 짝 검사

풀이: [스택 직접 구현](src/baek/step/stackQueDeq/ArrayStack.java) · [괄호](src/baek/step/stackQueDeq/bj9012.java) · [오큰수](src/baek/gold/G4/bj17298.java) · [탑](src/baek/gold/G5/bj2493.java) · [탑 보기](src/baek/gold/G3/bj22866.java)

<details>
<summary>핵심 코드: 모노톤 스택</summary>

```java
// 스택에는 아직 "오큰수"를 찾지 못한 인덱스가 남아 있다
for (int i = 1; i < N; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        NGE[stack.pop()] = arr[i];
    }
    stack.push(i);
}
```
</details>

### 큐 · 덱
- `ArrayDeque`로 큐/덱 연산을 처리하고 BFS의 기본 자료구조로 사용
- 덱 두 개를 커서 왼쪽/오른쪽 버퍼로 사용해 삽입·삭제를 O(1)에 처리
- 원형 큐 시뮬레이션 (요세푸스, 카드 버리기)

풀이: [큐 2](src/baek/step/stackQueDeq/bj18258.java) · [덱](src/baek/step/stackQueDeq/bj10866.java) · [요세푸스 문제 0](src/baek/step/stackQueDeq/bj11866.java) · [에디터](src/baek/silver/S2/bj1406.java)

### 우선순위 큐 (힙)
- `Comparable` / `Comparator`로 정렬 기준을 정의하고, `Collections.reverseOrder()`로 최대 힙 구성
- 최대 힙과 최소 힙을 함께 써서 실시간으로 중앙값 유지
- 그리디와 결합해 "현재 가능한 후보 중 최댓값"을 반복 선택

풀이: [최소 힙](src/baek/step/heap/bj1927.java) · [절댓값 힙](src/baek/step/heap/bj11286.java) · [중앙값 구하기](src/baek/gold/G2/bj2696.java) · [보석 도둑](src/baek/gold/G2/bj1202.java)

### 해시 · 정렬된 집합
- `HashMap` / `HashSet`으로 O(1) 조회, 문자열과 인덱스 양방향 매핑
- 등장 횟수 세기
- `TreeSet`으로 중복 제거와 정렬 상태를 동시에 유지

풀이: [나는야 포켓몬 마스터 이다솜](src/baek/step/setMap/bj1620.java) · [숫자 카드 2](src/baek/step/setMap/bj10816.java) · [N과 M (11)](src/baek/silver/S2/bj15665.java)

### 유니온 파인드
- 경로 압축과 크기 기준 합치기(union by size)로 find를 거의 O(1)에 처리
- 집합 크기 관리, 사이클 판정 (크루스칼에서 활용)
- 이름(문자열)을 `HashMap`으로 인덱스에 매핑한 뒤 합치기

풀이: [집합의 표현](src/baek/gold/G5/bj1717.java) · [여행 가자](src/baek/gold/G4/bj1976.java) · [친구 네트워크](src/baek/gold/G2/bj4195.java) · [서로소 집합](src/sw/D4/sw3289.java)

<details>
<summary>핵심 코드: 경로 압축 + 크기 기준 합치기</summary>

```java
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // 경로 압축
    return parent[x];
}

boolean union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra == rb) return false;                // 이미 같은 집합 (사이클)
    if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
    parent[rb] = ra;                           // 작은 쪽을 큰 쪽에 붙임
    size[ra] += size[rb];
    return true;
}
```
</details>

### 그래프 · 트리 표현
- 인접 리스트(`List<Integer>[]`), 인접 행렬, 간선 클래스(`Edge implements Comparable`)로 그래프 표현
- 트리의 전위·중위·후위 순회, 루트에서 탐색하며 부모 노드 기록

풀이: [DFS와 BFS](src/baek/step/graph/bj1260.java) · [트리 순회](src/baek/step/tree/bj1991.java) · [트리의 부모 찾기](src/baek/step/tree/bj11725.java)

<br>

## 알고리즘

### 그래프 탐색 (BFS · DFS)
- 격자 최단 거리 BFS, 여러 시작점을 큐에 동시에 넣는 다중 시작점 BFS
- 3차원 격자 BFS
- 방문 배열에 상태 차원을 추가한 BFS: `visited[r][c][벽을 부쉈는지]`
- 2색 칠하기로 이분 그래프 판별, 연결 요소 개수 세기
- BFS와 시뮬레이션 결합 (확산, 녹는 과정, 동시 이동)

풀이: [미로 탐색](src/baek/step/graph/bj2178.java) · [토마토](src/baek/step/graph/bj7576.java) · [토마토 (3차원)](src/baek/step/graph/bj7569.java) · [벽 부수고 이동하기](src/baek/step/graph/bj2206.java) · [이분 그래프](src/baek/step/graph/bj1707.java) · [연구소](src/baek/gold/G4/bj14502.java) · [치즈](src/baek/gold/G4/bj2636.java) · [탈출](src/baek/gold/G4/bj3055.java)

### 최단 경로
- **다익스트라** O(E log V): 우선순위 큐 + 이미 갱신된 낡은 항목 건너뛰기
- 경유지가 있는 경로를 다익스트라 여러 번으로 나눠 계산
- 격자를 가중치 그래프로 보고 다익스트라 적용
- **플로이드-워셜** O(V³): 모든 정점 쌍의 최단 거리

풀이: [최단경로](src/baek/gold/G4/bj1753.java) · [특정한 최단 경로](src/baek/gold/G4/bj1504.java) · [녹색 옷 입은 애가 젤다지?](src/baek/gold/G4/bj4485.java) · [플로이드](src/baek/gold/G4/bj11404.java) · [사람 네트워크2](src/sw/D6/sw1263.java)

<details>
<summary>핵심 코드: 다익스트라</summary>

```java
dist[K] = 0;
pq.add(new State(K, 0));
while (!pq.isEmpty()) {
    State cur = pq.poll();
    if (cur.d != dist[cur.v]) continue; // 낡은 항목 스킵
    for (Edge e : g[cur.v]) {
        long nd = cur.d + e.w;
        if (nd < dist[e.to]) {          // 완화
            dist[e.to] = nd;
            pq.add(new State(e.to, nd));
        }
    }
}
```
</details>

### 최소 신장 트리
- **크루스칼** O(E log E): 간선을 가중치순으로 정렬하고 유니온 파인드로 사이클을 막으며 선택

풀이: [최소 스패닝 트리](src/baek/gold/G4/bj1197.java) · [네트워크 연결](src/baek/gold/G4/bj1922.java) · [하나로](src/sw/D4/sw1251.java)

### 위상 정렬
- 진입 차수 기반 Kahn 알고리즘 O(V + E)
- 우선순위 큐와 결합해 조건을 만족하는 순서 중 가장 앞선 것 선택
- 큐 크기로 결과가 유일한지(`?`), 순환이 있는지(`IMPOSSIBLE`) 판별

풀이: [줄 세우기](src/baek/gold/G3/bj2252.java) · [문제집](src/baek/gold/G2/bj1766.java) · [최종 순위](src/baek/gold/G1/bj3665.java) · [작업순서](src/sw/D6/sw1267.java)

### 완전 탐색 · 백트래킹
- 순열 / 조합 / 중복 순열 / 중복 조합을 직접 구현 (N과 M 시리즈 전체)
- 부분집합 탐색
- 가지치기: 현재 비용이 지금까지의 최솟값 이상이면 중단, 대각선 충돌 검사

풀이: [N과 M (1)](src/baek/step/backTracking/bj15649.java) · [N과 M (12)](src/baek/silver/S2/bj15666.java) · [도영이가 만든 맛있는 음식](src/baek/silver/S2/bj2961.java) · [외판원 순회 2](src/baek/silver/S2/bj10971.java) · [N-Queen](src/baek/step/backTracking/bj9663.java) · [스도쿠](src/baek/step/backTracking/bj2580.java) · [알파벳](src/baek/gold/G4/bj1987.java)

### 동적 계획법
- 점화식 설계, bottom-up과 top-down(메모이제이션) 구현
- **0-1 배낭**: 1차원 배열을 역순으로 갱신해 공간 최적화, 비용을 축으로 바꾼 배낭 응용
- **LIS**: O(N²) DP와 O(N log N) 이분 탐색 방식 모두 구현, 실제 수열 역추적까지
- LCS, 바이토닉 수열, 최대 연속합(Kadane)

풀이: [1로 만들기](src/baek/step/dp1/bj1463.java) · [신나는 함수 실행](src/baek/step/dp1/bj9184.java) · [평범한 배낭](src/baek/gold/G5/bj12865.java) · [앱](src/baek/gold/G3/bj7579.java) · [가장 긴 증가하는 부분 수열 5](src/baek/platinum/P5/bj14003.java) · [LCS](src/baek/gold/G5/bj9251.java) · [가장 긴 바이토닉 부분 수열](src/baek/step/dp1/bj11054.java) · [연속합](src/baek/step/dp1/bj1912_Kadane.java)

<details>
<summary>핵심 코드: 0-1 배낭 (1차원)</summary>

```java
// 무게 j를 큰 쪽부터 갱신해야 같은 물건을 두 번 담지 않는다
for (int i = 1; i <= N; i++) {
    for (int j = K; j >= weight[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + cost[i]);
    }
}
```
</details>

### 이분 탐색
- 정렬된 배열에서 lower bound 직접 구현
- **파라메트릭 서치**: "조건을 만족하는 최댓값"을 결정 문제로 바꿔 이분 탐색
- LIS O(N log N) 최적화에 응용

풀이: [랜선 자르기](src/baek/step/binarySearch/bj1654.java) · [가장 긴 증가하는 부분 수열 2](src/baek/gold/G2/bj12015.java) · [가장 긴 증가하는 부분 수열 3](src/baek/gold/G2/bj12738.java)

### 그리디
- 정렬 기준을 세우고 매 단계 최선의 선택 (끝나는 시간 기준 정렬 등)
- 우선순위 큐와 결합한 그리디

풀이: [회의실 배정](src/baek/gold/G5/bj1931.java) · [주유소](src/baek/silver/S3/bj13305.java) · [잃어버린 괄호](src/baek/silver/S2/bj1541.java) · [보석 도둑](src/baek/gold/G2/bj1202.java)

### 누적 합 · 투 포인터 · 슬라이딩 윈도우
- 1차원 / 2차원 누적 합으로 구간 합을 O(1)에 계산
- 나머지 누적 합과 개수 세기를 결합
- 원형 배열에서 고정 길이 윈도우 이동, 정렬 후 투 포인터

풀이: [구간 합 구하기 4](src/baek/silver/S3/bj11659.java) · [구간 합 구하기 5](src/baek/silver/S1/bj11660.java) · [체스판 다시 칠하기 2](src/baek/gold/G4/bj25682.java) · [나머지 합](src/baek/gold/G3/bj10986.java) · [수열](src/baek/silver/S3/bj2559.java) · [회전 초밥](src/baek/gold/G4/bj15961.java) · [한빈이와 Spot Mart](src/sw/D3/sw9229.java)

### 분할 정복
- 분할 정복 거듭제곱 O(log N), 행렬 거듭제곱으로 피보나치 수 O(log N)
- 영역을 재귀적으로 4분할 / 9분할 (쿼드트리, Z, 종이의 개수)
- 재귀 패턴 출력 (별 찍기, 하노이 탑)

풀이: [곱셈](src/baek/silver/S1/bj1629.java) · [행렬 제곱](src/baek/gold/G4/bj10830.java) · [피보나치 수 6](src/baek/gold/G2/bj11444.java) · [쿼드트리](src/baek/silver/S1/bj1992.java) · [Z](src/baek/gold/G5/bj1074.java) · [종이의 개수](src/baek/silver/S2/bj1780.java) · [하노이 탑 이동 순서](src/baek/gold/G5/bj11729.java)

### 수학
- 소수 판별 O(√N), 에라토스테네스의 체
- 유클리드 호제법으로 최대공약수
- 파스칼의 삼각형으로 이항 계수, 페르마의 소정리로 모듈러 역원 계산 ([정리 노트](src/baek/gold/G1/bj11401.md))
- 기하: CCW, 선분 교차 판정, 신발끈 공식으로 다각형 넓이

풀이: [골드바흐 파티션](src/baek/step/divMulPrimes2/bj17103.java) · [가로수](src/baek/step/divMulPrimes2/bj2485.java) · [이항 계수 2](src/baek/silver/S2/bj11051.java) · [이항 계수 3](src/baek/gold/G1/bj11401.java) · [CCW](src/baek/gold/G5/bj11758.java) · [선분 교차 1](src/baek/gold/G3/bj17386.java) · [다각형의 면적](src/baek/gold/G5/bj2166.java)

### 구현 · 시뮬레이션
- 여러 조건이 얽힌 문제를 단계별로 나눠 구현
- 배열 회전, 톱니바퀴 회전, 동시 이동 처리
- 완전 탐색과 시뮬레이션을 결합한 삼성 SW 역량테스트 A형 유형

풀이: [감시](src/baek/gold/G3/bj15683.java) · [톱니바퀴](src/baek/gold/G5/bj14891.java) · [캐슬 디펜스](src/baek/gold/G3/bj17135.java) · [야구](src/baek/gold/G4/bj17281.java) · [배열 돌리기 3](src/baek/gold/G5/bj16935.java)

<details>
<summary>모의 SW 역량테스트 기출 17문제</summary>

[최적 경로](src/sw/sw1247.java) · [등산로 조성](src/sw/sw1949.java) · [수영장](src/sw/sw1952.java) · [탈주범 검거](src/sw/sw1953.java) · [디저트 카페](src/sw/sw2105.java) · [보호 필름](src/sw/sw2112.java) · [벌꿀채취](src/sw/sw2115.java) · [미생물 격리](src/sw/sw2382.java) · [차량 정비소](src/sw/sw2477.java) · [숫자 만들기](src/sw/sw4008.java) · [요리사](src/sw/sw4012.java) · [특이한 자석](src/sw/sw4013.java) · [활주로 건설](src/sw/sw4014.java) · [무선 충전](src/sw/sw5644.java) · [원자 소멸 시뮬레이션](src/sw/sw5648.java) · [핀볼 게임](src/sw/sw5650.java) · [벽돌 깨기](src/sw/sw5656.java)
</details>

<br>

## 학습 과정

| 단계 | 내용 | 풀이 수 |
|---|---|:---:|
| **1. 기초** | 백준 단계별로 풀어보기 24단계 (입출력부터 최소 신장 트리까지) | 168 |
| **2. 심화** | 백준 티어별 문제 (Platinum 1 · Gold 61 · Silver 54 · Bronze 63) | 179 |
| **3. 실전** | SW Expert Academy D1~D6, 모의 SW 역량테스트 기출 | 128 |
| | CodeTree | 1 |
| **합계** | 2024.12 ~ 2025.10 · 커밋 563개 | **476** |

> 백준 ID: `gjaku1031` (BOJ 서비스 종료로 문제 링크 대신 풀이 코드 링크를 첨부했습니다.)

<br>

## 다음 목표

- 세그먼트 트리, 펜윅 트리
- LCA (최소 공통 조상)
- 문자열 알고리즘 (KMP, 트라이)
- 비트마스크 DP

<br>

## 폴더 구조

```
src
├── baek          # 백준
│   ├── step      # 단계별로 풀어보기
│   ├── bronze    # B5 ~ B1
│   ├── silver    # S5 ~ S1
│   ├── gold      # G5 ~ G1
│   └── platinum  # P5
├── sw            # SW Expert Academy (D1 ~ D6, 루트는 모의 역량테스트 기출)
└── codeTree      # CodeTree
```
