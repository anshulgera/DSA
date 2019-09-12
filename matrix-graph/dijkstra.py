# greedy algo
import sys
def min_distance(grid, vertices, distances, visited):
    min = sys.maxsize
    min_dist_vertex = -1
    for vertex in range(vertices):
        if distances[vertex] < min and not visited[vertex]:
            min = distances[vertex]
            min_dist_vertex = vertex
    return min_dist_vertex

def dijkstra(grid, vertices, source):
    # initially all vertices are at infinity distance
    # as we don not know how to get there
    distances = [sys.maxsize] * vertices

    # to keep a track that we have explored all 
    # possible vertices from a given vertex
    visited = [False] * vertices

    distances[source] = 0

    for vertex in range(vertices):
        # Pick the minimun distance vertex from 
        # the set of vertices not yet visited

        u = min_distance(grid, vertices, distances, visited)
        print(f"Current closest vertex that is not visited is {u}")
        print(distances)
        
        print(f"Visiting all neighbours from {u}")
        for v in range(vertices):
            if not visited[v] and grid[u][v] != 0 and distances[v] > distances[u] + grid[u][v]:
                distances[v] = distances[u] + grid[u][v]
                print(f"Updating distance of {v} from {u}")
        print(f"Visited all vertices from {u}")
        visited[u] = True
        print(f"New distances are {distances}")
    print(distances)


grid = [[0, 4, 0, 0, 0, 0, 0, 8, 0], 
        [4, 0, 8, 0, 0, 0, 0, 11, 0], 
        [0, 8, 0, 7, 0, 4, 0, 0, 2], 
        [0, 0, 7, 0, 9, 14, 0, 0, 0], 
        [0, 0, 0, 9, 0, 10, 0, 0, 0], 
        [0, 0, 4, 14, 10, 0, 2, 0, 0], 
        [0, 0, 0, 0, 0, 2, 0, 1, 6], 
        [8, 11, 0, 0, 0, 0, 1, 0, 7], 
        [0, 0, 2, 0, 0, 0, 6, 7, 0] 
        ]

dijkstra(grid, len(grid), 0)