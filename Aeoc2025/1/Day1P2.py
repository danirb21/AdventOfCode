#Author Daniel Solis Alfonso

def limit_times(num,num1,es_suma) -> tuple:
    i=0
    times=0
    tupla=()
    if es_suma:
        #print("he entrado "+str(num)+"   "+str(num1))
        while(i!=num1):
            i+=1
            num+=1
            if num==100:
                num=0   
                times+=1
        tupla=(num,times)          
    else:
        #print("he entrado "+str(num)+"   "+str(num1))
        while(i!=num1):
            i+=1
            num=num-1
            if(num==0):
                times+=1
            if num==-1:
                num=99 
        tupla=(num,times)       
    return tupla

puntero=50
password=0
with open("input.txt","r") as fich:
    for linea in fich:
        rotacion=linea[0] 
        #print(linea) 
        if rotacion=='L':
            tupla=limit_times(puntero,int(linea[1::]),False)
            puntero=tupla[0]
            password=password+tupla[1]
        if rotacion=='R':
            tupla=limit_times(puntero,int(linea[1::]),True)
            puntero=tupla[0]
            password=password+tupla[1]
                    
    print("ES LA CONTRASEÑA "+str(password))            