package codsoft;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class quiz 
{
    private int score,not;
    private int currentQuestionIndex;
    private Question[] questions;
    private Timer timer;

    public quiz(Question[] questions) 
    {
        this.questions = questions;
        this.score = 0;
        this.not=0;
        this.currentQuestionIndex = 0;
        this.timer = new Timer();
    }

    public void startQuiz() 
    {
        System.out.println("Welcome to the Quiz!\n");
        for (Question question : questions) 
        {
            presentQuestion(question);
            waitForAnswer(question);
        }

        showResult();
    }

    private void presentQuestion(Question question) 
    {
        System.out.println(question.getQuestionText());

        char option = 'A';
        for (String choice : question.getOptions()) 
        {
            System.out.println(option + ") " + choice);
            option++;
        }

        startTimer(question);
    }

    private void waitForAnswer(Question question) 
    {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toUpperCase();

        // Check if the answer is correct
        if (userAnswer.equals(question.getCorrectAnswer())) 
        {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer() + ".\n");
            not++;
        }

        
        timer.cancel();
        timer.purge();

        
        currentQuestionIndex++;
    }

    private void startTimer(Question question)
    {
        timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                System.out.println("\nTime's up! The correct answer is " + question.getCorrectAnswer() + ".\n");
                currentQuestionIndex++;
            }
        }, question.getTimeLimit() * 1000); 
    }

    private void showResult() 
    {
    	System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
        System.out.println("Correct answers: "+score);
        System.out.println("Incorrect answers : "+not);
    }
    }


class Question 
{
    private String questionText;
    private String[] options;
    private String correctAnswer;
    private int timeLimit;

    public Question(String questionText, String[] options, String correctAnswer, int timeLimit) 
    {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer.toUpperCase();
        this.timeLimit = timeLimit;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public String[] getOptions()
    {
        return options;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }

    public int getTimeLimit()
    {
        return timeLimit;
    }

    public boolean isAnswerCorrect() 
    {
        
        return false;
    }
}
--------------------------------------------------------------------------------------------------------------------------
package codsoft;

public class main1 
{
    public static void main(String[] args) 
    {
        Question[] questions = {
            new Question("What is the capital of France?",
                new String[]{"Berlin", "Paris", "Madrid", "Rome"},
                "B", 10),
            new Question("Which country has highest population?",
            	new String[] {"China","Russia","India","America" },"C",10),
            new Question("Which country is largest country ?",
                	new String[] {"China","Russia","India","America" },"B",10),
            new Question("Which planet has the most moons? ",
            		new String[] {"Saturn","Earth","Neptune","Mercury"},"A",10)
        };

        quiz q = new quiz(questions);
        q.startQuiz();
    }
}
