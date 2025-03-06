# **Sudoku Solver** 🔢  

Hello world! This Java project consists of an implementation of a **Sudoku Solver** using **Backtracking Search**. This repository includes a command-line client that allows you to input a Sudoku puzzle and solve it interactively.  

Before anything, note that this work was done by two university students, so don't take it too seriously because, in reality, we are just having fun doing something coding-related. Feel free to make any comments in relation to code improvements and feel free to use it as you please.  

---

## **Table of Contents** 📑  

- [Features](#features)  
- [Project Structure](#project-structure)  
- [Installation & Setup](#installation--setup)  
- [License](#license)  
- [Acknowledgments](#acknowledgments)  

---

## **Features** 🚀  

- **Interactive Command-Line Interface**:  
  Solve Sudoku puzzles through an easy-to-use CLI.  

- **Backtracking Algorithm**:  
  - **Finds the next empty cell**: Detects empty spots and attempts valid numbers.  
  - **Validates moves**: Ensures compliance with Sudoku rules (rows, columns, and 3x3 boxes).  
  - **Recursive search**: Tries all possibilities and backtracks when needed.  

---

## **Project Structure** 🗂️  

**SUDOKU-STACK/**  
- **src/**  
  - **SudokuSolver.java** – CLI client for inputting and solving Sudoku puzzles  
  - **SudokuState.java** – Core logic for board representation and solving  
  - **StackList.java** – Custom stack implementation for the solver  
- **README.md** – This file – your guide to the project  
- **LICENSE** – Project license (MIT)  

---

## **Installation & Setup** 🔧  

### **Prerequisites** ✅  

- **Java 8** or later installed on your machine.  
- **Git** for cloning the repository.  

### **Steps to Install** 🛠️  

1. **Clone the repository**:  
    ```bash
    git clone https://github.com/PantocaPipoca/Sudoku-Solver-In-Java.git
    ```  
2. **Navigate to the project directory**:  
    ```bash
    cd Sudoku-Solver-In-Java/SUDOKU-STACK
    ```  
3. **Compile the project**:  
    ```bash
    mkdir bin
    javac -d bin src/*.java
    ```  
4. **Run the Sudoku Solver**:  
    ```bash
    java -cp bin SudokuSolver
    ```  

---

## **License** 📜  

This project is licensed under the **MIT License**. For more details, see the [LICENSE](LICENSE) file.  

---

## **Acknowledgments** 🙏  

This project was done by two university students Daniel Pantyukhov and Valentim Khakhitva.  

---

Feel free to reach out with any questions or suggestions.
