##################################################################
# Problem   : https://leetcode.com/problems/two-sum/		 #
# Submission: https://leetcode.com/submissions/detail/117330999/ #
##################################################################

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        answer = []
        
        # Empty list
        if not nums:
            return answer

        # Sort the list
        sorted_nums = nums
            
        for i in range(0, len(sorted_nums)):
            # Consider one number as the solution
            answer.append(i)
            
            # Check to see if the other number is present
            second_num = target - sorted_nums[i]
            for j in range(0, len(sorted_nums)):
                if i != j and second_num == sorted_nums[j]:
                    answer.append(j)
                    return answer
            
            answer = []
        
        return answer
