# ken-algorithm

A record of studying and implementing data structures and algorithms in Java.
I built the fundamentals through Baekjoon's step-by-step track, then strengthened problem-solving skills with tiered problems and Samsung SW Competency Test problems.

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=openjdk&logoColor=white)
![Problems](https://img.shields.io/badge/solved-476_problems-0076C0?style=flat-square)
![Period](https://img.shields.io/badge/2024.12_~_2025.10-563_commits-success?style=flat-square)

<br>

## What I Can Do

| Area | Topics |
|---|---|
| **Data Structures** | Stack (from scratch) · Queue/Deque · Priority Queue · Hash · TreeSet · Union-Find · Graph/Tree representation |
| **Graphs** | BFS/DFS · Dijkstra · Floyd-Warshall · Kruskal · Topological Sort · Bipartite check |
| **Search** | Brute Force · Backtracking · Binary Search · Parametric Search · Two Pointers · Sliding Window |
| **Dynamic Programming** | Recurrence design · Memoization · 0-1 Knapsack · LIS (O(N log N) + reconstruction) · LCS · Kadane |
| **Math** | Fast exponentiation · Matrix exponentiation · Sieve of Eratosthenes · Euclidean GCD · Modular inverse · CCW |
| **Implementation** | Simulation · Array rotation · Samsung SW Competency Test (A-level) problems |

<br>

## Data Structures

### Stack
- Implemented push / pop / peek from scratch with an array and a `top` index
- Monotonic stack to find the "next greater element" for every index in O(N)
- Bracket matching with a stack

Solutions: [Array Stack](src/baek/step/stackQueDeq/ArrayStack.java) · [Parentheses (9012)](src/baek/step/stackQueDeq/bj9012.java) · [Next Greater Element (17298)](src/baek/gold/G4/bj17298.java) · [Tower (2493)](src/baek/gold/G5/bj2493.java) · [Tower View (22866)](src/baek/gold/G3/bj22866.java)

<details>
<summary>Key code: monotonic stack</summary>

```java
// The stack holds indices whose next greater element hasn't been found yet
for (int i = 1; i < N; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        NGE[stack.pop()] = arr[i];
    }
    stack.push(i);
}
```
</details>

### Queue · Deque
- Queue/deque operations with `ArrayDeque`, used as the backbone of BFS
- Two deques as left/right buffers around a cursor for O(1) insert and delete
- Circular queue simulation (Josephus, card discarding)

Solutions: [Queue 2 (18258)](src/baek/step/stackQueDeq/bj18258.java) · [Deque (10866)](src/baek/step/stackQueDeq/bj10866.java) · [Josephus Problem 0 (11866)](src/baek/step/stackQueDeq/bj11866.java) · [Editor (1406)](src/baek/silver/S2/bj1406.java)

### Priority Queue (Heap)
- Custom ordering with `Comparable` / `Comparator`, max heap via `Collections.reverseOrder()`
- A max heap and a min heap together to maintain a running median
- Combined with greedy to repeatedly pick the best available candidate

Solutions: [Min Heap (1927)](src/baek/step/heap/bj1927.java) · [Absolute Value Heap (11286)](src/baek/step/heap/bj11286.java) · [Running Median (2696)](src/baek/gold/G2/bj2696.java) · [Jewel Thief (1202)](src/baek/gold/G2/bj1202.java)

### Hash · Sorted Set
- O(1) lookups with `HashMap` / `HashSet`, two-way mapping between strings and indices
- Frequency counting
- `TreeSet` to remove duplicates while keeping elements sorted

Solutions: [Pokémon Master (1620)](src/baek/step/setMap/bj1620.java) · [Number Cards 2 (10816)](src/baek/step/setMap/bj10816.java) · [N and M (11) (15665)](src/baek/silver/S2/bj15665.java)

### Union-Find
- Path compression plus union by size for near O(1) `find`
- Tracking set sizes and detecting cycles (used in Kruskal)
- Mapping names (strings) to indices with a `HashMap` before union

Solutions: [Set Representation (1717)](src/baek/gold/G5/bj1717.java) · [Let's Travel (1976)](src/baek/gold/G4/bj1976.java) · [Friend Network (4195)](src/baek/gold/G2/bj4195.java) · [Disjoint Set (3289)](src/sw/D4/sw3289.java)

<details>
<summary>Key code: path compression + union by size</summary>

```java
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // path compression
    return parent[x];
}

boolean union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra == rb) return false;                // already in the same set (cycle)
    if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
    parent[rb] = ra;                           // attach the smaller set to the larger
    size[ra] += size[rb];
    return true;
}
```
</details>

### Graph · Tree Representation
- Graphs as adjacency lists (`List<Integer>[]`), adjacency matrices, and edge classes (`Edge implements Comparable`)
- Pre-order, in-order, and post-order tree traversal; recording parents while traversing from the root

Solutions: [DFS and BFS (1260)](src/baek/step/graph/bj1260.java) · [Tree Traversal (1991)](src/baek/step/tree/bj1991.java) · [Find Parent in Tree (11725)](src/baek/step/tree/bj11725.java)

<br>

## Algorithms

### Graph Traversal (BFS · DFS)
- Shortest distance on grids with BFS; multi-source BFS by enqueuing all starting points at once
- BFS on 3D grids
- BFS with an extra state dimension: `visited[r][c][hasBrokenWall]`
- Bipartite check with two-coloring, counting connected components
- BFS combined with simulation (spreading, melting, simultaneous movement)

Solutions: [Maze Exploration (2178)](src/baek/step/graph/bj2178.java) · [Tomato (7576)](src/baek/step/graph/bj7576.java) · [Tomato (3D) (7569)](src/baek/step/graph/bj7569.java) · [Breaking Walls (2206)](src/baek/step/graph/bj2206.java) · [Bipartite Graph (1707)](src/baek/step/graph/bj1707.java) · [Laboratory (14502)](src/baek/gold/G4/bj14502.java) · [Cheese (2636)](src/baek/gold/G4/bj2636.java) · [Escape (3055)](src/baek/gold/G4/bj3055.java)

### Shortest Path
- **Dijkstra** O(E log V): priority queue, skipping stale entries
- Paths through required waypoints by splitting into several Dijkstra runs
- Treating a grid as a weighted graph and running Dijkstra on it
- **Floyd-Warshall** O(V³): shortest distances between all pairs

Solutions: [Shortest Path (1753)](src/baek/gold/G4/bj1753.java) · [Specific Shortest Path (1504)](src/baek/gold/G4/bj1504.java) · [Zelda (4485)](src/baek/gold/G4/bj4485.java) · [Floyd (11404)](src/baek/gold/G4/bj11404.java) · [People Network 2 (1263)](src/sw/D6/sw1263.java)

<details>
<summary>Key code: Dijkstra</summary>

```java
dist[K] = 0;
pq.add(new State(K, 0));
while (!pq.isEmpty()) {
    State cur = pq.poll();
    if (cur.d != dist[cur.v]) continue; // skip stale entries
    for (Edge e : g[cur.v]) {
        long nd = cur.d + e.w;
        if (nd < dist[e.to]) {          // relaxation
            dist[e.to] = nd;
            pq.add(new State(e.to, nd));
        }
    }
}
```
</details>

### Minimum Spanning Tree
- **Kruskal** O(E log E): sort edges by weight and pick them while Union-Find prevents cycles

Solutions: [Minimum Spanning Tree (1197)](src/baek/gold/G4/bj1197.java) · [Network Connection (1922)](src/baek/gold/G4/bj1922.java) · [Hanaro (1251)](src/sw/D4/sw1251.java)

### Topological Sort
- Kahn's algorithm based on in-degrees, O(V + E)
- Combined with a priority queue to pick the earliest valid order
- Using the queue size to detect whether the result is unique (`?`) or contains a cycle (`IMPOSSIBLE`)

Solutions: [Line Up (2252)](src/baek/gold/G3/bj2252.java) · [Workbook (1766)](src/baek/gold/G2/bj1766.java) · [Final Ranking (3665)](src/baek/gold/G1/bj3665.java) · [Task Order (1267)](src/sw/D6/sw1267.java)

### Brute Force · Backtracking
- Permutations / combinations / with repetition, implemented by hand (the entire N and M series)
- Subset enumeration
- Pruning: stop when the current cost already reaches the best answer; diagonal conflict checks

Solutions: [N and M (1) (15649)](src/baek/step/backTracking/bj15649.java) · [N and M (12) (15666)](src/baek/silver/S2/bj15666.java) · [Doyoung's Delicious Food (2961)](src/baek/silver/S2/bj2961.java) · [Traveling Salesman 2 (10971)](src/baek/silver/S2/bj10971.java) · [N-Queen (9663)](src/baek/step/backTracking/bj9663.java) · [Sudoku (2580)](src/baek/step/backTracking/bj2580.java) · [Alphabet (1987)](src/baek/gold/G4/bj1987.java)

### Dynamic Programming
- Designing recurrences; bottom-up and top-down (memoization) implementations
- **0-1 Knapsack**: space-optimized with a 1D array updated in reverse, plus a variant that uses cost as the DP axis
- **LIS**: both the O(N²) DP and the O(N log N) binary search approach, including reconstruction of the actual sequence
- LCS, bitonic subsequence, maximum subarray sum (Kadane)

Solutions: [Make It One (1463)](src/baek/step/dp1/bj1463.java) · [Fun Function Execution (9184)](src/baek/step/dp1/bj9184.java) · [Ordinary Knapsack (12865)](src/baek/gold/G5/bj12865.java) · [App (7579)](src/baek/gold/G3/bj7579.java) · [LIS 5 (14003)](src/baek/platinum/P5/bj14003.java) · [LCS (9251)](src/baek/gold/G5/bj9251.java) · [Longest Bitonic Subsequence (11054)](src/baek/step/dp1/bj11054.java) · [Maximum Subarray Sum (1912)](src/baek/step/dp1/bj1912_Kadane.java)

<details>
<summary>Key code: 0-1 knapsack (1D)</summary>

```java
// Iterate weight j from high to low so the same item is never taken twice
for (int i = 1; i <= N; i++) {
    for (int j = K; j >= weight[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + cost[i]);
    }
}
```
</details>

### Binary Search
- Lower bound implemented by hand on sorted arrays
- **Parametric search**: turning "find the maximum value that satisfies a condition" into a decision problem
- Applied to optimize LIS to O(N log N)

Solutions: [Cutting LAN Cables (1654)](src/baek/step/binarySearch/bj1654.java) · [LIS 2 (12015)](src/baek/gold/G2/bj12015.java) · [LIS 3 (12738)](src/baek/gold/G2/bj12738.java)

### Greedy
- Choosing a sort key and making the best choice at each step (e.g., sorting meetings by end time)
- Greedy combined with a priority queue

Solutions: [Meeting Room Assignment (1931)](src/baek/gold/G5/bj1931.java) · [Gas Station (13305)](src/baek/silver/S3/bj13305.java) · [Lost Parentheses (1541)](src/baek/silver/S2/bj1541.java) · [Jewel Thief (1202)](src/baek/gold/G2/bj1202.java)

### Prefix Sum · Two Pointers · Sliding Window
- 1D / 2D prefix sums for O(1) range sum queries
- Prefix sums of remainders combined with counting
- Fixed-size window over a circular array; two pointers after sorting

Solutions: [Range Sum 4 (11659)](src/baek/silver/S3/bj11659.java) · [Range Sum 5 (11660)](src/baek/silver/S1/bj11660.java) · [Repaint Chessboard 2 (25682)](src/baek/gold/G4/bj25682.java) · [Remainder Sum (10986)](src/baek/gold/G3/bj10986.java) · [Sequence (2559)](src/baek/silver/S3/bj2559.java) · [Rotating Sushi (15961)](src/baek/gold/G4/bj15961.java) · [Hanbin and Spot Mart (9229)](src/sw/D3/sw9229.java)

### Divide and Conquer
- Fast exponentiation in O(log N); Fibonacci in O(log N) with matrix exponentiation
- Recursively splitting regions into 4 or 9 parts (quad tree, Z order, paper counting)
- Recursive pattern printing (star patterns, Tower of Hanoi)

Solutions: [Multiplication (1629)](src/baek/silver/S1/bj1629.java) · [Matrix Power (10830)](src/baek/gold/G4/bj10830.java) · [Fibonacci 6 (11444)](src/baek/gold/G2/bj11444.java) · [Quad Tree (1992)](src/baek/silver/S1/bj1992.java) · [Z (1074)](src/baek/gold/G5/bj1074.java) · [Number of Papers (1780)](src/baek/silver/S2/bj1780.java) · [Tower of Hanoi (11729)](src/baek/gold/G5/bj11729.java)

### Math
- Primality test in O(√N), Sieve of Eratosthenes
- Greatest common divisor with the Euclidean algorithm
- Binomial coefficients with Pascal's triangle; modular inverse with Fermat's little theorem ([notes, Korean](src/baek/gold/G1/bj11401.md))
- Geometry: CCW, segment intersection, polygon area with the shoelace formula

Solutions: [Goldbach Partition (17103)](src/baek/step/divMulPrimes2/bj17103.java) · [Street Trees (2485)](src/baek/step/divMulPrimes2/bj2485.java) · [Binomial Coefficient 2 (11051)](src/baek/silver/S2/bj11051.java) · [Binomial Coefficient 3 (11401)](src/baek/gold/G1/bj11401.java) · [CCW (11758)](src/baek/gold/G5/bj11758.java) · [Segment Intersection 1 (17386)](src/baek/gold/G3/bj17386.java) · [Polygon Area (2166)](src/baek/gold/G5/bj2166.java)

### Implementation · Simulation
- Breaking problems with many interacting conditions into clear steps
- Array rotation, gear rotation, simultaneous movement
- Samsung SW Competency Test (A-level) style problems combining brute force and simulation

Solutions: [Surveillance (15683)](src/baek/gold/G3/bj15683.java) · [Gears (14891)](src/baek/gold/G5/bj14891.java) · [Castle Defense (17135)](src/baek/gold/G3/bj17135.java) · [Baseball (17281)](src/baek/gold/G4/bj17281.java) · [Array Rotation 3 (16935)](src/baek/gold/G5/bj16935.java)

<details>
<summary>17 Samsung SW Competency Test mock problems</summary>

[Optimal Path (1247)](src/sw/sw1247.java) · [Hiking Trail (1949)](src/sw/sw1949.java) · [Swimming Pool (1952)](src/sw/sw1952.java) · [Fugitive Capture (1953)](src/sw/sw1953.java) · [Dessert Cafe (2105)](src/sw/sw2105.java) · [Protective Film (2112)](src/sw/sw2112.java) · [Honey Harvest (2115)](src/sw/sw2115.java) · [Microbe Isolation (2382)](src/sw/sw2382.java) · [Car Repair Shop (2477)](src/sw/sw2477.java) · [Make Numbers (4008)](src/sw/sw4008.java) · [Chef (4012)](src/sw/sw4012.java) · [Peculiar Magnets (4013)](src/sw/sw4013.java) · [Runway Construction (4014)](src/sw/sw4014.java) · [Wireless Charging (5644)](src/sw/sw5644.java) · [Atom Annihilation (5648)](src/sw/sw5648.java) · [Pinball Game (5650)](src/sw/sw5650.java) · [Brick Breaker (5656)](src/sw/sw5656.java)
</details>

<br>

## Learning Path

| Stage | Description | Solved |
|---|---|:---:|
| **1. Fundamentals** | Baekjoon step-by-step track, 24 stages (from I/O to minimum spanning trees) | 168 |
| **2. Advanced** | Baekjoon tiered problems (Platinum 1 · Gold 61 · Silver 54 · Bronze 63) | 179 |
| **3. Practice** | SW Expert Academy D1–D6 and Samsung SW Competency Test mock problems | 128 |
| | CodeTree | 1 |
| **Total** | Dec 2024 – Oct 2025 · 563 commits | **476** |

> Baekjoon ID: `gjaku1031` (Baekjoon has shut down, so each problem links to my solution code instead of the problem page.)

<br>

## Next Goals

- Segment tree, Fenwick tree
- LCA (Lowest Common Ancestor)
- String algorithms (KMP, Trie)
- Bitmask DP

<br>

## Folder Structure

```
src
├── baek          # Baekjoon
│   ├── step      # Step-by-step track
│   ├── bronze    # B5 ~ B1
│   ├── silver    # S5 ~ S1
│   ├── gold      # G5 ~ G1
│   └── platinum  # P5
├── sw            # SW Expert Academy (D1 ~ D6; root holds the competency test mock problems)
└── codeTree      # CodeTree
```
