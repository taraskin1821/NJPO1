/*
Nadpisanie metod equals i hashcode spowodowało usunięcie problemu wycieku pamięci
*/
package memoryleak;

import java.util.Map;



public class MemoryLeak {
    public final String key;
    
    public MemoryLeak(String key) {
        this.key =key;
    }
    
   @Override
    public int hashCode() {
         int result = 0;
         result = 31 * result + this.key.hashCode();
         return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MemoryLeak other = (MemoryLeak) obj;
        return this.key.equals(other.key);
    }
    
    public static void main(String args[]) {
        try {
            Map map = System.getProperties();
            
            for(;;) {
                map.put(new MemoryLeak("key"), "value");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
