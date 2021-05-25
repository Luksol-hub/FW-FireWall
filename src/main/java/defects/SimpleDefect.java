package defects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // persistence object (saved DB)
@Table (name ="simple_defects") //Name of table
public class SimpleDefect {
  @Id // primary key
  @GeneratedValue
  private int id;
  private String name;
  private int category;
  private double position;
  private String descr;

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
