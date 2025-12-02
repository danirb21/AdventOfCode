#Author Daniel Solis Alfonso

def check_id(num)-> bool:
    id=str(num)
    j=0
    bol=True
    size=0
    half=int(len(id)/2)    
    for i in range(1,half+1):
        num=id[:i]
        numero_sin_num=id[i:]
        size=len(numero_sin_num)
        j=i
        while j<size and num==numero_sin_num[:i]:
            j+=i
            numero_sin_num=numero_sin_num[i:]
                
        if j==size and num==numero_sin_num:
            bol=False              
                      
    return bol
        
total_invalid_id=0
fich=open("input_test.txt","r")
ranges=fich.read().split(",")
for element in ranges:
    min=int(element.split("-")[0])
    max=int(element.split("-")[1])+1
    for i in range(min,max):
        if  not check_id(i):
            total_invalid_id+=i
            
print("Suma ids: "+str(total_invalid_id))
