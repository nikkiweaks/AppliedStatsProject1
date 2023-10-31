import java.util.ArrayList;

public class test {
    public static void main(String[]args){
        StatsLibrary test = new StatsLibrary();

        //testing mean
        ArrayList<Double> testNumbers = new ArrayList<>();
        testNumbers.add(1.0);
        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);

        double testerResults = test.findMean(testNumbers);
        System.out.println();
        System.out.println("This is the average of testNumbers: " + testerResults);

        //testing median
        testerResults = test.findMedian(testNumbers);
        System.out.println();
        System.out.println("This is the median of testNumbers: " + testerResults);

        //testing mode
        testerResults = test.findMode(testNumbers);
        System.out.println();
        System.out.println("This is the mode of testNumbers: " + testerResults);

        //testing variance and standard deviation
        double [] testResults = test.standardDeviation(testNumbers);
        System.out.println();
        System.out.println("This is the variance testResults: " + testResults[0]);
        System.out.println("This is the standard deviation testResults: " + testResults[1]);

        //testing union
        ArrayList<Integer> set1 = new ArrayList<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        
        ArrayList<Integer> set2 = new ArrayList<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(5);

        System.out.println();
        System.out.println("This is the union of set1 and set2: " + test.union(set1, set2));

        //testing intersection
        System.out.println();
        System.out.println("This is the intersection of set1 and set2: " + test.intersection(set1, set2));

        //testing compliment
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        System.out.println();
        System.out.println("This is the compliment of the subset of set: " + test.compliment(set, subset));

        //testing factorial
        System.out.println();
        System.out.println("This is the factorial of 10: " + test.factorial(52));

        //testing permutation and combinations
        double [] newTestResults = test.permutationCombinations(13, 5);
        System.out.println();
        System.out.println("This is the permutation of 13 and 5: " + newTestResults[0]);
        System.out.println("This is the combination of 13 and 5: " + newTestResults[1]);

        //testing conditional probability
        ArrayList<Integer> conditionalset = new ArrayList<>();
        conditionalset.add(1);
        conditionalset.add(2);
        conditionalset.add(3);
        conditionalset.add(4);
        conditionalset.add(5);
        conditionalset.add(6);

        ArrayList<Integer> conditionalsubset1 = new ArrayList<>();
        conditionalsubset1.add(1);
        conditionalsubset1.add(3);
        conditionalsubset1.add(5);

        ArrayList<Integer> conditionalsubset2 = new ArrayList<>();
        conditionalsubset2.add(4);
        conditionalsubset2.add(5);
        conditionalsubset2.add(6);

        System.out.println();
        System.out.println("This is the conditional probability for class example: " + test.conditionalProbability(conditionalset, conditionalsubset1, conditionalsubset2));

        //testing bayes
        System.out.println();
        System.out.println("This is the bayes theorem for class example: " + test.bayes(conditionalset, conditionalsubset1, conditionalsubset2));

        //testing for independence
        System.out.println();
        System.out.println("Are these subsets independent?: " + test.independance(conditionalset, conditionalsubset1, conditionalsubset2));

        //testing binomial distribution
        System.out.println();
        System.out.println("This is the binomial distribution for coin toss example: " + test.binomialDistributions(10, 7, .80));

        //testing geometric distribution
        newTestResults = test.geometricDistribution(3, .45, 0, 1);
        System.out.println();
        System.out.println("This is the geometric distribution for example 2 from our notes: " + newTestResults[0]);
        System.out.println("This is the geometric distribution variance for example 2 from our notes: " + newTestResults[1]);
        System.out.println("This is the geometric distribution standard deviation for example 2 from our notes: " + newTestResults[2]);

        //testing hypergeometric distribution
        newTestResults = test.hyperGeometricDistribution(6, 4, 20, 5);
        System.out.println();
        System.out.println("This is the hypergeometric distribution for class example: " + newTestResults[0]);
        System.out.println("This is the hypergeometric distribution variance for class example: " + newTestResults[1]);
        System.out.println("This is the hypergeometric distribution standard deviation for class example: " + newTestResults[2]);

        //testing negative binomial distribution
        newTestResults = test.negativeBinomialDistribution(3, 5, 2);
        System.out.println();
        System.out.println("This is the negative binomial distribution for class example: " + newTestResults[0]);
        System.out.println("This is the negative binomial distribution variance for class example: " + newTestResults[1]);
        System.out.println("This is the negative binomial distribution standard deviation for class example: " + newTestResults[2]);

        //testing poisson distribution
        newTestResults = test.poissonDistribution(3.5, 2);
        System.out.println();
        System.out.println("This is the poisson distribution for class example: " + newTestResults[0]);
        System.out.println("This is the poisson binomial distribution variance and standard deviation for class example: " + newTestResults[1]);

        //testing Tchebysheff's theorem
        System.out.println();
        System.out.println("This is the percentage of class example using Tchebysheff's theorem: " + test.tchebysheffsTheorem(14, 151, 179) + "%");
    }


}
