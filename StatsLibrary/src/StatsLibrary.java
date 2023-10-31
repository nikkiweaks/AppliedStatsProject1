import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

public class StatsLibrary {
   
    public double findMean(ArrayList<Double> userInputNumber){

        double sum = 0;

        for(double singleElement : userInputNumber){
            sum = sum + singleElement;
        }

        double result = sum / userInputNumber.size();
        return result;
    }

    public double findMedian(ArrayList<Double> userInputNumber){

        double result = 0;

        //sorts arraylist and checks if arraylist does not contain an even number of elements
        Collections.sort(userInputNumber);
        if(userInputNumber.size() % 2 != 0){
            result = userInputNumber.get(userInputNumber.size() / 2);
        }

        result = (userInputNumber.get((userInputNumber.size() - 1) / 2) + userInputNumber.get(userInputNumber.size() / 2)) / 2.0;

        return result;
    }
    public double findMode(ArrayList<Double> userInputNumber){
        
        int max = 0; 
        int count = 0;
        double result = 0; 
        double currentValue = 0;

        for (int i = 0; i < userInputNumber.size(); i++) { 

            //checks if the current index is already set as the mode, if so add to the count
            if (userInputNumber.get(i) == currentValue){
                count++; 
            }
            else {
                count = 1; 
                currentValue = userInputNumber.get(i); 
            }

            if (count > max) {
                result = currentValue;          
                max = count;  
            }
        }

        //checks if there is a mode, if not returns 0
        if(max > 1){
            return result;
        }
        return result = 0; 

    }

    public double[] standardDeviation(ArrayList<Double> userInputNumber){
        double result = 0;
        double sum = 0;
        double variance = 0;

        //loop that finds the mean of an arraylist and finds the deviation from every element from said mean, squares the number and adds up all the squares
        for(int i = 0; i < userInputNumber.size(); i++){
            double square = Math.pow(userInputNumber.get(i) - findMean(userInputNumber), 2);
            sum += square;
        }

        variance = sum / userInputNumber.size();
        result = Math.sqrt(variance);

        //prints out variance if index 0 is called, or standard deviation if index 1 is called
        double[] end = new double[2]; 
        end[0] = variance; 
        end[1] = result;

        return end;
    }

    public List<Integer> union(ArrayList<Integer> set1, ArrayList<Integer> set2){ 
        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(set1);
        list.addAll(set2);

        //source: tutorialspoint, used to get only the distinct values into a list
        List<Integer> result = list.stream().distinct().collect(Collectors.toList());
        

        Collections.sort(result);

        return result;
    }

    public ArrayList<Integer> intersection(ArrayList<Integer> set1, ArrayList<Integer> set2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
       
        //adds all elements of set 1 into an arraylist result, will only keep or "retain" elements that are also in set2
        result.addAll(set1);
        result.retainAll(set2);
        
        Collections.sort(result);

        return result;
    }

    public ArrayList<Integer> compliment(ArrayList<Integer> set, ArrayList<Integer> subset){
        ArrayList<Integer> result = new ArrayList<Integer>();

        //uses the intersection method to find common elements between full set and subset, removes only those elements
        set.removeAll(intersection(set, subset));

        result = set;

        return result;
    }

    public double factorial(double userInputNumber){
        double result = 1;   

        //loop that times the current result with the next element up, stops at userInputNumber
        //must start at 1 since anything divided by 0 stays at 0
        for(int i = 1; i <= userInputNumber; i++){    
            result = result * i;    
        }    

        return result;
    }

    public double[] permutationCombinations(double n, double r){
        double permutation = factorial(n) / factorial(n - r);
        double combination = factorial(n) / (factorial(r) * factorial(n - r));

        //inputs permutations and combination into an array, user can choose what is shown in output
        double[] result = new double[2]; 
        result[0] = permutation; 
        result[1] = combination;

        return result;
    }

    //method to find the probability of a set and a subset
    public double probability(ArrayList<Integer> fullset, ArrayList<Integer> set1){
        double result = ((float)set1.size()) / fullset.size();

        return result;
    }

    public double conditionalProbability(ArrayList<Integer> fullset, ArrayList<Integer> set1, ArrayList<Integer> set2){
        double result = 0;
        ArrayList<Integer> list = intersection(set1, set2);

        //finds the probability of all elements that are in both set1 and set2 against the fullset
        double prob = probability(fullset, list);

        //divides the original probability against only the probabaility of set2
        result = prob / (probability(fullset, set2));

        return result;

    }

    public double bayes(ArrayList<Integer> fullset, ArrayList<Integer> set1, ArrayList<Integer> set2){
        double result = 0;

        //uses condiditonal probabaility and probabaility methods in bayes formula. 
        result = (conditionalProbability(fullset, set1, set2) * probability(fullset, set2)) / 
            ((conditionalProbability(fullset, set1, set2) * probability(fullset, set2)) + (conditionalProbability(fullset, set1, compliment(fullset, set2)) * probability(fullset, compliment(fullset, set2))));

        return result;

    }

    public boolean independance(ArrayList<Integer> fullset, ArrayList<Integer> set1, ArrayList<Integer> set2){
        boolean result = false;

        if(conditionalProbability(fullset, set1, set2) == (probability(fullset, set1))){
            result = true;
        }else if (conditionalProbability(fullset, set2, set1) == probability(fullset, set2)){
            result = true;
        }else if (probability(fullset, intersection(set1, set2)) == probability(fullset, set1) * probability(fullset, set2)){
            result = true;
        }else{
            result = false;
        }

        return result;
    }
    

    public double binomialDistributions(double n, double y, double p){
        double result = 0;

        //creates array and calls permutationCombinations, only the combination is needed so only the first index is called
        double [] combination = permutationCombinations(n, y);

        result =  ( combination[1] * Math.pow(p, y) * (Math.pow(1 - p, n - y)));

        return result;
    }

    public double[]  geometricDistribution(double y, double p, double n, int i){
        double[] result = new double[3];
        double geo = 0;

        //switch case to figure out what formula to use, user must input a number 1-5 to use a formula
        //it is assumed that the user already knows which formula they want to use
        switch(i){
            //regular geometric formula
            case 1: geo = (Math.pow(1 - p, y - 1) * p);
                    break;
            //on or before nth trial
            case 2: geo = (1 - Math.pow(1 - p, n));
                    break;
            //before nth trial
            case 3: geo = (1 - Math.pow(1 - p, n - 1));
                    break;
            //on or after nth trial
            case 4: geo = (Math.pow(1 - p, n - 1));
                    break;
            //after nth trial
            case 5: geo = (Math.pow(1 - p, n));
            //if something else is picked
            default: geo = 0;
        }

        double variance = (1 / p);

        double standardDeviation = ((1 - p) / Math.pow(p, 2));

        //prints geometric answer at index 0, variance at index 1, or standard deviation at index 2 
        result[0] = geo;
        result[1] = variance;
        result[2] = standardDeviation;

        return result;
    }

    public double[] hyperGeometricDistribution(double r, double y, double N, double n){
        double[] result = new double[3]; 

        //creates an array of the three combinations needed for hypergeometric
        double [] combination1 = permutationCombinations(r, y);
        double [] combination2 = permutationCombinations(N - r, n - y);
        double [] combination3 = permutationCombinations(N, n);

        double hyper = ((combination1[1] * combination2[1]) / combination3[1]);
        double variance = (n * r) / N;
        double standardDeviation = (n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1)));

        //prints hypergeometric answer at index 0, variance at index 1, or standard deviation at index 2 
        result[0] = hyper;
        result[1] = variance;
        result[2] = standardDeviation;

        return result;

    }

    public double[] negativeBinomialDistribution(double r, double y, double p){
        double[] result = new double[3];
        double [] combination = permutationCombinations(y - 1, r - 1);

        double negative = (combination[1] * Math.pow(p, r) * Math.pow(1 - p, y - r));
        double variance = r / p;
        double standardDeviation = (r * (1 - p) / Math.pow(p, 2));

        //prints negativebinomial answer at index 0, variance at index 1, or standard deviation at index 2 
        result[0] = negative;
        result[1] = variance;
        result[2] = standardDeviation;

        return result;
    }

    public double[] poissonDistribution(double lambda, double y){
        double[] result = new double[2];

        double poisson = (Math.exp(-lambda) * Math.pow(lambda, y)) / factorial(y);
        double variance = lambda;

        //since both variance and standard deviation are lambda, can just use variance if user is looking for standard deviation
        result[0] = poisson;
        result[1] = variance;

        return result;

    }

    public double tchebysheffsTheorem(double standardDevation, double mean, double endingVal){
        
        //uses the ending value and mean to find the within number, which in this case is 'm' and finds k by using the within number divided by the standard deviation
        double m = (endingVal - mean);
        double k = (m / standardDevation);
        double result = (1 - (1 / Math.pow(k, 2))) * 100;

        return result;

    }
}
