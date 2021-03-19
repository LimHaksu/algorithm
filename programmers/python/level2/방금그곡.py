def solution(m, musicinfos):
    m = replace_hash(m)
    musicDic = {}
    for i, music in enumerate(musicinfos):
        splited = music.split(',')
        start_time = time_str_to_int(splited[0])
        end_time = time_str_to_int(splited[1])
        listen_length = end_time - start_time
        title = splited[2]
        pattern = replace_hash(splited[3])
        pattern = make_listened_pattern(pattern, listen_length)

        if title not in musicDic:
            musicDic[title] = []
        musicDic[title].append({'index': i, 'pattern':pattern})

    arr = []
    for title in musicDic:
        musics = musicDic[title]
        for music in musics:
            if m in music['pattern']:
                p = music['pattern']
                i = music['index']
                t = title
                arr.append({'pattern': p, 'index': i, 'title': t})
    if len(arr) == 0:
        return "(None)"
    arr.sort(key=lambda e: e['index'])
    arr.sort(key=lambda e: len(e['pattern']), reverse=True)

    return arr[0]['title']

def time_str_to_int(time):
    splited = time.split(':')
    return int(splited[0]) * 60 + int(splited[1])

def replace_hash(pattern):
    pattern = pattern.replace('A#', 'H')
    pattern = pattern.replace('C#', 'I')
    pattern = pattern.replace('D#', 'J')
    pattern = pattern.replace('F#', 'K')
    pattern = pattern.replace('G#', 'L')
    return pattern

def make_listened_pattern(pattern, listen_length):
    pattern_length = len(pattern)
    res = ''
    for i in range(listen_length):
        char = pattern[i % pattern_length]
        res += char
    return res

print(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))