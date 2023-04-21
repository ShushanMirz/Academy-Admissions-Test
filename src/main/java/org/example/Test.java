package org.example;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


    public class Test {


        private String title;
        private Integer duration;
        private List<String> questions;

        public Test(String title, Integer duration, List<String> questions) {
            this.title = title;
            this.duration = duration;
            this.questions = questions;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("duration")
        public Integer getDuration() {
            return duration;
        }

        @JsonProperty("duration")
        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        @JsonProperty("questions")
        public List<String> getQuestions() {
            return questions;
        }

        @JsonProperty("questions")
        public void setQuestions(List<String> questions) {
            this.questions = questions;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "title='" + title + '\'' +
                    ", duration=" + duration +
                    ", questions=" + questions +
                    '}';
        }
    }


