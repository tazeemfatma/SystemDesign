package SnakeGame;

public interface Snake {
    void moveSnake(Direction direction);
    boolean isGameOver(Cell nextCell);
    String render();
}
