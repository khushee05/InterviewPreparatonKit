/*
Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Sample Input 0

6 4
give me one grand today night
give one grand today
Sample Output 0

Yes
Sample Input 1

6 5
two times three is not four
two times two is four
Sample Output 1

No
Explanation 1

'two' only occurs once in the magazine.
*/


import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        this.noteMap = new HashMap<String, Integer>();
        this.magazineMap = new HashMap<String, Integer>();
        
        
        for(String s : magazine.split("[^a-zA-Z]+")) {
            if(!magazineMap.containsKey(s)){
                magazineMap.put(s, 1);
            }
            //occurrences = magazineMap.get(s);
            
            else {
                magazineMap.put(s,  magazineMap.get(s) + 1);
            }
        }
        
        for(String s : note.split("[^a-zA-Z]+")) {
         
            
            if(!noteMap.containsKey(s)) {
                noteMap.put(s, 1);
            }
            else {
                noteMap.put(s, noteMap.get(s) + 1);
            }
        }
        
    }
    
    public void solve() {
        boolean canReplicate = true;
        for(String s : noteMap.keySet()) {
            if(!magazineMap.containsKey(s) || (magazineMap.get(s) < noteMap.get(s)) ) {
                canReplicate = false;
                break;
            }
        }
        
        System.out.println( (canReplicate) ? "Yes" : "No" );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String magazine =scanner.nextLine();
        String note = scanner.nextLine();
        
        Solution s = new Solution(magazine, note);
        s.solve();
    }
}
