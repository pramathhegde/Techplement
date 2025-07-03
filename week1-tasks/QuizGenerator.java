import java.util.ArrayList;
import java.util.Scanner;

public class QuizGenerator {
    private static ArrayList<Quiz> quizzes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    addQuestionToQuiz();
                    break;
                case 3:
                    takeQuiz();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Quiz Generator!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Quiz Generator Menu ---");
        System.out.println("1. Create new quiz");
        System.out.println("2. Add question to quiz");
        System.out.println("3. Take a quiz");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    private static void createQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        quizzes.add(new Quiz(title));
        System.out.println("Quiz created successfully!");
    }

    private static void addQuestionToQuiz() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available. Create a quiz first.");
            return;
        }

        showQuizList();
        System.out.print("Select quiz number: ");
        int quizIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (quizIndex < 0 || quizIndex >= quizzes.size()) {
            System.out.println("Invalid quiz number.");
            return;
        }

        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();

        System.out.print("How many options? ");
        int numOptions = Integer.parseInt(scanner.nextLine());

        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options.add(scanner.nextLine());
        }

        System.out.print("Enter correct option number (1 to " + numOptions + "): ");
        int correctOption = Integer.parseInt(scanner.nextLine()) - 1;

        quizzes.get(quizIndex).addQuestion(new Question(questionText, options, correctOption));
        System.out.println("Question added successfully!");
    }

    private static void takeQuiz() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
            return;
        }

        showQuizList();
        System.out.print("Select quiz number: ");
        int quizIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (quizIndex < 0 || quizIndex >= quizzes.size()) {
            System.out.println("Invalid quiz number.");
            return;
        }

        Quiz quiz = quizzes.get(quizIndex);
        ArrayList<Question> questions = quiz.getQuestions();
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            ArrayList<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (1 to " + options.size() + "): ");
            int userAnswer = Integer.parseInt(scanner.nextLine()) - 1;

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer: " + options.get(q.getCorrectOptionIndex()));
            }
        }

        System.out.println("\nQuiz finished! Your score: " + score + "/" + questions.size());
    }

    private static void showQuizList() {
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).getTitle());
        }
    }
}
