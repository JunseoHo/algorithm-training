def solution(bandage, health, attacks):
    answer = 0
    last_attack = attacks[len(attacks) - 1]
    heal_count = 0
    hp = health
    for time in range(last_attack[0] + 1):
        if time == attacks[0][0]:
            heal_count = 0
            hp -= attacks[0][1]
            attacks.pop(0)
        else:
            heal_count += 1
            hp = min(hp + bandage[1], health)
            if heal_count == bandage[0]:
                hp = min(hp + bandage[2], health)
                heal_count = 0
        if hp < 1:
            return -1
    return hp