package org.example;
public class Test {


        private String title;
        private int duration;

        public Test(String title, int duration) {
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


        public void setDuration(int duration) {
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


