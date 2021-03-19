import re
def solution(files):
    p = re.compile('(\D+)(\d{1,5})(.*)')
    new_files = []
    for file in files:
        matched = p.match(file)
        head = matched[1].lower()
        number = int(matched[2])
        new_files.append({
            'head' : head,
            'number' : number,
            "original_name" : file
        })
    new_files.sort(key=lambda e: e['number'])
    new_files.sort(key=lambda e: e['head'])
    return list(map(lambda e: e['original_name'], new_files))

print(solution(["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]))