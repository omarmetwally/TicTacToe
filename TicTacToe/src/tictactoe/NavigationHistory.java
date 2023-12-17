/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Omar
 */
import javafx.scene.Scene;
import java.util.Stack;

public class NavigationHistory {
    private Stack<Scene> history = new Stack<>();

    public void pushScene(Scene scene) {
        history.push(scene);
    }

    public Scene popScene() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public Scene peekScene() {
        if (!history.isEmpty()) {
            return history.peek();
        }
        return null;
    }
}
