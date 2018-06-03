import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14 {
    private List<String> result = new ArrayList();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<String>();
        solute(s, 4, "");
        return result;
    }

    private void solute(String s, int d, String r) {
        if (d == 0 && s.length() == 0) result.add(r);
        else {
            for (int i = 1; i < 4; i ++) {
                if (s.length() >= i && isOk(s.substring(0, i))) {
                    if (d == 1) solute(s.substring(i), d - 1, r + s.substring(0, i));
                    else solute(s.substring(i), d - 1, r + s.substring(0, i) + '.');
                }
            }
        }
    }

    private boolean isOk(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        int data = Integer.parseInt(s);
        return 0 <= data && data <= 255;
    }

    @Test
    public void a() {
        List<String> stringList = restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}
