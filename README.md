# Subway-Optimal-Route-App
Bellevue College Capstone Project 2022-2023 group 11

# PseudoCode
# User interface to sign in
# access user database to find data on user
# Access geospatial data 
# finds user location
# takes user input 
# looks for both locations and calculates subway times with walking distance
# reports back the optimal time
# for secondary options looks at user preferences to see what secondary options are
# reports on map where user is and the ideal path

line1 = ["a", "b", "f", "d", "e"]
line2 = ["c", "e", "j", "g", "i"]
line3 = ["c", "j", "k", "l", "m"]
line4 = ["h", "b", "e", "a", "n"]

stations = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"]
allLines = [line1, line2, line3, line4]
nodeGraph = {}

def getList(letter):
  neighbors = []
  for i in allLines:
     if letter in i:
        pos = i.index(letter)
        if pos == 0:
            neighbors.append(i[pos+1])
        elif pos == len(i) - 1:
            neighbors.append(i[pos-1])
        elif pos > 0 and pos < len(i) - 1:
            neighbors.append(i[pos-1])
            neighbors.append(i[pos+1])
  return neighbors

for station in stations:
   nodeGraph[station] = getList(station)

def shortPath(origin, destination, *lines):
    paths = [[origin]]        # start from origin
    visited = set()             # only extend once per station
    while paths:                 # until no more extensions
        path = paths.pop(0)                   # shortest paths first
        if path[-1]==destination: return path # arrived!
        for line in lines:                    # find a transfer 
            if path[-1] not in line:continue  # no transfer on line
            i = line.index(path[-1])          # from station's location
            for station in line[i-1:i]+line[i+1:i+2]: # previous/next stations
                if station in visited : continue # already been there
                paths.append(path + [station])   # add longer path
                visited.add(station)
    return [] # no path to destination

print(shortPath("a","h",line1,line2,line3,line4))
# ['a', 'b', 'h']

print(shortPath("d","n",line1,line2,line3,line4))
# ['d', 'e', 'a', 'n']

print(shortPath("h","m",line1,line2,line3,line4))
# ['h', 'b', 'e', 'j', 'k', 'l', 'm']  