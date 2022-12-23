package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程ai 则必须先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule
 */
public class LC207_CanFinish {

    /**
     * 拓扑排序经典题目，采用广度优先算法。
     * 首先使用一个map，保存当前结点与其入度。
     * 再创建一个队列，插入入度为0的结点，同时更新map。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            return false;
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

        return finishList.size() == numCourses;
    }
}
