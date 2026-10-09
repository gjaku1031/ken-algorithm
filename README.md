# ken-algorithm

> Java로 꾸준히 풀어온 알고리즘 문제 풀이 기록

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=openjdk&logoColor=white)
![Baekjoon](https://img.shields.io/badge/Baekjoon-353_problems-0076C0?style=flat-square)
![SWEA](https://img.shields.io/badge/SWEA-129_problems-1E90FF?style=flat-square)
![Period](https://img.shields.io/badge/2024.12_~_2025.10-563_commits-success?style=flat-square)

<br>

## 한눈에 보기

| 플랫폼 | 풀이 수 | 비고 |
|---|---:|---|
| **백준 (BOJ)** | **353** | Platinum 1 · Gold 64 · Silver 57 · Bronze 64 · 단계별 풀이 167 |
| **SW Expert Academy** | **129** | SW 역량테스트 모의 기출 17 · D1~D6 112 |
| **CodeTree** | 1 | |
| **합계** | **483** | |

### 백준 티어 분포

| Platinum | Gold | Silver | Bronze |
|:---:|:---:|:---:|:---:|
| **1** | **64** | **57** | **64** |
| P5 1 | G1 3 · G2 7 · G3 9 · G4 21 · G5 24 | S1 12 · S2 17 · S3 17 · S4 5 · S5 6 | B1 8 · B2 9 · B3 34 · B4 11 · B5 2 |

> 백준 ID: `gjaku1031` (BOJ 서비스 종료로 문제 링크 대신 풀이 코드 링크를 첨부했습니다.)

<br>

## 다룰 수 있는 자료구조

| 분류 | 다룰 수 있는 것 | 풀이 예시 |
|---|---|---|
| **배열 · 문자열** | 1차원/2차원 배열 조작, 배열 회전, StringBuilder를 활용한 문자열 처리 | [배열 돌리기 1](src/baek/gold/G5/bj16926.java), [배열 돌리기 3](src/baek/gold/G5/bj16935.java), [그룹 단어 체커](src/baek/step/deep1/bj1316.java) |
| **스택** | 배열 기반 스택 직접 구현, 괄호 검사, 모노톤 스택 | [ArrayStack 직접 구현](src/baek/step/stackQueDeq/ArrayStack.java), [괄호](src/baek/step/stackQueDeq/bj9012.java), [오큰수](src/baek/gold/G4/bj17298.java), [탑](src/baek/gold/G5/bj2493.java), [탑 보기](src/baek/gold/G3/bj22866.java) |
| **큐 · 덱** | ArrayDeque 기반 큐/덱, 덱 두 개로 커서 이동 구현 | [큐 2](src/baek/step/stackQueDeq/bj18258.java), [카드2](src/baek/step/stackQueDeq/bj2164.java), [덱](src/baek/step/stackQueDeq/bj10866.java), [에디터](src/baek/silver/S2/bj1406.java) |
| **우선순위 큐 (힙)** | 최소/최대/커스텀 힙, Comparable·Comparator 정렬 기준, 두 힙으로 중앙값 유지 | [최소 힙](src/baek/step/heap/bj1927.java), [절댓값 힙](src/baek/step/heap/bj11286.java), [중앙값 구하기](src/baek/gold/G2/bj2696.java), [보석 도둑](src/baek/gold/G2/bj1202.java) |
| **해시 · 트리 셋** | HashMap/HashSet 조회, TreeSet/TreeMap으로 정렬된 집합 유지 | [나는야 포켓몬 마스터 이다솜](src/baek/step/setMap/bj1620.java), [숫자 카드 2](src/baek/step/setMap/bj10816.java), [친구 네트워크](src/baek/gold/G2/bj4195.java), [N과 M (11)](src/baek/silver/S2/bj15665.java) |
| **유니온 파인드** | 경로 압축, 집합 크기 관리, 사이클 판정 | [집합의 표현](src/baek/gold/G5/bj1717.java), [여행 가자](src/baek/gold/G4/bj1976.java), [친구 네트워크](src/baek/gold/G2/bj4195.java), [서로소 집합](src/sw/D4/sw3289.java) |
| **그래프 · 트리** | 인접 리스트/인접 행렬 표현, 트리 전위·중위·후위 순회, 부모 노드 찾기 | [DFS와 BFS](src/baek/step/graph/bj1260.java), [트리 순회](src/baek/step/tree/bj1991.java), [트리의 부모 찾기](src/baek/step/tree/bj11725.java) |

<br>

## 다룰 수 있는 알고리즘

| 분류 | 다룰 수 있는 것 | 풀이 예시 |
|---|---|---|
| **완전 탐색 · 백트래킹** | 순열/조합/중복 순열/중복 조합, 부분집합, 가지치기 | [N과 M (1)](src/baek/step/backTracking/bj15649.java), [N과 M (12)](src/baek/silver/S2/bj15666.java), [N-Queen](src/baek/step/backTracking/bj9663.java), [스도쿠](src/baek/step/backTracking/bj2580.java), [외판원 순회 2](src/baek/silver/S2/bj10971.java), [도영이가 만든 맛있는 음식](src/baek/silver/S2/bj2961.java) |
| **BFS · DFS** | 격자 최단 거리, 다중 시작점 BFS, 3차원 BFS, 상태를 포함한 BFS, 이분 그래프 판별, 연결 요소 | [미로 탐색](src/baek/step/graph/bj2178.java), [토마토](src/baek/step/graph/bj7576.java), [토마토 (3차원)](src/baek/step/graph/bj7569.java), [벽 부수고 이동하기](src/baek/step/graph/bj2206.java), [이분 그래프](src/baek/step/graph/bj1707.java), [연결 요소의 개수](src/baek/silver/S2/bj11724.java) |
| **최단 경로** | 다익스트라(우선순위 큐), 플로이드-워셜 | [최단경로](src/baek/gold/G4/bj1753.java), [특정한 최단 경로](src/baek/gold/G4/bj1504.java), [녹색 옷 입은 애가 젤다지?](src/baek/gold/G4/bj4485.java), [숨바꼭질 3](src/baek/gold/G5/bj13549.java), [플로이드](src/baek/gold/G4/bj11404.java), [사람 네트워크2](src/sw/D6/sw1263.java) |
| **최소 신장 트리** | 크루스칼 (간선 정렬 + 유니온 파인드) | [최소 스패닝 트리](src/baek/gold/G4/bj1197.java), [네트워크 연결](src/baek/gold/G4/bj1922.java), [하나로](src/sw/D4/sw1251.java), [최소 스패닝 트리 (SWEA)](src/sw/D4/sw3124.java) |
| **위상 정렬** | 진입 차수 기반 위상 정렬, 우선순위 큐 결합, 순서 변경과 모순 판별 | [줄 세우기](src/baek/gold/G3/bj2252.java), [문제집](src/baek/gold/G2/bj1766.java), [최종 순위](src/baek/gold/G1/bj3665.java), [작업순서](src/sw/D6/sw1267.java) |
| **동적 계획법** | 기본 점화식, 메모이제이션, 0-1 배낭, LIS(O(N²) · O(N log N) + 역추적), LCS, 최대 연속합(Kadane) | [1로 만들기](src/baek/step/dp1/bj1463.java), [신나는 함수 실행](src/baek/step/dp1/bj9184.java), [평범한 배낭](src/baek/gold/G5/bj12865.java), [앱](src/baek/gold/G3/bj7579.java), [가장 긴 증가하는 부분 수열 5](src/baek/platinum/P5/bj14003.java), [LCS](src/baek/gold/G5/bj9251.java), [가장 긴 바이토닉 부분 수열](src/baek/step/dp1/bj11054.java), [연속합 (Kadane)](src/baek/step/dp1/bj1912_Kadane.java) |
| **이분 탐색** | lower bound, 파라메트릭 서치 | [랜선 자르기](src/baek/step/binarySearch/bj1654.java), [공유기 설치](src/baek/gold/G4/bj2110.java), [가장 긴 증가하는 부분 수열 2](src/baek/gold/G2/bj12015.java) |
| **그리디** | 정렬 기준 설계, 우선순위 큐 결합 | [회의실 배정](src/baek/gold/G5/bj1931.java), [주유소](src/baek/silver/S3/bj13305.java), [잃어버린 괄호](src/baek/silver/S2/bj1541.java), [보석 도둑](src/baek/gold/G2/bj1202.java) |
| **누적 합** | 1차원/2차원 누적 합, 나머지 누적 합 | [구간 합 구하기 4](src/baek/silver/S3/bj11659.java), [구간 합 구하기 5](src/baek/silver/S1/bj11660.java), [체스판 다시 칠하기 2](src/baek/gold/G4/bj25682.java), [나머지 합](src/baek/gold/G3/bj10986.java) |
| **투 포인터 · 슬라이딩 윈도우** | 고정 길이 윈도우, 원형 배열 윈도우, 정렬 후 투 포인터 | [수열](src/baek/silver/S3/bj2559.java), [회전 초밥](src/baek/gold/G4/bj15961.java), [한빈이와 Spot Mart](src/sw/D3/sw9229.java) |
| **분할 정복** | 빠른 거듭제곱, 행렬 거듭제곱, 쿼드트리, 재귀적 패턴 | [곱셈](src/baek/silver/S1/bj1629.java), [행렬 제곱](src/baek/gold/G4/bj10830.java), [피보나치 수 6](src/baek/gold/G2/bj11444.java), [쿼드트리](src/baek/silver/S1/bj1992.java), [Z](src/baek/gold/G5/bj1074.java), [별 찍기 - 11](src/baek/gold/G4/bj2448.java) |
| **정수론** | 에라토스테네스의 체, 유클리드 호제법, 모듈러 역원(페르마의 소정리), 이항 계수 | [소수 구하기](src/baek/step/divMulPrimes2/bj1929.java), [골드바흐 파티션](src/baek/step/divMulPrimes2/bj17103.java), [가로수](src/baek/step/divMulPrimes2/bj2485.java), [이항 계수 2](src/baek/silver/S2/bj11051.java), [이항 계수 3](src/baek/gold/G1/bj11401.java) |
| **기하** | CCW, 선분 교차 판정, 신발끈 공식 | [CCW](src/baek/gold/G5/bj11758.java), [선분 교차 1](src/baek/gold/G3/bj17386.java), [다각형의 면적](src/baek/gold/G5/bj2166.java) |
| **구현 · 시뮬레이션** | 복잡한 조건 구현, 회전·이동 시뮬레이션, 완전 탐색과 시뮬레이션 결합 | [감시](src/baek/gold/G3/bj15683.java), [톱니바퀴](src/baek/gold/G5/bj14891.java), [캐슬 디펜스](src/baek/gold/G3/bj17135.java), [야구](src/baek/gold/G4/bj17281.java), [벽돌 깨기](src/sw/sw5656.java), [핀볼 게임](src/sw/sw5650.java) |

<br>

## 알고리즘별 대표 문제 (Gold 이상)

| 분야 | 문제 |
|---|---|
| **최단 경로** | 1753 [최단경로](src/baek/gold/G4/bj1753.java) (G4), 1504 [특정한 최단 경로](src/baek/gold/G4/bj1504.java) (G4), 4485 [녹색 옷 입은 애가 젤다지?](src/baek/gold/G4/bj4485.java) (G4), 11404 [플로이드](src/baek/gold/G4/bj11404.java) (G4), 13549 [숨바꼭질 3](src/baek/gold/G5/bj13549.java) (G5) |
| **MST · 유니온 파인드** | 1197 [최소 스패닝 트리](src/baek/gold/G4/bj1197.java) (G4), 1922 [네트워크 연결](src/baek/gold/G4/bj1922.java) (G4), 1717 [집합의 표현](src/baek/gold/G5/bj1717.java) (G5), 1976 [여행 가자](src/baek/gold/G4/bj1976.java) (G4), 4195 [친구 네트워크](src/baek/gold/G2/bj4195.java) (G2) |
| **위상 정렬** | 2252 [줄 세우기](src/baek/gold/G3/bj2252.java) (G3), 1766 [문제집](src/baek/gold/G2/bj1766.java) (G2), 3665 [최종 순위](src/baek/gold/G1/bj3665.java) (G1) |
| **DP** | 12865 [평범한 배낭](src/baek/gold/G5/bj12865.java) (G5), 7579 [앱](src/baek/gold/G3/bj7579.java) (G3), 9251 [LCS](src/baek/gold/G5/bj9251.java) (G5), 2565 [전깃줄](src/baek/gold/G5/bj2565.java) (G5), 14002 [가장 긴 증가하는 부분 수열 4](src/baek/gold/G4/bj14002.java) (G4), 17070 [파이프 옮기기 1](src/baek/gold/G5/bj17070.java) (G5), 1660 [캡틴 이다솜](src/baek/gold/G3/bj1660.java) (G3) |
| **이분 탐색** | 2110 [공유기 설치](src/baek/gold/G4/bj2110.java) (G4), 12015 [가장 긴 증가하는 부분 수열 2](src/baek/gold/G2/bj12015.java) (G2), 12738 [가장 긴 증가하는 부분 수열 3](src/baek/gold/G2/bj12738.java) (G2), 14003 [가장 긴 증가하는 부분 수열 5](src/baek/platinum/P5/bj14003.java) (P5) |
| **분할 정복 · 재귀** | 10830 [행렬 제곱](src/baek/gold/G4/bj10830.java) (G4), 11444 [피보나치 수 6](src/baek/gold/G2/bj11444.java) (G2), 1074 [Z](src/baek/gold/G5/bj1074.java) (G5), 11729 [하노이 탑 이동 순서](src/baek/gold/G5/bj11729.java) (G5), 2448 [별 찍기 - 11](src/baek/gold/G4/bj2448.java) (G4), 10993 [별 찍기 - 18](src/baek/gold/G4/bj10993.java) (G4) |
| **정수론 · 기하** | 11401 [이항 계수 3](src/baek/gold/G1/bj11401.java) (G1), 11758 [CCW](src/baek/gold/G5/bj11758.java) (G5), 17386 [선분 교차 1](src/baek/gold/G3/bj17386.java) (G3), 2166 [다각형의 면적](src/baek/gold/G5/bj2166.java) (G5) |
| **그래프 탐색 · 백트래킹** | 14502 [연구소](src/baek/gold/G4/bj14502.java) (G4), 2636 [치즈](src/baek/gold/G4/bj2636.java) (G4), 3055 [탈출](src/baek/gold/G4/bj3055.java) (G4), 1987 [알파벳](src/baek/gold/G4/bj1987.java) (G4), 6987 [월드컵](src/baek/gold/G4/bj6987.java) (G4), 13023 [ABCDE](src/baek/gold/G5/bj13023.java) (G5), 3109 [빵집](src/baek/gold/G3/bj3109.java) (G3) |
| **구현 · 시뮬레이션** | 15683 [감시](src/baek/gold/G3/bj15683.java) (G3), 17135 [캐슬 디펜스](src/baek/gold/G3/bj17135.java) (G3), 17281 [야구](src/baek/gold/G4/bj17281.java) (G4), 14891 [톱니바퀴](src/baek/gold/G5/bj14891.java) (G5), 16935 [배열 돌리기 3](src/baek/gold/G5/bj16935.java) (G5) |
| **자료구조 · 그리디** | 17298 [오큰수](src/baek/gold/G4/bj17298.java) (G4), 22866 [탑 보기](src/baek/gold/G3/bj22866.java) (G3), 1202 [보석 도둑](src/baek/gold/G2/bj1202.java) (G2), 2696 [중앙값 구하기](src/baek/gold/G2/bj2696.java) (G2), 1931 [회의실 배정](src/baek/gold/G5/bj1931.java) (G5) |
| **누적 합 · 투 포인터** | 10986 [나머지 합](src/baek/gold/G3/bj10986.java) (G3), 25682 [체스판 다시 칠하기 2](src/baek/gold/G4/bj25682.java) (G4), 15961 [회전 초밥](src/baek/gold/G4/bj15961.java) (G4) |

> [이항 계수 3](src/baek/gold/G1/bj11401.md)은 모듈로 곱셈 역원과 페르마의 소정리를 따로 정리해 두었습니다.

<br>

## SW 역량테스트 대비 (SWEA)

삼성 SW 역량테스트 A형 유형의 **구현·시뮬레이션·완전 탐색** 문제를 집중적으로 풀었습니다.

<details>
<summary><b>모의 SW 역량테스트 기출 17문제 보기</b></summary>

| 번호 | 문제 |
|---|---|
| 1247 | [최적 경로](src/sw/sw1247.java) |
| 1949 | [등산로 조성](src/sw/sw1949.java) |
| 1952 | [수영장](src/sw/sw1952.java) |
| 1953 | [탈주범 검거](src/sw/sw1953.java) |
| 2105 | [디저트 카페](src/sw/sw2105.java) |
| 2112 | [보호 필름](src/sw/sw2112.java) |
| 2115 | [벌꿀채취](src/sw/sw2115.java) |
| 2382 | [미생물 격리](src/sw/sw2382.java) |
| 2477 | [차량 정비소](src/sw/sw2477.java) |
| 4008 | [숫자 만들기](src/sw/sw4008.java) |
| 4012 | [요리사](src/sw/sw4012.java) |
| 4013 | [특이한 자석](src/sw/sw4013.java) |
| 4014 | [활주로 건설](src/sw/sw4014.java) |
| 5644 | [무선 충전](src/sw/sw5644.java) |
| 5648 | [원자 소멸 시뮬레이션](src/sw/sw5648.java) |
| 5650 | [핀볼 게임](src/sw/sw5650.java) |
| 5656 | [벽돌 깨기](src/sw/sw5656.java) |

</details>

| 난이도 | D1 | D2 | D3 | D4 | D5 | D6 |
|---|:---:|:---:|:---:|:---:|:---:|:---:|
| 풀이 수 | 2 | 28 | 59 | 16 | 4 | 2 |

<br>

## 백준 단계별로 풀어보기

기초부터 탄탄히 다지기 위해 백준 **단계별로 풀어보기**를 순서대로 진행했습니다.

<details>
<summary><b>단계별 진행 현황 보기</b></summary>

| 단계 | 폴더 | 풀이 수 |
|---|---|:---:|
| 입출력과 사칙연산 | [`input`](src/baek/step/input) | 11 |
| 조건문 | [`condi`](src/baek/step/condi) | 7 |
| 반복문 | [`loop`](src/baek/step/loop) | 11 |
| 1차원 배열 | [`arr`](src/baek/step/arr) | 10 |
| 문자열 | [`string`](src/baek/step/string) | 11 |
| 심화 1 | [`deep1`](src/baek/step/deep1) | 7 |
| 2차원 배열 | [`arr2`](src/baek/step/arr2) | 4 |
| 일반 수학 1 | [`math1`](src/baek/step/math1) | 7 |
| 약수, 배수와 소수 | [`divMulPrimes1`](src/baek/step/divMulPrimes1) | 6 |
| 약수, 배수와 소수 2 | [`divMulPrimes2`](src/baek/step/divMulPrimes2) | 8 |
| 브루트 포스 | [`brute`](src/baek/step/brute) | 6 |
| 정렬 | [`sort`](src/baek/step/sort) | 1 |
| 집합과 맵 | [`setMap`](src/baek/step/setMap) | 8 |
| 스택, 큐, 덱 | [`stackQueDeq`](src/baek/step/stackQueDeq) | 13 |
| 심화 2 | [`deep2`](src/baek/step/deep2) | 5 |
| 조합론 | [`combination`](src/baek/step/combination) | 2 |
| 재귀 | [`recursion`](src/baek/step/recursion) | 4 |
| 백트래킹 | [`backTracking`](src/baek/step/backTracking) | 9 |
| 동적 계획법 1 | [`dp1`](src/baek/step/dp1) | 14 |
| 이분 탐색 | [`binarySearch`](src/baek/step/binarySearch) | 1 |
| 우선순위 큐 | [`heap`](src/baek/step/heap) | 3 |
| 트리 | [`tree`](src/baek/step/tree) | 2 |
| 그래프와 순회 | [`graph`](src/baek/step/graph) | 16 |
| 최소 신장 트리 | [`mst`](src/baek/step/mst) | 1 |

</details>

<br>

## 폴더 구조

```
src
├── baek            # 백준
│   ├── platinum    # P5
│   ├── gold        # G1 ~ G5
│   ├── silver      # S1 ~ S5
│   ├── bronze      # B1 ~ B5
│   └── step        # 단계별로 풀어보기
├── sw              # SW Expert Academy
│   ├── D1 ~ D6     # 난이도별
│   └── sw*.java    # 모의 SW 역량테스트 기출
└── codeTree        # CodeTree
```

- 파일명 규칙: `bj{문제번호}.java`, `sw{문제번호}.java`
- 입출력: 빠른 입력을 위해 대부분 `BufferedReader` + `StringTokenizer` 사용
