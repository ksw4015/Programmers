package programmers.dfs.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 프로그래머스 불량 사용자
 */

public class Abuser {
    HashSet<HashSet<String>> result;

    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        int[] chk = new int[user_id.length];
        dfs(chk, user_id, banned_id, new ArrayList<>(), banned_id.length, 0);
        return result.size();
    }

    /**
     *
     * @param chk user_id 체크 배열
     */
    private void dfs(int[] chk, String[] user_id, String[] banned_id, List<String> result, int n, int lv) {
        if(lv == n) {
            HashSet<String> set = new HashSet<>(result);
            this.result.add(set);
        } else {
            for(int i = 0 ; i < user_id.length ; i++) {
                if(banned_id[lv].length() == user_id[i].length()) {
                    if(checkBannedId(banned_id[lv], user_id[i])) {
                        if(chk[i] == 0) {
                            chk[i] = 1;
                            result.add(user_id[i]);
                            dfs(chk, user_id, banned_id, result, n, lv + 1);
                            result.remove(result.size() - 1);
                            chk[i] = 0;
                        }
                    }
                }
            }
        }
    }

    private boolean checkBannedId(String bannedId, String userId) {
        boolean find = true;
        for(int j = 0 ; j < bannedId.length() ; j++) {
            if(bannedId.charAt(j) != '*') {
                if(bannedId.charAt(j) != userId.charAt(j)) {
                    find = false;
                    break;
                }
            }
        }
        return find;
    }

    public static void main(String[] args) {
        Abuser T = new Abuser();
        System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(T.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}
