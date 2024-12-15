// class Solution {
//     public double maxAverageRatio(int[][] classes, int extraStudents) {
//         // Lambda-like comparator for calculating gain in Java
//         PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
//         double sum = 0.0;

//         // Initialize the heap with gains and add the initial ratios to sum
//         for (int[] cls : classes) {
//             int pass = cls[0], total = cls[1];
//             double currentRatio = (double) pass / total;
//             double gain = ((double) (pass + 1) / (total + 1)) - currentRatio;
//             sum += currentRatio;
//             maxHeap.offer(new double[]{gain, pass, total});
//         }

//         // Distribute extra students to maximize the average ratio
//         for (int i = 0; i < extraStudents; i++) {
//             double[] top = maxHeap.poll();
//             double gain = top[0];
//             int pass = (int) top[1];
//             int total = (int) top[2];

//             // Update the sum by removing the old ratio and adding the new one
//             sum -= (double) pass / total;
//             pass++;
//             total++;
//             sum += (double) pass / total;

//             // Recalculate the gain and push back into the heap
//             double newGain = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
//             maxHeap.offer(new double[]{newGain, pass, total});
//         }

//         // Return the final average
//         return sum / classes.length;
//     }
// }

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());
        for(int[] cl : classes){
            pq.add(new ClassRecord(cl));
        }

        ClassRecord cl;
        while(extraStudents-- > 0){
            pq.add(pq.remove().addOneStudent());
        }
        double sum = 0;
        while(!pq.isEmpty()){
            cl = pq.remove();
            sum += (double)cl.pass/cl.total;
        }
        return sum / classes.length;
    }
}

class ClassRecord{
    int pass;
    int total;
    double inc;
    public ClassRecord(int[] array){
        pass = array[0];
        total = array[1];
        inc = getIncrement();
    }

    public ClassRecord addOneStudent(){
        pass++;
        total++;
        inc = getIncrement();
        return this;
    }

    private double getIncrement(){
        return (pass + 1.0)/(total + 1) - (double)pass/total;
    }
}

class Compare implements Comparator<ClassRecord>{
    public int compare(ClassRecord a, ClassRecord b){
        if(a.inc < b.inc){
            return 1;
        }
        else if(a.inc > b.inc){
            return -1;
        }
        else{
            return 0;
        }
    }
}