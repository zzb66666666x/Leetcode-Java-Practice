class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] p1shift = new int[]{0,0};
        int[] p2shift = new int[]{p2[0] - p1[0], p2[1] - p1[1]};
        int[] p3shift = new int[]{p3[0] - p1[0], p3[1] - p1[1]};
        int[] p4shift = new int[]{p4[0] - p1[0], p4[1] - p1[1]};
        double norm12 = norm(p1shift, p2shift);
        double norm13 = norm(p1shift, p3shift);
        double norm14 = norm(p1shift, p4shift);
        if (norm12 > norm13 && norm12 > norm14 && isClose(norm13, norm14)){
            if (vecDot(p2shift, p3shift)>0 && vecDot(p2shift, p3shift)>0){
                int[] vec23 = vecMinus(p3shift, p2shift);
                int[] vec24 = vecMinus(p4shift, p2shift);
                return checkAngle(p3shift, p4shift) && checkAngle(vec23, p3shift) && checkAngle(vec24, p4shift);
            }else{
                return false;
            }
        }else if (norm13 > norm12 && norm13 > norm14 && isClose(norm12, norm14)){
            if (vecDot(p2shift, p3shift)>0 && vecDot(p3shift, p4shift)>0){
                int[] vec32 = vecMinus(p2shift, p3shift);
                int[] vec34 = vecMinus(p4shift, p3shift);
                return checkAngle(p2shift, p4shift) && checkAngle(vec32, p2shift) && checkAngle(vec34, p4shift);
            }else{
                return false;
            }
        }else if (norm14 > norm12 && norm14 > norm13 && isClose(norm12, norm13)){
            if (vecDot(p2shift, p4shift)>0 && vecDot(p3shift, p4shift)>0){
                int[] vec43 = vecMinus(p3shift, p4shift);
                int[] vec42 = vecMinus(p2shift, p4shift);
                return checkAngle(p2shift, p3shift) && checkAngle(vec43, p3shift) && checkAngle(vec42, p2shift);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private int[] vecMinus(int[] v1, int[] v2){
        return new int[]{v1[0]-v2[0], v1[1]-v2[1]};
    }

    private double norm(int[] v1, int[] v2){
        int tmp1 = v1[0] - v2[0];
        int tmp2 = v1[1] - v2[1];
        return Math.sqrt(tmp1*tmp1 + tmp2*tmp2);
    }

    private boolean checkAngle(int[] v1, int[] v2){
        return isClose(0.0, vecDot(v1, v2));
    }

    private int vecDot(int[] v1, int[] v2){
        return v1[0]*v2[0] + v1[1]*v2[1];
    }

    private boolean isClose(double a, double b){
        return Math.abs(a-b) < 0.00001? true : false;
    }
}
