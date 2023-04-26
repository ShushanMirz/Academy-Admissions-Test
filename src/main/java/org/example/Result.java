package org.example;

import java.util.List;

public class Result {


        private String applicant;
        private String test;
        private String phase;
        private List<Answer> answers;



        public Result(String applicant, String test, String phase, List<Answer> answers) {
            super();
            this.applicant = applicant;
            this.test = test;
            this.phase = phase;
            this.answers = answers;
        }

        public String getApplicant() {
            return applicant;
        }

        public void setApplicant(String applicant) {
            this.applicant = applicant;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public String getPhase() {
            return phase;
        }

        public void setPhase(String phase) {
            this.phase = phase;
        }

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

    }

