def can_move(width, height, j, i):
    if j < 0 or j > height - 1:
        return False
    if i < 0 or i > width - 1:
        return False
    return True

def solution(land):
    answer = 0
    width = len(land[0])
    height = len(land)
    amount = [0] * width
    visit = [[False for _ in range(width)] for _ in range(height)]
    for i in range(width):
        for j in range(height):
            if land[j][i] == 1 and not visit[j][i]:
                local_amount = 0
                queue = []
                queue.append([j, i])
                visit[j][i] = True
                lst = set()
                while len(queue) > 0:
                    node = queue.pop(0)
                    y = node[0]
                    x = node[1]
                    local_amount += 1
                    lst.add(x)
                    for mv in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        next_y = y + mv[0]
                        next_x = x + mv[1]
                        if not can_move(width, height, next_y, next_x):
                            continue
                        if land[next_y][next_x] == 1 and not visit[next_y][next_x]:
                            visit[next_y][next_x] = True
                            queue.append([next_y, next_x])
                for x in lst:
                    amount[x] += local_amount
    for amt in amount:
        answer = max(amt, answer)
    return answer