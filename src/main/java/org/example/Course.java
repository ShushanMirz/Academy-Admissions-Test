package org.example;

    public class Course {

        private String title;
        private String description;
        private Resources resources;


        public Course(String title, String description, Resources resources) {
            super();
            this.title = title;
            this.description = description;
            this.resources = resources;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Resources getResources() {
            return resources;
        }

        public void setResources(Resources resources) {
            this.resources = resources;
        }

    }


