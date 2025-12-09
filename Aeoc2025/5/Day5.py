#Author Daniel Solis Alfonso
def check_fresh(rangos, num:int):
    bol=False
    for rango in rangos:
        if num>=int(rango[0]) and num<= int(rango[1]):
            bol=True
            break        
            
    """
    for num_min, num_max in zip(range_min, range_max):
        if bol:
            break
        for i in range(num_min,num_max+1):
            if num==i:
                bol=True
                break
    """
    return bol

with open("input.txt") as f:
    linea=f.readline().strip()
    rango=[]
    cont=0
    while linea!="":
        rango.append(linea.split("-"))
        linea=f.readline().strip()
    linea=f.readline().strip()
    while linea!="":
        num=int(linea)
        if check_fresh(rango,num):
            cont+=1    
        linea=f.readline().strip()
        
    
    print(f" IDs frescos: {cont}")        
        
