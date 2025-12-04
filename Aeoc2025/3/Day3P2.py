def find_max_digit(cadena_entrada):
    if not cadena_entrada:
        return None, None

    max_num = -1
    indice = -1

    for index in range(len(cadena_entrada)):
        caracter = cadena_entrada[index]
        
        try:
            num = int(caracter)
        except ValueError:
            continue
        
        if num > max_num:
            indice = index+1
            max_num = num

    if indice == -1:
        return None, None       

    return max_num

with open("input.txt","r") as fich:
    for linea in fich.readlines() :
        linea=linea.strip()
        size=len(linea)
        size1=len(linea)
        pos_num=0
        total=0
        acum=0
        dif=12
        str_num=""
        rango=abs(size-dif)
        linea_original=linea
        linea_consultar=linea_original[:size1-12+2]
        while(rango>0):
            linea1=linea[:rango+1]
            max_num=find_max_digit(linea1)
            #print(linea_original)
            pos_num=linea_consultar.find(str(max_num))+1
            str_num+=str(max_num)
            total+=1
            size=max(0,size-pos_num)
            dif=max(0,dif-total)
            rango=max(0,size-dif)
            linea=linea_original[pos_num:]
            ceros="0"*pos_num 
            linea_consultar=ceros+linea_consultar[pos_num:]
            
        if pos_num!=len(linea)-1:
            i=0
            while len(str_num)<12:  
                str_num+=linea[i]
                i+=1
        print(str_num)
        acum+=int(str_num)
        
    print("Suma: "+str(acum))
    
        
        


        