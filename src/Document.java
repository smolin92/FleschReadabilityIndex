public class Document {
	private String content;
	private String[] words;
	private String[] sentences;
	
	public Document(String input){
		content = input;
		words = content.split(" ");
		sentences = content.split("!|\\?|\\.|\\:|;");
	}
	
	/* Count the words in the document:
	 * split at whitespace then count entries in array
	 */
	public int getWordCount(){
		int numWords = words.length;
		return(numWords);
	}
	
	/* Count all the sentences
	 * split at any of the designated delimiters (!,?,:,;,.)
	 * then count array entries
	 */
	public int getSentenceCount(){
		int numSentences = sentences.length;
		return(numSentences);
	}
	
	// Count all the syllables of all the words
	public int getSyllableCount(){
		int count = 0;
		for(int i = 0; i < words.length; i++){
			Word w = new Word(words[i]);
			count += w.countSyllables();
		}
		return(count);
	}

}
