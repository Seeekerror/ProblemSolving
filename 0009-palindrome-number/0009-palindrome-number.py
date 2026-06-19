class Solution:
    def isPalindrome(self, x: int) -> bool:
        ans = 0
        nm = x
        while x > 0:
            num = x%10
            ans = 10 * ans + num
            x //= 10
        
        if(nm == ans):
            return True
        return False

        