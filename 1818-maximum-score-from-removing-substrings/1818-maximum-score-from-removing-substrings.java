class Solution {
    private StringBuilder sb = new StringBuilder();

    public int maximumGain(String s, int x, int y) {
        sb.append(s);
        if (x < y) {
            return maximumGainH(y, "ba", x, "ab");
        }
        return maximumGainH(x, "ab", y, "ba");

    }

    private int maximumGainH(int higherScore, String higheString, int lowerScore, String lowerString) {
        int tempSum = 0;
        int i = 0;
        while (sb.length() > 0) {
            if (i >= (sb.length() - 1)) {
                if (contains(higheString)) {
                    tempSum += maximumGainH(higherScore, higheString, lowerScore, lowerString);
                    return tempSum;
                } else if (contains(lowerString)) {
                    tempSum += maximumGainL(higherScore, higheString, lowerScore, lowerString);
                    return tempSum;
                } else {
                    break;
                }
            }
            if (sb.charAt(i) == higheString.charAt(0) && sb.charAt(i + 1) == higheString.charAt(1)) {
                sb = sb.replace(i, i + 2, "");
                tempSum += higherScore;
                if (i - 2 >= 0) {
                    i -= 2;
                } else {
                    i = 0;
                }

            } else {
                ++i;
            }
        }
        return tempSum;
    }

    private int maximumGainL(int higherScore, String higheString, int lowerScore, String lowerString) {
        int tempSum = 0;
        int i = 0;
        while (sb.length() > 0) {
            if (i >= (sb.length() - 1)) {
                if (contains(higheString)) {
                    tempSum += maximumGainH(higherScore, higheString, lowerScore, lowerString);
                    return tempSum;
                } else if (contains(lowerString)) {
                    tempSum += maximumGainL(higherScore, higheString, lowerScore, lowerString);
                    return tempSum;
                } else {
                    break;
                }
            }
            if (sb.charAt(i) == lowerString.charAt(0) && sb.charAt(i + 1) == lowerString.charAt(1)) {
                sb = sb.replace(i, i + 2, "");
                tempSum += lowerScore;
                if (i - 2 >= 0) {
                    i -= 2;
                } else {
                    i = 0;
                }
            } else {
                ++i;
            }
        }
        return tempSum;
    }

    public boolean contains(String s) {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == s.charAt(0) && sb.charAt(i + 1) == s.charAt(1)) {
                return true;
            }
        }
        return false;
    }
}
