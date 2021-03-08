def solution(a, b):
    days_by_month = [0,31,29,31,30,31,30,31,31,30,31,30,31]
    total_days = b
    for i in range(1, a):
        total_days += days_by_month[i]
    week_days = ['THU', 'FRI', 'SAT', 'SUN', 'MON', "TUE", "WED"]
    return week_days[total_days % 7]