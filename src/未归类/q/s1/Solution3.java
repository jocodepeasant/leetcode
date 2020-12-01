package 未归类.q.s1;

/**
 * 平时自练地
 */
class Solution3 {
    public boolean isLongPressedName(String name, String typed) {
        int nLen = name.length()-1;
        int tLen = typed.length()-1;
        while (nLen >= 0 && tLen >= 0) {
            if (name.charAt(nLen) == typed.charAt(tLen)) {
                nLen--;
                tLen--;
            }else {
                if (tLen < typed.length() - 1 && typed.charAt(tLen) == typed.charAt(tLen + 1)) {
                    tLen--;
                } else {
                    return false;
                }
            }
        }
        if (nLen >= 0) {
            return false;
        }
        while (tLen >= 0) {
            if (typed.charAt(tLen) != typed.charAt(tLen + 1)) {
                return false;
            }
        }
        return true;
    }
}
