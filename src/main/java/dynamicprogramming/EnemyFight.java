package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.careercup.com/question?id=5697406160076800
 */
public class EnemyFight {

    class Player {
        int strength;
        int money;

        public Player(int strength, int money) {
            this.strength = strength;
            this.money = money;
        }
    }

    class Enemy {
        int strength;
        int price;

        public Enemy(int strength, int price) {
            this.strength = strength;
            this.price = price;
        }
    }

    @Test
    public void test() {

        Player player = new Player(10, 10);
        Enemy enemy1 = new Enemy(4, 5);
        Enemy enemy2 = new Enemy(2, 3);
        Enemy enemy3 = new Enemy(3, 5);
        Enemy enemy4 = new Enemy(4, 4);
        List<Enemy> enemies = new ArrayList<Enemy>() {{ add(enemy1); add(enemy2); add(enemy3); add(enemy4); }};

        assertEquals(5, fightEnemies(enemies));
    }

    private int fightEnemies(List<Enemy> enemies) {
        return 0;
    }


}
