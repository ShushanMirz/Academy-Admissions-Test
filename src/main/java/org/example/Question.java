package org.example;
import java.util.List;

    public class Question {
        private String test;
        private String type;
        private String question;
        private Boolean required;
        private List<String> answers;
        private List<String> correctAnswers;
        private int maxScore;
        private String questionImage;

        public Question(String test, String type, String question, Boolean required, List<String> answers, List<String> correctAnswers, int maxScore, String questionImage) {
            super();
            this.test = test;
            this.type = type;
            this.question = question;
            this.required = required;
            this.answers = answers;
            this.correctAnswers = correctAnswers;
            this.maxScore = maxScore;
            this.questionImage = questionImage;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public Boolean getRequired() {
            return required;
        }

        public void setRequired(Boolean required) {
            this.required = required;
        }

        public List<String> getAnswers() {
            return answers;
        }

        public void setAnswers(List<String> answers) {
            this.answers = answers;
        }

        public List<String> getCorrectAnswers() {
            return correctAnswers;
        }

        public void setCorrectAnswers(List<String> correctAnswers) {
            this.correctAnswers = correctAnswers;
        }

        public Integer getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(int maxScore) {
            this.maxScore = maxScore;
        }

        public String getQuestionImage() {
            return questionImage;
        }

        public void setQuestionImage(String questionImage) {
            this.questionImage = questionImage;
        }


        @Override
        public String toString() {
            return "Question{" +
                    "test='" + test + '\'' +
                    ", type='" + type + '\'' +
                    ", question='" + question + '\'' +
                    ", required=" + required +
                    ", answers=" + answers +
                    ", correctAnswers=" + correctAnswers +
                    ", maxScore=" + maxScore +
                    ", questionImage='" + questionImage + '\'' +
                    '}';
        }
    }

