package investwise.Goal;

public class FinancialGoal {

    private int goalID;
    private String description;
    private double targetAmount;
    private double currentProgress;

    public FinancialGoal(int goalID, String description, double targetAmount) {
        this.goalID = goalID;
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentProgress = 0;
    }

    // Setters
    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public void setDescription(String description) {
      this.description = description ;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void setCurrentProgress(double currentProgress) {
            this.currentProgress = currentProgress;
    }

    // Getters
    public int getGoalID() {
        return goalID;
    }

    public String getDescription() {
        return description;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentProgress() {
        return currentProgress;
    }
}
