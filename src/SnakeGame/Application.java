package SnakeGame;

import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args){
        int boardRows=5;
        int boardCols=5;
       // Board board=new Board(boardRows,boardCols);
        Queue<Cell> foodQueue=new LinkedList<>();
        foodQueue.add(new Cell(1, 0));
        foodQueue.add(new Cell(0, 0));
        Cell snakeHead=new Cell(boardRows / 2, boardCols / 2);
       // Food.generateFood(boardRows,boardCols);
        Snake snake=new SnakeImpl(boardRows,boardCols,snakeHead,foodQueue);//do not include food q
    //  System.out.println(snake.render());
       // snake.moveSnake(Direction.RIGHT);
    //    snake.moveSnake(Direction.DOWN);
        snake.moveSnake(Direction.LEFT);
        System.out.println(snake.render());
        snake.moveSnake(Direction.LEFT);
        System.out.println(snake.render());
       snake.moveSnake(Direction.UP);
        System.out.println(snake.render());
        snake.moveSnake(Direction.DOWN);
        System.out.println(snake.render());
        snake.moveSnake(Direction.RIGHT);
        System.out.println(snake.render());
        snake.moveSnake(Direction.DOWN);

        // Render the game board
        System.out.println(snake.render());
        snake.moveSnake(Direction.RIGHT);

        // Render the game board
        System.out.println(snake.render());


    }
}
