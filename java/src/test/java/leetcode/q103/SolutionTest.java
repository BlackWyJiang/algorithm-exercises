package q103;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    TreeNode tree = TreeNode.of(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 0, 8, 0, 0, 9, 0, 0});
    Solution solution = new Solution();
    @Test
    public void zigzagLevelOrder() {
        List<List<Integer>> lists = solution.zigzagLevelOrder(tree);
        System.out.println(lists);
    }
    @Test
    public void preOrder() {
        List<Integer> preRet = solution.preOrder(tree);
        assertEquals(toStr(preRet),"124583697");

    }

    @Test
    public void inOrder() {
        List<Integer> preRet = solution.inOrder(tree);
        assertEquals(toStr(preRet),"428516937");
    }

    @Test
    public void postOrder() {
        List<Integer> preRet = solution.postOrder(tree);
        assertEquals(toStr(preRet),"485296731");
    }

    @Test
    public void levelOrder() {
        List<Integer> levelOrder = solution.levelOrder(tree);
        assertEquals(toStr(levelOrder),"123456789");
    }

    @Test
    public void splitLevelOrder() {
        List<List<Integer>> lists = solution.splitLevelOrder(tree);
        Object[] ret = lists.stream().map(this::toStr).toArray();
        assertArrayEquals(ret,new String[]{"1","23","4567","89"});
    }

    private String toStr(List<Integer> list) {
        StringBuilder ret = new StringBuilder();
        if (list == null) {
            return "";
        }

        for (Integer i : list) {
            if (i != 0) {
                ret.append(i);
            }
        }
        return ret.toString();
    }



}