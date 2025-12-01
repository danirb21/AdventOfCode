#Author Daniel Solis Alfonso

def limit_times(num,num1,es_suma) -> int:
    i=0
    
    if es_suma:
        #print("he entrado "+str(num)+"   "+str(num1))
        while(i!=num1):
            i+=1
            num+=1
            #print(i)
            if num==100:
                num=0        
    else:
        #print("he entrado "+str(num)+"   "+str(num1))
        while(i!=num1):
            #print(i)
            i+=1
            num=num-1
            if num==-1:
                num=99    
    return num

puntero=50
password=0
with open("input.txt","r") as fich:
    for linea in fich:
        rotacion=linea[0] 
        print(linea) 
        if rotacion=='L':
            puntero=limit_times(puntero,int(linea[1::]),False)
            if puntero==0:
                password=password+1
        if rotacion=='R':
            puntero=limit_times(puntero,int(linea[1::]),True)
            if puntero==0:
                password=password+1
            
            
    print("ES LA CONTRASEÑA"+str(password))            