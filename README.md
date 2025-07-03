Description:

This is a Java command-line application that allows users to create and take multiple-choice quizzes on various topics.

The application supports:

Creating new quizzes

Adding questions with options and specifying correct answers

Taking quizzes interactively and receiving scores with feedback

How to run:

Using IntelliJ IDEA

Open the project in IntelliJ IDEA.

Copy the files (QuizGenerator.java, Quiz.java, Question.java) into your src folder.

Run QuizGenerator.java.

Use the console menu to create quizzes, add questions, and take quizzes.

Using terminal (Windows, macOS, Linux)

Copy
Edit
javac QuizGenerator.java Quiz.java Question.java
java QuizGenerator
Project structure

Copy
Edit
week1-tasks/
├── QuizGenerator.java
├── Quiz.java
├── Question.java
└── README.md
Menu options

Copy
Edit
1. Create new quiz         → Create a quiz with a title
2. Add question to quiz    → Add questions to an existing quiz
3. Take a quiz             → Attempt a quiz and view your score
4. Exit                    → Exit the program
Features

Supports multiple quizzes and multiple questions per quiz

Multiple-choice options

Score tracking and detailed feedback

Simple console-based interface

Author

Pramath Hegde
