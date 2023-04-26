package org.example;
public class Test {


        private String title;
        private Integer duration;

        public Test(String title, Integer duration) {
            this.title = title;
            this.duration = duration;
        }


        public String getTitle() {
            return title;
        }


        public void setTitle(String title) {
            this.title = title;
        }


        public Integer getDuration() {
            return duration;
        }


        public void setDuration(Integer duration) {
            this.duration = duration;
        }


        @Override
        public String toString() {
            return "Test{" +
                    "title='" + title + '\'' +
                    ", duration=" + duration +
                    '}';
        }
    }


