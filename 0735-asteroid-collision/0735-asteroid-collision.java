import java.util.*;

class Solution {
    // Simulates asteroid collisions with an array stack.
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> survivors = new ArrayList<>();

        // Process asteroids from left to right.
        for (int asteroid : asteroids) {
            // A right mover cannot hit earlier asteroids.
            if (asteroid > 0) {
                survivors.add(asteroid);
            } else {
                int currentSize = Math.abs(asteroid);
                boolean destroyed = false;

                // Check only right movers nearest to the asteroid.
                while (!survivors.isEmpty()
                        && survivors.get(survivors.size() - 1) > 0) {
                    int topIndex = survivors.size() - 1;
                    int topSize = Math.abs(survivors.get(topIndex));

                    // Smaller right movers explode first.
                    if (topSize < currentSize) {
                        survivors.remove(topIndex);
                    } else {
                        // Equal size removes the stored asteroid too.
                        if (topSize == currentSize) {
                            survivors.remove(topIndex);
                        }

                        destroyed = true;
                        break;
                    }
                }

                // Store a left mover after every blocker is gone.
                if (!destroyed) {
                    survivors.add(asteroid);
                }
            }
        }

        int[] answer = new int[survivors.size()];

        // Copy list values into the required array result.
        for (int index = 0; index < survivors.size(); index++) {
            answer[index] = survivors.get(index);
        }

        return answer;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        Solution obj = new Solution();
        int[] answer = obj.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(answer));
    }
}