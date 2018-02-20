import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FleschReadabilityIndex {

	public static void main(String[] args) {
		try {
			// read the file into a string
			String documentContent = new String(Files.readAllBytes(Paths.get(args[0])));
			
			// create the document
			Document doc = new Document(documentContent);
			
			// calculate readability index; cast to double components for accurate calculations
			double syllables = (double) doc.getSyllableCount();
			double wordCount = (double) doc.getWordCount();
			double sentenceCount = (double) doc.getSentenceCount();
			
			long index = Math.round(206.835 - 84.6 * (syllables/wordCount) - 1.015 * (wordCount/sentenceCount));
			
			// determine the education level
			String educationLevel;
			if(index < 0){
				educationLevel = "Law school graduate";
			}
			else if(index <= 30){
				educationLevel = "College graduate";
			}
			else if(index <= 50){
				educationLevel = "College student";
			}
			else if(index <= 60){
				educationLevel = "High school graduate";
			}
			else if(index <= 65){
				educationLevel = "9th grader";
			}
			else if(index <= 70){
				educationLevel = "8th grader";
			}
			else if(index <= 80){
				educationLevel = "7th grader";
			}
			else if(index <= 90){
				educationLevel = "6th grader";
			}
			else if(index <= 100){
				educationLevel = "5th grader";
			}
			else{
				educationLevel = "Appropriate for all ages!";
			}
			
			// print results
			System.out.println("This document has a Flesch Readability Index of " + index + 
					" which is equivalent to the level of a " + educationLevel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
