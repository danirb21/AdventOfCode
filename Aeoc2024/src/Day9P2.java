import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Daniel Solis Alfonso
 */
public class Day9P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Inputs" + File.separator + "09" + File.separator + "input1.txt"));
        String mapaDisco;
        List<Integer> listaNumeros = new ArrayList<>();
        int id = 0;
        int num = 0;
        mapaDisco = bf.readLine();
        StringBuilder primeraLinea = new StringBuilder();
        for (int i = 0; i < mapaDisco.length(); i++) {
            if (i % 2 == 0) {
                num = Integer.parseInt(String.valueOf(mapaDisco.charAt(i)));
                if (num > 0) {
                    for (int cont = num; cont > 0; cont--) {
                        primeraLinea.append(id);
                        listaNumeros.add(id);
                    }
                }
                id++;

            } else {
                int num1 = Integer.parseInt(String.valueOf(mapaDisco.charAt(i)));
                for (int j = num1; j > 0; j--) {
                    primeraLinea.append(".");
                }
            }
        }

        String linea = primeraLinea.toString();
        long acum = 0;
        int orden = 0;
        int index = linea.indexOf("."); // Encuentra la primera ocurrencia
        for (int cont = 0; cont < index; cont++) {
            acum += (long) orden * listaNumeros.remove(0);
            orden++;
        }
        int distancia = index;
        int nPuntosJuntos = 1;
        int nDigito=0;
       // List<Integer> lista1 = null;
       // boolean bol = true;
        //int[] indiceFree=new int[2];
        //List<Integer> indiceFree = new LinkedList<>();

        // NO HE TENIDO EN CUENTA QUE HAY QUE VER TODOS LOS ESPACIOS NO PASAR AL SIGUIENTE FCK.
        // FALLIDO.
        while (linea.indexOf(".", index+1) != -1) {
            //indiceFree[0]=index;
            index=linea.indexOf(".",index+1);
            distancia=index-distancia;
            while(distancia==1){
                nPuntosJuntos++;
                distancia=index;
                index=linea.indexOf(".", index+1);
                distancia=index-distancia;
            }
            if(nPuntosJuntos>0){
                //indiceFree[1]=index;
                moverBloqueIzquierda(listaNumeros,nPuntosJuntos,orden,acum);
            }
            nDigito=listaNumeros.get(0);
            if(nDigito==1) {
                nDigito=nDigito*distancia;
                for (int i = 0; i < nDigito-1; i++) {
                    acum += (long) orden * listaNumeros.remove(0);
                    orden++;
                }
            }else{
                nDigito=distancia/nDigito;
                for (int i = 0; i < nDigito; i++) {
                    acum += (long) orden * listaNumeros.remove(0);
                    orden++;
                }
            }
        nPuntosJuntos=0;
        }
        System.out.println(acum);
    }

    public static int countDigit(int n) {
        if (n == 0)
            return 1;

        int count = 0;
        while (n != 0) {
            n = n / 10;

            ++count;
        }
        return count;
    }

    public static List<Integer> getBloqueId(List<Integer> list) {
        int num = 0;
        num = list.get(list.size() - 1);
        List<Integer> lista = new LinkedList<>();
        lista.add(num);
        for (int i = list.size() - 2; i > 0; i--) {
            num = list.get(i + 1);
            if (num == list.get(i)) {
                lista.add(num);
                //list.remove(i+1);
            } else {
                break;
            }
        }
        /*
        if(list.get(list.size()-1)==num){
            list.remove(list.size()-1);
        }
        if(lista.size()==1){
            list.remove(list.size()-1);
        }
         */
        return lista;
    }
    public static void moverBloqueIzquierda(List<Integer> listaNumeros, int nEspaciosLibres, int orden, long acum){
        List<Integer> listaCopia=new ArrayList<>(listaNumeros);
        List<Integer> bloque = Collections.emptyList();
        int nDigito=0;
        while(!getBloqueId(listaCopia).isEmpty()){
            nDigito=countDigit(getBloqueId(listaCopia).get(0));
            nDigito=nDigito*getBloqueId(listaCopia).size();
            if(nDigito<=nEspaciosLibres){
                bloque=getBloqueId(listaCopia);
                break;
            }else{
                for(int i=0;i<getBloqueId(listaCopia).size();i++){
                    listaCopia.remove(listaCopia.size()-1);
                }
            }
        }
        if(!bloque.isEmpty()){
            for(Integer integer: bloque){
                acum+= (long) orden *integer;
                orden++;
            }
            //int num=Integer.parseInt(String.valueOf(linea.charAt(linea.indexOf(indexofFree-1))));
            //listaNumeros.indexOf()
        }

    }
}
