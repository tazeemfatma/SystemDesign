package SnakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SnakeImpl implements Snake {
    LinkedList<Cell> snake;
    Cell foodCell;
    Cell head;
    int boardRows;
    int boardCols;
    static boolean gameOver;
   // Queue foodQ;//predefined food

    SnakeImpl(int rows, int cols, Cell init, Queue foodQueue) {
        boardRows = rows;
        boardCols = cols;
        snake = new LinkedList<>();

        //setting starting position of snake
        head = init;
        snake.add(head);

        //increasing length of snake
        snake.add(new Cell(head.getRow()-1, head.getCol()));
        snake.add(new Cell(head.getRow()-2, head.getCol()));
        //generate random
         generateFood();

        //foodCell = new Cell(1, 0);
        System.out.println(render());
        gameOver=false;

        //food defined
        //foodQ=foodQueue;
    }

    @Override
    public void moveSnake(Direction direction) {
        Cell newHead = getNextCell(direction);
        if (gameOver) {
            System.out.println("Game Over!!");
            return;
        }
        if(isValidPosition(newHead.getRow(), newHead.getCol())) {
            head = newHead;
            snake.addFirst(head);
            if (!newHead.equals(foodCell)) {
                snake.removeLast();
            } else {
                // generateFood(boardRows, boardCols);
                generateFood();
            }
        }else{
            if(snake.contains(new Cell(newHead.getRow(), newHead.getCol()))){
              //invalid move do nothing
            }else {

                gameOver = true;
            }
        }
    }

    private Cell getNextCell(Direction direction) {
        Cell nextCell;
        Cell currPos = snake.getFirst();
        int row = currPos.getRow();
        int col = currPos.getCol();
        switch (direction) {
            case UP -> {
                row--;
                break;
            }
            case DOWN -> {
                row++;
                break;
            }
            case LEFT -> {
                col--;
                break;
            }
            case RIGHT -> {
                col++;
                break;
            }
        }
        nextCell = new Cell(row, col);
        return nextCell;
    }
    private boolean isValidPosition(int rowNo, int colNo) {
        return (rowNo >= 0 && rowNo < boardRows) && (colNo >= 0 && colNo < boardCols)
                && (!snake.contains(new Cell(rowNo, colNo)) || (snake.getLast().getRow()==rowNo && snake.getLast().getCol()==colNo));
    }

    @Override
    public boolean isGameOver(Cell nextCell) {
        if (nextCell.getRow() < 0 || nextCell.getRow() >= boardRows || nextCell.getCol() < 0 || nextCell.getCol() >= boardCols)
            gameOver= true;
        if (nextCell != snake.getLast() && snake.contains(nextCell))
            gameOver= true;
        return gameOver;
    }

    @Override
    public String render() {
        StringBuilder board = new StringBuilder();
        for (int row = 0; row < boardRows; row++) {
            for (int col = 0; col < boardCols; col++) {
                Cell currentCell = new Cell(row, col);
                if (snake.contains(currentCell)) {
                    board.append("S");
                } else if (foodCell.equals(currentCell)) {
                    board.append("F");
                } else {
                    board.append(".");
                }
            }
            board.append(System.lineSeparator());
        }
        return board.toString();
    }

    private void generateFood() {
        Random random = new Random();
        int randomRow = random.nextInt(boardRows);
        int randomCol = random.nextInt(boardCols);
        foodCell = new Cell(randomRow, randomCol);
        while (snake.contains(foodCell)) {
            randomRow = random.nextInt(boardRows);
            randomCol = random.nextInt(boardCols);
        }
        foodCell = new Cell(randomRow, randomCol);

        //food defined
       // foodCell=(Cell) foodQ.poll();
    }
}
