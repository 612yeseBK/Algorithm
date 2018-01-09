package Tree;

import java.util.Random;

public class RandomMyTree {
    public static MyTree getRandomTree(){
        return new MyTree(Math.random());
    }
}
