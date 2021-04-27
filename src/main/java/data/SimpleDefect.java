package data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleDefect {
  @Id
  private String name;
  private int category;
  private double position;

    public SimpleDefect(String name, int category, double position) {
        this.name = name;
        this.category = category;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public double getPosition() {
        return position;
    }
}
