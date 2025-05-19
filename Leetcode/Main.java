import java.util.*;
// Main class
public class Main {
    public static void main(String[] args) {
        LeetCodePlatform platform = new LeetCodePlatform();

        // Register users
        platform.register("admin", "admin123", true);
        platform.register("alice", "alice123", false);

        // Admin login and create problems
        if (platform.login("admin", "admin123") && platform.isAdmin("admin")) {
            platform.addProblem("Two Sum", "Find two numbers that add up to a target.", "Easy");
            platform.addProblem("Longest Substring Without Repeating Characters", "Find the length of the longest substring without repeating characters.", "Medium");
        }

        // User login
        String currentUser = "alice";
        if (platform.login(currentUser, "alice123")) {
            System.out.println("Logged in as " + currentUser);

            // View problems
            System.out.println("\nAvailable Problems:");
            for (Problem p : platform.listProblems()) {
                System.out.println(p);
            }

            // Submit solution
            System.out.println("\nSubmitting solution to Problem ID 1...");
            String code = "public int[] twoSum(int[] nums, int target) { return new int[]{0,1}; }";
            String result = platform.submit(currentUser, 1, code);
            System.out.println("Submission Result: " + result);

            // View submission history
            System.out.println("\nYour Submissions:");
            for (Submission s : platform.viewSubmissions(currentUser)) {
                System.out.println(s);
            }
        } else {
            System.out.println("Login failed!");
        }
    }
}