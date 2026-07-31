/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labbookingreport;

/**
 *
 * @author Luleya Ghebru
 */


public class LabBookingReport {

    public static void main(String[] args) {

        // ---------------------------------------------------------
        // 1. Declare and populate the one-dimensional array of lab names
        // ---------------------------------------------------------
        String[] labNames = { "PROGRAMMING", "NETWORKING", "MULTIMEDIA" };

        // Row labels for the four academic weeks
        String[] weekLabels = { "WEEK 1", "WEEK 2", "WEEK 3", "WEEK 4" };

        // ---------------------------------------------------------
        // 2. Declare and populate the two-dimensional array of bookings
        //    Rows = weeks, Columns = laboratories (in the same order as labNames)
        // ---------------------------------------------------------
        int[][] bookings = {
                { 32, 18, 24 }, // Week 1
                { 28, 25, 19 }, // Week 2
                { 35, 20, 27 }, // Week 3
                { 30, 22, 21 }  // Week 4
        };

        // ---------------------------------------------------------
        // 3. Print the report header
        // ---------------------------------------------------------
        System.out.println("COMPUTER LAB BOOKING REPORT");
        System.out.println("--------------------------------------------------------------");

        // Print column headings: "WEEK" followed by each lab name
        System.out.printf("%-10s", "WEEK");
        for (int lab = 0; lab < labNames.length; lab++) {
            System.out.printf("%-15s", labNames[lab]);
        }
        System.out.println();

        // ---------------------------------------------------------
        // 4. Print each week's row with booking figures in correct positions
        // ---------------------------------------------------------
        for (int week = 0; week < bookings.length; week++) {
            System.out.printf("%-10s", weekLabels[week]);
            for (int lab = 0; lab < bookings[week].length; lab++) {
                System.out.printf("%-15d", bookings[week][lab]);
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------");

        // ---------------------------------------------------------
        // 5. Calculate totals, averages, minimum and maximum per laboratory
        // ---------------------------------------------------------
        int numLabs = labNames.length;
        int numWeeks = bookings.length;

        int[] totals = new int[numLabs];
        double[] averages = new double[numLabs];
        int[] minimums = new int[numLabs];
        int[] maximums = new int[numLabs];

        for (int lab = 0; lab < numLabs; lab++) {
            int total = 0;
            int min = bookings[0][lab];
            int max = bookings[0][lab];

            for (int week = 0; week < numWeeks; week++) {
                int value = bookings[week][lab];
                total += value;

                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }

            totals[lab] = total;
            averages[lab] = (double) total / numWeeks;
            minimums[lab] = min;
            maximums[lab] = max;
        }

        // ---------------------------------------------------------
        // 6. Display TOTAL, AVERAGE, MINIMUM and MAXIMUM rows
        // ---------------------------------------------------------
        System.out.printf("%-10s", "TOTAL");
        for (int lab = 0; lab < numLabs; lab++) {
            System.out.printf("%-15d", totals[lab]);
        }
        System.out.println();

        System.out.printf("%-10s", "AVERAGE");
        for (int lab = 0; lab < numLabs; lab++) {
            System.out.printf("%-15.2f", averages[lab]);
        }
        System.out.println();

        System.out.printf("%-10s", "MINIMUM");
        for (int lab = 0; lab < numLabs; lab++) {
            System.out.printf("%-15d", minimums[lab]);
        }
        System.out.println();

        System.out.printf("%-10s", "MAXIMUM");
        for (int lab = 0; lab < numLabs; lab++) {
            System.out.printf("%-15d", maximums[lab]);
        }
        System.out.println();
    }
}