package org.example;
import java.util.List;

public class Answer {

        private String question;
        private List<String> filledAnswers;


        public Answer(String question, List<String> filledAnswers) {
            super();
            this.question = question;
            this.filledAnswers = filledAnswers;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public List<String> getFilledAnswers() {
            return filledAnswers;
        }

        public void setFilledAnswers(List<String> filledAnswers) {
            this.filledAnswers = filledAnswers;
        }

    }


