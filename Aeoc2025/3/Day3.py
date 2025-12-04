#Author Daniel Solis Alfonso
sum_max=0
with open("input.txt","r") as fich:
    for linea in fich.readlines():
        bol=False
        linea=linea.strip()
        #print(linea)
        max=int(linea[0])
        indice=0
        #Search first number max
        for index in range(1,len(linea)):
            num=int(linea[index])
            if num>max:
                indice=index
                max=num
        str_max=str(max)
        
        if indice!=index:
            linea=linea[indice+1:]
        else:
            linea=linea[:index]
            bol=True
            
        max=int(linea[0])
        #Search second number max
        for i in range(1,len(linea)):
            num=int(linea[i])
            if num>max:
                max=num
        #Order the numbers        
        if bol:
            num1=str_max
            str_max=str(max)
            str_max+=num1
        else:
            str_max+=str(max)
        
        #print(str_max)
        sum_max+=int(str_max)
        
print("Suma: "+str(sum_max))          