class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        datetime1 = datetime.datetime.strptime(date1 , '%Y-%m-%d')
        datetime2 = datetime.datetime.strptime(date2 , '%Y-%m-%d')
        difference = datetime2 - datetime1
        return abs(difference.days)