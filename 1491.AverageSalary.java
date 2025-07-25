class Solution {
    public double average(int[] salary) {
        /* Approach 1 
            traverse the array and search for the smallest and the largest element and store them.
            in the same traversal calculate the sum of all elements in the array.
            And  for the result simply store sum-(min+max) and then devide by the length of the array - min and max. [size-2]

        */

        int min = salary[0];
        int max = salary[0];
        int sum = salary[0];

        for(int i=1;i<salary.length;i++){
            if(salary[i]>max) max = salary[i];
            else if(salary[i]<min) min = salary[i];
            sum += salary[i];
        }
        sum = sum - min - max;
        double ans = (double)sum/(salary.length-2);
        return ans;
    }
}
