package behaviours;
import structures.Section;


public interface BookBehaviour {
    public String beRead(Section section);
    public boolean takeInk(Section section); // ignoring the Person and Pen as they are too complicated
}
