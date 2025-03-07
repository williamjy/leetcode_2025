class Solution {
    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<String> ();
        boolean isSlash = true;
        int left = 0, right = 0;
        while (left < path.length()) {
            if (path.charAt(left) == '/') {
                right = left;
                while (right < path.length() && path.charAt(right) == '/') {
                    right++;
                }
                String currWord = path.substring(left, right);
                if (currWord.length() > 1) {
                    currWord = "/";
                }
                pathStack.push(currWord);
            } else {
                right = left;
                while (right < path.length() && path.charAt(right) != '/') {
                    right++;
                }
                String currWord = path.substring(left, right);
                if (currWord.equals(".")) {
                    pathStack.pop();
                } else if (currWord.equals("..")) {
                    if (!pathStack.empty()){
                        pathStack.pop();
                    }
                    if (!pathStack.empty()) {
                        pathStack.pop();
                    }
                    if (!pathStack.empty()) {
                        pathStack.pop();
                    }
                } else {
                    pathStack.push(currWord);
                }
            }
            left = right;
        }
        String simplifiedPath = "";
        if (!pathStack.empty() && pathStack.peek().equals("/")) {
            pathStack.pop();
        }
        Iterator iterator = pathStack.iterator();
        while (iterator.hasNext()) {
            simplifiedPath += iterator.next();
        }
        if (simplifiedPath == "") {
            simplifiedPath = "/";
        }
        return simplifiedPath;
    }
}