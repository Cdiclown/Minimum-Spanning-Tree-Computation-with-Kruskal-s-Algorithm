
# Minimum Spanning Tree Computation with Kruskal's Algorithm

## Description

The objective of this project is to develop a Java class for computing the Minimum Spanning Tree (MST) in a graph using Kruskal's algorithm. 

## Project Structure

Alongside this README, a pre-constructed package is provided, containing the minimum number of files needed to complete the project. Additionally, a test file `ProjectTest.java` is included.

### Files Provided

- `grafoMST.txt`: Contains an example of the input.
- `output.txt`: Contains the expected output from the computation.
- `ProjectTest.java`: A test file for verifying the implementation.

### Custom Implementations

As part of the project requirements, we were only allowed to use sorting algorithms written by ourselves. For this reason, I chose to implement **Merge Sort**. The choice of Merge Sort was motivated by its efficient time complexity of O(n log n) and its stable sorting nature, which is particularly useful for the edge list used in Kruskal's algorithm.

Additionally, I implemented the **Quick Union with Rank** for the union-find structure. The choice was driven by its efficient performance in terms of both time and space, especially when handling the union and find operations on large disjoint sets, which is crucial for the performance of Kruskal's algorithm.

### How to Use

1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```
2. Open the project in your preferred Java IDE.
3. Implement the Kruskal's algorithm in the provided Java class.
4. Run the `ProjectTest.java` to test the implementation.

### Dependencies

- Java Development Kit (JDK)

### Notes
- This project was a small individual assignment for the Algorithms and Data Structures course of the 2023/2024 academic year, and I achieved the maximum score for this project.

