package com.aor.Snake.model.game.elements;

import com.aor.Snake.model.Position;

public class SnakeBody extends Element {
    public SnakeBody(int x, int y) {super(x, y);}

    public void incrementX() {this.setPosition(new Position(this.getPosition().getX()+1, this.getPosition().getY()));}
    public void decrementX() {this.setPosition(new Position(this.getPosition().getX()-1, this.getPosition().getY()));}
    public void incrementY() {this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY()+1));}
    public void decrementY() {this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY()-1));}

}
