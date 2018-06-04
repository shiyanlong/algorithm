package study.toFlashBack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day15 {


    public List<String> generateParenthesis(int n) {
        return create(n, n,"", new ArrayList<>());
    }

    private List<String> create(int l, int r, String str, List<String> result) {
        if (l < 0 || r < 0) return result;
        if (l == 0 && r == 0) result.add(str);
        else if (l <= r) {
                result = create(l - 1, r, str + "(", result);
                result = create(l, r - 1, str + ")", result);
            }
        return result;
    }

    @Test
    public void a() {
        System.out.println(generateParenthesis(3));
    }
}
