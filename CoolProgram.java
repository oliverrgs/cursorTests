public class CoolProgram {
    public static void main(String[] args){
        // Create a cool ASCII art pattern
        String[] pattern = {
            "    *    ",
            "   ***   ",
            "  *****  ", 
            " ******* ",
            "*********"
        };
        
        // Print the pattern
        System.out.println("Here's something cool:");
        for (String line : pattern) {
            System.out.println(line);
        }
        
        // Add a fun animation effect
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println("\nTa-da! ✨");
        } catch (InterruptedException e) {
            System.out.println("Animation interrupted!");
        }
    }
}