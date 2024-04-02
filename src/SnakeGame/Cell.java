package SnakeGame;

import java.util.Objects;

public class Cell {
    private int row, col;
   // private CellType cellType;
    public Cell(int row, int col){
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;

        if(!(obj instanceof Cell))
            return false;
        Cell cell =(Cell)obj;

        return getRow()==cell.getRow() && getCol()== cell.getCol();
    }

   /* enum CellType{
        EMPTY,FOOD,SNAKE_NODE
    }*/

}
