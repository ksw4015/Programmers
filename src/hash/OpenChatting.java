package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        for(String r : record) {
            String[] data = r.split(" ");
            if(data[0].equals("Enter") || data[0].equals("Change")) {
                map.put(data[1], data[2]);
            }
        }

        List<String> result = new ArrayList<>();
        for(String r : record) {
            String[] data = r.split(" ");
            String nickName = map.get(data[1]);
            if(data[0].equals("Enter")) {
                result.add(nickName + "님이 들어왔습니다.");
            } else if(data[0].equals("Leave")) {
                result.add(nickName + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        OpenChatting T = new OpenChatting();
        System.out.println(Arrays.toString(T.solution(new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        })));
    }
}
