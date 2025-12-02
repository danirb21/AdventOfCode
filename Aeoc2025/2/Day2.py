#Author Daniel Solis Alfonso

def check_id(num)-> bool:
    id=str(num)
    half=int(len(id)/2)
    part=id[half:]
    part1=id[:half]
    #print("Mitad: "+str(half))
    #print(part)
    #print(part1)
    return part!=part1
        
total_invalid_id=0
fich=open("input.txt","r")
ranges=fich.read().split(",")
for element in ranges:
    min=int(element.split("-")[0])
    max=int(element.split("-")[1])+1
    for i in range(min,max):
        if not check_id(i):
            total_invalid_id+=i
            #print("Sumas Ciclo: "+str(total_invalid_id))
print("Suma ids: "+str(total_invalid_id))
