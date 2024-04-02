package SnakeGame;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SnakeImplTest {
    private SnakeImpl snakeGame;

    @Before
    public void setUp() {
        // Initialize the snake game with a 5x5 board and an initial position
        int rows = 5;
        int cols = 5;
        Cell initialPosition = new Cell(2, 2); // Middle of the board
        Queue<Cell> foodQueue = new LinkedList<>(); // Predefined food queue (empty for now)
        snakeGame = new SnakeImpl(rows, cols, initialPosition, foodQueue);
    }

    @Test
    public void testMoveSnake_ValidMove() {
        // Arrange
        Direction moveDirection = Direction.RIGHT; // Assuming RIGHT is a valid move
        Cell head = snakeGame.snake.getFirst();
        // Act
        snakeGame.moveSnake(moveDirection);
        Cell newHead = snakeGame.snake.getFirst();
        assertEquals(head.getRow(), newHead.getRow());
        assertEquals(head.getCol() + 1, newHead.getCol());
    }

    @Test
    public void testMoveSnake_FoodConsumption() {
        snakeGame.foodCell=new Cell(snakeGame.snake.getFirst().getRow()+1,snakeGame.snake.getFirst().getCol());
        Cell food=snakeGame.foodCell;
        Direction moveDirection = Direction.DOWN; // Assuming DOWN leads to foodCell
        snakeGame.moveSnake(moveDirection);
        assertEquals(food.getRow(),snakeGame.snake.getFirst().getRow());
        assertEquals(food.getCol(),snakeGame.snake.getFirst().getCol());

    }

    @Test
    public void testMoveSnake_GameOver() {
        Direction invalidMoveDirection = Direction.RIGHT;
        snakeGame.moveSnake(invalidMoveDirection);
        snakeGame.moveSnake(invalidMoveDirection);
        Cell newHead = snakeGame.snake.getFirst();
        assertTrue(snakeGame.isGameOver(newHead));
    }

    @Test
    public void testMoveSnake_inValidMove() {
        Direction moveDirection = Direction.RIGHT;
        snakeGame.moveSnake(moveDirection);
        Cell head = snakeGame.snake.getFirst();
        moveDirection = Direction.LEFT;
        snakeGame.moveSnake(moveDirection);
        Cell newHead = snakeGame.snake.getFirst();
        assertEquals(head.getRow(), newHead.getRow());
        assertEquals(head.getCol(), newHead.getCol());
    }
}

