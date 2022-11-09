package com.valya.homework.section14.coding11;

/*studentIdList = {1001, 1002}

studentsGrades = { { 'A', 'A', 'A', 'B' }

int[] studentIdList = {1001, 1002, 1003};

char[][] studentsGrades = {{'A', 'A', 'A', 'B'}, {'A', 'B', 'B'}, {'A','B', 'B',  'A',  'B', 'A'}};

*/

import com.valya.homework.section14.myException.PerimeterException;

import java.util.Arrays;

public class StudentUtil {

    public static void main(String[] args) throws MissingGradeException {

        int[] studentIdList = {1001, 1002, 1003};

        char[][] studentsGrades = {{'A', 'A', 'B', 'B'}, {'A', 'C', 'B'}, {'A', 'B', 'C', 'A', 'B', 'A'}};

        //System.out.println(Arrays.toString(calculateGPA(studentIdList, studentsGrades)));

        int[] gpaList = getStudentsByGPA(3.2,3.5,studentIdList,studentsGrades);

        System.out.println(Arrays.toString(gpaList));

    }

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws IllegalArgumentException, MissingGradeException {

        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
                    + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {

                    throw new MissingGradeException("This student is yet to receive a grade: " + studentIdList[i], studentIdList[i]);
                }
            }

            gpaList[i] = gpa / studentsGrades[i].length;
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades)  {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList;

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            //System.out.println("e.toString(): " + e);
            System.out.println("StudentId with problem : " + e.getStudentId());
            System.out.println(e.getMessage());
            throw new InvalidDataException(e);
        }


        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}