/*
2661. First Completely Painted Row or Column

Problema:
Se tiene un arreglo de numeros y una matriz y se quiere "pinta" cada celda de la matriz donde este ubicado un numero del arreglo,
se quiere devolver el indice minimo en el que se pinta una columna o fila de la misma.

Solucion:
Primero se guarda la posicion de cada numero de la matriz en un map y luego se recorre el arreglo contando la frecuencia para cada fila y columna
revisando el map, cuando se completa alguna se devuelve el indice dado

*/


class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
    Map<Integer,List<Integer>> map = new HashMap<>();
    int column = mat.length;
    int row =  mat[0].length;
    for(int i = 0 ; i < column;i++){
        for(int j = 0 ; j < row ; j++){
            int n = mat[i][j];
            List<Integer> index = new ArrayList<>();
            index.add(i);
            index.add(j);
            map.put(n, index);
            //System.out.println(n+" "+map.get(n));
        }
    }
    
    int[] frec = new int[column+row];
    int i;
    for( i = 0 ; i < arr.length ; i++){
      
        int curr = arr[i];
       // System.out.println(curr+" "+map.get(curr));
        int r = map.get(curr).get(0);
        int c = map.get(curr).get(1);
        frec[c]++;
        frec[r+row]++;
        if(frec[c]==column || frec[r+row]==row){
            return i;
        }

    }
    return i;
    }
}
