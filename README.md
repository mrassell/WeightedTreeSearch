# 🌳 Modified BFS: Weighted Tree Search

**Data Structures Project – Fall 2024**  
Instructor: [Professor Name]  
Student: Maheen Rassell  

---

## 📄 Overview

This project implements a variation of the **Breadth-First Search (BFS)** algorithm on a binary tree with weighted edges. Unlike traditional BFS that finds the shortest path in terms of hops, this version finds the path with the **minimum cumulative distance** — similar to Dijkstra's algorithm but adapted to trees using a **min-heap**.

The goal is to find the closest occurrence of a target node (usually `"*"`) based on total edge weight from the root.

---

## 🧠 Core Concepts

- Parses a custom tree input format using a **stack-based parser**
- Stores distances between parent and child nodes explicitly
- Uses a **min-heap priority queue** to explore the tree by increasing cumulative distance
- Implements `Comparable` in `TreeNode` for heap sorting
- Returns the **shortest distance** to the target node, or throws an exception if not found

---

## 🔧 Input Format

- Input is provided through standard input as a single line of tokens.
- Each node is defined by: `label distance`
- Parentheses `(` and `)` indicate subtrees
- Every non-leaf node has **exactly two children**

Example:
