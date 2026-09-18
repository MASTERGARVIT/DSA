import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> used = new HashSet<>();

            for (int x = 0; x < size; x++) {
                String word = queue.poll();

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;

                        String next = new String(arr);

                        if (set.contains(next)) {
                            if (!parents.containsKey(next)) {
                                parents.put(next, new ArrayList<>());
                                queue.add(next);
                                used.add(next);
                            }

                            parents.get(next).add(word);

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            set.removeAll(used);
        }

        if (!parents.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parents, path, result);

        return result;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        for (String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}