import java.util.ArrayList;

public class Quiz {
    private String title;
    private ArrayList<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
