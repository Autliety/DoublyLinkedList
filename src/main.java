/**
 * Liner Data Structure
 * @author Autliety
 */

public class main {
    
    public static void main(String[] args) {
        ListController lc = new ListController("./LinkedList-Wiki.txt");
        
        lc.print(">>>Print the list:");
        
        lc.sort();
        lc.print("\n>>>Sort ascending and Print:");
        
        lc.reBuild();
        lc.pick3Most(true);
        lc.print("\n>>>Print 3 largest occurrence:");
        
        lc.reBuild();
        lc.pick3Most(false);
        lc.print("\n>>>Print 3 smallest occurrence:");
        
        lc.reBuild();
        lc.deleteLessThan7();
        lc.print("\n>>>Delete occurrence less than 7:");
    }
}
