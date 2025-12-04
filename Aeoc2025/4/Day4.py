#Author Daniel Solis Alfonso

with open("input-test.txt", "r") as f:
    cuadricula=f.readlines()
    cont=0
    cont_papers=0
    for filas in range(0,len(cuadricula)):
        for columnas in range(0, len(cuadricula[filas])):
            cont=0
            if cuadricula[filas][columnas]=="@":         
                if (
                    (filas == 0 and columnas == 0) or
                    (filas == 0 and columnas == len(cuadricula[filas]) - 1) or
                    (filas == len(cuadricula) - 1 and columnas == 0) or
                    (filas == len(cuadricula) - 1 and columnas == len(cuadricula[filas]) - 1)
                ):  # Esquinas primera o ultima fila
                    cont_papers += 1
                    #print(f"Coordenadas: {filas}  {columnas}")
                else:
                    if filas==0:
                        if cuadricula[filas][columnas+1]=="@": #Derecha
                            cont+=1
                        if cuadricula[filas][columnas-1]=="@": #izquierda
                            cont+=1
                        if cuadricula[filas+1][columnas]=="@": #Abajo
                            cont+=1    
                        if cuadricula[filas+1][columnas-1]=="@": #Diagonal Izquierda Abajo    
                            cont+=1
                        if cuadricula[filas+1][columnas+1]=="@": #Diagonal Derecha Abajo 
                            cont+=1                  

                        if cont<4:
                            cont_papers+=1
                            #print(f"Coordenadas: {filas}  {columnas}")
                            
                    elif filas==len(cuadricula)-1:
                        if cuadricula[filas][columnas+1]=="@": #Derecha
                            cont+=1
                        if cuadricula[filas][columnas-1]=="@": #izquierda
                            cont+=1
                        if cuadricula[filas-1][columnas]=="@": #Arriba
                            cont+=1    
                        if cuadricula[filas-1][columnas-1]=="@": #Diagonal Izquierda Arriba   
                            cont+=1
                        if cuadricula[filas-1][columnas+1]=="@": #Diagonal Derecha Arriba 
                            cont+=1
                        if cont<4:
                            cont_papers+=1
                            #print(f"Coordenadas: {filas}  {columnas}")
                            
                    elif columnas==0:
                        if cuadricula[filas][columnas+1]=="@": #Derecha
                            cont+=1
                        if cuadricula[filas+1][columnas]=="@": #Abajo
                            cont+=1 
                        if cuadricula[filas-1][columnas]=="@": #Arriba
                            cont+=1 
                        if cuadricula[filas+1][columnas+1]=="@": #Diagonal Derecha Abajo 
                            cont+=1
                        if cuadricula[filas-1][columnas+1]=="@": #Diagonal Derecha Arriba 
                            cont+=1
                        if cont<4:
                            cont_papers+=1
                            #print(f"Coordenadas: {filas}  {columnas}")
                            
                    elif columnas==len(cuadricula[filas])-1:
                        
                        if cuadricula[filas][columnas-1]=="@": #izquierda
                            cont+=1
                        if cuadricula[filas+1][columnas]=="@": #Abajo
                            cont+=1
                        if cuadricula[filas-1][columnas]=="@": #Arriba
                            cont+=1
                        if cuadricula[filas-1][columnas-1]=="@": #Diagonal Izquierda Arriba   
                            cont+=1
                        if cont<4:
                            cont_papers+=1
                            #print(f"Coordenadas: {filas}  {columnas}")
                            
                    else:
                        if cuadricula[filas][columnas+1]=="@": #Derecha
                            cont+=1
                        if cuadricula[filas][columnas-1]=="@": #izquierda
                            cont+=1
                        if cuadricula[filas-1][columnas]=="@": #Arriba
                            cont+=1
                        if cuadricula[filas+1][columnas]=="@": #Abajo
                            cont+=1    
                        if cuadricula[filas-1][columnas-1]=="@": #Diagonal Izquierda Arriba   
                            cont+=1
                        if cuadricula[filas-1][columnas+1]=="@": #Diagonal Derecha Arriba 
                            cont+=1
                        if cuadricula[filas+1][columnas-1]=="@": #Diagonal Izquierda Abajo    
                            cont+=1
                        if cuadricula[filas+1][columnas+1]=="@": #Diagonal Derecha Abajo 
                            cont+=1
                        if cont<4:
                            cont_papers+=1
                            #print(f"Coordenadas: {filas}  {columnas}")
                        
    print(f"Numero de rollos accesibles: {cont_papers}")