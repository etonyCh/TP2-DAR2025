package sharedPackage;

import java.io.Serializable;

public class Operation implements Serializable {
    private double operand1;
    private double operand2;
    private String operator;

    public Operation(double operand1, String operator, double operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public double getOperand1() { return operand1; }
    public double getOperand2() { return operand2; }
    public String getOperator() { return operator; }
}