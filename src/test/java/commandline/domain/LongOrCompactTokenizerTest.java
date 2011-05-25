package commandline.domain;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;


import commandline.util.ArrayIterator;
import commandline.util.PeekIterator;

public class LongOrCompactTokenizerTest {
	
	@Test
	public void simpleArgumentSplit() {
		String[] args = new String[]{"-abcf","hello.txt"};
		PeekIterator<String> peekIterator = new PeekIterator<String>(new ArrayIterator<String>(args));
		LongOrCompactTokenizer tokenizer = new LongOrCompactTokenizer(peekIterator);
		assertThat(tokenizer.next().getValue(),is("a"));
		assertThat(tokenizer.next().getValue(),is("b"));
		assertThat(tokenizer.next().getValue(),is("c"));
		assertThat(tokenizer.next().getValue(),is("f"));
		assertThat(tokenizer.next().getValue(),is("hello.txt"));
	}
}