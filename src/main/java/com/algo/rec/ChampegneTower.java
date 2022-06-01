package com.algo.rec;

import java.util.ArrayList;
import java.util.List;

public class ChampegneTower {

  public static double champagneTower(int poured, int query_row, int query_glass) {
    List<List<Double>> pyramidRows = getEmptyPyramidRows(query_row);
    pyramidRows.get(0).set(0, (double)poured);
    for (int i = 0; i <= query_row; i++) {
      List<Double> currentRow = pyramidRows.get(i);
      for (int j = 0; j < currentRow.size(); j++) {
        double overflow = Math.max(0, currentRow.get(j) - 1);
        List<Double> nextRow = pyramidRows.get(i + 1);
        nextRow.set(j, nextRow.get(j) + overflow / 2);
        nextRow.set(j + 1, nextRow.get(j + 1) + overflow / 2);
        currentRow.set(j, currentRow.get(j) - overflow);
      }
    }
    return pyramidRows.get(query_row).get(query_glass);
  }

  private static List<List<Double>> getEmptyPyramidRows(int maxHeight) {
    List<List<Double>> pyramidRows = new ArrayList<>();
    for (int i = 0; i <= maxHeight + 1; i++) {
      List<Double> currentRow = new ArrayList<>();
      for (int j = 0; j < i + 1; j++) {
        currentRow.add((double)0);
      }
      pyramidRows.add(currentRow);
    }
    return pyramidRows;
  }

  public static void main(String[] args) {
    System.out.println(champagneTower(8, 2, 1));
  }

}
