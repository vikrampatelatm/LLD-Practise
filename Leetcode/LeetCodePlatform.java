import java.util.*;

// Platform service
public class LeetCodePlatform{
    private Map<String, User> users = new HashMap<>();
    private Map<Integer, Problem> problems = new HashMap<>();
    private List<Submission> submissions = new ArrayList<>();
    private int problemIdCounter = 1;

    public boolean register(String username, String password, boolean isAdmin) {
        if (users.containsKey(username)) return false;
        users.put(username, new User(username, password, isAdmin));
        return true;
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean isAdmin(String username) {
        User user = users.get(username);
        return user != null && user.isAdmin();
    }

    public int addProblem(String title, String description, String difficulty) {
        Problem problem = new Problem(problemIdCounter, title, description, difficulty);
        problems.put(problemIdCounter, problem);
        return problemIdCounter++;
    }

    public List<Problem> listProblems() {
        return new ArrayList<>(problems.values());
    }

    public String submit(String username, int problemId, String code) {
        if (!problems.containsKey(problemId)) return "Problem not found";
        String result = mockEvaluate(code); // mock evaluation
        Submission submission = new Submission(username, problemId, code, result);
        submissions.add(submission);
        return result;
    }

    public List<Submission> viewSubmissions(String username) {
        List<Submission> userSubs = new ArrayList<>();
        for (Submission s : submissions) {
            if (s.getUsername().equals(username)) userSubs.add(s);
        }
        return userSubs;
    }

    private String mockEvaluate(String code) {
        return code.contains("return") ? "Accepted" : "Wrong Answer";
    }
}