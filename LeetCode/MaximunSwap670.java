/*
670. Maximum Swap

Problema:
Se quiere conseguir el numero mas alto posible cambiando de lugar a lo sumo 1 digito de un numero

Solucion:
Se guardan los digitos en una lista y se recorre buscando los indices de los numeros a cambiar
luego se crea nuevamente el numero.


*/





class Solution {
    public int maximumSwap(int num) {
        List<Integer>arr = new ArrayList<>();
        int x = num;
        while(x > 0){
            arr.add(x%10);
            x/=10;
        }
        int idx = -1;
        int idy = -1;
        int max = -1;
        for(int i = 0; i < arr.size(); i++){
            if(max == -1 || arr.get(max) < arr.get(i)){
                max = i;
            }
            else if(arr.get(max) > arr.get(i)){
                idx =i;
                idy = max;
            }
        }
        if(idx != -1 && idy != -1){
            int temp = arr.get(idx);
            arr.set(idx,arr.get(idy));
            arr.set(idy,temp);
        }
        int curr = 0;
        for(int i = arr.size()-1; i>=0; i--){
            curr*=10;
            curr+=arr.get(i);
        }
        return curr;
    }
}
