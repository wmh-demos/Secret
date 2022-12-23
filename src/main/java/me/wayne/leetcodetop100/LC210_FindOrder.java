package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
 * 如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC210_FindOrder {

   public int[] findOrder(int numCourses, int[][] prerequisites) {
      // key是课程，value是该课程的前置课程
      Map<Integer, List<Integer>> courseToPreCourse = new HashMap<>();
      for (int[] arr : prerequisites) {
         List<Integer> list = courseToPreCourse.get(arr[0]);
         if (list == null) {
            list = new ArrayList<>();
         }
         list.add(arr[1]);
         courseToPreCourse.put(arr[0], list);
      }

      // 记录可以完成的课程的列表，即入度为0
      List<Integer> canFinishList = new ArrayList<>();
      for (int i = 0; i < numCourses; i++) {
         List<Integer> list = courseToPreCourse.get(i);
         if (list == null) {
            canFinishList.add(i);
         }
      }
      // 初始状态下没有任何入度为0的课程，直接返回false
      if (canFinishList.isEmpty()) {
         return new int[0];
      }

      List<Integer> finishList = new ArrayList<>();
      while (!canFinishList.isEmpty()) {
         // 遍历courseToPreCourse，将前置课程里包含canFinishList的都删掉
         for (Map.Entry<Integer, List<Integer>> entry : courseToPreCourse.entrySet()) {
            List<Integer> list = entry.getValue();
            list.removeAll(canFinishList);
         }
         // 记录已经完成的课程
         finishList.addAll(canFinishList);

         // 再放入即将完成的课程
         canFinishList.clear();
         Iterator<Map.Entry<Integer, List<Integer>>> it = courseToPreCourse.entrySet().iterator();
         while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = it.next();
            List<Integer> list = entry.getValue();
            if (list.isEmpty()) {
               canFinishList.add(entry.getKey());
               it.remove();
            }
         }
      }

      if (finishList.size() == numCourses) {
         return toIntArray(finishList);
      } else {
         return new int[]{};
      }
   }

   private int[] toIntArray(List<Integer> list) {
      int[] ret = new int[list.size()];
      int i = 0;
      for (Integer e : list) {
         ret[i++] = e;
      }
      return ret;
   }
}
