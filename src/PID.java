public class PID {

    private double Kp, Ki, Kd;
    private double limMin, limMax;
    public double integral;
    private double lastError;

    public PID(double Kp, double Ki, double Kd, double limMin, double limMax){
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        this.limMin = limMin;
        this.limMax = limMax;
    }

    public double run(double target, double measurement){
        return run(target - measurement);
    }
    public double run(double error){
        double proportional = Kp * error;
        integral += (error + lastError)/2;
        double derivative = error - lastError;

        double minNum, maxNum;
        minNum = Math.max(proportional, limMin);
        maxNum = Math.min(proportional, limMax);

        if(proportional < limMin){
            proportional = limMin;
        } else if(proportional > limMax){
            proportional = limMax;
        }

        if(integral < minNum){
            integral = minNum;
        } else if(integral > maxNum){
            integral = maxNum;
        }

        lastError = error;

        return proportional + derivative + (Ki * integral);
    }
}
