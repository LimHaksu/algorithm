def solution(record):
    uid_map = {}
    log = []
    for r in record:
        splited = r.split(' ')
        action, uid = splited[0], splited[1]
        if action == 'Enter':
            uid_map[uid] = splited[2]
            log.append({'uid':uid, 'action':action})
        elif action == 'Leave':
            log.append({'uid':uid, 'action':action})
        elif action == 'Change':
            uid_map[uid] = splited[2]
    return list(map(lambda e: uid_map[e['uid']]+'님이 '+('들어왔습니다.' if e['action'] == 'Enter' else '나갔습니다.'), log))

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))