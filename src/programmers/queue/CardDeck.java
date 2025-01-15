package programmers.queue;

import java.util.*;

/**
 * 프로그래머스
 *
 * 카드뭉치
 *
 *        cards1	             cards2	                      goal	                result
 * ["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
 * ["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
 *
 * 굳이 번갈아 안뽑아도됨...
 */
public class CardDeck {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> q3 = new LinkedList<>();

        q1.addAll(Arrays.asList(cards1));
        q2.addAll(Arrays.asList(cards2));
        q3.addAll(Arrays.asList(goal));

        while (!q3.isEmpty() && !q1.isEmpty() && !q2.isEmpty()) {
            String g = q3.peek();
            if(q1.peek().equals(g)) {
                q1.poll();
                q3.poll();
            } else if(q2.peek().equals(g)) {
                q2.poll();
                q3.poll();
            } else {
                return "No";
            }
        }

        if(!q3.isEmpty()) {
            if(q2.size() >= q3.size()) {
                while (!q3.isEmpty()) {
                    if(!q2.poll().equals(q3.poll()))
                        return "No";
                }
            } else if(q1.size() >= q3.size()) {
                while (!q3.isEmpty()) {
                    if(!q1.poll().equals(q3.poll()))
                        return "No";
                }
            }
            if(!q3.isEmpty())
                return "No";
        }

        return answer;
    }

    public static void main(String[] args) {
        CardDeck T = new CardDeck();
        System.out.println(T.solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
        System.out.println(T.solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
        System.out.println(T.solution(
                new String[]{"a"},
                new String[]{"b", "d", "c"},
                new String[]{"a", "b", "c", "d"}
        ));
    }
}
