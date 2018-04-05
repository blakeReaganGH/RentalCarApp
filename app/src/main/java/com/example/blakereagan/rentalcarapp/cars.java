package com.example.blakereagan.rentalcarapp;

import java.text.DecimalFormat;

public class cars {
        private int id;
        private String name;
        private String brand;
        private String color;
        private double rentalcost;
        private int image;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        private String url;

        public cars(int id, String name, String brand,
                          String color, double rentalcost, int image, String url) {
            this.id = id;
            this.name = name;
            this.brand = brand;
            this.color = color;
            this.rentalcost = rentalcost;
            this.image = image;
            this.url = url;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getRentalcost() {
            return rentalcost;
        }

        public void setRentalcost(double rentalcost) {
            this.rentalcost = rentalcost;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return name;
        }
    }
