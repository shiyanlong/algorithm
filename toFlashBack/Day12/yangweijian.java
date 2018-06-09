import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12 {

    private List<String> result = new ArrayList<>();

    private void operate(String o, String n, int p) {
        if (p >= o.length()) {
            if (!result.contains(n)) result.add(n);
            return;
        }
        char c = o.charAt(p);
        if ('A' <= c && c <= 'Z')
            c = (char) (c + 32);
        operate(o, n + c, p + 1);
        if ('a' <= c && c <= 'z') c = (char) (c- 32);
        operate(o, n + c, p +1);
    }

    public List<String> letterCasePermutation(String S) {
        operate(S, "", 0);
        return result;
    }

    @Test
    public void a() {
        System.out.println(Arrays.toString(letterCasePermutation("a1b1").toArray()));
    }
}
