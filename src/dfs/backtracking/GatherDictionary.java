package dfs.backtracking;

/**
 * 프로그래머스 모음 사전
 */
public class GatherDictionary {
    int cnt;
    boolean find = false;
    public int solution(String word) {
        char[] gathers = new char[]{'A', 'E', 'I', 'O', 'U'};
        cnt = 0;
        find = false;
        dfs(0, "", gathers, word);
        return cnt;
    }

    private void dfs(int lv, String sb, char[] gathers, String word) {
        if(sb.isEmpty() || sb.length() < 5) {
            for(int i = 0 ; i < gathers.length ; i++) {
                if(find)
                    continue;
                cnt++;
                if(word.equals(sb + gathers[i])) {
                    find = true;
                    return;
                }
                dfs(lv, sb + gathers[i], gathers, word);
                sb = sb.substring(0, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        GatherDictionary T = new GatherDictionary();
        System.out.println(T.solution("AAAAE"));
        System.out.println(T.solution("AAAE"));
        System.out.println(T.solution("I"));
        System.out.println(T.solution("EIO"));
    }
}