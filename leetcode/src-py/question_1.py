class Solution:
    def twoSum(self, nums, target):
        maps = {}
        for index, num in enumerate(nums):
            if target - num in maps:
                return [index, maps[target - num]]
            else:
                maps[num] = index
        return []


def main():
    so = Solution()
    res = so.twoSum([2, 7, 11, 15], 9)
    print(res)
    pass


if __name__ == "__main__":
    exit(main())
