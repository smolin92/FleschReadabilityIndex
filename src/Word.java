public class Word {
	private int syllables;
	private String text;
	private final static char VOWELS[] = {'a', 'e', 'i', 'o', 'u'};
	
	public Word(String s){
		text = s;
		syllables = 0;
	}
	
	/* Count all the syllables of the word: 
	 * adjacent vowels count as 1, 
	 * non-adjacent = 2, 
	 * e at end is 0, 
	 * min = 1
	 */
	
	public int countSyllables(){
		if(text.length() == 1){
			syllables = 1;
		}
		else{
			for(int i = 1; i < this.text.length(); i++){
				char letter1 = text.charAt(i);
				// check if letter at i - 1 is a vowel
				if(new String(Word.VOWELS).contains(Character.toString(letter1))){
					char letter2 = text.charAt(i - 1);
					// if is is, check if letter at i is
					if(new String(Word.VOWELS).contains(Character.toString(letter2))){
						// means 2 adjacent vowels so increment by 1
						this.syllables += 1;
					}
					else{
						// if letter 2 is the end of the word, "e" counts as 0
						if(letter2 == 'e' && text.lastIndexOf('e') == i && i == text.length() - 1){
							this.syllables += 0;
						}
						// this means a non-adjacent vowel so increment by 2 (1 for each)
						else{
							if(i - 2 >= 0){
								char letter3 = text.charAt(i - 2);
								if(new String(Word.VOWELS).contains(Character.toString(letter3))){
									// means 2 non-adjacent vowels so increment by 1
									this.syllables += 1;
								}
							}
						}
					}
				}
			}
		}
		
		// make sure to return syllables of 1 if left with 0 after the above
		if(syllables == 0){
			syllables = 1;
		}
		
		return(syllables);
	}
	
}
