public class PuzzleDriver {

    private static PuzzleSolution[] solutions = {
            new Problem1(),
            new Problem2(),
            new Problem3(),
            new Problem4(),
            new Problem5(),
            new Problem6(),
            new Problem7(),
            new Problem8(),
            new Problem9(),
            new Problem10()
    };

    public static void main(String[] args) {
        for (PuzzleSolution solution : solutions) {
            System.out.printf("%s solution: %s\n",
                    solution.getClass().getSimpleName(), solution.run());
        }
    }

}
