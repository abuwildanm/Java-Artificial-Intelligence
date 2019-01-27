package InformedSearch;

public class Test
{
    public static void main(String[] args)
    {
        Pair startNode = new Pair(2, 1);

        GreedyBestFirstSearch greedy = new GreedyBestFirstSearch(startNode);
        greedy.greedy();
    }
}
