package structures;
import behaviours.BookBehaviour;
import java.io.Serializable;
import java.util.ArrayList;


public class Book implements BookBehaviour, Serializable {
    private ArrayList<Section> allWords = new ArrayList<Section>(){};

    public ArrayList<Section> getAllWords() {
        return allWords;
    }
    public boolean isEmpty(){
        if(allWords.size() < 1){
            return true;
        }
        return false;
    }
    public boolean remove(Section section){
        if (allWords.contains(section)){
            allWords.remove(section);
            return true;
        }
        else{
            return false;
        }
    }

    public String readAll(){
        String result = "\n\n";
        for (int i = 0; i < allWords.size(); i++){
            result += this.beRead(allWords.get(i));
        }
        return result;
    }
    
    public String beRead(Section section) {
        return section.getContent();
    }

    // truth value tells you if a new section was made
    public boolean takeInk(Section section) {
        String title;
        boolean sectionAlreadyExists = false;
        int indexOfSection = -1;
        // check if the section exists and if so note the index
        for (int i = 0; i < allWords.size(); i++){
            title = allWords.get(i).getTitle();
            if (section.getTitle().equals(title)){
                sectionAlreadyExists = true;
                indexOfSection = i;
            }
        }
        // if it exists then add to the end of it
        if (sectionAlreadyExists){
            Section sectionInOut = allWords.get(indexOfSection);
            String addition = section.getContent();
            sectionInOut.addContent(addition);
            allWords.add(indexOfSection, sectionInOut);
        }
        // otherwise create a new section
        else {
            allWords.add(section); 
        }
        return !sectionAlreadyExists;
    }
    
}
