import java.util.*;
// Submission entity
public class Submission {
    private String username;
    private int problemId;
    private String code;
    private String result;
    private long timestamp;

    public Submission(String username, int problemId, String code, String result) {
        this.username = username;
        this.problemId = problemId;
        this.code = code;
        this.result = result;
        this.timestamp = System.currentTimeMillis();
    }

    public String getUsername() { return username; }
    public int getProblemId() { return problemId; }
    public String getCode() { return code; }
    public String getResult() { return result; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Problem ID: " + problemId + ", Result: " + result + ", Time: " + new Date(timestamp);
    }
}