import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day22 {

    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String str: strings) {
            switch (str) {
                case "":
                case ".": break;
                case "..": if (!stack.isEmpty()) stack.pop(); break;
                default: stack.push(str);
            }
        }
        if (stack.isEmpty()) sb.append("/");
        List<String> list = stack.subList(0, stack.size());
        for (String str: list) {
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/abc/..."));
    }
}
