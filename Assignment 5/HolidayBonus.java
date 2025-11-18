package assignment5;

public class HolidayBonus {

    public static final double HIGH_BONUS = 5000.0;
    public static final double LOW_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;
    
    
    //Calculates the holiday bonus for each store
    public static double[] calculateHolidayBonus(double[][] data) {
        if(data == null) {
            System.exit(1);
        }

        double[] result = new double[data.length];
        int rowCount = data.length;

        int maxColumns = 0;
        for(int r = 0; r < rowCount; r++) {
            if(data[r] != null && data[r].length > maxColumns) {
                maxColumns = data[r].length;
            }
        }

        for(int col = 0; col < maxColumns; col++) {
            int eligibleCount = 0;

            for(int r = 0; r < rowCount; r++) {
                if(data[r] != null && col < data[r].length) {
                    if(data[r][col] > 0.0) {
                        eligibleCount++;
                    }
                }
            }

            if(eligibleCount == 0) {
                continue;
            }
            else if(eligibleCount == 1) {
                for(int r = 0; r < rowCount; r++) {
                    if(data[r] != null && col < data[r].length) {
                        if(data[r][col] > 0.0) {
                            result[r] += HIGH_BONUS;
                            break;
                        }
                    }
                }
                continue;
            }
            else {
                double maxVal = Double.NEGATIVE_INFINITY;
                double minVal = Double.POSITIVE_INFINITY;

                for(int r = 0; r < rowCount; r++) {
                    if(data[r] != null && col < data[r].length) {
                        double val = data[r][col];
                        if(val > 0.0) {
                            if(val > maxVal) {
                                maxVal = val;
                            }
                            if(val < minVal) {
                                minVal = val;
                            }
                        }
                    }
                }

                for(int r = 0; r < rowCount; r++) {
                    if(data[r] != null && col < data[r].length) {
                        double val = data[r][col];
                        if(val > 0.0) {
                            if(val == maxVal) {
                                result[r] += HIGH_BONUS;
                            }
                            else if(val == minVal) {
                                result[r] += LOW_BONUS;
                            }
                            else {
                                result[r] += OTHER_BONUS;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
    //Calculates the total holiday bonuses
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0.0;

        for(int i = 0; i < bonuses.length; i++) {
            total += bonuses[i];
        }

        return total;
    }
}
