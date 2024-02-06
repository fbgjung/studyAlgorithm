from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0

    return bfs(begin, target, words)

def bfs(begin, target, words):
    queue = deque()
    queue.append([begin, 0])
    visited = [0] * (len(words))

    while queue:
        now, depth = queue.popleft()

        if now == target:
            return depth
        
        for word in range(len(words)):
            count = 0
            if visited[word] != 1: # 방문하지 않은 노드라면
                
                for i in range(len(now)):
                    if now[i] != words[word][i]:
                        count += 1
                        
                
                if count == 1:
                    queue.append([words[word], depth+1])
                    visited[word] = 1 # 방문 처리


print(solution("hit","cog",["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit","cog",["hot", "dot", "dog", "lot", "log"]))