/*
Java program to check if a Sudoku board is solved.
Takes 2D-array board as input and outputs True(board is
solved) or False(board is not solved).
*/

import java.util.*;

public class SudokuChecker {
  public static void main(String[] args) {
    int[][] board = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
    System.out.println(solved(board));
  }

  public static boolean solved(int[][] board){
      //rows and columns
      int[] row = new int[9];
      int[] col = new int[9];
      for (int r=0; r<board.length; r++) {
        for (int c=0; c<board.length; c++) {
          row[c] = board[r][c];
          col[c] = board[c][r];
        }
        if (complete(row) == false || complete(col) == false){
          return false;
        }
        else {
          return true;
        }
      }
      //squares
      for (int r=0; r<board.length; r+=3) {
        for (int c=0; c<board.length; c+=3) {
          if (complete(makeSquare(r,c,board)) == false) {
            return false;
          }
        }
      }
      return true;
    }

  public static int[] makeSquare(int row, int col, int[][] board) {
      int[] square = new int[9];
      int pos = 0;
      for (int i=0; i<3; i++) {
          for (int j=0; j<3; j++) {
            square[pos] = board[row+i][col+j];
            pos++;
          }
      }
      return square;
  }

  public static boolean complete(int[] numbers) {
      boolean[] reference = new boolean[10];
      Arrays.fill(reference, false);
      for (int n=0; n<numbers.length; n++) {
          if (numbers[n]<1 || numbers[n]>9) {
            return false;
          }
          if (reference[numbers[n]]) {
            return false;
          }
          reference[numbers[n]] = true;
      }
      return true;
  }
}
