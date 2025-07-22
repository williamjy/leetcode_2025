class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        if len(s) > len(t):
            return self.isOneEditDistance(t, s)
        elif len(t) - len(s) >= 2:
            return False
        elif len(s) == len(t):
            diff = 0
            for i in range(len(s)):
                if s[i] != t[i]:
                    diff += 1
            if diff == 1:
                return True
            else:
                return False
        elif len(s) < len(t):
            is_inserted = False
            i = 0
            j = 0
            while i < len(s):
                if s[i] != t[j]:
                    if is_inserted:
                        return False
                    else:
                        j += 1
                        is_inserted = True
                else:
                    i += 1
                    j += 1
            return True