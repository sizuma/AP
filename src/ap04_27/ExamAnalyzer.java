package ap04_27;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExamAnalyzer {
    ExamScore createExamScore(int math,int physics,int english,String name){
        return new ExamScore(math,physics,english,name);
    }
    ExamScore createRandomScore(String name){
        Random random = new Random();
        Integer math = random.nextInt(101);
        Integer physics = random.nextInt(101);
        Integer english = random.nextInt(101);
        return this.createExamScore(math, physics, english, name);
    }
    void printClassAvg(List<ExamScore> scores){
        double mathAvg = scores.stream().mapToInt(score -> score.math).average().getAsDouble();
        double physAvg = scores.stream().mapToInt(score -> score.physics).average().getAsDouble();
        double englishAvg = scores.stream().mapToInt(score -> score.english).average().getAsDouble();
        System.out.printf("%3s %6s %6s %6s %6s","","math","phys","eng","avg");
        System.out.println();
        System.out.printf("%3s %6s %6s %6s %6s","avg",mathAvg,physAvg,englishAvg,"");
        System.out.println();
    }
    void printScores(List<ExamScore> scores){
        scores.forEach(score -> {
            System.out.printf("%3s %6s %6s %6s %6.3f",score.name,score.math,score.physics,score.english,(score.math+score.physics+score.english)/3.0);
            System.out.println();
        });
    }
    void run(){
        List<ExamScore> scores = IntStream.iterate(0,i -> i+1)
                .limit(10)
                .mapToObj(String::valueOf)
                .map(this::createRandomScore)
                .collect(Collectors.toList());
        printClassAvg(scores);
        printScores(scores);

    }
    public static void main(String[] args){
        new ExamAnalyzer().run();
    }
}
