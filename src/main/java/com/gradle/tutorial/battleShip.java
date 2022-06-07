package com.gradle.tutorial;


public class battleShip {
    public static void main(String[] args) {}
    public static boolean isValidField(int[][] field) {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[0].length; x++) {
                int curr = field[y][x];
                int topLeft = y != 0 && x != 0 ? field[y - 1][x - 1] : 0;
                int topRight = y != 0 && x < field[0].length - 1 ? field[y - 1][x + 1] : 0;
                int bottomLeft = x != 0 && y < field.length - 1 ? field[y + 1][x - 1] : 0;
                int bottomRight = x < field[0].length - 1 && y < field.length - 1 ? field[y + 1][x + 1] : 0;

                if (curr == 1) {
                    if (topLeft == 1 || topRight == 1) {
                        return false;
                    }
                    if (bottomLeft == 1 || bottomRight == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static int calcShipsCount (int[][] field){
        if (field.length == 0) {
            return 0;
        }
        int rows = field.length;
        int cols = field[0].length;
        int shipsCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int curr = field[row][col];
                int left = col != 0 ? field[row][col - 1] : 0;
                int right = col != cols - 1 ? field[row][col + 1] : 0;
                int top = row != 0 ? field[row - 1][col] : 0;
                int bottom = row != rows - 1 ? field[row + 1][col] : 0;

                if (curr == 1) {
                    if (left == 0 && top == 0 && bottom == 1) {
                        shipsCount++;
                    }
                    if (left == 0 && bottom == 0 && right == 1) {
                        shipsCount++;
                    }
                    if (left == 0 && right == 0 && bottom == 0 && top == 0) {
                        shipsCount++;
                    }
                }
            }
        }
        return shipsCount;
    }
}




