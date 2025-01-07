import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Daniel Solis Alfonso
 */
// 688 too low
//answer 839
public class Day8P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Inputs" + File.separator + "08" + File.separator + "input.txt"));
        String linea;
        Antinodo[] antinodos1 = null;
        int cont = 0;
        List<String> mapa = new ArrayList<>();
        linea = bf.readLine();
        while (linea != null) {
            mapa.add(linea);
            linea = bf.readLine();
        }
        bf.close();
        final int xTotal = mapa.get(0).length();
        final int yTotal = mapa.size();
        List<Antena> antenas = getAntenas(mapa);
        Set<Antinodo> setAntinodo = new HashSet<>();
        List<Character> frecuencias = getFrecuencias(antenas);
        for (int i = 0; i < frecuencias.size(); i++) {
            List<Antena> antenaList = filtrarFrecuencia(antenas, frecuencias.get(i));
            for (int k = 0; k < antenaList.size(); k++) {
                for (int j = k + 1; j < antenaList.size(); j++) {
                    Antena antenaA = antenaList.get(k);
                    Antena antenaB = antenaList.get(j);
                    Antinodo[] antinodos = getAntinodos(antenaA, antenaB);
                    antinodos1 = getAntinodos2(antenaA, antenaB,xTotal,yTotal);
                    cont += antinodos1.length;
                    for (Antinodo antinodo : antinodos) {
                        if (antinodo.x < xTotal && antinodo.x >= 0 && antinodo.y < yTotal && antinodo.y >= 0) {
                            if (setAntinodo.add(antinodo)) {
                                System.out.println("x: " + antinodo.x + " y: " + antinodo.y);
                            }
                        }
                    }
                    for (Antinodo antinodo : antinodos1) {
                        System.out.println("Antinodos 2 x: " + antinodo.x + " y: " + antinodo.y);
                    }
                }
            }
        }
        System.out.println(setAntinodo.size() + cont);
    }

    public static class Antena {
        private int x;
        private int y;
        private char frecuencia;

        public Antena(int x, int y, char frecuencia) {
            this.x = x;
            this.y = y;
            this.frecuencia = frecuencia;
        }
    }

    public static class Antinodo {
        private int x;
        private int y;

        public Antinodo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Antinodo antena = (Antinodo) obj;
            return obj != null && (this.x == antena.x && this.y == antena.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static List<Antena> getAntenas(List<String> mapa) {
        List<Antena> lista = new ArrayList<>();
        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(i).length(); j++) {
                if (mapa.get(i).charAt(j) != '.') {
                    Antena antena = new Antena(j, i, mapa.get(i).charAt(j));
                    lista.add(antena);
                }
            }
        }
        return lista;
    }

    public static List<Character> getFrecuencias(List<Antena> antenas) {
        List<Character> characterList = new LinkedList<>();
        for (Antena antena : antenas) {
            if (!characterList.contains(antena.frecuencia)) {
                characterList.add(antena.frecuencia);
            }
        }
        return characterList;
    }

    public static List<Antena> filtrarFrecuencia(List<Antena> antenas, char ch) {
        List<Antena> antenas1 = new ArrayList<>();
        for (Antena antena : antenas) {
            if (antena.frecuencia == ch) {
                antenas1.add(antena);
            }
        }
        return antenas1;
    }

    public static Antinodo[] getAntinodos(Antena antenaA, Antena antenaB) {
        Antinodo antinodo;
        Antinodo antinodo1;
        if (antenaA.y < antenaB.y && antenaA.x > antenaB.x) {
            int distanciax = Math.abs(antenaA.x - antenaB.x);
            int distanciay = Math.abs(antenaA.y - antenaB.y);
            int x = antenaA.x + distanciax;
            int y = antenaA.y - distanciay;
            antinodo = new Antinodo(x, y);
            int x1 = antenaB.x - distanciax;
            int y1 = antenaB.y + distanciay;
            antinodo1 = new Antinodo(x1, y1);
        } else if (antenaA.y < antenaB.y && antenaA.x < antenaB.x) {
            int distanciax = Math.abs(antenaA.x - antenaB.x);
            int distanciay = Math.abs(antenaA.y - antenaB.y);
            int x = antenaA.x - distanciax;
            int y = antenaA.y - distanciay;
            antinodo = new Antinodo(x, y);
            int x1 = antenaB.x + distanciax;
            int y1 = antenaB.y + distanciay;
            antinodo1 = new Antinodo(x1, y1);
        } else if (antenaA.y > antenaB.y && antenaA.x > antenaB.x) {
            int distanciax = Math.abs(antenaA.x - antenaB.x);
            int distanciay = Math.abs(antenaA.y - antenaB.y);
            int x = antenaA.x + distanciax;
            int y = antenaA.y + distanciay;
            antinodo = new Antinodo(x, y);
            int x1 = antenaB.x - distanciax;
            int y1 = antenaB.y - distanciay;
            antinodo1 = new Antinodo(x1, y1);
        } else {
            int distanciax = Math.abs(antenaA.x - antenaB.x);
            int distanciay = Math.abs(antenaA.y - antenaB.y);
            int x = antenaA.x - distanciax;
            int y = antenaA.y + distanciay;
            antinodo = new Antinodo(x, y);
            int x1 = antenaB.x + distanciax;
            int y1 = antenaB.y - distanciay;
            antinodo1 = new Antinodo(x1, y1);
        }
        return new Antinodo[]{antinodo, antinodo1};
    }

    public static Antinodo[] getAntinodos2(Antena antenaA, Antena antenaB, int totalX, int totalY) {
        List<Antinodo> antinodos = new ArrayList<>();

        if (antenaA.x >= 0 && antenaA.x < totalX && antenaA.y >= 0 && antenaA.y < totalY) {
            antinodos.add(new Antinodo(antenaA.x, antenaA.y));
        }
        if (antenaB.x >= 0 && antenaB.x < totalX && antenaB.y >= 0 && antenaB.y < totalY) {
            antinodos.add(new Antinodo(antenaB.x, antenaB.y));
        }
        // Verificar alineación diagonal
        int deltaX = Math.abs(antenaA.x - antenaB.x);
        int deltaY = Math.abs(antenaA.y - antenaB.y);
        if (deltaX == deltaY) {
            int stepX = antenaA.x < antenaB.x ? 1 : -1;
            int stepY = antenaA.y < antenaB.y ? 1 : -1;

            int x = antenaA.x, y = antenaA.y;
            while (x != antenaB.x && y != antenaB.y) {
                if (x >= 0 && x < totalX && y >= 0 && y < totalY) {
                    antinodos.add(new Antinodo(x, y));
                }
                x += stepX;
                y += stepY;
            }

            if (antenaB.x >= 0 && antenaB.x < totalX && antenaB.y >= 0 && antenaB.y < totalY) {
                antinodos.add(new Antinodo(antenaB.x, antenaB.y));
            }
        }

        return antinodos.toArray(new Antinodo[0]);
    }
}

