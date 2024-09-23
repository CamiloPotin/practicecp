/*
2707. Extra Characters in a String

Problema:
Se quiere saber el minimo de caracteres extra al separar un String en palabras que se contienen en un diccionario dado.

Solucion:
Se usa programacion dinamica
chargpt reveer
*/


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        
         int n = s.length();
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary)); 
        
        // dp[i] representa el mínimo número de caracteres extra necesarios para s[i:n]
        int[] dp = new int[n + 1];
        
        // Inicializamos el array dp. dp[n] es 0 porque no quedan caracteres después del final.
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            //System.out.println(dp[i]);
        }
        dp[n] = 0;
        
        // Recorremos la cadena de forma inversa
        for (int i = n - 1; i >= 0; i--) {
            // Por defecto consideramos que el carácter actual es "extra"
            dp[i] = dp[i + 1] + 1;
            
            // Intentamos formar palabras a partir de s[i:j]
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (wordSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                    //System.out.println(dp[i]+" "+substring);
                }
            }
        }
        
        // La respuesta estará en dp[0]
        return dp[0];
        }
    
}
