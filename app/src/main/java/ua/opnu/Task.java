package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    // Task 1
    public void removeShorterStrings(List<String> list) {
        int i = 0;
        while (i < list.size() - 1) {
            String a = list.get(i);
            String b = list.get(i + 1);
            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    // Task 2
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    // Task 3
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    // Task 4
    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;
        String last = list.get(0);
        int i = 1;
        while (i < list.size()) {
            if (list.get(i).equals(last)) {
                list.remove(i);
            } else {
                last = list.get(i);
                i++;
            }
        }
    }

    // Task 5
    public void markLength4(List<String> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    // Task 6
    public boolean isPalindrome(Queue<Integer> queue) {
        int size = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // push all
        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            queue.add(v);
            stack.push(v);
        }

        boolean ok = true;

        // compare and restore
        for (int i = 0; i < size; i++) {
            int front = queue.remove();
            int back = stack.pop();
            if (front != back) ok = false;
            queue.add(front);
        }

        return ok;
    }

    // Task 7
    public void reorder(Queue<Integer> queue) {
        int size = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int negatives = 0;

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v < 0) {
                stack.push(v);
                negatives++;
            } else {
                queue.add(v);
            }
        }

        int positives = queue.size();

        while (!stack.isEmpty()) queue.add(stack.pop());

        for (int i = 0; i < positives; i++) queue.add(queue.remove());
    }

    // Task 8
    public void rearrange(Queue<Integer> queue) {
        int size = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int odds = 0;

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v % 2 != 0) {
                stack.push(v);
                odds++;
            } else queue.add(v);
        }

        int evens = queue.size();

        while (!stack.isEmpty()) queue.add(stack.pop());

        for (int i = 0; i < evens; i++) queue.add(queue.remove());

        for (int i = 0; i < odds; i++) stack.push(queue.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());
    }

    // Task 9
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    // Task 10
    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().length() % 2 == 0) it.remove();
        }
    }

    // Task 11
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);
        s1.retainAll(s2);
        return s1.size();
    }

    // Task 12
    public boolean isUnique(Map<String, String> map) {
        Set<String> seen = new HashSet<>();
        for (String v : map.values()) {
            if (!seen.add(v)) return false;
        }
        return true;
    }

    // Task 13
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();
            if (map2.containsKey(key) && Objects.equals(map2.get(key), value)) {
                res.put(key, value);
            }
        }
        return res;
    }

    // Task 14
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            String value = e.getValue();
            int key = e.getKey();


            if (!result.containsKey(value) || key > result.get(value)) {
                result.put(value, key);
            }
        }

        return result;
    }


    // Task 15
    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) throw new IllegalArgumentException("Map empty");

        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        int bestCount = Integer.MAX_VALUE;
        int bestValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();

            if (count < bestCount || (count == bestCount && value < bestValue)) {
                bestCount = count;
                bestValue = value;
            }
        }

        return bestValue;
    }

    // Task 16
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int n : list) {
            int c = freq.getOrDefault(n, 0) + 1;
            freq.put(n, c);
            if (c > max) max = c;
        }

        return max;
    }
}
